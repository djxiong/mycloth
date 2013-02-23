package com.hros.cloth.vaadin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hros.cloth.domain.Cloth;
import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;

public class ClothUtil {

	public static final String[] sizes = new String[] { "S", "S",
        "M", "M", "L", "L", "XL", "XL", "XXL", "XXL"};
	
	public static final String[] salesOffType = new String[] { "原价", Cloth.SALES_OFF_TYPE_ORIGINAL,
        "降价", Cloth.SALES_OFF_TYPE_AMOUNT, "打折", Cloth.SALES_OFF_TYPE_PERCENT};
	public static final String CONTAINER="CONTAINER";
	public static final String COLUMN_HEADERS="COLUMN_HEADERS";
	public static final String VISIABLE_COLUMNS="VISIABLE_COLUMNS";
	
	public static IndexedContainer getClothContainer(List<Cloth> clothes){
		IndexedContainer container = new IndexedContainer();
		container.addContainerProperty("name", String.class,null);
		//container.addContainerProperty("count", String.class,null);
		container.addContainerProperty("price", String.class,null);
		container.addContainerProperty("realPrice", String.class,null);
		container.addContainerProperty("salesOffType", String.class,null);
		container.addContainerProperty("salesOff", String.class,null);
		
		container.addContainerProperty("barCode", String.class,null);
		container.addContainerProperty("size", String.class,null);
		//List<Cloth> clothes = clothDao.getAllClothes();
		for(Cloth cloth:clothes){
			 Item item = container.addItem(cloth);
			 item.getItemProperty("name").setValue(cloth.getName());
			 //item.getItemProperty("count").setValue(cloth.getCount());
			 item.getItemProperty("price").setValue(cloth.getPrice());
			 item.getItemProperty("realPrice").setValue(cloth.getRealPrice());
			 item.getItemProperty("barCode").setValue(cloth.getBarCode());
			 if(cloth.getSalesOffType().equals(Cloth.SALES_OFF_TYPE_ORIGINAL)){
				 item.getItemProperty("salesOffType").setValue("原价");
				 item.getItemProperty("salesOff").setValue("-");
			 }
			 else if(cloth.getSalesOffType().equals(Cloth.SALES_OFF_TYPE_AMOUNT)){
				 item.getItemProperty("salesOffType").setValue("降价");
				 item.getItemProperty("salesOff").setValue(cloth.getSalesOff());
			 }
			 else{
				 item.getItemProperty("salesOffType").setValue("打折");
				 item.getItemProperty("salesOff").setValue(cloth.getSalesOff());
			 }
			 
			 item.getItemProperty("size").setValue(cloth.getSize());
		}
		
		
		return container;
	
		
	}
	
	public static String[] getClothTableColumnHeaders(){
		return new String[] { "名称","吊牌价","售价","促销方式","促销额","条形码","尺寸"};
	}
	
	public static String[] getClothTableVisiableColumn(){
		return new String[] { "name","price","realPrice","salesOffType","salesOff","barCode","size"};
	}
}
