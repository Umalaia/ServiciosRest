package proyectos.empleados.restController;

import java.util.List;
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

import proyectos.empleados.entities.Empleado;
import proyectos.empleados.entities.Proyecto;
import proyectos.empleados.service.ProyectoService;

@RestController
@RequestMapping("/proyectos")
public class ProyectoRestController {
	
	@Autowired
	private ProyectoService pServ;

	
	@GetMapping("/verTodos")
	public List<Proyecto> verTodos(){
		return pServ.verTodosLosProyectos();
	}
	
	@GetMapping("/verDetalles/{id}")
	public ResponseEntity<Proyecto> verProyecto(@PathVariable ("id") int idProyecto){
		return ResponseEntity.status(200).body(pServ.verUnProyecto(idProyecto));
	}
	
	@GetMapping("/verActivos")
	public List<Proyecto> activos(){
		return pServ.verProyectosActivos();
	}
	
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<String> eliminarProyecto(@PathVariable ("id") int idProyecto){
		if(pServ.eliminarProyecto(idProyecto) == true) {
			return ResponseEntity.status(200).body("Proyecto eliminado");
		}else 
			return ResponseEntity.status(500).body("Proyecto no se ha podido eliminar");
	}
	
	
	@PostMapping("/alta")
	public ResponseEntity<String> altaProyecto(@RequestBody Proyecto proyecto){
		if(pServ.altaProyecto(proyecto) != null) {
			return ResponseEntity.status(200).body("Alta realizada correctamente");
		}else
			return ResponseEntity.status(500).body("Alta no realizada");
	}
			
	
	@PutMapping("/editar/{idProyecto}")
	public ResponseEntity<String> editarProyecto(@PathVariable("idProyecto") int idProyecto, @RequestBody Proyecto proyecto){
		if(pServ.modificarProyecto(proyecto, idProyecto) != null) {
			return ResponseEntity.status(200).body("Proyecto modificado correctamente");
		}else
			return ResponseEntity.status(500).body("No se ha modificado el proyecto");
	}
	
	
	@GetMapping("/verDirector/{id}")
	public ResponseEntity<Empleado> verDirector(@PathVariable("id") int idProyecto){
		return ResponseEntity.status(200).body(pServ.verDirectorDeProyecto(idProyecto));
	}
	

}
