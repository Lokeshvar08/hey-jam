<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 27-01-2021
  Time: 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" href="static/css/userProfileHome.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
</head>
<body>
    <%
        response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");
        String username = (String) session.getAttribute("username");
        if(session.getAttribute("username")==null){
            response.sendRedirect("index.jsp");
        }
    %>
    <nav>
        <h4 style="color: white; font-weight: bold">Hey! <%=username%></h4>
        <a  style="font-size: 12px" href="userProfileHome.jsp">your <b>Institutions</b></a>
        <a style="font-size: 12px" href="#yourjams">your <b>JAMs</b></a>
        <a style="font-size: 12px" href="#partiesandsurveys">throw <b>parties & surveys</b></a>
        <a style="font-size: 12px" href="#notifications">Notifications</a>
        <a style="font-size: 12px" href="#chat">chat</a>
        <form method="get" action="UserInstitutionProfileLogout">
            <input type="submit" value="logout">
        </form>
    </nav>
    <div class="institopnav">
        <h2>You are part of the following <b>Institutions</b></h2>
        <div class="align-right">
            <a type="button" href="findInstitutions.jsp" class="btn btn-dark">FIND INSTITUTION</a>
        </div>
    </div>
    <div class="viewinstitution">
        <table id="allInstitutions" cellpadding="10">
            <tr>
                <th>Institution</th>
                <th>Total participants</th>
                <th>Your status</th>
            </tr>
        </table>
    </div>
</body>
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
<script src="static/js/userProfileHome.js"></script>
</html>