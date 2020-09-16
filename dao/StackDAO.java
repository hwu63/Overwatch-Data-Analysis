package net.javaee.overwatchstatistics.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import net.javaee.overwatchstatistics.model.Stack;

public class StackDAO extends DAO {
  private String jdbcURL;
  private String jdbcUsername;
  private String jdbcPassword;
  private Connection jdbcConnection;

  public StackDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
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

  public boolean insertStack(Stack stack) throws SQLException {

    String sql = "INSERT INTO sys.Stack VALUES (?, ?, ?)";

    connect();

    PreparedStatement statement = jdbcConnection.prepareStatement(sql);
    statement.setInt(1, stack.getIdGame());
    statement.setInt(2, stack.getTeamStack());
    statement.setInt(3, stack.getEnemyStack());

    boolean rowInserted = statement.executeUpdate() > 0;
    statement.close();
    disconnect();
    return rowInserted;
  }

  public List<Stack> listAllStacks() throws SQLException {
    List<Stack> liststack = new ArrayList<>();

    String sql = "SELECT * FROM sys.Stack";

    connect();

    Statement statement = jdbcConnection.createStatement();
    ResultSet resultSet = statement.executeQuery(sql);

    while (resultSet.next()) {
      int idGame = resultSet.getInt("idGame");
      int TeamStack = resultSet.getInt("TeamStack");
      int EnemyStack = resultSet.getInt("EnemyStack");

      Stack stack = new Stack(idGame, TeamStack, EnemyStack);
      liststack.add(stack);
    }

    resultSet.close();
    statement.close();

    disconnect();

    return liststack;
  }

  public boolean deleteStack(int idGame) throws SQLException {
    String sql = "DELETE FROM sys.Stack where idGame = ?";

    connect();

    PreparedStatement statement = jdbcConnection.prepareStatement(sql);
    statement.setInt(1, idGame);

    boolean rowDeleted = statement.executeUpdate() > 0;
    statement.close();
    disconnect();
    return rowDeleted;
  }

  public boolean updateStack(Stack stack) throws SQLException {
    String sql = "UPDATE sys.Stack SET TeamStack = ?, EnemyStack = ?"
        + " WHERE idGame = ?";
    connect();
    PreparedStatement statement = jdbcConnection.prepareStatement(sql);
    // statement.setInt(1, stack.getYear());
    statement.setInt(1, stack.getTeamStack());
    statement.setInt(2, stack.getEnemyStack());
    statement.setInt(3, stack.getIdGame());

    boolean rowUpdated = statement.executeUpdate() > 0;
    statement.close();
    disconnect();
    return rowUpdated;
  }

  public Stack getStack(int idgame) throws SQLException {
    Stack stack = null;
    String sql = "SELECT * FROM sys.Stack WHERE idGame = ?";

    connect();

    PreparedStatement statement = jdbcConnection.prepareStatement(sql);
    statement.setInt(1, idgame);

    ResultSet resultSet = statement.executeQuery();

    if (resultSet.next()) {
      int idGame = resultSet.getInt("idGame");
      int TeamStack = resultSet.getInt("TeamStack");
      int EnemyStack = resultSet.getInt("EnemyStack");

      stack = new Stack(idGame, TeamStack, EnemyStack);

    }

    resultSet.close();
    statement.close();

    return stack;
  }

  public List<Stack> listAllStacks(int team_stack) throws SQLException {
    List<Stack> liststack = new ArrayList<>();

    String sql = "SELECT * FROM sys.Stack where TeamStack > " + team_stack;

    connect();

    PreparedStatement statement = jdbcConnection.prepareStatement(sql);
    ResultSet resultSet = statement.executeQuery(sql);

    while (resultSet.next()) {
      int idGame = resultSet.getInt("idGame");
      int TeamStack = resultSet.getInt("TeamStack");
      int EnemyStack = resultSet.getInt("EnemyStack");

      Stack stack = new Stack(idGame, TeamStack, EnemyStack);
      liststack.add(stack);
    }

    resultSet.close();
    statement.close();

    disconnect();

    return liststack;
  }
}
