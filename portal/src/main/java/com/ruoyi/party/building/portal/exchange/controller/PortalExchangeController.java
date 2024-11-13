package com.ruoyi.party.building.portal.exchange.controller;


import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.party.building.exchange.domain.Exchange;
import com.ruoyi.party.building.exchange.service.IExchangeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 单位交流接口
 *
 * @author : gao
 * @date 2024年11月13日
 * -------------------------------------------<br>
 * <br>
 * <br>
 */
@Api("portal-单位交流接口")
@RestController
@RequestMapping("/api")
public class PortalExchangeController {

    @Autowired
    private IExchangeService exchangeService;


    @ApiOperation("单位交流")
    @GetMapping("/getExchangeList")
    public AjaxResult getExchangeList() {
        List<Exchange> list = exchangeService.selectExchangeList(new Exchange());
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("list", list);
        return ajaxResult;
    }

    @ApiOperation("单位交流详情")
    @GetMapping("/getExchangeInfo")
    public AjaxResult getExchangeInfo(String exchangeId) {
        Exchange exchange = exchangeService.selectExchangeById(Long.valueOf(exchangeId));
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("exchange", exchange);
        return ajaxResult;
    }

}
