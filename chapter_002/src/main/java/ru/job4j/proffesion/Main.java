package ru.job4j.profesion;

import ru.job4j.classes.*;

public class Main{
	public static void main(String[] args){
		Teacher ivanov = new Teacher("Семён Семёнович", 'M', "История", 3);
		Quality good = new Quality("хороший подчерк");
		Student petrov = new Student("Петров", 3);
		Knowledge knowledge = new Knowledge();
		knowledge = ivanov.teach(ivanov, petrov);
		System.out.println(knowledge.getTeach());
		Mood ivanovMood = new Mood();
		ivanovMood = ivanov.checkHomework(ivanov, 15, good);
		System.out.println(ivanovMood.getMood());
	}
}