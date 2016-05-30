<?xml version="1.0" encoding="UTF-8"?>
<vxml version="2.1">
<form>
<%String amarks=(String)request.getAttribute("amarks");
String perc=(String)request.getAttribute("aper");
String blogs=(String)request.getAttribute("back");%>
<field name="acad">
<prompt>YOUR ACADEMIC MARKS ARE<break time="small"/><%=amarks %><break time="small"/>TOTAL PERCENTAGE IS<break time="small"/><%=perc %><break time="small"/>NUMBER OF BACKLOGS ARE<break time="small"/><%=blogs %></prompt>
<prompt>DO YOU WANT TO KNOW ANTHING MORE SAY YES OR NO TO EXIT</prompt>
<grammar root="acad">
<rule id="acad">
<one-of>
<item>YES</item>
<item>NO</item>
</one-of>
</rule>
</grammar>
</field>
<block>
<if cond="acad=='YES'">
<submit next="Shome.jsp"/>
<elseif cond="acad=='NO'"/>
<submit next="Thank.jsp"/>
</if>
</block>
</form>
</vxml>