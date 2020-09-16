<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <title>OverWatch Game Statistics</title>
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
<body  >
  
<center>
    <h1 >OverWatch Game Statistics</h1>
</center>
<center>
<a href="#TablePlayer">Table Player</a><br />
<a href="#TableDamage">Table Damage</a><br />
<a href="#TableSupport">Table Support</a><br />
<a href="#TableTank">Table Tank</a><br />
<a href="#TableGame">Table Game</a><br />
<a href="#TableMedal">Table Medal</a><br />
<a href="#TableStack">Table Stack</a><br />
<a href="#TableMap">Table Map</a><br />
<a href="#TableRole">Table Role</a><br />
</center>

<center>
    <h3>
        <a href="newPlayer">Add New Player</a>
        </h3><h3>
        <a href="listPlayer">Display All Player Stats</a>
    </h3>
    <form action="selectPlayer" method="POST">
        <th>ID Player</th><input type="text" id="idPlayer" name="idPlayer" />
        <input type="submit" value="Search" />
    </form>
</center>
<div align="center">
    <table border="2" cellpadding="6" id = "TablePlayer">
        <caption><h3>Display of Player Stats</h3></caption>
        <tr>
        	<th>Edit</th>
            <th>idPlayer</th>
            <th>StartSkillRate</th>
            <th>EndSkillRate</th>
            <th>SkillRateChange</th>
            <th>idDeath</th>
            <th>Delete</th>
        </tr>
        <c:forEach var="Player" items="${listPlayer}">
            <tr>
                <td>
                    <a href="editPlayer?idPlayer=<c:out value='${Player.idPlayer}' />">Edit</a>
                </td>
                <td><c:out value="${Player.idPlayer}" /></td>
                <td><c:out value="${Player.startSkillRate}" /></td>
                <td><c:out value="${Player.endSkillRate}" /></td>
                <td><c:out value="${Player.skillRateChange}" /></td>
                <td><c:out value="${Player.idDeath}" /></td>
                <td>
                    <a href="deletePlayer?idPlayer=<c:out value='${Player.idPlayer}' />">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

<center>
<h3>
    <a href="newDamage">Add New Damage</a>
    </h3><h3>
    <a href="listDamage">Display All Damage Stats</a>
</h3>
 <form action="selectDamage" method="POST">
        <th>ID Damage</th><input type="text" id="idDamage" name="idDamage" />
        <input type="submit" value="Search" />
    </form>
</center>
<div align="center">
    <table border="2" cellpadding="6" id = "TableDamage">
        <caption><h3>Damage Data</h3></caption>
        <tr>
        	<th>Edit</th>
            <th>idDamage</th>
            <th>idMedal</th>
            <th>Elimination</th>
            <th>Damage</th>
            <th>idPlayer</th>
            <th>Delete</th>
        </tr>
        <c:forEach var="damage" items="${listDamage}">
            <tr>
                <td>
                    <a href="editDamage?idDamage=<c:out value='${damage.idDamage}' />">Edit</a>
                   </td>
                <td><c:out value="${damage.idDamage}" /></td>
                <td><c:out value="${damage.idMedal}" /></td>
                <td><c:out value="${damage.elim}" /></td>
                <td><c:out value="${damage.dmg}" /></td>
                <td><c:out value="${damage.idPlayer}" /></td>
                <td>
                    <a href="deleteDamage?idDamage=<c:out value='${damage.idDamage}' />">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

<h3 align="center">
    <a href="newGame">Add New Game</a>
    </h3><h3>
    <a href="listGame">Display All Game Stats</a>

</h3>
 <form action="selectGame" method="POST" align="center">
        <th>ID Game</th><input type="text" id="idGame" name="idGame" />
        <th>Season</th><input type="text" id=Season name="Season" />
        <input type="submit" value="Search" />
    </form>
<div align="center">
    <table border="2" cellpadding="6" id = "TableGame">
        <caption><h3>Game Data</h3></caption>
        <tr>
        	<th>Edit</th>
            <th>idGame</th>
            <th>Season</th>
            <th>TeamSkillRateAvg</th>
            <th>EnemySkillRateavg</th>
            <th>Result</th>
            <th>idLeaver</th>
            <th>idMap</th>
            <th>Delete</th>
        </tr>
        <c:forEach var="game" items="${listGame}">
            <tr>
                <td>
                    <a href="editGame?idGame=<c:out value='${game.idGame}' />">Edit</a>
                    </td>
                <td><c:out value="${game.idGame}" /></td>
                <td><c:out value="${game.season}" /></td>
                <td><c:out value="${game.teamSkillRateAvg}" /></td>
                <td><c:out value="${game.enemySkillRateavg}" /></td>
                <td><c:out value="${game.result}" /></td>
                <td><c:out value="${game.idLeaver}" /></td>
                <td><c:out value="${game.idMap}" /></td>
                <td>
                    <a href="deleteGame?idGame=<c:out value='${game.idGame}' />">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

<!-- <h3>
    <a href="newLeaver">Add New Leaver</a>
    </h3><h3>
    <a href="listLeaver">Display All Leaver Stats</a> -->
