package aomine.controller;

import java.util.HashMap;

public class SeatController {
  private HashMap<Integer, String> rowMap;
  
  public SeatController() {
    rowMap = new HashMap<>();
    rowMap.put(0, "A");
    rowMap.put(1, "B");
    rowMap.put(2, "C");
    rowMap.put(3, "D");
    rowMap.put(4, "E");
    rowMap.put(5, "F");
    rowMap.put(6, "G");
    rowMap.put(7, "H");
  }

  public String getRow (Integer index) {
    return rowMap.get(index);
  }
}
