package com.company;

public class Table {
	private boolean reserve = false;
	private static Integer id = 0;

	public Table(int code){
		this.id = code;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isReserve() {
		return reserve;
	}
	public void setReserve(boolean reserve) {
		this.reserve = reserve;
	}

	@Override
	public String toString() {
		return "Table{" +
				"id =" + this.id +
				'}';
	}
}
