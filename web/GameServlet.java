package net.javaee.overwatchstatistics.web;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.javaee.overwatchstatistics.dao.DamageDAO;
import net.javaee.overwatchstatistics.dao.GameDAO;
import net.javaee.overwatchstatistics.dao.LeaverDAO;
import net.javaee.overwatchstatistics.dao.MapDAO;
import net.javaee.overwatchstatistics.dao.MedalDAO;
import net.javaee.overwatchstatistics.dao.PlayerDAO;
import net.javaee.overwatchstatistics.dao.RoleDAO;
import net.javaee.overwatchstatistics.dao.StackDAO;
import net.javaee.overwatchstatistics.dao.SupportDAO;
import net.javaee.overwatchstatistics.dao.TankDAO;
import net.javaee.overwatchstatistics.model.Damage;
import net.javaee.overwatchstatistics.model.Game;
import net.javaee.overwatchstatistics.model.Map;
import net.javaee.overwatchstatistics.model.Medal;
import net.javaee.overwatchstatistics.model.Player;
import net.javaee.overwatchstatistics.model.Role;
import net.javaee.overwatchstatistics.model.Stack;
import net.javaee.overwatchstatistics.model.Support;
import net.javaee.overwatchstatistics.model.Tank;

/**
 * ControllerServlet.java This servlet acts as a page controller for the
 * application, handling all requests from the user.
 *
 * @author www.codejava.net
 */
public class GameServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private DamageDAO damageDAO;
  private GameDAO gameDAO;
  private LeaverDAO leaverDAO;
  private MapDAO mapDAO;
  private MedalDAO medalDAO;
  private PlayerDAO playerDAO;
  private RoleDAO roleDAO;
  private StackDAO stackDAO;
  private SupportDAO supportDAO;
  private TankDAO tankDAO;

  @Override
  public void init() {
    String jdbcURL = getServletContext().getInitParameter("jdbcURL");
    String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
    String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");

    damageDAO = new DamageDAO(jdbcURL, jdbcUsername, jdbcPassword);
    gameDAO = new GameDAO(jdbcURL, jdbcUsername, jdbcPassword);
    leaverDAO = new LeaverDAO(jdbcURL, jdbcUsername, jdbcPassword);
    mapDAO = new MapDAO(jdbcURL, jdbcUsername, jdbcPassword);
    medalDAO = new MedalDAO(jdbcURL, jdbcUsername, jdbcPassword);
    playerDAO = new PlayerDAO(jdbcURL, jdbcUsername, jdbcPassword);
    roleDAO = new RoleDAO(jdbcURL, jdbcUsername, jdbcPassword);
    stackDAO = new StackDAO(jdbcURL, jdbcURL, jdbcPassword);
    supportDAO = new SupportDAO(jdbcURL, jdbcUsername, jdbcPassword);
    tankDAO = new TankDAO(jdbcURL, jdbcURL, jdbcPassword);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String action = request.getServletPath();

    try {
      switch (action) {

        // getall
        case "/selectDamage":
          selectDamage(request, response);
          break;
        case "/newDamage":
          showNewForm(request, response);
          break;
        case "/insertDamage":
          insertDamage(request, response);
          break;
        case "/deleteDamage":
          deleteDamage(request, response);
          break;
        case "/editDamage":
          showEditFormDamage(request, response);
          break;
        case "/updateDamage":
          updateDamage(request, response);
          break;

        case "/selectGame":
          selectGame(request, response);
          break;
        case "/newGame":
          showNewForm(request, response);
          break;
        case "/insertGame":
          insertGame(request, response);
          break;
        case "/updateGame":
          updateGame(request, response);
          break;
        case "/deleteGame":
          deleteGame(request, response);
          break;
        case "/editGame":
          showEditFormGame(request, response);
          break;

        case "/selectMap":
          selectMap(request, response);
          break;
        case "/newMap":
          showNewForm(request, response);
          break;
        case "/insertMap":
          insertMap(request, response);
          break;
        case "/updateMap":
          updateMap(request, response);
          break;
        case "/deleteMap":
          deleteMap(request, response);
          break;
        case "/editMap":
          showEditFormMap(request, response);
          break;

        case "/selectMedal":
          selectMedal(request, response);
          break;
        case "/newMedal":
          showNewForm(request, response);
          break;
        case "/insertMedal":
          insertMedal(request, response);
          break;
        case "/updateMedal":
          updateMedal(request, response);
          break;
        case "/deleteMedal":
          deleteMedal(request, response);
          break;
        case "/editMedal":
          showEditFormMedal(request, response);
          break;

        case "/selectPlayer":
          selectPlayer(request, response);
          break;
        case "/newPlayer":
          showNewForm(request, response);
          break;
        case "/insertPlayer":
          insertPlayer(request, response);
          break;
        case "/updatePlayer":
          updatePlayer(request, response);
          break;
        case "/deletePlayer":
          deletePlayer(request, response);
          break;
        case "/editPlayer":
          showEditFormPlayer(request, response);
          break;

        case "/selectStack":
          selectStack(request, response);
          break;
        case "/newStack":
          showNewForm(request, response);
          break;
        case "/insertStack":
          insertStack(request, response);
          break;
        case "/updateStack":
          updateStack(request, response);
          break;
        case "/deleteStack":
          deleteStack(request, response);
          break;
        case "/editStack":
          showEditFormStack(request, response);
          break;

        case "/selectSupport":
          selectSupport(request, response);
          break;
        case "/newSupport":
          showNewForm(request, response);
          break;
        case "/insertSupport":
          insertSupport(request, response);
          break;
        case "/updateSupport":
          updateSupport(request, response);
          break;
        case "/deleteSupport":
          deleteSupport(request, response);
          break;
        case "/editSupport":
          showEditFormSupport(request, response);
          break;

        case "/selectTank":
          selectTank(request, response);
          break;
        case "/newTank":
          showNewForm(request, response);
          break;
        case "/insertTank":
          insertTank(request, response);
          break;
        case "/updateTank":
          updateTank(request, response);
          break;
        case "/deleteTank":
          deleteTank(request, response);
          break;
        case "/editTank":
          showEditFormTank(request, response);
          break;

        case "/selectRole":
          selectRole(request, response);
          break;
        case "/newRole":
          showNewForm(request, response);
          break;
        case "/insertRole":
          insertRole(request, response);
          break;
        case "/updateRole":
          updateRole(request, response);
          break;
        case "/deleteRole":
          deleteRole(request, response);
          break;
        case "/editRole":
          showEditFormRole(request, response);
          break;

        default:
          listGame(request, response);
          break;
      }
    } catch (SQLException ex) {
      throw new ServletException(ex);
    }
  }

  private void listGame(HttpServletRequest request, HttpServletResponse response)
      throws SQLException, IOException, ServletException {
    List<Damage> listDamage = damageDAO.listAllDamages();
    request.setAttribute("listDamage", listDamage);
    List<Game> listGame = gameDAO.listAllGames();
    request.setAttribute("listGame", listGame);
//    List<Leaver> listLeaver = leaverDAO.listAllLeavers();
//    request.setAttribute("listLeaver", listLeaver);
    List<Map> listMap = mapDAO.listAllMap();
    request.setAttribute("listMap", listMap);
    List<Map> listMapW = mapDAO.listWinRate();
    request.setAttribute("listMapW", listMapW);
    List<Medal> listMedal = medalDAO.listAllMedal();
    request.setAttribute("listMedal", listMedal);
    List<Player> listPlayer = playerDAO.listAllPlayer();
    request.setAttribute("listPlayer", listPlayer);
    List<Role> listRole = roleDAO.listAllRole();
    request.setAttribute("listRole", listRole);
    List<Stack> listStack = stackDAO.listAllStacks();
    request.setAttribute("listStack", listStack);
    List<Support> listSupport = supportDAO.listAllSupports();
    request.setAttribute("listSupport", listSupport);
    List<Tank> listTank = tankDAO.listAllTanks();
    request.setAttribute("listTank", listTank);

    RequestDispatcher dispatcher = request.getRequestDispatcher("GameForm.jsp");
    dispatcher.forward(request, response);
  }

  private void showNewForm(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    RequestDispatcher dispatcher = request.getRequestDispatcher("PlayerForm.jsp");
    dispatcher.forward(request, response);
  }

