package br.com.devmedia.curso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.devmedia.curso.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

	//busca por age igual ao parametro fornecido
	List<Person> findByAge(Integer age);
	
	//busca por age diferente do paramentro fornecido
	List<Person> findByAgeNot(Integer age);
	
	//busca por firstName igual ao paramentro
	List<Person> findByFirstNameLike(String firstName);
	
	//busca por firstName diferente do paramentro
	List<Person> findByFirstNameNotLike(String firstName);
}
