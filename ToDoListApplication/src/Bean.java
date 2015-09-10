import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import model.*;

@ManagedBean
@RequestScoped
public class Bean {
    private User1 user;
    private List<TodoList> userList;
    private TodoList newItem;
    private Status status;
    private String statusStr;
    ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
    Map<String, Object> sessionMap;

    
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
        	this.user= UserDB.selectUser(user.getEmail());
        	
            System.out.println("User logged in " + user.getEmail());
            showList();
            sessionMap = externalContext.getSessionMap();
            sessionMap.put("user", user);
            return "ShowList";
        } else {
            return "newUser";
        }
    }
    
    public String insertUser() {
        if (UserDB.emailExists(user.getEmail())) {
        	this.user= UserDB.selectUser(user.getEmail());        	
            message = "This email address already exists. " +
                    "Please enter another email address";
            sessionMap = externalContext.getSessionMap();
            sessionMap.put("user", user);
            return "newUser";
        } else {
            UserDB.insert(user);
            return "index";
        }
    }
    
    public String insertList() {
    	System.out.println(user.getFirstname());
    	sessionMap = externalContext.getSessionMap();
    	user = (User1) sessionMap.get("user");
    	this.newItem.setUser1(user);    
    	System.out.println(statusStr);
    	status = StatusDB.getStatusObj(this.getStatusStr());
    	System.out.println("Message " + status.getStatusMessage());
    	System.out.println(user.getFirstname());
    	this.newItem.setStatus(status);
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

	public String getStatusStr() {
		return statusStr;
	}

	public void setStatusStr(String statusStr) {
		this.statusStr = statusStr;
	}

	public Status getStatusObj(String statusStr){
		
		return status;
		
	}
}