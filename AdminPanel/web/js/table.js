function getXML()
{
    if(window.XMLHttpRequest)
        return new XMLHttpRequest();
    else
        return new ActiveXObject();
}
function check_all(checkname, bx) 
{
    for (i = 0; i < checkname.length; i++){
        checkname[i].checked = bx.checked? true:false;
    }
}
function check_1(checkname)
{
    alert("hi");
    var bool=false;
    for (i = 0; i < checkname.length; i++){
        if(checkname[i].checked==true)
        {
            bool=true;            
        }
    }
    var c=document.getElementById("actions-box-slider");
    if(bool==true)
    {
        c.innerHTML="<input type='image' name='update' value='Update' class='action-edit'><input type='image' name='delete' value='Delete' class='action-delete'>";
    }
    else
    {
        c.innerHTML="<input type='image' name='edit' value='Edit' class='action-edit'><input type='image' name='delete' value='Delete' class='action-delete'>";
    }
}
function onSubmit(id,type)
{
    var x=getXML();
    if(type=="edit")
    {
        x.onreadystatechange=
               function getCode()
               {
                   //alert(x.readyState);
                   if(x.readyState===4)
                   {
                       var c=document.getElementById("tr"+id);
                       c.innerHTML=x.responseText;
                   }
               };
        x.open("GET","edituser?id="+id,true);
        x.send();       
    }
    else if(type=="update")
    {
        var n=document.getElementById("name"+id);
        var u=document.getElementById("user"+id);
        var p=document.getElementById("password"+id);
        var gen=document.getElementById("gen"+id);
        var g=gen.options[gen.selectedIndex].value;
        var cty=document.getElementById("cty"+id);
        var c=cty.options[cty.selectedIndex].value;
        var ph=document.getElementById("phone"+id);
        var d=document.getElementById("date"+id);
        var e=document.getElementById("email"+id);
        //alert();
        x.onreadystatechange=
               function getCode()
               {
                   if(x.readyState===4)
                   {
                       var j=document.getElementById("tr"+id);
                       j.innerHTML=x.responseText;
                       onload();
                   }
               };
        x.open("GET","updateuser?id="+id+"&name="+n.value+"&user="+u.value+"&password="+p.value+"&gen="+g+"&cty="+c+"&phone="+ph.value+"&date="+d.value+"&email="+e.value,true);
        x.send();       
    }
    else if(type=="delete")
    {
        x.onreadystatechange=
               function getCode()
               {
                   //alert(x.readyState);
                   if(x.readyState===4)
                   {
                       var c=document.getElementById("tr"+id);
                       document.getElementById("tha").innerHTML="";
                       c.innerHTML="";
                       onload();
                   }
               };
        x.open("GET","deleteuser?id="+id,true);
        x.send();       
    }
    else if(type=="enable"||type=="disable")
    {
        //alert("here");
        x.onreadystatechange=
               function getCode()
               {
                   //alert(x.readyState);
                   if(x.readyState===4)
                   {
                        document.getElementById("status"+id).innerHTML=x.responseText;
                        onload();
                   }
               };
        x.open("GET","changestatus?id="+id+"&status="+type,true);
        x.send();
    }
}
function onSubmitM(id,type)
{
    var x=getXML();
    if(type=="view")
    {
        x.onreadystatechange=
               function getCode()
               {
                   //alert(x.readyState);
                   if(x.readyState===4)
                   {
                       var c=document.getElementById("tr"+id);
                       c.innerHTML=x.responseText;
                   }
               };
        x.open("GET","viewmsg?id="+id,true);
        x.send();       
    }
    else if(type=="delete")
    {
        x.onreadystatechange=
               function getCode()
               {
                   //alert(x.readyState);
                   if(x.readyState===4)
                   {
                       var c=document.getElementById("tr"+id);
                       document.getElementById("tha").innerHTML="";
                       c.innerHTML="";
                       onload();
                   }
               };
        x.open("GET","deletemsg?id="+id,true);
        x.send();       
    }
}