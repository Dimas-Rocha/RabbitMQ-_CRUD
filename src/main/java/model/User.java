package model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	private Long id;
	private String name;
	private String email;
	private LocalDateTime cretedAt;
	private LocalDateTime updateAt;

	protected void onCreate(LocalDateTime createdAt) {
		createdAt = LocalDateTime.now();
		updateAt = LocalDateTime.now();
	}

	protected void onUpdate() {
		updateAt = LocalDateTime.now();
	}
// CONSTRUCTORS

	public User() {}
	
	public User(String name, String email) {
		
		this.name = name;
		this.email = email;
				
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDateTime getCretedAt() {
		return cretedAt;
	}

	public void setCretedAt(LocalDateTime cretedAt) {
		this.cretedAt = cretedAt;
	}

	public LocalDateTime getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(LocalDateTime updateAt) {
		this.updateAt = updateAt;
	}
	
	
	//GETTERS AND SETTERS
	
	
	
	
	
}
