package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Service.UserService;
import dto.UserRequest;
import dto.UserResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping
	public ResponseEntity<UserResponse> createdUser(@Valid @RequestBody UserRequest request) {
		UserResponse response = userService.createdUser(request);
		return ResponseEntity.ok(response);
	}

	@GetMapping
	public ResponseEntity<List<UserResponse>> getAllUsers() {
		List<UserResponse> response = userService.getAllUsers();
		return ResponseEntity.ok(response);

	}

	@GetMapping("/{id}")
	public ResponseEntity<UserResponse> getUserBiId(@PathVariable Long id) {
		UserResponse user = userService.getUserById(id);

		return ResponseEntity.ok(user);

	}

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse>updateUser(@PathVariable Long id,
    		@Valid @RequestBody UserRequest request){
    	UserResponse response = userService.updateUser(id, request);
    	return ResponseEntity.ok(response);
    	
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
    	userService.deleteUser(id);
    	return ResponseEntity.noContent().build();
    }
}
