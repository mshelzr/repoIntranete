package com.intranet.asistencia.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.intranet.asistencia.bean.AlumnoPropAsistencia;
import com.intranet.asistencia.bean.AsistenciaResumen;
import com.intranet.asistencia.bean.CursoSeccionConNombre;
import com.intranet.bean.Asistencia;
import com.intranet.bean.Detalle_cursoSeccion;
import com.intranet.bean.Usuario;
import com.intranet.ibatis.MyIbatisManager;

public class AsistenciaDAO implements AsistenciaDAO_I{

	@SuppressWarnings("unchecked")
	@Override
	public List<AsistenciaResumen> listaCursosResumen(Usuario usi) {
		
		SqlSession sesion=MyIbatisManager.getSqlSessionFactory().openSession(true);
		List<AsistenciaResumen> listaAsistResumen=(List<AsistenciaResumen>)sesion.selectList("buscarAsistenciaResumen", usi);
		sesion.close();
		
		return listaAsistResumen;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Asistencia> obtenerAsistenciasDetalladas(Usuario usi, String idCurso) {
		
		SqlSession sesion=MyIbatisManager.getSqlSessionFactory().openSession(true);
		Map<String,Object> mapDato=new HashMap<String,Object>();
		Integer usito=(Integer)usi.getIdUsuario();
		mapDato.put("idUsi", usito);
		mapDato.put("idCursi",idCurso);
		List<Asistencia> listaAsistencias=sesion.selectList("buscarAsistenciaDetallada", mapDato);;
		sesion.close();
		return listaAsistencias;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CursoSeccionConNombre> obtenerSeccionXProfesor(Usuario usi) {
		SqlSession sesion=MyIbatisManager.getSqlSessionFactory().openSession(true);
		List<CursoSeccionConNombre> listaSeccionesXprofesor=(List<CursoSeccionConNombre>)sesion.selectList("buscarSeccionesxProfesor", usi);
		sesion.close();
		return listaSeccionesXprofesor;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AlumnoPropAsistencia> obtenerAlumnowpAsistencia(Detalle_cursoSeccion secc) {
		SqlSession sesion=MyIbatisManager.getSqlSessionFactory().openSession(true);
		List<AlumnoPropAsistencia> listaAlumnosDeSeccion=(List<AlumnoPropAsistencia>)sesion.selectList("buscarAlumnosDeSeccion", secc);
		sesion.close();
		return listaAlumnosDeSeccion;
	}

	@Override
	public int resultadoRegistroAsistencia(Asistencia asist) {
		int verificador=-1;
		SqlSession sesion=MyIbatisManager.getSqlSessionFactory().openSession(true);
		verificador=sesion.insert("ib_registrarAsistencia", asist);
		sesion.close();
		
		return verificador;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> obtenerFechaSeccionXProfesor(Detalle_cursoSeccion dcs) {
		SqlSession sesion=MyIbatisManager.getSqlSessionFactory().openSession(true);
		List<String> auxListaFechasSecc=(List<String>)sesion.selectList("ib_buscarFechasParamXProfesor", dcs);
		sesion.close();
		return auxListaFechasSecc;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AlumnoPropAsistencia> obtenerAlumnosConParametros(String fecha,
			Detalle_cursoSeccion dcs) {
		Map<String,Object> auxMap=new HashMap<String, Object>();
		auxMap.put("va_fecha", fecha);
		Integer vsc=(Integer)dcs.getIdCursoSeccion();
		auxMap.put("va_idsc", vsc);
		SqlSession sesion=MyIbatisManager.getSqlSessionFactory().openSession(true);
		List<AlumnoPropAsistencia> auxListaAlumnosSeccion=(List<AlumnoPropAsistencia>)sesion.selectList("ib_buscarAlumnosDeSeccion2", auxMap);
		sesion.close();
		return auxListaAlumnosSeccion;
	}

	@Override
	public int resultadoModifcarAsistencia(Asistencia asist) {
		int verificador=-1;
		SqlSession sesion=MyIbatisManager.getSqlSessionFactory().openSession(true);
		verificador=sesion.insert("ib_modificarAsistencia", asist);
		sesion.close();
		
		return verificador;
	}


}
