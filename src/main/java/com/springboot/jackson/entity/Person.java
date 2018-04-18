package com.springboot.jackson.entity;

import java.time.LocalDate;

import com.springboot.jackson.selfenum.SexEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

	private String name;
	private Integer age;
	private SexEnum sex;
	private LocalDate birthDate;
	
}
