package com.intranet.inscripcion.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.intranet.bean.Curso;
import com.intranet.bean.Inscripcion;
import com.intranet.bean.Usuario;
import com.intranet.ibatis.MyIbatisManager;
import com.intranet.inscripcion.bean.DatosReqInscripcionDTO;

public class InscripcionDAO implements InscripcionDAO_I {

	@SuppressWarnings("unchecked")
	@Override
	public List<Curso> obtenerCursosAnteriores(Usuario usi) {
		SqlSession sesion=MyIbatisManager.getSqlSessionFactory().openSession(true);
		List<Curso> listacursosant=sesion.selectList("buscarCursosAnteriores",usi);
		sesion.close();
		return listacursosant;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Curso> obtenerCursosActuales(Usuario usi) {
		SqlSession sesion=MyIbatisManager.getSqlSessionFactory().openSession(true);
		List<Curso> listacursosact=sesion.selectList("buscarCursosActuales",usi);
		sesion.close();
		return listacursosact;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Curso> obtenerCursosFuturos(Usuario usi) {
		SqlSession sesion=MyIbatisManager.getSqlSessionFactory().openSession(true);
		List<Curso> listacursosfut=sesion.selectList("buscarCursosFuturos",usi);
		sesion.close();
		return listacursosfut;
	}

	@Override
	public Curso obtenerCursoBean(Curso cursi) {
		SqlSession sesion=MyIbatisManager.getSqlSessionFactory().openSession(true);
		Curso cursod=(Curso) sesion.selectOne("buscarCursoBean",cursi);
		sesion.close();
		return cursod;
	}

	@Override
	public int obtenerDatosPreInscripcion(Usuario usi) {
		SqlSession sesion=MyIbatisManager.getSqlSessionFactory().openSession(true);
		int datosreqinscripcion=(int) sesion.selectOne("buscarCantCursosDelSigCiclo",usi);
		sesion.close();
		return datosreqinscripcion;
		
	}
	
	@Override
	public double obtenerPromAntCiclo(Usuario usi) {
		SqlSession sesion=MyIbatisManager.getSqlSessionFactory().openSession(true);
		double datosreqinscripcion=(double) sesion.selectOne("buscarPromAntCiclo",usi);
		sesion.close();
		return datosreqinscripcion;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Curso> obtenerCursosAnteriores2(Usuario usi) {
		SqlSession sesion=MyIbatisManager.getSqlSessionFactory().openSession(true);
		List<Curso> listacursosant=sesion.selectList("buscarCursosAnteriores2",usi);
		sesion.close();
		return listacursosant;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Curso> obtenerCursosActuales2(Usuario usi) {
		SqlSession sesion=MyIbatisManager.getSqlSessionFactory().openSession(true);
		List<Curso> listacursosact=sesion.selectList("buscarCursosActuales2",usi);
		sesion.close();
		return listacursosact;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Inscripcion> obtenerInscripcionesDelSemestre() {
		SqlSession sesion=MyIbatisManager.getSqlSessionFactory().openSession(true);
		List<Inscripcion> listaObtenerInscripciondelSemestreReturn=sesion.selectList("ib_buscarInscripcionesGlobal");
		sesion.close();
		return listaObtenerInscripciondelSemestreReturn;
	}

}
