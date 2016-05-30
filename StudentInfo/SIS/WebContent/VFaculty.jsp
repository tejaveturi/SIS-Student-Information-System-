<?xml version="1.0" encoding="UTF-8"?>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.controller.DBConnection"%><vxml version="2.1">
<form>
<field name="faculty">
<prompt>PLEASE SELECT A BRANCH FOR FACULTY INFORMATION</prompt>
<%Connection con=DBConnection.getConnection();
Statement st=con.createStatement();
ResultSet rs=null;
String branch=null; 
String qry="select branch from BRANCH";
rs=st.executeQuery(qry);
while(rs.next())
{
	branch=rs.getString(1); %>
	<prompt><%=branch %><break time="small"/></prompt>
	<%} %>
	<grammar root="branch">
<rule id="branch">
<one-of>
<%String qry1="select branch from BRANCH" ;
rs=st.executeQuery(qry1);
while(rs.next())
{
	branch=rs.getString(1); %>
	<item><%=branch %></item>
	<%} %>
	</one-of>
</rule>
</grammar>
</field>
<block>
<submit next="GetFacList"/>
</block>
</form>
</vxml>