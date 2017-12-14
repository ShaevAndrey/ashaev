package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class TrackerTest служит для тестирвания методов класса Tracker.
 * @author Shaev Andrey.
 * @version 1.01.
 * @since 13.12.17.
*/
public class TrackerTest {
	
	 /**
     * Тест метода добавления новой заявки.
     */
	@Test
	public void whenAddNewItemThenTrackerHasSameItem() {
	Tracker tracker = new Tracker();
	Item item = new Item("test1", "testDescription", 123L);
	tracker.add(item);
	assertThat(tracker.getAll()[0], is(item));
	}
	
	 /**
     * Тест метода замены заявки.
     */
	@Test
	public void whenReplaceNameThenReturnNewName() {
    Tracker tracker = new Tracker();
    Item previous = new Item("test1", "testDescription", 123L);
    // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
    tracker.add(previous);
    // Создаем новую заявку.
    Item next = new Item("test2", "testDescription2", 1234L);
    // Проставляем старый id из previous, который был сгенерирован выше.
    next.setId(previous.getId());
    // Обновляем заявку в трекере.
    tracker.replace(previous.getId(), next);
    // Проверяем, что заявка с таким id имеет новые имя test2.
    assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
	}
	
	 /**
     * Тест метода удаления заявки.
     */
	@Test
	public void whenDeleteItemThenNextItemStandPreviousPosition() {
	Tracker tracker = new Tracker();	
	Item item0 = new Item("test0", "testDescription", 123L);
	Item item1 = new Item("test1", "testDescription", 1234L);
	Item item2 = new Item("test2", "testDescription", 1235L);
	tracker.add(item0);
	tracker.add(item1);
	tracker.add(item2);
	tracker.delete(item1.getId());
	//Item[] result = tracker.getAll();
	assertThat(tracker.getAll()[1].getName(), is("test2"));
	}
	
	 /**
     * Тест поиска заявки по id.
     */
	@Test
	public void whenFindByIdThenBackItemWithThisId() {
		Tracker tracker = new Tracker();	
	Item item0 = new Item("test0", "testDescription", 123L);
	Item item1 = new Item("test1", "testDescription", 1234L);
	tracker.add(item0);
	tracker.add(item1);
	assertThat((tracker.findById(item0.getId()).getName()), is("test0"));
	}
	
	 /**
     * Тест поиска по ключевому слову в имени.
     */
	@Test
	public void whenFindByKeyStThenBackTwoItems() {
	Tracker tracker = new Tracker();	
	Item item0 = new Item("test0", "testDescription", 123L);
	Item item1 = new Item("tes1", "testDescription", 1234L);
	Item item2 = new Item("test2", "testDescription", 1235L);
	tracker.add(item0);
	tracker.add(item1);
	tracker.add(item2);	
	assertThat(tracker.findByName("st").length, is(2));
	}
	
	 /**
     * тест метода возврата всех заявок.
     */
	@Test
	public void whenAddTreeItemsThenGetAllReturnArrayLengthTree() {
	Tracker tracker = new Tracker();	
	Item item0 = new Item("test0", "testDescription", 123L);
	Item item1 = new Item("tes1", "testDescription", 1234L);
	Item item2 = new Item("test2", "testDescription", 1235L);
	tracker.add(item0);
	tracker.add(item1);
	tracker.add(item2);	
	assertThat(tracker.getAll().length, is(3));
	}
}