package ru.job4j.tracker;


/**
 * Class MenuTacker Служит для обработки заявок по командам пользователя.
 * @author Shaev Andrey.
 * @version 1.01.
 * @since 10.01.2018
*/
public class MenuTracker {
	private UserAction[] action = new UserAction[6];
	private Tracker tracker;
	private Input input;
	
	public int getRange(){
		return this.action.length;
	}
	public MenuTracker(Input input, Tracker tracker) {
		this.input = input;
		this.tracker = tracker;
	}
	
	public void fillActions() {
		this.action[0] = new AddItem();
		this.action[1] = new GetAll();
		this.action[2] = new MenuTracker.Edit();
		this.action[3] = new MenuTracker.Delete();
		this.action[4] = new FindById();
		this.action[5] = new FindByName();
	}
	
	public void show() {
		for (UserAction action : this.action) {
				System.out.println(action.info());
		}
	}
	
	public void select(int key) {
		this.action[key].execute(this.input, this.tracker);
	}
	
	/**
	 * Class AddItem Реализует добавление заявки.
	 * @author Shaev Andrey.
	 * @version 1.01.
	 * @since 10.01.2018
	*/
	private class AddItem implements UserAction {
		public int key() {
			return 0;
		}

		public void execute(Input input, Tracker tracker) {
			String name = input.ask("Enter the name");
			String desc = input.ask("Enter the description");
			Item item = new Item(name, desc);
			tracker.add(item);
			System.out.println("Новая заявка с Id : " + item.getId());
		}

		public String info() {
			return String.format("%s. %s", this.key(), "Add new item.");		
		}
	}
	
	/**
	 * Class GetAll Реализует вызов списка заявок.
	 * @author Shaev Andrey.
	 * @version 1.01.
	 * @since 10.01.2018
	*/
	private class GetAll implements UserAction {
		public int key() {
			return 1;
		}

		public void execute(Input input, Tracker tracker) {
			Item[] items = tracker.getAll();
			for (Item item:items) {
				System.out.println("Имя заявки: " + item.getName());	
				System.out.println("Описание заявки: " + item.getDesc());
			}
		}

		public String info() {
			return String.format("%s. %s", this.key(), "Show all item.");
		}
	}
	
	/**
	 * Class Edit Реализует редактирование заявки.
	 * @author Shaev Andrey.
	 * @version 1.01.
	 * @since 10.01.2018
	*/
	private static class Edit implements UserAction {
		public int key() {
			return 2;
		}

		public void execute(Input input, Tracker tracker) {
			String id = input.ask("Введите id заявки :");
			tracker.findById(id).setName(input.ask("Введите новое имя :"));
			tracker.findById(id).setDesc(input.ask("Введите новое описание :"));
		}

		public String info() {
			return String.format("%s. %s", this.key(), "Edit item.");
		}
	}
	
	/**
	 * Class Delete Реализует удаление заявки.
	 * @author Shaev Andrey.
	 * @version 1.01.
	 * @since 10.01.2018
	*/
	private static class Delete implements UserAction {
		public int key() {
			return 3;
		}

		public void execute(Input input, Tracker tracker) {
			String id = input.ask("Введите id заявки :");
			tracker.delete(id);
		}

		public String info() {
			return String.format("%s. %s", this.key(), "Delete item.");
		}
	}
}

/**
 * Class FindById Реализует поиск заявки по id.
 * @author Shaev Andrey.
 * @version 1.01.
 * @since 10.01.2018
*/
class FindById implements UserAction {
	public int key() {
		return 4;
	}

	public void execute(Input input, Tracker tracker) {
		String id = input.ask("Введите id заявки :");
		System.out.println("имя заявки: " + tracker.findById(id).getName());
		System.out.println("описание заявки: " + tracker.findById(id).getDesc());
	}

	public String info() {
		return String.format("%s. %s", this.key(), "Find item by id.");
	}
}

/**
 * Class FindByName Реализует поиск заявки по имени.
 * @author Shaev Andrey.
 * @version 1.01.
 * @since 10.01.2018
*/
class FindByName implements UserAction {
	public int key() {
		return 5;
	}

	public void execute(Input input, Tracker tracker) {
		String key = input.ask("Введите имя заявки :");
		Item[] items = new Item[tracker.findByName(key).length];
		items = tracker.findByName(key);
		for (Item item:items) {
			System.out.println("имя заявки: " + item.getName());
			System.out.println("описание заявки: " + item.getDesc());
		}
	}
	public String info() {
		return String.format("%s. %s", this.key(), "Find item by name.");
	}
}
