package ru.job4j.tracker;

/**
 * Class StubInput служит для тестирвания программы Tracker.
 * @author Shaev Andrey.
 * @version 1.01.
 * @since 22.12.2012
*/

public class StubInput implements Input {
	
	private String[] answers;
	private int position = 0;
	
	public StubInput(String[] answers) {
		this.answers = answers;
	}
	
	public String ask(String quation) {
		System.out.println(quation);
		System.out.println(answers[position]);
		return answers[position++];
	}
}