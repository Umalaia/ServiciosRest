package proyectos.empleados.restController;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import proyectos.empleados.dto.EmpleadoDto;
import proyectos.empleados.entities.Empleado;
import proyectos.empleados.service.EmpleadoService;

@RestController
@RequestMapping("/empleados")
public class EmpleadoRestController {
	
	@Autowired
	private EmpleadoService eServ;
	
	@GetMapping("/todos")
	public ResponseEntity<?> verTodos(){
		return ResponseEntity.status(200).body(eServ.todosLosEmpleados());
	}
	
	@GetMapping("/verUno/{id}")
	public ResponseEntity<Empleado> verUno(@PathVariable ("id") int idEmpleado){
		return ResponseEntity.status(200).body(eServ.verUnEmpleado(idEmpleado));
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<String> eliminarEmpleado(@PathVariable ("id") int idEmpleado){
		if(eServ.eliminarEmpleado(idEmpleado)) {
			return ResponseEntity.status(200).body("Empleado eliminado");
		}
		return ResponseEntity.status(500).body("Empleado no eliminado");
	}
	
	
	@PostMapping("/alta")
	public ResponseEntity<String> altaEmpleado(@RequestBody Empleado empleado){
		if(eServ.altaEmpleado(empleado) != null) {
			return ResponseEntity.status(HttpStatus.OK.value()).body("Alta de empleado realizada");
		}
		else
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body("Alta de empleado no se ha realizado");
	}
	
	
	@PutMapping("/editar/{id}")
	public ResponseEntity<String> modificarEmpleado(@PathVariable ("id")int idEmpleado, @RequestBody EmpleadoDto eDto){
		Empleado empl = eServ.verUnEmpleado(idEmpleado);
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.map(eDto, empl);
		if(eServ.modificarEmpleado(empl, idEmpleado) != null) {
			return ResponseEntity.status(HttpStatus.OK.value()).body("Modificación de empleado realizada");
		}
		else
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body("Modificación de empleado no se ha realizado");
	}
	

}
