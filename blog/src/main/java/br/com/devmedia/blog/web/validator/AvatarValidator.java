package br.com.devmedia.blog.web.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.devmedia.blog.entity.Avatar;

public class AvatarValidator implements Validator{

	public boolean supports(Class<?> clazz) {
		return Avatar.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {

		Avatar avatar = (Avatar) target;
		
		if(avatar.getFile() != null){
			
			if(avatar.getFile().getSize() == 0){
				
				errors.rejectValue("file", "file", "Selecione um avatar de ate 100kb");
				
			}
			
		}
		
	}

}
