package com.lh.dao;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.lh.model.Fruit;
import com.lh.utils.JDBCUtils;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExcelToFruitDao {

	public List<Fruit> getFruitFromExcel(String filename){
		List<Fruit> fruitlist=new ArrayList<Fruit>();
		Fruit fruit=null;
		File file=new File(filename);
		try {
			Workbook wb=Workbook.getWorkbook(file);
			Sheet sheet=wb.getSheet(0);
			int clos=sheet.getColumns();//列
			int rows=sheet.getRows();//行
			for(int i=1;i<rows;i++){
				for(int j=0;j<clos;j++){
					fruit=new Fruit();
					fruit.setId(sheet.getCell(j++, i).getColumn());
					fruit.setName(sheet.getCell(j++, i).getContents());
					fruit.setPrice(sheet.getCell(j++, i).getColumn());
					fruit.setNum(sheet.getCell(j++, i).getColumn());
					fruitlist.add(fruit);
				}
			}
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fruitlist;
	}
	
	public boolean findById(int id){
		boolean isSusess=false;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			conn=JDBCUtils.getConn();
			String sql="select * from fruit where id=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			while(rs.next()){
				isSusess=true;
			}
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.close(conn, ps, rs);
		}
		return isSusess;
	}
}
