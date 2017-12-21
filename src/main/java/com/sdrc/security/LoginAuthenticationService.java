/**
 * Copyright © NIC. All rights reserved.

 *
 * This software is the confidential and proprietary information 
 * of NIC.You shall not disclose such Confidential Information and 
 * shall use it only in accordance with the terms and conditions 
 * entered into with NIC.
 *
 * Id: LoginAuthenticationService.java,v 1.1
 *
 * Date Author Changes
 * Jul 29, 2017, 11:25:30 PM  prakash Created
 */
package com.sdrc.security;
 
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sdrc.domain.LoginUserDomain;
import com.sdrc.repository.LoginRepository;
 
@Service("loginAuthenticationService")
public class LoginAuthenticationService implements UserDetailsService 
{
	@Autowired
	LoginRepository loginRepo;
	
	@Override
    @Transactional(readOnly = false, propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED)
 	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException 
    {
    	if(userId == null || userId.isEmpty())
    	{
    		throw new UsernameNotFoundException("User Id is empty.");
    	}
    	LoginUserDomain user=loginRepo.findByUserId(userId);
    	if(user == null )
    	{
    		throw new UsernameNotFoundException("User not found.");
    	}
    	
        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_"+user.getRoleId().toUpperCase());
        grantList.add(authority);
 
        System.out.println("user= "+user);
        Boolean acNonExpired = user.getIsActive();
        Boolean credentialsNonExpired = user.getIsActive();
        Boolean enabled = user.getIsActive();
        Boolean acNonLocked = !(user.getIsLocked());
        String  dbPassword=user.getPassword();
        
 
        return (UserDetails) new User(userId, dbPassword, enabled,acNonExpired, credentialsNonExpired, acNonLocked, grantList);
   	}
 
}