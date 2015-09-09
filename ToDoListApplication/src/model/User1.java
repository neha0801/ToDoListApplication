package model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the USER1 database table.
 * 
 */
@Entity
@Table(name="User1",schema="testDb")
@NamedQuery(name="User1.findAll", query="SELECT u FROM User1 u")
public class User1 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int userid;

	private int birthyear;

	private String email;

	private String firstname;

	private String lastname;

	//bi-directional many-to-one association to Status
	@OneToMany(mappedBy="user1")
	private List<Status> statuses;

	//bi-directional many-to-one association to TodoList
	@OneToMany(mappedBy="user1")
	private List<TodoList> todoLists;

	public User1() {
	}

	public int getUserid() {
		return this.userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getBirthyear() {
		return this.birthyear;
	}

	public void setBirthyear(int birthyear) {
		this.birthyear = birthyear;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public List<Status> getStatuses() {
		return this.statuses;
	}

	public void setStatuses(List<Status> statuses) {
		this.statuses = statuses;
	}

	public Status addStatus(Status status) {
		getStatuses().add(status);
		status.setUser1(this);

		return status;
	}

	public Status removeStatus(Status status) {
		getStatuses().remove(status);
		status.setUser1(null);

		return status;
	}

	public List<TodoList> getTodoLists() {
		return this.todoLists;
	}

	public void setTodoLists(List<TodoList> todoLists) {
		this.todoLists = todoLists;
	}

	public TodoList addTodoList(TodoList todoList) {
		getTodoLists().add(todoList);
		todoList.setUser1(this);

		return todoList;
	}

	public TodoList removeTodoList(TodoList todoList) {
		getTodoLists().remove(todoList);
		todoList.setUser1(null);

		return todoList;
	}

}