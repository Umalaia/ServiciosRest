package proyectos.empleados.service;
import java.util.List;

import proyectos.empleados.entities.EmpleadoEnProyecto;

public interface EmpleadoEnProyectoService {
	List<EmpleadoEnProyecto> verEmpleadosConProyectos();
	EmpleadoEnProyecto altaEmpleadoEnProyecto(EmpleadoEnProyecto empleadoEnProyecto);
	EmpleadoEnProyecto verUnaEntradaEnProyecto(int idEntrada);
	boolean eliminarEmpleadoEnProyecto(int idEntrada);
	EmpleadoEnProyecto existeEmpleadoEnProyecto(int idProyecto, int idEmpleado);
}
