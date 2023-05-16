package com.crud.SpringBootCrud.controller;


import com.crud.SpringBootCrud.entities.ResponseModel;
import com.crud.SpringBootCrud.entities.User;
import com.crud.SpringBootCrud.helper.UserInfoHelper;
import com.crud.SpringBootCrud.service.UserServiceImpl;
import com.crud.SpringBootCrud.utils.UserConstants;
import com.crud.SpringBootCrud.validator.UserDataInfoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/api")
public class UserController implements UserConstants {

    @Autowired
    ResponseModel responseModel;

    @Autowired
    UserServiceImpl userServiceImpl;


    @PostMapping(value = "/save", consumes = "application/json")
    public ResponseModel save(@RequestBody String jsonDataForSaveUserDataInfo) {

        ArrayList<String> validationResult;
        validationResult = UserDataInfoValidator.validateSaveUserInfo(jsonDataForSaveUserDataInfo);


        if (validationResult.isEmpty()) {
            try {
                User userObj = UserInfoHelper.processSaveUserInfoJsonRequestData(jsonDataForSaveUserDataInfo);
                User user = userServiceImpl
                        .insertUser(userObj);
                if (user != null) {
                    responseModel.setStatus(SUCCESS);
                    responseModel.setMessage(USER_ADDED_SUCCESSFULLY);
                    responseModel.setData(user);
                } else {
                    responseModel.setStatus(FAIL);
                    responseModel.setMessage(ERROR_UNSUCCESS);
                    responseModel.setData(null);
                }
            } catch (Exception ex) {

                responseModel.setMessage(ERROR_EXCEPTION);
                responseModel.setStatus(FAIL);
                responseModel.setData(null);
                System.out.println(ex);
            }

        } else {
            responseModel.setMessage(VALIDATION_ERROR);
            responseModel.setStatus(FAIL);
            responseModel.setData(validationResult);
        }
        return responseModel;
    }


}
