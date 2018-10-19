<%@include file="header.jsp" %>	
<div class="clear"></div>
<!--  start nav-outer -->
</div>
<!--  start nav-outer-repeat................................................... END -->

  <div class="clear"></div>
 
<!-- start content-outer ........................................................................................................................START -->
<div id="content-outer">
<!-- start content -->
<div id="content">

	<!--  start page-heading -->
	<div id="page-heading">
            <!--  start message-blue -->
            <div id="message-blue">
            <table border="0" width="100%" cellpadding="0" cellspacing="0">
            <tr>
                <td class="blue-left" align="center">Welcome back,
                    <%
                        Cookie a[]=request.getCookies();
                        if(a!=null)
                            out.print(a[1].getValue());
                    %> 
                    <a href="">View my account.</a> </td>
                <td class="blue-right"><a class="close-blue"><img src="images/table/icon_close_blue.gif"   alt="" /></a></td>
            </tr>
            </table>
            </div>
            <!--<h3>Local Heading</h3>-->
	</div>
	<!-- end page-heading -->
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
		<!--  start content-table-inner ...................................................................... START -->
		<div id="content-table-inner">
		
			<!--  start table-content  -->
			<div id="table-content">
                            <h2 align="center">Email System </h2>
                            <br/>
                            <br/>
                            <br/>
                            <p>This is the main page of an email website developed by Dhwani Vora.</p>
                            <br />
                            <br/>
                            <p>This web application has been designed to provide a basic functioning email system where emails can be sent and recieved.
                            You can also mail attachments. Update your profile to reflect more information about yourself. You can also store contacts here.</p> 
                            <br />
                            <br/>
                            <p>The user can provide their valuable feedback and help improve the website.</p>
			
			<br />
			
			</div>
			<!--  end table-content  -->
	
			<div class="clear"></div>
		 
		</div>
		<!--  end content-table-inner ............................................END  -->
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
<!--  end content-outer........................................................END -->

<div class="clear">&nbsp;</div>
<%@include file="footer.jsp" %>