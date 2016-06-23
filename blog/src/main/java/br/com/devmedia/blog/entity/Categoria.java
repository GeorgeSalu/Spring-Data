package br.com.devmedia.blog.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "categoria")
public class Categoria extends AbstractPersistable<Long> {

	@NotBlank
	@Length(max=30,min=3)
	@Column(nullable = false, unique = true, length = 30)
	private String descricao;

	@Column(nullable = false, unique = true, length = 30)
	private String permalink;

	@ManyToMany
	@JoinTable(
			name = "postagens_has_categoria", 
			joinColumns = @JoinColumn(name = "categoria_id") ,
			inverseJoinColumns = @JoinColumn(name = "postagem_id")
	)
	private List<Postagem> postagens;
	
	@Override
	public void setId(Long id) {
		super.setId(id);
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getPermalink() {
		return permalink;
	}

	public void setPermalink(String permalink) {
		this.permalink = permalink;
	}

	public List<Postagem> getPostagens() {
		return postagens;
	}

	public void setPostagens(List<Postagem> postagens) {
		this.postagens = postagens;
	}

}
