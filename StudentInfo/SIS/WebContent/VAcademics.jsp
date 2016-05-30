<?xml version="1.0" encoding="UTF-8"?>

<%@page import="java.sql.Connection"%>
<%@page import="com.controller.DBConnection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%><vxml version="2.1">
<form>
<field name="year" type="digits">
<prompt>PLEASE SPECIFY THE YEAR FOR ACADEMIC DETAILS</prompt>
<grammar root="year">
<rule id="year">
<one-of>
<item>1</item>
<item>2</item>
<item>3</item>
<item>4</item>
</one-of>
</rule> 
</grammar>
</field>
<block>
<submit next="GetSem"/>
</block>
</form>
</vxml>