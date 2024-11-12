package com.ruoyi.web.controller.module.record.service;

import java.util.List;

import com.ruoyi.web.controller.module.record.domain.Record;

/**
 * 会议记录Service接口
 *
 * @author ruoyi
 * @date 2020-05-09
 */
public interface IRecordService {
    /**
     * 查询会议记录
     *
     * @param recordId 会议记录ID
     * @return 会议记录
     */
    public Record selectRecordById(Long recordId);

    /**
     * 查询会议记录列表
     *
     * @param record 会议记录
     * @return 会议记录集合
     */
    public List<Record> selectRecordList(Record record);

    /**
     * 新增会议记录
     *
     * @param record 会议记录
     * @return 结果
     */
    public int insertRecord(Record record);

    /**
     * 修改会议记录
     *
     * @param record 会议记录
     * @return 结果
     */
    public int updateRecord(Record record);

    /**
     * 批量删除会议记录
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteRecordByIds(String ids);

    /**
     * 删除会议记录信息
     *
     * @param recordId 会议记录ID
     * @return 结果
     */
    public int deleteRecordById(Long recordId);
}
