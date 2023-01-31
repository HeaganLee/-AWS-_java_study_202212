package test_practice;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
public class Company{
	
	private int companyId;
	private String companyName;
	private String address;
	private String city;
	private String state;
	private String zipCode;
	
	public static void main(String[] args) {
		Company company = new Company(100, "Apple", "Apple Computer Inc. 1 infinite Loop", "Cupertino", "CA", "95014");
		
		Gson gson = new Gson();
		gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
		
		Map<String, Object> com = new HashMap<>();
		com.put("companyId", company.companyId);
		com.put("companyName", company.companyName);
		com.put("address", company.address);
		com.put("city", company.city);
		com.put("state", company.state);
		com.put("zipCode", company.zipCode);
		
		String comJson = gson.toJson(com);
		System.out.println(comJson);
		
	}
	
	
}