   package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.entity.UserEntity;

@Component
public class UserDao {
	 @Autowired
	    private HibernateTemplate hibernateTemplate;
	 @Transactional
	    public void insert(UserEntity user) {
	        this.hibernateTemplate.save(user);

	    }
	   public UserEntity getUser(String userName) {
	        return this.hibernateTemplate.get(UserEntity.class, userName);
	    }
}
