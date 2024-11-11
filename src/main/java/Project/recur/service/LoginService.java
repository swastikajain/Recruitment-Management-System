package Project.recur.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import Project.recur.exception.InvalidUsernameException;
import Project.recur.model.Login;
import Project.recur.repository.LoginRepository;

@Service
public class LoginService {
	@Autowired
	private LoginRepository loginRepository;
	
	
	@Autowired
	private BCryptPasswordEncoder passEncoder;
	public List<Login> insertInBatch(List<Login> list) {
		return loginRepository.saveAll(list);
	}
	public Login signup(Login login) throws InvalidUsernameException {
		Optional<Login> optional = loginRepository.findByLoginId(login.getLoginid());
		if (optional.isPresent()) {
			throw new InvalidUsernameException("Login Id already exists");
		}
		// password encryption
		String encryptedPass = passEncoder.encode(login.getPassword());
		login.setPassword(encryptedPass);
		return loginRepository.save(login);
	}
	public Login findByUsername(int login_Id) {
		return loginRepository.findByLoginId(login_Id).get();
	}
}
