let requests = new Array();
var request1={name:"Güven"};
var request2={name:"Lara"};
requests.push(request1);
requests.push(request2);

// Add member to group
function addMemberToGroup() {
    //int studentID, String groupName,int sectionID
    let groupID = localStorage.getItem("groupId");
    let studentID = parseInt(localStorage.getItem("id"));
    let sectionID = parseInt(localStorage.getItem("section"));
    let httpRequest = new XMLHttpRequest();
    httpRequest.overrideMimeType("application/json");
    httpRequest.open("GET", 'http://localhost:8080/GroupFormationController/notRandomGeneratorAddMember?groupID='+groupID+'&studentID='+studentID+'&sectionID='+sectionID);
    httpRequest.onload = function () {
        let returnMessage = httpRequest.responseText;
        alert("The returnMessage is " + returnMessage);
    }
    httpRequest.send();
}

// Remove member from group
function removeUserFromGroup() {
    // Remove student text varsayimsal bir id, kutuya ne verdiyseniz ekleyin
    let studentID = localStorage.getItem("removeStudentText");
    let httpRequest = new XMLHttpRequest();
    httpRequest.overrideMimeType("application/json");
    httpRequest.open("GET", 'http://localhost:8080/GroupFormationController/removeUserFromGroup?studentID='+parseInt(localStorage.getItem("id")));
    httpRequest.onload = function () {
        let message = httpRequest.responseText;
        alert("The message from remove student function " + message);
    }
    httpRequest.send();
}

function getStudentsGroup() {
    let httpRequest = new XMLHttpRequest();
    let studentID = parseInt(localStorage.getItem("id"));
    httpRequest.overrideMimeType("application/json");
    httpRequest.open("GET", 'http://localhost:8080/ProfileController/getStudentsGroup?studentID='+parseInt(localStorage.getItem("id")));
    httpRequest.onload = function () {
        let groupId = httpRequest.responseText;
        localStorage.setItem("groupID", groupId);
        alert("group section of user is " + groupID);
    }
    httpRequest.send();
}


localStorage.setItem("myGroup","groupA");
function myFunction() {

    document.getElementById("Groupname").innerHTML =localStorage.getItem("viewGroupProfileName");
    if(document.getElementById("Groupname").innerHTML!== localStorage.getItem("myGroup")){
        document.getElementById("uploadedFile").style.visibility = "hidden";
        document.getElementById("reviewFiles").style.visibility = "hidden";
        document.getElementById("row2").style.visibility = "hidden";
        document.getElementById("row3").style.visibility = "hidden";
        document.getElementById("row4").style.visibility = "hidden";
        document.getElementById("row5").style.visibility = "hidden";
    }
    else{
        document.getElementById("row1").style.visibility = "hidden";
    }
    requests.forEach(function (element){
        var li = document.createElement("LI");
        li.innerText = element.name;
        var buttonE = document.createElement('button');
        buttonE.innerText = "Accept";
        buttonE.setAttribute("id","accept");
        li.append(buttonE);
        buttonE.onclick = function() { }
        var buttonA = document.createElement('button');
        buttonA.setAttribute("id","reject");
        buttonA.innerText = "Reject";
        li.append(buttonA);
        buttonE.onclick = function() { }
        document.getElementById("requests").appendChild(li);
    });





}

