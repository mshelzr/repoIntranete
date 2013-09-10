package com.intranet.seguridad.dao;

import com.intranet.asistencia.dao.AsistenciaDAO_I;
import com.intranet.horario.dao.HorarioDAO_I;
import com.intranet.inscripcion.dao.InscripcionDAO_I;
import com.intranet.nota.dao.CursoDAO_I;
import com.intranet.nota.dao.NotaDAO_I;

public abstract class DAOFactory {

    public static final int MYSQL = 1;
    public static final int ORACLE = 2;
    public static final int DB2 = 3;
    public static final int SQLSERVER = 4;
    public static final int XML = 5;
    public static final int IBATIS = 6;
	
	public abstract PerfilDAO_I getPerfilDAO();
	public abstract UsuarioDAO_I getUsuarioDAO();
	public abstract AsistenciaDAO_I getAsistenciaDAO();
	public abstract NotaDAO_I getNotaDAO();
	public abstract CursoDAO_I getCursoDAO();
	public abstract HorarioDAO_I getHorarioDAO();
	public abstract InscripcionDAO_I getInscripcionDAO();
	
	public static DAOFactory getDAOFactory(int valor){
		switch(valor){
		case IBATIS: return new IbatisDAOFactory();
		default: return null;
		}
	}
	
}
