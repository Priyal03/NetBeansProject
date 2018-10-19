<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.Calendar"%>
<%@include file="header.jsp" %>
<script type="text/javascript">
    function redirect()
    {
         window.location = "/AdminPanel/form";
    }
</script>
<div class="clear"></div>
<!--  start nav-outer -->
</div>
<!--  start nav-outer-repeat................................................... END -->
 
 <div class="clear"></div>
 
<!-- start content-outer -->
<div id="content-outer">
<!-- start content -->
<div id="content">


<div id="page-heading"><h1 align='center'>Change Password</h1></div>


<table border="0" width="100%" cellpadding="0" cellspacing="0" id="content-table">
<tr>
	<th rowspan="3" class="sized"><img src="images/shared/side_shadowleft.jpg" width="20" height="300" alt="" /></th>
	<th class="topleft"></th>
	<td id="tbl-border-top">&nbsp;</td>
	<th class="topright"></th>
	<th rowspan="3" class="sized"><img src="images/shared/side_shadowright.jpg" width="20" height="300" alt="" /></th>
</tr>
<tr>
	<td id="tbl-border-left"></td>
	<td>
	<!--  start content-table-inner -->
	<div id="content-table-inner" style="padding-left: 375px;padding-top: 50px;">
	<table border="0" width="100%" cellpadding="0" cellspacing="0">
	<tr valign="top">
	<td>
	
	
		<!--  start step-holder -->
		<!--  end step-holder -->
	
		<!-- start id-form -->
                <form action='changepass' method='post' onsubmit='return validP(this)'>
                    <table border="0" cellpadding="0" cellspacing="0"  id="id-form">
                    <tr>
                            <th valign="top">Old Password:</th>
                            <td><input id="oldpass" name='oldpass' type="password" class="inp-form" onKeyUp="return checkOldPass();"/></td>
                            <td>
                                <div id='op1'></div>
                                <div id='op2'></div>
                            </td>
                    </tr>    
                    <tr>
                            <th valign="top">New Password:</th>
                            <td><input name='password' id='password' type="password" class="inp-form" onKeyUp="return passwordCheck();"/></td>
                    </tr>
                    <tr>
                            <th valign="top"></th>
                            <td>
                                <div id="check1" style="width: 0px; height: 6px; background: red;"></div>
                                <div id="check" style="font-weight: bold; font-family: sans-serif;"></div>
                            </td>
                    </tr>
                    <tr>
                            <th valign="top">Confirm New Password:</th>
                            <td><input id="cpass" name='cpass'type="password" class="inp-form" onKeyUp="return match(this);"/></td>
                            <td>
                                <div id='p1'></div>
                                <div id='p2'></div>
                            </td>
                    </tr>
            <tr>
                    <th>&nbsp;</th>
                    <td valign="top">
                            <input type="submit" value="sub" class="form-submit" />
                            <input type="reset" value="" class="form-reset"  />
                    </td>
                    <td></td>
            </tr>
            </table>
        </form>                                        
	<!-- end id-form  -->

	</td>
	<td>
</td>
</tr>
<tr>
<td><img src="images/shared/blank.gif" width="695" height="1" alt="blank" /></td>
<td></td>
</tr>
</table>
 
<div class="clear"></div>
 

</div>
<!--  end content-table-inner  -->
</td>
<td id="tbl-border-right"></td>
</tr>
<tr>
	<th class="sized bottomleft"></th>
	<td id="tbl-border-bottom">&nbsp;</td>
	<th class="sized bottomright"></th>
</tr>
</table>









 





<div class="clear">&nbsp;</div>

</div>
<!--  end content -->
<div class="clear">&nbsp;</div>
</div>
<!--  end content-outer -->

 

<div class="clear">&nbsp;</div>
<%@include file="footer.jsp" %>