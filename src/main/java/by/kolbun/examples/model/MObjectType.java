package by.kolbun.examples.model;

public enum MObjectType {

  BOT(0),
  WALL(1),
  FOOD(2),
  POISON(3),
  CORPSE(4);

  private final int code;

  MObjectType(int code) {
    this.code = code;
  }

  public int code() {
    return this.code;
  }
}
