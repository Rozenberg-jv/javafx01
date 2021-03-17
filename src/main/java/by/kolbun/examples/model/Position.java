package by.kolbun.examples.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Position {

  private int x, y;

  public double howFar(Position another) {

    return Math.sqrt(Math.pow(x - another.x, 2) + Math.pow(y - another.y, 2));
  }
}
