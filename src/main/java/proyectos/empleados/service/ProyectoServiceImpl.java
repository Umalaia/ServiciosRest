package proyectos.empleados.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyectos.empleados.entities.Empleado;
import proyectos.empleados.entities.Proyecto;
import proyectos.empleados.repository.ProyectoRepository;
@Service
public class ProyectoServiceImpl implements ProyectoService{
	
	@Autowired
	private ProyectoRepository pRepo;

	@Override
	public List<Proyecto> verTodosLosProyectos() {
		return pRepo.findAll();
	}

	@Override
	public Proyecto verUnProyecto(int idProyecto) {
		return pRepo.findById(idProyecto).orElse(null);
	}

	@Override
	public Proyecto altaProyecto(Proyecto proyecto) {
		return pRepo.save(proyecto);
	}

	@Override
	public boolean eliminarProyecto(int idProyecto) {
		try {
			if(verUnProyecto(idProyecto) != null) {
				pRepo.deleteById(idProyecto);
				return true;
			}else
				return false;
		}catch(Exception e) {
			return false;
		}
	}
	
	/*
	@Override
	public Proyecto modificarProyecto(Proyecto proyecto, int idProyecto) {
		Proyecto proy = verUnProyecto(idProyecto);
	    if(proy != null) {
	    	proy.setDescripcion(proyecto.getDescripcion());
	    	proy.setDiasPrevistos(proyecto.getDiasPrevistos());
	    	proy.setFechaInicio(proyecto.getFechaInicio());
	    	proy.setEstado(proyecto.getEstado()); 
	        return pRepo.save(proy);
	    } else 
	        return null;
	}
	*/
	
	
	@Override
	public Proyecto modificarProyecto(Proyecto proyecto, int idProyecto) {
		try {
			if(verUnProyecto(idProyecto) != null)
				return pRepo.save(proyecto);
			else
				return null;
		} catch (Exception e) {
			return null;
		}	
	}
	
	
	@Override
	public List<Proyecto> verProyectosActivos() {
		return pRepo.verActivos();
	}

	@Override
	public Empleado verDirectorDeProyecto(int idProyecto) {
		return pRepo.verDirectorProyecto(idProyecto);
	}


}
