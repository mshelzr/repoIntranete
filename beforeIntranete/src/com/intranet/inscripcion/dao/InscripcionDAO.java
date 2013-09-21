package com.intranet.inscripcion.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.intranet.bean.CursoCompuestoDTO;
import com.intranet.bean.DetalleInscriCursoDTO;
import com.intranet.bean.HorarioDTO;
import com.intranet.bean.UsuarioDTO;
import com.intranet.util.HbnConexion;

public class InscripcionDAO {
	
	@SuppressWarnings("unchecked")
	public List<CursoCompuestoDTO> getCursosJalados(UsuarioDTO usuario){
		Session s=HbnConexion.getSessionFactory().getCurrentSession();
		s.beginTransaction();
		//Subquery separado
		int qUltInscripcion=inscripcionDelCicloAnterior(s,usuario);
		//Query Principal
		Query q=s.createQuery("SELECT cc FROM UsuarioDTO u JOIN u.alumnoDTOs a " +
				"JOIN a.inscripcionAlumnoDTOs i JOIN i.detalleInscriCursoDTOs dic " +
				"JOIN dic.cursoCompuestoDTO cc JOIN cc.cursoDTO cu " +
				"WHERE dic.promedioC<12.5 AND u.user=:usuario " +
				"AND i.idInscripcionAlumno=:qUltimaInscripcion");
		q.setParameter("usuario", usuario.getUser());
		q.setParameter("qUltimaInscripcion", qUltInscripcion);
		
		List<CursoCompuestoDTO> cursos=(List<CursoCompuestoDTO>)q.list();
		s.getTransaction().commit();
		return cursos;
	}

