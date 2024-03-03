package proyectos.empleados.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import proyectos.empleados.entities.Empleado;
import proyectos.empleados.entities.Proyecto;

public interface ProyectoRepository extends JpaRepository<Proyecto, Integer>{

	@Query
	("Select p from Proyecto p where p.estado = 'Activo'")
	public List<Proyecto> verActivos();
	
	@Query("select p.director from Proyecto p where p.idProyecto =?1")
	Empleado verDirectorProyecto(int idProyecto);
}
