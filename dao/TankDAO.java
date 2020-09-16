package net.javaee.overwatchstatistics.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import net.javaee.overwatchstatistics.model.Tank;

public class TankDAO extends DAO {

  private String jdbcUsername;
  private String jdbcURL;
  private String jdbcPassword;
  private Connection jdbcConnection;

  public TankDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
    this.jdbcURL = jdbcURL;
    this.jdbcUsername = jdbcUsername;
    this.jdbcPassword = jdbcPassword;
    this.jdbcURL = "jdbc:mysql://localhost:3306/sys?useLegacyDatetimeCode=false&serverTimezone=UTC";
    this.jdbcUsername = "root";
    this.jdbcPassword = "ZHAX1dele";
  }

  protected void connect() throws SQLException {
//    Object jdbcConnection;
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

  public boolean insertTank(Tank tank) throws SQLException {

    String sql = "INSERT INTO sys.Tank VALUES (?, ?, ?, ?, ?)";

    connect();
    PreparedStatement statement = jdbcConnection.prepareStatement(sql);

    statement.setInt(1, tank.getIdTank());
    statement.setInt(2, tank.getIdPlayer());
    statement.setInt(3, tank.getIdMedal());
    statement.setTime(4, tank.getObj_Time());
    statement.setInt(5, tank.getObj_Kill());

    boolean rowInserted = statement.executeUpdate() > 0;
    statement.close();
    disconnect();
    return rowInserted;
  }

  public List<Tank> listAllTanks() throws SQLException {
    List<Tank> listtank = new ArrayList<>();

    String sql = "SELECT * FROM sys.Tank";

    connect();

    Statement statement = jdbcConnection.createStatement();
    ResultSet resultSet = statement.executeQuery(sql);

    while (resultSet.next()) {

      int idTank = resultSet.getInt("idTank");
      int idPlayer = resultSet.getInt("idPlayer");
      int idMedal = resultSet.getInt("idMedal");
      Time Obj_Time = resultSet.getTime("Obj_Time");
      int Obj_Kill = resultSet.getInt("Obj_Kill");

      Tank tank = new Tank(idTank, idPlayer, idMedal, Obj_Time, Obj_Kill);
      listtank.add(tank);
    }

    resultSet.close();
    statement.close();

    disconnect();

    return listtank;
  }

  public boolean deleteTank(int idtank) throws SQLException {
    String sql = "DELETE FROM sys.Tank where idTank = ?";

    connect();

    PreparedStatement statement = jdbcConnection.prepareStatement(sql);
    statement.setInt(1, idtank);

    boolean rowDeleted = statement.executeUpdate() > 0;
    statement.close();
    disconnect();
    return rowDeleted;
  }

  public boolean updateTank(Tank tank) throws SQLException {
    String sql = "UPDATE sys.Tank SET Obj_Time = ?, Obj_Kill = ?,"
        +
        " idPlayer = ?, idMedal = ? WHERE idTank = ? ";
    connect();

    PreparedStatement statement = jdbcConnection.prepareStatement(sql);

    statement.setInt(1, tank.getIdPlayer());
    statement.setInt(2, tank.getIdMedal());
    statement.setTime(3, tank.getObj_Time());
    statement.setInt(4, tank.getObj_Kill());
    statement.setInt(5, tank.getIdTank());

    boolean rowUpdated = statement.executeUpdate() > 0;
    statement.close();
    disconnect();
    return rowUpdated;
  }

  public Tank getTank(int idtank) throws SQLException {
    Tank tank = null;
    String sql = "SELECT * FROM sys.Tank WHERE idTank = ? ";

    connect();

    PreparedStatement statement = jdbcConnection.prepareStatement(sql);
    statement.setInt(1, idtank);

    ResultSet resultSet = statement.executeQuery();

    if (resultSet.next()) {
      int idTank = resultSet.getInt("idTank");
      Time Obj_Time = resultSet.getTime("Obj_Time");
      int Obj_Kill = resultSet.getInt("Obj_Kill");
      int idPlayer = resultSet.getInt("idPlayer");
      int idMedal = resultSet.getInt("idMedal");

      tank = new Tank(idTank, idPlayer, idMedal, Obj_Time, Obj_Kill);

    }

    resultSet.close();
    statement.close();

    return tank;
  }
}