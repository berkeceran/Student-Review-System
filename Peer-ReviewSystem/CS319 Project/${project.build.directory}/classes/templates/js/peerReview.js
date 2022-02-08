let defaultThemeColors = Survey.StylesManager.ThemeColors["modern"];
defaultThemeColors["$header-color"] = "#AFAEB4"
defaultThemeColors["$answer-background-color"] = "#AFAEB4";
defaultThemeColors["$main-hover-color"] = "#AFAEB4";
defaultThemeColors["$main-color"] = "#AFAEB4";

Survey.StylesManager.applyTheme("modern");
let json;

window.onload = function () {
    let httpRequest = new XMLHttpRequest();
    httpRequest.overrideMimeType("application/json");
    httpRequest.open("GET", 'http://localhost:8080/PeerReviewController/getPeerReviewQuestions?');
    httpRequest.onload = function () {
        let jsonReturn = httpRequest.responseText;
        json = JSON.parse(jsonReturn);
        window.survey = new Survey.Model(json);

        survey
            .onComplete
            .add(function (result) {
                document
                    .querySelector('#surveyResult')
                    .textContent = "Result JSON:\n" + JSON.stringify(result.data, null, 3);
                    alert(JSON.stringify(result.data, null, 3));
                    let httpRequest2 = new XMLHttpRequest();
                    let answer = JSON.stringify(result.data, null, 3);
                    let giverId = parseInt(localStorage.getItem("id"));
                    let receiverId = parseInt(document.getElementById("peerId").value);
                    httpRequest2.overrideMimeType("application/json");
                    httpRequest2.open("GET", 'http://localhost:8080/PeerReviewController/giveAnswerQuestions?giverId='+giverId+'&receiverId='+receiverId+'&answer='+answer);
                    httpRequest2.onload = function () {

                    }
            });

        // survey.data = {
        //     satisfaction: 2
        // };

        $("#surveyElement").Survey({model: survey});
    }
    httpRequest.send();
}


