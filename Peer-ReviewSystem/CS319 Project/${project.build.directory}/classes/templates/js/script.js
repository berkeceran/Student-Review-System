let user;

function loginToSystem() {
    // Get the username and password
    let pass = document.getElementById("Pass").value;
    let userName = parseInt(document.getElementById("Uname").value);
    // Http Protocol
    let result = "false";
    let httpRq = new XMLHttpRequest();
    httpRq.overrideMimeType("application/json");
    httpRq.open("GET", 'http://localhost:8080/SignUpController/validateUser?schoolID='+userName+'&password='+pass);
    httpRq.onload = function () {
        result = httpRq.responseText;
        // The validation is done for the username and password. If there is any matching, then user is allowed to enter.
        if(result === "true") {
            // The information will be retrieved from database
            let httpRequest = new XMLHttpRequest();
            httpRequest.overrideMimeType("application/json");
            httpRequest.open("GET", 'http://localhost:8080/SignUpController/login?schoolID='+parseInt(document.getElementById("Uname").value));
            httpRequest.onload = function () {
                // The information of user will be stored locally.
                user = JSON.parse(httpRequest.responseText);
                localStorage.setItem("id", user["id"]);
                localStorage.setItem("name",user["name"]);
                localStorage.setItem("surname", user["surname"]);
                localStorage.setItem("email", user["email"]);
                localStorage.setItem("userRole",user["userRole"]);
                goDash();
            }
            httpRequest.send();
        } else {
            alert("Invalid Username or Password.");
            window.location.reload();
        }
    }
    httpRq.send();
}

function signUp() {
    // Storing the input of user
    let name = document.getElementById("Name").value;
    let surname = document.getElementById("Surname").value;
    let id = parseInt(document.getElementById("ID").value,10);
    let pass= document.getElementById("sign_up_pass").value;
    let confirmpass = document.getElementById("ConfirmPass").value;
    let email = document.getElementById("EMail").value;
    let userRole = "user";
    // Validating both password that user entered.
    if(confirmpass == pass) {
        // Validation of informations. If there is any user that is enrolled with same 'id' then the signing up will not be allowed.
        let httpRequest = new XMLHttpRequest();
        httpRequest.overrideMimeType("application/json");
        httpRequest.open("GET", 'http://localhost:8080/SignUpController/signUp?name='+name+'&surname='+surname
            +'&email='+email+'&password='+pass+'&schoolID='+id+'&userRole='+userRole);
        httpRequest.onload = function () {
            alert("Thank you for registering to our application.");
            window.location.reload();
        }
        httpRequest.send();
    } else {
        alert("Passwords are not matching!");
    }
}

function goDash(){
    assignSections();
    if(localStorage.getItem("userRole")=== "student"){
        alert("the section of student is " + localStorage.getItem("section"));
        window.location.href = "DashboardStudent.html";
    }
    else if(localStorage.getItem("userRole")=== "instructor" || localStorage.getItem("userRole")=== "TA" ){
        window.location.href = "DashboardInstructor.html";
    }
    else if(localStorage.getItem("userRole") === "admin") {
        window.location.href = "admin_page.html";
    }
    else {
        alert("Ups.. Since you are not enrolled to any course, you cannot enter the system.");
    }
}

function assignSections() {
    if(user["userRole"] === "student") {
        let httpRequest = new XMLHttpRequest();
        httpRequest.overrideMimeType("application/json");
        httpRequest.open("GET", 'http://localhost:8080/SectionController/getSectionOfStudent?studentID='+parseInt(localStorage.getItem("id")));
        httpRequest.onload = function () {
            let section = httpRequest.responseText;
            localStorage.setItem("section", section);
        }
        httpRequest.send();
    } else if(user["userRole"] === "instructor") {
        // The sections that instructor is teaching will be retrieved.
        let httpRequest = new XMLHttpRequest();
        httpRequest.overrideMimeType("application/json");
        let instructorID = parseInt(localStorage.getItem("id"));
        httpRequest.open("GET", 'http://localhost:8080/SectionController/getAllSectionsOfInstructor?instructorID='+instructorID);
        httpRequest.onload = function () {
            // Array JSON problem
            let sections = httpRequest.responseText;
            alert(sections);
            let list = [];
            for(let i=0; i<sections.length; i=i+2) {
                list.push(parseInt(sections.substring(i, i+1)));
            }
            localStorage.setItem("sections", list.toString());
            if(list.length !== 0 ) {
                // If there are at least 1 course that he/she is teaching then the 'sections' component will be assigned to instructor.
                localStorage.setItem("currentSection", list[0].toString());
            }
        }
        httpRequest.send();
    }
}