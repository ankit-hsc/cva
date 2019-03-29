package com.cva.domains;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


/**
 * @author Ankit
 *
 */
@Entity
@Table(name = "cva_package_details")
public class PackageEntity implements Serializable {
	@Id
	private Long id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	private String package_id;
	private String migration;
	private String version;
	private String package_asset_id;
	private String package_name;
	private String package_status;
	private String asset_type;
	private String asset_name;
	private String work_step_status;
	
 
    private Date create_time;
	private Date license_window_end;
	
	
	
	
	public String getPackage_id() {
		return package_id;
	}
	public void setPackage_id(String package_id) {
		this.package_id = package_id;
	}
	public String getMigration() {
		return migration;
	}
	public void setMigration(String migration) {
		this.migration = migration;
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
	public String getAsset_type() {
		return asset_type;
	}
	public void setAsset_type(String asset_type) {
		this.asset_type = asset_type;
	}
	public String getAsset_name() {
		return asset_name;
	}
	public void setAsset_name(String asset_name) {
		this.asset_name = asset_name;
	}
	public String getWork_step_status() {
		return work_step_status;
	}
	public void setWork_step_status(String work_step_status) {
		this.work_step_status = work_step_status;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Date getLicense_window_end() {
		return license_window_end;
	}
	public void setLicense_window_end(Date license_window_end) {
		this.license_window_end = license_window_end;
	}
	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PackageEntity cVAPackage = (PackageEntity) o;

        if ( package_id != null && cVAPackage.getPackage_id() != null) {
        	 return package_id.equals(cVAPackage.getPackage_id());
       }
       return false;
    }
}
