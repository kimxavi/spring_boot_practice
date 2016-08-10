<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>promotion write form</title>
</head>
<body>
c<input type="button" id="create" value="create"/>
u<input type="button" id="update" value="update" />
d<input type="button" id="delete" value="delete" />

PUT<input type="button" id="put" value="put" />
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script>

    $('#create').click(function(){ 
    	  var form = {
    		      title: "love",
    		      imgurl: "123",
    		  };

    	  $.ajax({
    	      url: "http://localhost:8080/promotion",
    	      method: "post",
    	      type: "json",
    	      contentType: "application/json",
    	      data: JSON.stringify(form),
    	      success: function(data) {
    	          alert("create");
    	      }
    	  });
    });

    $('#update').click(function(){
        
  	  var form = {
  		      title: "updatetitle",
  		      imgurl: "updateimgurl",
  		  };

  	  $.ajax({
  	      url: "http://localhost:8080/promotion/1",
  	      method: "post",
  	      type: "json",
  	      contentType: "application/json",
  	      data: JSON.stringify(form),
  	      success: function(data) {
  	          alert("update");
  	      }
  	  });
  	});

    $('#delete').click(function(){
       	 $.ajax({
    	      url: "http://localhost:8080/promotion/1",
    	      method: "delete",
    	      success: function(data) {
    	          alert("delete");
    	      }
    	  });
    	});

    $('#put').click(function(){
      	 $.ajax({
   	      url: "http://localhost:8080/promotion/1",
   	      method: "put",
   	      success: function(data) {
   	          alert("put");
   	      }
   	  });
   	});
    	
  

</script>

</body>
</html>