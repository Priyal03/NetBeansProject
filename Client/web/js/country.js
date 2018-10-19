function getXML()
{
    if(window.XMLHttpRequest)
        return new XMLHttpRequest();
    else
        return new ActiveXObject();
}
function getState(cnt)
{
    var sid=cnt.options[cnt.selectedIndex].value;
    //alert(sid);
    var x=getXML();
    //alert("hi");
    x.onreadystatechange=
            function getCode()
            {
                //alert(x.readyState);
                if(x.readyState===4)
                {
                    var c=document.getElementById("ccid");
                    c.options[cnt.selectedIndex].selected="Selected";
                    document.getElementById("state").innerHTML=x.responseText;
                }
            };
     x.open("GET","state?id="+sid,true);
     x.send();
}
function getCity(st)
{
    var sid=st.options[st.selectedIndex].value;
    //alert(sid);
    var x=getXML();
    //alert("hi");
    x.onreadystatechange=
            function getCode()
            {
                //alert(x.readyState);
                if(x.readyState===4)
                {
                    //var str="<select  name='st' class='styledselect_form_1'><option value='' selected='selected' align='center'>Here</option>";
                    document.getElementById("city").innerHTML=x.responseText;
                    //alert();
                }
            };
     x.open("GET","city?id="+sid,true);
     x.send();
}