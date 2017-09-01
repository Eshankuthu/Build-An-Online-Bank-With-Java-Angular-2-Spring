package com.userfront.service.UserServiceImpl;

import java.util.Set;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.userfront.Dao.RoleDao;
import com.userfront.Dao.UserDao;
import com.userfront.domain.User;
import com.userfront.domain.security.UserRole;
import com.userfront.service.UserService;

@Transactional
@Service
public class UserServiceImpl implements UserService{
	
	public static final Logger LOG= LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private RoleDao  roleDao;

	@Autowired
	private UserDao userDao;
	
	public void save(User user){
		userDao.save(user);
	}
	
	public User findByEmail(String email){
		return userDao.findByEmail(email);
		
	}
	
	public User createUser(User user,Set<UserRole> userRoles){
		User localUser = userDao.findByUsername(user.getUsername());
		if(localUser!=null){
			LOG.info("User with username {} already Exists.Nothing will be done", user.getUsername());
		} else{
			String encryptedPassword = passwordEncoder.encode(user.getPassword());
			user.setPassword(encryptedPassword);
			
			for(UserRole ur : userRoles){
				roleDao.save(ur.getRole());
			}
			
			user.getUserRoles().addAll(userRoles);
			user.setPrimaryAccount(accountSerivce.createPrimaryAccount());
			user.setSavingsAccount(accountService.createSavingAccount());
			
			localUser = userDao.save(user);
		}
		return localUser;
		
	}
	
	public User findByUsername(String username){
		return userDao.findByUsername(username);
	}
	
	public boolean checkUserExists(String username, String email){
		if(checkUsernameExists(username)|| checkEmailExists(email)){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean checkUsernameExists(String username){
		if(null!=findByUsername(username)){
			return true;
		}
		return false;
	}
	
	public boolean checkEmailExists(String email){
		if(null!=findByEmail(email)){
			return true;		
		}else{
			return false;
		}
	}



}
