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
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmpleadoEnProyectoDto other = (EmpleadoEnProyectoDto) obj;
		return idEmpleado == other.idEmpleado && idProyecto == other.idProyecto;
	}
	@Override
	public int hashCode() {
		return Objects.hash(idEmpleado, idProyecto);
	}
	
	
    
}
