package net.javaee.overwatchstatistics.model;

import java.sql.Time;

public class Tank {
  protected int idTank;
  protected int idPlayer;
  protected int idMedal;
  protected Time Obj_Time;
  protected int Obj_Kill;

  public Tank(int idTank, int idPlayer, int idMedal, Time obj_Time, int obj_Kill) {
    this.idTank = idTank;
    Obj_Time = obj_Time;
    Obj_Kill = obj_Kill;
    this.idPlayer = idPlayer;
    this.idMedal = idMedal;
  }

  public int getIdPlayer() {
    return idPlayer;
  }

  public void setIdPlayer(int idPlayer) {
    this.idPlayer = idPlayer;
  }

  public int getIdMedal() {
    return idMedal;
  }

  public void setIdMedal(int idMedal) {
    this.idMedal = idMedal;
  }

  public int getIdTank() {
    return idTank;
  }

  public void setIdTank(int idTank) {
    this.idTank = idTank;
  }

  public void setObj_Time(Time obj_Time) {
    Obj_Time = obj_Time;
  }

  public void setObj_Kill(int obj_Kill) {
    Obj_Kill = obj_Kill;
  }

  public Time getObj_Time() {
    return Obj_Time;
  }

  public int getObj_Kill() {
    return Obj_Kill;
  }
}