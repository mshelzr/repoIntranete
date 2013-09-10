<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modificar Asistencia del Alumno</title>
</head>
<body>
	<s:form action="cargarParamModificarAsistencia">
		<s:select list="listaSeccionesXprofesor" name="valora.idCursoSeccion"
			listValue="descCurso" label="Cursos" listKey="idCursoSeccion" />
		<s:submit value="Listar Alumnos" />
	</s:form>
	<s:form action="cargarParamFechaModificarAsistencia">
		<s:select label="Fechas" list="lfechas" name="avFecha" />
		<s:submit value="Fecha" />
	</s:form>
	<s:form action="modificarAsistencia">
		<s:checkboxlist list="listaAlumnoProdAsistTwo"
			name="listaVacia.idInscripcion" listValue="nompersona"
			listKey="idInscripcion" />
		<s:submit value="Aceptar" />
	</s:form>


</body>
</html>