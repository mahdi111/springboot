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

<table border=1 id="users">
<thead>
<tr>
<th>id </th><td>firstname</td><td>lastname </td><td>login </td><td>Action </td>
</tr>
</thead>
<tbody>
<tr>
<td>1 </td><td>x</td><td>y </td><td>z </td><td>Supprimer - Modifier </td>
</tr>
</tbody></table>
</div>

<div  style="width: 40%; float: left;">
<form id="nice">
<label>firstname</label>
<input type="text" name="firstName"><br>
<label>lastname</label>
<input type="text" name="lastName"><br>
<label>login</label>
<input type="text" name="login"><br>
<label>password</label>
<input type="password" name="password"><br>
<button id="target" type="button">ajouter / modifier</button>

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
    	
    	$.each(result,function(i,item){
    		var tr="<tr>";
    		tr += "<td>" +item.id + "</td>";
    		tr += "<td>" +$(this)[0].firstName + "</td>";
    		tr += "<td>" +$(this)[0].lastName + "</td>";
    		tr += "<td>" +$(this)[0].login + "</td>";
    		tr += "<td></td>";
    		tr += "</tr>";
    		$("#users tbody").append(tr);
    		    		
    	});
     }
  });
$( "#target" ).click(function() {
	$.ajax({
		  url:'/api/ajouter',
		  type:"POST",
		  data:$("form").serialize(),
		  success: function(){
			  alert( "it's work" );
		  }
		})
});
  
  
  </script>

</body>
</html>