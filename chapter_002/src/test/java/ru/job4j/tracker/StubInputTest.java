package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class StubInputTest служит для тестирвания программы Tracker.
 * @author Shaev Andrey.
 * @version 1.01.
 * @since 22.12.2012
*/
public class StubInputTest {
	private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
	Tracker tracker = new Tracker();
	
    @Before
    public void loadOutput() {
		
        System.out.println("execute before method");
        
		System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }
	
@Test
public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
   //создаём StubInput с последовательностью действий
   Input input = new StubInput(new String[]{"0", "test1 name", "desc", "6"});   
   //   создаём StartUI и вызываем метод init()
   new StartUI(input, tracker).init();     
   // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
   assertThat(tracker.getAll()[0].getName(), is("test1 name")); 
}

@Test
 public void whenUpdateThenTrackerHasUpdatedValue() {
    //Напрямую добавляем заявку
    Item item = tracker.add(new Item());
    //создаём StubInput с последовательностью действий
    Input input = new StubInput(new String[]{"2", item.getId(), "test name", "desc", "6"});
    // создаём StartUI и вызываем метод init()
    new StartUI(input, tracker).init();
    // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    assertThat(tracker.findById(item.getId()).getName(), is("test name"));
 }
 
 @Test
 public void whenDeleteThenTrackerHasDeleteItem() {
    //Напрямую добавляем заявку
    Item item = tracker.add(new Item("Name1", "desc1"));
	//создаём StubInput с последовательностью действий
    Input input = new StubInput(new String[]{"0", "name2", "desc2", "3", item.getId(), "6"});
    // создаём StartUI и вызываем метод init()
    new StartUI(input, tracker).init();
    // проверяем, что нулевой элемент массива в трекере содержит имя, принадлежащее второму элементу.
    assertThat(tracker.getAll()[0].getName(), is("name2"));
 }
 
 @Test
 public void whenFindItemByNameThenShowNameAndDesc() {
	Item item = tracker.add(new Item("Name1", "desc1"));
	Item item1 = tracker.add(new Item("Kate", "3"));
	Item item2 = tracker.add(new Item("Kristi", "2,5"));
	Item item3 = tracker.add(new Item("Karmen", "1"));
    Input input = new StubInput(new String[]{"5", "ist", "6"});
    // создаём StartUI и вызываем метод init()
    new StartUI(input, tracker).init();
	assertThat(new String(out.toByteArray()), is(new StringBuilder()
																	.append("Меню.")
																	.append(System.lineSeparator())
																	.append("0. Add new Item")
																	.append(System.lineSeparator())
																	.append("1. Show all items")
																	.append(System.lineSeparator())
																	.append("2. Edit item")
																	.append(System.lineSeparator())
																	.append("3. Delete item")
																	.append(System.lineSeparator())
																	.append("4. Find item by Id")
																	.append(System.lineSeparator())
																	.append("5. Find items by name")
																	.append(System.lineSeparator())
																	.append("6. Exit Program")
																	.append(System.lineSeparator())
																	.append("Select:")
																	.append(System.lineSeparator())
																	.append("Введите пункт меню : ")
																	.append(System.lineSeparator())
																	.append("5")
																	.append(System.lineSeparator())
																	.append("Введите имя заявки :")
																	.append(System.lineSeparator())
																	.append("ist")
																	.append(System.lineSeparator())
																	.append("имя заявки: Kristi")
																	.append(System.lineSeparator())
																	.append("описание заявки: 2,5")
																	.append(System.lineSeparator())
																	.append("Меню.")
																	.append(System.lineSeparator())
																	.append("0. Add new Item")
																	.append(System.lineSeparator())
																	.append("1. Show all items")
																	.append(System.lineSeparator())
																	.append("2. Edit item")
																	.append(System.lineSeparator())
																	.append("3. Delete item")
																	.append(System.lineSeparator())
																	.append("4. Find item by Id")
																	.append(System.lineSeparator())
																	.append("5. Find items by name")
																	.append(System.lineSeparator())
																	.append("6. Exit Program")
																	.append(System.lineSeparator())
																	.append("Select:")
																	.append(System.lineSeparator())
																	.append("Введите пункт меню : ")
																	.append(System.lineSeparator())
																	.append("6")
																	.append(System.lineSeparator())
																	.toString()));
																		
	}

