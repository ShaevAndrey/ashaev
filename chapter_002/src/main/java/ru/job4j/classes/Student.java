package ru.job4j.classes;

public class Student {
	public String name;
	public int rating;

	public Student(String name, int rating){
		this.name = name;
		this.rating = rating;
	}
	
	public String getName(){
		return this.name;
	}
	
	public int getRating(){
		return this.rating;
	}
}