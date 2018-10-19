function valid(frm)
{
    if(frm.name.value=="")
    {
        alert("Please Enter Name");
        frm.name.focus();
        return false;
    }
    if(frm.user.value=="")
    {
        alert("Please Enter Username");
        frm.user.focus();
        return false;
    }
    if(frm.user.className=="inp-form-error")
    {
        alert("Please Enter Valid Username");
        frm.user.focus();
        return false;
    }
    if(frm.oldpass.value=="")
    {
        alert("Please Enter Your Old Password");
        frm.oldpass.focus();
        return false;
    }
    if(frm.password.value=="")
    {
        alert("Please Enter Password");
        frm.password.focus();
        return false;
    }
    if(frm.password.className=="inp-form-error")
    {
        alert("Please Enter Valid Password");
        frm.password.focus();
        return false;
    }
    if(!(frm.gen[0].checked) && !(frm.gen[1].checked))
    {
        alert("Select Gender");
        frm.gen[0].focus();
        return false;
    }
    if(frm.ct.value=="")
    {
        alert("Select Country");
        frm.ct.focus();
        return false;
    }
    if(frm.st.value=="")
    {
        alert("Select State");
        frm.st.focus();
        return false;
    }
   // alert(frm.cty.value);
    if(frm.cty.value=="")
    {
        alert("Select City");
        frm.cty.focus();
        return false;
    }
    if(frm.phone.value=="")
    {
        alert("Please Enter Phone No");
        frm.phone.focus();
        return false;
    }
    if(!(frm.phone.value.match(/^[0-9]{10,12}$/i)))
    {
        alert("Please Valid Phone no");
        frm.phone.focus();
        return false;
    }
    if(frm.email.value=="")
    {
        alert("Please Enter Email");
        frm.email.focus();
        return false;
    }
    if(!(frm.email.value.match(/^[\w]+([_|\.-][\w]{1,})*@[\w]{2,}([_|\.-][\w]{1,})*\.([a-z]{2,4})$/i) ))
    {
        alert("Enter valid E-mail Id");
        frm.email.focus();
        return false;
    }
}
function validP(frm)
{
    if(frm.oldpass.value=="")
    {
        alert("Please Enter Your Old Password");
        frm.oldpass.focus();
        return false;
    }
    if(frm.password.value=="")
    {
        alert("Please Enter Password");
        frm.password.focus();
        return false;
    }
    if(frm.password.value==frm.oldpass.value)
    {
        alert("New Password cannot be same as Old Password");
        frm.password.focus();
        return false;
    }
    if(frm.password.className=="inp-form-error")
    {
        alert("Please Enter Valid Password");
        frm.password.focus();
        return false;
    }
    if(frm.oldpass.className=="inp-form-error")
    {
        alert("Please Enter Correct Old Password");
        frm.password.focus();
        return false;
    }
    if(frm.password.value!=frm.cpass.value)
    {
        alert("Password don't match!");
        frm.cpass.focus();
        return false;
    }
}
function match(cpass)
{
    var pwd = document.getElementById("password");
    if(pwd.value!=cpass.value)
    {
        var p1=document.getElementById("p1");
        p1.className="error-left";
        var p2=document.getElementById("p2");
        p2.className="error-inner";
        p2.innerHTML="Password doesn't match!";
        document.getElementById("cpass").className="inp-form-error";
    }
    else
    {
        var p1=document.getElementById("p1");
        p1.className=null;
        var p2=document.getElementById("p2");
        p2.className=null;
        p2.innerHTML="";
        document.getElementById("cpass").className="inp-form";
    }
}
function passwordCheck()
{
/*var strongRegex = new RegExp("^(?=.{8,})(?=.*[A-Z]) (?=.*[a-z])(?=.*[0-9])(?=.*\\W).*$", "g");
    var mediumRegex = new RegExp("^(?=.{7,})(((?=.*[A-Z])(?=.*[a-z]))|((?=.*[A-Z])(?=.*[0-9]))|((?=.*[a-z])(?=.*[0-9]))).*$", "g");
    var enoughRegex = new RegExp("(?=.{6,}).*", "g");*/
    var pwd = document.getElementById("password");
     
    if(pwd.value.length < 4) 
    {
        document.getElementById('check1').style.width = "50px";
        document.getElementById('check1').style.background = "red";
        pwd.className="inp-form-error";
        document.getElementById('check').innerHTML = 'Too Short';
    } 
    else if (pwd.value.length > 8) 
    {
        document.getElementById('check1').style.width = "200px";
        document.getElementById('check1').style.background = "green";
        document.getElementById('check').innerHTML = "Strong";
        pwd.className="inp-form";
    } 
    else if (pwd.value.length > 6) 
    {
        document.getElementById('check1').style.width = "150px";
        document.getElementById('check1').style.background = "gray";
        pwd.className="inp-form-error";
        document.getElementById('check').innerHTML = "Medium";
    } 
    else 
    {
        document.getElementById('check1').style.width = "100px";
        document.getElementById('check1').style.background = "#FF8080";
        pwd.className="inp-form-error";
        document.getElementById('check').innerHTML = "Weak";
    }
}
function passCheck()
{
/*var strongRegex = new RegExp("^(?=.{8,})(?=.*[A-Z]) (?=.*[a-z])(?=.*[0-9])(?=.*\\W).*$", "g");
    var mediumRegex = new RegExp("^(?=.{7,})(((?=.*[A-Z])(?=.*[a-z]))|((?=.*[A-Z])(?=.*[0-9]))|((?=.*[a-z])(?=.*[0-9]))).*$", "g");
    var enoughRegex = new RegExp("(?=.{6,}).*", "g");*/
    var pwd = document.getElementById("password");
     
    if(pwd.value.length < 4) 
    {
        document.getElementById('check1').style.width = "50px";
        document.getElementById('check1').style.background = "red";
        pwd.className="inp-form-error";
        document.getElementById('check').innerHTML = 'Too Short';
    } 
    else if (pwd.value.length > 8) 
    {
        document.getElementById('check1').style.width = "200px";
        document.getElementById('check1').style.background = "green";
        document.getElementById('check').innerHTML = "Strong";
    } 
    else if (pwd.value.length > 6) 
    {
        document.getElementById('check1').style.width = "150px";
        document.getElementById('check1').style.background = "gray";
        pwd.className="inp-form-error";
        document.getElementById('check').innerHTML = "Medium";
    } 
    else 
    {
        document.getElementById('check1').style.width = "100px";
        document.getElementById('check1').style.background = "#FF8080";
        pwd.className="inp-form-error";
        document.getElementById('check').innerHTML = "Weak";
    }
}
function getXML()
{
    if(window.XMLHttpRequest)
        return new XMLHttpRequest();
    else
        return new ActiveXObject();
}
function usernameCheck(user)
{
    var x=getXML();
    //alert("hi");
    x.onreadystatechange=
            function getCode()
            {
                //alert(x.readyState);
                if(x.readyState===4)
                {
                    var c=x.responseText;
                    if(c==="true")
                    {
                        var u1=document.getElementById("u1");
                        u1.className="error-left";
                        var u2=document.getElementById("u2");
                        u2.className="error-inner";
                        u2.innerHTML="The username already exists.";
                        document.getElementById("user").className="inp-form-error";
                    }
                    else
                    {
                        var u1=document.getElementById("u1");
                        u1.className=null;
                        var u2=document.getElementById("u2");
                        u2.className=null;
                        u2.innerHTML="";
                        document.getElementById("user").className="inp-form";
                    }    
                    //alert();
                }
            };
     x.open("GET","user?name='"+user.value+"'",true);
     x.send();
}
function checkOldPass()
{
    var x=getXML();
    var oldpass=document.getElementById("oldpass");
    //alert(oldpass.value);
    x.onreadystatechange=
            function getCode()
            {
                //alert(x.readyState);
                if(x.readyState===4)
                {
                    var c=x.responseText;
                    if(c==="true")
                    {
                        var op1=document.getElementById("op1");
                        op1.className="error-left";
                        var op2=document.getElementById("op2");
                        op2.className="error-inner";
                        op2.innerHTML="Incorrect Password!";
                        document.getElementById("oldpass").className="inp-form-error";
                    }
                    else
                    {
                        var op1=document.getElementById("op1");
                        op1.className=null;
                        var op2=document.getElementById("op2");
                        op2.className=null;
                        op2.innerHTML="";
                        document.getElementById("oldpass").className="inp-form";
                    }    
                    //alert();
                }
            };
     x.open("GET","pass?password="+oldpass.value+"",true);
     x.send();
}