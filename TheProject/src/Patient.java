
public class Patient {

	private int num;
	private String name;
	private String surName;
	private String gender;
	private String birthTime;
	private String regTime;
	private String email;
	private String phone;
	private String extraInfo;

	public Patient(int num, String name, String surName, String gender, String birthTime, String regTime, String email,
			String phone, String extraInfo) {

		this.num = num;
		this.name = name;
		this.surName = surName;
		this.gender = gender;
		this.birthTime = birthTime;
		this.regTime = regTime;
		this.email = email;
		this.phone = phone;
		this.extraInfo = extraInfo;
	}

	public boolean isSame(Patient p) {

		if (name.equals(p.getName()) && surName.equals(p.getSurName()) && email.equals(p.getEmail()) && birthTime.equals(p.getBirthTime()) && phone.equals(p.getPhone())) {
			return true;
		} else {
			return false;
		}

	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthTime() {
		return birthTime;
	}

	public void setBirthTime(String birthTime) {
		this.birthTime = birthTime;
	}

	public String getRegTime() {
		return regTime;
	}

	public void setRegTime(String regTime) {
		this.regTime = regTime;
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

	public String getExtraInfo() {
		return extraInfo;
	}

	public void setExtraInfo(String extraInfo) {
		this.extraInfo = extraInfo;
	}

}
