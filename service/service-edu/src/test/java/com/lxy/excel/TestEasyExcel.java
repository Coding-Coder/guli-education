package com.lxy.excel;

import com.alibaba.excel.EasyExcel;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestEasyExcel {

    public static final String FILE_NAME = "F:\\students.xlsx";

    /**
     * 实现excel写的操作
     */
    @Test
    public void writeToExcel() {
        //1 设置写入文件夹地址和excel文件名称
        //2 调用easyexcel里面的方法实现写操作
        //write方法两个参数：第一个参数文件路径名称，第二个参数实体类class
        EasyExcel.write(FILE_NAME, DemoData.class).sheet("学生列表").doWrite(getData());
    }

    //模拟list集合
    private static List<DemoData> getData() {
        List<DemoData> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            DemoData data = new DemoData()
                    .setSno(i)
                    .setSname("lxy" + i);
            list.add(data);
        }
        return list;
    }

    /**
     * 实现excel读操作
     */
    @Test
    public void readFromExcel() {
        EasyExcel.read(FILE_NAME, DemoData.class, new ExcelListener()).sheet().doRead();
    }
}
