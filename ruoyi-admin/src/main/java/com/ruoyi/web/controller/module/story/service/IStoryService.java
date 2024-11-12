package com.ruoyi.web.controller.module.story.service;

import java.util.List;

import com.ruoyi.web.controller.module.story.domain.Story;

/**
 * 故事Service接口
 *
 * @author ruoyi
 * @date 2020-05-08
 */
public interface IStoryService {
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
     * 批量删除故事
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteStoryByIds(String ids);

    /**
     * 删除故事信息
     *
     * @param storyId 故事ID
     * @return 结果
     */
    public int deleteStoryById(Long storyId);
}
