package Project.recur.model;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "JOB_TABLE")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "JOB_ID")
    private int idJob;

    @Column(name = "TITLE", length = 100)
    private String title;

    @Column(name = "DESCRIPTION", length = 100000)
    private String description;

    @Column(name = "LOCATION", length = 100)
    private String location;

    @Column(name = "QUALIFICATIONS", length = 500)
    private String qualifications;

    @Column(name = "EXPERIENCE_REQUIRED", length = 100)
    private String experienceRequired;

    @Column(name = "COMPANY_NAME", length = 100)
    private String companyName;

    @Column(name = "JOB_TYPE", length = 20)
    private String jobType;

    @Column(name = "SALARY_RANGE", length = 50)
    private String salaryRange;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_POSTED")
    private Date datePosted;

    @Temporal(TemporalType.DATE)
    @Column(name = "APPLICATION_DEADLINE")
    private Date applicationDeadline;

	public int getIdJob() {
		return idJob;
	}

	public void setIdJob(int idJob) {
		this.idJob = idJob;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getQualifications() {
		return qualifications;
	}

	public void setQualifications(String qualifications) {
		this.qualifications = qualifications;
	}

	public String getExperienceRequired() {
		return experienceRequired;
	}

	public void setExperienceRequired(String experienceRequired) {
		this.experienceRequired = experienceRequired;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public String getSalaryRange() {
		return salaryRange;
	}

	public void setSalaryRange(String salaryRange) {
		this.salaryRange = salaryRange;
	}

	public Date getDatePosted() {
		return datePosted;
	}

	public void setDatePosted(Date datePosted) {
		this.datePosted = datePosted;
	}

	public Date getApplicationDeadline() {
		return applicationDeadline;
	}

	public void setApplicationDeadline(Date applicationDeadline) {
		this.applicationDeadline = applicationDeadline;
	}

	@Override
    public String toString() {
        return "Job [idJob=" + idJob + 
               ", title=" + title + 
               ", description=" + description + 
               ", location=" + location + 
               ", qualifications=" + qualifications + 
               ", experienceRequired=" + experienceRequired + 
               ", companyName=" + companyName + 
               ", jobType=" + jobType + 
               ", salaryRange=" + salaryRange + "]";
    }
}
