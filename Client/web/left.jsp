<div class="clear"></div>
<!--  start nav-outer -->
</div>
<!--  start nav-outer-repeat................................................... END -->
 
 <div class="clear"></div>
 
<!-- start content-outer -->
<div id="content-outer">
<!-- start content -->
<div id="content">
<%
String uri = request.getRequestURI();

String pageName = uri.substring(uri.lastIndexOf("/")+1);
String pgn=pageName.substring(0, pageName.length()-4);
pgn=pgn.toUpperCase();
if(pgn.equalsIgnoreCase("draftinfo"))
    pgn="DRAFTS";
%>

    <div id="page-heading"><h1 align='center'><%=pgn%></h1></div>
<!--  start content-table-inner -->
	<div id="content-table-inner">
	


	<!--  start related-activities -->
	<div id="related-activities">
	
		<!--  start related-act-top -->
		<div id="related-act-top">
                    <table><tr><th align="left" class="table-header-repeat line-left minwidth-1" width="260" height="43"/><a href="compose.jsp">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;COMPOSE</a></th></tr></table>
		</div>
		<!-- end related-act-top -->
		
		<!--  start related-act-bottom -->
		<div id="related-act-bottom">
		
			<!--  start related-act-inner -->
			<div id="related-act-inner">
			
				<ul class="greyarrow">
                                        <li><a href=""></a></li> 
                                        <div class="clear"></div>
                                        <div class="lines-dotted-short"></div>
                                        <li><a href="inbox">Inbox</a></li> 
                                        <div class="clear"></div>
                                        <div class="lines-dotted-short"></div>
                                        <li><a href="">Starred</a></li> 
                                        <div class="clear"></div>
                                        <div class="lines-dotted-short"></div>
                                        <li><a href="draftinfo">Draft</a></li> 
                                        <div class="clear"></div>
                                        <div class="lines-dotted-short"></div>
                                        <li><a href="sent">Sent</a></li> 
                                        <div class="clear"></div>
                                        <div class="lines-dotted-short"></div>
                                        <li><a href="trash">Trash</a></li> 
                                        <div class="clear"></div>
                                        <div class="lines-dotted-short"></div>
                                </ul>
		
		</div>
		<!-- end related-act-bottom -->
	
	</div>
	<!-- end related-activities -->	
        <img src="images/shared/blank.gif" width="695" height="1" alt="blank" />

 
<div class="clear"></div>
 

</div>