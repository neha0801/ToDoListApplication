package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TODO_LIST database table.
 * 
 */
@Entity
@Table(name="TODO_LIST",schema="testDb")
@NamedQuery(name="TodoList.findAll", query="SELECT t FROM TodoList t")
public class TodoList implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="LIST_ID")
	private int listId;

	@Column(name="DUE_DATE")
	private String dueDate;

	private String priority;

	@Column(name="TRACK_DESCRIPTION")
	private String trackDescription;

	//bi-directional many-to-one association to Status
	@ManyToOne
	@JoinColumn(name="STATUS_ID")
	private Status status;

	//bi-directional many-to-one association to User1
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private User1 user1;

	public TodoList() {
	}

	public int getListId() {
		return this.listId;
	}

	public void setListId(int listId) {
		this.listId = listId;
	}

	public String getDueDate() {
		return this.dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getPriority() {
		return this.priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getTrackDescription() {
		return this.trackDescription;
	}

	public void setTrackDescription(String trackDescription) {
		this.trackDescription = trackDescription;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public User1 getUser1() {
		return this.user1;
	}

	public void setUser1(User1 user1) {
		this.user1 = user1;
	}

}