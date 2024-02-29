package proyectos.empleados.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import proyectos.empleados.entities.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer>{

}
