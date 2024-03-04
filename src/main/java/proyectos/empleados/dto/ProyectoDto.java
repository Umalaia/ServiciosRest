package proyectos.empleados.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProyectoDto {

	private String descripcion;
	private Date fechaInicio;
	private int diasPrevistos;
	private String estado;

}
