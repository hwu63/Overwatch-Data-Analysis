package net.javaee.overwatchstatistics.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import net.javaee.overwatchstatistics.model.Damage;

public class DamageDAO extends DAO {
  private String jdbcURL;
  private String jdbcUsername;
  private String jdbcPassword;
  private Connection jdbcConnection;

  public DamageDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
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

  public boolean insertDamage(Damage damage) throws SQLException {
    String sql = "INSERT INTO sys.Damage VALUES (?, ?, ?, ?, ?)";

    connect();

    PreparedStatement statement = jdbcConnection.prepareStatement(sql);
    statement.setInt(1, damage.getIdDamage());
    statement.setInt(2, damage.getIdMedal());
    statement.setInt(3, damage.getElim());
    statement.setInt(4, damage.getDmg());
    statement.setInt(5, damage.getIdPlayer());

    boolean rowInserted = statement.executeUpdate() > 0;
    statement.close();
    disconnect();
    return rowInserted;
  }

  public List<Damage> listAllDamages() throws SQLException {
    List<Damage> listdamage = new ArrayList<>();

    String sql = "SELECT * FROM sys.Damage";

    connect();

    Statement statement = jdbcConnection.createStatement();
    ResultSet resultSet = statement.executeQuery(sql);

    while (resultSet.next()) {
      int idDamage = resultSet.getInt("idDamage");
      int idMedal = resultSet.getInt("idMedal");
      int Elim = resultSet.getInt("Elim");
      int Dmg = resultSet.getInt("Dmg");
      int idPlayer = resultSet.getInt("idPlayer");

      Damage damage = new Damage(idDamage, idMedal, Elim, Dmg, idPlayer);
      listdamage.add(damage);
    }

    resultSet.close();
    statement.close();

    disconnect();

    return listdamage;
  }

  public boolean deleteDamage(int idDamage) throws SQLException {
    String sql = "DELETE FROM sys.Damage where idDamage = ? ";

    connect();

    PreparedStatement statement = jdbcConnection.prepareStatement(sql);
    statement.setInt(1, idDamage);

    boolean rowDeleted = statement.executeUpdate() > 0;
    statement.close();

    disconnect();

    return rowDeleted;
  }

  public boolean updateDamage(Damage damage) throws SQLException {
    String sql = "UPDATE sys.Damage SET idMedal = ?, Elim = ?, Dmg = ?, "
        + "idPlayer = ? WHERE idDamage = ?";
    connect();

    PreparedStatement statement = jdbcConnection.prepareStatement(sql);
    statement.setInt(1, damage.getIdMedal());
    statement.setInt(2, damage.getElim());
    statement.setInt(3, damage.getDmg());
    statement.setInt(4, damage.getIdPlayer());
    statement.setInt(5, damage.getIdDamage());

    boolean rowUpdated = statement.executeUpdate() > 0;
    statement.close();
    disconnect();
    return rowUpdated;
  }

  public Damage getDamage(int iddamage) throws SQLException {
    Damage damage = null;
    String sql = "SELECT * FROM sys.Damage WHERE idDamage = ? ";

    connect();

    PreparedStatement statement = jdbcConnection.prepareStatement(sql);
    statement.setInt(1, iddamage);

    ResultSet resultSet = statement.executeQuery();

    if (resultSet.next()) {
      int idDamage = resultSet.getInt("idDamage");
      int idMedal = resultSet.getInt("idMedal");
      int Elim = resultSet.getInt("Elim");
      int Dmg = resultSet.getInt("Dmg");
      int idPlayer = resultSet.getInt("idPlayer");

      damage = new Damage(idDamage, idMedal, Elim, Dmg, idPlayer);
    }

    resultSet.close();
    statement.close();

    return damage;
  }

  public List<Damage> listAllDamages(int elim) throws SQLException {
    List<Damage> listdamage = new ArrayList<>();

    String sql = "SELECT * FROM sys.Damage WHERE Elim > " + elim;

    connect();

    PreparedStatement statement = jdbcConnection.prepareStatement(sql);
    ResultSet resultSet = statement.executeQuery(sql);

    while (resultSet.next()) {
      int idDamage = resultSet.getInt("idDamage");
      int idMedal = resultSet.getInt("idMedal");
      int Elim = resultSet.getInt("Elim");
      int Dmg = resultSet.getInt("Dmg");
      int idPlayer = resultSet.getInt("idPlayer");

      Damage damage = new Damage(idDamage, idMedal, Elim, Dmg, idPlayer);
      listdamage.add(damage);
    }

    resultSet.close();
    statement.close();

    disconnect();

    return listdamage;
  }
}
