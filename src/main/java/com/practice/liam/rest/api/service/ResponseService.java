package com.practice.liam.rest.api.service;

import com.practice.liam.rest.api.model.CommonResult;
import com.practice.liam.rest.api.model.ListResult;
import com.practice.liam.rest.api.model.SingleResult;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResponseService {

    @Getter
    @AllArgsConstructor
    public enum CommonResponse {
        SUCCESS(0, "성공하였습니다."),
        FAIL(-1, "실패하였습니다.");

        private int code;
        private String message;
    }

    public void setSuccessResult(CommonResult result) {
        result.setSuccess(true);
        result.setCode(CommonResponse.SUCCESS.getCode());
        result.setMessage(CommonResponse.SUCCESS.getMessage());
    }

    public <T> SingleResult<T> getSingleResult(T data) {
        SingleResult<T> singleResult = new SingleResult();
        singleResult.setData(data);
        setSuccessResult(singleResult);
        return singleResult;
    }

    public <T> ListResult<T> getListResult(List<T> list) {
        ListResult<T> listResult = new ListResult();
        listResult.setData(list);
        setSuccessResult(listResult);
        return listResult;
    }

    public CommonResult getSuccessResult() {
        CommonResult commonResult = new CommonResult();
        setSuccessResult(commonResult);
        return commonResult;
    }

    public CommonResult getFailResult(int code, String msg) {
        CommonResult commonResult = new CommonResult();
        commonResult.setSuccess(false);
        commonResult.setCode(code);
        commonResult.setMessage(msg);
        return commonResult;
    }
}
