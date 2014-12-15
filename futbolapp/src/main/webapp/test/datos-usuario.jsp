<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>Visulizacion de datos Usuario TEST</title>
</head>
<body>
Nombre: <strong><s:property value="usuario.nombre" /></strong> <br />
Username: <strong><s:property value="usuario.username" /></strong> <br />
Password: <strong><s:property value="usuario.password" /></strong> <br />
Edad: <strong><s:property value="usuario.edad" /></strong> <br />
Fecha de Nacimiento: <strong><s:property value="usuario.fechaNacimiento" /></strong>
</body>
</html>