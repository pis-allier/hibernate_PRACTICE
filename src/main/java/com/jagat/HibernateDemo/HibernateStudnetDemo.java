package com.jagat.HibernateDemo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "demo_hibernate")
public class HibernateStudnetDemo {

	@Id
	private int id;
	private String name;
	private String lastname;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public HibernateStudnetDemo(int id, String name, String lastname) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
	}

	public HibernateStudnetDemo() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "HibernateStudnetDemo [id=" + id + ", name=" + name + ", lastname=" + lastname + "]";
	}

}
