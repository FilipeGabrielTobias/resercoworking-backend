package com.projetosoftware2.resercoworking.services;

import com.projetosoftware2.resercoworking.domain.Usuario;
import com.projetosoftware2.resercoworking.domain.enums.Perfil;
import com.projetosoftware2.resercoworking.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.ParseException;

/**
 * Created by Filipe.Tobias on 31/07/2018.
 */
@Service
public class DBService {

    @Autowired
    private BCryptPasswordEncoder pe;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void instantiateTestDatabase() throws ParseException {
        Usuario usuario = new Usuario();
        usuario.setId(1);
        usuario.setNome("Filipe Tobias");
        usuario.setEmail("tobias.filipe@gmail.com");
        usuario.setPassword(pe.encode("123"));
        usuario.addPerfil(Perfil.ADMIN);

        usuarioRepository.save(usuario);
    }
}
