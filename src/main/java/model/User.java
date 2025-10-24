package model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Name is mandatory")
	@Column(nullable = false)
	private String name;

	@Email(message = "message should be valid")
	@NotBlank(message = "Email is mandatory")
	@Column(nullable = false, unique = true)
	private String email;

	private LocalDateTime cretedAt;
	private LocalDateTime updateAt;

	@PrePersist
	protected void onCreate(LocalDateTime createdAt) {
		createdAt = LocalDateTime.now();
		updateAt = LocalDateTime.now();
	}

	@PreUpdate
	protected void onUpdate() {
		updateAt = LocalDateTime.now();
	}
// CONSTRUCTORS

	public User() {
	}

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

	// GETTERS AND SETTERS

}
