package proyectos.empleados.dto;
import java.util.Date;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmpleadoEnProyectoDto {
	
	private int idEmpleado;
	private int idProyecto;
	private int diasPrevistos;
	private Date fechaIncorporacion;
	
	
    
}
