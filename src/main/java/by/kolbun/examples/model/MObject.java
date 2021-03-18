package by.kolbun.examples.model;

public class MObject {

  private Position pos;

  private MObjectType type;

  public MObject(int x, int y, MObjectType type) {

    this(new Position(x, y), type);
  }

  public MObject(Position pos, MObjectType type) {

    this.pos = pos;
    this.type = type;
  }

  /*public MObject(Position pos, MObjectType type) {
    this.pos = pos;
    this.type = type;
  }*/

  public Position getPos() {
    return pos;
  }

  public MObjectType getType() {
    return type;
  }
}
