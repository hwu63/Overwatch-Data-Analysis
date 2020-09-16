package net.javaee.overwatchstatistics.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import net.javaee.overwatchstatistics.model.Game;

/**
 * AbstractDAO.java This DAO class provides CRUD database operations for the
 * table book in the database.
 * 
 * @author www.codejava.net
 *
 */
public class GameDAO extends DAO {
  private String jdbcURL;
  private String jdbcUsername;
  private String jdbcPassword;
  private Connection jdbcConnection;

  public GameDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
    this.jdbcURL = jdbcURL;
    this.jdbcUsername = jdbcUsername;
    this.jdbcPassword = jdbcPassword;
    this.jdbcURL = "jdbc:mysql://localhost:3306/sys?useLegacyDatetimeCode=false&serverTimezone=UTC";
    this.jdbcUsername = "root";
    this.jdbcPassword = "ZHAX1dele";
  }

  protected void connect() throws SQLException {
    if (jdbcConnection == null || jdbcConnection.isClosed()) {
      try {
        Class.forName("com.mysql.jdbc.Driver");
      } catch (ClassNotFoundException e) {
        throw new SQLException(e);
      }
      jdbcConnection = DriverManager.getConnection(
          jdbcURL, jdbcUsername, jdbcPassword);
    }
  }

  protected void disconnect() throws SQLException {
    if (jdbcConnection != null && !jdbcConnection.isClosed()) {
      jdbcConnection.close();
    }
  }

  public boolean insertGame(Game game) throws SQLException {
    String sql = "INSERT INTO sys.Game VALUES (?, ?, ?, ?, ?, ?, ?)";

    connect();

    PreparedStatement statement = jdbcConnection.prepareStatement(sql);
    statement.setInt(1, game.getIdGame());
    statement.setInt(2, game.getSeason());
    statement.setInt(3, game.getTeamSkillRateAvg());
    statement.setInt(4, game.getEnemySkillRateavg());
    statement.setString(5, game.getResultname());
    statement.setInt(6, game.getIdLeaver());
    statement.setInt(7, game.getIdMap());

    boolean rowInserted = statement.executeUpdate() > 0;
    statement.close();
    disconnect();
    return rowInserted;
  }

  public List<Game> listAllGames() throws SQLException {
    List<Game> listGame = new ArrayList<>();
    String sql = "SELECT * FROM sys.Game";

    connect();
    Statement statement = jdbcConnection.createStatement();
    ResultSet resultSet = statement.executeQuery(sql);

    while (resultSet.next()) {
      int idGame = resultSet.getInt("idGame");
      int Season = resultSet.getInt("Season");
      int TeamSkillRateAvg = resultSet.getInt("TeamSkillRateAvg");
      int EnemySkillRateavg = resultSet.getInt("EnemySkillRateavg");
      String Result = resultSet.getString("Result");
      int idLeaver = resultSet.getInt("idLeaver");
      int idMap = resultSet.getInt("idMap");

      Game game = new Game(idGame, Season, TeamSkillRateAvg, EnemySkillRateavg, Result, idLeaver,
          idMap);
      listGame.add(game);
    }

    resultSet.close();
    statement.close();

    disconnect();

    return listGame;
  }

  public boolean deleteGame(int idgame) throws SQLException {
    String sql = "DELETE FROM sys.Game where idGame = ?";

    connect();

    PreparedStatement statement = jdbcConnection.prepareStatement(sql);
    statement.setInt(1, idgame);

    boolean rowDeleted = statement.executeUpdate() > 0;
    statement.close();
    disconnect();
    return rowDeleted;
  }

  public boolean updateGame(Game game) throws SQLException {
    String sql = "UPDATE sys.Game SET Season = ?, TeamSkillRateAvg = ?, EnemySkillRateavg = ?, "
        + "Result = ?, idLeaver = ?, idMap = ? WHERE idGame = ?";
    connect();
    PreparedStatement statement = jdbcConnection.prepareStatement(sql);

    statement.setInt(1, game.getSeason());
    statement.setInt(2, game.getTeamSkillRateAvg());
    statement.setInt(3, game.getEnemySkillRateavg());
    statement.setString(4, game.getResultname());
    statement.setInt(5, game.getIdLeaver());
    statement.setInt(6, game.getIdMap());
    statement.setInt(7, game.getIdGame());

    boolean rowUpdated = statement.executeUpdate() > 0;
    statement.close();
    disconnect();
    return rowUpdated;
  }

  public Game getGame(int idgame) throws SQLException {
    Game game = null;
    String sql = "SELECT * FROM sys.Game WHERE idGame = ?";

    connect();

    PreparedStatement statement = jdbcConnection.prepareStatement(sql);
    statement.setInt(1, idgame);

    ResultSet resultSet = statement.executeQuery();

    if (resultSet.next()) {
      int idGame = resultSet.getInt("idGame");
      int Season = resultSet.getInt("Season");
      int TeamSkillRateAvg = resultSet.getInt("TeamSkillRateAvg");
      int EnemySkillRateavg = resultSet.getInt("EnemySkillRateavg");
      String Result = resultSet.getString("Result");
      int idLeaver = resultSet.getInt("idLeaver");
      int idMap = resultSet.getInt("idMap");

      game = new Game(idGame, Season, TeamSkillRateAvg, EnemySkillRateavg, Result, idLeaver,
          idMap);
    }

    resultSet.close();
    statement.close();

    return game;
  }

  public List<Game> listAllGamesBySeason(int season) throws SQLException {
    List<Game> listGame = new ArrayList<>();
    String sql = "SELECT * FROM sys.Game WHERE Season = " + season;

    connect();

    PreparedStatement statement = jdbcConnection.prepareStatement(sql);

    ResultSet resultSet = statement.executeQuery(sql);

    while (resultSet.next()) {
      int idGame = resultSet.getInt("idGame");
      int Season = resultSet.getInt("Season");
      int TeamSkillRateAvg = resultSet.getInt("TeamSkillRateAvg");
      int EnemySkillRateavg = resultSet.getInt("EnemySkillRateavg");
      String Result = resultSet.getString("Result");
      int idLeaver = resultSet.getInt("idLeaver");
      int idMap = resultSet.getInt("idMap");

      Game game = new Game(idGame, Season, TeamSkillRateAvg, EnemySkillRateavg, Result, idLeaver,
          idMap);
      listGame.add(game);
    }

    resultSet.close();
    statement.close();

    disconnect();

    return listGame;
  }

}
