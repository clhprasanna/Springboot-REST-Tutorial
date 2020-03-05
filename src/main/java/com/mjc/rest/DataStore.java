package com.mjc.rest;

import java.util.HashMap;

import com.mjc.rest.domain.User;

public class DataStore {
	
	private static HashMap<String,User> userData = new HashMap<String, User>();

	public static HashMap<String, User> getUserData() {
		return userData;
	}

}
