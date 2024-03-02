package proyectos.empleados.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import proyectos.empleados.entities.Empleado;
import proyectos.empleados.service.EmpleadoService;

@RestController
@RequestMapping("/empleados")
public class EmpleadoRestController {
	
	@Autowired
	private EmpleadoService eServ;
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<String> eliminarEmpleado(@PathVariable ("id") int idEmpleado){
		if(eServ.eliminarEmpleado(idEmpleado)) {
			return ResponseEntity.status(200).body("Empleado eliminado");
		}
		return ResponseEntity.status(500).body("Empleado no eliminado");
	}
	
	@GetMapping("/todos")
	public ResponseEntity<?> verTodos(){
		return ResponseEntity.status(200).body(eServ.todosLosEmpleados());
	}
	
	@GetMapping("/verUno/{id}")
	public ResponseEntity<Empleado> verUno(@PathVariable ("id") int idEmpleado){
		return ResponseEntity.status(200).body(eServ.verUnEmpleado(idEmpleado));
	}

}
