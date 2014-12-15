<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>Carga de Usuario TEST</title>
</head>
<body>
<s:form action="datosUsuario">
    <s:textfield name="nombre" label="Nombre" />
    <s:textfield name="username" label="Username" />
    <s:password name="password" label="Password" />
    <s:textfield name="edad" label="Edad" />
    <s:textfield name="fechaNacimiento" label="Fecha de Nacimiento" />
    <s:submit value="Login" />
</s:form>
</body>
</html>
