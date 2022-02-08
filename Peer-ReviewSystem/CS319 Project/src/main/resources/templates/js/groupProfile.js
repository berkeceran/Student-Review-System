
let currentGroup = localStorage.getItem("currentGroup");
let members = [];

let artifact = {
    url:"",
    comment:""
}


function myFunction() {
    // Get current semester
    let httpRq = new XMLHttpRequest();
    httpRq.overrideMimeType("application/json");
    httpRq.open("GET", 'http://localhost:8080/CurrentSystemInfoController/getCurrentSemester');
    httpRq.onload = function () {
        let result = httpRq.responseText;
        document.getElementById("semester").innerHTML = result;  // assign semester
        // Get Current Course
        let httpRq2 = new XMLHttpRequest();
        httpRq2.overrideMimeType("application/json");
        httpRq2.open("GET", 'http://localhost:8080/CurrentSystemInfoController/getCurrentCourseName');
        httpRq2.onload = function () {
            result = httpRq2.responseText;
            document.getElementById("courseName").innerHTML = localStorage.getItem("courseName");  // assign course name
        }
        httpRq2.send();
    }
    httpRq.send();


    // get the users groupID
    let httpRequest = new XMLHttpRequest();
    let studentID = parseInt(localStorage.getItem("id"));
    httpRequest.overrideMimeType("application/json");
    httpRequest.open("GET", 'http://localhost:8080/ProfileController/getStudentsGroup?studentID='+studentID);
    httpRequest.onload = function () {
        let groupID = httpRequest.responseText;
        localStorage.setItem("groupID", groupID);

        //decide whether group is her group or other group
        /*
        if(currentGroup === null)
        {
            currentGroup = localStorage.getItem("groupID");
            localStorage.setItem("currentGroup",currentGroup);
        }
        else
        {
            //document.getElementById("uploadedFile").style.visibility = "hidden";
            //document.getElementById("reviewFiles").style.visibility = "hidden";
            document.getElementById("row2").style.visibility = "hidden";
            document.getElementById("row4").style.visibility = "hidden";
        }

         */
        // get github link
        let httpRq = new XMLHttpRequest();
        httpRq.overrideMimeType("application/json");
        let groupName = currentGroup;
        httpRq.open("GET", 'http://localhost:8080/GroupFormationController/getGithubLink?groupName=' + groupName);
        httpRq.onload = function () {
            let result = httpRq.responseText;
            let json = JSON.parse(result);
            artifact.url = json[0];
            artifact.comment = json[1];
            alert(artifact.url);
            alert(artifact.comment);
            // get users from group
            let httpRq = new XMLHttpRequest();
            httpRq.overrideMimeType("application/json");
            httpRq.open("GET", 'http://localhost:8080/GroupFormationController/getGroupMembers?groupID=' + groupName);
            httpRq.onload = function () {
                let result = httpRq.responseText;
                let json = JSON.parse(result);
                for(let i = 0; i < json.length ;i++)
                {
                    members.push(json[i]);
                    alert(members[i]);
                }
            }
            members.forEach(function (element){
                let li = document.createElement("LI");
                let buttonE = document.createElement('button');
                buttonE.innerText = element.name;
                buttonE.setAttribute("id","goProfle");
                li.append(buttonE);
                buttonE.onclick = function() {
                    //basılan profili burada tutabiliriz şuan ad olarak tutuyor
                    localStorage.setItem("visitedStudentProfile",element.name);
                    window.location="StudentProfile.html";
                }
                document.getElementById("members").appendChild(li);
            });
        }
        httpRq.send();
        document.getElementById("Groupname").innerHTML = localStorage.getItem("currentGroup"); // assign current group
    }
    httpRequest.send();
}


function getGithubLink()
{
    let httpRq = new XMLHttpRequest();
    httpRq.overrideMimeType("application/json");
    let groupName = currentGroup;
    httpRq.open("GET", 'http://localhost:8080/GroupFormationController/getGithubLink?groupName=' + groupName);
    httpRq.onload = function () {
        let result = httpRq.responseText;
        let json = JSON.parse(result);
        artifact.url = json[0];
        artifact.comment = json[1];
    }
    httpRq.send();
}
// This
function getInformation() {

    // Get current semester
    let httpRq = new XMLHttpRequest();
    httpRq.overrideMimeType("application/json");
    httpRq.open("GET", 'http://localhost:8080/CurrentSystemInfoController/getCurrentSemester');
    httpRq.onload = function () {
        let result = httpRq.responseText;
        document.getElementById("semester").innerHTML = result;  // assign semester
        // Get Current Course
        let httpRq2 = new XMLHttpRequest();
        httpRq2.overrideMimeType("application/json");
        httpRq2.open("GET", 'http://localhost:8080/CurrentSystemInfoController/getCurrentCourseName');
        httpRq2.onload = function () {
            result = httpRq2.responseText;
            document.getElementById("courseName").innerHTML = localStorage.getItem("courseName");  // assign course name
        }
        httpRq2.send();
    }
    httpRq.send();
}

