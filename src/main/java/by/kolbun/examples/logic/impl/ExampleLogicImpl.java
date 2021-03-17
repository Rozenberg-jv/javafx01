package by.kolbun.examples.logic.impl;

import by.kolbun.examples.logic.ExampleLogic;
import by.kolbun.examples.model.Bot;
import by.kolbun.examples.model.MObject;
import by.kolbun.examples.model.MObjectType;

import java.util.List;
import java.util.stream.Collectors;

public class ExampleLogicImpl implements ExampleLogic {

  private List<Bot> bots;
  private List<MObject> mObjects;

  public void init(List<MObject> initialObjects) {
    this.bots = initialObjects.stream().filter(o -> o.getType() == MObjectType.BOT).map(o -> (Bot) o).collect(Collectors.toList());
    this.mObjects = initialObjects.stream().filter(o -> o.getType() != MObjectType.BOT).collect(Collectors.toList());
  }

  @Override
  public void step() {

    for (Bot bot : bots) {
      bot.act();
    }
  }
}
