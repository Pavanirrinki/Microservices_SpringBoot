package Job_application.JobsService.JobsDto;

import java.util.List;

import Job_application.JobsService.Entity.Jobs_Table;

public class JobWithUserDetailsResponse {
    private Jobs_Table job;
    private List<Object> userDetails;

    public JobWithUserDetailsResponse(Jobs_Table job, List<Object> userDetails) {
        this.job = job;
        this.userDetails = userDetails;
    }

    public Jobs_Table getJob() {
        return job;
    }

    public void setJob(Jobs_Table job) {
        this.job = job;
    }

    public List<Object> getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(List<Object> userDetails) {
        this.userDetails = userDetails;
    }
}
