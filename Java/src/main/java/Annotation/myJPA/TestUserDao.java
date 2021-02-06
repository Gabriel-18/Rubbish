package Annotation.myJPA;

public class TestUserDao {
	public static void main(String[] args) {
		UserDao userDao = new UserDao();
		User user = new User("hst", 18);
		userDao.add(user);
	}
}























