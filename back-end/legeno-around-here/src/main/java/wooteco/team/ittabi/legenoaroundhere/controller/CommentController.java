package wooteco.team.ittabi.legenoaroundhere.controller;

import java.net.URI;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import wooteco.team.ittabi.legenoaroundhere.dto.CommentRequest;
import wooteco.team.ittabi.legenoaroundhere.dto.CommentResponse;
import wooteco.team.ittabi.legenoaroundhere.service.CommentService;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<Void> createComment(@PathVariable Long postId,
        @RequestBody CommentRequest commentRequest) {
        CommentResponse commentResponse = commentService.createComment(postId, commentRequest);

        return ResponseEntity
            .created(URI.create("/comments/" + commentResponse.getId()))
            .build();
    }

    @PostMapping("/posts/{postId}/comments/{commentId}/comments")
    public ResponseEntity<Void> createCocomment(@PathVariable Long commentId,
        @RequestBody CommentRequest commentRequest) {
        CommentResponse commentResponse = commentService.createCocomment(commentId, commentRequest);

        return ResponseEntity
            .created(URI.create("/comments/" + commentResponse.getId()))
            .build();
    }

    @PutMapping("/comments/{commentId}")
    public ResponseEntity<CommentResponse> updateComment(@PathVariable Long commentId,
        @RequestBody CommentRequest commentRequest) {
        CommentResponse commentResponse = commentService.updateComment(commentId, commentRequest);

        return ResponseEntity
            .ok()
            .body(commentResponse);
    }

    @GetMapping("/comments/{commentId}")
    public ResponseEntity<CommentResponse> findComment(@PathVariable Long commentId) {
        CommentResponse commentResponse = commentService.findComment(commentId);

        return ResponseEntity
            .ok()
            .body(commentResponse);
    }

    @GetMapping("/posts/{postId}/comments")
    public ResponseEntity<List<CommentResponse>> findAllComment(@PathVariable Long postId) {
        List<CommentResponse> commentResponses = commentService.findAllComment(postId);

        return ResponseEntity
            .ok()
            .body(commentResponses);
    }

    @DeleteMapping("/comments/{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long commentId) {
        commentService.deleteComment(commentId);

        return ResponseEntity
            .noContent()
            .build();
    }

    @PostMapping("/comments/{commentId}/zzangs")
    public ResponseEntity<Void> pressCommentZzang(@PathVariable Long commentId) {
        commentService.pressZzang(commentId);

        return ResponseEntity
            .noContent()
            .build();
    }
}
