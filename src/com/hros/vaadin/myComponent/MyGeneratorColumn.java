package com.hros.vaadin.myComponent;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import com.vaadin.ui.Component;
import com.vaadin.ui.Table;

/**
 * 用于构建table的特殊列，其作用代替Table.ColumnGenerator
 * @author pb
 * 在构造时，指定需要替换的控件, 该控件构造时有3个参数，分别是table, itemid, columnid
 * 对应table, 行, 列，如下所示的构建lable的例子
 * 
 * public static class dictLabel extends Label {
		public dictLabel(Table source, Object itemId, Object columnId) {
			Item item = source.getItem(itemId);
			String s = (String) item.getItemProperty(columnId).getValue();
			if (dictMap.containsKey(s)) {
				String name = dictMap.get(s).getDictName();
				setPropertyDataSource(new ObjectProperty<String>(name, String.class));
		        setContentMode(CONTENT_DEFAULT);
		        setWidth(100, UNITS_PERCENTAGE);
			}
		}
	}
	
	table.addGeneratedColumn("industry", 
				new MyGeneratorColumn(dictLabel.class));
	
 */
@SuppressWarnings("serial")
public class MyGeneratorColumn implements Table.ColumnGenerator{
	private Class cls;
	
	public MyGeneratorColumn(Class cls) {
		this.cls = cls;
	}

	@Override
	public Object generateCell(Table source, Object itemId, Object columnId) {
		try {
			Class[] parameterTypes = {Table.class, Object.class, Object.class};
			Constructor c = cls.getDeclaredConstructor(parameterTypes);
			c.setAccessible(true);
			Component component = (Component) c.newInstance(source, itemId, columnId);
			return component;
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
