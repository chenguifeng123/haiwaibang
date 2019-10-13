package com.haiwaibang.model.po.multi;

import java.util.List;

/**
 * Created by chenguifeng on 2018/11/25.
 */
public class CountryProjectTree {
	private int id;
	private String name;
	private int leaf;

	List<CountryProjectTree> children;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLeaf() {
		return leaf;
	}

	public void setLeaf(int leaf) {
		this.leaf = leaf;
	}

	public List<CountryProjectTree> getChildren() {
		return children;
	}

	public void setChildren(List<CountryProjectTree> children) {
		this.children = children;
	}
}
