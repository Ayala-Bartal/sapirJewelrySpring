package spring.entities;

import java.io.Serializable;

/**
 * @author ayala
 *
 */
@SuppressWarnings("serial")
public class UserDbE implements Serializable{

	protected String firstName;
	protected String lastName;
	protected String email;
	protected String phoneNumber;
	protected String birthday;
	protected String weddingDate;
	protected String gender;
    protected String city;
	
	public UserDbE(){}
	
	public UserDbE(String firstName, String lastName, String email, String phoneNumber, String birthday,
			String weddingDate, String gender, String city) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
		this.weddingDate = weddingDate;
		this.gender= gender;
		this.city=city;
	}
	
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
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
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getWeddingDate() {
		return weddingDate;
	}
	public void setWeddingDate(String weddingDay) {
		this.weddingDate = weddingDay;
	}
	
	@Override
	public String toString() {
		return 	"UserDbE "
					+ "[firstName=" + firstName + ", lastName=" + lastName +
					", email=" + email + ", phoneNumber=" + phoneNumber + 
					", birthday=" + birthday + ", weddingDate=" + weddingDate + 
				"]";
	}
}
