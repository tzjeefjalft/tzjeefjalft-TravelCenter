package com.tz.travel.service;

import com.tz.travel.kernel.model.entity.UserEntity;
import com.tz.travel.kernel.model.rest.request.InfoRequest;
import com.tz.travel.model.TravelPlan;
import com.tz.travel.model.UserExt;
import com.tz.travel.model.UserInfo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by tzjeefjalft on 12/15/2014.
 */
@Service
public class TransferInfo {
    public UserInfo UserInfoRequestToUserInfo(InfoRequest<UserEntity> requestInfo){
        UserEntity userEntity = requestInfo.getInfo();
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(userEntity.getUserName());
        userInfo.setUserPw(userEntity.getUserPw());
        UserExt userExt = new UserExt();
        userExt.setEmail(userEntity.getEmail());
        userExt.setPhoneNumber(123456789);
        userInfo.setBusinessLevel(1);
        userInfo.setTblUserExtById(userExt);

//        TravelPlan travelPlan = new TravelPlan();
//        travelPlan.setTitle("title");
//        travelPlan.setStatus(1);
//        travelPlan.setImgPath("img");
//        travelPlan.setDescription("desc");
//        Collection<TravelPlan> travelPlans = new ArrayList<TravelPlan>();
//        travelPlans.add(travelPlan);
//        userInfo.setTblTravelPlansById(travelPlans);
        return userInfo;
    }

    public UserExt UserInfoRequestToUserExt(InfoRequest<UserEntity> requestInfo){
        UserEntity userEntity = requestInfo.getInfo();
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(userEntity.getUserName());
        userInfo.setUserPw(userEntity.getUserPw());
        UserExt userExt = new UserExt();
        userExt.setEmail(userEntity.getEmail());
        userExt.setPhoneNumber(123456789);
        userInfo.setBusinessLevel(1);
        userExt.setTblUserInfoById(userInfo);
        return userExt;
    }
}
