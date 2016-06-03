package br.com.devmedia.curso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.devmedia.curso.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

	@Query(
			nativeQuery=true,
			value="select funcConcatAddress(?1)"
	)
	String functionNativeQueryConcatenaEndereco(Long id);
	
	@Query(
			nativeQuery=true,
			value="select * from addresses where city like ?1 and street like ?2"
	)
	Address buscaPorCidadeRua(String city,String street);
	
	// usando @namedNativeQueries
	Address buscaPorEndereco(String city,String street);
	
	//usando @NamedQuery na entidade
	List<Address> buscaPorCidade(String cidade);
	
	// busca por city e ordena por type de forma descendente
	List<Address> findByCityOrderByTypeDesc(String city);
	
	//busca por city ou street conforme a igualdade da sequencia de caracteres
	List<Address> findByCityStartingWithOrStreetEndingWith(String city,String street);
	
	//busca por street conforme o paramentro conincida com qualquer parte da palavra
	List<Address> findByStreetContaining(String street);
	
	// busca por street conforme o termino da palavra
	List<Address> findByStreetEndingWith(String street);
	
	// busca por city comforme o inicio da palavra
	List<Address> findByCityStartingWith(String city);
	
}
