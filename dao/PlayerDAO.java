package net.javaee.overwatchstatistics.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import net.javaee.overwatchstatistics.model.Player;

public class PlayerDAO extends DAO {
  private String jdbcURL;
  private String jdbcUsername;
  private String jdbcPassword;
  private Connection jdbcConnection;

  public PlayerDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
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

  public boolean insertPlayer(Player player) throws SQLException {

    String sql = "INSERT INTO sys.Player VALUES (?, ?, ?, ?, ?)";

    connect();

    PreparedStatement statement = jdbcConnection.prepareStatement(sql);
    statement.setInt(1, player.getIdPlayer());
    statement.setInt(2, player.getStartSkillRate());
    statement.setInt(3, player.getEndSkillRate());
    statement.setInt(4, player.getSkillRateChange());
    statement.setInt(5, player.getIdDeath());

    System.out.print("shdfjsklfdhgjsklfhgjksdlh");

    boolean rowInserted = statement.executeUpdate() > 0;
    statement.close();
    disconnect();
    return rowInserted;
  }

  public List<Player> listAllPlayer() throws SQLException {
    List<Player> listplayer = new ArrayList<>();

    String sql = "SELECT * FROM sys.Player";

    connect();

    Statement statement = jdbcConnection.createStatement();
    ResultSet resultSet = statement.executeQuery(sql);

    while (resultSet.next()) {
      int idPlayer = resultSet.getInt("idPlayer");
      int StartSkillRate = resultSet.getInt("StartSkillRate");
      int EndSkillRate = resultSet.getInt("EndSkillRate");
      int SkillRateChange = resultSet.getInt("SkillRateChange");
      int idDeath = resultSet.getInt("idDeath");
//      Player player = new Player(idPlayer);
      Player player = new Player(idPlayer, StartSkillRate, EndSkillRate, SkillRateChange, idDeath);
      listplayer.add(player);
    }

    resultSet.close();
    statement.close();

    disconnect();

    return listplayer;
  }

  public boolean deletePlayer(int idplayer) throws SQLException {
    String sql = "DELETE FROM sys.Player where idPlayer = ? ";

    connect();

    PreparedStatement statement = jdbcConnection.prepareStatement(sql);
    statement.setInt(1, idplayer);

    boolean rowDeleted = statement.executeUpdate() > 0;
    statement.close();
    disconnect();
    return rowDeleted;
  }

  public boolean updatePlayer(Player player) throws SQLException {
    String sql = "UPDATE sys.Player SET  StartSkillRate = ?, EndSkillRate = ?, "
        +
        "SkillRateChange = ?, idDeath = ? WHERE idPlayer = ? ";
    connect();

    PreparedStatement statement = jdbcConnection.prepareStatement(sql);

    statement.setInt(1, player.getStartSkillRate());
    statement.setInt(2, player.getEndSkillRate());
    statement.setInt(3, player.getSkillRateChange());
    statement.setInt(4, player.getIdDeath());
    statement.setInt(5, player.getIdPlayer());

    boolean rowUpdated = statement.executeUpdate() > 0;
    statement.close();
    disconnect();
    return rowUpdated;
  }

  public Player getPlayer(int idplayer) throws SQLException {
    Player player = null;
    String sql = "SELECT * FROM sys.Player WHERE idPlayer = ? ";

    connect();

    PreparedStatement statement = jdbcConnection.prepareStatement(sql);
    statement.setInt(1, idplayer);

    ResultSet resultSet = statement.executeQuery();

    if (resultSet.next()) {
      int idPlayer = resultSet.getInt("idPlayer");

      int StartSkillRate = resultSet.getInt("StartSkillRate");
      int EndSkillRate = resultSet.getInt("EndSkillRate");
      int SkillRateChange = resultSet.getInt("SkillRateChange");
      int idDeath = resultSet.getInt("idDeath");

      player = new Player(idPlayer, StartSkillRate, EndSkillRate, SkillRateChange, idDeath);

    }

    resultSet.close();
    statement.close();

    return player;
  }

  public List<Player> listAllPlayer(int endSkillRate) throws SQLException {
    List<Player> listplayer = new ArrayList<>();

    String sql = "SELECT * FROM sys.Player where EndSkillRate > " + endSkillRate;

    connect();

    PreparedStatement statement = jdbcConnection.prepareStatement(sql);
    ResultSet resultSet = statement.executeQuery(sql);

    while (resultSet.next()) {
      int idPlayer = resultSet.getInt("idPlayer");
      int EndSkillRate = resultSet.getInt("EndSkillRate");
      int StartSkillRate = resultSet.getInt("StartSkillRate");
      int SkillRateChange = resultSet.getInt("SkillRateChange");
      int idDeath = resultSet.getInt("idDeath");

      Player player = new Player(idPlayer, StartSkillRate, EndSkillRate, SkillRateChange, idDeath);

      listplayer.add(player);
    }

    resultSet.close();
    statement.close();

    disconnect();

    return listplayer;
  }
}
