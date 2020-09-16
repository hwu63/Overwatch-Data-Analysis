package net.javaee.overwatchstatistics.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import net.javaee.overwatchstatistics.model.Support;

public class SupportDAO extends DAO {
  private String jdbcURL;
  private String jdbcUsername;
  private String jdbcPassword;
  private Connection jdbcConnection;

  public SupportDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
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

  public boolean insertSupport(Support support) throws SQLException {

    String sql = "INSERT INTO sys.support VALUES (?, ?, ?, ?, ?)";

    connect();

    PreparedStatement statement = jdbcConnection.prepareStatement(sql);
    statement.setInt(1, support.getIdSupport());
    statement.setInt(2, support.getIdMedal());
    statement.setInt(3, support.getHeal());
    statement.setInt(4, support.getIdPlayer());
    statement.setInt(5, support.getHeal_career());

    boolean rowInserted = statement.executeUpdate() > 0;
    statement.close();
    disconnect();
    return rowInserted;
  }

  public List<Support> listAllSupports() throws SQLException {
    List<Support> listsupport = new ArrayList<>();

    String sql = "SELECT * FROM sys.support";

    connect();

    Statement statement = jdbcConnection.createStatement();
    ResultSet resultSet = statement.executeQuery(sql);

    while (resultSet.next()) {
      int idSupport = resultSet.getInt("idSupport");
      int idMedal = resultSet.getInt("idMedal");
      int Heal = resultSet.getInt("Heal");
      int idPlayer = resultSet.getInt("idPlayer");
      int Heal_career = resultSet.getInt("Heal_career");

      Support support = new Support(idSupport, idMedal, Heal, idPlayer, Heal_career);
      listsupport.add(support);
    }

    resultSet.close();
    statement.close();

    disconnect();

    return listsupport;
  }

  public boolean deleteSupport(int idSupport) throws SQLException {
    String sql = "DELETE FROM sys.support where idSupport = ?";

    connect();

    PreparedStatement statement = jdbcConnection.prepareStatement(sql);
    statement.setInt(1, idSupport);

    boolean rowDeleted = statement.executeUpdate() > 0;
    statement.close();
    disconnect();
    return rowDeleted;
  }

  public boolean updateSupport(Support support) throws SQLException {
    String sql = "UPDATE sys.support SET Heal = ?, Heal_career = ?,"
        +
        " idMedal = ?, idPlayer = ? WHERE idSupport = ? ";
    connect();

    PreparedStatement statement = jdbcConnection.prepareStatement(sql);

    statement.setInt(1, support.getIdMedal());
    statement.setInt(2, support.getHeal());
    statement.setInt(3, support.getIdPlayer());
    statement.setInt(4, support.getHeal_career());
    statement.setInt(5, support.getIdSupport());

    boolean rowUpdated = statement.executeUpdate() > 0;
    statement.close();
    disconnect();
    return rowUpdated;
  }

  public Support getSupport(int idsupport) throws SQLException {
    Support support = null;
    String sql = "SELECT * FROM sys.support WHERE idSupport = ?";

    connect();

    PreparedStatement statement = jdbcConnection.prepareStatement(sql);
    statement.setInt(1, idsupport);

    ResultSet resultSet = statement.executeQuery();

    if (resultSet.next()) {
      int idSupport = resultSet.getInt("idSupport");
      int Heal = resultSet.getInt("Heal");
      int Heal_career = resultSet.getInt("Heal_career");
      int idMedal = resultSet.getInt("idMedal");
      int idPlayer = resultSet.getInt("idPlayer");

      support = new Support(idSupport, idMedal, Heal, idPlayer, Heal_career);

    }

    resultSet.close();
    statement.close();

    return support;
  }

  public List<Support> listAllSupports(int heal) throws SQLException {
    List<Support> listsupport = new ArrayList<>();

    String sql = "SELECT * FROM sys.support WHERE Heal > " + heal;

    connect();

    PreparedStatement statement = jdbcConnection.prepareStatement(sql);
    ResultSet resultSet = statement.executeQuery(sql);

    while (resultSet.next()) {
      int idSupport = resultSet.getInt("idSupport");
      int Heal = resultSet.getInt("Heal");
      int Heal_career = resultSet.getInt("Heal_career");
      int idMedal = resultSet.getInt("idMedal");
      int idPlayer = resultSet.getInt("idPlayer");

      Support support = new Support(idSupport, idMedal, Heal, idPlayer, Heal_career);
      listsupport.add(support);
    }

    resultSet.close();
    statement.close();

    disconnect();

    return listsupport;
  }
}
