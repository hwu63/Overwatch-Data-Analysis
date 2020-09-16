package net.javaee.overwatchstatistics.model;

public class Map {
  protected int idMap;
  protected String MapName;
  protected String Mode;
  protected int NumWin;

  public Map(int idMap, String mapName, String mode) {
    MapName = mapName;
    this.idMap = idMap;
    Mode = mode;
  }

  public int getNumWin() {
    return NumWin;
  }

  public void setNumWin(int numWin) {
    NumWin = numWin;
  }

  public Map(int idMap2, String mapName2, int numWin2) {
    MapName = mapName2;
    this.idMap = idMap;
    this.NumWin = numWin2;
  }

  public String getMapName() {
    return MapName;
  }

  public void setMapName(String mapName) {
    MapName = mapName;
  }

  public void setIdMap(int idMap) {
    this.idMap = idMap;
  }

  public void setMode(String mode) {
    Mode = mode;
  }

  public int getIdMap() {
    return idMap;
  }

  public String getMode() {
    return Mode;
  }
}
