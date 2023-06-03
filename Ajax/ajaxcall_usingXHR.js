function apicall()
{
    let httpRequest=new XMLHttpRequest();
    httpRequest.open("GET",'http://localhost:8080/api/student');
    httpRequest.send();
    httpRequest.onload=function(){
     console.log(httpRequest.responseText);
    }
    
    console.log("inside the .js file")
}