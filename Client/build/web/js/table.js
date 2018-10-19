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
    x.onreadystatechange=
               function getCode()
               {
                   //alert(x.readyState);
                   if(x.readyState===4)
                   {
                       var c=document.getElementById("tr"+id);
                       c.innerHTML="";
                   }
               };
    if(type=="delete")
    {
        x.open("GET","delete?mid="+id,true);
        x.send();       
    }
    else if(type=="sent")
    {
        x.open("GET","delete?mid="+id+"&sent=true",true);
        x.send();       
    }
    else if(type=='trash')
    {
        x.open("GET","delete?mid="+id+"&trash=true",true);
        x.send();       
    }
}