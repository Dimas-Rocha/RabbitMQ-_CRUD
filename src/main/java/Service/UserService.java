package Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Repository.UserRepository;
import dto.UserRequest;
import dto.UserResponse;
import model.User;

@Service
@Transactional	
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public UserResponse createdUser(UserRequest request) {
		if (userRepository.existsByEmail(request.getEmail())) {
			throw new RunTimeException("Email ja esta em uso: "+request.getEmail());
		}
		
		User user = new User();
		user.setEmail(request.getEmail());
		user.setName(request.getName());
		
		User savedUser = userRepository.save(user);
		
		
	}

}
