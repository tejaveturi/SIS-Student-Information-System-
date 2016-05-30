<?xml version="1.0" encoding="UTF-8"?>
<vxml version="2.1">
<form>
<%String collfee=(String)request.getAttribute("collfee");
String paidfee=(String)request.getAttribute("paidfee");
String pendingfee=(String)request.getAttribute("pendingfee");
String pdate=(String)request.getAttribute("pdate");
%>
<field name="acad">
<prompt>YOUR TOTAL FEE IS<break time="small"/><%=collfee %><break time="small"/>THE AMOUNT YOU HAVE PAID IS<break time="small"/><%=paidfee %><break time="small"/>FEE YET TO BE PAID IS<break time="small"/><%=pendingfee %><break time="small"/>LAST DATE TO PAY YOUR FEE IS<break time="small"/><%=pdate %></prompt>
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