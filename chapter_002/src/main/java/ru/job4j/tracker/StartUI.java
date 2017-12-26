package ru.job4j.tracker;

/**
 * Class StartUI.
 * @author Shaev Andrey.
 * @version 1.01.
 * @since 22.12.2012
*/

public class StartUI {
    
    private static final String ADD = "0";
	private static final String GETALL = "1";
	private static final String EDIT = "2";
	private static final String DELETE = "3";
	private static final String FINDBYID = "4";
	private static final String FINDBYNAME = "5";
    private static final String EXIT = "6";
    private final Input input;
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            switch (answer) {
					case ADD: this.createItem();
							 break;
					case GETALL: this.showAll();
							 break;
					case EDIT:this.editItem();
							 break;		
					case DELETE: this.deleteItem();
							 break;
					case FINDBYID: this.findItemById();
							 break;
					case FINDBYNAME: this.findItemByName();
							 break;
					case EXIT: exit = true;
							 break;		
					default: System.out.println("Нет такого пункта в меню, введите ещё раз");
			}
		}
    }

    /**
     * Метод реализует добавление новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с Id : " + item.getId() + "-----------");
    }
	
	/**
     * Метод реализует удаление заявки из хранилища.
     */
	private void deleteItem() {
		String id = this.input.ask("Введите id заявки :");
		this.tracker.delete(id);
	}
	
	/**
     * Метод показывающий все заявки в хранилище.
     */
	private void showAll() {
		Item[] items = this.tracker.getAll();
		for (Item item:items) {
			System.out.println("Имя заявки: " + item.getName());	
			System.out.println("Описание заявки: " + item.getDesc());
		}
	}
	
	/**
     * Метод реализует редактирование заявки в хранилище.
     */
	private void editItem() {
		String id = this.input.ask("Введите id заявки :");
		this.tracker.findById(id).setName(this.input.ask("Введите новое имя :"));
		this.tracker.findById(id).setDesc(this.input.ask("Введите новое описание :"));
	}
	
	/**
     * Метод реализует поиск заявки по ID.
     */
	private void findItemById() {
		String id = this.input.ask("Введите id заявки :");
		System.out.println("имя заявки: " + this.tracker.findById(id).getName());
		System.out.println("описание заявки: " + this.tracker.findById(id).getDesc());
	}
	
	/**
     * Метод реализует поиск заявок по ключевому слову в имени.
     */
	private void findItemByName() {
		String key = this.input.ask("Введите имя заявки :");
		Item[] items = new Item[this.tracker.findByName(key).length];
		items = this.tracker.findByName(key);
		for (Item item:items) {
			System.out.println("имя заявки: " + item.getName());
			System.out.println("описание заявки: " + item.getDesc());
		}
	}

    private void showMenu() {
        System.out.println("Меню.");
		System.out.println("0. Add new Item");
		System.out.println("1. Show all items");
		System.out.println("2. Edit item");
		System.out.println("3. Delete item");
		System.out.println("4. Find item by Id");
		System.out.println("5. Find items by name");
		System.out.println("6. Exit Program");
		System.out.println("Select:");
    }

    /**
     * Запускт программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
	}
}