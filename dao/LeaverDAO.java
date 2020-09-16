package net.javaee.overwatchstatistics.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import net.javaee.overwatchstatistics.model.Leaver;

public class LeaverDAO extends DAO {
  private String jdbcURL;
  private String jdbcUsername;
  private String jdbcPassword;
  private Connection jdbcConnection;

  public LeaverDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
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

  public boolean insertLeaver(Leaver leaver) throws SQLException {
    String sql = "INSERT INTO sys.Leaver VALUES (?, ?, ?)";

    connect();

    PreparedStatement statement = jdbcConnection.prepareStatement(sql);
    statement.setInt(1, leaver.getIdLeaver());
    statement.setBoolean(2, leaver.isLeaver());
    statement.setString(3, leaver.getTeam());

    boolean rowInserted = statement.executeUpdate() > 0;
    statement.close();
    disconnect();
    return rowInserted;
  }

  public List<Leaver> listAllLeavers() throws SQLException {
    List<Leaver> listLeaver = new ArrayList<>();

    String sql = "SELECT * FROM sys.Leaver";

    connect();

    Statement statement = jdbcConnection.createStatement();
    ResultSet resultSet = statement.executeQuery(sql);

    while (resultSet.next()) {

      int idLeaver = resultSet.getInt("idLeaver");
      boolean Leaver = resultSet.getBoolean("Leaver");
      String Team = resultSet.getString("Team");

      Leaver leaver = new Leaver(idLeaver, Leaver, Team);
      listLeaver.add(leaver);
    }
    resultSet.close();
    statement.close();

    disconnect();

    return listLeaver;
  }

  public boolean deleteLeaver(int idleaver) throws SQLException {
    String sql = "DELETE FROM sys.Leaver where idLeaver = ?";

    connect();

    PreparedStatement statement = jdbcConnection.prepareStatement(sql);
    statement.setInt(1, idleaver);

    boolean rowDeleted = statement.executeUpdate() > 0;
    statement.close();
    disconnect();
    return rowDeleted;
  }

  public boolean updateLeaver(Leaver leaver) throws SQLException {
    String sql = "UPDATE sys.Leaver SET HasLeaver = ?, Team = ?";
    sql += " WHERE idLeaver = ?";
    connect();

    PreparedStatement statement = jdbcConnection.prepareStatement(sql);

    statement.setBoolean(1, leaver.isLeaver());
    statement.setString(2, leaver.getTeam());
    statement.setInt(3, leaver.getIdLeaver());

    boolean rowUpdated = statement.executeUpdate() > 0;
    statement.close();
    disconnect();
    return rowUpdated;
  }

  public Leaver getLeaver(int idleaver) throws SQLException {
    Leaver leaver = null;
    String sql = "SELECT * FROM sys.Leaver WHERE idLeaver = ? ";

    connect();

    PreparedStatement statement = jdbcConnection.prepareStatement(sql);
    statement.setInt(1, idleaver);

    ResultSet resultSet = statement.executeQuery();

    if (resultSet.next()) {
      int idLeaver = resultSet.getInt("idLeaver");
      boolean Leaver = resultSet.getBoolean("Leaver");
      String Team = resultSet.getString("Team");

      leaver = new Leaver(idLeaver, Leaver, Team);
    }

    resultSet.close();
    statement.close();

    return leaver;
  }

  public List<Leaver> listAllLeavers(String team) throws SQLException {
    List<Leaver> listLeaver = new ArrayList<>();

    String sql = "SELECT * FROM sys.Leaver where Team = \'" + team + "'";

    connect();

    PreparedStatement statement = jdbcConnection.prepareStatement(sql);
    ResultSet resultSet = statement.executeQuery(sql);

    while (resultSet.next()) {
      int idLeaver = resultSet.getInt("idLeaver");
      boolean Leaver = resultSet.getBoolean("Leaver");
      String Team = resultSet.getString("Team");

      Leaver leaver = new Leaver(idLeaver, Leaver, Team);
      listLeaver.add(leaver);
    }
    resultSet.close();
    statement.close();

    disconnect();

    return listLeaver;
  }
}