	@SuppressWarnings("unchecked")
	public List<CursoCompuestoDTO> getCursosRestantes(UsuarioDTO usuario){
		Session s=HbnConexion.getSessionFactory().getCurrentSession();
		s.beginTransaction();
		//Subquery separado
		int qUltInscripcion=inscripcionDelCicloAnterior(s,usuario);
		//Query Principal
		Query q=s.createQuery("SELECT cc FROM UsuarioDTO u JOIN u.alumnoDTOs a " +
							"JOIN a.inscripcionAlumnoDTOs i JOIN a.carreraDTO c " +
							"JOIN c.detalleCursoCarreraCicloDTOs dcc JOIN dcc.cursoDTO cu JOIN cu.cursoCompuestoDTOs cc " +
							"WHERE cu.idCurso NOT IN (SELECT xcc.cursoDTO.idCurso FROM InscripcionAlumnoDTO xi " +
								"JOIN xi.detalleInscriCursoDTOs xdic JOIN xdic.cursoCompuestoDTO xcc JOIN xcc.cursoDTO xcu JOIN xcu.detalleCursoCarreraCicloDTOs xdcc " +
								"WHERE xi.idInscripcionAlumno=:qidInscripcion-1 and xdcc.carreraDTO.idCarrera=c.idCarrera and xdcc.cicloDTO.idCiclo=i.cicloDTO.idCiclo-1) " +  
							"AND cu.categoriaCursoDTO.idCategoriaCurso NOT IN (SELECT xcu.categoriaCursoDTO.idCategoriaCurso " +
								"FROM InscripcionAlumnoDTO xi JOIN xi.detalleInscriCursoDTOs dic JOIN dic.cursoCompuestoDTO xcc JOIN xcc.cursoDTO xcu " +
								"WHERE xi.idInscripcionAlumno=:qidInscripcion and dic.promedioC<12.5 and xi.cicloDTO.idCiclo=i.cicloDTO.idCiclo) " +
							"AND cu.idCurso NOT IN (SELECT xcc.cursoDTO.idCurso " +
								"FROM InscripcionAlumnoDTO xi JOIN xi.detalleInscriCursoDTOs xdic JOIN xdic.cursoCompuestoDTO xcc " +
								"WHERE xi.idInscripcionAlumno=:qidInscripcion and xi.cicloDTO.idCiclo=i.cicloDTO.idCiclo) " +
							"AND cu.idCurso NOT IN (SELECT xcu.idCurso " +
								"FROM DetalleCursoCarreraCicloDTO xdcc JOIN xdcc.cursoDTO xcu " +
								"WHERE xcu.categoriaCursoDTO.idCategoriaCurso not in (SELECT xcu.categoriaCursoDTO.idCategoriaCurso FROM InscripcionAlumnoDTO xi " +
									"JOIN xi.detalleInscriCursoDTOs xdic JOIN xdic.cursoCompuestoDTO xcc JOIN xcc.cursoDTO xcu JOIN xcu.detalleCursoCarreraCicloDTOs xdcc " +
									"WHERE xi.idInscripcionAlumno BETWEEN :qidInscripcion-1 AND :qidInscripcion and xdcc.carreraDTO.idCarrera=c.idCarrera and xdcc.cicloDTO.idCiclo=i.cicloDTO.idCiclo-1) " + 
								"AND xdcc.cicloDTO.idCiclo=i.cicloDTO.idCiclo) " +
							"AND dcc.cicloDTO.idCiclo BETWEEN i.cicloDTO.idCiclo-1 AND i.cicloDTO.idCiclo AND u.user=:usuario " +
							"AND i.idInscripcionAlumno=:qidInscripcion " +
							"group by cu.idCurso");
		q.setParameter("usuario", usuario.getUser());
		q.setParameter("qidInscripcion", qUltInscripcion);
		
		List<CursoCompuestoDTO> cursos=(List<CursoCompuestoDTO>)q.list();
		s.getTransaction().commit();
		return cursos;
	}
	@SuppressWarnings("unchecked")
	public List<CursoCompuestoDTO> getCursosSiguientes(UsuarioDTO usuario){
		Session s=HbnConexion.getSessionFactory().getCurrentSession();
		s.beginTransaction();
		//Subquery separado
		int qUltInscripcion=inscripcionDelCicloAnterior(s,usuario);
		//Query Principal
		Query q=s.createQuery("SELECT cc FROM UsuarioDTO u JOIN u.alumnoDTOs a " +
				"JOIN a.inscripcionAlumnoDTOs i JOIN a.carreraDTO c " +
				"JOIN c.detalleCursoCarreraCicloDTOs dcc JOIN dcc.cursoDTO cu JOIN cu.cursoCompuestoDTOs cc " +
				"WHERE cu.categoriaCursoDTO.idCategoriaCurso NOT IN (SELECT xcu.categoriaCursoDTO.idCategoriaCurso " +
					"FROM DetalleInscriCursoDTO dic JOIN dic.cursoCompuestoDTO cc JOIN cc.cursoDTO xcu " +
					"WHERE dic.inscripcionAlumnoDTO.idInscripcionAlumno=i.idInscripcionAlumno AND dic.promedioC<12.5) " +
				"AND cu.categoriaCursoDTO.idCategoriaCurso NOT IN (SELECT xxcu.categoriaCursoDTO.idCategoriaCurso " +
					"FROM DetalleCursoCarreraCicloDTO xxdcc JOIN xxdcc.cursoDTO xxcu " +
					"WHERE xxcu.idCurso NOT IN (SELECT xcc.cursoDTO.idCurso " +
						"FROM DetalleInscriCursoDTO xdic JOIN xdic.cursoCompuestoDTO xcc " +
						"WHERE xdic.inscripcionAlumnoDTO.idInscripcionAlumno=i.idInscripcionAlumno) " +
					"AND xxdcc.cicloDTO.idCiclo=i.cicloDTO.idCiclo AND xxdcc.carreraDTO.idCarrera=c.idCarrera) " +
				"AND dcc.cicloDTO.idCiclo=(i.cicloDTO.idCiclo+1) AND u.user=:usuario " +
				"AND i.idInscripcionAlumno=:qUltimaInscripcion");
		q.setParameter("usuario", usuario.getUser());
		q.setParameter("qUltimaInscripcion", qUltInscripcion);
		
		List<CursoCompuestoDTO> cursos=(List<CursoCompuestoDTO>)q.list();
		s.getTransaction().commit();
		return cursos;
	}

