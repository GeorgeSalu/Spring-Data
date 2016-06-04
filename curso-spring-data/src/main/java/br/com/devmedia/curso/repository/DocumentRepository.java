package br.com.devmedia.curso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import br.com.devmedia.curso.entity.Document;

public interface DocumentRepository extends JpaRepository<Document, Long>{

	@Procedure(name="docs.procedureReplaceCPF")
	String procedureReplaceCPF(@Param("ID_IN") Long id);
	
	@Procedure(procedureName="procReplaceCPF")
	String replaceCPF(Long id);
	
	@Query("select d from Document d where d.cpf like :start%")
	List<Document> findByCPFStartingWith(@Param("start") String start);
	
}
