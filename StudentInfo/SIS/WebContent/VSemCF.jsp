<?xml version="1.0" encoding="UTF-8"?>

<%@page import="java.sql.Connection"%>
<%@page import="com.controller.DBConnection"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%><vxml version="2.1">
<form>
<%String year=request.getParameter("year");
session.setAttribute("year",year);
%>
<field name="sem">
<prompt>PLEASE SELECT A SEMISTER FOR MORE DETAILS<break time="small"/></prompt>
<%
Connection con=DBConnection.getConnection();
Statement st=con.createStatement();
ResultSet rs=null;
String sem=null; 
String qry="select SEM from SEMESTER where YEAR='"+year+"'";
rs=st.executeQuery(qry);
while(rs.next())
{
	sem=rs.getString(1);
%>
<prompt><%=sem %><break time="small"/></prompt>
<%} %>
<grammar root="sem">
<rule id="sem">
<one-of>
<%String qry1="select SEM from SEMESTER where YEAR='"+year+"'";
rs=st.executeQuery(qry1);
while(rs.next())
{
	sem=rs.getString(1); %>
	<item><%=sem %></item>
	<%} %>
</one-of>
</rule>
</grammar>
</field>
<block>
<submit next="Collegefee"/>
</block>
</form>
</vxml>