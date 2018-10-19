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
		<h1 align='center'>Feedback</h1>
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
                                    ResultSet res=(ResultSet)request.getAttribute("feedback_info");
                                    ArrayList<Integer> al=new ArrayList<Integer>();
                                    if(request.getAttribute("al")!=null)
                                    {
                                        al=(ArrayList<Integer>)(request.getAttribute("al"));
                                    }
                                    String srt="";
                                    if(request.getAttribute("srt")!=null)
                                        srt=request.getAttribute("srt").toString();
                                    
                                %>
		
		 
				<!--  start product-table ..................................................................................... -->
                                <form id="mainform" name="form3" action='delmsg' method='post'>
				<table border="0" width="100%" cellpadding="0" cellspacing="0" id="product-table">
				<tr>
                                    <th id="tha" align="center" class="table-header-check" ><input id='demo_box' class='css-checkbox' name='checkall' type='checkbox' onclick="check_all(document.form2.check,this);"/><label for='demo_box' name='demo_lbl' class='css-label'></label></th>
                                        <th class="table-header-repeat line-left"><a class="info-tooltip" title="<%=srt.equals("fid")?"Descending":"Ascending"%>" href="feedback?sort=fid&<%=srt.equals("fid")?"order=desc":"order=asc"%>">FID</a></th>
                                        <th class="table-header-repeat line-left"><a class="info-tooltip" title="<%=srt.equals("uid")?"Descending":"Ascending"%>" href="feedback?sort=uid&<%=srt.equals("uid")?"order=desc":"order=asc"%>">UID</a></th>
					<th class="table-header-repeat line-left "><a class="info-tooltip" title="<%=srt.equals("user")?"Descending":"Ascending"%>" href="feedback?sort=user&<%=srt.equals("user")?"order=desc":"order=asc"%>">Username</a></th>
                                        <th class="table-header-repeat line-left "><a class="info-tooltip" title="<%=srt.equals("feedb")?"Descending":"Ascending"%>" href="feedback?sort=feedb&<%=srt.equals("feedb")?"order=desc":"order=asc"%>">Feedback</a></th>
                                        <th class="table-header-repeat line-left minwidth-1"><a href="">Options</a></th>
				</tr>
                                <%
                                    if(res!=null)
                                    {
                                        for(int i=0;res.next();i++)
                                        {
                                            int fid=res.getInt(1);
                                            if(i%2==0)
                                                out.print("<tr id=tr"+fid+">");
                                            else
                                                out.print("<tr id=tr"+fid+" class='alternate-row'>");
                                            out.print("<td><input id='demo_box_"+fid+"' class='css-checkbox' name='check' type='checkbox' value='"+fid+"'/>");
                                            out.print("<label for='demo_box_"+fid+"' name='demo_lbl_"+fid+"' class='css-label'></label></td>");
                                            out.print("<td id=fid"+fid+">"+res.getInt(1)+"</td>");
                                            out.print("<td id=uid"+fid+">"+res.getInt(2)+"</td>");
                                            out.print("<td id=user"+fid+">"+res.getString("user")+"</td>");
                                            out.print("<td id=feedb"+fid+">"+res.getString("feedb")+"</td>");
                                            %>
                                            <td class='options-width'>
                                                <a href="javascript:onSubmitM(<%=fid%>,'edit')"  title='Edit' class='icon-1 info-tooltip'></a>
                                                <a href="javascript:onSubmitM(<%=fid%>,'delete')" title='Delete' class='icon-2 info-tooltip'></a>
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
				<a href="javascript:check(document.form3.check)" class="action-slider"></a>
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
				<a href="" class="page-far-left"></a>
				<a href="" class="page-left"></a>
				<div id="page-info">Page <strong>1</strong> / 15</div>
				<a href="" class="page-right"></a>
				<a href="" class="page-far-right"></a>
			</td>
			<td>
			<select  class="styledselect_pages">
				<option value="">Number of rows</option>
				<option value="">1</option>
				<option value="">2</option>
				<option value="">3</option>
			</select>
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