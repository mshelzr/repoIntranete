package com.intranet.inscripcion.dao;

import java.util.List;

import com.intranet.bean.CursoDTO;
import com.intranet.bean.InscripcionDTO;
import com.intranet.bean.UsuarioDTO;

public class InscripcionDAO {

	public List<CursoDTO> obtenerCursosAnteriores(UsuarioDTO usi) {
//		SqlSession sesion=MyIbatisManager.getSqlSessionFactory().openSession(true);
//		List<CursoDTO> listacursosant=sesion.selectList("buscarCursosAnteriores",usi);
//		sesion.close();
		return null;
	}

	public List<CursoDTO> obtenerCursosActuales(UsuarioDTO usi) {
//		SqlSession sesion=MyIbatisManager.getSqlSessionFactory().openSession(true);
//		List<CursoDTO> listacursosact=sesion.selectList("buscarCursosActuales",usi);
//		sesion.close();
		return null;
	}

	public List<CursoDTO> obtenerCursosFuturos(UsuarioDTO usi) {
//		SqlSession sesion=MyIbatisManager.getSqlSessionFactory().openSession(true);
//		List<CursoDTO> listacursosfut=sesion.selectList("buscarCursosFuturos",usi);
//		sesion.close();
		return null;
	}

	public CursoDTO obtenerCursoBean(CursoDTO cursi) {
//		SqlSession sesion=MyIbatisManager.getSqlSessionFactory().openSession(true);
//		CursoDTO cursod=(CursoDTO) sesion.selectOne("buscarCursoBean",cursi);
//		sesion.close();
		return null;
	}

	public int obtenerDatosPreInscripcion(UsuarioDTO usi) {
//		SqlSession sesion=MyIbatisManager.getSqlSessionFactory().openSession(true);
//		int datosreqinscripcion=(int) sesion.selectOne("buscarCantCursosDelSigCiclo",usi);
//		sesion.close();
		return 0;
		
	}
	
	public double obtenerPromAntCiclo(UsuarioDTO usi) {
//		SqlSession sesion=MyIbatisManager.getSqlSessionFactory().openSession(true);
//		double datosreqinscripcion=(double) sesion.selectOne("buscarPromAntCiclo",usi);
//		sesion.close();
		return 0;
	}

	public List<CursoDTO> obtenerCursosAnteriores2(UsuarioDTO usi) {
//		SqlSession sesion=MyIbatisManager.getSqlSessionFactory().openSession(true);
//		List<CursoDTO> listacursosant=sesion.selectList("buscarCursosAnteriores2",usi);
//		sesion.close();
		return null;
	}

	public List<CursoDTO> obtenerCursosActuales2(UsuarioDTO usi) {
//		SqlSession sesion=MyIbatisManager.getSqlSessionFactory().openSession(true);
//		List<CursoDTO> listacursosact=sesion.selectList("buscarCursosActuales2",usi);
//		sesion.close();
		return null;
	}

	public List<InscripcionDTO> obtenerInscripcionesDelSemestre() {
//		SqlSession sesion=MyIbatisManager.getSqlSessionFactory().openSession(true);
//		List<Inscripcion> listaObtenerInscripciondelSemestreReturn=sesion.selectList("ib_buscarInscripcionesGlobal");
//		sesion.close();
		return null;
	}

}
