package ru.job4j.strategy;

public class Square implements Shape {
	
	public String draw() {
		 StringBuilder pic = new StringBuilder();
		    pic.append("+ + + +");
		    pic.append(System.lineSeparator());
		    pic.append("+     +");
		    pic.append(System.lineSeparator());
		    pic.append("+     +");
		    pic.append(System.lineSeparator());
		    pic.append("+ + + +");
		    pic.append(System.lineSeparator());
		    return pic.toString();
	}
}
