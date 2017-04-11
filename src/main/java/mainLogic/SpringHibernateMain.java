package mainLogic;

import dal.PostDao;
import dal.UserDao;
import dao.Post;
import dao.User;
import interfaceData.TitlePageData;
import interfaceData.PostPageData;
import org.joda.time.LocalDateTime;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class SpringHibernateMain {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring4.xml");
		
		UserDao userDao = context.getBean(UserDao.class);
		PostDao postDao = context.getBean(PostDao.class);

//        putNewRecordsToDataBase(userDao, postDao);


//        Minimum functionality

//        1. Open main page
        List<TitlePageData> titlePageData = openMainPage(postDao, userDao);

        System.out.println("\n\n" + " 1. Open main page");
        for (TitlePageData t : titlePageData) {
            System.out.println(t.toString());
        }

//        2. Post list for period
        String start = "2017-01-01T00:00:00";
        String end = "2017-05-01T00:00:00";
        List<TitlePageData> titlePageDataForPeriod = findMainPageDataForPeriod(postDao, userDao, start, end);

        System.out.println("\n\n" + " 2. Post list for period");
        for (TitlePageData t : titlePageDataForPeriod) {
            System.out.println(t.toString());
        }

//        3. Show publication text
        Long postId = 35l;
        PostPageData publicationData = findSinglePublication(postDao, userDao, postId);

        System.out.println("\n\n" + "3. Show publication text");
        System.out.println(publicationData.toString());



//        4. Show user information
        String firstName = "James";
        String lastName = "Bond";
        User user = findUserInfo(userDao, firstName, lastName);

        System.out.println("\n\n" + "4. Show user information");
        System.out.println("user = " + user);


//        5. Show all user publications
        firstName = "Dima";
        lastName = "Mendeleev";
        List<TitlePageData> userPublications =
                findUserPublications(userDao, postDao, firstName, lastName);

        System.out.println("\n\n" + " 5. Show all user publications");
        for (TitlePageData t : userPublications) {
            System.out.println(t.toString());
        }



        context.close();
		
	}

    private static List<TitlePageData> findUserPublications(
            UserDao userDao,
            PostDao postDao,
            String firstName,
            String lastName
    ) {
        User user = userDao.findByFirstNameAndLastName(firstName, lastName);

        Long userId = user.getId();
        List<Post> userPostList = postDao.findByUserId(userId);

        List<TitlePageData> userPublications = mapToTitlePageData(userPostList, userDao);

        return userPublications;
    }

    private static User findUserInfo(
            UserDao userDao,
            String firstName,
            String lastName
    ) {
	    User user = userDao.findByFirstNameAndLastName(firstName, lastName);

	    return user;
    }

    private static PostPageData findSinglePublication(
            PostDao postDao,
            UserDao userDao,
            Long postId
    ) {
        Post post = postDao.findById(postId);


	    PostPageData data = new PostPageData();

	    LocalDateTime dateTime = post.getDateTime();
	    data.setDateTime(dateTime);

        Long userId = post.getUserId();
        User user = userDao.findById(userId);
        String userFullName = user.getFirstName() + " " + user.getLastName();
        data.setUser(userFullName);

        String title = post.getTitle();
        data.setTitle(title);

        String publicationText = post.getPublication();
	    data.setPublication(publicationText);


	    return data;
    }

    private static List<TitlePageData> findMainPageDataForPeriod(
            PostDao postDao,
            UserDao userDao,
            String strStartPeriod,
            String  strEndPeriod
    ) {
        LocalDateTime startPeriod = LocalDateTime.parse(strStartPeriod);
        LocalDateTime endPeriod = LocalDateTime.parse(strEndPeriod);

        List<Post> postList = postDao.findFirstFiftyForPeriod(startPeriod, endPeriod);

        List<TitlePageData> dataForPeriod = mapToTitlePageData(postList, userDao);

        return dataForPeriod;
    }

    private static List<TitlePageData> openMainPage(PostDao postDao, UserDao userDao) {
	    List<Post> postList = postDao.findFirstFifty();

        List<TitlePageData> titlePageData = mapToTitlePageData(postList, userDao);

        return titlePageData;
    }

    private static List<TitlePageData> mapToTitlePageData(List<Post> postList, UserDao userDao) {
        List<TitlePageData> dataList = new ArrayList<TitlePageData>();

        for ( Post post : postList ) {
            TitlePageData data = new TitlePageData();

            LocalDateTime dateTime = post.getDateTime();
            data.setDateTime(dateTime);

            Long userId = post.getUserId();
            User user = userDao.findById(userId);
            String userFullName = user.getFirstName() + " " + user.getLastName();
            data.setUser(userFullName);

            String title = post.getTitle();
            data.setTitle(title);

            dataList.add(data);
        }
        return dataList;
    }
    private static void putNewRecordsToDataBase(UserDao userDao, PostDao postDao) {
        User newUser1 = new User();
        newUser1.setFirstName("Jim");
        newUser1.setLastName("Moriarty");
        userDao.save(newUser1);

        Post newPost1 = new Post();
        newPost1.setDateTime(LocalDateTime.parse("2017-04-16T08:11:30"));
        newPost1.setUser(newUser1);
        newPost1.setTitle("Jim's speech.");
        newPost1.setPublication("Honey you should see me in a crown.");
        postDao.save(newPost1);

        Post newPost2 = new Post();
        newPost2.setDateTime( LocalDateTime.parse("2017-04-10T10:11:30") );
        newPost2.setUser(newUser1);
        newPost2.setTitle("Some question.");
        newPost2.setPublication("Miss me?");
        postDao.save(newPost2);

//        ---------------

        User newUser2 = new User();
        newUser2.setFirstName("James");
        newUser2.setLastName("Bond");
        userDao.save(newUser2);

        Post newPost3 = new Post();
        newPost3.setDateTime( LocalDateTime.parse("2017-04-05T12:15:00") );
        newPost3.setUser(newUser2);
        newPost3.setTitle("Who are you?");
        newPost3.setPublication("Bond James Bond");
        postDao.save(newPost3);

//        ---------------

        User newUser3 = new User();
        newUser3.setFirstName("Dima");
        newUser3.setLastName("Mendeleev");
        userDao.save(newUser3);

        Post newPost4 = new Post();
        newPost4.setDateTime( LocalDateTime.parse("2010-01-05T12:15:00") );
        newPost4.setUser(newUser3);
        newPost4.setTitle("The only to know");
        newPost4.setPublication("No chem - no love");
        postDao.save(newPost4);

        Post newPost5 = new Post();
        newPost5.setDateTime( LocalDateTime.parse("2011-02-05T16:15:00") );
        newPost5.setUser(newUser3);
        newPost5.setTitle("My favorite gas in space");
        newPost5.setPublication("There are no any gas, you know");
        postDao.save(newPost5);

        Post newPost6 = new Post();
        newPost6.setDateTime( LocalDateTime.parse("2014-06-05T19:15:00") );
        newPost6.setUser(newUser3);
        newPost6.setTitle("London");
        newPost6.setPublication("London is the capital of GB");
        postDao.save(newPost6);

    }

}
