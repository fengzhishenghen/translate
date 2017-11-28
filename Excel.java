package translate;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import b.excel;

public class Excel {
	private static  Workbook wb;
	private static Sheet sheet;
	
	public Excel(String filepath){
		if(filepath==null){
			return;
		}
		String ext=filepath.split("\\.")[1];
		InputStream is=null;
		try{
			is=new FileInputStream(filepath);
			if("xls".equals(ext)){
				wb=new HSSFWorkbook(is);
			}else if("xlsx".equals(ext)){
				wb=new XSSFWorkbook(is);
			}else{
				wb=null;
			}
		}catch(FileNotFoundException e){
			System.out.println("无此文件");
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try {
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void fanyi(int english,int chinese,String fout){
		Sheet sheet=wb.getSheetAt(0);
		int rowNum=sheet.getLastRowNum();//获得总行数
		for(int j=1;j<=rowNum;j++){
        	Row row=sheet.getRow(j);
        	int colNum = row.getPhysicalNumberOfCells();
            	Cell cell = row.getCell(english);
            	cell.setCellType(Cell.CELL_TYPE_STRING);
                String title = (String)cell.getStringCellValue();
                String s=Utils.translate(title);
                Cell Ce=row.createCell(chinese);
                Ce.setCellValue(s);                                         
        }
		try{
		FileOutputStream excelFileOutPutStream = new FileOutputStream(fout);//写数据到这个路径上  
        wb.write(excelFileOutPutStream);  
        excelFileOutPutStream.flush();  
        excelFileOutPutStream.close();
		}catch(IOException e){
			e.printStackTrace();
		}
        System.out.println("done");  		
	}
	public static void main(String[] args){
		Excel excle=new Excel("C://Users/hasee/Desktop/东京top100poi外包版A组.xlsx");
		excle.fanyi(3, 4,"E://fanyi.xlsx");

        
	}
		
}
