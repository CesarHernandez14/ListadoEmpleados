package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.domain.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import mx.com.gm.dao.EmpleadoDao;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
    private EmpleadoDao empleadoDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Empleado> listarEmpleado() {
        return (List<Empleado>) empleadoDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Empleado empleado) {
        empleadoDao.save(empleado);
    }

    @Override
    @Transactional
    public void eliminar(Empleado empleado) {
        empleadoDao.delete(empleado);
    }

    @Override
    @Transactional(readOnly = true)
    public Empleado encontrarEmpleado(Empleado empleado) {
        return empleadoDao.findById(empleado.getIdEmpleado()).orElse(null);
    }
    /*
    @Transactional
    @Override
    public List<Empleado> findByNombre(String q) throws Exception{
        try{
            List<Empleado> entities = this.empleadoDao.findByNombre(q);
            return entities;
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
*/
}
