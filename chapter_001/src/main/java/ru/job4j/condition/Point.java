package ru.job4j.condition;
 
 /**
 * Class Point 3.2. определение принадлежности точки функции.
 * @author Shaev Andrey.
 * @version 1.01.
 * @since 18.11.17.
*/
public class Point {
   private int x;
   private int y;
 
   public  Point(int x, int y) {
      this.x = x;
      this.y = y;
  }
  
  public int getX() {
      return this.x;
  }
 
  public int getY() {
     return this.y;
  }
  public boolean is(int a, int b) {
    return this.y == a * this.x + b;
  } 
}