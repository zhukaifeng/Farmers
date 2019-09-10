package com.osiris.farmers.model;

import java.util.List;

public class SampleListData {


	/**
	 * code : null
	 * count : 9
	 * msg : ok
	 * cangysjgls : [{"id":1,"ypmc":"874","bcdwmc":"18","twh":"1","cysum":"2","comname":"百花菜市场","sczhutfl":"1-1","yplb":"蔬菜及蔬菜制品","user":"3","phone":"434343","ypbh":"大白菜","yyzz":"253","cyfei":"3","tsremark":"1568039071634.png,1568039071665.png","llrq":"2019-09-09 23:00:55","mark":"","mbrk":"0","mcrk":"","remark":""},{"id":2,"ypmc":null,"bcdwmc":null,"twh":null,"cysum":null,"comname":null,"sczhutfl":null,"yplb":null,"user":null,"phone":null,"ypbh":null,"yyzz":null,"cyfei":null,"tsremark":null,"llrq":null,"mark":null,"mbrk":null,"mcrk":null,"remark":null},{"id":3,"ypmc":null,"bcdwmc":null,"twh":null,"cysum":null,"comname":null,"sczhutfl":null,"yplb":null,"user":null,"phone":null,"ypbh":null,"yyzz":null,"cyfei":null,"tsremark":null,"llrq":null,"mark":null,"mbrk":null,"mcrk":null,"remark":null},{"id":4,"ypmc":null,"bcdwmc":null,"twh":null,"cysum":null,"comname":null,"sczhutfl":null,"yplb":null,"user":null,"phone":null,"ypbh":null,"yyzz":null,"cyfei":null,"tsremark":null,"llrq":null,"mark":null,"mbrk":null,"mcrk":null,"remark":null},{"id":5,"ypmc":null,"bcdwmc":null,"twh":null,"cysum":null,"comname":null,"sczhutfl":null,"yplb":null,"user":null,"phone":null,"ypbh":null,"yyzz":null,"cyfei":null,"tsremark":null,"llrq":null,"mark":null,"mbrk":null,"mcrk":null,"remark":null},{"id":6,"ypmc":null,"bcdwmc":null,"twh":null,"cysum":null,"comname":null,"sczhutfl":null,"yplb":null,"user":null,"phone":null,"ypbh":null,"yyzz":null,"cyfei":null,"tsremark":null,"llrq":null,"mark":null,"mbrk":null,"mcrk":null,"remark":null},{"id":7,"ypmc":null,"bcdwmc":null,"twh":null,"cysum":null,"comname":null,"sczhutfl":null,"yplb":null,"user":null,"phone":null,"ypbh":null,"yyzz":null,"cyfei":null,"tsremark":null,"llrq":null,"mark":null,"mbrk":null,"mcrk":null,"remark":null},{"id":8,"ypmc":null,"bcdwmc":null,"twh":null,"cysum":null,"comname":null,"sczhutfl":null,"yplb":null,"user":null,"phone":null,"ypbh":null,"yyzz":null,"cyfei":null,"tsremark":null,"llrq":null,"mark":null,"mbrk":null,"mcrk":null,"remark":null}]
	 */

	private Object code;
	private String count;
	private String msg;
	private List<CangysjglsBean> cangysjgls;

	public Object getCode() {
		return code;
	}

	public void setCode(Object code) {
		this.code = code;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public List<CangysjglsBean> getCangysjgls() {
		return cangysjgls;
	}

	public void setCangysjgls(List<CangysjglsBean> cangysjgls) {
		this.cangysjgls = cangysjgls;
	}

	public static class CangysjglsBean {
		/**
		 * id : 1
		 * ypmc : 874
		 * bcdwmc : 18
		 * twh : 1
		 * cysum : 2
		 * comname : 百花菜市场
		 * sczhutfl : 1-1
		 * yplb : 蔬菜及蔬菜制品
		 * user : 3
		 * phone : 434343
		 * ypbh : 大白菜
		 * yyzz : 253
		 * cyfei : 3
		 * tsremark : 1568039071634.png,1568039071665.png
		 * llrq : 2019-09-09 23:00:55
		 * mark :
		 * mbrk : 0
		 * mcrk :
		 * remark :
		 */

		private int id;
		private String ypmc;
		private String bcdwmc;
		private String twh;
		private String cysum;
		private String comname;
		private String sczhutfl;
		private String yplb;
		private String user;
		private String phone;
		private String ypbh;
		private String yyzz;
		private String cyfei;
		private String tsremark;
		private String llrq;
		private String mark;
		private String mbrk;
		private String mcrk;
		private String remark;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getYpmc() {
			return ypmc;
		}

		public void setYpmc(String ypmc) {
			this.ypmc = ypmc;
		}

		public String getBcdwmc() {
			return bcdwmc;
		}

		public void setBcdwmc(String bcdwmc) {
			this.bcdwmc = bcdwmc;
		}

		public String getTwh() {
			return twh;
		}

		public void setTwh(String twh) {
			this.twh = twh;
		}

		public String getCysum() {
			return cysum;
		}

		public void setCysum(String cysum) {
			this.cysum = cysum;
		}

		public String getComname() {
			return comname;
		}

		public void setComname(String comname) {
			this.comname = comname;
		}

		public String getSczhutfl() {
			return sczhutfl;
		}

		public void setSczhutfl(String sczhutfl) {
			this.sczhutfl = sczhutfl;
		}

		public String getYplb() {
			return yplb;
		}

		public void setYplb(String yplb) {
			this.yplb = yplb;
		}

		public String getUser() {
			return user;
		}

		public void setUser(String user) {
			this.user = user;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getYpbh() {
			return ypbh;
		}

		public void setYpbh(String ypbh) {
			this.ypbh = ypbh;
		}

		public String getYyzz() {
			return yyzz;
		}

		public void setYyzz(String yyzz) {
			this.yyzz = yyzz;
		}

		public String getCyfei() {
			return cyfei;
		}

		public void setCyfei(String cyfei) {
			this.cyfei = cyfei;
		}

		public String getTsremark() {
			return tsremark;
		}

		public void setTsremark(String tsremark) {
			this.tsremark = tsremark;
		}

		public String getLlrq() {
			return llrq;
		}

		public void setLlrq(String llrq) {
			this.llrq = llrq;
		}

		public String getMark() {
			return mark;
		}

		public void setMark(String mark) {
			this.mark = mark;
		}

		public String getMbrk() {
			return mbrk;
		}

		public void setMbrk(String mbrk) {
			this.mbrk = mbrk;
		}

		public String getMcrk() {
			return mcrk;
		}

		public void setMcrk(String mcrk) {
			this.mcrk = mcrk;
		}

		public String getRemark() {
			return remark;
		}

		public void setRemark(String remark) {
			this.remark = remark;
		}
	}
}
