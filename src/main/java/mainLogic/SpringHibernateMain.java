package mainLogic;

import dal.PostDao;
import dal.UserDao;
import dao.Post;
import dao.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class SpringHibernateMain {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring4.xml");
		
		UserDao userDao = context.getBean(UserDao.class);
		PostDao postDao = context.getBean(PostDao.class);

		User newUser = new User();
		newUser.setFirstName("Jim");
		newUser.setLastName("Moriarty");

        Post newPost = new Post();
        newPost.setUser(newUser);
        newPost.setTitle("Jim's speech.");
        newPost.setPublication("Honey you should see me in a crown.");

        userDao.save(newUser);
		postDao.save(newPost);
		
		System.out.println("User::" + newUser.toString());
		
		List<User> userList = userDao.findAll();
		
		for(User user : userList){
			System.out.println("User List::" + user);
		}

		context.close();
		
	}

}
