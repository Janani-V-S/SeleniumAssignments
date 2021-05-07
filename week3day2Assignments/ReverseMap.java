package week3.week3day2Assignments;


import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class ReverseMap {

	public static void main(String[] args) {
		Map<Integer,String> data = new TreeMap<Integer,String>(Collections.reverseOrder());
		data.put(100, "Hari");
		data.put(101,"Naveen");
		data.put(102, "Sam");
		data.put(104, "Balaji");
		
		System.out.println(data.size());
		
		System.out.println(data);
	}

}
