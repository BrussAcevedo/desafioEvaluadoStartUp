package cl.desafioLatam.servicios;



import cl.desafioLatam.DAO.UsuarioDAO;
import cl.desafioLatam.DTO.DireccionDTO;
import cl.desafioLatam.DTO.RolUsuarioDTO;
import cl.desafioLatam.DTO.UsuarioDTO;
import cl.desafioLatam.Enum.EstadoReg;
import cl.desafioLatam.Enum.EstadoSQL;
import cl.desafioLatam.utilidades.SetFechaHora;

public class ServicioCuenta {

	private ServicioUsuario servicioUsuario = new ServicioUsuario();
	private ServicioDireccion servicioDireccion = new ServicioDireccion();
	private ServicioRolUsuario servicioRol = new ServicioRolUsuario();
	private ServicioSeguridad seguridad = new ServicioSeguridad();
	
	public void registroDatos (UsuarioDTO datosUsuario, DireccionDTO datosDireccion) {
		RolUsuarioDTO rolUsuario = new RolUsuarioDTO(datosUsuario.getId(), 1);
		
		if (datosUsuario != null) {
			if (!datosUsuario.getCorreo().isEmpty() && !datosUsuario.getPassword().isEmpty()) {
				
				String passwordEncripted = seguridad.encriptarPassword(datosUsuario.getPassword());
				datosUsuario.setPassword(passwordEncripted);
				
				String fechaHoraActual= SetFechaHora.fijarFechaHora();
				datosUsuario.setCreatedAt(fechaHoraActual);
				datosUsuario.setUpdateAt(fechaHoraActual);
				
				EstadoReg estadoUsReg = servicioUsuario.NuevoUsuario(datosUsuario);
				EstadoReg estadoDirReg = servicioDireccion.nuevaDireccion(datosDireccion);
				EstadoReg estadoRolReg = servicioRol.nuevoRol(rolUsuario);
				
				String estadoGralReg = String.format("Resumen registro:\r\n"
											+ "Registro del usuario: %s\r\n"
											+ "registro direccion: %s\r\n"
											+ "registro rol: %s", estadoUsReg.getMensaje(), estadoDirReg.getMensaje(), estadoRolReg.getMensaje());
				
			}		
			
		}
	
		
	}
	
	public void loginUsuario (String correoLogin, String passwordLogin) {
		UsuarioDAO usuarioDao = new UsuarioDAO();
		
		EstadoSQL estado = usuarioDao.validatePassword(correoLogin, passwordLogin);
		System.out.println(estado.getMensaje());
	}
	
	
	
	
	
	
	
	
	
}
