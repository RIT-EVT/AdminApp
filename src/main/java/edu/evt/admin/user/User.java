package edu.evt.admin.user;

import com.mongodb.MongoClient;

public class User {
	private String firstName;
	private String lastName;
	private String UID;
	private String username;

	private final long id;

	public User(long id, String firstName, String lastName, String UID, String username){
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.UID = UID;
		this.username = username;
	}

	public static User get(String UUID){
		return null;
	}
}