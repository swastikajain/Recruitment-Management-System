package Project.recur.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Project.recur.dto.ResponseMessageDto;
import Project.recur.exception.InvalidUsernameException;
import Project.recur.model.Login;
import Project.recur.service.LoginService;

@RestController
public class AuthController {
	@Autowired
	private LoginService loginService;
	@PostMapping("/auth/signup")
	public ResponseEntity<?> signup(@RequestBody Login login, ResponseMessageDto dto) {
		try {
			return ResponseEntity.ok(loginService.signup(login));
		} catch (InvalidUsernameException e) {
			dto.setMsg(e.getMessage());
			return ResponseEntity.badRequest().body(dto);
		}
	}
}

