package cn.bdqn.utils;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import cn.bdqn.sys.controller.AsAccountController;
import cn.bdqn.sys.controller.AsAccountdetailController;
import cn.bdqn.sys.controller.AsKeywordsController;
import cn.bdqn.sys.entity.AsAccountdetail;
import cn.bdqn.sys.service.IAsAccountService;
import cn.bdqn.sys.service.IAsAccountdetailService;
import cn.bdqn.sys.service.IAsKeywordsService;
import cn.bdqn.sys.vo.AsAccountAll;
import cn.bdqn.sys.vo.AsAccountdetailAll;
import cn.bdqn.sys.vo.procteds;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/excel")
public class ExcelController {
	@Autowired
	private IAsKeywordsService iAsKeywordsService;
	@Autowired
	private IAsAccountdetailService adetailService;
	@Autowired
	private IAsAccountService iAsAccountService ;
    //创建表头
    private void createTitle(HSSFWorkbook workbook,HSSFSheet sheet,int reportType){
        HSSFRow row = sheet.createRow(0);
        //设置列宽，setColumnWidth的第二个参数要乘以256，这个参数的单位是1/256个字符宽度
        sheet.setColumnWidth(1,12*256);
        sheet.setColumnWidth(3,17*256);

        //设置为居中加粗
        HSSFCellStyle style = workbook.createCellStyle();
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        style.setFont(font);
        HSSFCell cell;
        if (reportType == 1) {
        	cell = row.createCell(0);
	        cell.setCellValue("序号");
	        cell.setCellStyle(style);


	        cell = row.createCell(1);
	        cell.setCellValue("代理商名称");
	        cell.setCellStyle(style);
	        
	        cell = row.createCell(1);
	        cell.setCellValue("账户余额");
	        cell.setCellStyle(style);
			
		} else if (reportType == 2 || reportType == 3) {
			cell = row.createCell(0);
	        cell.setCellValue("序号");
	        cell.setCellStyle(style);


	        cell = row.createCell(1);
	        cell.setCellValue("代理商名称");
	        cell.setCellStyle(style);

	        cell = row.createCell(2);
	        cell.setCellValue("预付款");
	        cell.setCellStyle(style);

	        cell = row.createCell(3);
	        cell.setCellValue("备注信息");
	        cell.setCellStyle(style);
	        
	        cell = row.createCell(4);
	        cell.setCellValue("时间");
	        cell.setCellStyle(style);
		} else if (reportType == 4) {
			  cell = row.createCell(0);
		        cell.setCellValue("序号");
		        cell.setCellStyle(style);


		        cell = row.createCell(1);
		        cell.setCellValue("产品分类名称");
		        cell.setCellStyle(style);

		        cell = row.createCell(2);
		        cell.setCellValue("数量");
		        cell.setCellStyle(style);

		        cell = row.createCell(3);
		        cell.setCellValue("价格");
		        cell.setCellStyle(style);
		}
       
        
    }

    //生成user表excel
    @GetMapping(value = "/getUser")
    public String getUser(HttpServletResponse response,int reportType) throws Exception{
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("统计表");
        
       
        //设置日期格式
        HSSFCellStyle style = workbook.createCellStyle();
        style.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy h:mm"));
		if (reportType == 1) {
			  createTitle(workbook,sheet,1);
			  List<AsAccountAll> list=iAsAccountService.getAsAccountList();
			
			int rowNum=1;
	        for(AsAccountAll as:list){
	            HSSFRow row = sheet.createRow(rowNum);
	            row.createCell(0).setCellValue(as.getId());
	            row.createCell(1).setCellValue(as.getUserName());
	            HSSFCell cell = row.createCell(2);
	            cell.setCellValue(as.getMoney().toString());
	            cell.setCellStyle(style);
	            rowNum++;
	        }
		} else if (reportType == 2 || reportType == 3) {
			List<AsAccountdetailAll> list=adetailService.getasAccountdetailList( null, null );

			  int rowNum=1;
		        for(AsAccountdetailAll as:list){
		            HSSFRow row = sheet.createRow(rowNum);
		            row.createCell(0).setCellValue(as.getId());
		            row.createCell(1).setCellValue(as.getUserName());
		            row.createCell(2).setCellValue(as.getAccountMoney().toString());
		            row.createCell(3).setCellValue(as.getMoney().toString());
		            row.createCell(4).setCellValue(as.getMemo());
		            HSSFCell cell = row.createCell(5);
		            cell.setCellValue(String.valueOf(as.getDetailDateTime().toString()));
		            cell.setCellStyle(style);
		            rowNum++;
		        }
		} else if (reportType == 4) {
			List<procteds>list=iAsKeywordsService.priductsList();
			 
			  int rowNum=1;
		        for(procteds as:list){
		            HSSFRow row = sheet.createRow(rowNum);
		            row.createCell(0).setCellValue(rowNum);//?
		            row.createCell(1).setCellValue(as.getConfigTypeName());
		            row.createCell(2).setCellValue(as.getNumber());
		            HSSFCell cell = row.createCell(3);
		            cell.setCellValue(String.valueOf(as.getPrice()));
		            cell.setCellStyle(style);
		            rowNum++;
		        }
		}
        //新增数据行，并且设置单元格数据
       

        String fileName = "导出excel例子.xls";

        //生成excel文件
        buildExcelFile(fileName, workbook);

        //浏览器下载excel
        buildExcelDocument(fileName,workbook,response);

        return "download excel";
    }
    

 
    //生成excel文件
    protected void buildExcelFile(String filename,HSSFWorkbook workbook) throws Exception{
        FileOutputStream fos = new FileOutputStream(filename);
        workbook.write(fos);
        fos.flush();
        fos.close();
    }

