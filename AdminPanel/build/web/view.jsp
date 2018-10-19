<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.Calendar"%>
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
		<h1 align='center'>User Information</h1>
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
                                    <%
                                        ResultSet res=(ResultSet)request.getAttribute("message");
                                        ResultSet rs=(ResultSet)request.getAttribute("user_info");
                                        ArrayList<Integer> usid=new ArrayList<Integer>();
                                        ArrayList<String> us=new ArrayList<String>();
                                        while(rs.next())
                                        {
                                            us.add(rs.getString("user"));
                                            usid.add(rs.getInt("uid"));
                                        }
                                        int id=Integer.parseInt(request.getParameter("mid"));
                                    %>


                                    <!--  start product-table ..................................................................................... --><!--  start product-table ..................................................................................... -->
                                    <form id="mainform" name="form1" action="deletemsg?id=<%=id%>&view=true" method="post">
                                        <table border="0" cellpadding="10px" cellspacing="10px" id="product-table">

                                    <%
                                        if(res.next())
                                        {
                                            %>
                                            
                                    <tr class="alternate-row">
                                        <td class="view-width"><b>From :</b> <%=us.get(usid.indexOf(res.getInt("sender")))%>@dmail.com</td>
                                    </tr>
                                    <tr>
                                            <td class="view-width"><b>To :</b> <%=us.get(usid.indexOf(res.getInt("reciever")))%>@dmail.com</td>
                                    </tr>
                                    <tr class="alternate-row">
                                            <td class="view-width"><b>Subject :</b> <%=res.getString("subject")%></td>
                                    </tr>
                                    <tr >
                                            <td class="msg"><%=res.getString("msg")%></td>
                                    </tr>
                                    <tr>
                                        <td  style="border: none;">
                                            <div id="actions-box">
                                                <a href="" class="action-slider"></a>
                                                <div id="actions-box-slider">                                   
                                                    <input type="image" name="delete" value="Delete" class="action-delete">
                                                </div>
                                                <div class="clear"></div>                            
                                            </div>
                                        </td>
                                    </tr>
                                            <%
                                        }
                                    %>
                                </table>
                                </form>
                                <!--  end product-table................................... --> 				
                            </div>
                            <!--  end content-table  -->
                            <!--  start actions-box ............................................... -->
                            
                            <!-- end actions-box........... -->
				<!--  end product-table................................... --> 				
			</div>
			<!--  end content-table  -->
                        <!--  start actions-box ............................................... -->
			
			<!-- end actions-box........... -->
			
			
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