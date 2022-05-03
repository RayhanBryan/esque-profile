package com.web.blog.backend.service;

import java.util.ArrayList;
import java.util.List;

import com.web.blog.backend.entity.Blog;
import com.web.blog.backend.exception.BusinessException;
import com.web.blog.backend.repository.BlogRepository;
import com.web.blog.backend.repository.UserRepository;
import com.web.blog.backend.util.PaginationList;
import com.web.blog.backend.wrapper.BlogWrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BlogService {
    @Autowired
    BlogRepository blogRepository;

    @Autowired
    UserRepository userRepository;

    // util
    private Blog toEntity(BlogWrapper wrapper) {
        Blog entity = new Blog();
        if (wrapper.getBlogId() != null) {
            entity = blogRepository.getById(wrapper.getBlogId());
        }
        entity.setUrl(wrapper.getUrl());
        entity.setTitle(wrapper.getTitle());
        entity.setTextBlog(wrapper.getTextBlog());
        return entity;
    }

    private BlogWrapper toWrapper(Blog entity) {
        BlogWrapper wrapper = new BlogWrapper();
        wrapper.setBlogId(entity.getBlogId());
        wrapper.setUrl(entity.getUrl());
        wrapper.setTitle(entity.getTitle());
        wrapper.setTextBlog(entity.getTextBlog());
        return wrapper;
    }

    private List<BlogWrapper> toWrapperList(List<Blog> entityList) {
        List<BlogWrapper> wrapperList = new ArrayList<BlogWrapper>();
        for (Blog entity : entityList) {
            wrapperList.add(toWrapper(entity));
        }
        return wrapperList;
    }

    private PaginationList<BlogWrapper, Blog> toPaginationList(Page<Blog> entityPage) {
        List<Blog> entityList = entityPage.getContent();
        List<BlogWrapper> wrapperList = toWrapperList(entityList);
        PaginationList<BlogWrapper, Blog> paginationList = new PaginationList<>(wrapperList, entityPage);
        return paginationList;
    }

    // Retrieve list of data
    public List<BlogWrapper> findAll() {
        List<Blog> blogList = blogRepository.findAll();
        return toWrapperList(blogList);
    }

    // Retrieve single data
    public BlogWrapper getBlogById(Long BlogId) {
        return toWrapper(blogRepository.findById(BlogId).get());
    }

    // Retrieve list of data with pagination
    public PaginationList<BlogWrapper, Blog> findAllWithPagination(int page,
            int size) {
        return toPaginationList(blogRepository.findAll(PageRequest.of(page, size)));
    }

    // Create and Update
    public BlogWrapper save(BlogWrapper wrapper) {
        Blog blog = blogRepository.save(toEntity(wrapper));
        return toWrapper(blog);
    }

    // Delete
    public void delete(Long id) {
        if (id == null)
            throw new BusinessException("Id cannot be null");
        blogRepository.deleteById(id);
    }
}
