<?php
 
    
    $url = "http://localhost:8080/barServices/webresources/web.bar/";
    $json = file_get_contents($url);
    $bars = json_decode($json, true);
?>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Bar + Kneipen Guide</title>
<meta name="description" content="Kneipenplan der Hochschule Hannover">
<meta name="author" content=" Firas Shmit, Valerie Vaske, Nadine Fakih, Alina Knaak, Claudia Gierszendorf">

<!-- Bootstrap  Stylesheets-->
<link rel="stylesheet" type="text/css"  href="css/bootstrap.css">

<!-- Stylesheets und die Schriftarten
    ================================================== -->
<link rel="stylesheet" type="text/css"  href="css/style.css">
<link href="https://fonts.googleapis.com/css?family=Raleway:300,400,500,600,700" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Dancing+Script:400,700" rel="stylesheet">


</head>
<body id="page-top" data-spy="scroll" data-target=".navbar-fixed-top">


<!-- Navigation
    ==========================================-->
<nav id="menu" class="navbar navbar-default navbar-fixed-top">
  <div class="container"> 
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
      <a class="navbar-brand page-scroll" href="#page-top">Kneipen Guide</a> </div>
    
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav navbar-right">
                <li><a href="#" class="page-scroll">Home</a></li>
           <li><a href="#about" class="page-scroll">Details</a></li>
          <li><a href="#restaurant-menu" class="page-scroll">Bars</a></li>



      </ul>
    </div>
    <!-- /.navbar-collapse --> 
  </div>
</nav>
<!-- Header -->
<header id="header">
  <div class="intro">
    <div class="overlay">
      <div class="container">
        <div class="row">
          <div class="intro-text">
            <h1>Bar + Kneipen Guide</h1>
            <p>in Hannover</p>
            <a href="#about" class="btn btn-custom btn-lg page-scroll">Details</a> </div>
        </div>
      </div>
    </div>
  </div>
</header>  
