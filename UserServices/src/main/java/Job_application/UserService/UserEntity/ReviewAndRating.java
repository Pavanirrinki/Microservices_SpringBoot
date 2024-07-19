package Job_application.UserService.UserEntity;

import org.hibernate.annotations.UuidGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ReviewAndRating {
	
	@Id
	@GeneratedValue
	@UuidGenerator
	@Column(name = "Id", updatable = false, nullable = false)
	private String id;
	private byte Rating;
	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private String Review;
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User_data userId;

	
	
	public User_data getUserId() {
		return userId;
	}
	public void setUserId(User_data userId) {
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
