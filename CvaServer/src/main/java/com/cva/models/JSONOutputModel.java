package com.cva.models;

import java.util.List;
import java.util.Map;

public class JSONOutputModel {
	private List data;
	private Object message;
	private int count;

	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public List getData() {
		return data;
	}
	public void setData(List data) {
		this.data = data;
	}
	public Object getMessage() {
		return message;
	}
	public void setMessage(Object message) {
		this.message = message;
	}
	

	
}
