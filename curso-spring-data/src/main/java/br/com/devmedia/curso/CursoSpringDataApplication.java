package br.com.devmedia.curso;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

import br.com.devmedia.curso.entity.Address;
import br.com.devmedia.curso.entity.Document;
import br.com.devmedia.curso.entity.Person;
import br.com.devmedia.curso.entity.Phone;
import br.com.devmedia.curso.entity.Address.TypeAddress;
import br.com.devmedia.curso.entity.Phone.TypePhone;
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

		//testConfiguration();
		//testSave();
		//testUpdate();
		testDelete();
		
	}

	private void testDelete() {

		personRepository.delete(9L);
		
	}

	private void testUpdate() {

		Person person = personRepository.findOne(9L);
		
		System.out.println(person.toString());
		
		person.setLastName("Aguiar");
		
		personRepository.save(person);
		
		Person p2 = personRepository.findOne(9L);
		
		System.out.println(p2.toString());
		
	}

	private void testSave() {

		Person person = new Person();
		person.setFirstName("Joao Luiz");
		person.setLastName("Rios");
		person.setAge(35);
		person.setDocument(new Document("123986655555", "2223333333"));
		
		Address address = new Address();
		address.setCity("Manaus");
		address.setStreet("Rua das Valquirias, 32");
		address.setType(TypeAddress.RESIDENCIAL);
		
		person.setAddresses(Arrays.asList(address));
		person.addPhone(new Phone(TypePhone.RESIDENCIAL, "8777666666"));
		
		personRepository.save(person);
		
		Person p2 = personRepository.findOne(person.getId());
		
		System.out.println(p2.toString());
		
	}

	private void testConfiguration() {
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
