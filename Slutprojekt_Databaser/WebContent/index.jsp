<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@page import="beans.BaseBean"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dumble</title>
</head>
<body>



	<form action="<%=request.getContextPath()%>/SearchServlet"
		method="post">
		Get from the database:<input type="text" name="searchString"><br>

		<input type="submit" value="Seach">
	</form>

	<%
	// get the results
	ArrayList<BaseBean> searchResults = (ArrayList<BaseBean>) request.getAttribute("searchResult");

	// Remove this for a fun error
	if (!(searchResults == null)) {

		out.print("<p> This is what the database has on your search</p>");

		out.print("<ul>");

		for (int i = 0; i < searchResults.size(); i++) {
			out.print("<li>");
			out.println("NAME: " + searchResults.get(i).getName());
			out.println("DESKRIPTION: " + searchResults.get(i).getDescription());
			out.println("NOTES: " + searchResults.get(i).getNotes());
			out.print("</li>");
		}
		if (searchResults.size() == 0) {
			out.print("Sorry, your search did'nt match anyting in the database");
		}

		out.print("</ul>");
	}
	
	%>











</body>
</html>