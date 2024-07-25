package cl.desafioLatam.servicios;

import cl.desafioLatam.DAO.DireccionDAO;
import cl.desafioLatam.DTO.DireccionDTO;
import cl.desafioLatam.Enum.EstadoReg;
import cl.desafioLatam.Enum.EstadoSQL;

public class ServicioDireccion {

	
	private DireccionDAO direccionDao = new DireccionDAO();
	
	
	
	public EstadoReg nuevaDireccion (DireccionDTO nuevaDireccion) {
		boolean estado = !existenciaDireccion(nuevaDireccion.getUsuarioId());
		
		if(nuevaDireccion != null) {
			if(!existenciaDireccion(nuevaDireccion.getUsuarioId())) {
				
				EstadoSQL estadoSql =  direccionDao.save(nuevaDireccion);
				
				if (estadoSql == EstadoSQL.EXITO) {
					return EstadoReg.INGRESADO;
				}
			}	
		}
		
		return EstadoReg.NO_INGRESADO;
		
	}
	
	
	public boolean existenciaDireccion(int idUsuario) {
		
		DireccionDTO direccion = new DireccionDTO();
		EstadoSQL estado = direccionDao.findById(idUsuario, direccion);
		
		if (estado == EstadoSQL.CONDICION_EXITOSA){
			System.out.println(estado.getMensaje());
			return true;
		}
		
		return false;
	}
	
	
	
}
