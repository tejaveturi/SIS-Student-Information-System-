<?xml version="1.0" encoding="UTF-8"?>
<vxml version="2.1">
<form>
<field name="fmenu">
<prompt>PLEASE SELECT A FEE TYPE FOR MORE INFORMATION<break time="small"/>COLLEGE FEE<break time="small"/>EXAM FEE</prompt>
<grammar root="fmenu">
<rule id="fmenu">
<one-of>
<item>COLLEGE FEE</item>
<item>EXAM FEE</item>
</one-of>
</rule>
</grammar>
</field>
<block>
<if cond="fmenu=='COLLEGE FEE'">
<submit next="VFeeDUES.jsp"/>
<elseif cond="fmenu=='EXAM FEE'"/>
<submit next="VFeeDuesE.jsp"/>
</if>
</block>
</form>
</vxml>