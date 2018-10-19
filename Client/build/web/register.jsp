<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.Calendar"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<!--URL Name -->
<%
String uri = request.getRequestURI();

String pageName = uri.substring(uri.lastIndexOf("/")+1);
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Email System</title>
<link rel="stylesheet" href="css/screen.css" type="text/css" media="screen" title="default" />
<!--[if IE]>
<link rel="stylesheet" media="all" type="text/css" href="css/pro_dropline_ie.css" />
<![endif]-->

<!--  jquery core -->
<script src="js/jquery/jquery-1.4.1.min.js" type="text/javascript"></script>

<!--  checkbox styling script -->

<![if !IE 7]>

<!--  styled select box script version 1 -->
<script src="js/jquery/jquery.selectbox-0.5.js" type="text/javascript"></script>
<script type="text/javascript">
$(document).ready(function() {
	$('.styledselect').selectbox({ inputClass: "selectbox_styled" });
});
</script>
 

<![endif]>

<!--  styled select box script version 2 --> 
<script src="js/jquery/jquery.selectbox-0.5_style_2.js" type="text/javascript"></script>
<script type="text/javascript">
$(document).ready(function() {
	$('.styledselect_form_1').selectbox({ inputClass: "styledselect_form_1" });
	$('.styledselect_form_2').selectbox({ inputClass: "styledselect_form_2" });
});
</script>

<!--  styled select box script version 3 --> 
<script src="js/jquery/jquery.selectbox-0.5_style_2.js" type="text/javascript"></script>
<script type="text/javascript">
$(document).ready(function() {
	$('.styledselect_pages').selectbox({ inputClass: "styledselect_pages" });
});
</script>

<!--  styled file upload script --> 
<script src="js/jquery/jquery.filestyle.js" type="text/javascript"></script>
<script type="text/javascript" charset="utf-8">
  $(function() {
      $("input.file_1").filestyle({ 
          image: "images/forms/choose-file.gif",
          imageheight : 21,
          imagewidth : 78,
          width : 310
      });
  });
</script>

<!-- Custom jquery scripts -->
<script src="js/jquery/custom_jquery.js" type="text/javascript"></script>
 
<!-- Tooltips -->
<script src="js/jquery/jquery.tooltip.js" type="text/javascript"></script>
<script src="js/jquery/jquery.dimensions.js" type="text/javascript"></script>
<script type="text/javascript">
$(function() {
	$('a.info-tooltip ').tooltip({
		track: true,
		delay: 0,
		fixPNG: true, 
		showURL: false,
		showBody: " - ",
		top: -35,
		left: 5
	});
});
</script> 


<!--  date picker script -->
<link rel="stylesheet" href="css/datePicker.css" type="text/css" />
<script src="js/jquery/date.js" type="text/javascript"></script>
<script src="js/jquery/jquery.datePicker.js" type="text/javascript"></script>
<script type="text/javascript" charset="utf-8">
        $(function()
{

// initialise the "Select date" link
$('#date-pick')
	.datePicker(
		// associate the link with a date picker
		{
			createButton:false,
			startDate:'01/01/2005',
			endDate:'31/12/2020'
		}
	).bind(
		// when the link is clicked display the date picker
		'click',
		function()
		{
			updateSelects($(this).dpGetSelected()[0]);
			$(this).dpDisplay();
			return false;
		}
	).bind(
		// when a date is selected update the SELECTs
		'dateSelected',
		function(e, selectedDate, $td, state)
		{
			updateSelects(selectedDate);
		}
	).bind(
		'dpClosed',
		function(e, selected)
		{
			updateSelects(selected[0]);
		}
	);
	
var updateSelects = function (selectedDate)
{
	var selectedDate = new Date(selectedDate);
	$('#d option[value=' + selectedDate.getDate() + ']').attr('selected', 'selected');
	$('#m option[value=' + (selectedDate.getMonth()+1) + ']').attr('selected', 'selected');
	$('#y option[value=' + (selectedDate.getFullYear()) + ']').attr('selected', 'selected');
}
// listen for when the selects are changed and update the picker
$('#d, #m, #y')
	.bind(
		'change',
		function()
		{
			var d = new Date(
						$('#y').val(),
						$('#m').val()-1,
						$('#d').val()
					);
			$('#date-pick').dpSetSelected(d.asString());
		}
	);

// default the position of the selects to today
var today = new Date();
updateSelects(today.getTime());

// and update the datePicker to reflect it...
$('#d').trigger('change');
});
</script>

<!-- MUST BE THE LAST SCRIPT IN <HEAD></HEAD></HEAD> png fix -->
<script src="js/jquery/jquery.pngFix.pack.js" type="text/javascript"></script>
<script type="text/javascript">
$(document).ready(function(){
$(document).pngFix( );
});
</script>
<script type="text/javascript" src="js/validate.js"></script>
<script type="text/javascript" src="js/country.js"></script>
</head>
    <body > 
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


<div id="page-heading"><h1 align='center'>Register</h1></div>


