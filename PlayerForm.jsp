
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Overwatch Analyzer</title>
    <style>
       body{
    background-color:#ffff66;}
    h1{
text-algin:center;
text-decoration:underline;
font-family:Georgia;
}
table {
  border-collapse: collapse;
}

table, td, th {
  border-bottom: 1px solid #ddd;
   padding: 15px;
  text-align: left;
}
  tr:hover {background-color: #f5f5f5;}
  </style>
</head>
<body>
<h1  align="center">Overwatch Analyzer</h1>
<div align="center">
    <c:if test="${damage != null}">
    <form action="updateDamage" method="post" color = "Black">
        </c:if>
        <c:if test="${damage == null}">
        <form action="insertDamage" method="post" color = "Black">
            </c:if>
            <table border="1" cellpadding="5">
                <caption>
                    <h2>
                        <c:if test="${damage != null}">
                            Edit Damage
                        </c:if>
                        <c:if test="${damage == null}">
                            Add New Damage
                        </c:if>
                    </h2>
                </caption>
                <tr>
                    <th>Id Damage: </th>
                    <td>
                        <input type="text" name="idDamage" size="45"
                               value="<c:out value='${damage.idDamage}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Id Medal: </th>
                    <td>
                        <input type="text" name="idMedal" size="45"
                               value="<c:out value='${damage.idMedal}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Elimination: </th>
                    <td>
                        <input type="text" name="Elim" size="45"
                               value="<c:out value='${damage.elim}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Damage: </th>
                    <td>
                        <input type="text" name="Dmg" size="45"
                               value="<c:out value='${damage.dmg}' />"
                        />
                    </td>
                </tr>

                <tr>
                    <th>Id Player: </th>
                    <td>
                        <input type="text" name="idPlayer" size="5"
                               value="<c:out value='${damage.idPlayer}' />"
                        />
                    </td>
                </tr>
                <tr align="center">
                    <td colspan="2" align="center">
                        <input type="submit" value="Save" />
                    </td>
                </tr>
            </table>
        </form>
</div>

<div align="center">
    <c:if test="${game != null}">
    <form action="updateGame" method="post">
        </c:if>
        <c:if test="${game  == null}">
        <form action="insertGame" method="post">
            </c:if>
            <table border="1" cellpadding="5">
                <caption>
                    <h2>
                        <c:if test="${game  != null}">
                            Edit Game
                        </c:if>
                        <c:if test="${game  == null}">
                            Add New Game
                        </c:if>
                    </h2>
                </caption>
                <tr>
                    <th>Id Game: </th>
                    <td>
                        <input type="text" name="idGame" size="5"
                               value="<c:out value='${game.idGame}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Season: </th>
                    <td>
                        <input type="text" name="Season" size="5"
                               value="<c:out value='${game.season}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>TeamSkillRateAvg: </th>
                    <td>
                        <input type="text" name="TeamSkillRateAvg" size="5"
                               value="<c:out value='${game.teamSkillRateAvg}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>EnemySkillRateavg: </th>
                    <td>
                        <input type="text" name="EnemySkillRateavg" size="5"
                               value="<c:out value='${game.enemySkillRateavg}' />"
                        />
                    </td>
                </tr>

                <tr>
                    <th>Result: </th>
                    <td>
                        <input type="text" name="Result" size="5"
                               value="<c:out value='${game.result}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>idLeaver: </th>
                    <td>
                        <input type="text" name="idLeaver" size="5"
                               value="<c:out value='${game.idLeaver}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>idMap: </th>
                    <td>
                        <input type="text" name="idMap" size="5"
                               value="<c:out value='${game.idMap}' />"
                        />
                    </td>
                </tr>
                
                <tr align="center">
                    <td colspan="2" align="center">
                        <input type="submit" value="Save" />
                    </td>
                </tr>
            </table>
        </form>
</div>
<%-- <h2>
    <a href="newLeaver">Add Leaver Data</a>
    &nbsp;&nbsp;&nbsp;
    <a href="listLeaver">List All Leaver Data</a>
</h2>
<div align="center">
    <c:if test="${leaver != null}">
    <form action="updateLeaver" method="post">
        </c:if>
        <c:if test="${leaver == null}">
        <form action="insertLeaver" method="post">
            </c:if>
            <table border="1" cellpadding="5">
                <caption>
                    <h2>
                        <c:if test="${leaver != null}">
                            Edit Leaver
                        </c:if>
                        <c:if test="${leaver== null}">
                            Add New Leaver
                        </c:if>
                    </h2>
                </caption>
                <tr>
                    <th>idLeaver: </th>
                    <td>
                        <input type="text" name="idLeaver" size="5"
                               value="<c:out value='${leaver.idLeaver}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Leaver: </th>
                    <td>
                        <input type="text" name="Leaver" size="5"
                               value="<c:out value='${leaver.Leaver}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Team: </th>
                    <td>
                        <input type="text" name="Team" size="5"
                               value="<c:out value='${leaver.Team}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Save" />
                    </td>
                </tr>
            </table>
        </form>
</div>
 --%>

<div align="center">
    <c:if test="${map != null}">
    <form action="updateMap" method="post">
        </c:if>
        <c:if test="${map == null}">
        <form action="insertMap" method="post">
            </c:if>
            <table border="1" cellpadding="5">
                <caption>
                    <h2>
                        <c:if test="${map != null}">
                            Edit Map
                        </c:if>
                        <c:if test="${map== null}">
                            Add New Map
                        </c:if>
                    </h2>
                </caption>
                <tr>
                    <th>idMap: </th>
                    <td>
                        <input type="text" name="idMap" size="5"
                               value="<c:out value='${map.idMap}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>MapName: </th>
                    <td>
                        <input type="text" name="MapName" size="5"
                               value="<c:out value='${map.mapName}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Mode: </th>
                    <td>
                        <input type="text" name="Mode" size="5"
                               value="<c:out value='${map.mode}' />"
                        />
                    </td>
                </tr>
                <tr align="center">
                    <td colspan="2" align="center">
                        <input type="submit" value="Save" />
                    </td>
                </tr>
            </table>
        </form>
</div>

<div align="center">
    <c:if test="${medal != null}">
    <form action="updateMedal" method="post">
        </c:if>
        <c:if test="${medal == null}">
        <form action="insertMedal" method="post">
            </c:if>
            <table border="1" cellpadding="5">
                <caption>
                    <h2>
                        <c:if test="${medal != null}">
                            Edit Medal Stats
                        </c:if>
                        <c:if test="${medal == null}">
                            Add New Medal Stats
                        </c:if>
                    </h2>
                </caption>
                <tr>
                    <th>idMedal: </th>
                    <td>
                        <input type="text" name="idMedal" size="5"
                               value="<c:out value='${medal.idMedal}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Gold: </th>
                    <td>
                        <input type="text" name="Gold" size="5"
                               value="<c:out value='${medel.gold}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Silver: </th>
                    <td>
                        <input type="text" name="Silver" size="5"
                               value="<c:out value='${medel.silver}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Bronze: </th>
                    <td>
                        <input type="text" name="Bronze" size="5"
                               value="<c:out value='${medel.bronze}' />"
                        />
                    </td>
                </tr>

                <tr>
                    <th>idPlayer: </th>
                    <td>
                        <input type="text" name="idPlayer" size="5"
                               value="<c:out value='${medal.idPlayer}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>idGame: </th>
                    <td>
                        <input type="text" name="idGame" size="5"
                               value="<c:out value='${medal.idGame}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Elim_Medal</th>
                    <td>
                        <input type="text" name="Elim_Medal" size="5"
                               value="<c:out value='${medal.elim_Medal}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Dmg_Medal: </th>
                    <td>
                        <input type="text" name="Dmg_Medal" size="5"
                               value="<c:out value='${medal.dmg_Medal}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Obj_Kill_Medal</th>
                    <td>
                        <input type="text" name="Obj_Kill_Medal" size="5"
                               value="<c:out value='${medal.obj_Kill_Medal}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Obj_Time_Medal: </th>
                    <td>
                        <input type="text" name="Obj_Time_Medal" size="5"
                               value="<c:out value='${medal.obj_Time_Medal}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Heal_Medal</th>
                    <td>
                        <input type="text" name="Heal_Medal" size="5"
                               value="<c:out value='${medal.heal_Medal}' />"
                        />
                    </td>
                </tr>
                <tr align="center">
                    <td colspan="2" align="center">
                        <input type="submit" value="Save" />
                    </td>
                </tr>
            </table>
        </form>
</div>

<div align="center">
    <c:if test="${player != null}">
    <form action="updatePlayer" method="post">
        </c:if>
        <c:if test="${player == null}">
        <form action="insertPlayer" method="post">
            </c:if>
            <table border="1" cellpadding="5">
                <caption>
                    <h2>
                        <c:if test="${player != null}">
                            Edit Player
                        </c:if>
                        <c:if test="${player == null}">
                            Add New Player
                        </c:if>
                    </h2>
                </caption>
                <tr>
                    <th>idPlayer: </th>
                    <td>
                        <input type="text" name="idPlayer" size="5"
                               value="<c:out value='${player.idPlayer}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>StartSkillRate: </th>
                    <td>
                        <input type="text" name="StartSkillRate" size="5"
                               value="<c:out value='${player.startSkillRate}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>EndSkillRate:</th>
                    <td>
                        <input type="text" name="EndSkillRate" size="5"
                               value="<c:out value='${player.endSkillRate}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>SkillRateChange:</th>
                    <td>
                        <input type="text" name="SkillRateChange" size="5"
                               value="<c:out value='${player.skillRateChange}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>idDeath:</th>
                    <td>
                        <input type="text" name="idDeath" size="5"
                               value="<c:out value='${player.idDeath}' />"
                        />
                    </td>
                </tr>
                <tr align="center">
                    <td colspan="2" align="center">
                        <input type="submit" value="Save" />
                    </td>
                </tr>
            </table>
        </form>
</div>

<div align="center">
    <c:if test="${role != null}">
    <form action="updateRole" method="post">
        </c:if>
        <c:if test="${role == null}">
        <form action="insertRole" method="post">
            </c:if>
            <table border="1" cellpadding="5">
                <caption>
                    <h2>
                        <c:if test="${role != null}">
                            Edit Role
                        </c:if>
                        <c:if test="${role == null}">
                            Add New Role
                        </c:if>
                    </h2>
                </caption>
                <tr>
                    <th>idRole: </th>
                    <td>
                        <input type="text" name="idRole" size="5"
                               value="<c:out value='${role.idRole}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Role1: </th>
                    <td>
                        <input type="text" name="Role1" size="5"
                               value="<c:out value='${role.role1}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Role2</th>
                    <td>
                        <input type="text" name="Role2" size="5"
                               value="<c:out value='${role.role2}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>idPlayer:</th>
                    <td>
                        <input type="text" name="idPlayer" size="5"
                               value="<c:out value='${role.idPlayer}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>idGame:</th>
                    <td>
                        <input type="text" name="idGame" size="5"
                               value="<c:out value='${role.idGame}' />"
                        />
                    </td>
                </tr>
                <tr align="center">
                    <td colspan="2" align="center">
                        <input type="submit" value="Save" />
                    </td>
                </tr>
            </table>
        </form>
</div>

<div align="center">
    <c:if test="${stack != null}">
    <form action="updateStack" method="post">
        </c:if>
        <c:if test="${stack == null}">
        <form action="insertStack" method="post">
            </c:if>
            <table border="1" cellpadding="5">
                <caption>
                    <h2>
                        <c:if test="${stack != null}">
                            Edit Stack
                        </c:if>
                        <c:if test="${stack == null}">
                            Add New Stack Stat
                        </c:if>
                    </h2>
                </caption>
                <tr>
                    <th>idGame: </th>
                    <td>
                        <input type="text" name="idGame" size="5"
                               value="<c:out value='${stack.idGame}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>TeamStack: </th>
                    <td>
                        <input type="text" name="TeamStack" size="5"
                               value="<c:out value='${stack.teamStack}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>EnemyStack: </th>
                    <td>
                        <input type="text" name="EnemyStack" size="5"
                               value="<c:out value='${stack.enemyStack}' />"
                        />
                    </td>
                </tr>
                <tr align="center">
                    <td colspan="2" align="center">
                        <input type="submit" value="Save" />
                    </td>
                </tr>
            </table>
        </form>
</div>


<div align="center">
    <c:if test="${support != null}">
        <form action="updateSupport" method="post">
    </c:if>
    <c:if test="${support == null}">
        <form action="insertSupport" method="post">
    </c:if>
    <table border="1" cellpadding="5">
        <caption>
            <h2>
                <c:if test="${support != null}">
                    Edit Support
                </c:if>
                <c:if test="${support == null}">
                    Add New Support
                </c:if>
            </h2>
        </caption>
        <tr>
            <th>idSupport: </th>
            <td>
                <input type="text" name="idSupport" size="5" value="<c:out value='${support.idSupport}' />" />
            </td>
        </tr>
        <tr>
            <th>idMedal: </th>
            <td>
                <input type="text" name="idMedal" size="5" value="<c:out value='${support.idMedal}' />" />
            </td>
        </tr>
        <tr>
            <th>Heal:</th>
            <td>
                <input type="text" name="Heal" size="5" value="<c:out value='${support.Heal}' />" />
            </td>
        </tr>
        <tr>
            <th>idPlayer:</th>
            <td>
                <input type="text" name="idPlayer" size="5" value="<c:out value='${support.idPlayer}' />" />
            </td>
        </tr>
        <tr>
            <th>Heal_career:</th>
            <td>
                <input type="text" name="Heal_career" size="5" value="<c:out value='${support.Heal_career}' />" />
            </td>
        </tr>
        <tr align="center">
            <td colspan="2" align="center">
                <input type="submit" value="Save" />
            </td>
        </tr>
    </table>
    </form>
</div>

<div align="center">
    <c:if test="${tank != null}">
        <form action="updateTank" method="post">
    </c:if>
    <c:if test="${tank == null}">
        <form action="insertTank" method="post">
    </c:if>
    <table border="1" cellpadding="5">
        <caption>
            <h2>
                <c:if test="${tank != null}">
                    Edit Tank
                </c:if>
                <c:if test="${tank == null}">
                    Add New Tank
                </c:if>
            </h2>
        </caption>
        <tr>
            <th>idTank: </th>
            <td>
                <input type="text" name="idTank" size="5" value="<c:out value='${tank.idTank}' />" />
            </td>
        </tr>
        <tr>
            <th>idPlayer: </th>
            <td>
                <input type="text" name="idPlayer" size="5" value="<c:out value='${tank.idPlayer}' />" />
            </td>
        </tr>
        <tr>
            <th>idMedal:</th>
            <td>
                <input type="text" name="idMedal" size="5" value="<c:out value='${tank.idMedal}' />" />
            </td>
        </tr>
        <tr>
            <th>Obj_Time:</th>
            <td>
                <input type="text" name="Obj_Time" size="5" value="<c:out value='${tank.obj_Time}' />" />
            </td>
        </tr>
        <tr>
            <th>Obj_Kill:</th>
            <td>
                <input type="text" name="Obj_Kill" size="5" value="<c:out value='${tank.obj_Kill}' />" />
            </td>
        </tr>
        <tr align="center">
            <td colspan="2" align="center">
                <input type="submit" value="Save" />
            </td>
        </tr>
    </table>
    </form>
</div>
</body>
</html>
