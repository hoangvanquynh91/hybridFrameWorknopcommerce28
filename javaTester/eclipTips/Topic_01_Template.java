package eclipTips;

import org.openqa.selenium.support.ui.WebDriverWait;

public class Topic_01_Template {
	
	public static void main(String[] args){
		tong();
		tong(90,100);
		WebDriverWait explicitWait = new WebDriverWait(null, null, null, 0, 0);
		
	}
	public static void tong() {
		int a = 10;
		int b = 20;
		System.out.println(a+b);
	}
	public static void tong(int a, int b) {
		System.out.println(a+b);
	}
	
}