// Get users group name
function getGroupOfUser() {
    let httpRequest = new XMLHttpRequest();
    let studentID = parseInt(localStorage.getItem("id"));
    httpRequest.overrideMimeType("application/json");
    httpRequest.open("GET", 'http://localhost:8080/ProfileController/getStudentsGroup?studentID='+studentID);
    httpRequest.onload = function () {
        let groupId = httpRequest.responseText;
        localStorage.setItem("groupId", groupId);
        document.getElementById("Groupname").innerHTML = localStorage.getItem("currentGroup"); // assign current group
    }
    httpRequest.send();
}

// Leave group
function leaveGroup() {
    // Remove student text varsayimsal bir id, kutuya ne verdiyseniz ekleyin
    let studentID = parseInt(localStorage.getItem("id"));
    let httpRequest = new XMLHttpRequest();
    httpRequest.overrideMimeType("application/json");
    httpRequest.open("GET", 'http://localhost:8080/GroupFormationController/removeUserFromGroup?studentID='+studentID);
    httpRequest.onload = function () {
        window.location.href = "DashboardStudent.html";
    }
    httpRequest.send();
}

// Add member to group
function addMemberToGroup() {
    //int studentID, String groupName,int sectionID
    getGroupOfUser();
    let groupName = localStorage.getItem("groupId");
    let studentID = parseInt(document.getElementById("invitedId").value);
    let sectionID = parseInt(localStorage.getItem("section"));
    let httpRequest = new XMLHttpRequest();
    httpRequest.overrideMimeType("application/json");
    httpRequest.open("GET", 'http://localhost:8080/GroupFormationController/notRandomGeneratorAddMember?studentID='+studentID+'&groupName='+groupName+'&sectionID='+sectionID);
    httpRequest.onload = function () {
        window.location.reload();
    }
    httpRequest.send();
}

// Remove member from group
function removeUserFromGroup() {
    // Remove student text varsayimsal bir id, kutuya ne verdiyseniz ekleyin
    let studentID = parseInt(document.getElementById("deletedId").value);
    let httpRequest = new XMLHttpRequest();
    httpRequest.overrideMimeType("application/json");
    httpRequest.open("GET", 'http://localhost:8080/GroupFormationController/removeUserFromGroup?studentID='+studentID);
    httpRequest.onload = function () {
        window.location.reload();
    }
    httpRequest.send();
}

// Add github link and artifact
function addGithubLink() {
    let link = document.getElementById("gitUrl").value;
    getGroupOfUser();
    let groupName = localStorage.getItem("groupId");
    let description = document.getElementById("coments").value;
    let httpRequest = new XMLHttpRequest();
    httpRequest.overrideMimeType("application/json");
    httpRequest.open("GET", 'http://localhost:8080/GroupFormationController/addGithubLink?link='+link+'&groupName='+groupName+'&description='+description);
    httpRequest.onload = function () {
        window.location.reload();
    }
    httpRequest.send();
}

// Add artifact Reviews
function addArtifactReview() {
    getGroupOfUser();
    let groupName = localStorage.getItem("groupId");
    let artifactType = document.getElementById("artifactName").value;
    let answer = document.getElementById("content").value;
    // If user is in its own group, then he/she cannot give artifact review.
    let giverID = parseInt(localStorage.getItem("id"));
    let httpRequest = new XMLHttpRequest();
    httpRequest.overrideMimeType("application/json");
    httpRequest.open("GET", 'http://localhost:8080/ArtifactReviewController/giveArtifactReviewToGroup?groupName='+groupName+'&artifactType='+artifactType+'&answer='+answer+'&giverID='+giverID);
    httpRequest.onload = function () {
        window.location.reload();
    }
    httpRequest.send();
}

// -------------------------------------------------------------------------------
// -------------------------------------------------------------------------------
// -------------------------------------------------------------------------------

/*
function getStudentsGroup() {
    let httpRequest = new XMLHttpRequest();
    let studentID = parseInt(localStorage.getItem("id"));
    httpRequest.overrideMimeType("application/json");
    httpRequest.open("GET", 'http://localhost:8080/ProfileController/getStudentsGroup?studentID='+parseInt(localStorage.getItem("id")));
    httpRequest.onload = function () {
        let groupId = httpRequest.responseText;
        localStorage.setItem("groupID", groupId);
    }
    httpRequest.send();
}

 */


/*

function addArtifacts (){
    let createA = document.createElement('a');
    createA.setAttribute('href', artifact.url);
    let createLabel = document.createElement("P");
    createLabel.innerText = artifact.comment;
    createA.innerText = artifact.url;
    document.getElementById("groupDescription").append(createLabel);
    document.getElementById("groupDescription").append(createA);
}

function sendReview() {
    let li = document.createElement("LI");
    let name = document.getElementById("artifactName").value;
    let reviewContent = document.getElementById("content").value;
    let Label1 = document.createElement("div");
    let Label2 = document.createElement("P");
    Label1.innerText =localStorage.getItem(name)+" : "+ name;
    Label2.innerText = reviewContent;
    li.append(Label1);
    li.append(Label2);
    if(li.innerHTML != ""){
        document.getElementById("reviews").appendChild(li);
    }
    console.log(li.innerHTML);
    document.getElementById("artifactName").value = "";
    document.getElementById("content").value = "";
}

 */
