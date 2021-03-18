package by.kolbun.examples.model.algo.commands.impl;

import by.kolbun.examples.model.MObject;
import by.kolbun.examples.model.algo.commands.Command;

public class MoveCommand implements Command {

  private final int dx, dy;

  public MoveCommand(int dx, int dy) {
    this.dx = dx;
    this.dy = dy;
  }

  @Override
  public void execute(MObject target) {

    target.getPos().relative(dx, dy);
  }
}
