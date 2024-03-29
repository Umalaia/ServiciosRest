package proyectos.empleados.service;

import java.util.List;

import proyectos.empleados.entities.Empleado;
import proyectos.empleados.entities.Proyecto;

public interface ProyectoService {
	List<Proyecto> verTodosLosProyectos();
	Proyecto verUnProyecto(int idProyecto);
	Proyecto altaProyecto(Proyecto proyecto);
	boolean eliminarProyecto(int idProyecto);
	Proyecto modificarProyecto(Proyecto proyecto, int idProyecto);
	List<Proyecto> verProyectosActivos();
	Empleado verDirectorDeProyecto(int idProyecto);
	
}
