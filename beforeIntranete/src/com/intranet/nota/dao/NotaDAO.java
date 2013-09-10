package com.intranet.nota.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.intranet.bean.Curso;
import com.intranet.bean.Detalle_cursoSeccion;
import com.intranet.bean.Detalle_tiponotacurso;
import com.intranet.bean.Inscripcion;
import com.intranet.bean.Nota;
import com.intranet.bean.Usuario;
import com.intranet.ibatis.MyIbatisManager;
import com.intranet.nota.bean.AlumnosNotaConNombre;
import com.intranet.nota.bean.NotaConNombre;
import com.intranet.nota.bean.NotaWithPorcentaje;

public class NotaDAO implements NotaDAO_I {

	@SuppressWarnings("unchecked")
	@Override
	public List<NotaConNombre> obtenerNotasDetalladas(Usuario usi,int idCurso) {
		SqlSession sesion=MyIbatisManager.getSqlSessionFactory().openSession(true);
		Map<String,Object> meterMap=new HashMap<String,Object>();
		Integer idUsui=(Integer)usi.getIdUsuario();
		Integer idCurso2=(Integer)idCurso;
		meterMap.put("idUsi", idUsui);
		meterMap.put("idCursi", idCurso2);
		List<NotaConNombre> listaNota=sesion.selectList("buscarNotas",meterMap);
		sesion.close();
		return listaNota;
	}

	//del profe
	@SuppressWarnings("unchecked")
	@Override
	public List<Detalle_tiponotacurso> obtenerTiposDeNotas(Detalle_cursoSeccion dccurso) {
		SqlSession sesion=MyIbatisManager.getSqlSessionFactory().openSession(true);
		List<Detalle_tiponotacurso> auxtn=sesion.selectList("ib_buscarTipoNotas",dccurso);
		sesion.close();
		return auxtn;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<AlumnosNotaConNombre> obtenerAlumnosParaNota(
			Detalle_cursoSeccion dcs) {
		SqlSession sesion=MyIbatisManager.getSqlSessionFactory().openSession(true);
		List<AlumnosNotaConNombre> auxancn=sesion.selectList("ib_buscarAlumnosNotaConNombre",dcs);
		sesion.close();
		return auxancn;
	}

	
	@Override
	public int sdaoGenerarNota(Nota inota) {
		int exito=-1;
		SqlSession sesion=MyIbatisManager.getSqlSessionFactory().openSession(true);
		exito=sesion.insert("ib_generarNota",inota);
		sesion.close();
		return exito;
	}

	@Override
	public int sdaoModificarNota(Nota inota) {
		int exito=-1;
		SqlSession sesion=MyIbatisManager.getSqlSessionFactory().openSession(true);
		exito=sesion.insert("ib_modificarNota",inota);
		sesion.close();
		return exito;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<NotaWithPorcentaje> obtenerNotasDelCursoAlumno(Inscripcion inscripcion,Detalle_cursoSeccion curso) {
		SqlSession sesion=MyIbatisManager.getSqlSessionFactory().openSession(true);
		Map<String,Object> auxMap=new HashMap<String, Object>();
		auxMap.put("vi_idInscri", inscripcion.getIdInscripcion());
		auxMap.put("vi_idCursi", curso.getIdCursoSeccion());
		List<NotaWithPorcentaje> valorListaReturn=sesion.selectList("ib_buscarNotasDelAlumno",auxMap);
		sesion.close();
		return valorListaReturn;
	}

	@Override
	public int rdIngresarPromedioDelCursoDelSemestre(Inscripcion inscri,Detalle_cursoSeccion dcs,String nota) {
		int exito=-1;
		Map<String,Object> auxMap=new HashMap<String,Object>();
		auxMap.put("vi_idInscri", inscri.getIdInscripcion());
		auxMap.put("vi_id", dcs.getIdCursoSeccion());
		auxMap.put("vi_nota", nota);
		SqlSession sesion=MyIbatisManager.getSqlSessionFactory().openSession(true);
		exito=sesion.insert("ib_generarPromedioDelCursos",auxMap);
		sesion.close();
		return exito;
	}

	@Override
	public int rdIngresarPromedioGnralDelSemestre(Inscripcion inscri,String gnotal) {
		int exito=-1;
		Map<String,Object> auxMap=new HashMap<String,Object>();
		auxMap.put("vi_idInscri2", inscri.getIdInscripcion());
		auxMap.put("vi_gnotal", gnotal);
		SqlSession sesion=MyIbatisManager.getSqlSessionFactory().openSession(true);
		exito=sesion.insert("ib_generarPromedioGnral",auxMap);
		sesion.close();
		return exito;
	}

}
