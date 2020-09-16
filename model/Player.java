package net.javaee.overwatchstatistics.model;

public class Player {

  public int idPlayer;
  public int StartSkillRate;
  public int EndSkillRate;
  public int SkillRateChange;
  public int idDeath;

  public Player(int idPlayer, int startSkillRate, int endSkillRate, int skillRateChange,
      int iddeath) {
    this.idPlayer = idPlayer;
    StartSkillRate = startSkillRate;
    EndSkillRate = endSkillRate;
    SkillRateChange = skillRateChange;
    idDeath = iddeath;
  }

  public Player(int idPlayer2) {
    this.idPlayer = idPlayer2;
    StartSkillRate = 0;
    EndSkillRate = 0;
    SkillRateChange = 0;
    idDeath = 0;
  }

  public int getIdPlayer() {
    return idPlayer;
  }

  public void setIdPlayer(int IdPlayer) {
    this.idPlayer = IdPlayer;
  }

  public void setEndSkillRate(int EndSkillRate) {
    this.EndSkillRate = EndSkillRate;
  }

  public void setStartSkillRate(int StartSkillRate) {
    this.StartSkillRate = StartSkillRate;
  }

  public void setSkillRateChange(int SkillRateChange) {
    this.SkillRateChange = SkillRateChange;
  }

  public int getEndSkillRate() {
    return EndSkillRate;
  }

  public int getStartSkillRate() {
    return StartSkillRate;
  }

  public int getSkillRateChange() {
    return SkillRateChange;
  }

  public int getIdDeath() {
    return idDeath;
  }

  public void setIdDeath(int IdDeath) {
    this.idDeath = IdDeath;
  }
}
