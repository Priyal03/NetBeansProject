<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.Calendar"%>
<%@include file="header.jsp" %>
<%@include file="left.jsp" %>
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
                int mid;
                if(request.getParameter("mid")!=null)
                    mid=Integer.parseInt(request.getParameter("mid"));
                else
                    mid=Integer.parseInt(request.getParameter("did"));
            %>


            <!--  start product-table ..................................................................................... --><!--  start product-table ..................................................................................... -->
            <form id="mainform" name="form1" action="delete?mid=<%=mid%>">
            <table border="0" cellpadding="10px" cellspacing="10px" id="product-table">
           
            <%
                res.first();
                if(res.next())
                {
                   
                    String u=us.get(usid.indexOf(res.getInt("reciever")));
                int id=res.getInt("sender");
                String from=us.get(usid.indexOf(id));
                    %>
                    
            <tr class="alternate-row">
                <td class="view-width"><b>From :</b> <%=from%>@dmail.com</td>
            </tr>
            <tr>
                    <td class="view-width"><b>To :</b> <%=u%>@dmail.com</td>
            </tr>
            <tr class="alternate-row">
                    <td class="view-width"><b>Subject :</b> <%=res.getString("subject")%></td>
            </tr>
            <tr >
                    <td class="msg"><%=id==1?res.getString("msg").replace("User",u):res.getString("msg")%></td>
            </tr>
            <tr>
                <td>
                    <div id="actions-box">
                            <a href="javascript:check(document.form1.check)" class="action-slider"></a>
                            <div id="actions-box-slider">                                   
                                <input type="image" name="delete" value="Delete"class="action-delete">
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
</div>
<%@include file="footer.jsp" %>