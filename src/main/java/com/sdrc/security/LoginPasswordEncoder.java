/**
 * Copyright © NIC. All rights reserved.

 *
 * This software is the confidential and proprietary information 
 * of NIC.You shall not disclose such Confidential Information and 
 * shall use it only in accordance with the terms and conditions 
 * entered into with NIC.
 *
 * Id: LoginPasswordEncoder.java,v 1.1
 *
 * Date Author Changes
 * Jul 29, 2017, 11:26:23 PM  prakash Created
 */
package com.sdrc.security;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;



@Component("passwordEncoder")
public class LoginPasswordEncoder implements  PasswordEncoder {

	public String encode(CharSequence rawPassword) 
	{
        return null;
	}

	//@Override
	public boolean matches(CharSequence userPassword, String dbPassword) 
	{
		if(userPassword == null )
		{
			return false;
		}
		else if(dbPassword == null)
		{
			return false;
		}
		else
		{
			return dbPassword.equals(userPassword);
		}
	}
}
