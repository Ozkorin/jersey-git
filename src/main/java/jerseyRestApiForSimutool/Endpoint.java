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
		return "Get Request Reply Comes Here1"; 
		// return Response.status(201).type(MediaType.TEXT_PLAIN).build();
	}

	@POST
	@Path("activity")
	@Produces(MediaType.TEXT_PLAIN)
	public String responseToPostRequest(final String incomingActivityJson) {

		// GSON is used to convert JSON to POJO
		Gson jsonToPojo = new Gson();
		//Error Checking
		if (jsonToPojo == null)
			return "Gson Object jsonToPojo is null";
		
		// The following code does the conversion.
		Activity activityPojoFromJson = jsonToPojo.fromJson(incomingActivityJson, Activity.class);
		//Error Checking
		if (activityPojoFromJson == null)
			return "Activity Object activityPojoFromJson is null";
		
		ST st = new ST(activityPojoFromJson.getUploader(), activityPojoFromJson.getPurpose(), 
				activityPojoFromJson.getDescription(), activityPojoFromJson.getAttachment(), 
				activityPojoFromJson.getVisibility(), activityPojoFromJson.getUpload_date(),
				activityPojoFromJson.getTags());
		
		return st.getLinearTag();

		//return activityPojoFromJson.getPurpose();
	}

}
