<?xml version="1.0" encoding="UTF-8"?>

<%@page import="java.sql.Connection"%>
<%@page import="com.controller.DBConnection"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>

<%@page import="java.util.ArrayList"%><vxml version="2.1">
<form>
<field name="sem">
<prompt>PLEASE SELECT A SEMISTER FOR MORE DETAILS<break time="small"/></prompt>
<%
ArrayList al=(ArrayList)request.getAttribute("semal");
String sem=null;
for(int i=0;i<al.size();i++)
{
	sem=al.toString();%>
<prompt><%=sem %><break time="small"/></prompt>
<%} %>
<grammar root="sem">
<rule id="sem">
<one-of>
<%for(int i=0;i<al.size();i++)
{
	sem=al.toString(); %>
	<item><%=sem %></item>
	<%} %>
</one-of>
</rule>
</grammar>
</field>
<block>
<submit next="Vacad"/>
</block>
</form>
</vxml>