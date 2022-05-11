package com.web.blog.backend.service;

import java.util.ArrayList;
import java.util.List;

import com.web.blog.backend.entity.User;
import com.web.blog.backend.repository.UserRepository;
import com.web.blog.backend.util.PaginationList;
import com.web.blog.backend.wrapper.UserWrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {
    @Autowired
    UserRepository userRepository;

    // util
    private User toEntity(UserWrapper wrapper) {
        User entity = new User();
        if (wrapper.getUserId() != null) {
            entity = userRepository.getById(wrapper.getUserId());
        }
        entity.setUserName(wrapper.getUserName());
        entity.setPassword(wrapper.getPassword());
        return entity;
    }

    private UserWrapper toWrapper(User entity) {
        UserWrapper wrapper = new UserWrapper();
        wrapper.setUserId(entity.getUserId());
        wrapper.setUserName(entity.getUserName());
        wrapper.setPassword(entity.getPassword());
        return wrapper;
    }

    private List<UserWrapper> toWrapperList(List<User> entityList) {
        List<UserWrapper> wrapperList = new ArrayList<UserWrapper>();
        for (User entity : entityList) {
            wrapperList.add(toWrapper(entity));
        }
        return wrapperList;
    }

    private PaginationList<UserWrapper, User> toPaginationList(Page<User> entityPage) {
        List<User> entityList = entityPage.getContent();
        List<UserWrapper> wrapperList = toWrapperList(entityList);
        PaginationList<UserWrapper, User> paginationList = new PaginationList<>(wrapperList, entityPage);
        return paginationList;
    }

    // get
    public List<UserWrapper> findAll() {
        return toWrapperList(userRepository.findAll(Sort.by("userId").ascending()));
    }

    public List<UserWrapper> findByUserName(String userName) {
        return toWrapperList(userRepository.findByUserNameIgnoreCaseContaining(userName));
    }

    public PaginationList<UserWrapper, User> findAll(int page, int size) {
        Pageable paging = PageRequest.of(page, size);
        return toPaginationList(userRepository.findAll(paging));
    }

    public UserWrapper getById(Long id) {
        User user = userRepository.getById(id);
        return toWrapper(user);
    }

    // post & put
    public UserWrapper save(UserWrapper wrapper) {
        return toWrapper(userRepository.save(toEntity(wrapper)));
    }

    // delete
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
