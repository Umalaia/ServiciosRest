package proyectos.empleados.service;

import java.util.List;

import proyectos.empleados.entities.Empleado;

public interface EmpleadoService {

	List<Empleado> todosLosEmpleados();
	Empleado verUnEmpleado(int idEmpleado);
	boolean altaEmpleado(int idEmpleado);
	int eliminarEmpleado(int idEmpleado);
	Empleado modificarEmpleado(Empleado empleado);
	
}
