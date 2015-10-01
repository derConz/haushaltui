package de.derconz.web.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import de.derconz.kit.IUser;
import de.derconz.kit.persist.User;
import de.derconz.kit.persist.UserDAO;

@Controller
@ManagedBean(name ="userService")
@ViewScoped
public class UserServiceBean implements Serializable {

	@Autowired
	private UserDAO userDAO;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3647806285487854402L;
	
	private List<IUser> userList;
	
	public UserServiceBean() {
		System.out.println("Bean initialised");
	}

	public List<IUser> getUserList() {
		return userDAO.getUserList();
	}

	public void setUserList(List<IUser> userList) {
		this.userList = userList;
	}
	
	
	public void populateUserList(ActionEvent ae) {
		userList = userDAO.getUserList();
	}
}
