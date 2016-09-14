package com.base.dao;

import java.io.Serializable;
import com.jdao.base.Table;
import com.jdao.base.Fields;

/**
 * @date 2016-09-14 16:05:41  dao for table sys_menu
 */
public class SysMenu extends Table<SysMenu> implements Serializable{
	private static final long serialVersionUID = 1L;
	private final static String TABLENAME_ = "sys_menu";
	/**id*/
	public final static Fields ID = new Fields("`id`");
	/**menu_name*/
	public final static Fields MENUNAME = new Fields("`menu_name`");
	/**parent_id*/
	public final static Fields PARENTID = new Fields("`parent_id`");
	/**level*/
	public final static Fields LEVEL = new Fields("`level`");

	private int id = 0;
	private java.lang.String menuName;
	private int parentId = 0;
	private int level = 0;

	public SysMenu(){
		super(TABLENAME_,SysMenu.class);
		super.setFields(ID,MENUNAME,PARENTID,LEVEL);
	}

	public SysMenu(String tableName4sharding){
		super(tableName4sharding,SysMenu.class);
		super.setFields(ID,MENUNAME,PARENTID,LEVEL);
	}

	public int getId(){
		return this.id;
	}

	public void setId(int id){
		fieldValueMap.put(ID, id);
		 this.id=id;
	}
	public java.lang.String getMenuName(){
		return this.menuName;
	}

	public void setMenuName(java.lang.String menuName){
		fieldValueMap.put(MENUNAME, menuName);
		 this.menuName=menuName;
	}
	public int getParentId(){
		return this.parentId;
	}

	public void setParentId(int parentId){
		fieldValueMap.put(PARENTID, parentId);
		 this.parentId=parentId;
	}
	public int getLevel(){
		return this.level;
	}

	public void setLevel(int level){
		fieldValueMap.put(LEVEL, level);
		 this.level=level;
	}
}