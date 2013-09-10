package com.intranet.nota.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.intranet.bean.Curso;
import com.intranet.bean.Detalle_cursoSeccion;
import com.intranet.bean.Inscripcion;
import com.intranet.bean.Usuario;
import com.intranet.ibatis.MyIbatisManager;

public class CursoDAO implements CursoDAO_I {

	@SuppressWarnings("unchecked")
	@Override
	public List<Curso> obtenerCursos(Usuario usi) {
		SqlSession sesion=MyIbatisManager.getSqlSessionFactory().openSession(true);
		List<Curso> cursoLista=sesion.selectList("buscarCursos",usi);
		sesion.close();
		return cursoLista;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Detalle_cursoSeccion> obtenerCursosDelAlumno(Inscripcion inscripcion) {
		SqlSession sesion=MyIbatisManager.getSqlSessionFactory().openSession(true);
		List<Detalle_cursoSeccion> valorListReturn=sesion.selectList("ib_CursoDelAlumnoDelSemestre",inscripcion);
		sesion.close();
		return valorListReturn;
	}

	@Override
	public int obtenerCantidadDeCursosDelSemestre(Inscripcion inscripcion) {
		SqlSession sesion=MyIbatisManager.getSqlSessionFactory().openSession(true);
		int valorOneReturn=(int)sesion.selectOne("ib_buscarCantidadDeCursosDelAlumno",inscripcion);
		sesion.close();
		return valorOneReturn;
	}

	

}
