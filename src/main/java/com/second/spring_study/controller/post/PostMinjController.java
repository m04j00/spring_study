package com.second.spring_study.controller.post;

import com.second.spring_study.dto.request.minj.CreatePostRequestDto;
import com.second.spring_study.dto.response.minj.PostResponseDto;
import com.second.spring_study.service.post.PostMinjService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/posts-minj")
public class PostMinjController {
    private final PostMinjService postMinjService;

    @PostMapping("/{userpk}")
    public void createPost(@PathVariable(name = "userpk") @Valid long userPk, @RequestBody @Valid CreatePostRequestDto createPostRequestDto) {
        postMinjService.createPost(userPk, createPostRequestDto);
    }

    @GetMapping
    public List<PostResponseDto> getPosts(@RequestParam(value = "userpk", required = false) Long userPk) {
        return postMinjService.getPosts(userPk);
    }

    @PostMapping("/details/{id}")
    public PostResponseDto getPost(@PathVariable(name="id") @Valid long postId){
        return postMinjService.getPost(postId);
    }

}