//  private void showEditForm(HttpServletRequest request, HttpServletResponse response)
//      throws SQLException, ServletException, IOException {
//    String idplayer = request.getParameter("idPlayer");
//    int idPlayer_ = Integer.parseInt(idplayer);
//    Player existingPlayer_ = playerDAO.getPlayer(idPlayer_);
//    request.setAttribute("Player", existingPlayer_);
//
//    if (idplayer == null) {
//
//      int idPlayer = Integer.parseInt(request.getParameter("idPlayer"));
//
//      Player existingPlayer = playerDAO.getPlayer(idPlayer);
//      Support existingSupport = supportDAO.getSupport(idPlayer);
//      Tank existingTank = tankDAO.getTank(idPlayer);
//      Damage existingDamage = damageDAO.getDamage(idPlayer);
//      Role existingRole = roleDAO.getRole(idPlayer);
//      Medal existingMedal = medalDAO.getMedal(idPlayer);
//
//      request.setAttribute("damage", existingDamage);
//      request.setAttribute("support", existingSupport);
//      request.setAttribute("player", existingPlayer);
//      request.setAttribute("tank", existingTank);
//      request.setAttribute("role", existingRole);
//      request.setAttribute("medal", existingMedal);
//    }
//
//    RequestDispatcher dispatcher = request.getRequestDispatcher("PlayerForm.jsp");
//
//    dispatcher.forward(request, response);
//  }

  // ------------------------------------
  // ---------------Damage---------------
  // ------------------------------------

  private void showEditFormDamage(HttpServletRequest request, HttpServletResponse response)
      throws SQLException, ServletException, IOException {
    String id = request.getParameter("idDamage");
    Damage existingDamage_;
    if (id != null) {
      int idDamage_ = Integer.parseInt(id);
      existingDamage_ = damageDAO.getDamage(idDamage_);
    } else {
      return;
    }

    request.setAttribute("damage", existingDamage_);
    RequestDispatcher dispatcher = request.getRequestDispatcher("PlayerForm.jsp");
    dispatcher.forward(request, response);
  }

  private void selectDamage(HttpServletRequest request, HttpServletResponse response)
      throws SQLException, ServletException, IOException {
    int idDamage = Integer
        .parseInt(request.getParameter("idDamage") == "" ? "-1" : request.getParameter("idDamage"));

    Damage damage = damageDAO.getDamage(idDamage);

    List<Damage> listDamage = new ArrayList<>();
    if (idDamage != - 1) {
      if (damageDAO.getDamage(idDamage) != null)
        listDamage.add(damageDAO.getDamage(idDamage));
    } else {
      listDamage = damageDAO.listAllDamages();
    }
    request.setAttribute("listDamage", listDamage);

    RequestDispatcher dispatcher = request.getRequestDispatcher("GameForm.jsp");
    dispatcher.forward(request, response);

  }

  private void insertDamage(HttpServletRequest request, HttpServletResponse response)
      throws SQLException, IOException {
    int idDamage = Integer.parseInt(
        request.getParameter("idDamage") != "" ? request.getParameter("idDamage") : "0");
    int idMedal = Integer
        .parseInt(request.getParameter("idMedal") != "" ? request.getParameter("idMedal") : "0");
    int Elim = Integer
        .parseInt(request.getParameter("Elim") != "" ? request.getParameter("Elim") : "0");
    int Dmg = Integer
        .parseInt(request.getParameter("Dmg") != "" ? request.getParameter("Dmg") : "0");
    int idPlayer = Integer.parseInt(
        request.getParameter("idPlayer") != "" ? request.getParameter("idPlayer") : "0");

    Damage newDamage = new Damage(idDamage, idMedal, Elim, Dmg, idPlayer);
    damageDAO.insertDamage(newDamage);
    response.sendRedirect("list");
  }

  private void updateDamage(HttpServletRequest request, HttpServletResponse response)
      throws SQLException, IOException {
    int idDamage = Integer.parseInt(
        request.getParameter("idDamage") != "" ? request.getParameter("idDamage") : "0");
    int idMedal = Integer
        .parseInt(request.getParameter("idMedal") != "" ? request.getParameter("idMedal") : "0");
    int Elim = Integer
        .parseInt(request.getParameter("Elim") != "" ? request.getParameter("Elim") : "0");
    int Dmg = Integer
        .parseInt(request.getParameter("Dmg") != "" ? request.getParameter("Dmg") : "0");
    int idPlayer = Integer.parseInt(
        request.getParameter("idPlayer") != "" ? request.getParameter("idPlayer") : "0");

    Damage newDamage = new Damage(idDamage, idMedal, Elim, Dmg, idPlayer);

    damageDAO.updateDamage(newDamage);
    response.sendRedirect("list");
  }

  private void deleteDamage(HttpServletRequest request, HttpServletResponse response)
      throws SQLException, IOException {
    int iddamage = Integer.parseInt(request.getParameter("idDamage"));

    damageDAO.deleteDamage(iddamage);
    response.sendRedirect("list");
  }

  // ------------------------------------
  // ----------------Game----------------
  // ------------------------------------

  private void showEditFormGame(HttpServletRequest request, HttpServletResponse response)
      throws SQLException, ServletException, IOException {
    String id = request.getParameter("idGame");
    Game existingGame_;
    if (id != null) {
      int idGame_ = Integer.parseInt(id);
      existingGame_ = gameDAO.getGame(idGame_);
    } else {
      return;
    }

    request.setAttribute("game", existingGame_);
    RequestDispatcher dispatcher = request.getRequestDispatcher("PlayerForm.jsp");
    dispatcher.forward(request, response);
  }

  private void selectGame(HttpServletRequest request, HttpServletResponse response)
      throws SQLException, ServletException, IOException {
    int idGame = Integer
        .parseInt(request.getParameter("idGame") == "" ? "-1" : request.getParameter("idGame"));
    int Season = Integer
        .parseInt(request.getParameter("Season") == "" ? "-1" : request.getParameter("Season"));

    Game game = gameDAO.getGame(idGame);

    List<Game> listGame = new ArrayList<>();
    if (Season != - 1) {
      if (gameDAO.listAllGamesBySeason(Season) != null)
        listGame = gameDAO.listAllGamesBySeason(Season);
    }
    if (idGame != - 1) {
      if (gameDAO.getGame(idGame) != null)
        listGame.add(gameDAO.getGame(idGame));
    }
    if (Season == - 1 && idGame == - 1) {
      listGame = gameDAO.listAllGames();
    }
    request.setAttribute("listGame", listGame);

    RequestDispatcher dispatcher = request.getRequestDispatcher("GameForm.jsp");
    dispatcher.forward(request, response);

  }

  private void insertGame(HttpServletRequest request, HttpServletResponse response)
      throws SQLException, IOException {

    int idGame = Integer
        .parseInt(request.getParameter("idGame") != "" ? request.getParameter("idGame") : "0");
    int Season = Integer
        .parseInt(request.getParameter("Season") != "" ? request.getParameter("Season") : "0");
    int TeamSkillRateAvg = Integer.parseInt(
        request.getParameter("TeamSkillRateAvg") != "" ? request.getParameter("TeamSkillRateAvg")
            : "0");
    int EnemySkillRateavg = Integer.parseInt(
        request.getParameter("EnemySkillRateavg") != "" ? request.getParameter("EnemySkillRateavg")
            : "0");
    String Result = request.getParameter("Result") != "" ? request.getParameter("Result") : "Draw";
    int idLeaver = Integer
        .parseInt(request.getParameter("idLeaver") != "" ? request.getParameter("idLeaver") : "1");
    int idMap = Integer
        .parseInt(request.getParameter("idMap") != "" ? request.getParameter("idMap") : "19");

    Game game = new Game(idGame, Season, TeamSkillRateAvg, EnemySkillRateavg, Result, idLeaver,
        idMap);
    gameDAO.insertGame(game);
    response.sendRedirect("list");
  }

  private void deleteGame(HttpServletRequest request, HttpServletResponse response)
      throws SQLException, IOException {
    int idgame = Integer.parseInt(request.getParameter("idGame"));
    gameDAO.deleteGame(idgame);
    response.sendRedirect("list");
  }

  private void updateGame(HttpServletRequest request, HttpServletResponse response)
      throws SQLException, IOException {
    int idGame = Integer
        .parseInt(request.getParameter("idGame") != "" ? request.getParameter("idGame") : "1");
    int Season = Integer
        .parseInt(request.getParameter("Season") != "" ? request.getParameter("Season") : "0");
    int TeamSkillRateAvg = Integer.parseInt(
        request.getParameter("TeamSkillRateAvg") != "" ? request.getParameter("TeamSkillRateAvg")
            : "0");
    int EnemySkillRateavg = Integer.parseInt(
        request.getParameter("EnemySkillRateavg") != "" ? request.getParameter("EnemySkillRateavg")
            : "0");
    String Result = request.getParameter("Result") != "" ? request.getParameter("Result") : "Draw";
    int idLeaver = Integer
        .parseInt(request.getParameter("idLeaver") != "" ? request.getParameter("idLeaver") : "1");
    int idMap = Integer
        .parseInt(request.getParameter("idMap") != "" ? request.getParameter("idMap") : "19");

    Game game = new Game(idGame, Season, TeamSkillRateAvg, EnemySkillRateavg, Result, idLeaver,
        idMap);
    gameDAO.updateGame(game);
    response.sendRedirect("list");
  }

  // -----------------------------------
  // ----------------Map----------------
  // -----------------------------------
  private void showEditFormMap(HttpServletRequest request, HttpServletResponse response)
      throws SQLException, ServletException, IOException {
    String id = request.getParameter("idMap");
    Map existingMap_;
    if (id != null) {
      int idMap_ = Integer.parseInt(id);
      existingMap_ = mapDAO.getMap(idMap_);
    } else {
      return;
    }

    request.setAttribute("map", existingMap_);
    RequestDispatcher dispatcher = request.getRequestDispatcher("PlayerForm.jsp");
    dispatcher.forward(request, response);
  }

  private void selectMap(HttpServletRequest request, HttpServletResponse response)
      throws SQLException, ServletException, IOException {
    int idMap = Integer
        .parseInt(request.getParameter("idMap") == "" ? "-1" : request.getParameter("idMap"));
    String MapName = request.getParameter("MapName");

    List<Map> listMap = new ArrayList<>();
    if (idMap != - 1) {
      if (mapDAO.getMap(idMap) != null) {
        listMap.add(mapDAO.getMap(idMap));
      }
    }
    if (MapName != "") {
      if (mapDAO.getMap(MapName) != null) {
        listMap.add(mapDAO.getMap(MapName));
      }
    }
    if (idMap == - 1 && MapName == "") {
      listMap = mapDAO.listAllMap();
    }
    request.setAttribute("listMap", listMap);

    RequestDispatcher dispatcher = request.getRequestDispatcher("GameForm.jsp");
    dispatcher.forward(request, response);

  }

  private void insertMap(HttpServletRequest request, HttpServletResponse response)
      throws SQLException, IOException {

    int idMap = Integer
        .parseInt(request.getParameter("idMap") != "" ? request.getParameter("idMap") : "0");
    String MapName = request.getParameter("MapName");
    String Mode = request.getParameter("Mode");

    Map map = new Map(idMap, MapName, Mode);
    mapDAO.insertMap(map);
    response.sendRedirect("list");
  }

  private void deleteMap(HttpServletRequest request, HttpServletResponse response)
      throws SQLException, IOException {
    int idMap = Integer
        .parseInt(request.getParameter("idMap"));
    mapDAO.deleteMap(idMap);
    response.sendRedirect("list");
  }

  private void updateMap(HttpServletRequest request, HttpServletResponse response)
      throws SQLException, IOException {
    String idmap = request.getParameter("idMap");
    if (idmap == "")
      return;
    int idMap = Integer
        .parseInt(idmap);
    String MapName = request.getParameter("MapName");
    String Mode = request.getParameter("Mode");

    Map map = new Map(idMap, MapName, Mode);

    mapDAO.updateMap(map);
    response.sendRedirect("list");
  }

  // ------------------------------------
  // ----------------Medal---------------
  // ------------------------------------
  private void showEditFormMedal(HttpServletRequest request, HttpServletResponse response)
      throws SQLException, ServletException, IOException {
    String id = request.getParameter("idMedal");
    Medal existingMedal_;
    if (id != null) {
      int idMedal_ = Integer.parseInt(id);
      existingMedal_ = medalDAO.getMedal(idMedal_);
    } else {
      return;
    }

    request.setAttribute("medal", existingMedal_);
    RequestDispatcher dispatcher = request.getRequestDispatcher("PlayerForm.jsp");
    dispatcher.forward(request, response);
  }

  private void selectMedal(HttpServletRequest request, HttpServletResponse response)
      throws SQLException, ServletException, IOException {
    int idMedal = Integer
        .parseInt(request.getParameter("idMedal") == "" ? "-1" : request.getParameter("idMedal"));
    int Gold = Integer
        .parseInt(request.getParameter("Gold") == "" ? "-1" : request.getParameter("Gold"));

    List<Medal> listMedal = new ArrayList<>();
    if (Gold != - 1) {
      if (medalDAO.listAllMedal(Gold) != null)
        listMedal = medalDAO.listAllMedal(Gold);
    }
    if (idMedal != - 1) {
      if (medalDAO.getMedal(idMedal) != null)
        listMedal.add(medalDAO.getMedal(idMedal));
    }
    if (Gold == - 1 && idMedal == - 1) {
      listMedal = medalDAO.listAllMedal();
    }
    request.setAttribute("listMedal", listMedal);

    RequestDispatcher dispatcher = request.getRequestDispatcher("GameForm.jsp");
    dispatcher.forward(request, response);

  }

  private void insertMedal(HttpServletRequest request, HttpServletResponse response)
      throws SQLException, IOException {

    String idmedal = request.getParameter("idMedal");
    if (idmedal == "")
      return;
    int idMedal = Integer.parseInt(idmedal);
    int Gold = Integer
        .parseInt(request.getParameter("Gold") != "" ? request.getParameter("Gold") : "0");
    int Silver = Integer
        .parseInt(request.getParameter("Silver") != "" ? request.getParameter("Silver") : "0");
    int Bronze = Integer
        .parseInt(request.getParameter("Bronze") != "" ? request.getParameter("Bronze") : "0");
    int idPlayer = Integer
        .parseInt(request.getParameter("idPlayer") != "" ? request.getParameter("idPlayer") : "1");
    int idGame = Integer
        .parseInt(request.getParameter("idGame") != "" ? request.getParameter("idGame") : "1");
    String Elim_Medal = request
        .getParameter("Elim_Medal");
    String Dmg_Medal = request
        .getParameter("Dmg_Medal");
    String Obj_Kill_Medal = request
        .getParameter("Obj_Kill_Medal");
    String Obj_Time_Medal = request
        .getParameter("Obj_Time_Medal");
    String Heal_Medal = request
        .getParameter("Heal_Medal");

    Medal medal = new Medal(idMedal, Gold, Silver, Bronze,
        idPlayer, idGame, Elim_Medal, Dmg_Medal, Obj_Kill_Medal,
        Obj_Time_Medal, Heal_Medal);
    medalDAO.insertMedal(medal);
    response.sendRedirect("list");
  }

  private void deleteMedal(HttpServletRequest request, HttpServletResponse response)
      throws SQLException, IOException {
    int idMedal = Integer.parseInt(request.getParameter("idMedal"));
    medalDAO.deleteMedal(idMedal);
    response.sendRedirect("list");
  }

  private void updateMedal(HttpServletRequest request, HttpServletResponse response)
      throws SQLException, IOException {
    String idmedal = request.getParameter("idMedal");
    if (idmedal == "")
      return;
    int idMedal = Integer.parseInt(idmedal);
    int Gold = Integer
        .parseInt(request.getParameter("Gold") != "" ? request.getParameter("Gold") : "0");
    int Silver = Integer
        .parseInt(request.getParameter("Silver") != "" ? request.getParameter("Silver") : "0");
    int Bronze = Integer
        .parseInt(request.getParameter("Bronze") != "" ? request.getParameter("Bronze") : "0");
    int idPlayer = Integer
        .parseInt(request.getParameter("idPlayer") != "" ? request.getParameter("idPlayer") : "1");
    int idGame = Integer
        .parseInt(request.getParameter("idGame") != "" ? request.getParameter("idGame") : "1");
    String Elim_Medal = request
        .getParameter("Elim_Medal");
    String Dmg_Medal = request
        .getParameter("Dmg_Medal");
    String Obj_Kill_Medal = request
        .getParameter("Obj_Kill_Medal");
    String Obj_Time_Medal = request
        .getParameter("Obj_Time_Medal");
    String Heal_Medal = request
        .getParameter("Heal_Medal");

    Medal medal = new Medal(idMedal, Gold, Silver, Bronze,
        idPlayer, idGame, Elim_Medal, Dmg_Medal, Obj_Kill_Medal,
        Obj_Time_Medal, Heal_Medal);
    medalDAO.updateMedal(medal);
    response.sendRedirect("list");
  }

  // ------------------------------------
  // ---------------Player---------------
  // ------------------------------------
  private void showEditFormPlayer(HttpServletRequest request, HttpServletResponse response)
      throws SQLException, ServletException, IOException {
    String id = request.getParameter("idPlayer");
    Player existingPlayer_;
    if (id != null) {
      int idPlayer_ = Integer.parseInt(id);
      existingPlayer_ = playerDAO.getPlayer(idPlayer_);
    } else {
      return;
    }

    request.setAttribute("player", existingPlayer_);
    RequestDispatcher dispatcher = request.getRequestDispatcher("PlayerForm.jsp");
    dispatcher.forward(request, response);
  }

  private void selectPlayer(HttpServletRequest request, HttpServletResponse response)
      throws SQLException, ServletException, IOException {
    int idPlayer = Integer
        .parseInt(request.getParameter("idPlayer") == "" ? "-1" : request.getParameter("idPlayer"));

    Player player = playerDAO.getPlayer(idPlayer);

    List<Player> listPlayer = new ArrayList<>();
    if (idPlayer != - 1) {
      if (playerDAO.getPlayer(idPlayer) != null)
        listPlayer.add(playerDAO.getPlayer(idPlayer));
    } else {
      listPlayer = playerDAO.listAllPlayer();
    }
    request.setAttribute("listPlayer", listPlayer);

    RequestDispatcher dispatcher = request.getRequestDispatcher("GameForm.jsp");
    dispatcher.forward(request, response);

  }

  private void insertPlayer(HttpServletRequest request, HttpServletResponse response)
      throws SQLException, IOException {
    String id = request.getParameter("idPlayer");
    if (id == "")
      return;
    int idPlayer = Integer.parseInt(id);
    int StartSkillRate = Integer.parseInt(
        request.getParameter("StartSkillRate") != "" ? request.getParameter("StartSkillRate")
            : "0");
    int EndSkillRate = Integer.parseInt(
        request.getParameter("EndSkillRate") != "" ? request.getParameter("EndSkillRate") : "0");
    int SkillRateChange = Integer.parseInt(
        request.getParameter("SkillRateChange") != "" ? request.getParameter("SkillRateChange")
            : "0");
    int idDeath = Integer
        .parseInt(request.getParameter("idDeath") != "" ? request.getParameter("idDeath") : "0");

    Player player = new Player(idPlayer, StartSkillRate, EndSkillRate, SkillRateChange, idDeath);

    playerDAO.insertPlayer(player);
    response.sendRedirect("list");
  }

  private void deletePlayer(HttpServletRequest request, HttpServletResponse response)
      throws SQLException, IOException {
    int idPlayer = Integer.parseInt(request.getParameter("idPlayer"));

    playerDAO.deletePlayer(idPlayer);
    response.sendRedirect("list");
  }

  private void updatePlayer(HttpServletRequest request, HttpServletResponse response)
      throws SQLException, IOException {
    String id = request.getParameter("idPlayer");
    if (id == "")
      return;
    int idPlayer = Integer.parseInt(id);
    int StartSkillRate = Integer.parseInt(
        request.getParameter("StartSkillRate") != "" ? request.getParameter("StartSkillRate")
            : "0");
    int EndSkillRate = Integer.parseInt(
        request.getParameter("EndSkillRate") != "" ? request.getParameter("EndSkillRate") : "0");
    int SkillRateChange = Integer.parseInt(
        request.getParameter("SkillRateChange") != "" ? request.getParameter("SkillRateChange")
            : "0");
    int idDeath = Integer
        .parseInt(request.getParameter("idDeath") != "" ? request.getParameter("idDeath") : "0");

    Player player = new Player(idPlayer, StartSkillRate, EndSkillRate, SkillRateChange, idDeath);
    playerDAO.updatePlayer(player);
    response.sendRedirect("list");
  }

  // ------------------------------------
  // --------------Support---------------
  // ------------------------------------
  private void showEditFormSupport(HttpServletRequest request, HttpServletResponse response)
      throws SQLException, ServletException, IOException {
    String id = request.getParameter("idSupport");
    Support existingSupport_;
    if (id != null) {
      int idSupport_ = Integer.parseInt(id);
      existingSupport_ = supportDAO.getSupport(idSupport_);
    } else {
      return;
    }

    request.setAttribute("support", existingSupport_);
    RequestDispatcher dispatcher = request.getRequestDispatcher("PlayerForm.jsp");
    dispatcher.forward(request, response);
  }

  private void selectSupport(HttpServletRequest request, HttpServletResponse response)
      throws SQLException, ServletException, IOException {
    int idSupport = Integer
        .parseInt(
            request.getParameter("idSupport") == "" ? "-1" : request.getParameter("idSupport"));
    int Heal = Integer
        .parseInt(request.getParameter("Heal") == "" ? "-1" : request.getParameter("Heal"));

    List<Support> listSupport = new ArrayList<>();
    if (Heal != - 1) {
      if (supportDAO.listAllSupports(Heal) != null)
        listSupport = supportDAO.listAllSupports(Heal);
      else
        listSupport = supportDAO.listAllSupports();
    }
    if (idSupport != - 1) {
      if (supportDAO.getSupport(idSupport) != null)
        listSupport.add(supportDAO.getSupport(idSupport));
    }
    if (idSupport == - 1 && Heal == - 1) {
      listSupport = supportDAO.listAllSupports();
    }
    request.setAttribute("listSupport", listSupport);

    RequestDispatcher dispatcher = request.getRequestDispatcher("GameForm.jsp");
    dispatcher.forward(request, response);

  }

  private void insertSupport(HttpServletRequest request, HttpServletResponse response)
      throws SQLException, IOException {
    String id = request.getParameter("idSupport");
    if (id == "")
      return;
    int idSupport = Integer.parseInt(id);
    int idMedal = Integer
        .parseInt(request.getParameter("idMedal") != "" ? request.getParameter("idMedal") : "1");
    int Heal = Integer
        .parseInt(request.getParameter("Heal") != "" ? request.getParameter("Heal") : "0");
    int idPlayer = Integer
        .parseInt(request.getParameter("idPlayer") != "" ? request.getParameter("idPlayer") : "1");
    int Heal_career = Integer.parseInt(
        request.getParameter("Heal_career") != "" ? request.getParameter("Heal_career") : "0");

    Support support = new Support(idSupport, Heal, Heal_career, idMedal, idPlayer);
    supportDAO.insertSupport(support);
    response.sendRedirect("list");
  }

  private void deleteSupport(HttpServletRequest request, HttpServletResponse response)
      throws SQLException, IOException {
    int idSupport = Integer.parseInt(request.getParameter("idSupport"));

    supportDAO.deleteSupport(idSupport);
    response.sendRedirect("list");
  }

  private void updateSupport(HttpServletRequest request, HttpServletResponse response)
      throws SQLException, IOException {
    String id = request.getParameter("idSupport");
    if (id == "")
      return;
    int idSupport = Integer.parseInt(id);
    int idMedal = Integer
        .parseInt(request.getParameter("idMedal") != "" ? request.getParameter("idMedal") : "1");
    int Heal = Integer
        .parseInt(request.getParameter("Heal") != "" ? request.getParameter("Heal") : "0");
    int idPlayer = Integer
        .parseInt(request.getParameter("idPlayer") != "" ? request.getParameter("idPlayer") : "1");
    int Heal_career = Integer.parseInt(
        request.getParameter("Heal_career") != "" ? request.getParameter("Heal_career") : "0");

    Support support = new Support(idSupport, Heal, Heal_career, idMedal, idPlayer);
    supportDAO.updateSupport(support);
    response.sendRedirect("list");
  }

  // ------------------------------------
  // ----------------Tank----------------
  // ------------------------------------
  private void showEditFormTank(HttpServletRequest request, HttpServletResponse response)
      throws SQLException, ServletException, IOException {
    String id = request.getParameter("idTank");
    Tank existingTank_;
    if (id != null) {
      int idTank_ = Integer.parseInt(id);
      existingTank_ = tankDAO.getTank(idTank_);
    } else {
      return;
    }

    request.setAttribute("tank", existingTank_);
    RequestDispatcher dispatcher = request.getRequestDispatcher("PlayerForm.jsp");
    dispatcher.forward(request, response);
  }

  private void selectTank(HttpServletRequest request, HttpServletResponse response)
      throws SQLException, ServletException, IOException {
    int idTank = Integer
        .parseInt(
            request.getParameter("idTank") == "" ? "-1" : request.getParameter("idTank"));

    List<Tank> listTank = new ArrayList<>();
    if (idTank != - 1) {
      if (tankDAO.getTank(idTank) != null)
        listTank.add(tankDAO.getTank(idTank));
    } else {
      listTank = tankDAO.listAllTanks();
    }
    request.setAttribute("listTank", listTank);

    RequestDispatcher dispatcher = request.getRequestDispatcher("GameForm.jsp");
    dispatcher.forward(request, response);

  }

  private void insertTank(HttpServletRequest request, HttpServletResponse response)
      throws SQLException, IOException {
    String id = request.getParameter("idTank");
    if (id == "")
      return;
    int idTank = Integer.parseInt(id);
    Time Obj_Time = Time.valueOf(
        request.getParameter("Obj_Time") != "" ? request.getParameter("Obj_Time") : "00:00:00");
    int Obj_Kill = Integer
        .parseInt(request.getParameter("Obj_Kill") != "" ? request.getParameter("Obj_Kill") : "0");
    int idPlayer = Integer
        .parseInt(request.getParameter("idPlayer") != "" ? request.getParameter("idPlayer") : "1");
    int idMedal = Integer
        .parseInt(request.getParameter("idMedal") != "" ? request.getParameter("idMedal") : "1");

    Tank tank = new Tank(idTank, idPlayer, idMedal, Obj_Time, Obj_Kill);

    tankDAO.insertTank(tank);
    response.sendRedirect("list");
  }

  private void updateTank(HttpServletRequest request, HttpServletResponse response)
      throws SQLException, IOException {
    String id = request.getParameter("idTank");
    if (id == "")
      return;
    int idTank = Integer.parseInt(id);
    Time Obj_Time = Time.valueOf(
        request.getParameter("Obj_Time") != "" ? request.getParameter("Obj_Time") : "00:00:00");
    int Obj_Kill = Integer
        .parseInt(request.getParameter("Obj_Kill") != "" ? request.getParameter("Obj_Kill") : "0");
    int idPlayer = Integer
        .parseInt(request.getParameter("idPlayer") != "" ? request.getParameter("idPlayer") : "1");
    int idMedal = Integer
        .parseInt(request.getParameter("idMedal") != "" ? request.getParameter("idMedal") : "1");

    Tank tank = new Tank(idTank, idPlayer, idMedal, Obj_Time, Obj_Kill);
    tankDAO.updateTank(tank);
    response.sendRedirect("list");
  }

  private void deleteTank(HttpServletRequest request, HttpServletResponse response)
      throws SQLException, IOException {
    int idtank = Integer.parseInt(request.getParameter("idTank"));

    tankDAO.deleteTank(idtank);
    response.sendRedirect("list");
  }

  // ------------------------------------
  // ----------------Stack---------------
  // ------------------------------------
  private void showEditFormStack(HttpServletRequest request, HttpServletResponse response)
      throws SQLException, ServletException, IOException {
    String id = request.getParameter("idGame");
    Stack existingStack_;
    if (id != null) {
      int idStack_ = Integer.parseInt(id);
      existingStack_ = stackDAO.getStack(idStack_);
    } else {
      return;
    }

    request.setAttribute("stack", existingStack_);
    RequestDispatcher dispatcher = request.getRequestDispatcher("PlayerForm.jsp");
    dispatcher.forward(request, response);
  }

  private void selectStack(HttpServletRequest request, HttpServletResponse response)
      throws SQLException, ServletException, IOException {
    int idStack = Integer
        .parseInt(
            request.getParameter("idGame") == "" ? "-1" : request.getParameter("idGame"));

    List<Stack> listStack = new ArrayList<>();

    if (idStack != - 1) {
      if (stackDAO.getStack(idStack) != null)
        listStack.add(stackDAO.getStack(idStack));
    } else {
      listStack = stackDAO.listAllStacks();
    }
    request.setAttribute("listStack", listStack);

    RequestDispatcher dispatcher = request.getRequestDispatcher("GameForm.jsp");
    dispatcher.forward(request, response);

  }

  private void insertStack(HttpServletRequest request, HttpServletResponse response)
      throws SQLException, IOException {
    String id = request.getParameter("idGame");
    if (id == "")
      return;
    int idGame = Integer.parseInt(id);
    int TeamStack = Integer.parseInt(
        request.getParameter("TeamStack") != "" ? request.getParameter("TeamStack") : "0");
    int EnemyStack = Integer.parseInt(
        request.getParameter("EnemyStack") != "" ? request.getParameter("EnemyStack") : "0");

    Stack stack = new Stack(idGame, TeamStack, EnemyStack);

    stackDAO.insertStack(stack);
    response.sendRedirect("list");
  }

  private void updateStack(HttpServletRequest request, HttpServletResponse response)
      throws SQLException, IOException {
    String id = request.getParameter("idGame");
    if (id == "")
      return;
    int idStack = Integer.parseInt(id);
    int TeamStack = Integer.parseInt(
        request.getParameter("TeamStack") != "" ? request.getParameter("TeamStack") : "0");
    int EnemyStack = Integer.parseInt(
        request.getParameter("EnemyStack") != "" ? request.getParameter("EnemyStack") : "0");

    Stack stack = new Stack(idStack, TeamStack, EnemyStack);

    stackDAO.updateStack(stack);
    response.sendRedirect("list");
  }

  private void deleteStack(HttpServletRequest request, HttpServletResponse response)
      throws SQLException, IOException {
    int idStack = Integer.parseInt(request.getParameter("idGame"));

    stackDAO.deleteStack(idStack);
    response.sendRedirect("list");
  }

  // ------------------------------------
  // ----------------Role----------------
  // ------------------------------------
  private void showEditFormRole(HttpServletRequest request, HttpServletResponse response)
      throws SQLException, ServletException, IOException {
    String id = request.getParameter("idRole");
    Role existingRole_;
    if (id != null) {
      int idRole_ = Integer.parseInt(id);
      existingRole_ = roleDAO.getRole(idRole_);
    } else {
      return;
    }

    request.setAttribute("role", existingRole_);
    RequestDispatcher dispatcher = request.getRequestDispatcher("PlayerForm.jsp");
    dispatcher.forward(request, response);
  }

  private void selectRole(HttpServletRequest request, HttpServletResponse response)
      throws SQLException, ServletException, IOException {
    int idRole = Integer
        .parseInt(
            request.getParameter("idRole") == "" ? "-1" : request.getParameter("idRole"));
    String Role1 = request.getParameter("Role1");

    List<Role> listRole = new ArrayList<>();

    if (idRole != - 1) {
      if (roleDAO.getRole(idRole) != null)
        listRole.add(roleDAO.getRole(idRole));
    }
    if (Role1 != "") {
      if (roleDAO.listAllRole(Role1) != null)
        listRole = roleDAO.listAllRole(Role1);
    }
    if (idRole == - 1 && Role1 == "") {
      listRole = roleDAO.listAllRole();
    }
    request.setAttribute("listRole", listRole);

    RequestDispatcher dispatcher = request.getRequestDispatcher("GameForm.jsp");
    dispatcher.forward(request, response);

  }

  private void insertRole(HttpServletRequest request, HttpServletResponse response)
      throws SQLException, IOException {
    int idRole = Integer
        .parseInt(request.getParameter("idRole") != "" ? request.getParameter("idRole") : "1");
    String Role1 = request.getParameter("Role1") != "" ? request.getParameter("Role1") : "Unknown";
    String Role2 = request.getParameter("Role2") != "" ? request.getParameter("Role2") : "Unknown";
    int idPlayer = Integer
        .parseInt(request.getParameter("idPlayer") != "" ? request.getParameter("idPlayer") : "1");
    int idGame = Integer
        .parseInt(request.getParameter("idGame") != "" ? request.getParameter("idGame") : "1");

    Role role = new Role(idRole, Role1, Role2, idPlayer, idGame);

    roleDAO.insertRole(role);
    response.sendRedirect("list");
  }

  private void deleteRole(HttpServletRequest request, HttpServletResponse response)
      throws SQLException, IOException {
    int idplayer = Integer.parseInt(request.getParameter("idPlayer"));
    roleDAO.deleteRole(idplayer);
    response.sendRedirect("list");
  }

  private void updateRole(HttpServletRequest request, HttpServletResponse response)
      throws SQLException, IOException {
    int idRole = Integer
        .parseInt(request.getParameter("idRole") != "" ? request.getParameter("idRole") : "1");
    String Role1 = request.getParameter("Role1") != "" ? request.getParameter("Role1") : "Unknown";
    String Role2 = request.getParameter("Role2") != "" ? request.getParameter("Role2") : "Unknown";
    int idPlayer = Integer
        .parseInt(request.getParameter("idPlayer") != "" ? request.getParameter("idPlayer") : "1");
    int idGame = Integer
        .parseInt(request.getParameter("idGame") != "" ? request.getParameter("idGame") : "1");

    Role role = new Role(idRole, Role1, Role2, idPlayer, idGame);
    roleDAO.updateRole(role);
    response.sendRedirect("list");
  }
