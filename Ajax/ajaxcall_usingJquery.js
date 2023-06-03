function fetchUser(){
	
	var tableData = "";
	 $.ajax({  
	 	 type: "GET",   
	     url : "http://localhost:8080/api/student",
         dataType:"JSON",
		 headers: {
            'Content-Type': 'application/json',
          },
	     success : function(response) {
	    console.log(response);
	    
	    response.forEach(function(item){
	    	tableData += '<tr>' +
      	  		
                '<td id = "name'+ item.id +'">' + item.id + '</td>' +
      	  		'<td id = "name'+ item.id +'">' + item.name + '</td>' +
      	  		'<td id = "email'+ item.id +'">' + item.age+ '</td>' +
      	  		'<td id = "address'+ item.id +'">' + item.email + '</td>' +
      	  	    
      	  	    '</td>'+
						
      	  		'</tr>';
        });
      $("#user-table>tbody").html(tableData);		    	 
	     },
	     error: function (response){
         console.log(response);
	      }
   });
	
}