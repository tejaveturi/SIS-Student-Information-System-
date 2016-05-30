<?xml version="1.0" encoding="UTF-8"?>
<vxml version="2.1">
<form>
<%String name=(String)session.getAttribute("sname"); %>
<field name="menu">
<prompt>HELLO <%=name %><break time="small"/>WELCOME TO STUDENT INFORMATION SYSTEM<break time="small"/>PLEASE SELECT ONE OF THE OPTIONS FOR MORE INFORMATION<break time="small"/>ACADEMIC INFORMATION<break time="small"/>ATTENDANCE INFORMATION<break time="small"/>FEE DUES<break time="small"/>FACULTY INFORMATION<break time="small"/>FEEDBACK</prompt>
<grammar root="menu">
<rule id="menu">
<one-of>
<item>ACADEMIC INFORMATION</item>
<item>ATTENDANCE INFORMATION</item>
<item>FEE DUES</item>
<item>FACULTY INFORMATION</item>
<item>FEEDBACK</item>
</one-of>
</rule>
</grammar>
</field>
<block>
<if cond="menu=='ACADEMIC INFORMATION'">
<submit next="VAcademics.jsp"/>
<elseif cond="menu=='ATTENDANCE INFORMATION'"/>
<submit next="VAttendance.jsp"/>
<elseif cond="menu=='FEE DUES'"/>
<submit next="VFeeMenu.jsp"/>
<elseif cond="menu=='FACULTY INFORMATION'"/>
<submit next="VFaculty.jsp"/>
<elseif cond="menu=='FEEDBACK'"/>
<submit next="VFeedback.jsp"/>
</if>
</block>
</form>
</vxml>