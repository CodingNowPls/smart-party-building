package com.ruoyi.web.controller.module.story.service.impl;

import java.util.List;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;

import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.web.controller.module.story.service.IStoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.web.controller.module.story.mapper.StoryMapper;
import com.ruoyi.web.controller.module.story.domain.Story;


/**
 * 故事Service业务层处理
 *
 * @author ruoyi
 * @date 2020-05-08
 */
@Service
public class StoryServiceImpl implements IStoryService {
    @Autowired
    private StoryMapper storyMapper;

    /**
     * 查询故事
     *
     * @param storyId 故事ID
     * @return 故事
     */
    @Override
    public Story selectStoryById(Long storyId) {
        return storyMapper.selectStoryById(storyId);
    }

    /**
     * 查询故事列表
     *
     * @param story 故事
     * @return 故事
     */
    @Override
    public List<Story> selectStoryList(Story story) {
        return storyMapper.selectStoryList(story);
    }

    /**
     * 新增故事
     *
     * @param story 故事
     * @return 结果
     */
    @Override
    public int insertStory(Story story) {
        story.setCreateBy(ShiroUtils.getLoginName());
        story.setCreateTime(DateUtils.getNowDate());
        return storyMapper.insertStory(story);
    }

    /**
     * 修改故事
     *
     * @param story 故事
     * @return 结果
     */
    @Override
    public int updateStory(Story story) {
        story.setUpdateBy(ShiroUtils.getLoginName());
        story.setUpdateTime(DateUtils.getNowDate());
        return storyMapper.updateStory(story);
    }

    /**
     * 删除故事对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteStoryByIds(String ids) {
        return storyMapper.deleteStoryByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除故事信息
     *
     * @param storyId 故事ID
     * @return 结果
     */
    @Override
    public int deleteStoryById(Long storyId) {
        return storyMapper.deleteStoryById(storyId);
    }
}