<%-- 
</h3>
<div align="center">
    <table border="2" cellpadding="6">
        <caption><h3>Leaver Data</h3></caption>
        <tr>
            <th>idLeaver</th>
            <th>HasLeaver</th>
            <th>Team</th>
            <th>Delete</th>
        </tr>
        <c:forEach var="leaver" items="${listLeaver}">
            <tr>
                <td>
                    <a href="editLeaver?idLeaver=<c:out value='${leaver.idLeaver}' />">Edit</a>
                    </td><td>
                    <a href="deleteLeaver?idLeaver=<c:out value='${leaver.idLeaver}' />">Delete</a>
                </td>
                <td><c:out value="${leaver.idLeaver}" /></td>
                <td><c:out value="${leaver.hasLeaver?'Yes':'No'}" /></td>
                <td><c:out value="${leaver.team}" /></td>
            </tr>
        </c:forEach>
    </table>
</div> --%>

<h3 align="center">
    <a href="newMap">Add New Map</a>
    </h3><h3>
    <a href="listMap">Display All Map Stats</a>

</h3>
 <form action="selectMap" method="POST" align="center">
        <th>ID Map: </th><input type="text" id="idMap" name="idMap" />
        <th>Map Name: </th><input type="text" id="MapName" name="MapName" />
        <input type="submit" value="Search" />
    </form>
</center>
<div align="center">
    <table border="2" cellpadding="6" id = "TableMap">
        <caption><h3>Map Data</h3></caption>
        <tr>
        	<th>Edit</th>
            <th>idMap</th>
            <th>MapName</th>
            <th>Mode</th>
            <th>Delete</th>
        </tr>
        <c:forEach var="map" items="${listMap}">
            <tr>
                <td>
                    <a href="editMap?idMap=<c:out value='${map.idMap}' />">Edit</a>
                    </td>
                <td><c:out value="${map.idMap}" /></td>
                <td><c:out value="${map.mapName}" /></td>
                <td><c:out value="${map.mode}" /></td>
                <td>
                    <a href="deleteMap?idMap=<c:out value='${map.idMap}' />">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

<div align="center">
    <table border="2" cellpadding="6">
        <caption><h3>Map Number of Wins</h3></caption>
        <tr>
            <th>MapName</th>
            <th>Number of Wins</th>
        </tr>
        <c:forEach var="map" items="${listMapW}">
            <tr>
                <td><c:out value="${map.mapName}" /></td>
                <td><c:out value="${map.numWin}" /></td>
            </tr>
        </c:forEach>
    </table>
</div>

<h3 align="center">
    <a href="newMedal">Add New Medal Stat</a>
    </h3><h3>
    <a href="listMedal">Display All Medal Stat</a>

</h3>
 <form action="selectMedal" method="POST" align="center">
        <th>ID Medal</th><input type="text" id="idMedal" name="idMedal" />
        <th>Gold > </th><input type="text" id="Gold" name="Gold" />
        <input type="submit" value="Search" />
    </form>
</center>
<div align="center">
    <table border="2" cellpadding="6" id = "TableMedal">
        <caption><h3>Medal Data</h3></caption>
        <tr>
        	<th>Edit</th>
            <th>idMedal</th>
            <th>Gold</th>
            <th>Silver</th>
            <th>Bronze</th>
            <th>idPlayer</th>
            <th>idGame</th>
            <th>Elim_Medal</th>
            <th>Dmg_Medal</th>
            <th>Obj_Kill_Medal</th>
            <th>Obj_Time_Medal</th>
            <th>Heal_Medal</th>
            <th>Delete</th>
        </tr>
        <c:forEach var="medal" items="${listMedal}">
            <tr>
                <td>
                    <a href="editMedal?idMedal=<c:out value='${medal.idMedal}' />&idGame=<c:out value='${medal.idGame}' />">Edit</a>
                    </td>
                <td><c:out value="${medal.idMedal}" /></td>
                <td><c:out value="${medal.gold}" /></td>
                <td><c:out value="${medal.silver}" /></td>
                <td><c:out value="${medal.bronze}" /></td>
                <td><c:out value="${medal.idPlayer}" /></td>
                <td><c:out value="${medal.idGame}" /></td>
                <td><c:out value="${medal.elim_Medal}" /></td>
                <td><c:out value="${medal.dmg_Medal}" /></td>
                <td><c:out value="${medal.obj_Kill_Medal}" /></td>
                <td><c:out value="${medal.obj_Time_Medal}" /></td>
                <td><c:out value="${medal.heal_Medal}" /></td>
                <td>
                    <a href="deleteMedal?idMedal=<c:out value='${medal.idMedal}' />&idGame=<c:out value='${medal.idGame}' />">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</center>

 <h3 align = "center">
    <a href="newRole">Add New Role</a>
    </h3><h3>
    <a href="listRole">Display All Role Stats</a>

</h3>
<form action="selectRole" method="POST" align="center">
        <th>ID Role</th><input type="text" id="idRole" name="idRole" />
        <th>Role1</th><input type="text" id="Role1" name="Role1" />
        <input type="submit" value="Search" />
    </form>