@Test
 public void whenSelectShowAllItemsThenShowAllItems() {
	Item item = tracker.add(new Item("Name1", "desc1"));
	Item item1 = tracker.add(new Item("Kate", "3"));
	Input input = new StubInput(new String[]{"1", "6"});
    // создаём StartUI и вызываем метод init()
    new StartUI(input, tracker).init();
	assertThat(new String(out.toByteArray()), is(new StringBuilder()
																	.append("Меню.")
																	.append(System.lineSeparator())
																	.append("0. Add new Item")
																	.append(System.lineSeparator())
																	.append("1. Show all items")
																	.append(System.lineSeparator())
																	.append("2. Edit item")
																	.append(System.lineSeparator())
																	.append("3. Delete item")
																	.append(System.lineSeparator())
																	.append("4. Find item by Id")
																	.append(System.lineSeparator())
																	.append("5. Find items by name")
																	.append(System.lineSeparator())
																	.append("6. Exit Program")
																	.append(System.lineSeparator())
																	.append("Select:")
																	.append(System.lineSeparator())
																	.append("Введите пункт меню : ")
																	.append(System.lineSeparator())
																	.append("1")
																	.append(System.lineSeparator())
																	.append("Имя заявки: Name1")
																	.append(System.lineSeparator())
																	.append("Описание заявки: desc1")
																	.append(System.lineSeparator())
																	.append("Имя заявки: Kate")
																	.append(System.lineSeparator())
																	.append("Описание заявки: 3")
																	.append(System.lineSeparator())
																	.append("Меню.")
																	.append(System.lineSeparator())
																	.append("0. Add new Item")
																	.append(System.lineSeparator())
																	.append("1. Show all items")
																	.append(System.lineSeparator())
																	.append("2. Edit item")
																	.append(System.lineSeparator())
																	.append("3. Delete item")
																	.append(System.lineSeparator())
																	.append("4. Find item by Id")
																	.append(System.lineSeparator())
																	.append("5. Find items by name")
																	.append(System.lineSeparator())
																	.append("6. Exit Program")
																	.append(System.lineSeparator())
																	.append("Select:")
																	.append(System.lineSeparator())
																	.append("Введите пункт меню : ")
																	.append(System.lineSeparator())
																	.append("6")
																	.append(System.lineSeparator())
																	.toString()));
																		
	}	

	@Test
 public void whenFindItemBIdThenShowNameAndDesc() {
	Item item = tracker.add(new Item("Name1", "desc1"));
	Input input = new StubInput(new String[]{"4", item.getId(), "6"});
    // создаём StartUI и вызываем метод init()
    new StartUI(input, tracker).init();
	assertThat(new String(out.toByteArray()), is(new StringBuilder()
																	.append("Меню.")
																	.append(System.lineSeparator())
																	.append("0. Add new Item")
																	.append(System.lineSeparator())
																	.append("1. Show all items")
																	.append(System.lineSeparator())
																	.append("2. Edit item")
																	.append(System.lineSeparator())
																	.append("3. Delete item")
																	.append(System.lineSeparator())
																	.append("4. Find item by Id")
																	.append(System.lineSeparator())
																	.append("5. Find items by name")
																	.append(System.lineSeparator())
																	.append("6. Exit Program")
																	.append(System.lineSeparator())
																	.append("Select:")
																	.append(System.lineSeparator())
																	.append("Введите пункт меню : ")
																	.append(System.lineSeparator())
																	.append("4")
																	.append(System.lineSeparator())
																	.append("Введите id заявки :")
																	.append(System.lineSeparator())
																	.append(item.getId())
																	.append(System.lineSeparator())
																	.append("имя заявки: Name1")
																	.append(System.lineSeparator())
																	.append("описание заявки: desc1")
																	.append(System.lineSeparator())
																	.append("Меню.")
																	.append(System.lineSeparator())
																	.append("0. Add new Item")
																	.append(System.lineSeparator())
																	.append("1. Show all items")
																	.append(System.lineSeparator())
																	.append("2. Edit item")
																	.append(System.lineSeparator())
																	.append("3. Delete item")
																	.append(System.lineSeparator())
																	.append("4. Find item by Id")
																	.append(System.lineSeparator())
																	.append("5. Find items by name")
																	.append(System.lineSeparator())
																	.append("6. Exit Program")
																	.append(System.lineSeparator())
																	.append("Select:")
																	.append(System.lineSeparator())
																	.append("Введите пункт меню : ")
																	.append(System.lineSeparator())
																	.append("6")
																	.append(System.lineSeparator())
																	.toString()));
																		
	}
}