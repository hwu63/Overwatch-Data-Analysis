package net.javaee.overwatchstatistics.model;

public class Stack {
  protected int idGame;
  protected int TeamStack;
  protected int EnemyStack;

  public Stack(int idGame, int teamStack, int enemyStack) {
    this.idGame = idGame;
    TeamStack = teamStack;
    EnemyStack = enemyStack;
  }

  public int getIdGame() {
    return idGame;
  }

  public void setIdGame(int idGame) {
    this.idGame = idGame;
  }

  public void setTeamStack(int teamStack) {
    TeamStack = teamStack;
  }

  public void setEnemyStack(int enemyStack) {
    EnemyStack = enemyStack;
  }

  public int getTeamStack() {
    return TeamStack;
  }

  public int getEnemyStack() {
    return EnemyStack;
  }
}
