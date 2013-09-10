<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Agregar Asistencia del alumno</title>
</head>
<body>
	<s:form action="cargarParamAgregarAsistencia">
		<s:select list="listaSeccionesXprofesor" name="valora.idCursoSeccion"
			listValue="descCurso" listKey="idCursoSeccion" />
		<s:submit value="Listar Alumnos" />
	</s:form>
	<s:form action="agregarAsistencia">
		<s:checkboxlist list="listaAlumnoProdAsist"
			name="listaVacia.idInscripcion" listValue="nompersona"
			listKey="idInscripcion" />
		<s:submit value="Aceptar" />
	</s:form>


</body>
</html>