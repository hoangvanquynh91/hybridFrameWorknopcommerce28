package JavaOPP;

public class Topic_01 {
	private int studentID;
	private String studentName;
	private Float knowdgePoint;
	private Float practisePoint;
	

	private int getStudentID() {
		return studentID;
	}


	private void setStudentID(int studentID) {
		this.studentID = studentID;
	}


	private String getStudentName() {
		return studentName;
	}


	private void setStudentName(String studentName) {
		this.studentName = studentName;
	}


	private Float getKnowdgePoint() {
		return knowdgePoint;
	}


	private void setKnowdgePoint(Float knowdgePoint) {
		this.knowdgePoint = knowdgePoint;
	}


	private Float getPractisePoint() {
		return practisePoint;
	}


	private void setPractisePoint(Float practisePoint) {
		this.practisePoint = practisePoint;
	}

	private Float getAveragePoint() {
		return (this.knowdgePoint + this.practisePoint*2)/3;
	}
	private void showStudentInfo() {
		System.out.println("---------------------------------");
		System.out.println("Student ID : " + getStudentID());
		System.out.println("Student Name : " + getStudentName());
		System.out.println("Student Knowledge Point : " + getKnowdgePoint());
		System.out.println("Student practice Point : " + getPractisePoint());
		System.out.println("Student Average Point : " + getAveragePoint());
		
	}
	public static void main(String[] args) {
		Topic_01 firstStudent = new Topic_01();
		firstStudent.setStudentID(1);
		firstStudent.setStudentName("Nguyen Van A");
		firstStudent.setKnowdgePoint(8.5f);
		firstStudent.setPractisePoint(9f);
		
		firstStudent.showStudentInfo();

	}

	public void clickToElement() {
		System.out.println("Click To Element topic 01");
	}

}
