function branch()
{
	var branch=new XMLHttpRequest();
	branch.open("GET","http://localhost:2015/SIS/DropDowns?action=branches",true);
	branch.send();
	
	branch.onreadystatechange=function()
	{
		if(branch.readyState==4 && branch.status==200)
		{
			var brresp=branch.responseXML;
			var branches=brresp.getElementsByTagName("branchnames");
			var bddown=document.getElementById("bid");
			
			var broption=document.createElement("option");
			broption.text="select";
			
			bddown.add(broption);
			
			alert(branches.length);
			for(var i=0;i<=branches.length;i++)
			{
				var broption=document.createElement("option");
				broption.text=branches[i].childNodes[0].nodeValue;
				
				bddown.add(broption);
			}
		}
	}
}
function year()
{
	var year=new XMLHttpRequest();
	year.open("GET","http://localhost:2015/SIS/DropDowns?action=years",true);
	year.send();
	
	year.onreadystatechange=function()
	{
		if(year.readyState==4 && year.status==200)
		{
			var yrresp=year.responseXML;
			var years=yrresp.getElementsByTagName("yearno");
			var yddown=document.getElementById("year_id");
			
			var yroption=document.createElement("option");
			yroption.text="select";
			
			yddown.add(yroption);
			alert("total years are"+years.length);
			
			for(var i=0;i<=years.length;i++)
			{
				var yroption=document.createElement("option");
				yroption.text=years[i].childNodes[0].nodeValue;
				
				yddown.add(yroption);
			}
		}
	}
}
function semister()
{
	var sem=new XMLHttpRequest();
	var y=document.getElementById("year_id").value;
	sem.open("GET","http://localhost:2015/SIS/DropDowns?action=sem&year="+y,true);
	sem.send();
	
	sem.onreadystatechange=function()
	{
		if(sem.readyState==4 && sem.status==200)
		{
			var semresp=sem.responseXML;
			var sems=semresp.getElementsByTagName("sem");
			var semddown=document.getElementById("semid");
			
			if(semddown.length!=0)
			{
				semddown.length=0;
			}
			var semoption=document.createElement("option");
			semoption.text="select";
			
			semddown.add(semoption);
			alert("total sems are"+sems.length);
			
			for(var i=0;i<=sems.length;i++)
			{
				var semoption=document.createElement("option");
				semoption.text=sems[i].childNodes[0].nodeValue;
				
			semddown.add(semoption);
			}
		}
	}
}