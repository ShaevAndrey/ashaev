package ru.job4j.tracker;

/**
 * Class StartUINew работа с трекером при помощи внутренних классов.
 * @author Shaev Andrey.
 * @version 1.01.
 * @since 10.01.2018
*/
public class StartUINew {
	
	 private final Input input;
	 
	 public StartUINew(Input input) {
	        this.input = input;
	 }
	 
/**
* Основой цикл программы.
*/
	public void init() {
			Tracker tracker = new Tracker();
			do {
	    	MenuTracker menu = new MenuTracker(this.input, tracker);
	    	menu.fillActions();
	    	menu.show();
	    	menu.select(this.input.ask("Select:", menu.getRange()));
	    } while (!"y".equals(this.input.ask("Exit (y)")));
	}
	
	public static void main(String[] args) {
	        new StartUINew(new ValidateInput()).init();
		} 
}
