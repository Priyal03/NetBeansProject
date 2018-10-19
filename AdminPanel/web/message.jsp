<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@include file="header.jsp"%>
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
		<h1 align='center'>Messages</h1>
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
                                    int r=5;
                                    int pg=1;
                                    int ind=0;
                                    if(request.getAttribute("rows")!=null)
                                        r=Integer.parseInt(request.getAttribute("rows").toString());
                                    if(request.getAttribute("page")!=null)
                                        pg=Integer.parseInt(request.getAttribute("page").toString());
                                    ind=(pg-1)*r;
                                    ResultSet res=(ResultSet)request.getAttribute("message_info");
                                    ResultSet rs=(ResultSet)request.getAttribute("user_info");
                                    ArrayList<Integer> al=new ArrayList<Integer>();
                                    ArrayList<Integer> usid=new ArrayList<Integer>();
                                    ArrayList<String> us=new ArrayList<String>();
                                    if(request.getAttribute("al")!=null)
                                    {
                                        al=(ArrayList<Integer>)(request.getAttribute("al"));
                                    }
                                    String srt="";
                                    if(request.getAttribute("srt")!=null)
                                        srt=request.getAttribute("srt").toString();
                                    while(rs.next())
                                    {
                                        us.add(rs.getString("user"));
                                        usid.add(rs.getInt("uid"));
                                    }
                                %>
		
		 
				<!--  start product-table ..................................................................................... -->
                                <form id="mainform" name="form2" action='delmsg' method='post'>
				<table border="0" width="100%" cellpadding="0" cellspacing="0" id="product-table">
				<tr>
                                    <th id="tha" align="center" class="table-header-check" ><input id='demo_box' class='css-checkbox' name='checkall' type='checkbox' onclick="check_all(document.form2.check,this);"/><label for='demo_box' name='demo_lbl' class='css-label'></label></th>
                                        <th class="table-header-repeat line-left"><a class="info-tooltip" title="<%=srt.equals("mid")?"Descending":"Ascending"%>" href="message?ind=<%=ind%>&r=<%=r%>&sort=mid&<%=srt.equals("mid")?"order=desc":"order=asc"%>">MID</a></th>
					<th class="table-header-repeat line-left "><a class="info-tooltip" title="<%=srt.equals("sender")?"Descending":"Ascending"%>" href="message?ind=<%=ind%>&r=<%=r%>&sort=sender&<%=srt.equals("sender")?"order=desc":"order=asc"%>">From</a></th>
                                        <th class="table-header-repeat line-left "><a class="info-tooltip" title="<%=srt.equals("reciever")?"Descending":"Ascending"%>" href="message?ind=<%=ind%>&r=<%=r%>&sort=reciever&<%=srt.equals("reciever")?"order=desc":"order=asc"%>">To</a></th>
                                        <th class="table-header-repeat line-left "><a class="info-tooltip" title="<%=srt.equals("subject")?"Descending":"Ascending"%>" href="message?ind=<%=ind%>&r=<%=r%>&sort=subject&<%=srt.equals("subject")?"order=desc":"order=asc"%>">Subject</a></th>
					<th class="table-header-repeat line-left minwidth-1"><a class="info-tooltip" title="<%=srt.equals("msg")?"Descending":"Ascending"%>" href="message?ind=<%=ind%>&r=<%=r%>&sort=msg&<%=srt.equals("msg")?"order=desc":"order=asc"%>">Message</a></th>
                                        <th class="table-header-repeat line-left minwidth-1"><a href="">Options</a></th>
				</tr>
                                <%
                                    if(res!=null)
                                    {
                                        for(int i=0;res.next();i++)
                                        {
                                            int mid=res.getInt(1);
                                            if(i%2==0)
                                                out.print("<tr id=tr"+mid+">");
                                            else
                                                out.print("<tr id=tr"+mid+" class='alternate-row'>");
                                            out.print("<td><input id='demo_box_"+mid+"' class='css-checkbox' name='check' type='checkbox' value='"+mid+"'/>");
                                            out.print("<label for='demo_box_"+mid+"' name='demo_lbl_"+mid+"' class='css-label'></label></td>");
                                            out.print("<td id=mid"+mid+">"+res.getInt("mid")+"</td>");
                                            out.print("<td id=from"+mid+">"+us.get(usid.indexOf(res.getInt("sender")))+"</td>");
                                            out.print("<td id=to"+mid+">"+us.get(usid.indexOf(res.getInt("reciever")))+"</td>");
                                            out.print("<td id=subject"+mid+">"+res.getString("subject")+"</td>");
                                            String s=res.getString("msg");
                                            out.print("<td id=msg"+mid+">"+s.substring(0, s.length()<50?s.length():50)+"</td>");
                                            %>
                                            <td class='options-width'>
                                                <a href="view?mid=<%=mid%>"  title='View' class='icon-1 info-tooltip'></a>
                                                <a href="javascript:onSubmitM(<%=mid%>,'delete')" title='Delete' class='icon-2 info-tooltip'></a>
                                            </td></tr>
                                            <%
                                        }    
                                    }
                                %>
				</table>
				<!--  end product-table................................... --> 				
			</div>
			<!--  end content-table  -->
			<!--  start actions-box ............................................... -->
			<div id="actions-box">
				<a href="javascript:check(document.form2.check)" class="action-slider"></a>
				<div id="actions-box-slider">                                   
                                    <input type="image" name="delete" value="Delete"class="action-delete">
				</div>
				<div class="clear"></div>                            
			</div>
                        </form>
			<!-- end actions-box........... -->
			<!--  start paging..................................................... -->
			<table border="0" cellpadding="0" cellspacing="0" id="paging-table">
			<tr>
			<td>
				<%
                                    int t=Integer.parseInt(request.getAttribute("total").toString());
                                    if(ind>0)
                                        out.print("<a href='message?ind="+(ind-r)+"&r="+r+"' class='page-left'></a>");
                            %>
                                <div id="page-info">Page <strong><%=pg%></strong></div>
                            <%
                                    if(ind+r<=t)
                                        out.print("<a href='message?ind="+(ind+r)+"&r="+r+"' class='page-right'></a>");
                            %>
			</td>
			</tr>
			</table>
			<!--  end paging................ -->
			
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