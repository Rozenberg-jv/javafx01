package by.kolbun.examples.model.algo;

import by.kolbun.examples.model.algo.commands.Command;

import java.util.Arrays;
import java.util.List;

public class Algo {

  private List<Command> commands;
  private int currentCommand = 0;

  public Algo(List<Command> commands) {
    this.commands = commands;
  }

  public Algo(Command... commands) {
    this.commands = Arrays.asList(commands);
  }

  public void performNext() {
    commands.get(currentCommand).execute();
    currentCommand++;
    if (currentCommand == commands.size())
      currentCommand = 0;
  }
}
