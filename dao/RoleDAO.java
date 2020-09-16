package net.javaee.overwatchstatistics.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import net.javaee.overwatchstatistics.model.Role;

public class RoleDAO extends DAO {
  private String jdbcURL;
  private String jdbcUsername;
  private String jdbcPassword;
  private Connection jdbcConnection;

  public RoleDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
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

  public boolean insertRole(Role r) throws SQLException {
    String sql = "INSERT INTO sys.Role VALUES (?, ?, ?, ?, ?)";

    connect();

    PreparedStatement statement = jdbcConnection.prepareStatement(sql);
    statement.setInt(1, r.getIdRole());

    boolean rowInserted = statement.executeUpdate() > 0;
    statement.close();
    disconnect();
    return rowInserted;
  }

  public List<Role> listAllRole() throws SQLException {
    List<Role> listrole = new ArrayList<>();

    String sql = "SELECT * FROM sys.Role";

    connect();

    Statement statement = jdbcConnection.createStatement();
    ResultSet resultSet = statement.executeQuery(sql);
    while (resultSet.next()) {
      int idRole = resultSet.getInt("idRole");
      String Role1 = resultSet.getString("Role1");
      String Role2 = resultSet.getString("Role2");
      int idPlayer = resultSet.getInt("idPlayer");
      int idGame = resultSet.getInt("idGame");

      Role role = new Role(idRole, Role1, Role2, idPlayer, idGame);
      listrole.add(role);
    }
    resultSet.close();
    statement.close();

    disconnect();

    return listrole;
  }

  public boolean deleteRole(int idRole) throws SQLException {
    String sql = "DELETE FROM sys.Role where idRole = ? ";

    connect();

    PreparedStatement statement = jdbcConnection.prepareStatement(sql);
    statement.setInt(1, idRole);

    boolean rowDeleted = statement.executeUpdate() > 0;
    statement.close();
    disconnect();
    return rowDeleted;
  }

  public boolean updateRole(Role role) throws SQLException {

    String sql = "UPDATE sys.Role SET Role1 = ?, Role2 = ?, idPlayer = ?, idGame = ?  WHERE idRole = ?";
    connect();

    PreparedStatement statement = jdbcConnection.prepareStatement(sql);
    statement.setString(1, role.getRole1());
    statement.setString(2, role.getRole2());
    statement.setInt(3, role.getIdplayer());
    statement.setInt(4, role.getIdgame());
    statement.setInt(5, role.getIdRole());

    boolean rowUpdated = statement.executeUpdate() > 0;
    statement.close();
    disconnect();
    return rowUpdated;
  }

  public Role getRole(int idrole) throws SQLException {
    Role role = null;
    String sql = "SELECT * FROM sys.Role WHERE idRole = ?";

    connect();

    PreparedStatement statement = jdbcConnection.prepareStatement(sql);
    statement.setInt(1, idrole);

    ResultSet resultSet = statement.executeQuery();

    if (resultSet.next()) {
      int idRole = resultSet.getInt("idRole");
      String Role1 = resultSet.getString("Role1");
      String Role2 = resultSet.getString("Role2");
      int idPlayer = resultSet.getInt("idPlayer");
      int idGame = resultSet.getInt("idGame");

      role = new Role(idRole, Role1, Role2, idPlayer, idGame);

    }
    resultSet.close();
    statement.close();

    return role;
  }

  public List<Role> listAllRole(String role1) throws SQLException {
    List<Role> listrole = new ArrayList<>();

    String sql = "SELECT * FROM sys.Role where Role1 = \'" + role1 + "'";

    connect();

    PreparedStatement statement = jdbcConnection.prepareStatement(sql);

    ResultSet resultSet = statement.executeQuery(sql);
    while (resultSet.next()) {
      int idRole = resultSet.getInt("idRole");
      String Role1 = resultSet.getString("Role1");
      String Role2 = resultSet.getString("Role2");
      int idPlayer = resultSet.getInt("idPlayer");
      int idGame = resultSet.getInt("idGame");

      Role role = new Role(idRole, Role1, Role2, idPlayer, idGame);
      listrole.add(role);
    }
    resultSet.close();
    statement.close();

    disconnect();

    return listrole;
  }

}
