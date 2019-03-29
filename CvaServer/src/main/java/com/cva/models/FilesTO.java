package com.cva.models;

import java.time.ZonedDateTime;

public class FilesTO {
	 private String name;
	    private String lastModified;

	    public FilesTO(String name, String lastModified) {

	        this.name = name;
	        this.lastModified = lastModified;
	    }

	    public String getLastModified() {
	        return lastModified;
	    }

	    public void setLastModified(String lastModified) {
	        this.lastModified = lastModified;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }
}
