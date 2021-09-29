<%@page import="controlador.Conexion"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script type="text/javascript"  src="js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="js/consultar.js"></script>
<title>Insert title here</title>

</head>
<body>
<h1>Gestion usuario</h1>
<%! %>


<%
Conexion con=new Conexion();
con.conexionbd();

String u="",c="",r="",e="",d="";

if(request.getParameter("do")!=null){
d=request.getParameter("do");
u=request.getParameter("us");
c=request.getParameter("cl");
r=request.getParameter("ro");
e=request.getParameter("es");
}
%>

<form action="ServletGestionusuario"  method="post">
<select id="lista" name="doc">


</select>   
<input type="text" name="usu"  value="<%=u%>">
<input type="text" name="cla"  value="<%=c%>">
<input type="text" name="rol"  value="<%=r%>">
<input type="text" name="est"  value="<%=e%>">
<input type="submit" name="btnins" value="Insertar">
<input type="submit" name="btncon" value="Consultar">
<input type="submit" name="btnact" value="Actualizar">

</form>

<form action="ServletGestionusuario" method="post">
<input type="text" name="doc">
<input type="submit" name="btneli" value="Eliminar">
<
</form>


<input type="button" name="btneli" class="con" value="Consultar g">
<table id="tabla">



</table>




</table>



</body>
</html>