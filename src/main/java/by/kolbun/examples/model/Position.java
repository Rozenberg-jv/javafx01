package by.kolbun.examples.model;

public class Position {

  private int x, y;

  public Position(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public double howFar(Position another) {

    return Math.sqrt(Math.pow(x - another.x, 2) + Math.pow(y - another.y, 2));
  }

  public int indexNumber() {

    return y * 32 + x;
  }

  public void relative(int dx, int dy) {

    this.x += dx;
    this.y += dy;
  }

  //

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }
}
