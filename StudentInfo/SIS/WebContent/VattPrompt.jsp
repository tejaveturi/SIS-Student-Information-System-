<?xml version="1.0" encoding="UTF-8"?>
<vxml version="2.1">
<form>
<%String aattn=(String)request.getAttribute("aper");
%>
<field name="attn">
<prompt>YOUR ATTENDANCE PERCENTAGE IS<break time="small"/><%=aattn %><break time="small"/></prompt>
<prompt>DO YOU WANT TO KNOW ANYTHING MORE SAY YES OR NO TO EXIT</prompt>
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
<if cond="attn=='YES'">
<submit next="Shome.jsp"/>
<elseif cond="attn=='NO'"/>
<submit next="Thank.jsp"/>
</if>
</block>
</form>
</vxml>