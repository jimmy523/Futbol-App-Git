package com.futbol.manager.service.usuario;

import com.futbol.manager.view.dto.UsuarioDto;
import org.springframework.stereotype.Service;

/**
 * Created by aandrade on 06/09/2014.
 */
@Service
public interface UsuarioService {
    public UsuarioDto login(String username,String password);
}
