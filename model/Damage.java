package net.javaee.overwatchstatistics.model;

/**
 * Book.java This is a model class represents a book entity
 *
 * @author www.codejava.net
 */

public class Damage {

  protected int idDamage;
  protected int idMedal;
  protected int Elim;
  protected int Dmg;
  protected int idPlayer;

  public Damage(int idDamage, int idMedal, int elim, int dmg, int idPlayer) {

    this.idDamage = idDamage;
    this.idMedal = idMedal;
    Elim = elim;
    Dmg = dmg;
    this.idPlayer = idPlayer;
  }

  public int getIdDamage() {
    return idDamage;
  }

  public void setIdDamage(int idDamage) {
    this.idDamage = idDamage;
  }

  public int getIdMedal() {
    return idMedal;
  }

  public void setIdMedal(int idMedal) {
    this.idMedal = idMedal;
  }

  public int getElim() {
    return Elim;
  }

  public void setElim(int elim) {
    Elim = elim;
  }

  public int getDmg() {
    return Dmg;
  }

  public void setDmg(int dmg) {
    Dmg = dmg;
  }

  public int getIdPlayer() {
    return idPlayer;
  }

  public void setIdPlayer(int idPlayer) {
    this.idPlayer = idPlayer;
  }

}
