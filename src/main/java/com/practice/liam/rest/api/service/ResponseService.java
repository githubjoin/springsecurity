package com.practice.liam.rest.api.service;

import com.practice.liam.rest.api.model.CommonResult;
import com.practice.liam.rest.api.model.ListResult;
import com.practice.liam.rest.api.model.SingleResult;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResponseService {

    public enum CommonResponse {
        SUCCESS(0, "성공하였습니다."),
        FAIL(-1, "실패하였습니다.");

        private int code;
        private String message;

        CommonResponse(int code, String message) {
            this.code = code;
            this.message = message;
        }

        public int getCode() {
            return this.code;
        }

        public String getMessage() {
            return this.message;
        }
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

    public CommonResult getFailResult() {
        CommonResult commonResult = new CommonResult();
        commonResult.setSuccess(false);
        commonResult.setCode(CommonResponse.FAIL.getCode());
        commonResult.setMessage(CommonResponse.FAIL.getMessage());
        return commonResult;
    }


    public void setSuccessResult(CommonResult result) {
        result.setSuccess(true);
        result.setCode(CommonResponse.SUCCESS.getCode());
        result.setMessage(CommonResponse.SUCCESS.getMessage());
    }
}
