package testservelet;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserServece {
	private static UserServece userServece;
	private List<User> listOfUser = new ArrayList();
	
	private UserServece(){
		
	}
	static UserServece getUserServece() {
		if(userServece == null) {
			userServece = new UserServece();
		}
		return userServece;
	}
	
	
	public List<User> getListOfUser (){
		return listOfUser;
	}
	
     public void  saveUser (User user) throws SQLException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {

		listOfUser.add(user);
		UserDoa userDao = new UserDoa(ConnectionUtil.openConnection());
		 userDao.insert(user.getFirstName(), user.getLastName(), user.getPassword(), user.getEmail(), user.getAccess());
	}
	
     public User getUser(String email) {
 		return listOfUser.stream().filter(user -> user.getEmail().equals(email)).findAny().orElse(null);
 	}
     
}

