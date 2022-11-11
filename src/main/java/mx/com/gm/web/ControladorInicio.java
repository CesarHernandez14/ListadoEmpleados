package mx.com.gm.web;

import java.util.List;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import mx.com.gm.domain.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import mx.com.gm.servicio.EmpleadoService;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
public class ControladorInicio {
    
    @Autowired
    private EmpleadoService empleadoService;
    
    @GetMapping("/")
    public String inicio(Model model, @AuthenticationPrincipal User user){
        var empleados = empleadoService.listarEmpleado();
        log.info("ejecutando el controlador Spring MVC");
        log.info("usuario que hizo login:" + user);
        model.addAttribute("empleados", empleados);
        return "index";
    }
    
    @GetMapping("/agregar")
    public String agregar(Empleado empleado){
        return "modificar";
    }
    
    @PostMapping("/guardar")
    public String guardar(@Valid Empleado empleado, Errors errores){
        if(errores.hasErrors()){
            return "modificar";
        }
        empleadoService.guardar(empleado);
        return "redirect:/";
    }
    
    @GetMapping("/editar/{idEmpleado}")
    public String editar(Empleado empleado, Model model){
        empleado = empleadoService.encontrarEmpleado(empleado);
        model.addAttribute("empleado", empleado);
        return "modificar";
    }
    
    @GetMapping("/eliminar")
    public String eliminar(Empleado empleado){
        empleadoService.eliminar(empleado);
        return "redirect:/";
    }
    
    /*
    @GetMapping("/")
    public String busquedaNombre(Model model, @RequestParam(value = "query", required = false)String q){
        try{
            List<Empleado> empleados = this.empleadoService.findByNombre(q);
            return "index";
        }catch(Exception e){
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }
*/
}
