package ru.job4j.classes;

public class Mood {
	public String mood;
	public Mood(){
		
	}
	public Mood(String data){
		this.mood = data;
	}	
	public String getMood(){
		return this.mood;
	}
}