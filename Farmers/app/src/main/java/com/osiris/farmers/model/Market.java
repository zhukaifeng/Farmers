package com.osiris.farmers.model;

import java.util.List;

public class Market {


	/**
	 * code :
	 * count :
	 * market : [{"address":"新桥商业区1号楼西边","beifen":"国有","id":1,"mark":"","marketnm":"新桥菜市场","mbrk":"","mcrk":"","phone":"18962993668","regionid":"1","remark":"","ren":"李苏","tel":"18962993668","yyzz":"91321182058664862T","zhuren":"李苏"},{"address":"濠东新村商业区","beifen":"民营","id":2,"mark":"","marketnm":"濠东菜市场","mbrk":"","mcrk":"","phone":"13962967779","regionid":"1","remark":"","ren":"陈辉","tel":"13962967779","yyzz":"91321182MA1NFY5Q9A","zhuren":"陈辉"},{"address":"人民路68号","beifen":"民营","id":3,"mark":"","marketnm":"东方菜市场","mbrk":"","mcrk":"","phone":"13806298388","regionid":"1","remark":"","ren":"陈志刚","tel":"13806298388","yyzz":"91321182703960972J","zhuren":"陈志刚"},{"address":"观音山太平北路366号","beifen":"民营","id":4,"mark":"","marketnm":"观音山菜市场","mbrk":"","mcrk":"","phone":"13951321655","regionid":"2","remark":"","ren":"王建","tel":"13951321655","yyzz":"91321100MA1P212U30","zhuren":"王建"},{"address":"濠北路193号","beifen":"国有","id":5,"mark":"","marketnm":"北濠桥菜市场","mbrk":"","mcrk":"","phone":"13773667219","regionid":"3","remark":"","ren":"顾杨","tel":"13773667219","yyzz":"91321100MA1P210L77","zhuren":"顾杨"},{"address":"人民中路204号#8号","beifen":"国有","id":6,"mark":"","marketnm":"端平桥菜市场","mbrk":"","mcrk":"","phone":"13862928885","regionid":"3","remark":"","ren":"张钰","tel":"13862928885","yyzz":"321182000088204","zhuren":"张钰"},{"address":"人民路北、北濠桥路东，南通大厦D座101室","beifen":"民营","id":7,"mark":"","marketnm":"城中菜市场","mbrk":"","mcrk":"","phone":"13806295776","regionid":"3","remark":"","ren":"徐旭","tel":"13806295776","yyzz":"321182000086080","zhuren":"徐旭"},{"address":"任港路39号","beifen":"民营","id":8,"mark":"","marketnm":"都市华城菜市场","mbrk":"","mcrk":"","phone":"18906297001","regionid":"4","remark":"","ren":"冯主任","tel":"18906297001","yyzz":"321124197605140019","zhuren":"冯主任"},{"address":"虹桥新村内商业1号楼","beifen":"民营","id":9,"mark":"","marketnm":"虹桥菜市场","mbrk":"","mcrk":"","phone":"13806295659","regionid":"4","remark":"","ren":"周翠珍","tel":"13806295659","yyzz":"321182000006179","zhuren":"周翠珍"},{"address":"桃坞路89号","beifen":"民营","id":10,"mark":"","marketnm":"莘园路菜市场","mbrk":"","mcrk":"","phone":"13962918479","regionid":"4","remark":"","ren":"庄主任","tel":"13962918479","yyzz":"91321182MA1NXGQK2J","zhuren":"庄主任"},{"address":"花园路北五山公寓旁","beifen":"集体","id":11,"mark":"","marketnm":"五山菜市场","mbrk":"","mcrk":"","phone":"13901482191","regionid":"5","remark":"","ren":"倪主任","tel":"13901482191","yyzz":"91321182MA1NTA3B4N","zhuren":"倪主任"},{"address":"城港新村70号楼底楼","beifen":"集体","id":12,"mark":"","marketnm":"城港菜市场","mbrk":"","mcrk":"","phone":"13515200232","regionid":"6","remark":"","ren":"陈峰","tel":"13515200232","yyzz":"913321182MAIPYLY43F","zhuren":"陈峰"},{"address":"天都新村内沿河路北","beifen":"集体","id":13,"mark":"","marketnm":"天都菜市场","mbrk":"","mcrk":"","phone":"13862950160","regionid":"7","remark":"","ren":"陈主任","tel":"13862950160","yyzz":"913321182MAIPYLWU3U","zhuren":"陈主任"},{"address":"教育路45号","beifen":"集体","id":14,"mark":"","marketnm":"长风菜市场","mbrk":"","mcrk":"","phone":"13861902368","regionid":"7","remark":"","ren":"常小荣","tel":"13861902368","yyzz":"91321182MA1PD44F1R","zhuren":"常小荣"},{"address":"易家桥新村内工商路旁","beifen":"国有","id":15,"mark":"","marketnm":"易家桥菜市场","mbrk":"","mcrk":"","phone":"13016767977","regionid":"8","remark":"","ren":"徐冰","tel":"13016767977","yyzz":"321182000006179","zhuren":"徐冰"},{"address":"段家坝路101号","beifen":"国有","id":16,"mark":"","marketnm":"段家坝菜市场","mbrk":"","mcrk":"","phone":"18006290929","regionid":"8","remark":"","ren":"周霆","tel":"18006290929","yyzz":"321182000006180","zhuren":"周霆"},{"address":"学田新村内学田南路北","beifen":"国有","id":17,"mark":"","marketnm":"学田菜市场","mbrk":"","mcrk":"","phone":"13338068211","regionid":"9","remark":"","ren":"陈刚","tel":"13338068211","yyzz":"321182000006188","zhuren":"陈刚"},{"address":"百花村4组，钟秀路北濠西路东","beifen":"集体","id":18,"mark":"","marketnm":"百花菜市场","mbrk":"","mcrk":"","phone":"15962990001","regionid":"10","remark":"","ren":"单张","tel":"15962990001","yyzz":"321182000006184","zhuren":"单张"}]
	 * msg : 1
	 */

