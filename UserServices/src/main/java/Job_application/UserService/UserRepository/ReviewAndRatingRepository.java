package Job_application.UserService.UserRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import Job_application.UserService.UserEntity.ReviewAndRating;

public interface ReviewAndRatingRepository extends JpaRepository<ReviewAndRating, String> {

}
