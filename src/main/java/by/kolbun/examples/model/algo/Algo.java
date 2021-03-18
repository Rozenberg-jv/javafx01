package by.kolbun.examples.model.algo;

import by.kolbun.examples.model.MObject;
import by.kolbun.examples.model.algo.commands.Command;

import java.util.Arrays;
import java.util.List;

public class Algo {

  private MObject target;

  private List<Command> commands;
  private int currentCommand = 0;

  public Algo(MObject target, List<Command> commands) {
    this.commands = commands;
    this.target = target;
  }

  public Algo(MObject target, Command... commands) {
    this(target, Arrays.asList(commands));
  }

  public void performNext() {
    commands.get(currentCommand).execute(this.target);
    currentCommand++;
    if (currentCommand == commands.size())
      currentCommand = 0;
  }
}
