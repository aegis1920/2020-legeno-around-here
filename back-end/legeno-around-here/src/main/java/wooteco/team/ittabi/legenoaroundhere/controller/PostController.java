package wooteco.team.ittabi.legenoaroundhere.controller;

import java.net.URI;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import wooteco.team.ittabi.legenoaroundhere.controller.validator.ImagesConstraint;
import wooteco.team.ittabi.legenoaroundhere.dto.PageRequest;
import wooteco.team.ittabi.legenoaroundhere.dto.PageableAssembler;
import wooteco.team.ittabi.legenoaroundhere.dto.PostCreateRequest;
import wooteco.team.ittabi.legenoaroundhere.dto.PostImageResponse;
import wooteco.team.ittabi.legenoaroundhere.dto.PostResponse;
import wooteco.team.ittabi.legenoaroundhere.dto.PostSearchRequest;
import wooteco.team.ittabi.legenoaroundhere.dto.PostUpdateRequest;
import wooteco.team.ittabi.legenoaroundhere.dto.PostWithCommentsCountResponse;
import wooteco.team.ittabi.legenoaroundhere.service.PostService;

@RestController
@RequiredArgsConstructor
@Validated
public class PostController {

    private final PostService postService;

    @PostMapping("/posts")
    public ResponseEntity<Void> createPost(@RequestBody PostCreateRequest postCreateRequest) {
        Long postId = postService.createPost(postCreateRequest).getId();

        return ResponseEntity
            .created(URI.create("/posts/" + postId))
            .build();
    }

    @GetMapping("/posts/{postId}")
    public ResponseEntity<PostResponse> findPost(@PathVariable Long postId) {
        PostResponse post = postService.findPost(postId);

        return ResponseEntity
            .ok()
            .body(post);
    }

    @PostMapping("/posts/images")
    public ResponseEntity<List<PostImageResponse>> uploadPostImages(
        @ImagesConstraint List<MultipartFile> images) {
        List<PostImageResponse> postImageResponses = postService.uploadPostImages(images);

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(postImageResponses);
    }

    @PutMapping("/posts/{postId}")
    public ResponseEntity<PostResponse> updatePost(@PathVariable Long postId,
        @RequestBody PostUpdateRequest postUpdateRequest) {
        PostResponse postResponse = postService.updatePost(postId, postUpdateRequest);

        return ResponseEntity
            .ok()
            .body(postResponse);
    }

    @GetMapping("/posts")
    public ResponseEntity<Page<PostWithCommentsCountResponse>> searchPosts(
        PageRequest pageRequest, PostSearchRequest postSearchRequest) {
        Page<PostWithCommentsCountResponse> posts
            = postService.searchPosts(PageableAssembler.assemble(pageRequest), postSearchRequest);

        return ResponseEntity
            .ok()
            .body(posts);
    }

    @GetMapping("/posts/me")
    public ResponseEntity<Page<PostWithCommentsCountResponse>> findMyPosts(
        PageRequest pageRequest) {
        Page<PostWithCommentsCountResponse> posts
            = postService.findMyPosts(PageableAssembler.assemble(pageRequest));

        return ResponseEntity
            .ok()
            .body(posts);
    }


    @GetMapping("/users/{userId}/posts")
    public ResponseEntity<Page<PostWithCommentsCountResponse>> findPosts(PageRequest pageRequest,
        @PathVariable Long userId) {
        Page<PostWithCommentsCountResponse> posts
            = postService.findPostsByUserId(PageableAssembler.assemble(pageRequest), userId);

        return ResponseEntity
            .ok()
            .body(posts);
    }

    @DeleteMapping("/posts/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable Long postId) {
        postService.deletePost(postId);

        return ResponseEntity
            .noContent()
            .build();
    }

    @PostMapping("/posts/{postId}/zzangs")
    public ResponseEntity<Void> pressPostZzang(@PathVariable Long postId) {
        postService.pressZzang(postId);

        return ResponseEntity
            .noContent()
            .build();
    }
}
