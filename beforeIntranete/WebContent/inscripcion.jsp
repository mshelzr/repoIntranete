<?xml version="1.0" encoding="UTF-8"?>
<%@page pageEncoding="ISO-8859-1" contentType="text/html;charset=UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inscripcion</title>
</head>
<body>

	<s:actionerror />
	<s:form action="cargarCursosInscripcion">
		<s:checkboxlist list="listaCursosAnteriores"
			name="listaVaciaA.idCurso" listKey="idCurso" listValue="descCurso" />
		<s:checkboxlist list="listaCursosActuales" name="listaVaciaB.idCurso"
			listKey="idCurso" listValue="descCurso" />
		<s:checkboxlist list="listaCursosFuturos" name="listaVaciaC.idCurso"
			listKey="idCurso" listValue="descCurso" />
		<s:submit value="Cargar" />
	</s:form>
	<s:form action="binscribir">
		<s:iterator value="#session.x_curso">
			<s:property value="idCurso" />
			<s:property value="descCurso" />
			<br>
		</s:iterator>
		<s:submit value="Inscribirse" />
	</s:form>
</body>
</html>