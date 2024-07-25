package cl.desafioLatam.servicios;

import cl.desafioLatam.DAO.RolUsuarioDAO;
import cl.desafioLatam.DTO.RolUsuarioDTO;
import cl.desafioLatam.Enum.EstadoReg;
import cl.desafioLatam.Enum.EstadoSQL;

public class ServicioRolUsuario {

	private RolUsuarioDAO rolUsuarioDao = new RolUsuarioDAO();
	
	
	public EstadoReg nuevoRol(RolUsuarioDTO nuevoRolUsuario) {
		
		if (nuevoRolUsuario != null && (nuevoRolUsuario.getRolId() > 0 && nuevoRolUsuario.getRolId() < 3)) {
			
			if (!existenciaRol(nuevoRolUsuario.getUsuarioId())) {
				
				 EstadoSQL estadoSql =  rolUsuarioDao.save(nuevoRolUsuario);
				 
				 if (estadoSql == EstadoSQL.EXITO) {
					 return EstadoReg.INGRESADO;
				 }				
			}		
		}
		return EstadoReg.NO_INGRESADO;
	}
	
	public boolean existenciaRol (int idUsuario) {
		
		RolUsuarioDTO rolUsuario = new RolUsuarioDTO();
		EstadoSQL estado = rolUsuarioDao.findById(3, rolUsuario);
		
		if (estado == EstadoSQL.CONDICION_EXITOSA) {
			return true;
		}	
		return false;
	}
	
	
}
