<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insertar Notas</title>
</head>
<body>
	<s:form action="cargarTiposNotaActReg">
		<s:select list="listaSeccionesXprofesor2" name="stvDCS.idCursoSeccion"
			listValue="descCurso" listKey="idCursoSeccion" />
		<s:submit value="Cargar Seccion" />
	</s:form>
	<s:form action="listarAlumnosParAgregarNota">
		<s:select list="listaTipoNotaXProfesor"
			name="stvDTNC.idDetalle_tiponotacurso" listValue="pesoNota"
			listKey="idDetalle_tiponotacurso" />
		<s:submit value="Filto TipoNota" />
	</s:form>
	<s:form action="AgregarNota">
		<s:iterator value="listaAlumnosParaGenNota">
			<s:property />
			<s:set name="nota" value="17" />

			<%-- 		<s:textfield label="nota" name="#listaAlumnosParaGenNota.nota"/> --%>

		</s:iterator>
		<s:submit value="Aceptar" />
	</s:form>



</body>
</html>