	public int getCantidadDeCursosRestantes4Parameter(UsuarioDTO usuario){
		int result=0;
		Session s=HbnConexion.getSessionFactory().getCurrentSession();
		s.beginTransaction();
		//Subquery separado
		int qUltInscripcion=inscripcionDelCicloAnterior(s,usuario);
		//Query Principal
		Query q=s.createQuery("SELECT count(*) FROM UsuarioDTO u JOIN u.alumnoDTOs a " +
				"JOIN a.inscripcionAlumnoDTOs i JOIN a.carreraDTO c " +
				"JOIN c.detalleCursoCarreraCicloDTOs dcc JOIN dcc.cursoDTO cu JOIN cu.cursoCompuestoDTOs cc " +
				"WHERE cu.idCurso NOT IN (SELECT xcc.cursoDTO.idCurso " +
					"FROM DetalleInscriCursoDTO xdic JOIN xdic.cursoCompuestoDTO xcc " +
					"WHERE xdic.inscripcionAlumnoDTO.idInscripcionAlumno=i.idInscripcionAlumno) " +
				"AND dcc.cicloDTO.idCiclo=i.cicloDTO.idCiclo AND u.user=:usuario " +
				"AND i.idInscripcionAlumno=:qUltimaInscripcion");
		q.setParameter("usuario", usuario.getUser());
		q.setParameter("qUltimaInscripcion", qUltInscripcion);
		
		result=((Long)q.uniqueResult()).intValue();
		//Valor a regresar
		s.getTransaction().commit();
		
		return result;
	}

