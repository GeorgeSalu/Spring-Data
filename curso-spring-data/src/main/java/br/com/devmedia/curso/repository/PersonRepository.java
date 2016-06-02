package br.com.devmedia.curso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.devmedia.curso.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

	//busca por lastName and Age between
	List<Person> findByLastNameAndAgeBetween(String lastName,int min,int max);
	
	//busca por age usando between
	List<Person> findByAgeBetween(int min,int max);
	
	//busca por age OR firstName via paramentro
	List<Person> findByAgeOrFirstName(Integer age,String firstName);
	
	//busca por firstName igual a paramentro
	Person findByFirstNameAndLastName(String firstName,String lastName);
	
	//busca por age igual ao parametro fornecido
	List<Person> findByAge(Integer age);
	
	//busca por age diferente do paramentro fornecido
	List<Person> findByAgeNot(Integer age);
	
	//busca por firstName igual ao paramentro
	List<Person> findByFirstNameLike(String firstName);
	
	//busca por firstName diferente do paramentro
	List<Person> findByFirstNameNotLike(String firstName);
}
