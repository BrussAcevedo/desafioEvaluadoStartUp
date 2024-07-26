<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Iniciar Sesion</title>
<%@include file ="assets/html/importHead.html" %>
<link rel ="stylesheet" href="assets/css/login.css">
</head>
<body>

<div class ="contenido row d-flex justify-content-center">

<div class="col-12 d-flex ms-auto boton-atras">
<form action="IndexControlador" method="get">
<button type="submit" name ="action" value="inicio">HOME <i class="fa-solid fa-house"></i></button>
</form>
</div>


<div class="contendorLogin col-12 ">
	<form action="LoginControlador" method="post">
	
	 <h1>Acceso al Portal</h1>
	
		<div class="contenedorInterno">
		
		<div class ="contenedorDato pb-3">
			<input type="text" placeholder="Correo Electronico" name ="correoLoginTxt" required>
			<i class="fa-solid fa-user icon1"></i>
		</div>
		
		
		<div class ="contenedorDato">
			<input type="password" placeholder="Contraseña" name ="passwordLoginTxt" required>
			<i class="fa-solid fa-key icon2"></i>
		</div>
		
		<div class ="recuperar-recordar pt-1 pb-2">
			<input type ="checkbox" name ="action" value ="recordar">Recordar Contraseña
			<a href="LoginControlador?action = recuperar">¿Olvidaste tu Contraseña?</a>
		</div>
			
		<div class ="boton-enviar mt-5">
			<button type="submit" name="action" value="enviar" >Enviar</button>
		</div>
		
		<div class ="Registrar py-2">
		<p class="my-0">¿Aun no estas Registrado?</p>
			<a href="IndexControlador?action=registro">Registrate acá</a>
		</div>
		
		</div>
	</form>
</div>
</div>
					<%String usuarioIncorrectoMsj = (String)request.getAttribute("usuarioIncorrecto"); %>
		<%if(usuarioIncorrectoMsj != null){ %>
		<div class ="usuario-contraseña-error" style="width 200px;">
			<p>El correo y/o contraseña son incorrectas. Porfavor intentalo denuevo.</p>
		</div>
			
		<%} %>



<%@include file ="assets/html/importFooter.html" %>
</body>
</html>