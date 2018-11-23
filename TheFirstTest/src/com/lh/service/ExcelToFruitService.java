package com.lh.service;

import java.util.ArrayList;
import java.util.List;

import com.lh.dao.ExcelToFruitDao;
import com.lh.dao.FruitAddDao;
import com.lh.dao.FruitUpdataDao;
import com.lh.model.Fruit;

public class ExcelToFruitService {

	public boolean excelToFruit(){
		boolean isSusess=true;
		
		ExcelToFruitDao etfd=new ExcelToFruitDao();
		FruitUpdataDao fud=new FruitUpdataDao();
		FruitAddDao fad=new FruitAddDao();
		
		List<Fruit> fruitlist=new ArrayList<Fruit>();
		try {
			fruitlist=etfd.getFruitFromExcel("G:\\1.xls");
			for(Fruit list:fruitlist){
				int id=list.getId();
				String name=list.getName();
				double price=list.getPrice();
				int num=list.getNum();
				//判断这个id这一行是否存在数据库的表里
				if(etfd.findById(id)){
					fud.updataById(id, name, price, num);
				}else{
					fad.addFruit(name, price, num);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			isSusess=false;
		}
		return isSusess;
	}
}
