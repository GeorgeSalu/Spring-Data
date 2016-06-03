package br.com.devmedia.curso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.devmedia.curso.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

	// busca por age e orderna por firstName [a-z] e se houver empate orderna por lastName
	List<Person> findByAgeGreaterThanOrderByFirstNameAscLastNameAsc(Integer age);
	
	// busca por number via phones mapeados em person
	List<Person> findByPhonesNumberStartingWith(String number);
	
	// busca por linhas em persons que não contenham o id_document iguais a null
	List<Person> findByDocumentIsNotNull();
	
	// busca por linhas em persons que tenham document_id iguais a null
	List<Person> findByDocumentIsNull();
	
	// busca por firstName ignorando lestras maiusculas e minusculas
	List<Person> findByFirstNameIgnoreCase(String firstName);
	
	// busca por age baseado em uma lista de paramentros que sera negada
	List<Person> findByAgeNotIn(Integer... ages);
	
	// busca por age baseado em uma lista de paramentros
	List<Person> findByAgeIn(Integer... ages);
	
	//busca por firstName maior que o valor informado
	List<Person> findByFirstNameGreaterThan(String firstName);
	
	// busca por age menor que e igual ao paramnetro
	List<Person> findByAgeLessThanEqual(Integer age);
	
	//busca por age maior que e igual ao paramentro
	List<Person> findByAgeGreaterThanEqual(Integer age);
	
	//busca por age menor que o paramentro
	List<Person> findByAgeLessThan(Integer age);
	
	// busca por age maior queo paramentro
	List<Person> findByAgeGreaterThan(Integer age);
	
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
