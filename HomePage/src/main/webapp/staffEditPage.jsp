<!DOCTYPE html>
<html>
<head>
<style>
.myDiv {
  border: 5px outset;
  background-color: black;
  color: white;
}
.myDiv2 {
  border: 3px outset;
  background-size: 50% auto;
  background-color: white;
  color: black;
  width:50%;
}
</style>
<meta charset="ISO-8859-1">
<title>Update Clothes</title>
<link rel="icon" href="logo.png" type="image/x-icon">
</head>
<body style="background-color:lightgray;">
<center>
<div class="myDiv">
<h1>Update Clothes</h1>
</div>
</center>
<br>
<center>
<div class="myDiv2">
Enter the ID of the cloth you want to update:
<br>
<form>
<input type=text name=updateClothId><br>
<br>
<input type=submit>
<input type=reset>
</form>
</div>
<br>
<div class="myDiv2">
<form method="post">
Cloth ID:<br><input type=text name=clothId value=001 width=100%><br>
<br>
Cloth Name:<br><input type=text name=clothName value=Flannel width=50%><br>
<br>
Cloth Price:<br><input type=text name=clothPrice value=129.90 width=50%><br>
<br>
Cloth Description:<br><input type=text name=clothDescription value="Soft and Comfy" width=50%><br>
<br>
<input type=submit>
<input type=reset>
</form>
</div>
</center>
</body>
</html>