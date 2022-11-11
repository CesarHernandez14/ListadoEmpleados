package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.domain.Empleado;

public interface EmpleadoService {
    
    public List<Empleado> listarEmpleado();
    
    public void guardar(Empleado empleado);
    
    public void eliminar(Empleado empleado);
    
    public Empleado encontrarEmpleado(Empleado empleado);
    
    //public List<Empleado>findByNombre(String q)throws Exception;
}
