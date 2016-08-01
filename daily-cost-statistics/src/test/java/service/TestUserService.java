package service;

import com.yeapoo.statistics.service.IUserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class TestUserService extends BaseTest{
	
	@Autowired
	private IUserService userService;
	
	@Test
	public void testGetUser(){
		System.out.println(userService.getUserEntityByUserName("asddsa"));
	}

}
