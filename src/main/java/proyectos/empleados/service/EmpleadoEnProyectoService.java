package proyectos.empleados.service;
import java.util.List;
import proyectos.empleados.entities.EmpleadoEnProyecto;

public interface EmpleadoEnProyectoService {
	List<EmpleadoEnProyecto> verEmpleadosConProyectos();
	EmpleadoEnProyecto altaEmpleadoEnProyecto(EmpleadoEnProyecto empleEnProy);
	EmpleadoEnProyecto verUnEmpleadoEnProyecto(int idEntrada);
	
}
