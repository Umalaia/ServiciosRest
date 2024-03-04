package proyectos.empleados.restController;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import proyectos.empleados.dto.EmpleadoEnProyectoDto;
import proyectos.empleados.entities.Empleado;
import proyectos.empleados.entities.EmpleadoEnProyecto;
import proyectos.empleados.service.EmpleadoEnProyectoService;
import proyectos.empleados.service.EmpleadoService;
import proyectos.empleados.service.ProyectoService;


@RestController
@RequestMapping("/empleadosEnProyecto")
public class EmpleadosEnProyectoRestController {
	
	@Autowired
	private EmpleadoEnProyectoService epServ;
	
	@Autowired
	private EmpleadoService eServ;
	
	@Autowired
	private ProyectoService pServ;

	
	@GetMapping("/todos")
	public ResponseEntity<?> verTodos(){
		return ResponseEntity.status(HttpStatus.OK.value()).body(epServ.verTodos());
	}
	
	
	@GetMapping("/verEntrada/{id}")
	public ResponseEntity<?> verEntrada(@PathVariable ("id") int idEntrada){
		if(epServ.verUnaEntradaEnProyecto(idEntrada)!= null){
			return ResponseEntity.status(HttpStatus.OK.value()).body(epServ.verUnaEntradaEnProyecto(idEntrada));
		}else
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body("No existe entrada");
	}
	
	
	@GetMapping("/existe/{idProyecto}/{idEmpleado}")
	public ResponseEntity<String> existe(@PathVariable ("idProyecto") int idProyecto, @PathVariable ("idEmpleado") int idEmpleado){
		if(epServ.existeEmpleadoEnProyecto(idProyecto, idEmpleado) != null){
			return ResponseEntity.status(HttpStatus.OK.value()).body("Existe el empleado");
		}else
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body("No existe el empleado");
	}
	
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<String> eliminar(@PathVariable ("id") int idEntrada){
		if(epServ.eliminarEmpleadoEnProyecto(idEntrada) == true) 
			return ResponseEntity.status(HttpStatus.OK.value()).body("Entrada eliminada");
		else
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body("Entrada no eliminada");
	}

	
	@PostMapping("/alta")
	public ResponseEntity<String> alta(@RequestBody EmpleadoEnProyectoDto epDto){
		//EmpleadoEnProyecto ep= modelMapper(epDto);
		EmpleadoEnProyecto ep= new EmpleadoEnProyecto();
		ep.setEmpleado(eServ.verUnEmpleado(epDto.getIdEmpleado()));
		ep.setProyecto(pServ.verUnProyecto(epDto.getIdProyecto()));
		ep.setDiasPrevistos(epDto.getDiasPrevistos());
		ep.setFechaIncorporacion(epDto.getFechaIncorporacion());
		if(epServ.altaEmpleadoEnProyecto(ep) != null){
			return ResponseEntity.status(HttpStatus.OK.value()).body("Alta realizada correctamente");
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body("Alta no realizada");
		}
	}
		
	/*
	//Mapper Dto
	private EmpleadoEnProyecto modelMapper(EmpleadoEnProyectoDto epDto) {
		EmpleadoEnProyecto ep= new EmpleadoEnProyecto();
		ep.setEmpleado(eServ.verUnEmpleado(epDto.getIdEmpleado()));
		ep.setProyecto(pServ.verUnProyecto(epDto.getIdProyecto()));
		ep.setDiasPrevistos(epDto.getDiasPrevistos());
		ep.setFechaIncorporacion(epDto.getFechaIncorporacion());
		
		return ep;
	}
	*/	
	
	
	@PostMapping("/altaModelMapper")
	public ResponseEntity<String> altaModelMapper(@RequestBody EmpleadoEnProyectoDto epDto){
		EmpleadoEnProyecto ep= new EmpleadoEnProyecto();
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.map(epDto, ep);
		if(epServ.altaEmpleadoEnProyecto(ep) != null){
			return ResponseEntity.status(HttpStatus.OK.value()).body("Alta realizada correctamente");
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body("Alta no realizada");
		}
	}
	

}