<div align="center">
    <table id="TableRole" border="2" cellpadding="6">
        <caption><h3>Role Data</h3></caption>
        <tr>
        	<th>Edit</th>
            <th>idRole</th>
            <th>Role1</th>
            <th>Role2</th>
            <th>idPlayer</th>
            <th>idGame</th>
            <th>Delete</th>
        </tr>
        <c:forEach var="role" items="${listRole}">
            <tr>
                <td>
                    <a href="editRole?idRole=<c:out value='${role.idRole}' />">Edit</a>
                    </td>
                <td><c:out value="${role.idRole}" /></td>
                <td><c:out value="${role.role1}" /></td>
                <td><c:out value="${role.role2}" /></td>
                <td><c:out value="${role.idPlayer}" /></td>
                <td><c:out value="${role.idGame}" /></td>
                <td>
                    <a href="deleteRole?idRole=<c:out value='${role.idRole}' />">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div> 

<h3 align="center">
    <a href="newStack">Add New Stack</a>
    </h3><h3>
    <a href="listStack">Display All Stack Stats</a>

</h3>
 <form action="selectStack" method="POST" align="center">
        <th>ID Stack</th><input type="text" id="idStack" name="idStack" />
        <input type="submit" value="Search" />
    </form>
</center>
<div align="center">
    <table border="2" cellpadding="6" id = "TableStack">
        <caption><h3>Stack Data</h3></caption>
        <tr>
        	<th>Edit</th>
            <th>idGame</th>
            <th>TeamStack</th>
            <th>EnemyStack</th>
            <th>Delete</th>
        </tr>
        <c:forEach var="stack" items="${listStack}">
            <tr>
                <td>
                    <a href="editStack?idGame=<c:out value='${stack.idGame}' />">Edit</a>
                    </td>
                <td><c:out value="${stack.idGame}" /></td>
                <td><c:out value="${stack.teamStack}" /></td>
                <td><c:out value="${stack.enemyStack}" /></td>
                <td>
                    <a href="deleteStack?idGame=<c:out value='${stack.idGame}' />">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

<h3 align="center">
    <a href="newSupport">Add New Support</a>
    </h3><h3>
    <a href="listSupport">Display All Support Stats</a>

</h3>
 <form action="selectSupport" method="POST" align="center">
 		<th>idSupport </th><input type="text" id="idSupport" name="idSupport" />
        <th>Heal > </th><input type="text" id="Heal" name="Heal" />
        <input type="submit" value="Search" />
    </form>
</center>
<div align="center">
    <table border="2" cellpadding="6" id = "TableSupport">
        <caption>
            <h3>Support Data</h3>
        </caption>
        <tr>
        	<th>Edit</th>
            <th>idSupport</th>
            <th>idMedal</th>
            <th>Heal</th>
            <th>idPlayer</th>
            <th>Heal_career</th>
            <th>Delete</th>
        </tr>
        <c:forEach var="support" items="${listSupport}">
            <tr>
                <td>
                    <a href="editSupport?idSupport=<c:out value='${support.idSupport}' />">Edit</a>
                    </td>
                <td>
                    <c:out value="${support.idSupport}" />
                </td>
                <td>
                    <c:out value="${support.idMedal}" />
               </td>
               <td>
                    <c:out value="${support.heal}" />
               </td>
                <td>
                    <c:out value="${support.idPlayer}" />
                </td>
                <td>
                    <c:out value="${support.heal_career}" />
                </td>
                <td>
                    <a href="deleteSupport?idSupport=<c:out value='${support.idSupport}' />">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

<h3 align="center">
    <a href="newTank">Add New Tank</a>
    </h3><h3>
    <a href="listTank">Display All Tank Stats</a>

</h3>
 <form action="selectTank" method="POST" align="center">
        <th>ID Tank</th><input type="text" id="idTank" name="idTank" />
        <input type="submit" value="Search" />
    </form>
</center>
<div align="center">
    <table border="2" cellpadding="6" id="TableTank">
        <caption>
            <h3>Tank Data</h3>
        </caption>
        <tr>
         	<th>Edit</th>
            <th>idTank</th>
            <th>idPlayer</th>
            <th>idMedal</th>
            <th>Obj_Time</th>
            <th>Obj_Kill</th>
            <th>Delete</th>
        </tr>
        <c:forEach var="tank" items="${listTank}">
            <tr>
                <td>
                    <a href="editTank?idTank=<c:out value='${tank.idTank}' />">Edit</a>
                     </td>
                <td>
                    <c:out value="${tank.idTank}" />
                </td>
                <td>
                    <c:out value="${tank.idPlayer}" />
                </td>
                <td>
                    <c:out value="${tank.idMedal}" />
                </td>
                <td>
                    <c:out value="${tank.obj_Time}" />
                </td>
                <td>
                    <c:out value="${tank.obj_Kill}" />
                </td>
                <td>
                    <a href="deleteTank?idTank=<c:out value='${tank.idTank}' />">Delete</a>
               </td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>

