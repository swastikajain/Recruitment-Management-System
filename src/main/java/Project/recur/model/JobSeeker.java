package Project.recur.model;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;
@Entity
@Table(name = "JOB_SEEKER")
public class JobSeeker {
	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name = "JOB_SEEKER_ID")
	    private int jobSeekerId;

	    @Column(name = "NAME", length = 100)
	    private String name;

	    @Column(name = "EMAIL", length = 100, unique = true)
	    private String email;

	    @Column(name = "PASSWORD", length = 255)
	    private String password;

	    @Column(name = "PHONE", length = 20)
	    private String phone;

	    @Column(name = "ADDRESS", length = 255)
	    private String address;

	    public int getJobSeekerId() {
			return jobSeekerId;
		}

		public void setJobSeekerId(int jobSeekerId) {
			this.jobSeekerId = jobSeekerId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getEducation() {
			return education;
		}

		public void setEducation(String education) {
			this.education = education;
		}

		public String getWorkExperience() {
			return workExperience;
		}

		public void setWorkExperience(String workExperience) {
			this.workExperience = workExperience;
		}

		public String getSkills() {
			return skills;
		}

		public void setSkills(String skills) {
			this.skills = skills;
		}

		public String getProfilePicture() {
			return profilePicture;
		}

		public void setProfilePicture(String profilePicture) {
			this.profilePicture = profilePicture;
		}

		public Date getDateOfBirth() {
			return dateOfBirth;
		}

		public void setDateOfBirth(Date dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}

		public List<Resume> getResumes() {
			return resumes;
		}

		public void setResumes(List<Resume> resumes) {
			this.resumes = resumes;
		}

		@Column(name = "EDUCATION", length = 500)
	    private String education;

	    @Column(name = "WORK_EXPERIENCE", length = 1000)
	    private String workExperience;

	    @Column(name = "SKILLS", length = 1000)
	    private String skills;

	    @Column(name = "PROFILE_PICTURE", length = 255)
	    private String profilePicture;

	    @Temporal(TemporalType.DATE)
	    @Column(name = "DATE_OF_BIRTH")
	    private Date dateOfBirth;

	    @OneToMany(mappedBy = "jobSeeker", cascade = CascadeType.ALL)
	    private List<Resume> resumes;

	    // Getters and Setters
}






    
   
