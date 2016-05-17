package br.com.devmedia.revjpa;

import br.com.devmedia.revjpa.dao.PersonDAO;
import br.com.devmedia.revjpa.entity.Person;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		//insertPerson();
		findPersonById();
		
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
