package com.cva.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cva.models.FilesTO;
import com.cva.models.JSONOutputModel;
import com.cva.services.FileDownloadService;

@RestController

public class FileDownloadController {
	@Autowired
	    private FileDownloadService downloadService;

	    /**
	     * GET /ExpirationReports : get all cva report files
	     * @return list of report files in the response
	     */
	    @RequestMapping(value = "/files",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	    @ResponseBody
	    public JSONOutputModel listReportFiles() {
	    	JSONOutputModel output = new JSONOutputModel();
	    	output.setData(downloadService.listAllReportFiles());
			return output ;
	    }


	    /**
	     * GET /ExpirationReports/files/{filename} : download the given file
	     * @param filename name of the selected file
	     * @return file as attachment
	     */
	    @RequestMapping("/files/{filename:.+}")
	    @ResponseBody
	    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

	        Resource file = downloadService.loadAsResource(filename);
	        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
	            "attachment; filename=\"" + file.getFilename() + "\"").body(file);
	    }

}
