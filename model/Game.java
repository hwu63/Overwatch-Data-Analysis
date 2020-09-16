package net.javaee.overwatchstatistics.model;

public class Game {
  enum result {
    Win,
    Loss,
    Draw
  }

  protected int idGame;
  protected int Season;
  protected int TeamSkillRateAvg;
  protected int EnemySkillRateavg;
  protected result Result;
  protected int idLeaver;
  protected int idMap;

  public Game(int idGame, int season, int teamSkillRateAvg, int enemySkillRateavg, result result,
      int idLeaver, int idMap) {

    this.idGame = idGame;
    Season = season;
    TeamSkillRateAvg = teamSkillRateAvg;
    EnemySkillRateavg = enemySkillRateavg;
    Result = result;
    this.idLeaver = idLeaver;
    this.idMap = idMap;
  }

  public Game(int idGame, int season, int teamSkillRateAvg, int enemySkillRateavg, String Result,
      int idLeaver, int idMap) {
    this(idGame, season, teamSkillRateAvg, enemySkillRateavg, result.valueOf(Result), idLeaver,
        idMap);
  }

  public int getIdGame() {
    return idGame;
  }

  public void setIdGame(int idGame) {
    this.idGame = idGame;
  }

  public int getSeason() {
    return Season;
  }

  public void setSeason(int season) {
    Season = season;
  }

  public int getTeamSkillRateAvg() {
    return TeamSkillRateAvg;
  }

  public void setTeamSkillRateAvg(int teamSkillRateAvg) {
    TeamSkillRateAvg = teamSkillRateAvg;
  }

  public int getEnemySkillRateavg() {
    return EnemySkillRateavg;
  }

  public void setEnemySkillRateavg(int enemySkillRateavg) {
    EnemySkillRateavg = enemySkillRateavg;
  }

  public result getResult() {
    return Result;
  }

  public void setResult(result result) {
    Result = result;
  }

  public int getIdLeaver() {
    return idLeaver;
  }

  public void setIdLeaver(int idLeaver) {
    this.idLeaver = idLeaver;
  }

  public int getIdMap() {
    return idMap;
  }

  public void setIdMap(int idMap) {
    this.idMap = idMap;
  }

  public String getResultname() {
    return Result.name();
  }

}
