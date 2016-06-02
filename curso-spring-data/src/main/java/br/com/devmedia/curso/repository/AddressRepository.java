package br.com.devmedia.curso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.devmedia.curso.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

	//busca por city ou street conforme a igualdade da sequencia de caracteres
	List<Address> findByCityStartingWithOrStreetEndingWith(String city,String street);
	
	//busca por street conforme o paramentro conincida com qualquer parte da palavra
	List<Address> findByStreetContaining(String street);
	
	// busca por street conforme o termino da palavra
	List<Address> findByStreetEndingWith(String street);
	
	// busca por city comforme o inicio da palavra
	List<Address> findByCityStartingWith(String city);
	
}
