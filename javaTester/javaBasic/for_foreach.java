package javaBasic;

import org.testng.annotations.Test;

public class for_foreach {

	@Test
	public void for_demo() {
		
		//foreach sử dụng biến tạm [city] để duyệt qua các phần tử trong mảng
	  String[] array = {"Hà nội", "Hải phòng", "Lạng sơn", "Thanh  hóa"};
			  
		for (String city : array) {
			
			if(city == "Lạng sơn")
				System.out.println(city);
			
		}	  
	}
	@Test
public void for_demo_II() {
	
		for(int i=0; i>=5; i++) {
		System.out.println(i);	
		}
	
}

}
