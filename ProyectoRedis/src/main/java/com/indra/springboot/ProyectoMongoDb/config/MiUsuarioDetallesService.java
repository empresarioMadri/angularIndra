package com.indra.springboot.ProyectoMongoDb.config;

import com.indra.springboot.ProyectoMongoDb.form.MiUsuarioPrincipal;
import com.indra.springboot.ProyectoMongoDb.entities.Usuario;
import com.indra.springboot.ProyectoMongoDb.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MiUsuarioDetallesService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByLogin(s);
        if(usuario == null){
            throw new UsernameNotFoundException(s);
        }
        return new MiUsuarioPrincipal(usuario);
    }
}
