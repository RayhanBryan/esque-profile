package com.web.blog.backend.controller;

import com.web.blog.backend.entity.User;
import com.web.blog.backend.service.UserService;
import com.web.blog.backend.util.DataResponse;
import com.web.blog.backend.util.DataResponseList;
import com.web.blog.backend.util.DataResponsePagination;
import com.web.blog.backend.wrapper.UserWrapper;

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
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
    UserService userService;

    // get
    @GetMapping(path = "/findAll")
    public DataResponseList<UserWrapper> findAll() {
        return new DataResponseList<UserWrapper>(userService.findAll());
    }

    @GetMapping(path = "/findAllPagination")
    public DataResponsePagination<UserWrapper, User> findAllPagination(@RequestParam("page") int page,
            @RequestParam("size") int size) {
        return new DataResponsePagination<UserWrapper, User>(userService.findAll(page, size));
    }

    @GetMapping(path = "/findById")
    public DataResponse<UserWrapper> findById(@RequestParam("id") Long id) {
        try {
            UserWrapper hasil = userService.getById(id);
            return new DataResponse<UserWrapper>(hasil);
        } catch (Exception e) {
            return new DataResponse<UserWrapper>(false, "User tidak ditemukan: " + id);
        }

    }

    @GetMapping("/findByUserName")
    public DataResponseList<UserWrapper> findByUserName(@RequestParam("username") String userName) {
        return new DataResponseList<UserWrapper>(userService.findByUserName(userName));
    }

    // post&put
    @PostMapping(path = "/post")
    public DataResponse<UserWrapper> post(@RequestBody UserWrapper wrapper) {
        return new DataResponse<UserWrapper>(userService.save(wrapper));
    }

    @PutMapping(path = "/update")
    public DataResponse<UserWrapper> update(@RequestBody UserWrapper wrapper) {
        try {
            return new DataResponse<UserWrapper>(userService.save(wrapper));
        } catch (Exception e) {
            return new DataResponse<UserWrapper>(false, "User tidak ditemukan: " + wrapper.getUserId());
        }
    }

    // delete
    @DeleteMapping(path = "/delete")
    public DataResponse<UserWrapper> delete(@RequestParam("id") Long id) {
        try {
            userService.delete(id);
            return new DataResponse<UserWrapper>(true, "Delete Sukses");
        } catch (Exception e) {
            return new DataResponse<UserWrapper>(false, "User tidak ditemukan: " + id);
        }
    }

}
