<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Asistencia</title>
</head>
<body>
	<s:iterator value="listaAsistenciaResumen">
		<s:a action="listaAsistenciaDetallada">
			<s:param name="inte">
				<s:property value="idCursoSeccion" />
			</s:param>
			<s:property value="descCurso" />
			<s:property value="cantAsistencias" />
		</s:a>
		<br>
	</s:iterator>
</body>
</html>