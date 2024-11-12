package com.ruoyi.party.building.record.service.impl;

import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.web.controller.module.record.domain.Record;
import com.ruoyi.web.controller.module.record.mapper.RecordMapper;
import com.ruoyi.web.controller.module.record.service.IRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 会议记录Service业务层处理
 *
 * @author ruoyi
 * @date 2020-05-09
 */
@Service
public class RecordServiceImpl implements IRecordService {
    @Autowired
    private RecordMapper recordMapper;

    /**
     * 查询会议记录
     *
     * @param recordId 会议记录ID
     * @return 会议记录
     */
    @Override
    public Record selectRecordById(Long recordId) {
        return recordMapper.selectRecordById(recordId);
    }

    /**
     * 查询会议记录列表
     *
     * @param record 会议记录
     * @return 会议记录
     */
    @Override
    @DataScope(deptAlias = "r")
    public List<Record> selectRecordList(Record record) {
        return recordMapper.selectRecordList(record);
    }

    /**
     * 新增会议记录
     *
     * @param record 会议记录
     * @return 结果
     */
    @Override
    public int insertRecord(Record record) {
        //record.setCreateBy(ShiroUtils.getLoginName());
        record.setCreateTime(DateUtils.getNowDate());
        return recordMapper.insertRecord(record);
    }

    /**
     * 修改会议记录
     *
     * @param record 会议记录
     * @return 结果
     */
    @Override
    public int updateRecord(Record record) {
        record.setUpdateBy(ShiroUtils.getLoginName());
        record.setUpdateTime(DateUtils.getNowDate());
        return recordMapper.updateRecord(record);
    }

    /**
     * 删除会议记录对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteRecordByIds(String ids) {
        return recordMapper.deleteRecordByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除会议记录信息
     *
     * @param recordId 会议记录ID
     * @return 结果
     */
    @Override
    public int deleteRecordById(Long recordId) {
        return recordMapper.deleteRecordById(recordId);
    }
}
