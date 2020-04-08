package com.cognizant.Service;

public class Validation {

	public boolean userValidate(String password)
	{
		String pattern="^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$";
		if(password.matches(pattern))
		{
			return true;
		}
		return false;
		
	}
	
}
