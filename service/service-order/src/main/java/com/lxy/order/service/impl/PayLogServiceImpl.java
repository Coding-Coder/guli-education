package com.lxy.order.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.wxpay.sdk.WXPayUtil;
import com.lxy.order.entity.Order;
import com.lxy.order.entity.PayLog;
import com.lxy.order.mapper.PayLogMapper;
import com.lxy.order.service.OrderService;
import com.lxy.order.service.PayLogService;
import com.lxy.order.utils.HttpClient;
import com.lxy.servicebase.exceptionhandler.GuliException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 支付日志表 服务实现类
 * </p>
 *
 * @author lxy
 * @since 2021-06-16
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class PayLogServiceImpl extends ServiceImpl<PayLogMapper, PayLog> implements PayLogService {
    @Autowired
    private OrderService orderService;

    //生成微信支付二维码接口
    @Override
    public Map<String, Object> createNative(String orderNo) {
        try {
            //1 根据订单号查询订单信息
            QueryWrapper<Order> wrapper = new QueryWrapper<>();
            wrapper.eq("order_no", orderNo);
            Order order = orderService.getOne(wrapper);

            //2 使用map设置生成二维码需要参数
            Map<String, String> params = new HashMap<>();
            params.put("appid", "wx74862e0dfcf69954");//关联的公众号appid
            params.put("mch_id", "1558950191");//商户号
            params.put("nonce_str", WXPayUtil.generateNonceStr());//用微信的工具类生成随机的字符串
            params.put("body", order.getCourseTitle()); //课程标题
            params.put("out_trade_no", orderNo); //唯一标识：使用的订单号
            params.put("total_fee", order.getTotalFee().multiply(new BigDecimal("100")).longValue() + "");//价格
            params.put("spbill_create_ip", "127.0.0.1");
            params.put("notify_url", "http://guli.shop/api/order/weixinPay/weixinNotify");//回调地址
            params.put("trade_type", "NATIVE");//支付的类型

            //3 发送httpclient请求，传递参数xml格式，微信支付提供的固定的地址
            HttpClient client = new HttpClient("https://api.mch.weixin.qq.com/pay/unifiedorder");
            //设置xml格式的参数
            client.setXmlParam(WXPayUtil.generateSignedXml(params, "T6m9iK73b0kn9g5v426MKfHQH7X8rKwb"));//商户key
            client.setHttps(true);//使用https(微信的固定地址是https形式的)
            //执行post请求发送
            client.post();

            //4 得到发送请求返回结果
            //返回内容，是使用xml格式返回
            String xml = client.getContent();

            //把xml格式转换map集合，把map集合返回
            Map<String, String> resultMap = WXPayUtil.xmlToMap(xml);

            //最终返回数据 的封装
            Map<String, Object> result = new HashMap<>();
            result.put("out_trade_no", orderNo);
            result.put("course_id", order.getCourseId());
            result.put("total_fee", order.getTotalFee());
            result.put("result_code", resultMap.get("result_code"));//返回二维码操作状态码
            result.put("code_url", resultMap.get("code_url"));//二维码地址
            return result;
        } catch (Exception e) {
            throw new GuliException(20001, "生成微信支付二维码失败");
        }
    }

    //查询订单支付状态
    @Override
    public Map<String, String> queryPayStatus(String orderNo) {
        try {
            //1、封装参数
            Map<String, String> params = new HashMap<>();
            params.put("appid", "wx74862e0dfcf69954");
            params.put("mch_id", "1558950191");
            params.put("out_trade_no", orderNo);
            params.put("nonce_str", WXPayUtil.generateNonceStr());

            //2 发送httpclient
            HttpClient client = new HttpClient("https://api.mch.weixin.qq.com/pay/orderquery");
            client.setXmlParam(WXPayUtil.generateSignedXml(params, "T6m9iK73b0kn9g5v426MKfHQH7X8rKwb"));
            client.setHttps(true);
            client.post();

            //3 得到请求返回内容
            String xml = client.getContent();
            //6、转成Map再返回
            return WXPayUtil.xmlToMap(xml);
        } catch (Exception e) {
            throw new GuliException(20001, "查询订单支付信息失败");
        }
    }

    //添加支付记录和更新订单状态
    @Override
    public void updateOrdersStatus(Map<String, String> map) {
        //从map获取订单号
        String orderNo = map.get("out_trade_no");
        //根据订单号查询订单信息
        QueryWrapper<Order> wrapper = new QueryWrapper<>();
        wrapper.eq("order_no", orderNo);
        Order order = orderService.getOne(wrapper);

        //更新订单表订单状态
        if (order.getStatus() == 1) {
            return;
        }
        order.setStatus(1);//1:代表已经支付
        orderService.updateById(order);

        //向支付表添加支付记录
        PayLog payLog = new PayLog();
        payLog.setOrderNo(orderNo);  //订单号
        payLog.setPayTime(new Date()); //订单完成时间
        payLog.setPayType(1);//支付类型 1:微信
        payLog.setTotalFee(order.getTotalFee());//总金额(分)
        payLog.setTradeState(map.get("trade_state"));//支付状态
        payLog.setTransactionId(map.get("transaction_id")); //流水号
        payLog.setAttr(JSONObject.toJSONString(map));

        baseMapper.insert(payLog);
    }
}
