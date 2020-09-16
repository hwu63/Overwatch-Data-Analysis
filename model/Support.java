package net.javaee.overwatchstatistics.model;

public class Support {
  protected int idSupport;
  protected int idMedal;
  protected int Heal;
  protected int idPlayer;
  protected int Heal_career;

  public Support(int idSupport, int idMedal, int heal, int idPlayer, int heal_career) {
    this.idSupport = idSupport;
    Heal = heal;
    Heal_career = heal_career;
    this.idMedal = idMedal;
    this.idPlayer = idPlayer;
  }

  public int getIdSupport() {
    return idSupport;
  }

  public void setIdSupport(int idSupport) {
    this.idSupport = idSupport;
  }

  public void setHeal(int heal) {
    Heal = heal;
  }

  public void setHeal_career(int heal_career) {
    Heal_career = heal_career;
  }

  public int getHeal() {
    return Heal;
  }

  public int getHeal_career() {
    return Heal_career;
  }

  public int getIdMedal() {
    return idMedal;
  }

  public void setIdMedal(int idMedal) {
    this.idMedal = idMedal;
  }

  public int getIdPlayer() {
    return idPlayer;
  }

  public void setIdPlayer(int idPlayer) {
    this.idPlayer = idPlayer;
  }
}
