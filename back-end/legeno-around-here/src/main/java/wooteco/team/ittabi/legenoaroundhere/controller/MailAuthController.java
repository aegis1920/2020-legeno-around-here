package wooteco.team.ittabi.legenoaroundhere.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import wooteco.team.ittabi.legenoaroundhere.dto.MailAuthCheckRequest;
import wooteco.team.ittabi.legenoaroundhere.dto.MailAuthCreateRequest;
import wooteco.team.ittabi.legenoaroundhere.dto.MailAuthFindPasswordRequest;
import wooteco.team.ittabi.legenoaroundhere.service.MailAuthService;

@RestController
@RequiredArgsConstructor
public class MailAuthController {

    private final MailAuthService mailAuthService;

    @PostMapping("/mail-auth/send")
    public ResponseEntity<Void> sendAuthMail(
        @RequestBody MailAuthCreateRequest mailAuthCreateRequest) {
        mailAuthService.publishAuth(mailAuthCreateRequest);

        return ResponseEntity
            .ok()
            .build();
    }

    @PostMapping("/mail-auth/find/password")
    public ResponseEntity<Void> findPasswordAuthMail(
        @RequestBody MailAuthFindPasswordRequest mailAuthFindPasswordRequest) {
        mailAuthService.publishAuth(mailAuthFindPasswordRequest);

        return ResponseEntity
            .ok()
            .build();
    }

    @PostMapping("/mail-auth/check")
    public ResponseEntity<Void> checkAuth(@RequestBody MailAuthCheckRequest mailAuthCheckRequest) {
        mailAuthService.checkAuth(mailAuthCheckRequest);

        return ResponseEntity
            .ok()
            .build();
    }
}
