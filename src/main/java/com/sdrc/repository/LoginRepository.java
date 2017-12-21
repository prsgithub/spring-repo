package com.sdrc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sdrc.domain.LoginUserDomain;
import com.sdrc.model.LoginUserModel;

public interface LoginRepository extends JpaRepository<LoginUserDomain, String> 
{
	LoginUserDomain findByUserId(String uid);
}
