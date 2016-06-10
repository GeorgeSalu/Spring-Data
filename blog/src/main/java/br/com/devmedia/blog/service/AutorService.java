package br.com.devmedia.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.devmedia.blog.entity.Autor;
import br.com.devmedia.blog.repository.AutorRepository;

@Service
@Transactional(readOnly=true,propagation=Propagation.REQUIRED)
public class AutorService {

	@Autowired
	private AutorRepository repository;
	
	@Transactional(readOnly=false)
	public void save(Autor autor){
		
		repository.save(autor);
	
	}
	
	public List<Autor> findAll(){
		return repository.findAll();
	}
	
	public Autor findByNome(String nome){
		return repository.findByNome(nome);
	}
	
	public Autor findById(Long id){
		return repository.findOne(id);
	}
	
}
