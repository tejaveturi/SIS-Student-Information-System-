<?xml version="1.0" encoding="UTF-8"?>
<vxml version="2.1">
<form>
<field name="say">
<%String email=(String)request.getAttribute("email");
String mob=(String)request.getAttribute("mob");
%>
<prompt>SELECTED FACULTY CONTACT NUMBER IS<break time="small"/><say-as interpret-as="vxml:phone"><%=mob %></say-as><break time="small"/>DO YOU WANT TO KNOW MORE INFORMATION SAY YES OR NO TO EXIT</prompt>
<grammar root="attn">
<rule id="attn">
<one-of>
<item>YES</item>
<item>NO</item>
</one-of>
</rule>
</grammar>
</field>
<block>
<if cond="say=='YES'">
<submit next="Shome.jsp"/>
<elseif cond="say=='NO'"/>
<submit next="Thank.jsp"/>
</if>
</block>

</form>
</vxml>
