package com.demo.mybatisplus.service;

import com.demo.mybatisplus.entity.Area;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author huangjian
 * @version 1.0
 * @date: 2019年06月02日
 * @description: TODO
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaServiceTest {

    @Autowired
    AreaService areaService;

    /*@Test
    public void test(){
        File provinces = new File("C:\\Users\\huangjian\\Desktop\\provinces.xlsx");
        File city = new File("C:\\Users\\huangjian\\Desktop\\city.xlsx");
        File areas = new File("C:\\Users\\huangjian\\Desktop\\areas.xlsx");
        File streets = new File("C:\\Users\\huangjian\\Desktop\\streets.xlsx");
        File villages = new File("C:\\Users\\huangjian\\Desktop\\villages.xlsx");
        readExcel(provinces);
        System.out.println("------------------------------------11111111111111-------------------------------------------");
        readExcel(city);
        System.out.println("------------------------------------2222222222222222-------------------------------------------");
        readExcel(areas);
        System.out.println("------------------------------------33333333333333-------------------------------------------");
        readExcel(streets);
        System.out.println("------------------------------------444444444444444-------------------------------------------");
        readExcel(villages);
    }*/

    // 去读Excel的方法readExcel，该方法的入口参数为一个File对象
    /*public void readExcel(File file){
        try {
            List<Area> list = new ArrayList<>();

            FileInputStream fileIn = new FileInputStream(file.getAbsolutePath());
            //根据指定的文件输入流导入Excel从而产生Workbook对象
            Workbook wb0 = new XSSFWorkbook(fileIn);
            //获取Excel文档中的第一个表单
            Sheet sht0 = wb0.getSheetAt(0);
            //对Sheet中的每一行进行迭代
            for (Row r : sht0) {
                //如果当前行的行号（从0开始）未达到2（第三行）则从新循环
                if (r.getRowNum() < 1) {
                    continue;
                }
                //r.cell
                //创建实体类
                Area area = new Area();
                area.setCode(r.getCell(0).getStringCellValue());
                area.setName(r.getCell(1).getStringCellValue());
                if(r.getCell(2) != null){
                    area.setProvinceCode(r.getCell(2).getStringCellValue());
                }
                if(r.getCell(3) != null){
                    area.setCityCode(r.getCell(3).getStringCellValue());
                }
                if(r.getCell(4) != null){
                    area.setAreaCode(r.getCell(4).getStringCellValue());
                }
                if(r.getCell(5) != null){
                    area.setStreetCode(r.getCell(5).getStringCellValue());
                }
                list.add(area);
                if(list.size() >= 1000){
                    areaService.saveBatch(list);
                    System.out.println("当前第: " + r.getRowNum());
                    list.clear();
                }
                //areaService.save(area);
            }
            fileIn.close();

            if(list.size() >= 1){
                areaService.saveBatch(list);
                System.out.println("最后数据: " + list.size());
                list.clear();
            }
        } catch (

        FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

}