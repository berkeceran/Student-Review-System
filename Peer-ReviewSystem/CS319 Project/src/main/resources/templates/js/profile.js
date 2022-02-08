function myFunction() {
    let schoolID = parseInt(localStorage.getItem("navigatedStudent"));
    let name, surname, email,section, group, course;
    if(isNaN(schoolID)) {
        schoolID = localStorage.getItem("id");
        localStorage.setItem("studentID", schoolID);
        name = localStorage.getItem("name");
        surname = localStorage.getItem("surname");
        email = localStorage.getItem("email");
    } else {
        getStudentsSection(schoolID);
        getGroupOfUser(schoolID);
        let httpRequest = new XMLHttpRequest();
        httpRequest.overrideMimeType("application/json");
        httpRequest.open("GET", 'http://localhost:8080//SignUpController/getUserInformation?schoolID='+schoolID);
        httpRequest.onload = function () {
            let userJSON = JSON.parse(httpRequest.responseText);
            localStorage.setItem("studentID", userJSON["id"]);
            name = userJSON["name"];
            surname = userJSON["surname"];
            email = userJSON["email"];
        }
    }
    getStudentsSection(schoolID);
    getGroupOfUser(schoolID);
    getCourseName();
    section = localStorage.getItem("studentSection");
    group = localStorage.getItem("studentGroupID");
    course = localStorage.getItem("studentCourse");
    document.getElementById("name").innerHTML = " Name : " + name;
    document.getElementById("surname").innerHTML = " Surname : " + surname;
    document.getElementById("Email").innerHTML = " Email : " + email;
    document.getElementById("Course").innerHTML = " Course : " + course;
    document.getElementById("Semester").innerHTML = " Semester : " + localStorage.getItem("semester");
    document.getElementById("Section").innerHTML = " Section : " + section;
    document.getElementById("Group").innerHTML = " Group : " + group;
    //yukarıdaki kodları düzeltmeyi unutma

}

function getStudentsSection(studentID) {
    let rq1 = new XMLHttpRequest();
    rq1.overrideMimeType("application/json");
    rq1.open("GET", 'http://localhost:8080/SectionController/getSectionOfStudent?studentID='+parseInt(studentID));
    rq1.onload = function () {
        let section = rq1.responseText;
        localStorage.setItem("studentSection", section);
    }
    rq1.send();
}

// Get users group name
function getGroupOfUser(studentID) {
    let rq2 = new XMLHttpRequest();
    rq2.overrideMimeType("application/json");
    rq2.open("GET", 'http://localhost:8080/ProfileController/getStudentsGroup?studentID='+studentID);
    rq2.onload = function () {
        let groupId = rq2.responseText;
        localStorage.setItem("studentGroupID", groupId);
    }
    rq2.send();
}

function getCourseName() {
    let result;
    let httpRq = new XMLHttpRequest();
    httpRq.overrideMimeType("application/json");
    httpRq.open("GET", 'http://localhost:8080/CurrentSystemInfoController/getCurrentCourseName');
    httpRq.onload = function () {
        result = httpRq.responseText;
        localStorage.setItem("studentCourse", result);
    }
    httpRq.send();
}
//for show how to use
function getAllPeerReviews() {
    let studentID = localStorage.getItem("studentID");
    httpRq.overrideMimeType("application/json");
    let groupID = localStorage.getItem("studentGroupID");
    httpRq.open("GET", 'http://localhost:8080/GroupFormationController/getGroupMembers?groupID='+groupID);
    httpRq.onload = function () {
        let result = httpRq.responseText;
        let json = JSON.parse(result);
        let students = [];
        for(let element in json) {
            list.push(getPeerReviews(parseInt(element), parseInt(studentID)));
        }
        return students;
    }
    httpRq.send();
}


// Get 1 person's peer review
function getPeerReviews(giverID, receiverID) {
    let httpRequest = new XMLHttpRequest();
    let id = parseInt(giverID);
    let rec = parseInt(receiverID);
    httpRequest.overrideMimeType("application/json");
    httpRequest.open("GET", 'http://localhost:8080//PeerReviewController/getPeerReviewAnswers?giverID='+id+'&receiverID'+rec);
    httpRequest.onload = function () {
        let result = httpRequest.responseText;
        let rw = [];
        rw.push(result);
        let student = { review: rw, name: giverID};
        return student;
    }
}

//peers od student
let students = getAllPeerReviews();
// need a stude
students.forEach(function (element){
    let li = document.createElement("LI");
    li.value = element;
    let buttonE = document.createElement('button');
    buttonE.innerText = element.name;
    li.append(buttonE);
    buttonE.onclick = function() {
        currentStudent={ review: element.review, name: element.name};
        if(document.getElementById("questions").innerHTML!==""){
            document.getElementById("questions").innerHTML="";
        }
        renew();
    };
    document.getElementById("students").appendChild(li);
});



function renew () {
    currentStudent.review.forEach(function(element){
        let  li = document.createElement("LI");
        li.value = element;
        let label = document.createElement('label');
        //question
        label.innerText = element;
        li.append(label);
        document.getElementById("questions").appendChild(li);
    });

}

