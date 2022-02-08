function myFunction() {
    document.getElementById("name").innerHTML =" Name : "+ localStorage.getItem("name");
    document.getElementById("surname").innerHTML =" Surname : "+ "Tüzün";//localStorage.getItem("name");
    document.getElementById("Email").innerHTML =" Email : "+ "eraytuzun@cs.bilkent.edu.tr";//localStorage.getItem("Email");
    document.getElementById("Course").innerHTML =" Course : "+ "CS319";//localStorage.getItem("Course");
    document.getElementById("Semester").innerHTML =" Semester : "+ "2020-2021 Spring";//localStorage.getItem("Semester");
    //yukarıdaki kodları düzeltmeyi unutma

}
//for show how to use

/*
var student1={ name: "student1"};
var student2={ name: "student2"};
var student3={ name: "student3"};
var student4={ name: "student4"};

var currentSection =student1 ;
let groupmembers = new Array();
groupmembers.push(student1);
groupmembers.push(student2);
groupmembers.push(student3);
groupmembers.push(student4);
*/
//write your code here
/*
let reviews1 = new Array();
reviews1.push("Peer Review of Student 1");
let reviews2 = new Array();
reviews2.push("Peer Review of Student 2");
let reviews3 = new Array();
reviews3.push("Peer Review of Student 3");
let reviews4 = new Array();
reviews4.push("Peer Review of Student 4");

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

*/

