package net.otrs.noticemanagement.model;

/**
 * 
================================================================================
================================================================================

               THIS MODEL CLASS REPRESENTS A NOTICE ENTITY

================================================================================
================================================================================
*
**/

public class Notice {
	
	protected int id;
	protected int priority;
	protected String title;
	protected String description;
	protected String email;
	
	public Notice() {} /** Default constructor **/
	
	public Notice(int priority, String title, String description, String email) { /** Overloaded constructor with 4 attributes **/
		super();
		this.priority = priority;
		this.title = title;
		this.description = description;
		this.email = email;
	}	
		
	public Notice(int id, int priority, String title, String description, String email) { /** Overloaded constructor with all 5 attributes **/
		super();
		this.id = id;
		this.priority = priority;
		this.title = title;
		this.description = description;
		this.email = email;
	}

	/** Getters and Setters for all attributes **/
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getPriority() {
		return priority;
	}
	
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	/***********************************************/
	
}
