package com.kaishengit.test;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.kaishengit.entity.User;

public class GsonTest {

	public static void main(String[] args) {
	
		User user = new User(1001,"jack", 23, "China");
		
		Gson gson = new Gson();
//		String json = gson.toJson(user);
//		System.out.println(json);
		
//		List<String> lists = Lists.newArrayList("aa","bb","cc");
//		String listJson = gson.toJson(lists);
//		System.out.println(listJson);
		
//		List<User> users = Lists.newArrayList(new User(1001,"jack", 23, "China"),new User(1001,"jack", 23, "China"),new User(1001,"jack", 23, "China"));
//		
//		String objJson = gson.toJson(users);
//		System.out.println(objJson);
		
//		Map<String,String> maps = new HashMap<>();
//		maps.put("k1", "v1");
//		maps.put("k2", "v2");
//		maps.put("k3", "v3");
//		String mapJson = gson.toJson(maps);
//		System.out.println(mapJson);
		
		
	}
	
	
}
