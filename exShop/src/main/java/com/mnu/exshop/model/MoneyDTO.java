package com.mnu.exshop.model;

public class MoneyDTO {
	private int custno;
	private int saleno;
	private int amount;
	private String pcode;
	private int sdate;
	public int getCustno() {
		return custno;
	}
	public void setCustno(int custno) {
		this.custno = custno;
	}
	public int getSaleno() {
		return saleno;
	}
	public void setSaleno(int saleno) {
		this.saleno = saleno;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	public int getSdate() {
		return sdate;
	}
	public void setSdate(int sdate) {
		this.sdate = sdate;
	}
}
