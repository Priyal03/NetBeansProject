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

<%
    String r = "", s = "", msg = "";
    int did=-1;
    if(request.getAttribute("draft_info")!=null)
    {
        ResultSet res = (ResultSet) request.getAttribute("draft_info");
        did=res.getInt(1);
        if (res.getString(3) != null) {
            r = res.getString(3);
        }
        if (res.getString(4) != null) {
            s = res.getString(4);
        }
        if (res.getString(5) != null) {
            msg = res.getString(5);
        }
    }
%>
<%@include file="left.jsp" %>
<!-- start id-form -->
<form action='send?did=<%=did%>' method='post' onsubmit='return valid(this)'>
    <table style="float: right;"border="0" cellpadding="0" cellspacing="0"  id="id-form">
        <tr>

            <th valign="top" >To:</th>
            <td><input name='reciever' type="text" class="inp-compose" value="<%=r%>"/></td>
            <td></td>
        </tr>
        <tr>

            <th valign="top">Subject:</th>
            <td><input name='subject' type="text" class="inp-compose" value="<%=s%>"/></td>
            <td></td>
        </tr>
        <tr>

            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>

            <th>File:</th>
            <td><input type="file" class="file_1" /></td>
            <td>
            </td>
        </tr>
        <tr>

            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>

            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>

            <td></td>
            <td>
                <textarea id="elm1" name="area"><%=msg%></textarea>
            </td>
            <td></td>
        </tr>
        <tr>
        </tr>
        <tr><td></td><td></td></tr>
        <tr>

            <th>&nbsp;</th>
            <td valign="top">
                <input type="submit" name="send" value="send" class="form-send" />
                <input type="submit" name="draft" value="draft" class="form-draft"  />
            </td>
            <td></td>
        </tr>
    </table>
</form>                                        
<!-- end id-form  -->
<div class="clear">&nbsp;</div>

</div>
<!--  end content -->
<div class="clear">&nbsp;</div>
</div>
<!--  end content-outer -->


<div class="clear">&nbsp;</div>

<!--  end content-table-inner  -->
<div class="clear">&nbsp;</div>

</div>
<!--  end content -->
<div class="clear">&nbsp;</div>
</div>
<!--  end content-outer -->

<div style="height: 200px;width: 100%"></div>

<div class="clear">&nbsp;</div>

</body>
</html>