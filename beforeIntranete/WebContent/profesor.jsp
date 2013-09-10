<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Menu Profesor</title>
</head>
<body>
	Gestion de datos del alumno
	<br>
	<s:a action="irAgregarAsistencia">Agregar Asistencia</s:a>
	<br>
	<s:a action="irModificarAsistencia">Modificar Asistencia</s:a>
	<br>
	<s:a action="cargarSeccionesDelProfesorActReg">Agregar Nota</s:a>
	<br>
	<s:a action="cargarSeccionesDelProfesorActMod">Modificar Nota</s:a>

</body>
</html>