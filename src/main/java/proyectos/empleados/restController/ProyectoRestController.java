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

import proyectos.empleados.dto.ProyectoDto;
import proyectos.empleados.entities.Empleado;
import proyectos.empleados.entities.Proyecto;
import proyectos.empleados.service.ProyectoService;

@RestController
@RequestMapping("/proyectos")
public class ProyectoRestController {
	
	@Autowired
	private ProyectoService pServ;

	
	@GetMapping("/verTodos")
	public ResponseEntity<?> verTodos(){
		return ResponseEntity.status(HttpStatus.OK.value()).body(pServ.verTodosLosProyectos());
	}
	
	@GetMapping("/verDetalles/{id}")
	public ResponseEntity<?> verProyecto(@PathVariable ("id") int idProyecto){
		if(pServ.verUnProyecto(idProyecto) != null)
			return ResponseEntity.status(HttpStatus.OK.value()).body(pServ.verUnProyecto(idProyecto));
		else
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body("No existe el proyecto");
	}
	
	@GetMapping("/verActivos")
	public ResponseEntity<?>  activos(){
		return ResponseEntity.status(HttpStatus.OK.value()).body(pServ.verProyectosActivos());
	}
	
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<String> eliminarProyecto(@PathVariable ("id") int idProyecto){
		if(pServ.eliminarProyecto(idProyecto) == true) {
			return ResponseEntity.status(HttpStatus.OK.value()).body("Proyecto eliminado");
		}else 
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body("Proyecto no se ha podido eliminar");
	}
	
	
	@PostMapping("/alta")
	public ResponseEntity<String> altaProyecto(@RequestBody Proyecto proyecto){
		if(pServ.altaProyecto(proyecto) != null) {
			return ResponseEntity.status(HttpStatus.OK.value()).body("Alta realizada correctamente");
		}else
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body("Alta no realizada");
	}
			
	/*
	 * Modificar proyecto sin Dto
	@PutMapping("/editar/{id}")
	public ResponseEntity<String> editarProyecto(@PathVariable("id") int idProyecto, @RequestBody Proyecto proyecto){
		if(pServ.modificarProyecto(proyecto, idProyecto) != null) {
			return ResponseEntity.status(HttpStatus.OK.value()).body("Proyecto modificado correctamente");
		}else
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body("No se ha modificado el proyecto");
	}
	*/
	
	//Modificar proyecto con Dto
	@PutMapping("/editar/{id}")
	public ResponseEntity<String> editarProyecto(@PathVariable("id") int idProyecto, @RequestBody ProyectoDto proyectoDto){
		Proyecto proy = pServ.verUnProyecto(idProyecto);
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.map(proyectoDto, proy);
		if(pServ.modificarProyecto(proy, idProyecto) != null) {
			return ResponseEntity.status(HttpStatus.OK.value()).body("Proyecto modificado correctamente");
		}else
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body("No se ha modificado el proyecto");
	}
	
	
	@GetMapping("/verDirector/{id}")
	public ResponseEntity<Empleado> verDirector(@PathVariable("id") int idProyecto){
		return ResponseEntity.status(HttpStatus.OK.value()).body(pServ.verDirectorDeProyecto(idProyecto));
	}
	

}
