package com.cva.models;

import java.util.Date;
import java.util.List;


public class PackageTO {
	
	private String package_id ;
	private String version ;
	private String package_asset_id ;
	private String package_name;
	private String package_status;
	private String asset_name ;
	private String asset_type ;
	private String work_step_status ;
	private String create_time;
	private String licensing_end_date ;
	public String getPackage_id() {
		return package_id;
	}
	public void setPackage_id(String package_id) {
		this.package_id = package_id;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getPackage_asset_id() {
		return package_asset_id;
	}
	public void setPackage_asset_id(String package_asset_id) {
		this.package_asset_id = package_asset_id;
	}
	public String getPackage_name() {
		return package_name;
	}
	public void setPackage_name(String package_name) {
		this.package_name = package_name;
	}
	public String getPackage_status() {
		return package_status;
	}
	public void setPackage_status(String package_status) {
		this.package_status = package_status;
	}
	public String getAsset_name() {
		return asset_name;
	}
	public void setAsset_name(String asset_name) {
		this.asset_name = asset_name;
	}
	public String getAsset_type() {
		return asset_type;
	}
	public void setAsset_type(String asset_type) {
		this.asset_type = asset_type;
	}
	public String getWork_step_status() {
		return work_step_status;
	}
	public void setWork_step_status(String work_step_status) {
		this.work_step_status = work_step_status;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_date) {
		this.create_time = create_date;
	}
	public String getLicensing_end_date() {
		return licensing_end_date;
	}
	public void setLicensing_end_date(String licensing_end_date) {
		this.licensing_end_date = licensing_end_date;
	}
	
	
}
