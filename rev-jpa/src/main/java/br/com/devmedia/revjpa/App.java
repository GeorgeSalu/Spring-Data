package br.com.devmedia.revjpa;

import java.util.List;

import org.hibernate.dialect.PointbaseDialect;

import br.com.devmedia.revjpa.dao.DocumentDAO;
import br.com.devmedia.revjpa.dao.PersonDAO;
import br.com.devmedia.revjpa.dao.PhoneDAO;
import br.com.devmedia.revjpa.entity.Document;
import br.com.devmedia.revjpa.entity.Person;
import br.com.devmedia.revjpa.entity.Phone;
import br.com.devmedia.revjpa.entity.Phone.TypePhone;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		//insertPerson();
		//findPersonById();
		//countPerson();
		//findByLastName();
		//findByAge();
		//findByFullName();
		//updatePerson();
		//deletePerson();
		//insertDocument();
		//updateDocument();
		//findPersonByCpf();
		insertPhone();
	}

	private static void insertPhone() {

		Person person = new Person();
		person.setFirstName("Gilson");
		person.setLastName("Figueira");
		person.setAge(28);
		person.setDocument(new Document("145.256.365-98", "10000000000"));

		Phone phone = new Phone(TypePhone.CELULAR, "999999999");
		phone.setPerson(person);
		
		PhoneDAO dao = new PhoneDAO();
		
		dao.save(phone);
		
		phone = dao.findById(phone.getId());
		
		System.out.println(phone.toString());
		
	}

	private static void findPersonByCpf() {

		Person p = new PersonDAO().findByCpf("123.456.789-99");
		
		System.out.println(p.toString());
		
	}

	private static void updateDocument() {

		Document doc = new DocumentDAO().findById(1L);
		
		System.out.println(doc.toString());
		
		doc.setCpf("123.456.789-99");
		
		new DocumentDAO().update(doc);
		
		System.out.println(new DocumentDAO().findById(1L).toString());
		
	}

	private static void insertDocument() {
		
		Person p1 = new Person();
		p1.setFirstName("Aline");
		p1.setLastName("De Souza");
		p1.setAge(24);
		p1.setDocument(new Document("123+456.789-99", "123456789"));
		
		new PersonDAO().save(p1);
		
		System.out.println(p1.toString());
		
		
	}

	private static void deletePerson() {

		new PersonDAO().delete(3L);
		
	}

	private static void updatePerson() {

		Person p1 = new PersonDAO().findById(3L);
		
		System.out.println(p1.toString());
		
		p1.setLastName("de souza");
		
		new PersonDAO().update(p1);
		
		Person p2 = new PersonDAO().findById(3L);
		
		System.out.println(p2.toString());
		
	}

	private static void findByFullName() {

		Person person = new PersonDAO().findByFullName("Bruna", "Figueira");
		
		System.out.println(person.toString());	
		
	}

	private static void findByAge() {
		
		List<Person> persons = new PersonDAO().findByAgeIsBetween(20, 40);
		
		for(Person person : persons){
			System.out.println(person.toString());
		}
		
	}

	private static void findByLastName() {

		List<Person> persons = new PersonDAO().findByLastName("da silva");
		
		for(Person person : persons){
			System.out.println(person.toString());
		}
		
	}

	private static void countPerson() {
		
		long total = new PersonDAO().count();
		
		System.out.println("Total Person : "+total);
		
	}

	private static void findPersonById() {

		Person p1 = new PersonDAO().findById(2L);
		
		Person p2 = new PersonDAO().findById(3L);
		
		System.out.println(p1);
		System.out.println(p2);
		
	}

	private static void insertPerson() {

		Person p1 = new Person();
		p1.setFirstName("Ana Maria");
		p1.setLastName("da silva");
		p1.setAge(29);
		
		new PersonDAO().save(p1);
		
		System.out.println(p1.toString());
		
		Person p2 = new Person();
		p2.setFirstName("Bruna");
		p2.setLastName("Figueira");
		p2.setAge(30);
		
		new PersonDAO().save(p2);
		
		System.out.println(p2.toString());
		
		Person p3 = new Person();
		p3.setFirstName("Carlos");
		p3.setLastName("da silva");
		p3.setAge(40);
		
		new PersonDAO().save(p3);
		
		System.out.println(p3.toString());
		
	}
}
