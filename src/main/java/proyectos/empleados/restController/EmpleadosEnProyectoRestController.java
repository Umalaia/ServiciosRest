package proyectos.empleados.restController;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import proyectos.empleados.dto.EmpleadoEnProyectoDto;
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
	public List<EmpleadoEnProyecto> verTodos(){
		return epServ.verEmpleadosConProyectos();
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

}
