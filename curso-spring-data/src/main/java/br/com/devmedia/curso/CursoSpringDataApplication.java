package br.com.devmedia.curso;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;

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
		//testDelete();
		//testeSavePersons();
		//testDeletePersons();
		//testFindAndSort();
		//testFindByIds();
		//testExists();
		//testPagination();
		//testByAge();
		//testByFirstNameLike();
		//testbyAndOr();
		//testByBetween();
		//testByLastNameAndBetween();
		//testByGreaterAndLess();
		//testByGreaterAndLessEquals();
		//testByFirstNameGreaterThan();
		//testByStartAndEnd();
		//testByContaining();
		//testByAddressStratingAndEnding();
		//testByInAndNotIn();
		//testByOrderBy();
		testIgnoreCase();
		
	}

	private void testIgnoreCase() {

		List<Person> p1 = personRepository.findByFirstNameIgnoreCase("BRUna");
		p1.forEach(System.out::println);
	}

	private void testByOrderBy() {

		List<Address> p1 = addressRepository.findByCityOrderByTypeDesc("Rio de Janeiro");
		p1.forEach(System.out::println);
	}

	private void testByInAndNotIn() {

		List<Person> findByAgeIn = personRepository.findByAgeIn(24,28,30,40);
		findByAgeIn.forEach(System.out::println);
		
		System.out.println("----------------------------------------------------");
		
		List<Person> findByAgeNotIn = personRepository.findByAgeNotIn(24,28,30,40);
		findByAgeNotIn.forEach(System.out::println);
	}

	private void testByAddressStratingAndEnding() {

		List<Address> findByCityStartingWithOrStreetEndingWith = addressRepository.findByCityStartingWithOrStreetEndingWith("Rio", "102");
		findByCityStartingWithOrStreetEndingWith.forEach(System.out::println);
	}

	private void testByContaining() {

		List<Address> findByStreetContainig = addressRepository.findByStreetContaining("Ipanema");
		findByStreetContainig.forEach(System.out::println);
	}

	private void testByStartAndEnd() {

		List<Address> findByCityStartingWith = addressRepository.findByCityStartingWith("Rio");
		findByCityStartingWith.forEach(System.out::println);
		
		List<Address> findByStreetEndingWith = addressRepository.findByStreetEndingWith("1002");
		findByStreetEndingWith.forEach(System.out::println);
	}

	private void testByFirstNameGreaterThan() {

		List<Person> findByFirstNameGreaterThan = personRepository.findByFirstNameGreaterThan("Bruna");
		findByFirstNameGreaterThan.forEach(System.out::println);
	}

	private void testByGreaterAndLessEquals() {

		List<Person> findByAgeGreaterThan = personRepository.findByAgeGreaterThan(28);
		findByAgeGreaterThan.forEach(System.out::println);
		
		System.out.println("-----------------------------------------");
		
		List<Person> findByAgeLessThanEqual = personRepository.findByAgeLessThanEqual(28);
		findByAgeLessThanEqual.forEach(System.out::println);
	}

	private void testByGreaterAndLess() {

		List<Person> p1 = personRepository.findByAgeGreaterThan(28);
		p1.forEach(System.out::println);
		
		System.out.println("----------------------------------------------");
		
		List<Person> p2 = personRepository.findByAgeLessThan(28);
		p2.forEach(System.out::println);
		
	}

	private void testByLastNameAndBetween() {

		List<Person> findByLastNameAndAgeBetween = personRepository.findByLastNameAndAgeBetween("Figueira", 25, 35);
		findByLastNameAndAgeBetween.forEach(System.out::println);
	}

	private void testByBetween() {

		List<Person> findByAgeBetween = personRepository.findByAgeBetween(24, 29);
		findByAgeBetween.forEach(System.out::println);
	}

	private void testbyAndOr() {

		Person findByFirstNameAndLastName = personRepository.findByFirstNameAndLastName("Aline", "Gomes");
		System.out.println(findByFirstNameAndLastName.toString());
		
		List<Person> findByAgeOrFirstName = personRepository.findByAgeOrFirstName(29, "Bruna");
		findByAgeOrFirstName.forEach(System.out::println);
		
	}

	private void testByFirstNameLike() {

		List<Person> findByFirstNameLike = personRepository.findByFirstNameLike("Aline");
		findByFirstNameLike.forEach(System.out::println);
		
		System.out.println("----------------------------------------------------------");
		
		List<Person> findByFirstNameNotLike = personRepository.findByFirstNameNotLike("Aline");
		findByFirstNameNotLike.forEach(System.out::println);
	}

	private void testByAge() {

		List<Person> findByAge = personRepository.findByAge(29);
		findByAge.forEach(System.out::println);
		
		
		List<Person> findByAgeNot = personRepository.findByAgeNot(29);
		findByAgeNot.forEach(System.out::println);
	}

	private void testPagination() {

		Page<Person> pages = personRepository.findAll(new PageRequest(0,3));
		pages.getContent().forEach(System.out::println);

		pages = personRepository.findAll(new PageRequest(1,3));
		pages.getContent().forEach(System.out::println);
		
		
	}

	private void testExists() {

		boolean p1 = personRepository.exists(5L);
		
		System.out.println(" p1 is "+p1);
		
		boolean p2 = personRepository.exists(50L);
		
		System.out.println(" p2 is "+p2);
		
	}

	private void testFindByIds() {

		List<Person> persons = personRepository.findAll(Arrays.asList(1L,2L,4L));
		
		persons.forEach(System.out::println);
		
	}

	private void testFindAndSort() {

		Order orderAsc = new Order(Direction.ASC,"lastName");
		
		Order orderDesc = new Order(Direction.DESC,"firstName");
		
		Sort sort = new Sort(orderAsc,orderDesc);
		
		List<Person> persons = personRepository.findAll(sort);
		
		persons.forEach(System.out::println);
		
	}

	private void testDeletePersons() {

		Person p1 = personRepository.findOne(9L);
		Person p2 = personRepository.findOne(10L);
		Person p3 = personRepository.findOne(11L);
		
		personRepository.delete(Arrays.asList(p1,p2,p3));
		
		System.out.println("------------------------------------------------");
		
		Person p4 = personRepository.findOne(12L);
		Person p5 = personRepository.findOne(13L);
		Person p6 = personRepository.findOne(14L);
		
		personRepository.deleteInBatch(Arrays.asList(p4,p5,p6));
		
	}

	private void testeSavePersons() {

		Person p1 = new Person();
		p1.setFirstName("Alisson");
		p1.setLastName("Souza");
		p1.setAge(29);
		p1.setDocument(new Document("1299999988", "8887665555"));
		
		Person p2 = new Person();
		p2.setFirstName("Maria");
		p2.setLastName("Souza");
		p2.setAge(19);
		p2.setDocument(new Document("299999988", "887665555"));

		Person p3 = new Person();
		p3.setFirstName("Amanda");
		p3.setLastName("Souza");
		p3.setAge(30);
		p3.setDocument(new Document("1009999988", "8800665555"));
		
		Person p4 = new Person();
		p4.setFirstName("claudemir");
		p4.setLastName("Souza");
		p4.setAge(26);
		p4.setDocument(new Document("129999998898", "888766512555"));
		
		Person p5 = new Person();
		p5.setFirstName("denis");
		p5.setLastName("Souza");
		p5.setAge(23);
		p5.setDocument(new Document("1298889988", "885555"));
		
		
		Person p6 = new Person();
		p6.setFirstName("George");
		p6.setLastName("Souza");
		p6.setAge(20);
		p6.setDocument(new Document("1200009988", "88800065555"));
		
		
		List<Person> save = personRepository.save(Arrays.asList(p1,p2,p3,p4,p5,p6));
		
		save.forEach(System.out::println);
		
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