<table  border="0" width="100%" cellpadding="0" cellspacing="0" id="content-table">
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
	<table border="0" width="100%" cellpadding="0" cellspacing="0" >
	<tr valign="top">
	<td>
	
		<!-- start id-form -->
                <form action='add' method='post' onsubmit='return valid(this)'>
                    <table border="0" cellpadding="0" cellspacing="0"  id="id-form">
                    <tr>
                            <th valign="top">Name:</th>
                            <td><input name='name' type="text" class="inp-form" /></td>
                            <td></td>
                    </tr>
                    <tr>
                            <th valign="top">Username:</th>
                            <td><input name='user' id="user" type="text" class="inp-form" onblur='return usernameCheck(this);'/></td>
                            <td>
                                <div id='u1'></div>
                                <div id='u2'></div>
                            </td>
                    </tr>
                    <tr>
                            <th valign="top">Password:</th>
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
                            <th valign="top">Confirm password:</th>
                            <td><input id="cpass" name='cpass'type="password" class="inp-form" onKeyUp="return match(this);"/></td>
                            <td>
                                <div id='p1'></div>
                                <div id='p2'></div>
                            </td>
                    </tr>
                    <tr>
                    <th rowspan='2'valign="top">Gender:</th>
                    <td>	
                        <input type='radio' name='gen' value='M'>&nbspMale
                    </td>
                    </tr>
                    <tr>
                        <td><input type='radio' name='gen' value='F'>&nbspFemale</td>
                    </tr>
                    <tr>
                    <th valign="top">Country</th>
                    <td>	
                        <select id='cnt'name='ct' class='styledselect_form' onchange="getState(this);">
                            <%
                                ResultSet res=(ResultSet)request.getAttribute("count");
                                out.print("<option value=' ' selected='selected'>Select</option>");
                                if(res!=null)
                                {
                                    while(res.next())
                                    {
                                        out.print("<option value='"+res.getInt(1));
                                        out.print("'>"+res.getString(2)+"</option>");
                                    }
                                }
                            %>
                    </select>
                    </td>
                    </tr>
                    <tr>
                    <th valign="top">State</th>
                    <td>	
                        <div id='state'>
                            <select  name='st'  class='styledselect_form' onchange="getCity(this);">
                                <option value='' selected='selected'> </option>
                            </select>
                        </div>
                    </td>
                    </tr>
                    <tr>
                    <th valign="top">City</th>
                    <td>	
                        <div id='city'>
                            <select  name='cty'  class='styledselect_form'>
                                <option value='' selected='selected'> </option>
                            </select>
                        </div>
                    </td>
                    </tr>
                    <tr>
                            <th valign="top">Mobile:</th>
                            <td>
                                <select  id="ccid" name='ccid' class="styledselect-day">
                                    <%
                                        res=(ResultSet)request.getAttribute("c_code");
                                        out.print("<option value='' selected='selected'> </option>");
                                        if(res!=null)
                                        {
                                            while(res.next())
                                            {
                                                out.print("<option value='"+res.getInt(2));
                                                out.print("'>+"+res.getInt(3)+"</option>");
                                            }
                                        }
                                    %>
                                </select>
                                <input name='phone' type="text" class="inp-form" />
                            </td>
                            <td></td>
                    </tr>
                    <tr>
                    <th valign="top">Date of birth:</th>
                    <td class="noheight">

                            <table border="0" cellpadding="0" cellspacing="0">
                            <tr  valign="top">
                                    <td>
                                    <select id="d" name='d' class="styledselect-day">
                                            <option value=""> </option>
                                            <option value="1">1</option>
                                            <option value="2">2</option>
                                            <option value="3">3</option>
                                            <option value="4">4</option>
                                            <option value="5">5</option>
                                            <option value="6">6</option>
                                            <option value="7">7</option>
                                            <option value="8">8</option>
                                            <option value="9">9</option>
                                            <option value="10">10</option>
                                            <option value="11">11</option>
                                            <option value="12">12</option>
                                            <option value="13">13</option>
                                            <option value="14">14</option>
                                            <option value="15">15</option>
                                            <option value="16">16</option>
                                            <option value="17">17</option>
                                            <option value="18">18</option>
                                            <option value="19">19</option>
                                            <option value="20">20</option>
                                            <option value="21">21</option>
                                            <option value="22">22</option>
                                            <option value="23">23</option>
                                            <option value="24">24</option>
                                            <option value="25">25</option>
                                            <option value="26">26</option>
                                            <option value="27">27</option>
                                            <option value="28">28</option>
                                            <option value="29">29</option>
                                            <option value="30">30</option>
                                            <option value="31">31</option>
                                    </select>
                                    </td>
                                    <td>
                                            <select id="m" name='m' class="styledselect-month">
                                                    <option value=""> </option>
                                                    <option value="1">Jan</option>
                                                    <option value="2">Feb</option>
                                                    <option value="3">Mar</option>
                                                    <option value="4">Apr</option>
                                                    <option value="5">May</option>
                                                    <option value="6">Jun</option>
                                                    <option value="7">Jul</option>
                                                    <option value="8">Aug</option>
                                                    <option value="9">Sep</option>
                                                    <option value="10">Oct</option>
                                                    <option value="11">Nov</option>
                                                    <option value="12">Dec</option>
                                            </select>
                                    </td>
                                    <td>
                                            <select  id="y" name='y' class="styledselect-year">
                                                    <option value=""> </option>
                                                    <%
                                                        Calendar c1=Calendar.getInstance();
                                                        int y=c1.get(Calendar.YEAR);
                                                        for(int i=1964;i<=y;i++)
                                                        {
                                                    %>
                                                    <option value="<%=i%>"><%=i%></option>
                                                    <%
                                                        }
                                                    %>
                                            </select>
                                            </form>
                                    </td>
                                    <!--<td><a href=""  id="date-pick"><img src="images/forms/icon_calendar.jpg"   alt="" /></a></td>-->
                            </tr>
                            </table>

                    </td>
                    <td></td>
            </tr>
            <tr>
                    <th valign="top">Current email:</th>
                    <td><input name='email'type="text" class="inp-form" /></td>
            </tr>
            <tr><td></td><td></td></tr>
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