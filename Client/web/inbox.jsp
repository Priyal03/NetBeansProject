<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.Calendar"%>
<%@include file="header.jsp" %>
<%@include file="left.jsp" %>
<div id="table-content">        
    <%
                
                                    int r=10;
                                    int pg=1;
                                    int ind=0;
                                    
                                    ind=(pg-1)*r;
                                    ResultSet res=(ResultSet)request.getAttribute("message_info");
                                    String srt="";
                                    if(request.getAttribute("srt")!=null)
                                        srt=request.getAttribute("srt").toString();
                                    if(res.next())
                                    {
                                %>
		
			
				<!--  start product-table ..................................................................................... --><!--  start product-table ..................................................................................... -->
                                <form id="mainform" name="form1" action="delete" method="post">
				<table border="0" cellpadding="10px" cellspacing="10px" id="product-table">
				<tr>
                                    <th id="tha" align="center" class="table-header-check" ><input id='demo_box' class='css-checkbox' name='checkall' type='checkbox' onclick="check_all(document.form1.check,this);"/><label for='demo_box' name='demo_lbl' class='css-label'></label></th>
					<th class="table-header-repeat line-left minwidth-1 sender-width"><a class="info-tooltip" title="<%=srt.equals("sender")?"Descending":"Ascending"%>" href="inbox?ind=<%=ind%>&r=<%=r%>&sort=sender&<%=srt.equals("sender")?"order=desc":"order=asc"%>">Sender</a>	</th>
					<th class="table-header-repeat line-left minwidth-1 subject-width"><a class="info-tooltip" title="<%=srt.equals("subject")?"Descending":"Ascending"%>" href="inbox?ind=<%=ind%>&r=<%=r%>&sort=subject&<%=srt.equals("subject")?"order=desc":"order=asc"%>">Subject</a></th>
                                        <th class="table-header-repeat line-left minwidth-1 time-width"><a class="info-tooltip" title="<%=srt.equals("dttime")?"Descending":"Ascending"%>" href="inbox?ind=<%=ind%>&r=<%=r%>&sort=dttime&<%=srt.equals("dttime")?"order=desc":"order=asc"%>">Time</a></th>
                                        <th class="table-header-repeat line-left"></th>
				</tr>
                                <%
                                    
                                        res.previous();
                                        for(int i=0;res.next();i++)
                                        {
                                            int mid=res.getInt(1);
                                            if(i%2==0)
                                                out.print("<tr id=tr"+mid+">");
                                            else
                                                out.print("<tr id=tr"+mid+" class='alternate-row'>");
                                            out.print("<td><input id='demo_box_"+mid+"' class='css-checkbox' name='check' type='checkbox' value='"+mid+"'/>");
                                            out.print("<label for='demo_box_"+mid+"' name='demo_lbl_"+mid+"' class='css-label'></label></td>");
                                            out.print("<td id=sender"+mid+">"+res.getString("user")+"</td>");
                                            out.print("<td id=subject"+mid+"><a href=view?mid="+mid+">"+res.getString("subject")+"</a></td>");
                                            out.print("<td id=time"+mid+">"+(res.getTimestamp("dttime")).toString()+"</td>");
                                            %>
                                            <td><a href="javascript:onSubmit(<%=mid%>,'delete')" title='Delete' class='icon-2 info-tooltip'></a></td>
                                            </tr>
                                            <%
                                            
                                        }    
                                %>
                                                </div>
                                            <tr><td colspan="5" style="border: none;height: 20px; "></td></tr>
                                            <tr>
                                                <td colspan="5" style="border: none;">
                                                    <div id="actions-box">
                                                            <a href="javascript:check(document.form1.check)" class="action-slider"></a>
                                                            <div id="actions-box-slider">                                   
                                                                <input type="image" name="delete" value="Delete"class="action-delete">
                                                            </div>
                                                            <div class="clear"></div>                            
                                                    </div>
                                                </td>
                                            </tr>
                                                  
				</table>
                                            <%
                                }
                                else
                                    {
                                        out.println("<center><h1>Inbox is empty!!</h1><center>");
                                    }
                                    %>
				<!--  end product-table................................... --> 				
			</div>
			<!--  end content-table  -->
                        <!--  start actions-box ............................................... -->
                        </form>
			<!-- end actions-box........... -->
			</div>
<%@include file="footer.jsp" %>