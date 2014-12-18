package com.tz.travel.rest;

import com.tz.travel.dao.jpa.Interface.TravelPlanDao;
import com.tz.travel.dao.jpa.Interface.UserExtDao;
import com.tz.travel.dao.jpa.Interface.UserInfoDao;
import com.tz.travel.kernel.model.entity.UserEntity;
import com.tz.travel.model.TravelPlan;
import com.tz.travel.model.UserExt;
import com.tz.travel.model.UserInfo;
import com.tz.travel.service.TransferInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;

import com.tz.travel.kernel.model.rest.request.InfoRequest;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by tzjeefjalft on 12/15/2014.
 */
@Path("/userInfo")
@Component
@Transactional
public class UserInfoService {
    private static Logger LOGGER = LoggerFactory.getLogger(UserInfoService.class);

    @Autowired
    private UserInfoDao userInfoDao;
    @Autowired
    private UserExtDao userExtDao;
    @Autowired
    private TransferInfo transferInfo;
    @Autowired
    private TravelPlanDao travelPlanDao;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserById(@QueryParam("id") Integer id){
        try {
            return Response.ok().entity(userInfoDao.find(id)).build();
        } catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/ext")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserExtById(@QueryParam("id") Integer id){
        try {
            return Response.ok().entity(userExtDao.find(id)).build();
        } catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response createUser(InfoRequest<UserEntity> infoRequest){
        try {
            UserInfo userInfo = transferInfo.UserInfoRequestToUserInfo(infoRequest);
            userInfoDao.create(userInfo);
            return Response.ok().entity(null).build();
        } catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("/createTravelPlanByUserId")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createTravelPlan(@QueryParam("id") Integer id,InfoRequest<UserEntity> infoRequest){
        try {
            UserInfo info = userInfoDao.find(id);
            TravelPlan travelPlan = new TravelPlan();
            travelPlan.setTitle("title");
            travelPlan.setStatus(1);
            travelPlan.setImgPath("img");
            travelPlan.setDescription("desc");
//            Collection<TravelPlan> travelPlans = new ArrayList<TravelPlan>();
//            travelPlans.add(travelPlan);
//            info.setTblTravelPlansById(travelPlans);
//            info.setUserPw("777");
//            userInfoDao.create(info);
            travelPlan.setTblUserInfoByUserId(info);
            travelPlanDao.create(travelPlan);
            return Response.ok().entity(null).build();
        } catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

}
