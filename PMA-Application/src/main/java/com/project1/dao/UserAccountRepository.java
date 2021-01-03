package com.project1.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.project1.entities.UserAccount;

public interface UserAccountRepository extends PagingAndSortingRepository<UserAccount, Long>{
		
	
	
}
