package com.lxy.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class DemoData {
    //设置excel表头名称
    @ExcelProperty(value = "学生编号", index = 0)
    private Integer sno;
    @ExcelProperty(value = "学生姓名", index = 1)
    private String sname;
}
