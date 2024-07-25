package cl.desafioLatam.servicios;



import cl.desafioLatam.DAO.RolUsuarioDAO;
import cl.desafioLatam.DAO.UsuarioDAO;
import cl.desafioLatam.DTO.DireccionDTO;
import cl.desafioLatam.DTO.RolUsuarioDTO;
import cl.desafioLatam.DTO.UsuarioDTO;
import cl.desafioLatam.Enum.EstadoReg;
import cl.desafioLatam.Enum.EstadoSQL;

public class ServicioUsuario {

	private UsuarioDAO usuarioDao = new UsuarioDAO();
	
	
	
	public EstadoReg NuevoUsuario (UsuarioDTO nuevoUsuario) {
		EstadoSQL estadoSql = null;
		if (nuevoUsuario.getCorreo() != null && nuevoUsuario.getPassword() != null ) {
			String correo = nuevoUsuario.getCorreo();
			if(!existenciaUsuario(correo)) {
				estadoSql= usuarioDao.save(nuevoUsuario);
			
				if (estadoSql == EstadoSQL.CONDICION_EXITOSA) {				
					return EstadoReg.INGRESADO;
				}
			}else {
				return EstadoReg.EXISTENTE;
			}		
		}		

		return EstadoReg.NO_INGRESADO;
		
		
		
	}
	
	private boolean existenciaUsuario (String correo) {
		UsuarioDTO usuarioTemp = new UsuarioDTO();
		EstadoSQL estado = usuarioDao.findByMail(correo, usuarioTemp);
		
		if (estado == EstadoSQL.CONDICION_EXITOSA) {
			return true;
		}
		
		return false;
	}
	
	
}
