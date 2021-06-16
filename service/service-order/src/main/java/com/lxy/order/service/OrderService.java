package com.lxy.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lxy.order.entity.Order;

/**
 * <p>
 * 订单 服务类
 * </p>
 *
 * @author lxy
 * @since 2021-06-16
 */
public interface OrderService extends IService<Order> {

    //1 生成订单的方法
    String createOrders(String courseId, String memberId);
}
