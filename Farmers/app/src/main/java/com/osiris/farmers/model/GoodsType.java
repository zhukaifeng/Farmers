package com.osiris.farmers.model;

import java.util.List;

public class GoodsType {


	/**
	 * code :
	 * count :
	 * description : [{"beifen":"","descripbz":"","descriptionbz":"","descriptionnm":"蔬菜","id":1,"mark":"","mbrk":"","mcrk":"","remark":""},{"beifen":"","descripbz":"","descriptionbz":"","descriptionnm":"肉类","id":2,"mark":"","mbrk":"","mcrk":"","remark":""},{"beifen":"","descripbz":"","descriptionbz":"","descriptionnm":"水产","id":3,"mark":"","mbrk":"","mcrk":"","remark":""},{"beifen":"","descripbz":"","descriptionbz":"","descriptionnm":"面制品","id":4,"mark":"","mbrk":"","mcrk":"","remark":""},{"beifen":"","descripbz":"","descriptionbz":"","descriptionnm":"熟食","id":5,"mark":"","mbrk":"","mcrk":"","remark":""},{"beifen":"","descripbz":"","descriptionbz":"","descriptionnm":"南北干货","id":6,"mark":"","mbrk":"","mcrk":"","remark":""},{"beifen":"","descripbz":"","descriptionbz":"","descriptionnm":"商品类别1","id":7,"mark":"","mbrk":"","mcrk":"","remark":""},{"beifen":"","descripbz":"","descriptionbz":"","descriptionnm":"商品类别2","id":8,"mark":"","mbrk":"","mcrk":"","remark":""},{"beifen":"","descripbz":"","descriptionbz":"","descriptionnm":"商品类别3","id":9,"mark":"","mbrk":"","mcrk":"","remark":""},{"beifen":"","descripbz":"","descriptionbz":"","descriptionnm":"商品类别4","id":10,"mark":"","mbrk":"","mcrk":"","remark":""},{"beifen":"","descripbz":"","descriptionbz":"","descriptionnm":"商品类别5","id":11,"mark":"","mbrk":"","mcrk":"","remark":""},{"beifen":"","descripbz":"","descriptionbz":"","descriptionnm":"商品类别6","id":12,"mark":"","mbrk":"","mcrk":"","remark":""},{"beifen":"","descripbz":"","descriptionbz":"","descriptionnm":"商品类别7","id":13,"mark":"","mbrk":"","mcrk":"","remark":""},{"beifen":"","descripbz":"","descriptionbz":"","descriptionnm":"商品类别8","id":14,"mark":"","mbrk":"","mcrk":"","remark":""},{"beifen":"","descripbz":"","descriptionbz":"","descriptionnm":"商品类别9","id":15,"mark":"","mbrk":"","mcrk":"","remark":""},{"beifen":"","descripbz":"","descriptionbz":"","descriptionnm":"商品类别10","id":16,"mark":"","mbrk":"","mcrk":"","remark":""},{"beifen":"","descripbz":"","descriptionbz":"","descriptionnm":"蔬菜及蔬菜制品","id":17,"mark":"","mbrk":"","mcrk":"","remark":""},{"beifen":"","descripbz":"","descriptionbz":"","descriptionnm":"水产及水产制品","id":18,"mark":"","mbrk":"","mcrk":"","remark":""},{"beifen":"","descripbz":"","descriptionbz":"","descriptionnm":"肉及肉制品","id":19,"mark":"","mbrk":"","mcrk":"","remark":""},{"beifen":"","descripbz":"","descriptionbz":"","descriptionnm":"豆及豆制品","id":20,"mark":"","mbrk":"","mcrk":"","remark":""},{"beifen":"","descripbz":"","descriptionbz":"","descriptionnm":"粮食及粮食制品","id":21,"mark":"","mbrk":"","mcrk":"","remark":""},{"beifen":"","descripbz":"","descriptionbz":"","descriptionnm":"水果及水果制品","id":22,"mark":"","mbrk":"","mcrk":"","remark":""},{"beifen":"","descripbz":"","descriptionbz":"","descriptionnm":"调味品","id":23,"mark":"","mbrk":"","mcrk":"","remark":""},{"beifen":"","descripbz":"","descriptionbz":"","descriptionnm":"其它","id":24,"mark":"","mbrk":"","mcrk":"","remark":""}]
	 * msg : 1
	 */

	private String code;
	private String count;
	private String msg;
	private List<DescriptionBean> description;

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

	public List<DescriptionBean> getDescription() {
		return description;
	}

	public void setDescription(List<DescriptionBean> description) {
		this.description = description;
	}

	public static class DescriptionBean {
		/**
		 * beifen :
		 * descripbz :
		 * descriptionbz :
		 * descriptionnm : 蔬菜
		 * id : 1
		 * mark :
		 * mbrk :
		 * mcrk :
		 * remark :
		 */

		private String beifen;
		private String descripbz;
		private String descriptionbz;
		private String descriptionnm;
		private int id;
		private String mark;
		private String mbrk;
		private String mcrk;
		private String remark;
		private boolean clicked;

		public boolean isClicked() {
			return clicked;
		}

		public void setClicked(boolean clicked) {
			this.clicked = clicked;
		}

		public String getBeifen() {
			return beifen;
		}

		public void setBeifen(String beifen) {
			this.beifen = beifen;
		}

		public String getDescripbz() {
			return descripbz;
		}

		public void setDescripbz(String descripbz) {
			this.descripbz = descripbz;
		}

		public String getDescriptionbz() {
			return descriptionbz;
		}

		public void setDescriptionbz(String descriptionbz) {
			this.descriptionbz = descriptionbz;
		}

		public String getDescriptionnm() {
			return descriptionnm;
		}

		public void setDescriptionnm(String descriptionnm) {
			this.descriptionnm = descriptionnm;
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
