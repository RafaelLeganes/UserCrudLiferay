package com.sinensia.utilities;

import com.sinensia.model.User;

import java.util.ArrayList;

public class UsersSingleton {
	
	private static UsersSingleton mInstance;
	private ArrayList<User> list = null;
	
	public static UsersSingleton getInstance() {
		if (mInstance == null)
			mInstance = new UsersSingleton();
		
		return mInstance;
	}
	
	private UsersSingleton() {
		list = new ArrayList<User>();
	}
	
	public ArrayList<User> getArray(){
		return this.list;
	}
	
	public void addToArray(User user) {
		list.add(user);
	}
}
