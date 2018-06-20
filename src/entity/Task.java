package entity;

public class Task {



	private Integer id;
	private String title;
	private String task;
	private String limitdate;
	private String name;
	private String status;

	public Task() {
	}

	public Task(Integer id,String title,String task ,String limitdate,String name,String status) {
		super();
		this.id = id;
		this.title = title;
		this.task = task;
		this.limitdate = limitdate;
		this.name = name;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public String getLimitdate() {
		return limitdate;
	}

	public void setLimitdate(String limitdate) {
		this.limitdate = limitdate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}