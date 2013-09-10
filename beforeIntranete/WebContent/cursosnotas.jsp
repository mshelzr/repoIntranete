<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cursos de Notas</title>
</head>
<body>
	<s:iterator value="listaCursosDetalle">
		<s:a action="notaDetallado">
			<s:param name="codCurso">
				<s:property value="idCurso" />
			</s:param>
			<s:property value="descCurso" />
			<br>
		</s:a>
	</s:iterator>


</body>
</html>