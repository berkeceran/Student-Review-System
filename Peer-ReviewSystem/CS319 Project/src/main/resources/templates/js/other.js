function goDash(){
  if(localStorage.getItem("userRole")=== "student"){
    window.location.href = "DashboardStudent.html";
    console.log(localStorage.getItem("userRole"));
  }
  else if(localStorage.getItem("userRole") === "instructor"
      || localStorage.getItem("userRole") === "TA") {
    window.location.href = "DashboardInstructor.html";
  }
}

function sendMessage() {
  var message1 = document.getElementById("usermsg").value;
  var li = document.createElement("LI");  
  li.innerHTML = message1;
  li.value= message;
  if(li.innerHTML != ""){
    document.getElementById("messages").appendChild(li);
  }
  
  console.log(li.innerHTML);
  document.getElementById("usermsg").value = "";

}
function contactUS() {
  let nameOfContact = document.getElementById("Options");
  let emailOfContact = document.getElementById("emailOfContact");
  let findUsHow = document.getElementById("findUsHow");
  let choiceOfFindUs = findUsHow.options[findUsHow.selectedIndex].text;
  let messageOfUser = document.getElementById("messageOfUser");
  let httpRequest = new XMLHttpRequest();
  httpRequest.overrideMimeType("application/json");
  httpRequest.open("GET", 'http://localhost:8080//OtherController/insertContactUsInfo?nameOfContact='+nameOfContact+"&emailOfContact="+emailOfContact+"&findUsHow="+findUsHow+"&choiceOfFindUs="+choiceOfFindUs+"&messageOfUser="+messageOfUser);
  httpRequest.onload = function () {
    let result = httpRequest.responseText;
    alert("The result of contactUS is " + result);
  }
  httpRequest.send();
}