localStorage.removeItem("navigatedStudent");
function getInformation() {
    getAllGroupsAndSections()
    getCourseName();
    getSemesterName();
    document.getElementById("studentFullName").innerHTML = localStorage.getItem("name") + " " + localStorage.getItem("surname");
}

function getAllGroupsAndSections() {
    let section = parseInt(localStorage.getItem("section"));
    let httpRequest = new XMLHttpRequest();
    httpRequest.overrideMimeType("application/json");
    httpRequest.open("GET", 'http://localhost:8080//SectionController/getGroupsOfSection?sectionNumber='+section);
    httpRequest.onload = function () {
        let response = httpRequest.responseText;
        let groups = JSON.parse(response);
        let section = { group: groups , name: localStorage.getItem("section") };
        let currentSection = section ;
        let sections = [];
        sections.push(section);
        sections.forEach(function (element){
            let li = document.createElement("LI");
            li.value = element;
            let buttonE = document.createElement('button');
            buttonE.innerText = element.name;
            li.append(buttonE);
            buttonE.onclick = function() {
                currentSection={ group: element.group, name: element.name};
                if(document.getElementById("group-list").innerHTML!==""){
                    document.getElementById("group-list").innerHTML="";

                }
                renew();
            };
            document.getElementById("section-list").appendChild(li);
        });
    }
    httpRequest.send();
}

function renew() {
    currentSection.group.forEach(function(element) {
        var li = document.createElement("LI");
        li.value = element;
        console.log(currentSection.group[1].name);
        console.log(li);
        var buttonE = document.createElement('button');
        buttonE.innerText = element.name;
        li.append(buttonE);
        buttonE.onclick = function() { };
        document.getElementById("group-list").appendChild(li);
    });
}


function gotoGroupProfile() {
    // onclick=localStorage.setItem("viewGroupProfileName", groupName);
    window.location="GroupProfile.html";
}

function gotoPersonalProfile() {
    // localStorage.setItem("navigatedStudent", localStorage.getItem("id"))
    window.location="StudentProfile.html";
}

function getCourseName() {
    let result;
    let httpRq = new XMLHttpRequest();
    httpRq.overrideMimeType("application/json");
    httpRq.open("GET", 'http://localhost:8080/CurrentSystemInfoController/getCurrentCourseName');
    httpRq.onload = function () {
        result = httpRq.responseText;
        document.getElementById("courseName").innerHTML = result;
    }
    httpRq.send();
}

function getSemesterName() {
    let result;
    let httpRq = new XMLHttpRequest();
    httpRq.overrideMimeType("application/json");
    httpRq.open("GET", 'http://localhost:8080/CurrentSystemInfoController/getCurrentSemester');
    httpRq.onload = function () {
        result = httpRq.responseText;
        localStorage.setItem("semester", result);
        document.getElementById("semesterName").innerHTML = result;
    }
    httpRq.send();
}

function createGroup2(){
    let sectionID = parseInt(localStorage.getItem("section"));
    let studentID = parseInt(localStorage.getItem("id"));

    let httpRequest = new XMLHttpRequest();
    httpRequest.overrideMimeType("application/json");
    // section is 1, needs to be replaced
    httpRequest.open("GET", 'http://localhost:8080//GroupFormationController/notRandomGenerator?sectionID='+sectionID+'&studentID='+studentID);
    httpRequest.onload = function () {
        let json = JSON.parse(httpRequest.responseText);
        if (json["result"] === "true") {
            alert("You have created new group. If you encounter with any error, please contact with admin.");
            localStorage.setItem("groupId", json["group"]);
        }
    }
    httpRequest.send();
}

function logoutSystem() {
    localStorage.clear();
}

var formmationStyle = 0;

var modal = document.getElementById("myModal");

// Get the button that opens the modal
var createGroup = document.getElementById("groupCreate");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks on the button, open the modal
if(modal!== null){
    createGroup.onclick = function() {
        modal.style.display = "block";
        let size = parseInt(document.getElementById("quantity").value);
        let httpRequest = new XMLHttpRequest();
        httpRequest.overrideMimeType("application/json");
        // section is 1, needs to be replaced
        httpRequest.open("GET", 'http://localhost:8080//GroupFormationController/randomGenerator?size='+size+'&sectionID='+parseInt(localStorage.getItem("section")));
        httpRequest.onload = function () {
            let output = httpRequest.responseText;
        }
        httpRequest.send();
    }

    // When the user clicks on <span> (x), close the modal
    span.onclick = function() {
        modal.style.display = "none";
    }

    // When the user clicks anywhere outside of the modal, close it
    window.onclick = function(event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }
}

function sendMessage() {
    var message1 = document.getElementById("usermsg").value;
    var li = document.createElement("LI");
    li.innerHTML = message1;
    li.value= message;
    if(li.innerHTML !== "") {
        document.getElementById("messages").appendChild(li);
    }
    console.log(li.innerHTML);
    document.getElementById("usermsg").value = "";
}