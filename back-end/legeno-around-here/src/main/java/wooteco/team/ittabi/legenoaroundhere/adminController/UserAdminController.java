package wooteco.team.ittabi.legenoaroundhere.adminController;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import wooteco.team.ittabi.legenoaroundhere.dto.LoginRequest;
import wooteco.team.ittabi.legenoaroundhere.dto.TokenResponse;
import wooteco.team.ittabi.legenoaroundhere.service.UserService;

@RestController
@RequiredArgsConstructor
public class UserAdminController {

    private final UserService userService;

    @PostMapping("/admin/login")
    public ResponseEntity<TokenResponse> loginAdmin(@RequestBody LoginRequest loginRequest) {
        TokenResponse token = userService.loginAdmin(loginRequest);

        return ResponseEntity
            .ok(token);
    }
}
