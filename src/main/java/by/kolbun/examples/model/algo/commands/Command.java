package by.kolbun.examples.model.algo.commands;

import by.kolbun.examples.model.MObject;

public interface Command {

  void execute(MObject target);
}
