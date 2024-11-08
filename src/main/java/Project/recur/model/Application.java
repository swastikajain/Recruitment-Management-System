package Project.recur.model;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "APPLICATION")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "APPLICATION_ID")
    private int applicationId;

    @ManyToOne
    @JoinColumn(name = "JOB_SEEKER_ID")
    private JobSeeker jobSeeker;

    @ManyToOne
    @JoinColumn(name = "JOB_ID")
    private Job job;

    @Column(name = "APPLICATION_STATUS", length = 20)
    private String applicationStatus;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_APPLIED")
    private Date dateApplied;

    @ManyToOne
    @JoinColumn(name = "RESUME_ID")
    private Resume resume;

    @Column(name = "COVER_LETTER", length = 10000)
    private String coverLetter;

	public int getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}

	public JobSeeker getJobSeeker() {
		return jobSeeker;
	}

	public void setJobSeeker(JobSeeker jobSeeker) {
		this.jobSeeker = jobSeeker;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public String getApplicationStatus() {
		return applicationStatus;
	}

	public void setApplicationStatus(String applicationStatus) {
		this.applicationStatus = applicationStatus;
	}

	public Date getDateApplied() {
		return dateApplied;
	}

	public void setDateApplied(Date dateApplied) {
		this.dateApplied = dateApplied;
	}

	public Resume getResume() {
		return resume;
	}

	public void setResume(Resume resume) {
		this.resume = resume;
	}

	public String getCoverLetter() {
		return coverLetter;
	}

	public void setCoverLetter(String coverLetter) {
		this.coverLetter = coverLetter;
	}

}
