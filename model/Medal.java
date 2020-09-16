package net.javaee.overwatchstatistics.model;

public class Medal {
  enum Type {
    Gold,
    Silver,
    Bronze,
    None,
    Unknown
  }

  protected int idMedal;
  protected int Gold;
  protected int Silver;
  protected int Bronze;
  protected int idPlayer;
  protected int idGame;
  protected Type Elim_Medal;
  protected Type Dmg_Medal;
  protected Type Obj_Kill_Medal;
  protected Type Obj_Time_Medal;
  protected Type Heal_Medal;

  public Medal(int idMedal, int gold, int silver, int bronze, int idPlayer, int idGame,
      Type elim_Medal, Type dmg_Medal, Type obj_Kill_Medal, Type obj_Time_Medal, Type heal_Medal) {
    super();
    this.idMedal = idMedal;
    Gold = gold;
    Silver = silver;
    Bronze = bronze;
    this.idPlayer = idPlayer;
    this.idGame = idGame;
    Elim_Medal = elim_Medal;
    Dmg_Medal = dmg_Medal;
    Obj_Kill_Medal = obj_Kill_Medal;
    Obj_Time_Medal = obj_Time_Medal;
    Heal_Medal = heal_Medal;
  }

  public Medal(int idMedal, int gold, int bronze, int silver, int idPlayer, int idGame,
      String elim_Medal, String dmg_Medal, String obj_Kill_Medal, String obj_Time_Medal,
      String heal_Medal) {
    this(idMedal, gold, bronze, silver, idPlayer, idGame, transfer(elim_Medal),
        transfer(dmg_Medal), transfer(obj_Kill_Medal), transfer(obj_Time_Medal),
        transfer(heal_Medal));
  }

  private static Type transfer(String medal) {
    if (medal == "")
      return Type.Unknown;
    return Type.valueOf(medal);
  }

  public int getIdMedal() {
    return idMedal;
  }

  public void setIdMedal(int idMedal) {
    this.idMedal = idMedal;
  }

  public int getGold() {
    return Gold;
  }

  public void setGold(int gold) {
    Gold = gold;
  }

  public int getBronze() {
    return Bronze;
  }

  public void setBronze(int bronze) {
    Bronze = bronze;
  }

  public int getSilver() {
    return Silver;
  }

  public void setSilver(int silver) {
    Silver = silver;
  }

  public int getIdPlayer() {
    return idPlayer;
  }

  public void setIdPlayer(int idPlayer) {
    this.idPlayer = idPlayer;
  }

  public int getIdGame() {
    return idGame;
  }

  public void setIdGame(int idGame) {
    this.idGame = idGame;
  }

  public Type getElim_Medal() {
    return Elim_Medal;
  }

  public void setElim_Medal(Type elim_Medal) {
    Elim_Medal = elim_Medal;
  }

  public Type getDmg_Medal() {
    return Dmg_Medal;
  }

  public void setDmg_Medal(Type dmg_Medal) {
    Dmg_Medal = dmg_Medal;
  }

  public Type getObj_Kill_Medal() {
    return Obj_Kill_Medal;
  }

  public void setObj_Kill_Medal(Type obj_Kill_Medal) {
    Obj_Kill_Medal = obj_Kill_Medal;
  }

  public Type getObj_Time_Medal() {
    return Obj_Time_Medal;
  }

  public void setObj_Time_Medal(Type obj_Time_Medal) {
    Obj_Time_Medal = obj_Time_Medal;
  }

  public Type getHeal_Medal() {
    return Heal_Medal;
  }

  public void setHeal_Medal(Type heal_Medal) {
    Heal_Medal = heal_Medal;
  }

  public String getElim_Medalname() {
    return Elim_Medal.name();
  }

  public String getDmg_Medalname() {
    return Dmg_Medal.name();
  }

  public String getObj_Kill_Medalname() {
    return Obj_Kill_Medal.name();
  }

  public String getObj_Time_Medalname() {
    return Obj_Time_Medal.name();
  }

  public String getHeal_Medalname() {
    return Heal_Medal.name();
  }

}