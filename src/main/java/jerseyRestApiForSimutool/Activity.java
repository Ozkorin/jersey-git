package jerseyRestApiForSimutool;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;

public class Activity {
	
	@Expose
	private String uploader;
	
	
	@Expose
	private String purpose;
	
	
	@Expose
	private String description;
	
	
	@Expose
	private String attachment;
	

	@Expose
	private String visibility;
	

	@Expose
	private String upload_date;
	

	@Expose
	private List<String> tags = new ArrayList<String>();

	/**
	 * 
	 * @return The uploader
	 */
	public String getUploader() {
		return uploader;
	}

	/**
	 * 
	 * @param uploader
	 *            The uploader
	 */
	public void setUploader(String uploader) {
		this.uploader = uploader;
	}

	/**
	 * 
	 * @return The purpose
	 */
	public String getPurpose() {
		return purpose;
	}

	/**
	 * 
	 * @param purpose
	 *            The purpose
	 */
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	/**
	 * 
	 * @return The description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 
	 * @param description
	 *            The description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 
	 * @return The attachwment
	 */
	public String getAttachment() {
		return attachment;
	}

	/**
	 * 
	 * @param attachment
	 *            The attachment
	 */
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	/**
	 * 
	 * @return The visibility
	 */
	public String getVisibility() {
		return visibility;
	}

	/**
	 * 
	 * @param visibility
	 *            The visibility
	 */
	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}

	/**
	 * 
	 * @return The upload_date
	 */
	public String getUpload_date() {
		return upload_date;
	}

	/**
	 * 
	 * @param upload_date
	 *            The upload_date
	 */
	public void setUpload_date(String upload_date) {
		this.upload_date = upload_date;
	}

	/**
	 * 
	 * @return The tags
	 */
	public List<String> getTags() {
		return tags;
	}

	/**
	 * 
	 * @param tags
	 *            The tags
	 */
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	
	@Override
	public String toString() {
		return "To Be Modified";
	}

}
