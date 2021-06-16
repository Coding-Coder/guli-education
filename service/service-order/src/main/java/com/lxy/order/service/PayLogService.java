package com.lxy.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lxy.order.entity.PayLog;

import java.util.Map;

/**
 * <p>
 * 支付日志表 服务类
 * </p>
 *
 * @author lxy
 * @since 2021-06-16
 */
public interface PayLogService extends IService<PayLog> {
    //生成微信支付二维码接口
    Map<String, Object> createNative(String orderNo);

    //根据订单号查询订单支付状态
    Map<String, String> queryPayStatus(String orderNo);

    //向支付表添加记录，更新订单状态
    void updateOrdersStatus(Map<String, String> map);
}
