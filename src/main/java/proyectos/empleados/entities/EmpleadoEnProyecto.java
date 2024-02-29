package proyectos.empleados.entities;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="empleados_en_proyecto")
public class EmpleadoEnProyecto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_entrada")
	private int idEntrada;
	
	@ManyToOne
	@JoinColumn(name="id_proyecto")
	private Proyecto proyecto;
	
	@ManyToOne
	@JoinColumn(name="id_empleado")
	private Empleado empleado;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dias_previstos")
	private int diasPrevistos;
	
	@Column(name="fecha_incorporacion")
	private Date fechaIncorporacion;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmpleadoEnProyecto other = (EmpleadoEnProyecto) obj;
		return idEntrada == other.idEntrada;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idEntrada);
	}
}
