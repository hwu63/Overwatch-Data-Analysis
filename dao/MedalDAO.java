package net.javaee.overwatchstatistics.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import net.javaee.overwatchstatistics.model.Medal;

public class MedalDAO extends DAO {
  private String jdbcURL;
  private String jdbcUsername;
  private String jdbcPassword;
  private Connection jdbcConnection;

  public MedalDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
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

  public boolean insertMedal(Medal medal) throws SQLException {

    String sql = "INSERT INTO sys.Medal VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    connect();

    PreparedStatement statement = jdbcConnection.prepareStatement(sql);
    statement.setInt(1, medal.getIdMedal());
    statement.setInt(2, medal.getGold());
    statement.setInt(3, medal.getSilver());
    statement.setInt(4, medal.getBronze());
    statement.setInt(5, medal.getIdPlayer());
    statement.setInt(6, medal.getIdGame());
    statement.setString(7, medal.getElim_Medalname());
    statement.setString(8, medal.getDmg_Medalname());
    statement.setString(9, medal.getObj_Kill_Medalname());
    statement.setString(10, medal.getObj_Time_Medalname());
    statement.setString(11, medal.getHeal_Medalname());

    boolean rowInserted = statement.executeUpdate() > 0;
    statement.close();
    disconnect();
    return rowInserted;
  }

  public List<Medal> listAllMedal() throws SQLException {
    List<Medal> listMedal = new ArrayList<>();

    String sql = "SELECT * FROM sys.Medal";

    connect();

    Statement statement = jdbcConnection.createStatement();
    ResultSet resultSet = statement.executeQuery(sql);

    while (resultSet.next()) {
      int idMedal = resultSet.getInt("idMedal");
      int Gold = resultSet.getInt("Gold");
      int Silver = resultSet.getInt("Silver");
      int Bronze = resultSet.getInt("Bronze");
      int idPlayer = resultSet.getInt("idPlayer");
      int idGame = resultSet.getInt("idGame");
      String Elim_Medal = resultSet.getString("Elim_Medal");
      String Dmg_Medal = resultSet.getString("Dmg_Medal");
      String Obj_Kill_Medal = resultSet.getString("Obj_Kill_Medal");
      String Obj_Time_Medal = resultSet.getString("Obj_Time_Medal");
      String Heal_Medal = resultSet.getString("Heal_Medal");

      Medal medal = new Medal(idMedal, Gold, Silver, Bronze,
          idPlayer, idGame, Elim_Medal, Dmg_Medal, Obj_Kill_Medal,
          Obj_Time_Medal, Heal_Medal);
      listMedal.add(medal);
    }

    resultSet.close();
    statement.close();

    disconnect();

    return listMedal;
  }

  public boolean deleteMedal(int idmedal) throws SQLException {
    String sql = "DELETE FROM sys.Medal where idMedal = ?";

    connect();

    PreparedStatement statement = jdbcConnection.prepareStatement(sql);
    statement.setInt(1, idmedal);

    boolean rowDeleted = statement.executeUpdate() > 0;
    statement.close();
    disconnect();
    return rowDeleted;
  }

  public boolean updateMedal(Medal medal) throws SQLException {
    String sql = "UPDATE sys.Medal SET Gold = ?, Silver = ?, Bronze = ?, idPlayer =?,"
        +
        "idGame = ?, Elim_Medal = ?, Dmg_Medal = ?, Obj_Kill_Medal = ?,Obj_Time_Medal = ?, Heal_Medal = ?";
    sql += " WHERE idMedal = ?";
    connect();

    PreparedStatement statement = jdbcConnection.prepareStatement(sql);
    statement.setInt(1, medal.getGold());
    statement.setInt(2, medal.getSilver());
    statement.setInt(3, medal.getBronze());
    statement.setInt(4, medal.getIdPlayer());
    statement.setInt(5, medal.getIdGame());
    statement.setString(6, medal.getElim_Medalname());
    statement.setString(7, medal.getDmg_Medalname());
    statement.setString(8, medal.getObj_Kill_Medalname());
    statement.setString(9, medal.getObj_Time_Medalname());
    statement.setString(10, medal.getHeal_Medalname());
    statement.setInt(11, medal.getIdMedal());

    boolean rowUpdated = statement.executeUpdate() > 0;
    statement.close();
    disconnect();
    return rowUpdated;
  }

  public Medal getMedal(int idmedal) throws SQLException {
    Medal medal = null;
    String sql = "SELECT * FROM sys.Medal WHERE idMedal = ? ";

    connect();

    PreparedStatement statement = jdbcConnection.prepareStatement(sql);
    statement.setInt(1, idmedal);

    ResultSet resultSet = statement.executeQuery();

    if (resultSet.next()) {
      int idMedal = resultSet.getInt("idMedal");
      int Gold = resultSet.getInt("Gold");
      int Silver = resultSet.getInt("Silver");
      int Bronze = resultSet.getInt("Bronze");
      int idPlayer = resultSet.getInt("idPlayer");
      int idGame = resultSet.getInt("idGame");
      String Elim_Medal = resultSet.getString("Elim_Medal");
      String Dmg_Medal = resultSet.getString("Dmg_Medal");
      String Obj_Kill_Medal = resultSet.getString("Obj_Kill_Medal");
      String Obj_Time_Medal = resultSet.getString("Obj_Time_Medal");
      String Heal_Medal = resultSet.getString("Heal_Medal");

      medal = new Medal(idMedal, Gold, Silver, Bronze,
          idPlayer, idGame, Elim_Medal, Dmg_Medal, Obj_Kill_Medal,
          Obj_Time_Medal, Heal_Medal);
    }

    resultSet.close();
    statement.close();

    return medal;
  }

  public List<Medal> listAllMedal(int gold) throws SQLException {
    List<Medal> listMedal = new ArrayList<>();

    String sql = "SELECT * FROM sys.Medal where Gold > " + gold;

    connect();

    PreparedStatement statement = jdbcConnection.prepareStatement(sql);
    ResultSet resultSet = statement.executeQuery(sql);

    while (resultSet.next()) {
      int idMedal = resultSet.getInt("idMedal");
      int Gold = resultSet.getInt("Gold");
      int Silver = resultSet.getInt("Silver");
      int Bronze = resultSet.getInt("Bronze");
      int idPlayer = resultSet.getInt("idPlayer");
      int idGame = resultSet.getInt("idGame");
      String Elim_Medal = resultSet.getString("Elim_Medal");
      String Dmg_Medal = resultSet.getString("Dmg_Medal");
      String Obj_Kill_Medal = resultSet.getString("Obj_Kill_Medal");
      String Obj_Time_Medal = resultSet.getString("Obj_Time_Medal");
      String Heal_Medal = resultSet.getString("Heal_Medal");

      Medal medal = new Medal(idMedal, Gold, Silver, Bronze,
          idPlayer, idGame, Elim_Medal, Dmg_Medal, Obj_Kill_Medal,
          Obj_Time_Medal, Heal_Medal);
      listMedal.add(medal);
    }

    resultSet.close();
    statement.close();

    disconnect();

    return listMedal;
  }
}
