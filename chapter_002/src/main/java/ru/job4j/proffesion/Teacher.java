package ru.job4j.profesion;

import ru.job4j.classes.*;

public class Teacher extends Profesion {
	
	public char sex;
	public String schoolSubject;
	public int tolerance;
	
	public Teacher() {
		
	}
	public Teacher(String name, char sex, String schoolSubject, int tolerance) {
		this.name = name;
		this.sex = sex;
		this.schoolSubject = schoolSubject;
		this.tolerance = tolerance;
	}
	
	public Knowledge teach(Teacher teacher, Student student){
		
		Knowledge knowledge = new Knowledge(teacher.getName() + " научил студента " + student.getName());
		return knowledge;
	}
	
	public Mood checkHomework(Teacher teacher, int count, Quality handwriting){
	
		if (count < 10) {
			Mood mood= new Mood(teacher.getName() + " проверил " + count + " работ, написанных " + handwriting.getHandwriting() + " и у него хорошее настроение");
			return mood;
		} else {
			Mood mood= new Mood(teacher.getName() + " проверил " + count + " работ, написанных " + handwriting.getHandwriting() + " и у него плохое настроение");
			return mood;
		}
		
	}
}