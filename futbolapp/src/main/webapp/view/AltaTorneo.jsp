<%--
  Created by IntelliJ IDEA.
  User: aandrade
  Date: 06/09/2014
  Time: 04:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="/struts-tags" prefix="s" %>

<html>
<head>
    <title>Alta Torneo</title>
</head>
<body>
<s:form action="datosTorneo">
    <s:textfield name="nombre" label="Nombre" />
    <s:textfield name="tipo" label="Tipo" />
    <s:textfield name="duracion" label="Duracion de Partidos (En minutos)" />
    <s:date name="fechaInicio" format="dd/mm/aaaa" />
    <h4>
        <s:checkboxlist label="Seleccione los dias en que se relizara el torneo" list="dias"
                        name="diasJornada" value="defaultDias" />
    </h4>
    <s:textfield name="horarioJornadaInicio" label="Hora Inicio Jornada (HH:MM) 24HS" />
    <s:textfield name="horarioJornadaFin" label="Hora Fin Jornada (HH:MM) 24HS" />
    <s:submit value="Enviar" />
</s:form>
</body>
</html>
