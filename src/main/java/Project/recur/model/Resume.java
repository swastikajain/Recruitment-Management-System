package Project.recur.model;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "RESUME")
public class Resume {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "RESUME_ID")
    private int resumeId;

    @Column(name = "FILE_PATH", length = 255)
    private String file;  // File path or link

    public int getResumeId() {
		return resumeId;
	}

	public void setResumeId(int resumeId) {
		this.resumeId = resumeId;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Date getDateUploaded() {
		return dateUploaded;
	}

	public void setDateUploaded(Date dateUploaded) {
		this.dateUploaded = dateUploaded;
	}

	public JobSeeker getJobSeeker() {
		return jobSeeker;
	}

	public void setJobSeeker(JobSeeker jobSeeker) {
		this.jobSeeker = jobSeeker;
	}

	@Column(name = "FILE_NAME", length = 100)
    private String fileName;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_UPLOADED")
    private Date dateUploaded;

    @ManyToOne
    @JoinColumn(name = "JOB_SEEKER_ID")
    private JobSeeker jobSeeker;

    // Getters and Setters
}




   
