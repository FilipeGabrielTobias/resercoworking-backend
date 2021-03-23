package com.projetosoftware2.resercoworking.security;

import com.projetosoftware2.resercoworking.domain.AssociacaoUsuarioPerfil;
import com.projetosoftware2.resercoworking.domain.Perfil;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Filipe.Tobias on 03/08/2018.
 */
@Data
public class UserSS implements UserDetails {

    private Long id;
    private String nome;
    private String email;
    private String senha;
    private Collection<? extends GrantedAuthority> authorities;

    public UserSS(){
    }

    public UserSS(Long id, String nome, String email, String senha, Set<AssociacaoUsuarioPerfil> perfis){
        super();
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.authorities = perfis.stream().map(x -> new SimpleGrantedAuthority(x.getPerfil().getDescricao())).collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public boolean hasRole(Perfil perfil){
        return getAuthorities().contains(new SimpleGrantedAuthority(perfil.getDescricao()));
    }
}
