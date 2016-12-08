package com.niit.collaborationbackend.test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.niit.collaborationbackend.dao.UserDAO;
import com.niit.collaborationbackend.model.User;

public class UserTest {

	public static void main(String[] args)
	{
		AnnotationConfigApplicationContext mycontext = new AnnotationConfigApplicationContext();
		mycontext.scan("com.niit.collaborationbackend");
		mycontext.refresh();
		UserDAO userdao = (UserDAO) mycontext.getBean("userDAO");
		User user = (User) mycontext.getBean("user");
		user.setU_name("natasha");
		user.setU_address("NIIT,second floor,bhandarkar bhavan,wesa borivali west, US");
		/*user.setU_dob("31/03/1978");*/
		user.setU_gender("M");
		user.setU_contact("6523959144");
		user.setU_email("chiragjohn@gmail.com");
		//user.setEnabled(true);
		user.setU_username("john");
		user.setU_password("password");
		
		userdao.addUser(user);
		System.out.println(userdao.getAllUsers());
	}

}
