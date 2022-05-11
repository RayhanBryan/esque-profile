package com.web.blog.backend.controller;

import com.web.blog.backend.entity.Activity;
import com.web.blog.backend.service.ActivityService;
import com.web.blog.backend.util.DataResponse;
import com.web.blog.backend.util.DataResponseList;
import com.web.blog.backend.util.DataResponsePagination;
import com.web.blog.backend.wrapper.ActivityWrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(path = "/activity")
public class ActivityController {
    @Autowired
    ActivityService activityService;

    // get
    @GetMapping(path = "/findAll")
    public DataResponseList<ActivityWrapper> findAll() {
        return new DataResponseList<>(activityService.findAll());
    }

    @GetMapping(path = "/findAllOrderBy")
    public DataResponseList<ActivityWrapper> findAllOrderBy(){
        return new DataResponseList<>(activityService.findAllOrderBy());
    }

    @GetMapping(path = "/findAllPagination")
    public DataResponsePagination<ActivityWrapper, Activity> findAllPagination(@RequestParam("page") int page,
            @RequestParam("size") int size) {
        return new DataResponsePagination<>(activityService.findAllWithPagination(page, size));
    }

    @GetMapping(path = "/findById")
    public DataResponse<ActivityWrapper> findById(@RequestParam("id") Long id) {
        try {
            ActivityWrapper result = activityService.getactivityById(id);
            return new DataResponse<>(result);
        } catch (Exception e) {
            return new DataResponse<ActivityWrapper>(false, "Activity tidak ditemukan: " + id);
        }

    }

    // post&put
    @PostMapping(path = "/post")
    public DataResponse<ActivityWrapper> post(@RequestBody ActivityWrapper wrapper) {
        return new DataResponse<>(activityService.save(wrapper));
    }

    @PutMapping(path = "/update")
    public DataResponse<ActivityWrapper> update(@RequestBody ActivityWrapper wrapper) {
        try {
            return new DataResponse<>(activityService.save(wrapper));
        } catch (Exception e) {
            return new DataResponse<>(false, "Activity tidak ditemukan: " + wrapper.getActivityId());
        }
    }

    // delete
    @DeleteMapping(path = "/delete")
    public DataResponse<ActivityWrapper> delete(@RequestParam("id") Long id) {
        try {
            activityService.delete(id);
            return new DataResponse<>(true, "Delete Sukses");
        } catch (Exception e) {
            return new DataResponse<>(false, "User tidak ditemukan: " + id);
        }
    }
}
