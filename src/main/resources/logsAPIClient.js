logsAPIClient = (function(){
    return{
        getLogs:function(){
            const xhttp = new XMLHttpRequest();
            xhttp.onload = function() {
                document.getElementById("log-container").innerHTML = this.responseText;
            }
            xhttp.open("GET", "/logs");
            xhttp.send();
        },
    
        
        postLogs:function(newlog){
            let url = "/logs";

            fetch(url, {
                method: "POST",
                body: newlog,
                headers: {
                    "Content-type": "text/html; charset=utf-8"
                }
            });
        }
    }
})();


// let nameVar = document.getElementById("name").value;
//                 const xhttp = new XMLHttpRequest();
//                 xhttp.onload = function() {
//                     document.getElementById("getrespmsg").innerHTML =
//                     this.responseText;
//                 }
//                 xhttp.open("GET", "/hello?name="+nameVar);
//                 xhttp.send();