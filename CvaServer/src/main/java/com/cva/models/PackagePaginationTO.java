package com.cva.models;

import java.util.List;

public class PackagePaginationTO {
	private List<PackageTO> packageList;
	private int count;
	
	public PackagePaginationTO(List<PackageTO> packageList, int count) {
		super();
		this.packageList = packageList;
		this.count = count;
	}

	public List<PackageTO> getPackageList() {
		return packageList;
	}

	public void setPackageList(List<PackageTO> packageList) {
		this.packageList = packageList;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	
	
}
