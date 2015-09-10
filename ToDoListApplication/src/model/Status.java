package model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


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
	@OneToMany(mappedBy="status")
	private List<TodoList> todoLists;

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

	public List<TodoList> getTodoLists() {
		return this.todoLists;
	}

	public void setTodoLists(List<TodoList> todoLists) {
		this.todoLists = todoLists;
	}

	public TodoList addTodoList(TodoList todoList) {
		getTodoLists().add(todoList);
		todoList.setStatus(this);

		return todoList;
	}

	public TodoList removeTodoList(TodoList todoList) {
		getTodoLists().remove(todoList);
		todoList.setStatus(null);

		return todoList;
	}
	

}