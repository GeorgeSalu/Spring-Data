package br.com.devmedia.curso;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

import br.com.devmedia.curso.entity.Person;
import br.com.devmedia.curso.repository.AddressRepository;
import br.com.devmedia.curso.repository.DocumentRepository;
import br.com.devmedia.curso.repository.PersonRepository;
import br.com.devmedia.curso.repository.PhoneRepository;

@SpringBootApplication
//@ImportResource(value="spring-data.xml")
public class CursoSpringDataApplication implements CommandLineRunner{

	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private DocumentRepository documentRepository;
	@Autowired
	private PhoneRepository phoneRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursoSpringDataApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
		long total = personRepository.count();
		System.out.println("Total of person "+total);
		
		List<Person> persons = personRepository.findAll();
		persons.forEach(System.out::println);

		long totalAddress = addressRepository.count();
		System.out.println("Total of person "+totalAddress);
		
		long totalPhone = phoneRepository.count();
		System.out.println("Total of person "+totalPhone);
		
		long totalDocument = documentRepository.count();
		System.out.println("Total of person "+totalDocument);
		
	}
}
