<?xml version="1.0" encoding="UTF-8"?>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%><vxml version="2.1">
<form>
<%ArrayList al=(ArrayList)request.getAttribute("al"); %>
<field name="fname">
<prompt>PLEASE SELECT A FACULTY NAME FOR MORE DETAILS</prompt>
<%for(Object o:al)
	{
	HashMap hm=(HashMap)o;
	String name=(String)hm.get("fname");%>
	<prompt><%=name %></prompt>
	<%} %>
	<grammar root="fname">
	<rule id="fname">
	<one-of>
	<%for(Object o:al)
	{
		HashMap hm=(HashMap)o;
		String name=(String)hm.get("fname"); %>
		<item><%=name %></item>
		<%} %>
	</one-of>
	</rule>
	</grammar>
</field>
<block>
<submit next="GetFnum"/>
</block>
</form>
</vxml>