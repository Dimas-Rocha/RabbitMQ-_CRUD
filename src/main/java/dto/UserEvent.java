package dto;

import java.time.LocalDateTime;

public class UserEvent {
private String type;
private Long userId;
private String userEmail;
private LocalDateTime timestamp;

public UserEvent() {}

public UserEvent(String type, Long userId, String userEmail, LocalDateTime timestamp) {
	
	this.type = type;
	this.userId = userId;
	this.userEmail = userEmail;
	this.timestamp = timestamp;
}

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

public Long getUserId() {
	return userId;
}

public void setUserId(Long userId) {
	this.userId = userId;
}

public String getUserEmail() {
	return userEmail;
}

public void setUserEmail(String userEmail) {
	this.userEmail = userEmail;
}

public LocalDateTime getTimestamp() {
	return timestamp;
}

public void setTimestamp(LocalDateTime timestamp) {
	this.timestamp = timestamp;
}

@Override
public String toString() {
	return "UserEvent [type=" + type + ", userId=" + userId + ", userEmail=" + userEmail + ", timestamp=" + timestamp
			+ "]";
}




}
