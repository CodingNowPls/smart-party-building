package com.ruoyi.party.building.story.mapper;

import com.ruoyi.web.controller.module.story.domain.Story;

import java.util.List;

/**
 * 故事Mapper接口
 *
 * @author ruoyi
 * @date 2020-05-08
 */
public interface StoryMapper {
    /**
     * 查询故事
     *
     * @param storyId 故事ID
     * @return 故事
     */
    public Story selectStoryById(Long storyId);

    /**
     * 查询故事列表
     *
     * @param story 故事
     * @return 故事集合
     */
    public List<Story> selectStoryList(Story story);

    /**
     * 新增故事
     *
     * @param story 故事
     * @return 结果
     */
    public int insertStory(Story story);

    /**
     * 修改故事
     *
     * @param story 故事
     * @return 结果
     */
    public int updateStory(Story story);

    /**
     * 删除故事
     *
     * @param storyId 故事ID
     * @return 结果
     */
    public int deleteStoryById(Long storyId);

    /**
     * 批量删除故事
     *
     * @param storyIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteStoryByIds(String[] storyIds);
}
