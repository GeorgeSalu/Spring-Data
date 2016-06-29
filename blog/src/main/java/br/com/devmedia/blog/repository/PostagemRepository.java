package br.com.devmedia.blog.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.devmedia.blog.entity.Postagem;

public interface PostagemRepository extends JpaRepository<Postagem,Long>{

	Postagem findByPermalink(String permalink);

	List<Postagem> findByCategoriasPermalink(String link);

	List<Postagem> findByAutorNome(String nome);
	
	Page<Postagem> findAllByOrderByDataPostagemDesc(Pageable pageable);

	Page<Postagem> findAllByCategoriasPermalinkOrderByDataPostagemDesc(Pageable pageable, String permalink);

	Page<Postagem> findAllByAutorIdOrderByDataPostagemDesc(Pageable pageable, Long id);

	Page<Postagem> findByTextoContainingIgnoreCaseOrderByDataPostagemDesc(String texto, Pageable pageable);

	Page<Postagem> findAllByTituloContainingIgnoreCaseOrderByDataPostagemDesc(Pageable pageable, String titulo);

	Page<Postagem> findAllByAutorIdAndTituloOrderByDataPostagemDesc(Pageable pageable, Long id, String titulo);
	
}
