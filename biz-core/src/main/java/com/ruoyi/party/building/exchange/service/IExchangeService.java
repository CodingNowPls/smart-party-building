package com.ruoyi.party.building.exchange.service;

import com.ruoyi.party.building.exchange.domain.Exchange;

import java.util.List;

/**
 * 交流Service接口
 *
 * @author ruoyi
 * @date 2020-05-08
 */
public interface IExchangeService {
    /**
     * 查询交流
     *
     * @param exchangeId 交流ID
     * @return 交流
     */
    public Exchange selectExchangeById(Long exchangeId);

    /**
     * 查询交流列表
     *
     * @param exchange 交流
     * @return 交流集合
     */
    public List<Exchange> selectExchangeList(Exchange exchange);

    /**
     * 新增交流
     *
     * @param exchange 交流
     * @return 结果
     */
    public int insertExchange(Exchange exchange);

    /**
     * 修改交流
     *
     * @param exchange 交流
     * @return 结果
     */
    public int updateExchange(Exchange exchange);

    /**
     * 批量删除交流
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteExchangeByIds(String ids);

    /**
     * 删除交流信息
     *
     * @param exchangeId 交流ID
     * @return 结果
     */
    public int deleteExchangeById(Long exchangeId);
}
