package ru.job4j.tracker;

import java.util.*;
import java.util.Arrays;

/**
 * Class Tracker создаёт и хранит список заявок.
 * @author Shaev Andrey.
 * @version 1.01.
 * @since 13.12.17
*/
public class Tracker {
	
	private final Item[] items = new Item[100];
	private int position = 0;
	private static Random rn = new Random();
	
	/**
     * Метод реализаущий добавление заявки в хранилище.
     * @param item новая заявка.
     */
	public Item add(Item item) {
		item.setId(this.generatedId());
		this.items[position++] = item;
		return item;
	}
	
	/**
     * Метод заменяющий зайвку по номеру Id.
     * @param item новая заявка, id- id старой заявки.
     */
	public void replace(String id, Item item) {
		for (int index = 0; index != position; index++) {
			if (items[index].getId().equals(id)) {
				this.items[index] = item;
				break;
			}
		}
	}
	
	/**
     * Метод реализаущий поиск заявки по id.
     * @param id- id заявки.
     */
	protected Item findById(String id) {
		Item result = null;
		for (Item item:items) {
			if (item != null && item.getId().equals(id)) {
				result = item;
				break;
			}
		}
		return result;
	}
	
	/**
     * Метод реализаущий реализующий поиск заявки по ключевому сочетанию букв в имени.
     * @param key подстрока, по которой находятся имена.
     */
	protected Item[] findByName(String key) {
		Item[] temp = new Item[position];
		int count = 0;
		for (int index = 0; index != position; index++) {
			if (this.items[index].getName().indexOf(key) != -1) {
				temp[count++] = this.items[index];
			}
		}
		Item[] result = Arrays.copyOf(temp, count);
		return result;
	}
	
	/**
     * Метод реализаущий удаление заявки по id.
     * 
     */
	public void delete(String id) {
		for (int index = 0; index != position; index++) {
			if (items[index].getId().equals(id)) {
				for (int count = index; count != (position - 1); count++) {
					this.items[count] = this.items[count + 1];
				}
				break;
			}
		}
		position--;
	}
	
	/**
     * Метод реализаущий возврат списка заявок.
     */
	public Item[] getAll() {
		Item[] result = new Item[this.position];
		for (int index = 0; index != position; index++) {
			result[index] = this.items[index];
		}
		return result;
	}
	
	/**
     * Метод генерирующий уникальный id.
     */
	String generatedId() {
		return String.valueOf(System.currentTimeMillis() + rn.nextInt());
	}
}