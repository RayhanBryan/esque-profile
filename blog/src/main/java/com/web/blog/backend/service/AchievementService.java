package com.web.blog.backend.service;

import com.web.blog.backend.entity.Achievements;
import com.web.blog.backend.entity.Blog;
import com.web.blog.backend.exception.BusinessException;
import com.web.blog.backend.repository.AchievementRepository;
import com.web.blog.backend.util.PaginationList;
import com.web.blog.backend.wrapper.AchievementWrapper;
import com.web.blog.backend.wrapper.BlogWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AchievementService {

    @Autowired
    AchievementRepository achievementRepository;
    private Achievements toEntity(AchievementWrapper wrapper) {
        Achievements entity = new Achievements();
        if (wrapper.getAchievementId() != null) {
            entity = achievementRepository.getById(wrapper.getAchievementId());
        }
        entity.setUrl(wrapper.getUrl());
        entity.setTitle(wrapper.getTitle());
        entity.setTextAchievement(wrapper.getTextAchievement());
        return entity;
    }

    private AchievementWrapper toWrapper(Achievements entity) {
        AchievementWrapper wrapper = new AchievementWrapper();
        wrapper.setAchievementId(entity.getAchievementId());
        wrapper.setUrl(entity.getUrl());
        wrapper.setTitle(entity.getTitle());
        wrapper.setTextAchievement(entity.getTextAchievement());
        return wrapper;
    }

    private List<AchievementWrapper> toWrapperList(List<Achievements> entityList) {
        List<AchievementWrapper> wrapperList = new ArrayList<AchievementWrapper>();
        for (Achievements entity : entityList) {
            wrapperList.add(toWrapper(entity));
        }
        return wrapperList;
    }

    private PaginationList<AchievementWrapper, Achievements> toPaginationList(Page<Achievements> entityPage) {
        List<Achievements> entityList = entityPage.getContent();
        List<AchievementWrapper> wrapperList = toWrapperList(entityList);
        PaginationList<AchievementWrapper, Achievements> paginationList = new PaginationList<>(wrapperList, entityPage);
        return paginationList;
    }

    // Retrieve list of data
    public List<AchievementWrapper> findAll() {
        List<Achievements> blogList = achievementRepository.findAll();
        return toWrapperList(blogList);
    }
    public List<AchievementWrapper> findAllOrderBy(){
        List<Achievements> blogList = achievementRepository.findAllByOrderByAchievementIdDesc();
        return toWrapperList(blogList);
    }

    // Retrieve single data
    public AchievementWrapper getAchievementId(Long AchievementId) {
        return toWrapper(achievementRepository.findById(AchievementId).get());
    }

    // Retrieve list of data with pagination
    public PaginationList<AchievementWrapper, Achievements> findAllWithPagination(int page,
                                                                   int size) {
        return toPaginationList(achievementRepository.findAll(PageRequest.of(page, size)));
    }

    // Create and Update
    public AchievementWrapper save(AchievementWrapper wrapper) {
        return toWrapper(achievementRepository.save(toEntity(wrapper)));
    }

    // Delete
    public void delete(Long id) {
        if (id == null)
            throw new BusinessException("Id cannot be null");
        achievementRepository.deleteById(id);
    }
}
