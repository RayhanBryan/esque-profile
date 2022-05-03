package com.web.blog.backend.controller;

import java.io.IOException;

import com.web.blog.backend.entity.Blog;
import com.web.blog.backend.repository.BlogRepository;
import com.web.blog.backend.service.BlogService;
import com.web.blog.backend.service.FileUploadUtil;
import com.web.blog.backend.util.DataResponse;
import com.web.blog.backend.util.DataResponseList;
import com.web.blog.backend.util.DataResponsePagination;
import com.web.blog.backend.wrapper.BlogWrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

@CrossOrigin
@RestController
@RequestMapping(path = "/blog")
public class BlogController {
    @Autowired
    BlogService blogService;

    @Autowired
    BlogRepository blogRepository;

    // get
    @GetMapping(path = "/findAll")
    public DataResponseList<BlogWrapper> findAll() {
        return new DataResponseList<BlogWrapper>(blogService.findAll());
    }

    @GetMapping(path = "/findAllPagination")
    public DataResponsePagination<BlogWrapper, Blog> findAllPagination(@RequestParam("page") int page,
            @RequestParam("size") int size) {
        return new DataResponsePagination<BlogWrapper, Blog>(blogService.findAllWithPagination(page, size));
    }

    @GetMapping(path = "/findById")
    public DataResponse<BlogWrapper> findById(@RequestParam("id") Long id) {
        try {
            BlogWrapper hasil = blogService.getBlogById(id);
            return new DataResponse<BlogWrapper>(hasil);
        } catch (Exception e) {
            return new DataResponse<BlogWrapper>(false, "Blog tidak ditemukan: " + id);
        }

    }

    // post&put
    @PostMapping(path = "/post")
    public RedirectView saveBlog(Blog blog,
            @RequestParam("image") MultipartFile multipartFile) throws IOException {
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        blog.setUrl(fileName);
        Blog savedBlog = blogRepository.save(blog);
        String uploadDir = "blog-photos/" + savedBlog.getBlogId();
        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
        return new RedirectView("/post", true);
    }

    @PutMapping(path = "/update")
    public DataResponse<BlogWrapper> update(@RequestBody BlogWrapper wrapper) {
        try {
            return new DataResponse<BlogWrapper>(blogService.save(wrapper));
        } catch (Exception e) {
            return new DataResponse<BlogWrapper>(false, "Blog tidak ditemukan: " + wrapper.getBlogId());
        }
    }

    // delete
    @DeleteMapping(path = "/delete")
    public DataResponse<BlogWrapper> delete(@RequestParam("id") Long id) {
        try {
            blogService.delete(id);
            return new DataResponse<BlogWrapper>(true, "Delete Sukses");
        } catch (Exception e) {
            return new DataResponse<BlogWrapper>(false, "User tidak ditemukan: " + id);
        }
    }
}
