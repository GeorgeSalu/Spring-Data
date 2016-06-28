package br.com.devmedia.blog.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.devmedia.blog.entity.Usuario;
import br.com.devmedia.blog.entity.UsuarioLogado;

@Service
public class UsuarioLogadoDetailService implements UserDetailsService{

	private static final Logger LOG = Logger.getLogger(UsuarioLogadoDetailService.class);
	
	@Autowired
	private UsuarioService service;
	
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		Usuario usuario;
		
		try{
			usuario = service.findByEmail(userName);
			LOG.info("Usuario Encontrado : [ "+userName+" ]");
		}catch(Exception ex){
			LOG.error("Usuario não encontrado : [ "+userName+" ]");
			throw new UsernameNotFoundException("Usuario ["+userName+"] nao enontrado no sistema");
		}
		
		return new UsuarioLogado(usuario);
	}

}
