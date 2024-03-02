package proyectos.empleados.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyectos.empleados.entities.Empleado;
import proyectos.empleados.repository.EmpleadoRepository;

@Service
public class EmpleadoServiceImpl implements EmpleadoService{
	
	@Autowired
	private EmpleadoRepository eRepo;

	@Override
	public List<Empleado> todosLosEmpleados() {
		return eRepo.findAll();
	}

	@Override
	public Empleado verUnEmpleado(int idEmpleado) {
		return eRepo.findById(idEmpleado).orElse(null);
	}

	@Override
	public boolean altaEmpleado(int idEmpleado) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminarEmpleado(int idEmpleado) {
		try {
			if(verUnEmpleado(idEmpleado) != null) {
				eRepo.deleteById(idEmpleado);
				return true;
			}else
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Empleado modificarEmpleado(Empleado empleado) {

		return null;
	}

}
