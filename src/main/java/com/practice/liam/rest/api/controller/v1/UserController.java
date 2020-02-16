package com.practice.liam.rest.api.controller.v1;

import com.practice.liam.rest.api.entity.User;
import com.practice.liam.rest.api.model.CommonResult;
import com.practice.liam.rest.api.model.ListResult;
import com.practice.liam.rest.api.model.SingleResult;
import com.practice.liam.rest.api.repository.UserJpaRepo;
import com.practice.liam.rest.api.service.ResponseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"1. User"})
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1")
public class UserController {

    @Autowired
    UserJpaRepo userJpaRepo;

    @Autowired
    ResponseService responseService;

    @ApiOperation(value = "회원 리스트 조회", notes = "모든 회원을 조회한다")
    @GetMapping(value = "/users")
    public ListResult<User> findAllUser() {
        return responseService.getListResult(userJpaRepo.findAll());
    }

    @ApiOperation(value = "회원 조회", notes = "회원번호의 회원을 조회한다")
    @GetMapping(value = "/user/{id}")
    public SingleResult<User> findUser(@ApiParam(value = "id", required = true) @PathVariable Long id) {
        return responseService.getSingleResult(userJpaRepo.findById(id).orElse(null));
    }

    @ApiOperation(value = "회원 등록", notes = "회원을 등록한다")
    @PostMapping(value = "/user")
    public SingleResult<User> save(@ApiParam(value = "회원ID", required = true) @RequestParam String uid,
                     @ApiParam(value = "회원명", required = true) @RequestParam String name
    ) {
        User user = User.builder()
                .uid(uid)
                .name(name)
                .build();
        return responseService.getSingleResult(userJpaRepo.save(user));
    }

    @ApiOperation(value = "회원 수정", notes = "회원정보를 수정한다")
    @PutMapping(value = "/user")
    public SingleResult<User> modify(
            @ApiParam(value = "회원번호", required = true) @RequestParam Long id,
            @ApiParam(value = "회원id", required = true) @RequestParam String uid,
                                   @ApiParam(value = "회원명", required = true) @RequestParam String name
    ) {
        User user = User.builder()
                .id(id)
                .uid(uid)
                .name(name)
                .build();
        return responseService.getSingleResult(userJpaRepo.save(user));
    }

    @ApiOperation(value = "회원 삭제", notes = "회원정보를 삭제한다")
    @DeleteMapping(value = "/user/{id}")
    public CommonResult delete(
            @ApiParam(value = "회원번호", required = true) @PathVariable Long id
    ) {
        userJpaRepo.deleteById(id);
        return responseService.getSuccessResult();
    }
}
