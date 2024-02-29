package proyectos.empleados.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyectos.empleados.entities.EmpleadoEnProyecto;
import proyectos.empleados.repository.EmpleadoEnProyectoRepository;

@Service
public class EmpleadoEnProyectoServiceImpl implements EmpleadoEnProyectoService{
	
	@Autowired
	private EmpleadoEnProyectoRepository epRepo;

	@Override
	public List<EmpleadoEnProyecto> verEmpleadosConProyectos() {
		return epRepo.findAll();
	}

	@Override
	public EmpleadoEnProyecto altaEmpleadoEnProyecto(EmpleadoEnProyecto empleEnProy) {
		try {
			return epRepo.save(empleEnProy);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public EmpleadoEnProyecto verUnEmpleadoEnProyecto(int idEntrada) {
		return epRepo.findById(idEntrada).orElse(null);
	}

}
