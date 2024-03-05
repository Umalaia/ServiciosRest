package proyectos.empleados.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmpleadoDto {
	
	private String nombre;
	private String email;
	private double sueldo;
	private String categoria;
	
}
