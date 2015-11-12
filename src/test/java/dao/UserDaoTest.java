package dao;

import static org.junit.Assert.assertNotNull;

import javax.persistence.Transient;

import org.junit.Ignore;
import org.junit.Test;

import entity.User;

public class UserDaoTest {
	
	private UserDao userDao = new UserDao();

	@Test@Transient
	public void testSelect() {
		assertNotNull(userDao.select(1));
	}

	@Test@Ignore
	public void testInsert() {
		User user = new User();
		user.setUsername("hibernate");
		user.setPassword("hibernate");
		assertNotNull(userDao.insert(user));
	}

	@Test@Ignore
	public void testDelete() {
		User user = new User();
		user.setUserid(5);
		userDao.delete(user);
	}

	@Test@Ignore
	public void testUpdate() {
		User user = userDao.select(1);
		user.setUsername("hibername");
		userDao.update(user);
	}

}
