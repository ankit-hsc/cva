package com.cva.controllers;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cva.models.JSONOutputModel;
import com.cva.models.PackagePaginationTO;
import com.cva.services.PackageAssetService;

@RestController

public class PackageAssetController {


	@Autowired
	PackageAssetService packageAssetService;

	private static final Logger LOGGER = (Logger) LogManager.getLogger(PackageAssetController.class);

	@RequestMapping(value = "/table", method = RequestMethod.GET)
	@ResponseBody
	public JSONOutputModel getPackageList(@RequestParam(value="index") int index,
			@RequestParam(value="pageSize") int pageSize,
			@RequestParam(value="package_id",required=false) String package_id,
			@RequestParam(value="package_asset_id",required=false) String package_asset_id,
			@RequestParam(value="version",required=false) String version,
			@RequestParam(value="package_name",required=false) String package_name,
			@RequestParam(value="package_status",required=false) String package_status,
			@RequestParam(value="asset_name",required=false) String asset_name,
			@RequestParam(value="asset_type",required=false) String asset_type,
			@RequestParam(value="work_step_status",required=false) String work_step_status,
			@RequestParam(value="fromCreateDate",required=false) String fromCreateDate,
			@RequestParam(value="toCreateDate",required=false) String toCreateDate,
			@RequestParam(value="fromLicenseDate",required=false) String fromLicenseDate,
			@RequestParam(value="toLicenseDate",required=false) String toLicenseDate
			) {
		JSONOutputModel output = new JSONOutputModel();
		StringBuilder query = new StringBuilder();
		if(package_id!=null && package_id!="") {query.append(query.toString().isEmpty()?" where p.package_id='"+package_id+"'" : " and  p.package_id='"+package_id+"'");}
		
		if(package_asset_id!=null && package_asset_id!="") {query.append(query.toString().isEmpty()?" where p.package_asset_id='"+package_asset_id+"'" : " and p.package_asset_id='"+package_asset_id+"'");}
		
		if(version!=null && version!="") {
			if (version.equals("UPDATE"))
			query.append(query.toString().isEmpty()?" where p.version='"+version+"'" : " and p.version='"+version+"'");
			else if(version.equals("NEW"))
		    query.append(query.toString().isEmpty()?" where p.version IS NULL" : " and p.version IS NULL");
				
		}
		
		if(package_name!=null && package_name!="") {query.append(query.toString().isEmpty()?" where p.package_name='"+package_name+"'" : " and p.package_name='"+package_name+"'");}
		
		if(package_status!=null && package_status!="") {query.append(query.toString().isEmpty()?" where p.package_status='"+package_status+"'" : " and p.package_status='"+package_status+"'");}
		
		if(asset_name!=null && asset_name!="") {query.append(query.toString().isEmpty()?" where p.asset_name='"+asset_name+"'" : " and p.asset_name='"+asset_name+"'");}
		
		if(asset_type!=null && asset_type!="") {query.append(query.toString().isEmpty()?" where p.asset_type='"+asset_type+"'" : " and p.asset_type='"+asset_type+"'");}
		
		if(work_step_status!=null && work_step_status!="") {query.append(query.toString().isEmpty()?" where p.work_step_status='"+work_step_status+"'" : " and p.work_step_status='"+work_step_status+"'");}
		
		if(fromCreateDate!=null && fromCreateDate!="" && toCreateDate!=null && toCreateDate!="") 
		{fromCreateDate=fromCreateDate+" 00:00:00";toCreateDate=toCreateDate+" 23:59:59";
			query.append(query.toString().isEmpty()?" where p.create_time between '"+fromCreateDate+"' and '"+toCreateDate+"' " : "  and p.create_time between '"+fromCreateDate+"' and '"+toCreateDate+"' ");}
		
		if(fromLicenseDate!=null && fromLicenseDate!="" && toLicenseDate!=null && toLicenseDate!="") 
		{fromLicenseDate=fromLicenseDate+" 00:00:00";toLicenseDate=toLicenseDate+" 23:59:59";
			query.append(query.toString().isEmpty()?" where p.license_window_end between '"+fromLicenseDate+"' and '"+toLicenseDate+"' " : "  and p.license_window_end between '"+fromLicenseDate+"' and '"+toLicenseDate+"' ");}
		
		
		PackagePaginationTO paginationTO=packageAssetService.getPackageAssetList(index,pageSize,query.toString()); 
		output.setData(paginationTO.getPackageList());
		output.setCount(paginationTO.getCount());
		query=null;
		return output;
	}
	
	
	
}
