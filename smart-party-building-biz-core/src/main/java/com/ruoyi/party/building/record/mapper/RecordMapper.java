package com.ruoyi.party.building.record.mapper;


import com.ruoyi.party.building.record.domain.Record;

import java.util.List;

/**
 * 会议记录Mapper接口
 *
 * @author ruoyi
 * @date 2020-05-09
 */
public interface RecordMapper {
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
     * 删除会议记录
     *
     * @param recordId 会议记录ID
     * @return 结果
     */
    public int deleteRecordById(Long recordId);

    /**
     * 批量删除会议记录
     *
     * @param recordIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteRecordByIds(String[] recordIds);
}
