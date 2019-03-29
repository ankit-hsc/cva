package com.cva.services;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cva.models.FilesTO;
import com.cva.utilities.DateUtill;

import java.io.File;
import java.io.FilenameFilter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Transactional
@Repository

public class FileDownloadService {
	 private static final Logger logger = LogManager.getLogger(FileDownloadService.class);
	 @Value("${cva.reporting.report-folder}")
	    private String reportFolder;

	 
	  public static final String REPORT_FILE_NAME_PREFIX = "Expiring_Content_";
	    public static final String FILE_EXTN = ".csv";
	    
	    /**
	     * list all report files
	     * @return
	     */
	    public List<FilesTO> listAllReportFiles() {

	        List<FilesTO> reportFiles = new ArrayList<>();

	        try {
	            File rootFolder = Paths.get(reportFolder).toFile();

	            if (rootFolder.exists() && rootFolder.isDirectory()) {
	                logger.info("Report folder exists for: "+reportFolder);
	                File[] fileList = rootFolder.listFiles(new FilenameFilter() {
	                    public boolean accept(File dir, String name) {
	                        if (name.startsWith(REPORT_FILE_NAME_PREFIX) && name.endsWith(FILE_EXTN)) {
	                            return true;
	                        }
	                        return false;
	                    }
	                });
	                
	                sortByLastModified(fileList);
	               

	                for (File file : fileList) {
	                    FilesTO fileDTO = new FilesTO(file.getName(),
	                        getDateTime(file.lastModified()));
	                    reportFiles.add(fileDTO);
	                }

	            } else {
	                logger.error("Report folder doesnt exists for: " + reportFolder);
	            }
	        } catch (Exception e) {
	            logger.error("Exception while listing report files: " + e);
	        }

	        return reportFiles;
	    }

	    public Path load(String filename) {
	        Path rootFolder = Paths.get(reportFolder);
	        return rootFolder.resolve(filename);
	    }

	    /**
	     * load the given file as resource
	     * @param filename
	     * @return
	     */
	    public Resource loadAsResource(String filename) {

	        try {
	            Path file = load(filename);
	            Resource resource = new UrlResource(file.toUri());
	            if (resource.exists() && resource.isReadable()) {
	                return resource;
	            } else {
	                logger.error("Could not read file: " + filename);
	                throw new RuntimeException("Could not read file: " + filename);
	            }
	        } catch (Exception e) {
	            logger.error("Could not read file: " + filename);
	            throw new RuntimeException("Could not read file: " + e);
	        }
	    }

	    private String getDateTime(Long millis) {
	    	 Date date = new Date(millis);
	    	 return DateUtill.getStringFromDate(date);
	    }
	    private static File[] sortByLastModified(File[] files) {
	        Arrays.sort(files, new Comparator<File>() {
	            public int compare(File o1, File o2) {
	                return Long.compare(o2.lastModified(), o1.lastModified());
	            }
	        });
	        return files;
	    }
}
