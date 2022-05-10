package com.web.blog.backend.service;

import java.util.ArrayList;
import java.util.List;

import com.web.blog.backend.entity.Activity;
import com.web.blog.backend.exception.BusinessException;
import com.web.blog.backend.service.repository.ActivityRepository;
import com.web.blog.backend.util.PaginationList;
import com.web.blog.backend.wrapper.ActivityWrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ActivityService {
    @Autowired
    ActivityRepository activityRepository;

    // util

    private Activity toEntity(ActivityWrapper wrapper) {
        Activity entity = new Activity();
        if (wrapper.getActivityId() != null) {
            entity = activityRepository.getById(wrapper.getActivityId());
        }
        entity.setUrl(wrapper.getUrl());
        entity.setTitle(wrapper.getTitle());
        entity.setTextActivity(wrapper.getTextActivity());
        return entity;
    }

    private ActivityWrapper toWrapper(Activity entity) {
        ActivityWrapper wrapper = new ActivityWrapper();
        wrapper.setActivityId(entity.getActivityId());
        wrapper.setUrl(entity.getUrl());
        wrapper.setTitle(entity.getTitle());
        wrapper.setTextActivity(entity.getTextActivity());
        return wrapper;
    }

    private List<ActivityWrapper> toWrapperList(List<Activity> entityList) {
        List<ActivityWrapper> wrappers = new ArrayList<ActivityWrapper>();
        for (Activity entity : entityList) {
            wrappers.add(toWrapper(entity));
        }
        return wrappers;
    }

    private PaginationList<ActivityWrapper, Activity> toPaginationList(Page<Activity> entityPage) {
        List<Activity> entityList = entityPage.getContent();
        List<ActivityWrapper> wrapperList = toWrapperList(entityList);
        PaginationList<ActivityWrapper, Activity> paginationList = new PaginationList<>(wrapperList, entityPage);
        return paginationList;
    }

    // Retrieve list of data
    public List<ActivityWrapper> findAll() {
        List<Activity> activityList = activityRepository.findAll();
        return toWrapperList(activityList);
    }

    // Retrieve single data
    public ActivityWrapper getactivityById(Long activityId) {
        return toWrapper(activityRepository.findById(activityId).get());
    }

    // Retrieve list of data with pagination
    public PaginationList<ActivityWrapper, Activity> findAllWithPagination(int page,
            int size) {
        return toPaginationList(activityRepository.findAll(PageRequest.of(page, size)));
    }

    // Create and Update
    public ActivityWrapper save(ActivityWrapper wrapper) {
        Activity activity = activityRepository.save(toEntity(wrapper));
        return toWrapper(activity);
    }

    // Delete
    public void delete(Long id) {
        if (id == null)
            throw new BusinessException("Id cannot be null");
        activityRepository.deleteById(id);
    }

}
