
function getLogs(){
    logsAPIClient.getLogs();
}

function postLogs(){
    logsAPIClient.postLogs(document.getElementById("logInput").value);
}