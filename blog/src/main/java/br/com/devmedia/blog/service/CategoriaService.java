package br.com.devmedia.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.devmedia.blog.entity.Categoria;
import br.com.devmedia.blog.repository.CategoriaRepository;
import br.com.devmedia.blog.util.MyReplaceString;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;
	
	public List<Categoria> findAll() {
		
		return repository.findAll();
	}
	
	public Categoria findByDescricao(String descricao){
		
		return repository.findByDescricao(descricao);
	}
	
	public Categoria findById(Long id){
		
		return repository.findOne(id);
	}
	
	@Transactional(readOnly=false)
	public void delete(Long id){
		repository.delete(id);
	}
	
	@Transactional(readOnly=false)
	public void saveOrUpdate(Categoria categoria){
		
		String permalink = MyReplaceString.formatarPermalink(categoria.getDescricao());
		
		categoria.setPermalink(permalink);
		
		repository.save(categoria);
		
	}
	
}
