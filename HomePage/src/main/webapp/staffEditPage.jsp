<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="ISO-8859-1">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Edit Product | Staff</title>
	<link rel="stylesheet" href="style.css">
	<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
</head>
<body>
	<header class="navHeader">
		<a href="mainHome.html" class="navLogo">CaptEmpire</a>
		
		<nav class="navbar">
			<input type="checkbox" id="navbarCheck">
			<label for = "navbarCheck" class="navbarCheckbtn">
				<i class='bx bx-menu'></i>
			</label>
			
			<ul class="navbarMenu">
				<li><a href="mainHome.html" class="active">Home</a></li>
				<li><a href="aboutUs.html">About</a></li>
				<li><a href="contact.html">Contact</a></li>
				<li><a href="#">FAQs</a></li>
			</ul>
		</nav>
	</header>
	
	<section class="backgroundWebsite">
		<div class="staffSearch-wrapper">
			<div class="staffSearch-form-box">
				<h2>Edit Product</h2>
					<form action = "staffEdit" method="post">
					<div class="staffSearch-input-box">
						<input type="text" name="checkProductID" required>
						<label>Product ID</label>
					</div>
					<button type="submit" class="search-btn">Search</button>
					</form>
			</div>
		</div>
	</section>
</body>
</html>