package proyectos.empleados.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyectos.empleados.entities.EmpleadoEnProyecto;
import proyectos.empleados.repository.EmpleadoEnProyectoRepository;

@Service
public class EmpleadoEnProyectoServiceImpl implements EmpleadoEnProyectoService {

	@Autowired
	private EmpleadoEnProyectoRepository epRepo;

	@Override
	public List<EmpleadoEnProyecto> verEmpleadosConProyectos() {
		return epRepo.findAll();
	}

	@Override
	public EmpleadoEnProyecto altaEmpleadoEnProyecto(EmpleadoEnProyecto empleEnProy) {
		try {
			if(existeEmpleadoEnProyecto(empleEnProy.getProyecto().getIdProyecto(), empleEnProy.getEmpleado().getIdEmpleado()) != null)
			return epRepo.save(empleEnProy);	
		} catch (Exception e) {
			return null;
		}
		return empleEnProy;
	}

	@Override
	public EmpleadoEnProyecto verUnEmpleadoEnProyecto(int idEntrada) {
		return epRepo.findById(idEntrada).orElse(null);
	}

	@Override
	public EmpleadoEnProyecto verProyecto(int idProyecto) {
		return epRepo.findById(idProyecto).orElse(null);
	}

	@Override
	public EmpleadoEnProyecto existeEmpleadoEnProyecto(int idProyecto, int idEmpleado) {
		return epRepo.buscarEmpleadoEnProyecto(idProyecto, idEmpleado);
	}
	


}
