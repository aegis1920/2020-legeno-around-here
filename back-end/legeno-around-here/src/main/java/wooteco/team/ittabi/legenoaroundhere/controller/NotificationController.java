package wooteco.team.ittabi.legenoaroundhere.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import wooteco.team.ittabi.legenoaroundhere.dto.NotificationResponse;
import wooteco.team.ittabi.legenoaroundhere.service.NotificationService;

@RestController
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    @GetMapping("/notifications/me")
    public ResponseEntity<List<NotificationResponse>> findMyNotices() {
        List<NotificationResponse> notificationResponses = notificationService.findMyNotice();

        return ResponseEntity
            .ok(notificationResponses);
    }

    @PutMapping("/notifications/{noticeId}/read")
    public ResponseEntity<Void> readMyNotice(@PathVariable Long noticeId) {
        notificationService.readMyNotice(noticeId);

        return ResponseEntity
            .noContent()
            .build();
    }
}
