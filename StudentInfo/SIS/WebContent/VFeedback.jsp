<?xml version="1.0" encoding="UTF-8"?>
<vxml version="2.1">
<form> 
<field name="feed"> 
<prompt>
PLEASE GIVE YOUR FEEDBACK REGARDING THE APPLICATION BY SELECTING ANY ONE OF THE OPTIONS<break time="small"/>EXCELLENT<break time="small"/>GOOD<break time="small"/>AVERAGE<break time="small"/>POOR 
</prompt>
<grammar root="feed">
<rule id="feed">
<one-of>
<item>EXCELLENT</item>
<item>GOOD</item>
<item>AVERAGE</item>
<item>POOR</item>
</one-of>
</rule>
</grammar>
</field>
<block>
<submit next="StoreFeed"/>
</block>
</form>
</vxml>