//  private void getAll(HttpServletRequest request, HttpServletResponse response)
//      throws SQLException, IOException, ServletException {
//    int idGame = Integer
//        .parseInt(request.getParameter("idGame") == "" ? "-1" : request.getParameter("idGame"));
//    int idPlayer = Integer
//        .parseInt(request.getParameter("idPlayer") == "" ? "-1" : request.getParameter("idPlayer"));
//
//    Game game = gameDAO.getGame(idGame);
//    Player player = playerDAO.getPlayer(idPlayer);
//
//    List<Game> listGame = new ArrayList<>();
//    if (idGame != - 1) {
//      listGame.add(gameDAO.getGame(idGame));
//    } else {
//      listGame = gameDAO.listAllGames();
//    }
//    request.setAttribute("listGame", listGame);
//
//    List<Player> listPlayer = new ArrayList<>();
//    if (idPlayer != - 1) {
//      listPlayer.add(playerDAO.getPlayer(idPlayer));
//    } else {
//      listPlayer = playerDAO.listAllPlayer();
//    }
//    request.setAttribute("listPlayer", listPlayer);
//
//    List<Support> listSupport = new ArrayList<>();
//    if (idPlayer != - 1) {
//      listSupport.add(supportDAO.getSupport(idPlayer));
//    } else {
//      listSupport = supportDAO.listAllSupports();
//    }
//    request.setAttribute("listSupport", listSupport);
//
//    List<Tank> listTank = new ArrayList<>();
//    if (idPlayer != - 1) {
//      listTank.add(tankDAO.getTank(idPlayer));
//    } else {
//      listTank = tankDAO.listAllTanks();
//    }
//    request.setAttribute("listTank", listTank);
//
//    List<Role> listRole = new ArrayList<>();
//    if (idPlayer != - 1) {
//      listRole.add(roleDAO.getRole(idPlayer));
//    } else {
//      listRole = roleDAO.listAllRole();
//    }
//    request.setAttribute("listRole", listRole);
//
//    RequestDispatcher dispatcher = request.getRequestDispatcher("GameForm.jsp");
//    dispatcher.forward(request, response);
//  }

}
