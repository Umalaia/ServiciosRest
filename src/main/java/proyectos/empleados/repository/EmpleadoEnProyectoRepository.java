package proyectos.empleados.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import proyectos.empleados.entities.EmpleadoEnProyecto;

public interface EmpleadoEnProyectoRepository extends JpaRepository<EmpleadoEnProyecto, Integer>{

	@Query("select e from EmpleadoEnProyecto e where e.proyecto.idProyecto = :idProyecto and e.empleado.idEmpleado = :idEmpleado")
	public EmpleadoEnProyecto buscarEmpleadoEnProyecto(int idProyecto,int idEmpleado);
}
