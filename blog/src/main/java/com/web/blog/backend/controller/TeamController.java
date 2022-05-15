package com.web.blog.backend.controller;

import com.web.blog.backend.entity.Teams;
import com.web.blog.backend.service.TeamService;
import com.web.blog.backend.util.DataResponse;
import com.web.blog.backend.util.DataResponseList;
import com.web.blog.backend.util.DataResponsePagination;
import com.web.blog.backend.wrapper.TeamWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(path = "/team")
public class TeamController {
    @Autowired
    TeamService teamService;

    // get
    @GetMapping(path = "/findAll")
    public DataResponseList<TeamWrapper> findAll() {
        return new DataResponseList<TeamWrapper>(teamService.findAll());
    }

    @GetMapping(path = "/findAllOrderBy")
    public DataResponseList<TeamWrapper> findAllOrderBy(){return new DataResponseList<>(teamService.findAllOrderBy()); }

    @GetMapping(path = "/findAllPagination")
    public DataResponsePagination<TeamWrapper, Teams> findAllPagination(@RequestParam("page") int page,
                                                                        @RequestParam("size") int size) {
        return new DataResponsePagination<TeamWrapper, Teams>(teamService.findAllWithPagination(page, size));
    }

    @GetMapping(path = "/findById")
    public DataResponse<TeamWrapper> findById(@RequestParam("id") Long id) {
        try {
            TeamWrapper hasil = teamService.getBlogById(id);
            return new DataResponse<TeamWrapper>(hasil);
        } catch (Exception e) {
            return new DataResponse<TeamWrapper>(false, "Blog tidak ditemukan: " + id);
        }

    }

    // post&put
    @PostMapping(path = "/post")
    public DataResponse<TeamWrapper> post(@RequestBody TeamWrapper wrapper) {
        try {
            return new DataResponse<TeamWrapper>(teamService.save(wrapper));
        } catch (Exception e) {
            return new DataResponse<TeamWrapper>(false, "Team tidak ditemukan: " + wrapper.getTeamId());
        }

    }

    @PutMapping(path = "/update")
    public DataResponse<TeamWrapper> update(@RequestBody TeamWrapper wrapper) {
        try {
            return new DataResponse<TeamWrapper>(teamService.save(wrapper));
        } catch (Exception e) {
            return new DataResponse<TeamWrapper>(false, "Blog tidak ditemukan: " + wrapper.getTeamId());
        }
    }


    // delete
    @DeleteMapping(path = "/delete")
    public DataResponse<TeamWrapper> delete(@RequestParam("id") Long id) {
        try {
            teamService.delete(id);
            return new DataResponse<TeamWrapper>(true, "Delete Sukses");
        } catch (Exception e) {
            return new DataResponse<TeamWrapper>(false, "User tidak ditemukan: " + id);
        }
    }
}
