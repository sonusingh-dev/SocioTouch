package com.socioffice.sociotouch;

import java.util.ArrayList;

import com.socioffice.sociotouch.model.MenuItem;

import android.app.Application;

public class InitializeSocioTouch extends Application {
	
	private int orderNo;
	private ArrayList<MenuItem> menuItemList;
	private ArrayList<MenuItem> menuOrderList;
	
	/**
	 * @return the orderNo
	 */
	public int getOrderNo() {
		return orderNo;
	}
	/**
	 * @param orderNo the orderNo to set
	 */
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	/**
	 * @return the menuItemList
	 */
	public ArrayList<MenuItem> getMenuItemList() {
		return menuItemList;
	}
	/**
	 * @param menuItemList the menuItemList to set
	 */
	public void setMenuItemList(ArrayList<MenuItem> menuItemList) {
		this.menuItemList = menuItemList;
	}	
	/**
	 * @return the menuOrderList
	 */
	public ArrayList<MenuItem> getMenuOrderList() {
		return menuOrderList;
	}
	/**
	 * @param menuOrderList the menuOrderList to set
	 */
	public void setMenuOrderList(ArrayList<MenuItem> menuOrderList) {
		this.menuOrderList = menuOrderList;
	}		
	
}