    //浏览器下载excel
    protected void buildExcelDocument(String filename,HSSFWorkbook workbook,HttpServletResponse response) throws Exception{
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(filename, "utf-8"));
        OutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        outputStream.flush();
        outputStream.close();
    }
    @RequestMapping("/downloadPdf")
    public void downloadPdf(HttpServletRequest request, HttpServletResponse response,int reportType) throws Exception {
      // 告诉浏览器用什么软件可以打开此文件
      response.setHeader("content-Type", "application/pdf");
      // 下载文件的默认名称
      response.setHeader("Content-Disposition", "attachment;filename=user.pdf");
   
      Document document = new Document();
      PdfWriter.getInstance(document, response.getOutputStream());
      document.open();
      /*List<User> list = userRepository.findAll();*/
      if (reportType == 1) {
    	  List<AsAccountAll> list=iAsAccountService.getAsAccountList();
		PdfPTable table1 = new PdfPTable(3);
	      PdfPCell cell1 = new PdfPCell();
	      for (AsAccountAll as : list) {
	        PdfPTable table = new PdfPTable(3);
	        PdfPCell cell = new PdfPCell();
	        cell.setPhrase(new Paragraph(as.getId()+""));
	        table.addCell(cell);
	        document.add(table);
	   
	        cell = new PdfPCell();
	        cell.setPhrase(new Paragraph(as.getUserName()));
	        table.addCell(cell);
	        document.add(table);
	        
	        cell = new PdfPCell();
	        cell.setPhrase(new Paragraph(as.getMoney().toString()));
	        table.addCell(cell);
	        document.add(table);
	      }
       
	} else if (reportType == 2 || reportType == 3) {
		
		List<AsAccountdetailAll> list=adetailService.getasAccountdetailList( null, null );

			PdfPTable table1 = new PdfPTable(6);
		      PdfPCell cell1 = new PdfPCell();
		      for (AsAccountdetailAll as : list) {
		        PdfPTable table = new PdfPTable(6);
		        PdfPCell cell = new PdfPCell();
		        cell.setPhrase(new Paragraph(as.getId()+""));
		        table.addCell(cell);
		        document.add(table);
		   
		        cell = new PdfPCell();
		        cell.setPhrase(new Paragraph(as.getUserName()));
		        table.addCell(cell);
		        document.add(table);
		        
		        cell = new PdfPCell();
		        cell.setPhrase(new Paragraph(as.getAccountMoney().toString()));
		        table.addCell(cell);
		        document.add(table);
		        
		        cell = new PdfPCell();
		        cell.setPhrase(new Paragraph(as.getMoney().toString()));
		        table.addCell(cell);
		        document.add(table);
		        
		        cell = new PdfPCell();
		        cell.setPhrase(new Paragraph(as.getMemo()));
		        table.addCell(cell);
		        document.add(table);
		        
		        cell = new PdfPCell();
		        cell.setPhrase(new Paragraph(as.getDetailDateTime().toString()));
		        table.addCell(cell);
		        document.add(table);
		      }
	       
	} else if (reportType == 4) {
		List<procteds>list=iAsKeywordsService.priductsList();
		  PdfPTable table1 = new PdfPTable(3);
	      PdfPCell cell1 = new PdfPCell();
	      for (procteds as : list) {
	        PdfPTable table = new PdfPTable(3);
	        PdfPCell cell = new PdfPCell();
	        cell.setPhrase(new Paragraph(as.getConfigTypeName()+""));
	        table.addCell(cell);
	        document.add(table);
	   
	        cell = new PdfPCell();
	        cell.setPhrase(new Paragraph(as.getNumber()));
	        table.addCell(cell);
	        document.add(table);
	        
	        cell = new PdfPCell();
	        cell.setPhrase(new Paragraph(String.valueOf(as.getPrice())));
	        table.addCell(cell);
	        document.add(table);
	      }
		  
	};
      
      document.close();
    }

}