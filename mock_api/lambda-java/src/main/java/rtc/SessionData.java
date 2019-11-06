package rtc;

import com.amazonaws.services.lambda.runtime.Context; 
import com.amazonaws.services.lambda.runtime.LambdaLogger;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;


import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Random;
import java.util.UUID;

public class SessionData {
	
	int MIN_NUMBEROFPARTICIPANT = 2;
	int MAX_NUMBEROFPARTICIPANT = 5;
	public void getConference(InputStream inputStream, OutputStream outputStream, Context context) throws IOException {
		LambdaLogger logger = context.getLogger();
        logger.log("received : output the Mock Conference list");
        

        JSONArray responseData = new JSONArray();
        
        
        for (int i = 1; i <= 20; i++ ) {
        	
        	// generate a conference object and put it into conferenceInfo
        	JSONObject conference = new JSONObject();
        	JSONArray participants = new JSONArray();
        	String conferenceId = UUID.randomUUID().toString();
        	String name = "Conference " + i;
        	String callbackUrl = "https:myAppServer/MyConferenceEventListener";
        	conference.put("id", conferenceId);
        	conference.put("name", name);
        	conference.put("callbackUrl", callbackUrl);
        	
        	int numOfParticipant = MIN_NUMBEROFPARTICIPANT + (int)(Math.random() * ((MAX_NUMBEROFPARTICIPANT - MIN_NUMBEROFPARTICIPANT) + 1));
        	for(int j = 0; j < numOfParticipant; j++) {
        		
        		//generate participants capabilities
        		JSONObject capabilities = new JSONObject();
        		String recordingEnabled = "false";
        		String videoEnabled = "false";
        		String chatEnabled = "false";
        		capabilities.put("recordingEnabled", recordingEnabled);
        		capabilities.put("videoEnabled", videoEnabled);
        		capabilities.put("chatEnabled", chatEnabled);
        		
        		//generate participants info
        		JSONObject participant = new JSONObject();
        		String participantId = UUID.randomUUID().toString();
            	String displayName = getRandomName();
            	String connectionId = "null";
            	String streams = "null";
            	String userAgent = "null";
            	participant.put("id", participantId);
            	participant.put("displayName", displayName);
            	participant.put("connectionId", connectionId);
            	participant.put("streams", streams);
            	participant.put("userAgent", userAgent);
            	participant.put("capabilities", capabilities);
            	participants.put(participant);
        	}
        	
        	
        	conference.put("participants", participants);
        	responseData.put(conference);

        }
        
        OutputStreamWriter writer = new OutputStreamWriter(outputStream, "UTF-8");
        writer.write(responseData.toString());
        writer.close();
	}
	
	public String getRandomName() {
		Random r = new Random();
		
		int length = 4 + r.nextInt(4);
		String name = "";
		for(int i = 0 ; i < length; i++) {
			char c = (char) (r.nextInt(26) + 'a');
			name += c;
		}
		
		return name;
		   
	}
    
    public void getSessions(InputStream inputStream, OutputStream outputStream, Context context) throws IOException {
    	
    	LambdaLogger logger = context.getLogger();
        logger.log("received : output the sessions list");
        

        JSONArray responseData = new JSONArray();
    	JSONObject responseBody = new JSONObject();
        
        
        for (int i = 1; i <= 20; i++ ) {
        	String session_id = "session "+ i;
            String duration = (int)Math.floor(Math.random() * 10) + " min";
            String num_users = (int)Math.floor(Math.random() * 10) + "";
            JSONObject oneSession = new JSONObject();
            oneSession.put("session_id", session_id);
            oneSession.put("created_at", "09-18-2019");
            oneSession.put("destroyed_at", "09-18-2019");
            oneSession.put("duration", duration);
            oneSession.put("num_users", num_users);
            
            responseData.put(oneSession);
        }
        
        responseBody.put("data", responseData);
        JSONObject responseJson = new JSONObject();
    	responseJson.put("statusCode", 200);    	
        responseJson.put("body", responseBody);
        
        OutputStreamWriter writer = new OutputStreamWriter(outputStream, "UTF-8");
        writer.write(responseJson.toString());
        writer.close();
    }
}