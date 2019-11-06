exports.handler = async (event) => {
    // TODO implement
    var head = "{\"statusCode\": 200, \"data\": [";
    
    var data = "";
    for(var i = 0; i < 20; i++){
        var session_id = "session "+ i;
        var duration = Math.floor(Math.random() * 10) + " min";
        var num_users = Math.floor(Math.random() * 10);
        
        var one_session = "{\"session_id\": \"" + session_id + "\",\"created_at\": \"09-18-2019\",\"destroyed_at\": \"09-18-2019\",\"duration\": \"" + duration + "\",\"num_users\": \"" +num_users+ "\"},"

        data += one_session
    }
    
    var end = "]}";
    var output = head + data.substring(0, data.length - 1) + end;
    const response = {
        statusCode: 200,
        
        body: output,
    };
    return response;
};
