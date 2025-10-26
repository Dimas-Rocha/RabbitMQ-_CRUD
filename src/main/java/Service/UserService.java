package Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Repository.UserRepository;
import dto.UserEvent;
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
			throw new RunTimeException("Email ja esta em uso: " + request.getEmail());
		}

		User user = new User();
		user.setEmail(request.getEmail());
		user.setName(request.getName());

		User savedUser = userRepository.save(user);
		
           //PUBLICAR EVENTO
		
		UserEvent event = new UserEvent("CREATED", savedUser.getId(), savedUser.getEmail());
		eventProducer.sendUserEvent(event);
		return mapToResponse(savedUser);

	}

	@Transactional(readOnly = true)
	public List<UserResponse> getAllUsers() {
		return userRepository.findAll().stream().map(this::mapToResponse).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public UserResponse getUserById(Long id) {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Usuario não encontrado com ID: " + id));
		return mapToResponse(user);

	}

	public UserResponse updateUser(Long id, UserRequest request) {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Usuario não encontrado com ID: " + id));
	
	
	if(!user.getEmail().equals(request.getEmail())&&
	userRepository.existsByEmail(request.getEmail())){
		throw new RuntimeException("Email ja esta em uso: "+ request.getEmail());
		}
	user.setName(request.getName());
	user.setEmail(request.getEmail());
	User updateUser = userRepository.save(user);
	 
	UserEvent event = new UserEvent("UPDATE", updateUser.getId(), updateUser.getEmail());
	eventProducer.sendUserEvent(event);
	return mapToResponse(updateUser);
	}

	public void deleteUser(Long id) {
		User user = userRepository.findById(id)
				.orElseThrow(()-> new RuntimeException("Usuario não encontrado: "+ id));
		String userEmail = user.getEmail();
		userRepository.delete(user);
		
	}
	private UserResponse mapToResponse(User user) {

		return new UserResponse(user.getId(), user.getName(), user.getEmail(), user.getCretedAt(), user.getUpdateAt());
	}

}
