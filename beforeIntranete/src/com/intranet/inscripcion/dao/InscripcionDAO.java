package com.intranet.inscripcion.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.intranet.bean.CursoDTO;
import com.intranet.bean.UsuarioDTO;
import com.intranet.util.HbnConexion;

public class InscripcionDAO {
	
	@SuppressWarnings("unchecked")
	public List<CursoDTO> getCursosJalados(UsuarioDTO usuario){
		Session s=HbnConexion.getSessionFactory().getCurrentSession();
		s.beginTransaction();
		//Subquery separado
		int qUltInscripcion=ultimaInscripcion(s,usuario);
		//Query Principal
		Query q=s.createQuery("SELECT cu FROM UsuarioDTO u JOIN u.alumnoDTOs a " +
				"JOIN a.inscripcionAlumnoDTOs i JOIN i.detalleInscriCursoDTOs dic " +
				"JOIN dic.cursoCompuestoDTO cc JOIN cc.cursoDTO cu " +
				"WHERE dic.promedioC<12.5 AND u.user=:usuario " +
				"AND i.idInscripcionAlumno=:qUltimaInscripcion");
		q.setParameter("usuario", usuario.getUser());
		q.setParameter("qUltimaInscripcion", qUltInscripcion);
		
		List<CursoDTO> cursos=(List<CursoDTO>)q.list();
		s.getTransaction().commit();
		return cursos;
	}

	@SuppressWarnings("unchecked")
	public List<CursoDTO> getCursosRestantes(UsuarioDTO usuario){
		Session s=HbnConexion.getSessionFactory().getCurrentSession();
		s.beginTransaction();
		//Subquery separado
		int qUltInscripcion=ultimaInscripcion(s,usuario);
		//Query Principal
		Query q=s.createQuery("SELECT cu FROM UsuarioDTO u JOIN u.alumnoDTOs a " +
							"JOIN a.inscripcionAlumnoDTOs i JOIN a.carreraDTO c " +
							"JOIN c.detalleCursoCarreraCicloDTOs dcc JOIN dcc.cursoDTO cu " +
							"WHERE cu.idCurso NOT IN (SELECT xcc.cursoDTO.idCurso FROM InscripcionAlumnoDTO xi " +
								"JOIN xi.detalleInscriCursoDTOs xdic JOIN xdic.cursoCompuestoDTO xcc JOIN xcc.cursoDTO xcu JOIN xcu.detalleCursoCarreraCicloDTOs xdcc " +
								"WHERE xi.idInscripcionAlumno=:qidInscripcion-1 and xdcc.carreraDTO.idCarrera=c.idCarrera and xdcc.cicloDTO.idCiclo=i.cicloDTO.idCiclo-1)" +  
							"AND cu.categoriaCursoDTO.idCategoriaCurso NOT IN (SELECT xcu.categoriaCursoDTO.idCategoriaCurso " +
								"FROM InscripcionAlumnoDTO xi JOIN xi.detalleInscriCursoDTOs dic JOIN dic.cursoCompuestoDTO xcc JOIN xcc.cursoDTO xcu " +
								"WHERE xi.idInscripcionAlumno=:qidInscripcion and dic.promedioC<12.5 and xi.cicloDTO.idCiclo=i.cicloDTO.idCiclo)" +
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
		
		List<CursoDTO> cursos=(List<CursoDTO>)q.list();
		s.getTransaction().commit();
		return cursos;
	}
	@SuppressWarnings("unchecked")
	public List<CursoDTO> getCursosSiguientes(UsuarioDTO usuario){
		Session s=HbnConexion.getSessionFactory().getCurrentSession();
		s.beginTransaction();
		//Subquery separado
		int qUltInscripcion=ultimaInscripcion(s,usuario);
		//Query Principal
		Query q=s.createQuery("SELECT cu FROM UsuarioDTO u JOIN u.alumnoDTOs a " +
				"JOIN a.inscripcionAlumnoDTOs i JOIN a.carreraDTO c " +
				"JOIN c.detalleCursoCarreraCicloDTOs dcc JOIN dcc.cursoDTO cu " +
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
		
		List<CursoDTO> cursos=(List<CursoDTO>)q.list();
		s.getTransaction().commit();
		return cursos;
	}

	public int getCantidadDeCursosRestantes4Parameter(UsuarioDTO usuario){
		int result=0;
		Session s=HbnConexion.getSessionFactory().getCurrentSession();
		s.beginTransaction();
		//Subquery separado
		int qUltInscripcion=ultimaInscripcion(s,usuario);
		//Query Principal
		Query q=s.createQuery("SELECT count(*) FROM UsuarioDTO u JOIN u.alumnoDTOs a " +
				"JOIN a.inscripcionAlumnoDTOs i JOIN a.carreraDTO c " +
				"JOIN c.detalleCursoCarreraCicloDTOs dcc JOIN dcc.cursoDTO cu " +
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
		int qUltInscripcion=ultimaInscripcion(s,usuario);
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
	
	private int ultimaInscripcion(Session s, UsuarioDTO usuario){
		
		int result=0;
		Query qUltimaInscripcion=s.createQuery("Select xi.idInscripcionAlumno " +
				"FROM InscripcionAlumnoDTO xi JOIN xi.alumnoDTO a JOIN a.usuarioDTO u " +
				"WHERE u.user=:usuario ORDER BY xi.idInscripcionAlumno desc");
		qUltimaInscripcion.setParameter("usuario", usuario.getUser());
		qUltimaInscripcion.setMaxResults(1);
		result=(int)qUltimaInscripcion.uniqueResult();
		return result;
	}

}
