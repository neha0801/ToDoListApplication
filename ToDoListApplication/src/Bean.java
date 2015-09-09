import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import model.*;

@ManagedBean
@RequestScoped
public class Bean {
    private User1 user;
    private List<TodoList> userList;
    private TodoList newItem;
    
    
    private String message;
    
    public Bean() {
    }
    
    @PostConstruct
    public void init() {
        user = new User1();
        userList= new ArrayList<TodoList>();
        newItem = new TodoList();
    }
    
    public String checkUser() {
        if (UserDB.emailExists(user.getEmail())) {
            System.out.println("User logged in " + user.getEmail());
            showList();
            return "ShowList";
        } else {
        	message = "This email address already exists. " +
                    "Please enter another email address";
            UserDB.insert(user);
            return "newUser";
        }
    }
    
    public String insertList() {
    	this.newItem.setUser1(user);
    	ToDoListDB.insert(newItem);
        return "index";

    }
    
    public String newUser() {
         UserDB.insert(user);
         return "index";
    }
    
    public void showList() {
    	List<TodoList> uList = ToDoListDB.getList(UserDB.selectUser(user.getEmail()));
    	this.userList = uList;
    }
    
    public String getList(String email) {
    	return "";
    }
    
    public User1 getUser() {
        return user;
    }

    public void setUser(User1 user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

	public List<TodoList> getUserList() {
		return userList;
	}

	public void setUserList(List<TodoList> userList) {
		this.userList = userList;
	}

	public TodoList getNewItem() {
		return newItem;
	}

	public void setNewItem(TodoList newItem) {
		this.newItem = newItem;
	}


}