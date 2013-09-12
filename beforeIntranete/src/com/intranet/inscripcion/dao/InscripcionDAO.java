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
				"JOIN a.inscripcionDTOs i JOIN i.detalleInscriCursoDTOs dic " +
				"JOIN dic.cursoCompuestoDTO cc JOIN cc.cursoDTO cu " +
				"WHERE dic.promedioC<12.5 AND u.user=:usuario " +
				"AND i.idInscripcion=:qUltimaInscripcion");
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
				"JOIN a.inscripcionDTOs i JOIN a.carreraDTO c " +
				"JOIN c.detalleCursoCarreraCicloDTOs dcc JOIN dcc.cursoDTO cu " +
				"WHERE cu.categoriaCursoDTO.idCategoriaCurso NOT IN (SELECT xcu.categoriaCursoDTO.idCategoriaCurso " +
					"FROM DetalleInscriCursoDTO dic JOIN dic.cursoCompuestoDTO cc JOIN cc.cursoDTO xcu " +
					"WHERE dic.inscripcionDTO.idInscripcion=i.idInscripcion AND dic.promedioC<12.5) " +
				"AND cu.idCurso NOT IN (SELECT xcc.cursoDTO.idCurso " +
					"FROM DetalleInscriCursoDTO xdic JOIN xdic.cursoCompuestoDTO xcc " +
					"WHERE xdic.inscripcionDTO.idInscripcion=i.idInscripcion) " +
				"AND dcc.cicloDTO.idCiclo=i.cicloDTO.idCiclo AND u.user=:usuario " +
				"AND i.idInscripcion=:qUltimaInscripcion");
		q.setParameter("usuario", usuario.getUser());
		q.setParameter("qUltimaInscripcion", qUltInscripcion);
		
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
				"JOIN a.inscripcionDTOs i JOIN a.carreraDTO c " +
				"JOIN c.detalleCursoCarreraCicloDTOs dcc JOIN dcc.cursoDTO cu " +
				"WHERE cu.categoriaCursoDTO.idCategoriaCurso NOT IN (SELECT xcu.categoriaCursoDTO.idCategoriaCurso " +
					"FROM DetalleInscriCursoDTO dic JOIN dic.cursoCompuestoDTO cc JOIN cc.cursoDTO xcu " +
					"WHERE dic.inscripcionDTO.idInscripcion=i.idInscripcion AND dic.promedioC<12.5) " +
				"AND dcc.cicloDTO.idCiclo=(i.cicloDTO.idCiclo+1) AND u.user=:usuario " +
				"AND i.idInscripcion=:qUltimaInscripcion");
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
				"JOIN a.inscripcionDTOs i JOIN a.carreraDTO c " +
				"JOIN c.detalleCursoCarreraCicloDTOs dcc JOIN dcc.cursoDTO cu " +
				"WHERE cu.idCurso NOT IN (SELECT xcc.cursoDTO.idCurso " +
					"FROM DetalleInscriCursoDTO xdic JOIN xdic.cursoCompuestoDTO xcc " +
					"WHERE xdic.inscripcionDTO.idInscripcion=i.idInscripcion) " +
				"AND dcc.cicloDTO.idCiclo=i.cicloDTO.idCiclo AND u.user=:usuario " +
				"AND i.idInscripcion=:qUltimaInscripcion");
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
				"FROM InscripcionDTO i JOIN i.alumnoDTO a JOIN a.usuarioDTO u " +
				"WHERE u.user=:usuario AND i.idInscripcion=:qUltimaInscripcion");
		q.setParameter("usuario", usuario.getUser());
		q.setParameter("qUltimaInscripcion", qUltInscripcion);
		result=(int)q.uniqueResult();
		s.getTransaction().commit();
		
		return result;
	}
	
	private int ultimaInscripcion(Session s, UsuarioDTO usuario){
		
		int result=0;
		Query qUltimaInscripcion=s.createQuery("Select xi.idInscripcion " +
				"FROM InscripcionDTO xi JOIN xi.alumnoDTO a JOIN a.usuarioDTO u " +
				"WHERE u.user=:usuario ORDER BY xi.idInscripcion desc");
		qUltimaInscripcion.setParameter("usuario", usuario.getUser());
		qUltimaInscripcion.setMaxResults(1);
		result=(int)qUltimaInscripcion.uniqueResult();
		return result;
	}

}
