package com.lh.service;
/*
 * 将数据库中的fruit表以Excel表格的形式存到电脑的G盘
 */
import java.io.File;
import java.io.IOException;
import java.util.List;

import com.lh.dao.FruitDao;
import com.lh.model.Fruit;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class FruitFYExcel {

	public boolean fruitFYExcel(int pageNo) {

		//用于判断Excel表格是否创建成功
		boolean isSuccess=true;
		FruitDao fd = new FruitDao();
		//创建一个可以写入的Excel工作簿
		WritableWorkbook wwb = null;
		//存储的地址
		String fileName = "G:\\fruit"+pageNo+".xls";
		File file = new File(fileName);
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			//以file的名字来创造一个Workbook
			wwb = Workbook.createWorkbook(file);
			//创建工作表
			WritableSheet ws = wwb.createSheet("Test Sheet 1", 0);
			//fruitlist是存放当前页的数据
			List<Fruit> fruitlist = fd.listFruit(pageNo);
			//添加的四个是Excel表最上面的那一行
			Label labelId = new Label(0, 0, "id");
			Label labeName = new Label(1, 0, "name");
			Label labelPrice = new Label(2, 0, "price");
			Label labelNum = new Label(3, 0, "num");
			ws.addCell(labelId);
			ws.addCell(labeName);
			ws.addCell(labelPrice);
			ws.addCell(labelNum);
			//将fruitlist里存放的数据一行一行的写到上面新建的表格里面
			for (int i = 0; i < fruitlist.size(); i++) {
				Label labelId_i = new Label(0, i + 1, fruitlist.get(i).getId() + "");
				Label labelName_i = new Label(1, i + 1, fruitlist.get(i).getName());
				Label labelPrice_i = new Label(2, i + 1, fruitlist.get(i).getPrice() + "");
				Label labelNum_i = new Label(3, i + 1, fruitlist.get(i).getNum() + "");
				ws.addCell(labelId_i);
				ws.addCell(labelName_i);
				ws.addCell(labelPrice_i);
				ws.addCell(labelNum_i);
			}
			//写入文档
			wwb.write();
			//关闭Excel工作簿对象
			wwb.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			isSuccess=false;
			e.printStackTrace();
		}
		return isSuccess;
	}
}
