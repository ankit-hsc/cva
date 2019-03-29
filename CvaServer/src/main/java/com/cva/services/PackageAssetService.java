package com.cva.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cva.domains.PackageEntity;
import com.cva.models.PackagePaginationTO;
import com.cva.models.PackageTO;
import com.cva.utilities.DateUtill;


@Transactional
@Repository

public class PackageAssetService {


	private static final Logger LOGGER = (Logger) LogManager.getLogger(PackageAssetService.class.getName());	
	
	@PersistenceContext	
	private EntityManager entityManager;
	 
		
	
	public PackagePaginationTO getPackageAssetList(int index,int pageSize,String searchQuery) {
		int count=0;
		List<PackageTO> toList=new ArrayList<>();
		StringBuilder getQuery = new StringBuilder("FROM PackageEntity as p ");
		StringBuilder getCountQuery = new StringBuilder("select count(*) from PackageEntity as p");
		
		if(searchQuery!=null && searchQuery!="") {
			getQuery.append(searchQuery);
			getQuery.append(" ORDER BY p.package_id desc,p.asset_type");
			getCountQuery.append(searchQuery);
		}		
		else {getQuery.append("ORDER BY p.package_id,p.asset_type");}
		
		Query query=entityManager.createQuery(getQuery.toString());
		query.setFirstResult((index - 1) * pageSize);
		query.setMaxResults(pageSize);
		List<PackageEntity> entityList=  query.getResultList();
		
		List<Long> auditCount=(List<Long>)entityManager.createQuery(getCountQuery.toString()).getResultList();
		if(auditCount!=null && !auditCount.isEmpty()){ 
			count=auditCount.get(0).intValue();
			}
		
		for(PackageEntity entity:entityList )
		{
	    PackageTO to =new PackageTO();
		to.setPackage_id(entity.getPackage_id());
		to.setVersion(entity.getVersion());
		to.setPackage_asset_id(entity.getPackage_asset_id());
		to.setPackage_name(entity.getPackage_name());
		to.setPackage_status(entity.getPackage_status());
		to.setAsset_name(entity.getAsset_name());
		to.setAsset_type(entity.getAsset_type());
		to.setWork_step_status(entity.getWork_step_status());
		to.setCreate_time(DateUtill.getStringFromDate(entity.getCreate_time()));
		to.setLicensing_end_date(DateUtill.getStringFromDate(entity.getLicense_window_end()));
		toList.add(to);
		}
		return new PackagePaginationTO(toList,count);
	}
	
}
