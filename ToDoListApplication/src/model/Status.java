package model;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the STATUS database table.
 * 
 */
@Entity
@Table(name="Status",schema="testDb")
@NamedQuery(name="Status.findAll", query="SELECT s FROM Status s")
public class Status implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="STATUS_ID")
	private int statusId;

	@Column(name="STATUS_MESSAGE")
	private String statusMessage;

	//bi-directional many-to-one association to TodoList
	@ManyToOne
	@JoinColumn(name="LIST_ID")
	private TodoList todoList;

	//bi-directional many-to-one association to User1
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private User1 user1;

	public Status() {
	}

	public int getStatusId() {
		return this.statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public String getStatusMessage() {
		return this.statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public TodoList getTodoList() {
		return this.todoList;
	}

	public void setTodoList(TodoList todoList) {
		this.todoList = todoList;
	}

	public User1 getUser1() {
		return this.user1;
	}

	public void setUser1(User1 user1) {
		this.user1 = user1;
	}

}