<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import = "javax.servlet.RequestDispatcher" %>
<%@ page import = "javax.servlet.http.HttpSession" %>
<%@page session="false" %><!DOCTYPE HTML>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>GeekyGadgets</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <!-- Styles -->


        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
        <link rel='stylesheet' id='prettyphoto-css'  href="css/prettyPhoto.css" type='text/css' media='all'>
        <link href="css/fontello.css" type="text/css" rel="stylesheet">
        <!--[if lt IE 7]>
                <link href="css/fontello-ie7.css" type="text/css" rel="stylesheet">  
            <![endif]-->
        <!-- Google Web fonts -->
        <link href='http://fonts.googleapis.com/css?family=Quattrocento:400,700' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Patua+One' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>

        <!-- slider jquery inclusions -->
        <link href="themes/1/js-image-slider.css" rel="stylesheet" type="text/css" />
        <script src="themes/1/js-image-slider.js" type="text/javascript"></script>
        <link href="generic.css" rel="stylesheet" type="text/css" />
        <link rel="stylesheet" type="text/css" href="css_signup/demo.css" />
        <link rel="stylesheet" type="text/css" href="css_signup/style3.css" />
        <link rel="stylesheet" type="text/css" href="css_signup/animate-custom.css" />
        <style>
            body {
                padding-top: 60px; /* 60px to make the container go all the way to the bottom of the topbar */
            }
        </style>
        <link href="css/bootstrap-responsive.css" rel="stylesheet">
        <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
              <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
            <![endif]-->
        <!-- Favicon -->
        <link rel="shortcut icon" href="img/favicon.ico">
        <!-- JQuery -->
        <script type="text/javascript" src="js/jquery.js"></script>
        <!-- Load ScrollTo -->
        <script type="text/javascript" src="js/jquery.scrollTo-1.4.2-min.js"></script>
        <!-- Load LocalScroll -->
        <script type="text/javascript" src="js/jquery.localscroll-1.2.7-min.js"></script>
        <!-- prettyPhoto Initialization -->
        <script type="text/javascript" charset="utf-8">


        </script>
    </head>
    <body>
        <!--background-color:#032b35;color: white;-->


 

        <!--******************** NAVBAR ********************-->
        <div class="navbar-wrapper" >
            <div class="navbar navbar-inverse navbar-fixed-top" >
                <div class="navbar-inner" style="background-color:#032b35">
                    <div class="container" >

                        <!-- Responsive Navbar Part 1: Button for triggering responsive navbar (not covered in tutorial). Include responsive CSS to utilize. -->
                        <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse"> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </a>
                        <img id="logo" src="img/logo.png" style="width:2.7in;height:0.75in;"/>

                        <input type="text" name="srch" placeholder="Keywords:Mobiles,Laptops.." style="width:300px;height:20px;position: absolute;top: 30%;background-image: url('img/Search.png');background-size: contain;padding-left: 32px;background-repeat: no-repeat;" onfocus="chngtxt(this);" onblur="defaulttxt(this);" />
                        <input type="image" src="img/go.png" name="search"  style="position: absolute;left:51%;top:30%;" >
                        <!-- Responsive Navbar Part 2: Place all navbar contents you want collapsed withing .navbar-collapse.collapse. -->
                        <nav class="pull-right nav-collapse collapse">
                            <ul id="menu-main" class="nav" >
                                <li ><a title="portfolio" href="#portfolio">Post Ad!</a></li>
                                <li><a title="services" href="#services">Categories</a></li>
                                <li><a title="contact" href="#contact">Contact</a></li>
                                <li><a id="loginslide"  title="logout" style="cursor:pointer" href="#">Logout</a></li>

                                <%
                                    HttpSession session1 = request.getSession(false);
                                    if (session1 == null ) {
                                        response.sendRedirect("index.jsp");


                                    } else {%>
                                <li style="color:white;padding-top:2%;"> Welcome, <%= session1.getAttribute("username")%> </li>
                                    <%}%>


                                </li>
                            </ul>
                        </nav>

                    </div>

                    <!-- /.container -->
                </div>
                <!-- /.navbar-inner -->
            </div>
            <!-- /.navbar -->
        </div>  

        <!-- /.navbar-wrapper -->
        <div id="top"></div>
        <!-- ******************** HeaderWrap ********************-->
        <div style="height: 640px">

            <div id="headerwrap" style="background-color:#f29315;box-shadow: 1px 2px 5px black">
                <header class="clearfix" style="top:-80px;">
                    <!-- <h1><span>Legend!</span> We make web a beautiful place.</h1>
                     <div class="container">
                       <div class="row">
                         <div class="span12">
                           <h2>Signup for our Newsletter to be updated</h2>
                           <input type="text" name="your-email" placeholder="you@yourmail.com" class="cform-text" size="40" title="your email">
                           <input type="submit" value="Notify me" class="cform-submit">
                         </div>
                       </div>-->

                    <div id="sliderFrame" style="top:0px;left:0px;">
                        <div id="slider" style="top:0px;">
                            <img src="img/1.jpg" />
                            <img src="img/2.jpg" />
                            <img src="img/3.jpg"  />
                            <img src="img/4.jpg"  />
                            <img src="img/5.jpg" />
                        </div>
                    </div>
                    <!--<div class="row">
                        <div class="span12" style="left:7%">
                            <ul class="icon" >
                                <li><a href="#" target="_blank"><i class="icon-pinterest-circled"></i></a></li>
                                <li><a href="#" target="_blank"><i class="icon-facebook-circled"></i></a></li>
                                <li><a href="#" target="_blank"><i class="icon-twitter-circled"></i></a></li>
                                <li><a href="#" target="_blank"><i class="icon-gplus-circled"></i></a></li>
                                <li><a href="#" target="_blank"><i class="icon-skype-circled"></i></a></li>
                            </ul>
                        </div>
                    </div>-->
                </header>

            </div>
        </div>
        <!--******************** Feature ********************-->
        <!-- <div class="scrollblock">
             <section id="feature">
                 <div class="container">
                     <div class="row">
                         <div class="span12">
                             <article>
                                 <p>We work to make web a beautiful place.</p>
                                 <p>We craft beautiful designs and convert them into</p>
                                 <p>fully functional and user-friendy web app.</p>
                             </article>
                         </div>
                        
                     </div>
                      
                 </div>
                 
             </section>
         </div>-->
        <hr>
        <!--******************** Portfolio Section ********************-->
        <section id="portfolio" class="single-page scrollblock">
            <div class="container">
                <div class="align"><i class="icon-desktop-circled"></i></div>
                <h1 id="folio-headline">Portfolio...</h1>
                <!--<script type="text/javascript" charset="utf-8">
                function call_ajax_signup() {
                event.preventDefault();
                var username = document.getElementById("model_no").value;
                var email = document.getElementById("sell_price").value;
                var password = document.getElementById("passwordsignup").value;
                var xmlhttp;
                if (window.XMLHttpRequest) {
                    xmlhttp = new XMLHttpRequest();
                }
                else {
                    // code for IE6, IE5
                    xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");

                }
                xmlhttp.open("POST", "register", true);
                xmlhttp.onreadystatechange = function()
                {
                    if (xmlhttp.readyState == 4 && xmlhttp.status == 200)
                    {
                        var res = xmlhttp.responseText;

                        if (res == "Success") {
                            //alert(res);
                            document.getElementById("success").innerHTML = "Registered successfully<br>Go and Log in!";
                            document.getElementById("success").style.display = "block";
                        }
                        else if (res == "Error") {

                            document.getElementById("success").innerHTML = "Please Try Again!";
                            document.getElementById("success").style.display = "block";
                        }
                    }
                };
                xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                xmlhttp.send("username=" + username + "&email=" + email + "&password=" + password + "&uname=" + uname + "&dob=" + dob + "&gender=" + gender + "&contact=" + contact + "&state=" + state + "&city=" + city + "&zipcode=" + zipcode);
            }
        </script>   <!-->    
                <form form  autocomplete="on" name="form1" method="post" enctype="multipart/form-data" action="add_upload">
                    <div style="left:40%">
                <label for="model_no" >Model Number</label>
                                <input id="model_no" name="model_no" required="required" type="text" />
                <label for="price" >Selling Price</label>
                                <input id="sell_price" name="sell_price" required="required" type="text" />
                                
                                <br>  Category<br>
                               <select name="category">
                                    </select>
                                <label for="price" >Description 1</label>
                                <input id="desc_1" name="desc_1" required="required" type="text" />
                                 <label for="price" >Description 2</label>
                                <input id="desc_2" name="desc_2" required="required" type="text" />
                                <label for="price" >Description 3</label>
                                <input id="desc_3" name="desc_3" required="required" type="text" />
                                <label for="price" >Description 4</label>
                                <input id="desc_4" name="desc_4" required="required" type="text" />
                                <label for="price" >Description 5</label>
                                <input id="desc_5" name="desc_5" required="required" type="text" />
                                
                                <label for="passwordsignup_confirm" class="youpasswd" data-icon="p">Upload Pic : </label>
                                <input type="file" name="U_PIC" value="" style="float: left"/>
                                
                                <br>  <br>  <input type="submit" value="Upload"/> 
                                
                                </div>   
                </form>
                
                
            </div>
            <!-- /.container -->
        </section>
        <hr>
        <!--******************** Services Section ********************-->
        <section id="services" class="single-page scrollblock">
            <div class="container">
                <div class="align"><i class="icon-cog-circled"></i></div>
                <h1>Services</h1>
                <!-- Four columns -->
                <div class="row">
                    <div class="span3">
                        <div class="align"> <i class="icon-desktop sev_icon"></i> </div>
                        <h2>Personal Computers</h2>
                        <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.</p>
                    </div>
                    <!-- /.span3 -->
                    <div class="span3">
                        <div class="align"> <i class="icon-vector sev_icon"></i> </div>
                        <h2>Others</h2>
                        <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.</p>
                    </div>
                    <!-- /.span3 -->
                    <div class="span3">
                        <div class="align"> <i class="icon-basket sev_icon"></i> </div>
                        <h2>Laptops</h2>
                        <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.</p>
                    </div>
                    <!-- /.span3 -->
                    <div class="span3">
                        <div class="align"> <i class="icon-mobile-1 sev_icon"></i> </div>
                        <h2>Mobiles</h2>
                        <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.</p>
                    </div>
                    <!-- /.span3 -->
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container -->
        </section>
        <hr>
        <!--******************** Testimonials Section ********************-->
        <section id="testimonials" class="single-page hidden-phone">
            <div class="container">
                <div class="row">
                    <div class="blockquote-wrapper">
                        <blockquote class="mega">
                            <div class="span4">
                                <p class="cite">John Doe &amp; Sons:</p>
                            </div>
                            <div class="span8">
                                <p class="alignright">"We highly appreciate the enthusiasm and creative talent of the people at Legend!"</p>
                            </div>
                        </blockquote>
                    </div>
                    <!-- /.blockquote-wrapper -->
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container -->
        </section>
        <hr>
        <!--******************** News Section ********************-->
        <section id="news" class="single-page scrollblock">
            <div class="container">
                <div class="align"><i class="icon-pencil-circled"></i></div>
                <h1>Our Blog</h1>
                <!-- Three columns -->
                <div class="row">
                    <article class="span4 post"> <img class="img-news" src="img/blog_img-01.jpg" alt="">
                        <div class="inside">
                            <p class="post-date"><i class="icon-calendar"></i> March 17, 2013</p>
                            <h2>A girl running on a road</h2>
                            <div class="entry-content">
                                <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s. &hellip;</p>
                                <a href="#" class="more-link">read more</a> </div>
                        </div>
                        <!-- /.inside -->
                    </article>
                    <!-- /.span4 -->
                    <article class="span4 post"> <img class="img-news" src="img/blog_img-02.jpg" alt="">
                        <div class="inside">
                            <p class="post-date">February 28, 2013</p>
                            <h2>A bear sleeping on a tree</h2>
                            <div class="entry-content">
                                <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s. &hellip;</p>
                                <a href="#" class="more-link">read more</a> </div>
                        </div>
                        <!-- /.inside -->
                    </article>
                    <!-- /.span4 -->
                    <article class="span4 post"> <img class="img-news" src="img/blog_img-03.jpg" alt="">
                        <div class="inside">
                            <p class="post-date">February 06, 2013</p>
                            <h2>A Panda playing with his baby</h2>
                            <div class="entry-content">
                                <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s. &hellip;</p>
                                <a href="#" class="more-link">read more</a> </div>
                        </div>
                        <!-- /.inside -->
                    </article>
                    <!-- /.span4 -->
                </div>
                <!-- /.row -->
                <a href="#" class="btn btn-large">Go to our blog</a> </div>
            <!-- /.container -->
        </section>
        <hr>
        <!--******************** Team Section ********************-->
        <section id="team" class="single-page scrollblock">
            <div class="container">
                <div class="align"><i class="icon-group-circled"></i></div>
                <h1>Meet the team</h1>
                <!-- Five columns -->
                <div class="row">
                    <div class="span2 offset1">
                        <div class="teamalign"> <img class="team-thumb img-circle" src="img/portrait-1.jpg" alt=""> </div>
                        <h3>Andrew</h3>
                        <div class="job-position">web designer</div>
                    </div>
                    <!-- ./span2 -->
                    <div class="span2">
                        <div class="teamalign"> <img class="team-thumb img-circle" src="img/portrait-2.jpg" alt=""> </div>
                        <h3>Stephen</h3>
                        <div class="job-position">web developer</div>
                    </div>
                    <!-- ./span2 -->
                    <div class="span2">
                        <div class="teamalign"> <img class="team-thumb img-circle" src="img/portrait-3.jpg" alt=""> </div>
                        <h3>Maria</h3>
                        <div class="job-position">graphic designer</div>
                    </div>
                    <!-- ./span2 -->
                    <div class="span2">
                        <div class="teamalign"> <img class="team-thumb img-circle" src="img/portrait-4.jpg" alt=""> </div>
                        <h3>John</h3>
                        <div class="job-position">project manager</div>
                    </div>
                    <!-- ./span2 -->
                    <div class="span2">
                        <div class="teamalign"> <img class="team-thumb img-circle" src="img/portrait-2.jpg" alt=""> </div>
                        <h3>Ashton</h3>
                        <div class="job-position">real owner</div>
                    </div>
                    <!-- ./span2 -->
                </div>
                <!-- /.row -->
                <div class="row">
                    <div class="span10 offset1">
                        <hr class="featurette-divider">
                        <div class="featurette">
                            <h2 class="featurette-heading">Want to know more? <span class="muted">| a little about us</span></h2>
                            <p>Li Europan lingues es membres del sam familie. Lor separat existentie es un myth. Por scientie, musica, sport etc, litot Europa usa li sam vocabular. Li lingues differe solmen in li grammatica, li pronunciation e li plu commun vocabules. Omnicos directe al desirabilite de un nov lingua franca: On refusa continuar payar custosi traductores.</p>
                            <p>At solmen va esser necessi far uniform grammatica, pronunciation e plu sommun paroles. Ma quande lingues coalesce, li grammatica del resultant lingue es plu simplic e regulari quam ti del coalescent lingues.</p>
                            <p>A un Angleso it va semblar un simplificat Angles, quam un skeptic Cambridge amico dit me que Occidental es.</p>
                        </div>
                        <!-- /.featurette -->
                        <hr class="featurette-divider">
                    </div>
                    <!-- .span10 -->
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container -->
        </section>
        <!--******************** Contact Section ********************-->
        <section id="contact" class="single-page scrollblock">
            <div class="container">
                <div class="align"><i class="icon-mail-2"></i></div>
                <h1>Contact us now!</h1>
                <div class="row">
                    <div class="span12">
                        <div class="cform" id="theme-form">
                            <form action="#" method="post" class="cform-form">
                                <div class="row">
                                    <div class="span6"> <span class="your-name">
                                            <input type="text" name="your-name" placeholder="Your Name" class="cform-text" size="40" title="your name">
                                        </span> </div>
                                    <div class="span6"> <span class="your-email">
                                            <input type="text" name="your-email" placeholder="Your Email" class="cform-text" size="40" title="your email">
                                        </span> </div>
                                </div>
                                <div class="row">
                                    <div class="span6"> <span class="company">
                                            <input type="text" name="company" placeholder="Your Company" class="cform-text" size="40" title="company">
                                        </span> </div>
                                    <div class="span6"> <span class="website">
                                            <input type="text" name="website" placeholder="Your Website" class="cform-text" size="40" title="website">
                                        </span> </div>
                                </div>
                                <div class="row">
                                    <div class="span12"> <span class="message">
                                            <textarea name="message" class="cform-textarea" cols="40" rows="10" title="drop us a line."></textarea>
                                        </span> </div>
                                </div>
                                <div>
                                    <input type="submit" value="Send message" class="cform-submit pull-left">
                                </div>
                                <div class="cform-response-output"></div>
                            </form>
                        </div>
                    </div>
                    <!-- ./span12 -->
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container -->
        </section>
        <hr>
        <div class="footer-wrapper">
            <div class="container">
                <footer>
                    <small>&copy; 2013 Inbetwin Network. All rights reserved.</small>
                </footer>
            </div>
            <!-- ./container -->
        </div>
        <!-- Loading the javaScript at the end of the page -->
        <script type="text/javascript" src="js/bootstrap.js"></script>
        <script type="text/javascript" src="js/jquery.prettyPhoto.js"></script>
        <script type="text/javascript" src="js/site.js"></script>

        <!--ANALYTICS CODE-->
        <script type="text/javascript">
            var _gaq = _gaq || [];
            _gaq.push(['_setAccount', 'UA-29231762-1']);
            _gaq.push(['_setDomainName', 'dzyngiri.com']);
            _gaq.push(['_trackPageview']);

            (function() {
                var ga = document.createElement('script');
                ga.type = 'text/javascript';
                ga.async = true;
                ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
                var s = document.getElementsByTagName('script')[0];
                s.parentNode.insertBefore(ga, s);
            })();
        </script>
    </body>
</html>

