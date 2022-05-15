package com.web.blog.backend.service;

import com.web.blog.backend.entity.Teams;
import com.web.blog.backend.exception.BusinessException;
import com.web.blog.backend.repository.TeamRepository;
import com.web.blog.backend.util.PaginationList;
import com.web.blog.backend.wrapper.TeamWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TeamService {
    @Autowired
    TeamRepository teamRepository;
    // util
    private Teams toEntity(TeamWrapper wrapper) {
        Teams entity = new Teams();
        if (wrapper.getTeamId() != null) {
            entity = teamRepository.getById(wrapper.getTeamId());
        }
        entity.setUrl(wrapper.getUrl());
        entity.setTitle(wrapper.getTitle());
        entity.setTextTeam(wrapper.getTextTeam());
        entity.setPosition(wrapper.getPosition());
        return entity;
    }

    private TeamWrapper toWrapper(Teams entity) {
        TeamWrapper wrapper = new TeamWrapper();
        wrapper.setTeamId(entity.getTeamId());
        wrapper.setUrl(entity.getUrl());
        wrapper.setTitle(entity.getTitle());
        wrapper.setTextTeam(entity.getTextTeam());
        wrapper.setPosition(entity.getPosition());
        return wrapper;
    }

    private List<TeamWrapper> toWrapperList(List<Teams> entityList) {
        List<TeamWrapper> wrapperList = new ArrayList<TeamWrapper>();
        for (Teams entity : entityList) {
            wrapperList.add(toWrapper(entity));
        }
        return wrapperList;
    }

    private PaginationList<TeamWrapper, Teams> toPaginationList(Page<Teams> entityPage) {
        List<Teams> entityList = entityPage.getContent();
        List<TeamWrapper> wrapperList = toWrapperList(entityList);
        PaginationList<TeamWrapper, Teams> paginationList = new PaginationList<>(wrapperList, entityPage);
        return paginationList;
    }

    // Retrieve list of data
    public List<TeamWrapper> findAll() {
        List<Teams> blogList = teamRepository.findAll();
        return toWrapperList(blogList);
    }
    public List<TeamWrapper> findAllOrderBy(){
        List<Teams> blogList = teamRepository.findAllByOrderByTeamId();
        return toWrapperList(blogList);
    }

    // Retrieve single data
    public TeamWrapper getBlogById(Long TeamId) {
        return toWrapper(teamRepository.findById(TeamId).get());
    }

    // Retrieve list of data with pagination
    public PaginationList<TeamWrapper, Teams> findAllWithPagination(int page,
                                                                   int size) {
        return toPaginationList(teamRepository.findAll(PageRequest.of(page, size)));
    }

    // Create and Update
    public TeamWrapper save(TeamWrapper wrapper) {
        return toWrapper(teamRepository.save(toEntity(wrapper)));
    }

    // Delete
    public void delete(Long id) {
        if (id == null)
            throw new BusinessException("Id cannot be null");
        teamRepository.deleteById(id);
    }

}
