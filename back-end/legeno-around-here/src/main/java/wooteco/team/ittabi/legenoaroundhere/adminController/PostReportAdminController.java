package wooteco.team.ittabi.legenoaroundhere.adminController;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import wooteco.team.ittabi.legenoaroundhere.dto.PageRequest;
import wooteco.team.ittabi.legenoaroundhere.dto.PageableAssembler;
import wooteco.team.ittabi.legenoaroundhere.dto.PostReportResponse;
import wooteco.team.ittabi.legenoaroundhere.service.report.PostReportService;

@RestController
@RequiredArgsConstructor
public class PostReportAdminController {

    private final PostReportService postReportService;

    @GetMapping("/admin/post-reports/{id}")
    public ResponseEntity<PostReportResponse> findPostReport(@PathVariable Long id) {
        PostReportResponse postReport = postReportService.findPostReport(id);

        return ResponseEntity
            .ok(postReport);
    }

    @GetMapping("/admin/post-reports")
    public ResponseEntity<Page<PostReportResponse>> findAllPostReport(PageRequest pageRequest) {
        Page<PostReportResponse> postReports
            = postReportService.findAllPostReport(PageableAssembler.assemble(pageRequest));

        return ResponseEntity
            .ok(postReports);
    }

    @DeleteMapping("/admin/post-reports/{id}")
    public ResponseEntity<Void> deletePostReport(@PathVariable Long id) {
        postReportService.deletePostReport(id);

        return ResponseEntity
            .noContent()
            .build();
    }
}
