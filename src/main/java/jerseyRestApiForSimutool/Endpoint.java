package jerseyRestApiForSimutool;

import java.util.List;

import com.google.gson.Gson;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class Endpoint {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String responseToGetRequest() {
		return "Get Request Reply Comes Here 2";  
		// return Response.status(201).type(MediaType.TEXT_PLAIN).build();
	}

	@POST
	@Path("activity")
	@Produces(MediaType.TEXT_PLAIN)
	public Response responseToPostRequest(final String incomingActivityJson) {

		// GSON is used to convert JSON to POJO
		Gson jsonToPojo = new Gson();
		//Error Checking
		if (jsonToPojo == null)
			return Response.status(400).build();
			//String Return Below
			//return "Gson Object jsonToPojo is null";
		
		// The following code does the conversion.
		Activity activityPojoFromJson = jsonToPojo.fromJson(incomingActivityJson, Activity.class);
		//Error Checking
		if (activityPojoFromJson == null)
			return Response.status(400).build();
			//String Return Below
			//return "Activity Object activityPojoFromJson is null";
		
		ST st = new ST(activityPojoFromJson.getUploader(), activityPojoFromJson.getPurpose(), 
				activityPojoFromJson.getDescription(), activityPojoFromJson.getAttachment(), 
				activityPojoFromJson.getVisibility(), activityPojoFromJson.getUpload_date(),
				activityPojoFromJson.getTags());
		
		//Code To check if linearization of tags using string builder is working or not
		//return st.getLinearTag();

		//Code to see if activityPojoFromNull has values or not
		//return activityPojoFromJson.getPurpose();
		
		//Return ok
		return Response.status(200).build();
	}

}
