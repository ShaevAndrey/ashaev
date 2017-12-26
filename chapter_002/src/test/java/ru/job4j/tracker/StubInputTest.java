package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class StubInputTest служит для тестирвания программы Tracker.
 * @author Shaev Andrey.
 * @version 1.01.
 * @since 22.12.2012
*/
public class StubInputTest {
	
@Test
public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
   // создаём Tracker
   Tracker tracker = new Tracker();  
   //создаём StubInput с последовательностью действий
   Input input = new StubInput(new String[]{"0", "test1 name", "desc", "6"});   
   //   создаём StartUI и вызываем метод init()
   new StartUI(input, tracker).init();     
   // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
   assertThat(tracker.getAll()[0].getName(), is("test1 name")); 
}

@Test
 public void whenUpdateThenTrackerHasUpdatedValue() {
    // создаём Tracker
    Tracker tracker = new Tracker();
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
    // создаём Tracker
    Tracker tracker = new Tracker();
    //Напрямую добавляем заявку
    Item item = tracker.add(new Item("Name1", "desc1"));
	//создаём StubInput с последовательностью действий
    Input input = new StubInput(new String[]{"0", "name2", "desc2", "3", item.getId(), "6"});
    // создаём StartUI и вызываем метод init()
    new StartUI(input, tracker).init();
    // проверяем, что нулевой элемент массива в трекере содержит имя, принадлежащее второму элементу.
    assertThat(tracker.getAll()[0].getName(), is("name2"));
 }
}