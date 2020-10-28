package com.giao.ssm.test;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @program: oracle-ssm
 * @description
 * @author: 影耀子（YingYew）
 * @create: 2020-09-28 23:44
 **/
public class PoiTest {

    @Test
    public void testHSSF_base() throws IOException {
        /*
         * 开发步骤：
         * 1、创建一个工作簿
         * 2、创建一个工作表
         * 3、创建一个行对象
         * 4、创建一个单元格对象，指定它的列
         * 5、给单元格设置内容
         * 6、样式进行修饰（跳过）
         * 7、保存，写文件
         * 8、关闭对象
         */
        Workbook wb = new HSSFWorkbook();
        Sheet sheet = wb.createSheet();
        Row nRow = sheet.createRow(7);			//第八行
        Cell nCell = nRow.createCell(4);		//第五列

        nCell.setCellValue("厚溥IT百家强！");

        OutputStream os = new FileOutputStream("D:\\Intellij-IDEA\\POI\\testpoi.xls");	//excel 2003
        wb.write(os);
        os.flush();
        os.close();
    }

    //带样式的
    @Test
    public void testHSSF_base2() throws IOException{

        Workbook wb = new HSSFWorkbook();
        Sheet sheet = wb.createSheet();
        Row nRow = sheet.createRow(15);			//第16行
        Cell nCell = nRow.createCell(10);		//第11列

        nCell.setCellValue("厚溥IT百家强！");

        //创建单元格样式
        CellStyle cellStyle=wb.createCellStyle();
        //创建一个字体对象
        Font font=wb.createFont();
        //设置字体
        font.setFontName("微软雅黑");
        //设置字体大小
        font.setFontHeightInPoints((short)26);

        //添加到样式
        cellStyle.setFont(font);
        nCell.setCellStyle(cellStyle);

        //再创建一个单元格
        nRow = sheet.createRow(16);			//第17行
        nCell = nRow.createCell(11);		//第12列

        nCell.setCellValue("百年企业");

        //给该单元格设置新样式
        CellStyle cellStyle2=wb.createCellStyle();
        Font font2=wb.createFont();
        font2.setFontName("华文彩云");
        font2.setFontHeightInPoints((short)13);
        cellStyle2.setFont(font2);
        nCell.setCellStyle(cellStyle2);


        OutputStream os = new FileOutputStream("D:\\Intellij-IDEA\\POI\\testpoi.xls");	//excel 2003
        wb.write(os);

        os.flush();
        os.close();
    }
    //带样式的(方法版)
    @Test
    public void testHSSF_base2ByMethod() throws IOException {

        Workbook wb = new HSSFWorkbook();
        Sheet sheet = wb.createSheet();
        Row nRow = sheet.createRow(15); // 第16行
        Cell nCell = nRow.createCell(10); // 第11列

        nCell.setCellValue("厚溥IT百家强！");

        CellStyle cellStyle = wb.createCellStyle();
        Font font = wb.createFont();

        //添加到样式(调用样式1方法)
        nCell.setCellStyle(this.style1(wb, cellStyle, font));

        // 再创建一个单元格
        nRow = sheet.createRow(16); // 第17行
        nCell = nRow.createCell(11); // 第12列

        nCell.setCellValue("百年企业");

        //给该单元格设置新样式（调用方法2）
        CellStyle cellStyle2 = wb.createCellStyle();
        Font font2 = wb.createFont();
        nCell.setCellStyle(this.style2(wb, cellStyle2, font2));
        OutputStream os = new FileOutputStream("D:\\Intellij-IDEA\\POI\\testpoi2.xls"); // excel2003

        wb.write(os);

        os.flush();
        os.close();
    }

    //定义样式1
    public CellStyle style1(Workbook wb,CellStyle cellStyle,Font font){
        // 设置字体
        font.setFontName("微软雅黑");
        // 设置字体大小
        font.setFontHeightInPoints((short) 26);

        cellStyle.setFont(font);//绑定字体

        return cellStyle;
    }

    //定义样式2
    public CellStyle style2(Workbook wb, CellStyle cellStyle, Font font) {
        // 设置字体
        font.setFontName("华文彩云");
        // 设置字体大小
        font.setFontHeightInPoints((short)13);

        cellStyle.setFont(font);// 绑定字体

        return cellStyle;
    }
}
