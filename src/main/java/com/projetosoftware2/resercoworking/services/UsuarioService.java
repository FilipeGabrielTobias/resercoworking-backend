package com.projetosoftware2.resercoworking.services;

import com.projetosoftware2.resercoworking.domain.Usuario;
import com.projetosoftware2.resercoworking.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projetosoftware2.resercoworking.services.exceptions.ObjectNotFoundException;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> getUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario getUsuarioById(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado"));
    }

    public Usuario saveUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario updateUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
    
    public Usuario atualizaPontuacao(Long usuarioId, Integer qtPontos, boolean resgatePontos){
    	Usuario usuario = usuarioRepository.findById(usuarioId)
    	                .orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado"));
    	
    	int pontos = usuario.getQuantidadePontos();
    	if (resgatePontos) {
    		pontos -= qtPontos;    		 
    	} else {
    		pontos += qtPontos;  
    	}
    	
    	usuario.setQuantidadePontos(pontos);

    	return usuarioRepository.save(usuario);
    }
    
    
}
