<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div  style="width: 60%; float: left;">

<table border=1><tbody><tr>
<td>id </td><td>firstname</td><td>lastname </td><td>login </td><td>Action </td>
</tr>
<tr>
<td>1 </td><td>x</td><td>y </td><td>z </td><td>Supprimer - Modifier </td>
</tr>
</tbody></table>
</div>

<div style="width: 40%; float: left;">
<form>
<label>firstname</label>
<input type="text"><br>
<label>lastname</label>
<input type="text"><br>
<label>login</label>
<input type="text"><br>
<label>password</label>
<input type="password"><br>
<button>ajouter / modifier</button>

</form>
</div>
<script
  src="https://code.jquery.com/jquery-3.2.1.min.js"
  integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
  crossorigin="anonymous"></script>
  <script type="text/javascript">
  $.ajax({
	 url : "/api/user/",
     type: "GET" ,
     success:  function(result){
    	// alert(result);
    	console.log(result);
    	
    	//effacer le contenu
    	$("#users tbody").empty()
    	
    	result.each(function(){
    		
    	}
     }
  });
  
  </script>

</body>
</html>