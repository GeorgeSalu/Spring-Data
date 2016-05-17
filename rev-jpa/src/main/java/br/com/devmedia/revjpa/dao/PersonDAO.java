package br.com.devmedia.revjpa.dao;

import br.com.devmedia.revjpa.entity.Person;

public class PersonDAO extends GenericDAO<Person>{

	public PersonDAO() {
		super(Person.class);
	}

}
