localStorage.removeItem("navigatedStudent");
let sts = localStorage.getItem("sections");
let currentSection =localStorage.getItem("currentSection");
let sections = [];
for(let i=0; i<sts.length; i++) {
    let grps = getAllGroupsInCurrentSection(parseInt(sts[i]));
    let section = { group: grps, name: sts[i].toString()};
    sections.push(section);
}
sections.forEach(function (element) {
    var li = document.createElement("LI");
    li.value = element;
    var buttonE = document.createElement('button');
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

function renew () {
    currentSection.group.forEach(function(element) {
        let li = document.createElement("LI");
        li.value = element;
        let buttonE = document.createElement('button');
        buttonE.innerText = element.name;
        li.append(buttonE);
        buttonE.onclick = function() { };
        document.getElementById("group-list").appendChild(li);
    });
}

function sendMessage(){
    let message1 = document.getElementById("usermsg").value;
    let li = document.createElement("LI");
    li.innerHTML = message1;
    li.value= message;
    if(li.innerHTML !== ""){
        document.getElementById("messages").appendChild(li);
    }

    console.log(li.innerHTML);
    document.getElementById("usermsg").value = "";
}

function logoutSystem() {
    localStorage.clear();
}

//Pop up instructor start group formation
// Get the modal
let modal = document.getElementById("myModal");

// Get the button that opens the modal
let btn = document.getElementById("groupFormB");

// Get the <span> element that closes the modal
let span = document.getElementsByClassName("close")[0];

// When the user clicks on the button, open the modal
if(modal!== null){
    btn.onclick = function() {
        modal.style.display = "block";
    }

    // When the user clicks on <span> (x), close the modal
    span.onclick = function() {
        modal.style.display = "none";
    }

    // When the user clicks anywhere outside of the modal, close it
    window.onclick = function(event) {
        if (event.target === modal) {
            modal.style.display = "none";
        }
    }
}

function randomForm() {
    let size = parseInt(document.getElementById("quantity").value);
    let httpRequest = new XMLHttpRequest();
    httpRequest.overrideMimeType("application/json");
    httpRequest.open("GET", 'http://localhost:8080//GroupFormationController/randomGeneratorAllSections?size='+size);
    httpRequest.onload = function () {
    }
    httpRequest.send();
}

function manualForm(){
    let httpRequest = new XMLHttpRequest();
    httpRequest.overrideMimeType("application/json");
    httpRequest.open("GET", 'http://localhost:8080//ProcessController/changeGroupFormation?status=on');
    httpRequest.onload = function () {}
    httpRequest.send();
}

function closeGroupFormation() {
    let httpRequest = new XMLHttpRequest();
    httpRequest.overrideMimeType("application/json");
    httpRequest.open("GET", 'http://localhost:8080//ProcessController/changeGroupFormation?size=off');
    httpRequest.onload = function () {}
    httpRequest.send();
}

function getGroupFormationStatus() {

}
//pop-up end
//write your code here
// This function will return the list of all sections
function getAllGroupsInCurrentSection(sectionNumber) {
    let httpRequest = new XMLHttpRequest();
    httpRequest.overrideMimeType("application/json");
    httpRequest.open("GET", 'http://localhost:8080//SectionController/getGroupsOfSection?sectionNumber='+sectionNumber);
    httpRequest.onload = function () {
        let groups = JSON.parse(httpRequest.responseText);
        let returnGroups = new Array;
        for(let i=0; i<groups.length; i++) {
            returnGroups.push(groups[i]);
        }
        return returnGroups;
    }
    httpRequest.send();
}
