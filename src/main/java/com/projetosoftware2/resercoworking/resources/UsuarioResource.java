package com.projetosoftware2.resercoworking.resources;

import com.projetosoftware2.resercoworking.domain.Usuario;
import com.projetosoftware2.resercoworking.security.JWTUtil;
import com.projetosoftware2.resercoworking.security.UserSS;
import com.projetosoftware2.resercoworking.services.AuthService;
import com.projetosoftware2.resercoworking.services.UserService;
import com.projetosoftware2.resercoworking.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Filipe.Tobias on 07/08/2018.
 */
@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

}
