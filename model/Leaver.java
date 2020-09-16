package net.javaee.overwatchstatistics.model;

public class Leaver {

  protected int idLeaver;
  protected boolean Leaver;
  protected String Team;

  public Leaver(int idLeaver, boolean Leaver, String team) {

    this.idLeaver = idLeaver;
    this.Leaver = Leaver;
    Team = team;
  }

  public boolean isLeaver() {
    return Leaver;
  }

  public void setLeaver(boolean hasLeaver) {
    Leaver = hasLeaver;
  }

  public void setIdLeaver(int idLeaver) {
    this.idLeaver = idLeaver;
  }

  public void setTeam(String team) {
    Team = team;
  }

  public int getIdLeaver() {
    return idLeaver;
  }

  public String getTeam() {
    return Team;
  }
}
