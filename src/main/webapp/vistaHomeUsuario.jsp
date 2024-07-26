<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mi Portal Trabajador</title>
<%@include file ="assets/html/importHead.html" %>
<link rel ="stylesheet" href="assets/css/homeUsuario.css">
</head>
<body>

<%@include file = "assets/html/navbarPortal.html" %>
<section class="contenedor-pagina container">

	<div class ="bienvenida-Txt pt-3">
	<h1>Bienvenido(a) <a href="#" class =txt-color2>${userNick}</a> a tu portal de trabajador:</h1>
	</div>
	<hr>
	 <div class="contenido-pagina row mt-5">
	 
	 <div class="contenedor-contenido">
		 <h2><i class="fa-regular fa-bell"></i> Notificaciones</h2>
		 <hr>
		 <div class = "ps-4">
		 <p><i class="fa-solid fa-check"></i> No tienes notificaciones pendientes.</p> 
		 </div>
		
	 </div>
	 
	 <div class ="contenedor-contenido mt-5 ">
	 	<h2><i class="fa-regular fa-file-lines"></i> Perfil Usuario</h2>
	 	<hr>
	 	<div class ="row">
	 	<div class =" ps-4 col-6">
	 		<p><i class="fa-regular fa-user"></i> Nombre: ${userName}</p>
	 		<p><i class="fa-solid fa-circle-user"></i> Nick Usuario: ${userNick}</p>
			<p><i class="fa-regular fa-envelope"></i> Correo Electrónico: ${userMail}</p>
			<p><i class="fa-solid fa-scale-balanced"></i> Peso: ${userWeight} kg</p>
			<p><i class="fa-regular fa-address-book"></i> Direccion: ${userAddressStreet}, #${userAddressNumber} </p>
	 	</div>
	 	<div class="col-6 d-flex align-items-center justify-content-center">
	 		<img class ="w-50" alt="imgPerfil" src="https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png">
	 	</div>
	 	</div>
	 </div>
	
	</div>

</section>
	<%@include file ="assets/html/importFooter.html" %>
</body>
</html>