package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


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

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_COMPLETED")
	private Date dateCompleted;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DUE_DATE")
	private Date dueDate;

	private String priority;

	@Column(name="STATUS_ID")
	private int statusId;

	@Column(name="TRACK_DESCRIPTION")
	private String trackDescription;

	//bi-directional many-to-one association to Status
	@OneToMany(mappedBy="todoList")
	private List<Status> statuses;

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

	public Date getDateCompleted() {
		return this.dateCompleted;
	}

	public void setDateCompleted(Date dateCompleted) {
		this.dateCompleted = dateCompleted;
	}

	public Date getDueDate() {
		return this.dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getPriority() {
		return this.priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public int getStatusId() {
		return this.statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public String getTrackDescription() {
		return this.trackDescription;
	}

	public void setTrackDescription(String trackDescription) {
		this.trackDescription = trackDescription;
	}

	public List<Status> getStatuses() {
		return this.statuses;
	}

	public void setStatuses(List<Status> statuses) {
		this.statuses = statuses;
	}

	public Status addStatus(Status status) {
		getStatuses().add(status);
		status.setTodoList(this);

		return status;
	}

	public Status removeStatus(Status status) {
		getStatuses().remove(status);
		status.setTodoList(null);

		return status;
	}

	public User1 getUser1() {
		return this.user1;
	}

	public void setUser1(User1 user1) {
		this.user1 = user1;
	}

}