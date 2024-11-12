package com.ruoyi.web.controller.module.exchange.controller;

import java.util.List;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.web.controller.module.exchange.service.IExchangeService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ruoyi.web.controller.module.exchange.domain.Exchange;
import com.ruoyi.web.controller.module.exchange.service.IExchangeService;


import com.ruoyi.common.utils.poi.ExcelUtil;


/**
 * 交流Controller
 *
 * @author ruoyi
 * @date 2020-05-08
 */
@Controller
@RequestMapping("/module/exchange")
public class ExchangeController extends BaseController {
    private String prefix = "module/exchange";

    @Autowired
    private IExchangeService exchangeService;

    @RequiresPermissions("module:exchange:view")
    @GetMapping()
    public String exchange() {
        return prefix + "/exchange";
    }

    /**
     * 查询交流列表
     */
    @RequiresPermissions("module:exchange:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Exchange exchange) {
        startPage();
        List<Exchange> list = exchangeService.selectExchangeList(exchange);
        return getDataTable(list);
    }

    /**
     * 导出交流列表
     */
    @RequiresPermissions("module:exchange:export")
    @Log(title = "交流", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Exchange exchange) {
        List<Exchange> list = exchangeService.selectExchangeList(exchange);
        ExcelUtil<Exchange> util = new ExcelUtil<Exchange>(Exchange.class);
        return util.exportExcel(list, "exchange");
    }

    /**
     * 新增交流
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存交流
     */
    @RequiresPermissions("module:exchange:add")
    @Log(title = "交流", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Exchange exchange) {
        return toAjax(exchangeService.insertExchange(exchange));
    }

    /**
     * 修改交流
     */
    @GetMapping("/edit/{exchangeId}")
    public String edit(@PathVariable("exchangeId") Long exchangeId, ModelMap mmap) {
        Exchange exchange = exchangeService.selectExchangeById(exchangeId);
        mmap.put("exchange", exchange);
        return prefix + "/edit";
    }

    /**
     * 修改保存交流
     */
    @RequiresPermissions("module:exchange:edit")
    @Log(title = "交流", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Exchange exchange) {
        return toAjax(exchangeService.updateExchange(exchange));
    }

    /**
     * 删除交流
     */
    @RequiresPermissions("module:exchange:remove")
    @Log(title = "交流", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(exchangeService.deleteExchangeByIds(ids));
    }

    /**
     * 详情
     *
     * @param exchangeId
     * @param mmap
     * @return
     */
    @GetMapping("/detail/{exchangeId}")
    public String detail(@PathVariable("exchangeId") Long exchangeId, ModelMap mmap) {
        Exchange exchange = exchangeService.selectExchangeById(exchangeId);
        mmap.put("exchange", exchange);
        return prefix + "/detail";
    }
}
