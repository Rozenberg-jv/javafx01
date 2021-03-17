package by.kolbun.examples.logic;

import by.kolbun.examples.model.MObject;

import java.util.List;

public interface ExampleLogic extends Logic {

  void init(List<MObject> list);

  void step();
}
