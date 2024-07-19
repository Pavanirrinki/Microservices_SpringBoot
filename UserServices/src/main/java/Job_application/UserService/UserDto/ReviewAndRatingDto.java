package Job_application.UserService.UserDto;



public class ReviewAndRatingDto {
	private String id;
	private byte Rating;
	private String Review;
	private String userId;
	


	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public byte getRating() {
		return Rating;
	}
	public void setRating(byte rating) {
		Rating = rating;
	}
	public String getReview() {
		return Review;
	}
	public void setReview(String review) {
		Review = review;
	}
	

}