	public int getCantidadDeCursosQuePuedeLlevar(UsuarioDTO usuario){
		int result=0;
		Session s=HbnConexion.getSessionFactory().getCurrentSession();
		s.beginTransaction();
		//Subquery separado
		int qUltInscripcion=inscripcionDelCicloAnterior(s,usuario);
		//Query Principal
		Query q=s.createQuery("Select i.aprobado " +
				"FROM InscripcionAlumnoDTO i JOIN i.alumnoDTO a JOIN a.usuarioDTO u " +
				"WHERE u.user=:usuario AND i.idInscripcionAlumno=:qUltimaInscripcion");
		q.setParameter("usuario", usuario.getUser());
		q.setParameter("qUltimaInscripcion", qUltInscripcion);
		result=(int)q.uniqueResult();
		s.getTransaction().commit();
		
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public List<CursoCompuestoDTO> getCursosRecienteMatriculado(UsuarioDTO usuario){
		Session s=HbnConexion.getSessionFactory().getCurrentSession();
		s.beginTransaction();
		//Subquery separado
		int qUltInscripcion=ultimaInscripcion(s,usuario);
		//Query Principal
		Query q=s.createQuery("SELECT cc " +
				"FROM CursoCompuestoDTO cc JOIN cc.detalleInscriCursoDTOs dic " +
				"JOIN dic.inscripcionAlumnoDTO xi JOIN xi.alumnoDTO a JOIN a.usuarioDTO u " + 
				"WHERE u.user=:usuario AND xi.idInscripcionAlumno=:nidInscripcion " +
				"ORDER BY xi.inscripcionDTO.idInscripcion desc");
		q.setParameter("usuario", usuario.getUser());
		q.setParameter("nidInscripcion", qUltInscripcion);
		
		List<CursoCompuestoDTO> cursos=(List<CursoCompuestoDTO>)q.list();
		s.getTransaction().commit();
		return cursos;
	}

	@SuppressWarnings("unchecked")
	public List<HorarioDTO> getHorarioAlumno(UsuarioDTO usuario) {
		Session s=HbnConexion.getSessionFactory().getCurrentSession();
		s.beginTransaction();
		//Subquery separado
		int qUltInscripcion=ultimaInscripcion(s,usuario);
		//Query Principal
		Query q=s.createQuery("SELECT h " +
		"FROM HorarioDTO h JOIN h.cursoCompuestoDTO cc JOIN cc.detalleInscriCursoDTOs dic JOIN dic.inscripcionAlumnoDTO xi JOIN xi.alumnoDTO a JOIN a.usuarioDTO u " + 
		"WHERE u.user=:usuario AND xi.idInscripcionAlumno=:nidInscripcion " +
		"ORDER BY xi.inscripcionDTO.idInscripcion desc");
		q.setParameter("usuario", usuario.getUser());
		q.setParameter("nidInscripcion", qUltInscripcion);
		
		List<HorarioDTO> cursos=(List<HorarioDTO>)q.list();
		s.getTransaction().commit();
		return cursos;
	}

	@SuppressWarnings("unchecked")
	public List<HorarioDTO> getHorarioPorCurso(UsuarioDTO usuario,CursoCompuestoDTO cc) {
		Session s=HbnConexion.getSessionFactory().getCurrentSession();
		s.beginTransaction();
		//Query Principal
		Query q=s.createQuery("SELECT h "+
			"FROM HorarioDTO h JOIN h.cursoCompuestoDTO cc "+
			"WHERE cc.idCursoCompuesto=:qidCursoCompuesto");
		q.setParameter("qidCursoCompuesto", cc.getIdCursoCompuesto());
		
		List<HorarioDTO> cursos=(List<HorarioDTO>)q.list();
		s.getTransaction().commit();
		return cursos;
	}
	
	public int inscripcionDelCicloAnterior(Session s, UsuarioDTO usuario){
		
		int result=0;
		Query qUltimaInscripcion=s.createQuery("Select xi.idInscripcionAlumno " +
				"FROM InscripcionDTO ig,InscripcionAlumnoDTO xi JOIN xi.alumnoDTO a JOIN a.usuarioDTO u " +
				"WHERE u.user=:usuario AND xi.inscripcionDTO.idInscripcion=ig.idInscripcion-1 " +
				"ORDER BY xi.inscripcionDTO.idInscripcion desc");
		qUltimaInscripcion.setParameter("usuario", usuario.getUser());
		qUltimaInscripcion.setMaxResults(1);
		result=(int)qUltimaInscripcion.uniqueResult();
		return result;
	}
	
	public int ultimaInscripcion(Session s, UsuarioDTO usuario){
		int esNulo=0;
		
		if(s==null){
			esNulo=1;
			s=HbnConexion.getSessionFactory().getCurrentSession();
			s.beginTransaction();
		}
		
		int result=-1;
		Query qtopPeriodo=s.createQuery("select p.idPeriodo " +
				"FROM PeriodoDTO p " +
				"ORDER BY p.idPeriodo desc"); 
		qtopPeriodo.setMaxResults(1);
		int topPeriodo=(int)qtopPeriodo.uniqueResult();
		
		Query qUltimaInscripcion=s.createQuery("select xi.idInscripcionAlumno " +
				"FROM PeriodoDTO p JOIN p.inscripcionDTOs ig JOIN ig.inscripcionAlumnoDTOs xi JOIN xi.alumnoDTO a JOIN a.usuarioDTO u " +
				"WHERE u.user=:usuario AND p.idPeriodo=:qidPeriodo " +
				"ORDER BY xi.idInscripcionAlumno desc");
		qUltimaInscripcion.setParameter("usuario", usuario.getUser()); 
		qUltimaInscripcion.setParameter("qidPeriodo",topPeriodo );
		qUltimaInscripcion.setMaxResults(1);
		
		try {
			result=(int)qUltimaInscripcion.uniqueResult();	
			if(esNulo==1){			
				s.getTransaction().commit();
			}
		} catch (NullPointerException n) {
			result=0;
		}

		return result;
	}

	@SuppressWarnings("unchecked")
	public List<CursoCompuestoDTO> getCursoCompuestoPorCurso(List<Integer> cursosJalados) {
		Session s=HbnConexion.getSessionFactory().getCurrentSession();
		s.beginTransaction();
		Query q=s.createQuery("SELECT cc FROM CursoCompuestoDTO cc JOIN cc.cursoDTO c WHERE c.idCurso IN (:ArrayidCurso)");
		q.setParameterList("ArrayidCurso", cursosJalados);
		List<CursoCompuestoDTO> innerCc=(List<CursoCompuestoDTO>)q.list();
		s.getTransaction().commit();
		return innerCc;
	}
	
	public void add(DetalleInscriCursoDTO dic){
		Session s=HbnConexion.getSessionFactory().getCurrentSession();
		s.beginTransaction();
		s.persist(dic);
		s.getTransaction().commit();
	}
	
	public void remove(DetalleInscriCursoDTO dic){
		Session s=HbnConexion.getSessionFactory().getCurrentSession();
		s.beginTransaction();
		s.delete(dic);
		s.getTransaction().commit();
	}
	
	
}
