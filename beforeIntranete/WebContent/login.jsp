<?xml version="1.0" encoding="UTF-8"?>
<%@page pageEncoding="ISO-8859-1" contentType="text/html;charset=UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Logeo del Sistema</title>
</head>
<body>

	<s:form action="logueo" method="post">
		<s:textfield label="Nombre" name="usuario.user" value="alumno" />
		<s:textfield label="Password" name="usuario.password" value="uno" />
		<s:submit value="Enviar" />
	</s:form>

</body>
</html>