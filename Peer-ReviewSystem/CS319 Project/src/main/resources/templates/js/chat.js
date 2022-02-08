function goDash(){

    if(localStorage.getItem("type")== "student"){
        window.location.href = "DashboardStudent.html";
    }
    else if(localStorage.getItem("type")== "instructor"){
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




let reviews1 = new Array();
reviews1.push("Student 1\n\n Section 1\n\n GroupA");
let reviews2 = new Array();
reviews2.push("Student 2\n\n Section 1\n\n GroupA");
let reviews3 = new Array();
reviews3.push("Student 3\n\n Section 1\n\n GroupB");
let reviews4 = new Array();
reviews4.push("Student 4\n\n Section 1\n\n GroupB");

let student1PeerReview={ name: "Student 1 Peer Review:"};
let student2PeerReview={ name: "Student 2 Peer Review"};
let student3PeerReview={ name: "Student 3 Peer Review"};
let student4PeerReview={ name: "Student 4 Peer Review"};

let student1 = { review: reviews1 , name: "Student1" };
let student2 = { review: reviews2 , name: "Student2" };
let student3 = { review: reviews3 , name: "Student3" };
let student4 = { review: reviews4 , name: "Student4" };

var currentStudent =student1 ;
let students = new Array();
students.push(student1);
students.push(student2);
students.push(student3);
students.push(student4);

students.forEach(function (element){
    var li = document.createElement("LI");
    li.value = element;
    var buttonE = document.createElement('button');
    buttonE.innerText = element.name;
    li.append(buttonE);
    buttonE.onclick = function() {
        currentStudent={ review: element.review, name: element.name};
        if(document.getElementById("reviews").innerHTML!==""){
            document.getElementById("reviews").innerHTML=""; //group list

        }


        renew();
    };
    document.getElementById("students").appendChild(li);  //sectionlist
});



function renew () {
    currentStudent.review.forEach(function(element){
        var li = document.createElement("LI");
        li.value = element;
        var label = document.createElement('label');
        label.innerText = element;
        li.append(label);
        label.onclick = function() { };
        document.getElementById("reviews").appendChild(li);
    });

}

