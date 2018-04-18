package com.springboot.jackson.util;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.springboot.jackson.entity.Person;
import com.springboot.jackson.selfenum.SexEnum;
import com.springboot.jackson.utils.JacksonUtil;


public class JacksonUtilTest {

	@Test
	public void shouldSerializePerson() {
		Person person = new Person();
		person.setName("Roger");
		person.setAge(18);
		person.setSex(SexEnum.MAN);
		
		System.out.println(JacksonUtil.serialize(person));
		
		List<Person> persons = new ArrayList<>();
		persons.add(person);
		System.out.println(JacksonUtil.serialize(persons));
		
	}
}
