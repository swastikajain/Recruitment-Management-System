package Project.recur.model;


import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "NOTIFICATION")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "NOTIFICATION_ID")
    private int notificationId;

    @ManyToOne
    @JoinColumn(name = "JOB_SEEKER_ID")
    private JobSeeker jobSeeker;

    @Column(name = "MESSAGE", length = 1000)
    private String message;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_SENT")
    private Date dateSent;

    @Column(name = "IS_READ")
    private boolean isRead;

	public int getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(int notificationId) {
		this.notificationId = notificationId;
	}

	public JobSeeker getJobSeeker() {
		return jobSeeker;
	}

	public void setJobSeeker(JobSeeker jobSeeker) {
		this.jobSeeker = jobSeeker;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getDateSent() {
		return dateSent;
	}

	public void setDateSent(Date dateSent) {
		this.dateSent = dateSent;
	}

	public boolean isRead() {
		return isRead;
	}

	public void setRead(boolean isRead) {
		this.isRead = isRead;
	}
}

