package net.javaee.overwatchstatistics.model;

public class Role {
  enum roleType {
    Offense, Defense, Tank, Support, Unknown, None
  };

  protected int idRole;
  protected roleType Role1;
  protected roleType Role2;
  protected int idPlayer;

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

  protected int idGame;

  public Role(int idRole, roleType role1, roleType role2, int idPlayer, int idGame) {
    this.idRole = idRole;
    Role1 = role1;
    Role2 = role2;
    this.idPlayer = idPlayer;
    this.idGame = idGame;
  }

  public Role(int idRole2, String role12, String role22, int idplayer2, int idgame2) {
    this(idRole2, roleType.valueOf(role12), roleType.valueOf(role22), idplayer2, idgame2);
  }

  public int getIdplayer() {
    return idPlayer;
  }

  public void setIdplayer(int idplayer) {
    this.idPlayer = idplayer;
  }

  public int getIdgame() {
    return idGame;
  }

  public void setIdgame(int idgame) {
    this.idGame = idgame;
  }

  public int getIdRole() {
    return idRole;
  }

  public roleType getRole1enum() {
    return Role1;
  }

  public roleType getRole2enum() {
    return Role2;
  }

  public String getRole1() {
    return Role1.name();
  }

  public String getRole2() {
    return Role2.name();
  }

  public void setIdRole(int idRole) {
    this.idRole = idRole;
  }

  public void setRole1(roleType role1) {
    Role1 = role1;
  }

  public void setRole2(roleType role2) {
    Role2 = role2;
  }

  public void setRole1(String role1) {
    Role1 = roleType.valueOf(role1);
  }

  public void setRole2(String role2) {
    Role2 = roleType.valueOf(role2);
    ;
  }
}
