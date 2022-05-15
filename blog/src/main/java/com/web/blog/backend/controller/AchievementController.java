package com.web.blog.backend.controller;

import com.web.blog.backend.entity.Achievements;
import com.web.blog.backend.service.AchievementService;
import com.web.blog.backend.util.DataResponse;
import com.web.blog.backend.util.DataResponseList;
import com.web.blog.backend.util.DataResponsePagination;
import com.web.blog.backend.wrapper.AchievementWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(path = "/achievement")
public class AchievementController {
    @Autowired
    AchievementService achievementService;
    // get
    @GetMapping(path = "/findAll")
    public DataResponseList<AchievementWrapper> findAll() {
        return new DataResponseList<AchievementWrapper>(achievementService.findAll());
    }

    @GetMapping(path = "/findAllOrderBy")
    public DataResponseList<AchievementWrapper> findAllOrderBy(){return new DataResponseList<>(achievementService.findAllOrderBy()); }

    @GetMapping(path = "/findAllPagination")
    public DataResponsePagination<AchievementWrapper, Achievements> findAllPagination(@RequestParam("page") int page,
                                                                                      @RequestParam("size") int size) {
        return new DataResponsePagination<AchievementWrapper, Achievements>(achievementService.findAllWithPagination(page, size));
    }

    @GetMapping(path = "/findById")
    public DataResponse<AchievementWrapper> findById(@RequestParam("id") Long id) {
        try {
            AchievementWrapper hasil = achievementService.getAchievementId(id);
            return new DataResponse<AchievementWrapper>(hasil);
        } catch (Exception e) {
            return new DataResponse<AchievementWrapper>(false, "Blog tidak ditemukan: " + id);
        }

    }

    // post&put
    @PostMapping(path = "/post")
    public DataResponse<AchievementWrapper> post(@RequestBody AchievementWrapper wrapper) {
        try {
            return new DataResponse<AchievementWrapper>(achievementService.save(wrapper));
        } catch (Exception e) {
            return new DataResponse<AchievementWrapper>(false, "Blog tidak ditemukan: " + wrapper.getAchievementId());
        }

    }

    @PutMapping(path = "/update")
    public DataResponse<AchievementWrapper> update(@RequestBody AchievementWrapper wrapper) {
        try {
            return new DataResponse<AchievementWrapper>(achievementService.save(wrapper));
        } catch (Exception e) {
            return new DataResponse<AchievementWrapper>(false, "Blog tidak ditemukan: " + wrapper.getAchievementId());
        }
    }


    // delete
    @DeleteMapping(path = "/delete")
    public DataResponse<AchievementWrapper> delete(@RequestParam("id") Long id) {
        try {
            achievementService.delete(id);
            return new DataResponse<AchievementWrapper>(true, "Delete Sukses");
        } catch (Exception e) {
            return new DataResponse<AchievementWrapper>(false, "User tidak ditemukan: " + id);
        }
    }
}
