package student;

import java.util.Arrays;

public class Student {
	private String firstName;
	private String lastName;
	// Date of birth
	private String dob;
	private String email;
	private String phone;
	private String gender;
	private String address;
	private String city;
	private String pincode;
	private String state;
	private String country;
	private String[] hobbies;
	private Qualification qualification1;
	private Qualification qualification2;
	private Qualification qualification3;
	private Qualification qualification4;
	private String course;
	
	public Student() {
		super();
	}

	public Student(String firstName, String lastName, String dob, String email, String phone, String gender,
			String address, String city, String pincode, String state, String country, String[] hobbies,
			Qualification qualification1, Qualification qualification2, Qualification qualification3,
			Qualification qualification4, String course) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.address = address;
		this.city = city;
		this.pincode = pincode;
		this.state = state;
		this.country = country;
		this.hobbies = hobbies;
		this.qualification1 = qualification1;
		this.qualification2 = qualification2;
		this.qualification3 = qualification3;
		this.qualification4 = qualification4;
		this.course = course;
	}
	
	

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String[] getHobbies() {
		return hobbies;
	}

	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}

	public Qualification getQualification1() {
		return qualification1;
	}

	public void setQualification1(Qualification qualification1) {
		this.qualification1 = qualification1;
	}

	public Qualification getQualification2() {
		return qualification2;
	}

	public void setQualification2(Qualification qualification2) {
		this.qualification2 = qualification2;
	}

	public Qualification getQualification3() {
		return qualification3;
	}

	public void setQualification3(Qualification qualification3) {
		this.qualification3 = qualification3;
	}

	public Qualification getQualification4() {
		return qualification4;
	}

	public void setQualification4(Qualification qualification4) {
		this.qualification4 = qualification4;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
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

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob + ", email=" + email
				+ ", phone=" + phone + ", gender=" + gender + ", address=" + address + ", city=" + city + ", pincode="
				+ pincode + ", state=" + state + ", country=" + country + ", hobbies=" + Arrays.toString(hobbies)
				+ ", qualification1=" + qualification1 + ", qualification2=" + qualification2 + ", qualification3="
				+ qualification3 + ", qualification4=" + qualification4 + ", course=" + course + "]";
	}
	
}
