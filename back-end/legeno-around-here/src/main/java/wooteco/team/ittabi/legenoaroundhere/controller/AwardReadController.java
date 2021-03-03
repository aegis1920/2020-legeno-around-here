package wooteco.team.ittabi.legenoaroundhere.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import wooteco.team.ittabi.legenoaroundhere.dto.AwardResponse;
import wooteco.team.ittabi.legenoaroundhere.service.award.AwardService;

@RestController
@RequiredArgsConstructor
public class AwardReadController {

    private final AwardService awardService;

    @GetMapping("/users/{userId}/awards")
    public ResponseEntity<List<AwardResponse>> findAwards(@PathVariable Long userId) {
        List<AwardResponse> awards = awardService.findAwards(userId);

        return ResponseEntity
            .ok(awards);
    }

    @GetMapping("/awards/me")
    public ResponseEntity<List<AwardResponse>> findMyAwards() {
        List<AwardResponse> awards = awardService.findMyAwards();

        return ResponseEntity
            .ok(awards);
    }
}
