package com.second.spring_study.service;

import com.second.spring_study.dto.request.ywoo.PostRequestDto;
import com.second.spring_study.entity.ywoo.boardYwoo.PostYwoo;
import com.second.spring_study.entity.ywoo.boardYwoo.repository.PostYwooRepository;
import com.second.spring_study.entity.ywoo.userYwoo.UserYwoo;
import com.second.spring_study.entity.ywoo.userYwoo.repository.UserYwooRepository;
import com.second.spring_study.exception.ywoo.ApiExceptionYwoo;
import com.second.spring_study.exception.ywoo.ErrorCodeEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostYwooService {
     PostYwooRepository postYwooRepository;
     UserYwooRepository userYwooRepository;

    @Transactional
    public void createPost(PostRequestDto postRequestDto, long userpk){
        //user의 id가 없을 경우 에러 발생
        UserYwoo userYwoo = userYwooRepository.findById(userpk).orElseThrow(()->{
            throw new ApiExceptionYwoo(ErrorCodeEnum.USER_NOT_FOUND);
        });

        PostYwoo boardYwoo = PostYwoo.createPost(userYwoo, postRequestDto.getPostTitle(), postRequestDto.getPostContent());

        postYwooRepository.save(boardYwoo);
    }
}
