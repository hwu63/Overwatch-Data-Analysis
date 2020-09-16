package net.javaee.overwatchstatistics.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import net.javaee.overwatchstatistics.model.Map;

public class MapDAO extends DAO {
  private String jdbcURL;
  private String jdbcUsername;
  private String jdbcPassword;
  private Connection jdbcConnection;

  public MapDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
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

  public boolean insertMap(Map map) throws SQLException {

    String sql = "INSERT INTO sys.Map VALUES (?, ?, ?)";

    connect();

    PreparedStatement statement = jdbcConnection.prepareStatement(sql);
    statement.setInt(1, map.getIdMap());
    statement.setString(2, map.getMapName());
    statement.setString(3, map.getMode());

    boolean rowInserted = statement.executeUpdate() > 0;
    statement.close();
    disconnect();
    return rowInserted;
  }

  public List<Map> listAllMap() throws SQLException {
    List<Map> listmap = new ArrayList<>();

    String sql = null;
    sql = "SELECT * FROM sys.Map";

    connect();

    Statement statement = jdbcConnection.createStatement();
    ResultSet resultSet = statement.executeQuery(sql);

    while (resultSet.next()) {
      int idMap = resultSet.getInt("idMap");
      String MapName = resultSet.getString("MapName");
      String Mode = resultSet.getString("Mode");

      Map map = new Map(idMap, MapName, Mode);
      listmap.add(map);
    }

    resultSet.close();
    statement.close();

    disconnect();

    return listmap;
  }

  public boolean deleteMap(int idmap) throws SQLException {
    String sql = "DELETE FROM sys.Map where idMap = " + idmap;

    connect();

    PreparedStatement statement = jdbcConnection.prepareStatement(sql);

    boolean rowDeleted = statement.executeUpdate() > 0;
    statement.close();
    disconnect();
    return rowDeleted;
  }

  public boolean updateMap(Map map) throws SQLException {
    String sql = "UPDATE sys.Map SET MapName = ?, Mode = ? WHERE idMap = ?";
    connect();

    PreparedStatement statement = jdbcConnection.prepareStatement(sql);
    statement.setString(1, map.getMapName());
    statement.setString(2, map.getMode());
    statement.setInt(3, map.getIdMap());

    boolean rowUpdated = statement.executeUpdate() > 0;
    statement.close();
    disconnect();
    return rowUpdated;
  }

  public Map getMap(int idmap) throws SQLException {
    Map map = null;
    String sql = "SELECT * FROM sys.Map WHERE idMap = " + idmap;

    connect();

    PreparedStatement statement = jdbcConnection.prepareStatement(sql);

    ResultSet resultSet = statement.executeQuery();

    if (resultSet.next()) {
      int idMap = resultSet.getInt("idMap");
      String MapName = resultSet.getString("MapName");
      String Mode = resultSet.getString("Mode");

      map = new Map(idMap, MapName, Mode);
    }

    resultSet.close();
    statement.close();

    return map;
  }

  public Map getMap(String Mapname) throws SQLException {
    Map map = null;
    String sql = "SELECT * FROM sys.Map WHERE MapName = ?";

    connect();

    PreparedStatement statement = jdbcConnection.prepareStatement(sql);
    statement.setString(1, Mapname);
    ResultSet resultSet = statement.executeQuery();

    if (resultSet.next()) {
      int idMap = resultSet.getInt("idMap");
      String MapName = resultSet.getString("MapName");
      String Mode = resultSet.getString("Mode");

      map = new Map(idMap, MapName, Mode);
    }

    resultSet.close();
    statement.close();

    return map;
  }

  public List<Map> listAllMap(String mode) throws SQLException {
    List<Map> listmap = new ArrayList<>();

    String sql = null;
    sql = "SELECT * FROM sys.Map WHERE Mode = ?";

    connect();

    PreparedStatement statement = jdbcConnection.prepareStatement(sql);
    statement.setString(1, mode);

    ResultSet resultSet = statement.executeQuery(sql);

    while (resultSet.next()) {
      int idMap = resultSet.getInt("idMap");
      String MapName = resultSet.getString("MapName");
      String Mode = resultSet.getString("Mode");

      Map map = new Map(idMap, MapName, Mode);
      listmap.add(map);
    }

    resultSet.close();
    statement.close();

    disconnect();

    return listmap;
  }

  public List<Map> listWinRate() throws SQLException {
    List<Map> listmap = new ArrayList<>();

    String sql = null;
    sql = "SELECT sys.Game.idMap, sys.Map.MapName, count(sys.Game.idMap) as NumWin\n" +
        "    FROM sys.Game join sys.Map\n" +
        "    On sys.Game.idMap = sys.Map.idMap\n" +
        "    WHERE Result = \"Win\"\n" +
        "    Group By sys.Game.idMap\n" +
        "    Order By NumWin desc\n" +
        "    limit 19 offset 1;";

    connect();

    PreparedStatement statement = jdbcConnection.prepareStatement(sql);

    ResultSet resultSet = statement.executeQuery(sql);

    while (resultSet.next()) {
      int idMap = resultSet.getInt("idMap");
      String MapName = resultSet.getString("MapName");
      int NumWin = resultSet.getInt("NumWin");

      Map map = new Map(idMap, MapName, NumWin);
      listmap.add(map);
    }

    resultSet.close();
    statement.close();

    disconnect();

    return listmap;
  }

}