	private String code;
	private String count;
	private String msg;
	private List<MarketBean> market;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
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

	public List<MarketBean> getMarket() {
		return market;
	}

	public void setMarket(List<MarketBean> market) {
		this.market = market;
	}

	public static class MarketBean {
		/**
		 * address : 新桥商业区1号楼西边
		 * beifen : 国有
		 * id : 1
		 * mark :
		 * marketnm : 新桥菜市场
		 * mbrk :
		 * mcrk :
		 * phone : 18962993668
		 * regionid : 1
		 * remark :
		 * ren : 李苏
		 * tel : 18962993668
		 * yyzz : 91321182058664862T
		 * zhuren : 李苏
		 */

		private String address;
		private String beifen;
		private int id;
		private String mark;
		private String marketnm;
		private String mbrk;
		private String mcrk;
		private String phone;
		private String regionid;
		private String remark;
		private String ren;
		private String tel;
		private String yyzz;
		private String zhuren;

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getBeifen() {
			return beifen;
		}

		public void setBeifen(String beifen) {
			this.beifen = beifen;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getMark() {
			return mark;
		}

		public void setMark(String mark) {
			this.mark = mark;
		}

		public String getMarketnm() {
			return marketnm;
		}

		public void setMarketnm(String marketnm) {
			this.marketnm = marketnm;
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

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getRegionid() {
			return regionid;
		}

		public void setRegionid(String regionid) {
			this.regionid = regionid;
		}

		public String getRemark() {
			return remark;
		}

		public void setRemark(String remark) {
			this.remark = remark;
		}

		public String getRen() {
			return ren;
		}

		public void setRen(String ren) {
			this.ren = ren;
		}

		public String getTel() {
			return tel;
		}

		public void setTel(String tel) {
			this.tel = tel;
		}

		public String getYyzz() {
			return yyzz;
		}

		public void setYyzz(String yyzz) {
			this.yyzz = yyzz;
		}

		public String getZhuren() {
			return zhuren;
		}

		public void setZhuren(String zhuren) {
			this.zhuren = zhuren;
		}
	}
}
