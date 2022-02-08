const buttonAssignRole = document.getElementById("buttonAssignRole");
const buttonCreateSection = document.getElementById("buttonCreateSection");
const buttonChangeCourseName = document.getElementById("buttonChangeCourseName");
const buttonAddUser = document.getElementById("buttonAddUser");
const buttonChangeSemester = document.getElementById("buttonChangeSemester");

// Part 1 User Assign Role
buttonAssignRole.addEventListener("click", function (e) {
  e.preventDefault();
  let schoolID = parseInt(document.getElementById("RoleUserID").value);
  let role = document.getElementById("Options").options[document.getElementById("Options").selectedIndex].innerText.toString();
  let httpRequest = new XMLHttpRequest();
  httpRequest.overrideMimeType("application/json");
  httpRequest.open("GET", 'http://localhost:8080//UserController/assignRoleToUser?schoolID='+schoolID+'&role='+role);
  httpRequest.onload = function () {
    window.location.reload();
  }
  httpRequest.send();
});

// Part 2.1 Semester Adding
buttonChangeSemester.addEventListener("click", function (e) {
  e.preventDefault();
  let semester =document.getElementById("Semester").value;
  let httpRequest = new XMLHttpRequest();
  httpRequest.overrideMimeType("application/json");
  httpRequest.open("GET", 'http://localhost:8080//CurrentSystemInfoController/changeCurrentSemester?semester='+semester);
  httpRequest.onload = function () {
    window.location.reload();
  }
  httpRequest.send();
});

// Part 2.2 Change Course Name
buttonChangeCourseName.addEventListener("click", function (e) {
  e.preventDefault();
  let courseName = document.getElementById("CourseName").value;
  let httpRequest = new XMLHttpRequest();
  httpRequest.overrideMimeType("application/json");
  httpRequest.open("GET", 'http://localhost:8080//CurrentSystemInfoController/changeCurrentCourseName?courseName='+courseName);
  httpRequest.onload = function () {
    window.location.reload();
  }
  httpRequest.send();
});

// Part 2.3 Section Adding
buttonCreateSection.addEventListener("click", function (e) {
  e.preventDefault();
  let instructorID = parseInt(document.getElementById("InstructorID").value);
  let sectionNumber = parseInt(document.getElementById("sectionNumber").value);
  let httpRequest = new XMLHttpRequest();
  httpRequest.overrideMimeType("application/json");
  httpRequest.open("GET", 'http://localhost:8080//SectionController/addSection?sectionNumber='+sectionNumber+"&instructorID="+instructorID);
  httpRequest.onload = function () {
    window.location.reload();
  }
  httpRequest.send();
});

// Part 3 User Assign Section
buttonAddUser.addEventListener("click", function (e) {
  e.preventDefault();
  let schoolID = parseInt(document.getElementById("AssignUserID").value);
  let sectionNumber = parseInt(document.getElementById("AssignSectionNumber").value);
  let httpRequest = new XMLHttpRequest();
  httpRequest.overrideMimeType("application/json");
  httpRequest.open("GET", 'http://localhost:8080//SectionController/addUserToSection?schoolID='+schoolID+'&sectionNumber='+sectionNumber);
  httpRequest.onload = function () {
    window.location.reload();
  }
  httpRequest.send();
});
