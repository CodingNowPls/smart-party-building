package com.ruoyi.web.controller.module.exchange.service.impl;

import java.util.List;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;

import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.web.controller.module.exchange.service.IExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.web.controller.module.exchange.mapper.ExchangeMapper;
import com.ruoyi.web.controller.module.exchange.domain.Exchange;


/**
 * 交流Service业务层处理
 *
 * @author ruoyi
 * @date 2020-05-08
 */
@Service
public class ExchangeServiceImpl implements IExchangeService {
    @Autowired
    private ExchangeMapper exchangeMapper;

    /**
     * 查询交流
     *
     * @param exchangeId 交流ID
     * @return 交流
     */
    @Override
    public Exchange selectExchangeById(Long exchangeId) {
        return exchangeMapper.selectExchangeById(exchangeId);
    }

    /**
     * 查询交流列表
     *
     * @param exchange 交流
     * @return 交流
     */
    @Override
    public List<Exchange> selectExchangeList(Exchange exchange) {
        return exchangeMapper.selectExchangeList(exchange);
    }

    /**
     * 新增交流
     *
     * @param exchange 交流
     * @return 结果
     */
    @Override
    public int insertExchange(Exchange exchange) {
        exchange.setCreateBy(ShiroUtils.getLoginName());
        exchange.setCreateTime(DateUtils.getNowDate());
        return exchangeMapper.insertExchange(exchange);
    }

    /**
     * 修改交流
     *
     * @param exchange 交流
     * @return 结果
     */
    @Override
    public int updateExchange(Exchange exchange) {
        exchange.setUpdateBy(ShiroUtils.getLoginName());
        exchange.setUpdateTime(DateUtils.getNowDate());
        return exchangeMapper.updateExchange(exchange);
    }

    /**
     * 删除交流对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteExchangeByIds(String ids) {
        return exchangeMapper.deleteExchangeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除交流信息
     *
     * @param exchangeId 交流ID
     * @return 结果
     */
    @Override
    public int deleteExchangeById(Long exchangeId) {
        return exchangeMapper.deleteExchangeById(exchangeId);
    }
}
