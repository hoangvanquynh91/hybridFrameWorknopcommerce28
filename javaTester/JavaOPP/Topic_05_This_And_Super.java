package JavaOPP;

public class Topic_05_This_And_Super extends BaseOPP{
	
	private int phoneNumber;


	protected int getPhoneNumber() {
		return phoneNumber;
	}


	protected void setPhoneNumber(int phoneNumber) {
		if(!String.valueOf(phoneNumber).startsWith("9") || !String.valueOf(phoneNumber).startsWith("3") ||
				!String.valueOf(phoneNumber).startsWith("8")) {
			throw new IllegalArgumentException("So dien thoai bat dau bang 09,08,03");
		}else if(phoneNumber >11 || phoneNumber < 10) {
			throw new IllegalArgumentException("do dai khong hop le");
		}else {
			this.phoneNumber = phoneNumber;
		}
		}
		
		


	public static void main(String[] args) {
		Topic_05_This_And_Super tp5 = new Topic_05_This_And_Super();
		tp5.setPhoneNumber(923);
		System.out.println(tp5.getPhoneNumber());
	}

}
