package proyectos.empleados.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyectos.empleados.dto.EmpleadoEnProyectoDto;
import proyectos.empleados.entities.EmpleadoEnProyecto;
import proyectos.empleados.repository.EmpleadoEnProyectoRepository;

@Service
public class EmpleadoEnProyectoServiceImpl implements EmpleadoEnProyectoService {

	@Autowired
	private EmpleadoEnProyectoRepository epRepo;

	@Override
	public List<EmpleadoEnProyecto> verTodos() {
		return epRepo.findAll();
	}

	
	@Override
	public EmpleadoEnProyecto altaEmpleadoEnProyecto(EmpleadoEnProyecto empleadoEnProyecto) {
		boolean noExiste = existeEmpleadoEnProyecto(empleadoEnProyecto.getProyecto().getIdProyecto(), empleadoEnProyecto.getEmpleado().getIdEmpleado()) == null;
		try {
			if(noExiste)
			return epRepo.save(empleadoEnProyecto);	
			else
				return null;
		} catch (Exception e) {
			return null;
		}
	}
	
	
	/*
	 * Sin comprobar (manera simple)
	@Override
	public EmpleadoEnProyecto altaEmpleadoEnProyecto(EmpleadoEnProyecto empleadoEnProyecto) {
		return epRepo.save(empleadoEnProyecto);
	}
	*/

	@Override
	public EmpleadoEnProyecto verUnaEntradaEnProyecto(int idEntrada) {
		return epRepo.findById(idEntrada).orElse(null);
	}



	@Override
	public EmpleadoEnProyecto existeEmpleadoEnProyecto(int idProyecto, int idEmpleado) {
		return epRepo.buscarEmpleadoEnProyecto(idProyecto, idEmpleado);
	}

	@Override
	public boolean eliminarEmpleadoEnProyecto(int idEntrada) {
		try {
			if(verUnaEntradaEnProyecto(idEntrada)!= null) {
				epRepo.deleteById(idEntrada);
				return true;
			}else
				return false;
		} catch (Exception e) {
				return false;
	}
	
	}

	@Override
	public EmpleadoEnProyecto modificarEmpleadoEnProyecto(int idProyecto, int idEmpleado) {
		return null;
	}

}
