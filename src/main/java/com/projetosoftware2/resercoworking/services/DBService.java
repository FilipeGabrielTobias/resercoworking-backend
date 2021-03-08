package com.projetosoftware2.resercoworking.services;

import com.projetosoftware2.resercoworking.domain.AssociacaoUsuarioPerfil;
import com.projetosoftware2.resercoworking.domain.Perfil;
import com.projetosoftware2.resercoworking.domain.Usuario;
import com.projetosoftware2.resercoworking.repositories.PerfilRepositoy;
import com.projetosoftware2.resercoworking.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Filipe.Tobias on 31/07/2018.
 */
@Service
public class DBService {

    @Autowired
    private BCryptPasswordEncoder pe;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PerfilRepositoy perfilRepositoy;

    public void instantiateTestDatabase() throws ParseException {
        Perfil perfil = new Perfil();
        perfil.setId(1L);
        perfil.setNome("Administrador");
        perfil.setDescricao("Administrador da Aplicação");

        Usuario usuario = new Usuario();
        usuario.setId(1);
        usuario.setNome("Filipe Tobias");
        usuario.setEmail("tobias.filipe@gmail.com");
        usuario.setSenha(pe.encode("123"));

        perfilRepositoy.save(perfil);
        usuarioRepository.save(usuario);

        Set<AssociacaoUsuarioPerfil> set = new HashSet<>();
        AssociacaoUsuarioPerfil associacaoUsuarioPerfil = new AssociacaoUsuarioPerfil();
        associacaoUsuarioPerfil.setId(1L);
        associacaoUsuarioPerfil.setUsuario(usuario);
        associacaoUsuarioPerfil.setPerfil(perfil);
        set.add(associacaoUsuarioPerfil);

        usuario.setAssociacaoUsuarioPerfil(set);

        usuarioRepository.save(usuario);
    }
}
