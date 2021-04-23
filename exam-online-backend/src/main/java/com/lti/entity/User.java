package com.lti.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//***************************** User Entity ******************************
@Entity
@Table(name = "tbl_user_boot")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_seq")
	@SequenceGenerator(sequenceName = "user_seq", allocationSize = 1, name = "my_seq")
	@Column(name = "user_id")
    private int id;
	
	@Column(name = "first_name")
    private String firstName;
	
	@Column(name = "middle_name")
    private String middleName;
	
	@Column(name = "last_name")
    private String lastName;
	
	@Column(name = "email")
    private String email;
	
	@Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
	
	@Column(name = "gender")
    private String gender;
	
	@Column(name = "phone_no")
    private String phoneNo;
	
	@Column(name = "password")
    private String password;
	
	@Column(name = "qualification")
    private String qualification;
	
	@Column(name = "rights")
    private String rights;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "state")
	private String state;
    
    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<UserAnswer> userAnswers;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Result> results;

    public List<UserAnswer> getUserAnswers() {
    	return userAnswers;
    }
    public void setUserAnswers(List<UserAnswer> userAnswers) {
    	this.userAnswers = userAnswers;
	}

	public List<Result> getResults() {
		return results;
	}
	public void setResults(List<Result> results) {
		this.results = results;
	}*/
	
	public String getRights() {
		return rights;
	}
	public void setRights(String rights) {
		this.rights = rights;
	}
	
	public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getMiddleName() {
        return middleName;
    }
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getPhoneNo() {
        return phoneNo;
    }
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getQualification() {
        return qualification;
    }
    public void setQualification(String qualification) {
        this.qualification = qualification;
    }
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}
 