package co.empresa.recursoshumanos.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @RequestMapping("/userlogin")
    public String userValidation(){
        return "Usuario ingreso con exito";
    }

    @RequestMapping("/adminlogin")
    public String adminValidation(){
        return "admin ingreso con exito";
    }
}
