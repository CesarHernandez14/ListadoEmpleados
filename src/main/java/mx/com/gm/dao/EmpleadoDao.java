package mx.com.gm.dao;

import java.util.List;
import mx.com.gm.domain.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmpleadoDao extends JpaRepository<Empleado, Long>{
    /*
    @Query(value = "SELECT * FROM empleado WHERE empleado.nombre = %:q%")
    List<Empleado>findByNombre(@Param("q")String q);
*/
}
