package br.com.devmedia.blog.web.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.devmedia.blog.entity.Usuario;

public class UsuarioValidator implements Validator{

	public boolean supports(Class<?> arg0) {
		return Usuario.class.equals(arg0);
	}

	public void validate(Object target, Errors errors) {

		Usuario usuario = (Usuario) target;
		
		if(usuario.getNome() != null){
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "nome","Esta campo é obrigatorio");
		}
		
		if(usuario.getEmail() != null){
			Pattern pattern = Pattern.compile(".+@.+\\..+");
			Matcher matcher = pattern.matcher(usuario.getEmail());
			if(!matcher.matches()){
				errors.rejectValue("email","email","Insira um email valido");
			}
		}
		
		if(usuario.getSenha() != null){
			
			if(usuario.getSenha().length() > 8 || usuario.getSenha().length() < 5){
				
				errors.rejectValue("senha", "senha","A senha deve conter entre 5 e 8 caracteres");
				
			}
			
		}
		
		if(usuario.getFile() != null){
			
			if(usuario.getFile().getSize() == 0){
				errors.rejectValue("file", "file","Selecione uma imagem ate 100kb");
			}
			
		}
		
	}

}
