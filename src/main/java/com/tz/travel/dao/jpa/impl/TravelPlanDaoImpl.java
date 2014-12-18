package com.tz.travel.dao.jpa.impl;

import com.tz.travel.dao.jpa.Interface.TravelPlanDao;
import com.tz.travel.model.TravelPlan;
import com.tz.travel.model.UserExt;
import org.springframework.stereotype.Component;

/**
 * Created by tzjeefjalft on 12/18/2014.
 */
@Component
public class TravelPlanDaoImpl extends AbstractGenericDao<TravelPlan, Integer> implements TravelPlanDao{
    public TravelPlanDaoImpl() {
        super(TravelPlan.class, Integer.class);
    }
}
