package com.oa.commons;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import com.oa.pojo.Duty;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;

/**
 * 基于poi用java操作excel数据的工具类
 */
public class ExcelOperate {

    public static void main(String[] args) {
        // 创建Excel表格
//        createExcel(getStudent());

        // 读取Excel表格
     // List<Student> list = readExcel();
       // System.out.println(list.toString());
    }

    /**
     * 初始化数据
     * 
     * @return 数据
     */
    private static List<Student> getStudent() {
        List<Student> list = new ArrayList<Student>();
        Student student1 = new Student("小明", 8, "二年级");
        Student student2 = new Student("小光", 9, "三年级");
        Student student3 = new Student("小花", 10, "四年级");
        list.add(student1);
        list.add(student2);
        list.add(student3);
        return list;
    }

    /**
     * 创建Excel
     * 
     * @param list
     *            数据
     */
    public static void createExcel(List<Duty> list) {
        // 创建一个Excel文件
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 创建一个Excel文件中的一个工作表
        HSSFSheet sheet = workbook.createSheet("5月");
        //合并表格（合并第一行的第一列到第三列为一个格子）
        CellRangeAddress region = new CellRangeAddress(
                0, // 行起始：第一行
                0, // 行结束：第一行
                0, // 列起始：第一列
                5  // 列结束：第6列
        );
        sheet.addMergedRegion(region);
        
        HSSFRow hssfRow = sheet.createRow(0);
        HSSFCell headCell = hssfRow.createCell(0);
        headCell.setCellValue("企业5月的考勤数据");  //第一行的表描述信息
        
        // 设置单元格格式居中
        HSSFCellStyle cellStyle = workbook.createCellStyle();
    	cellStyle.setAlignment(HorizontalAlignment.CENTER);  //所有的单元格居中对齐
        headCell.setCellStyle(cellStyle);
        
//表头每列的描述信息        
        // 添加表头行
        hssfRow = sheet.createRow(1);
        // 添加表头内容
        headCell = hssfRow.createCell(0);  //列号，从0开始计数
        headCell.setCellValue("用户名");
        headCell.setCellStyle(cellStyle);

        headCell = hssfRow.createCell(1);
        headCell.setCellValue("真实姓名");
        headCell.setCellStyle(cellStyle);

        headCell = hssfRow.createCell(2);
        headCell.setCellValue("所属部门");
        headCell.setCellStyle(cellStyle);

        headCell = hssfRow.createCell(3);
        headCell.setCellValue("出勤日期");
        headCell.setCellStyle(cellStyle);
        headCell = hssfRow.createCell(4);
        headCell.setCellValue("签到时间");
        headCell.setCellStyle(cellStyle);
        headCell = hssfRow.createCell(5);
        headCell.setCellValue("签退时间");

        headCell.setCellStyle(cellStyle);
        // 添加数据内容;行数是list.size()的值
        for (int i = 0; i < list.size(); i++) {
            hssfRow = sheet.createRow((int) i + 2);
            Duty duty = list.get(i);

            // 创建行单元格，并设置值
            HSSFCell cell = hssfRow.createCell(0); //行号，从0开始计数，0表示第一行
            //往数据信息行的第一行第一列放入数据
            cell.setCellValue(duty.getEmprid());
            cell.setCellStyle(cellStyle);
            //往数据信息行的第一行第二列放入数据
            cell = hssfRow.createCell(1);
            cell.setCellValue(duty.getEmployee().getRealname());
            cell.setCellStyle(cellStyle);
            //往数据信息行的第一行第三列放入数据
            cell = hssfRow.createCell(2);
            cell.setCellValue(duty.getDept().getDeptname());
            cell.setCellStyle(cellStyle);

            //往数据信息行的第一行第四列放入数据
            cell = hssfRow.createCell(3);
            cell.setCellValue(duty.getSdtdate());
            cell.setCellStyle(cellStyle);
            //往数据信息行的第一行第四列放入数据
            cell = hssfRow.createCell(4);
            cell.setCellValue(duty.getSignintime());
            cell.setCellStyle(cellStyle);
            //往数据信息行的第一行第四列放入数据
            cell = hssfRow.createCell(5);
            cell.setCellValue(duty.getSignouttime());
            cell.setCellStyle(cellStyle);
        }

        // 保存Excel文件
        try {
            //动态获取windows的桌面路径(保存excel表到windows系统的桌面)
            javax.swing.filechooser.FileSystemView fsv = javax.swing.filechooser.FileSystemView.getFileSystemView();
            String deskPath = fsv.getHomeDirectory().getAbsolutePath();
            Path path = new File(deskPath+"/"+System.currentTimeMillis()+"-duty.xlsx").toPath();
            OutputStream outputStream = new FileOutputStream(path.toString());
            workbook.write(outputStream);
            outputStream.close(); //关流
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取Excel
     *
     * @return 数据集合
     */
    private static List<Student> readExcel() {
        List<Student> list = new ArrayList<Student>();
        HSSFWorkbook workbook = null;

        try {
            // 读取Excel文件
            InputStream inputStream = new FileInputStream("D:/students.xls");
            workbook = new HSSFWorkbook(inputStream);
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 循环工作表
        for (int numSheet = 0; numSheet < workbook.getNumberOfSheets(); numSheet++) {
            HSSFSheet hssfSheet = workbook.getSheetAt(numSheet);
            if (hssfSheet == null) {
                continue;
            }
            // 循环行
            for (int rowNum = 2; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                if (hssfRow == null) {
                    continue;
                }

                // 将单元格中的内容存入集合
                Student student = new Student();

                HSSFCell cell = hssfRow.getCell(0);
                if (cell == null) {
                    continue;
                }
                student.setName(cell.getStringCellValue());

                cell = hssfRow.getCell(1);
                if (cell == null) {
                    continue;
                }
                student.setAge((int) cell.getNumericCellValue());

                cell = hssfRow.getCell(2);
                if (cell == null) {
                    continue;
                }
                student.setGrade(cell.getStringCellValue());

                list.add(student);
            }
        }
        return list;
    }
}



class Student {

    private String name;
    private int age;
    private String grade;

    public Student() {
    }

    public Student(String name, int age, String grade) {
        super();
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + ", grade=" + grade
                + "]";
    }
}