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
                                    request.setAttribute("ex", "hi");
                                    if(request.getAttribute("add")!=null)
                                    {
                                        String s=request.getAttribute("add").toString();
                                        if(s.equals("true"))
                                        {
                                %>
				<!--  start message-green -->
				<div id="message-green">
				<table border="0" width="100%" cellpadding="0" cellspacing="0">
				<tr>
					<td class="green-left">User registered successfully. <a href="form">Add new one.</a></td>
					<td class="green-right"><a class="close-green"><img src="images/table/icon_close_green.gif"   alt="" /></a></td>
				</tr>
				</table>
				</div>
				<!--  end message-green -->
                                <%
                                        }
                                    }
                                    int r=10;
                                    int pg=1;
                                    int ind=0;
                                    if(request.getParameter("r")!=null)
                                        r=Integer.parseInt(request.getAttribute("r").toString());
                                    if(request.getParameter("pg")!=null)
                                        pg=Integer.parseInt(request.getAttribute("pg").toString());
                                    ind=(pg-1)*r;
                                    ResultSet res=(ResultSet)request.getAttribute("user_info");
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
                                <form id="mainform" name="form1" action='upduser?ind=<%=ind%>&r=<%=r%>' method='post'>
				<table border="0" width="100%" cellpadding="0" cellspacing="0" id="product-table">
				<tr>
                                    <th id="tha" align="center" class="table-header-check" ><input id='demo_box' class='css-checkbox' name='checkall' type='checkbox' onclick="check_all(document.form1.check,this);"/><label for='demo_box' name='demo_lbl' class='css-label'></label></th>
                                        <th class="table-header-repeat line-left"><a class="info-tooltip" title="<%=srt.equals("uid")?"Descending":"Ascending"%>" href="viewuser?ind=<%=ind%>&r=<%=r%>&sort=uid&<%=srt.equals("uid")?"order=desc":"order=asc"%>">UID</a></th>
					<th class="table-header-repeat line-left minwidth-1"><a class="info-tooltip" title="<%=srt.equals("name")?"Descending":"Ascending"%>" href="viewuser?ind=<%=ind%>&r=<%=r%>&sort=name&<%=srt.equals("name")?"order=desc":"order=asc"%>">Name</a>	</th>
					<th class="table-header-repeat line-left minwidth-1"><a class="info-tooltip" title="<%=srt.equals("user")?"Descending":"Ascending"%>" href="viewuser?ind=<%=ind%>&r=<%=r%>&sort=user&<%=srt.equals("user")?"order=desc":"order=asc"%>">Username</a></th>
                                        <th class="table-header-repeat line-left minwidth-1"><a class="info-tooltip" title="<%=srt.equals("password")?"Descending":"Ascending"%>" href="viewuser?ind=<%=ind%>&r=<%=r%>&sort=password&<%=srt.equals("password")?"order=desc":"order=asc"%>">Password</a></th>
					<th class="table-header-repeat line-left"><a class="info-tooltip" title="<%=srt.equals("gender")?"Descending":"Ascending"%>" href="viewuser?ind=<%=ind%>&r=<%=r%>&sort=gender&<%=srt.equals("gender")?"order=desc":"order=asc"%>">Gender</a></th>
                                        <th class="table-header-repeat line-left minwidth-1"><a class="info-tooltip" title="<%=srt.equals("cityname")?"Descending":"Ascending"%>" href="viewuser?ind=<%=ind%>&r=<%=r%>&sort=cityname&<%=srt.equals("cityname")?"order=desc":"order=asc"%>">City</a></th>
					<th class="table-header-repeat line-left minwidth-1"><a class="info-tooltip" title="<%=srt.equals("phone")?"Descending":"Ascending"%>" href="viewuser?ind=<%=ind%>&r=<%=r%>&sort=phone&<%=srt.equals("phone")?"order=desc":"order=asc"%>">Phone</a></th>
                                        <th class="table-header-repeat line-left minwidth-1"><a class="info-tooltip" title="<%=srt.equals("dob")?"Descending":"Ascending"%>" href="viewuser?ind=<%=ind%>&r=<%=r%>&sort=dob&<%=srt.equals("dob")?"order=desc":"order=asc"%>">Date of Birth</a></th>
                                        <th class="table-header-repeat line-left minwidth-1"><a class="info-tooltip" title="<%=srt.equals("email")?"Descending":"Ascending"%>" href="viewuser?ind=<%=ind%>&r=<%=r%>&sort=email&<%=srt.equals("email")?"order=desc":"order=asc"%>">Email</a></th>
                                        <th class="table-header-repeat line-left minwidth-1"><a href="">Options</a></th>
				</tr>
                                <%
                                    ResultSet rs=(ResultSet)request.getAttribute("city_info");
                                    ArrayList<String> city=new ArrayList<String>();
                                    ArrayList<Integer> cid=new ArrayList<Integer>();
                                    boolean ed=false;
                                    if(res!=null)
                                    {
                                        for(int i=0;res.next();i++)
                                        {
                                            int uid=res.getInt(1);
                                            if(!al.contains(new Integer(uid)))
                                            {
                                                if(i%2==0)
                                                    out.print("<tr id=tr"+uid+">");
                                                else
                                                    out.print("<tr id=tr"+uid+" class='alternate-row'>");
                                                out.print("<td><input id='demo_box_"+uid+"' class='css-checkbox' name='check' type='checkbox' value='"+uid+"'/>");
                                                out.print("<label for='demo_box_"+uid+"' name='demo_lbl_"+uid+"' class='css-label'></label></td>");
                                                out.print("<td id=uid"+uid+">"+res.getInt(1)+"</td>");
                                                out.print("<td id=name"+uid+">"+res.getString(2)+"</td>");
                                                out.print("<td id=user"+uid+">"+res.getString(3)+"</td>");
                                                out.print("<td id=password"+uid+">"+res.getString(4)+"</td>");
                                                out.print("<td id=gen"+uid+">"+res.getString(5)+"</td>");
                                                out.print("<td id=cty"+uid+">"+res.getString(13)+"</td>");
                                                out.print("<td id=phone"+uid+">"+res.getString(7)+"</td>");
                                                out.print("<td id=date"+uid+">"+res.getString(8)+"</td>");
                                                out.print("<td id=email"+uid+">"+res.getString(9)+"</td>");
                                                %>
                                                <td class='options-width'>
                                                    <a href="javascript:onSubmit(<%=uid%>,'edit')"  title='Edit' class='icon-1 info-tooltip'></a>
                                                    <a href="javascript:onSubmit(<%=uid%>,'delete')" title='Delete' class='icon-2 info-tooltip'></a>
                                                    <div id="status<%=uid%>">
                                                        <%
                                                        if(res.getInt(10)==0)
                                                        {
                                                        %>
                                                            <a href="javascript:onSubmit(<%=uid%>,'enable')"  title='Enable' class='icon-3 info-tooltip'></a>
                                                        <%
                                                        } 
                                                        else
                                                        {
                                                        %>
                                                            <a href="javascript:onSubmit(<%=uid%>,'disable')" title='Disable' class='icon-5 info-tooltip'></a>
                                                        <%}
                                                        %>
                                                    </div></td></tr>
                                            <%
                                            }
                                            else
                                            {
                                                while(rs.next())
                                                {
                                                    city.add(rs.getString(3));
                                                    cid.add(rs.getInt(1));
                                                }
                                                ed=true;
                                                if(i%2==0)
                                                    out.print("<tr id=tr"+uid+">");
                                                else
                                                    out.print("<tr id=tr"+uid+" class='alternate-row'>");
                                                //out.print("<td><input name='check' class='css-checkbox' type='checkbox' checked='checked' value='"+uid+"'/></td>");
                                                out.print("<td><input id='demo_box_"+uid+"' class='css-checkbox' name='check' type='checkbox' value='"+uid+"' checked='checked'>");
                                                out.print("<label for='demo_box_"+uid+"' name='demo_lbl_"+uid+"' class='css-label'></label></td>");
                                                out.print("<td>"+uid+"</td>");
                                                out.print("<td><input type='text' id='name"+uid+"' name='name"+uid+"' value='"+res.getString(2)+"'></td>");
                                                out.print("<td><input type='text' id='user"+uid+"' name='user"+uid+"' value='"+res.getString(3)+"'></td>");
                                                out.print("<td><input type='text' id='password"+uid+"' name='password"+uid+"' value='"+res.getString(4)+"'></td>");
                                                out.print("<td><select id='gen"+uid+"' name='gen"+uid+"'>");
                                                out.print("<option value='M'"+(res.getString(5).equals("M")?"selected='selected'":"")+">M</option>");
                                                out.print("<option value='F'"+(res.getString(5).equals("M")?"selected='selected'":"")+">F</option>");
                                                out.print("</select></td>");
                                                out.print("<td><select id='cty"+uid+"' name='cty"+uid+"'>");                                           
                                                for(int in=0;in<city.size();in++)
                                                {
                                                    out.print("<option value='"+cid.get(in)+"'"+(res.getInt(6)==cid.get(in)?"selected='selected'":"")+">"+city.get(in)+"</option>");
                                                }
                                                out.print("</select></td>");
                                                out.print("<td><input type='text' id='phone"+uid+"' name='phone"+uid+"' value='"+res.getString(7)+"'></td>");
                                                out.print("<td><input type='text' id='date"+uid+"' name='date"+uid+"' value='"+res.getString(8)+"'></td>");
                                                out.print("<td><input type='text' id='email"+uid+"' name='email"+uid+"' value='"+res.getString(9)+"'></td>");
                                                out.print("<td class='options-width'>");
                                                out.print("<a href=\"javascript:onSubmit("+uid+",'update')\" title='Save' class='icon-5 info-tooltip'></a></td></tr>");
                                            }
                                        }    
                                    }
                                %>
                                                </div>
				</table>
				<!--  end product-table................................... --> 				
			</div>
			<!--  end content-table  -->
                        <!--  start actions-box ............................................... -->
			<div id="actions-box">
				<a href="javascript:check(document.form1.check)" class="action-slider"></a>
				<div id="actions-box-slider">                                   
                                    <input type="image" name="edit" value="Edit" class="action-edit">
                                    <input type="image" name="update" value="Update" class="action-edit">
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
			<select class='styledselect-day'">
				<option value="">8</option>
                                <option value="" selected="selected">10</option>
				<option value="">12</option>
				<option value="">14</option>
				<option value="">16</option>
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