package com.jagat.HibernateDemo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "alien_table")
public class Alien {

	@Id
	private int id;
	private AlienName name;
	private String color;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public AlienName getName() {
		return name;
	}

	public void setName(AlienName name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Alien(int id, AlienName name, String color) {
		super();
		this.id = id;
		this.name = name;
		this.color = color;
	}

	public Alien() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Alien [id=" + id + ", color=" + color + "]";
	}

}
