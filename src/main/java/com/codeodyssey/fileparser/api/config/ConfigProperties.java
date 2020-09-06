package com.codeodyssey.fileparser.api.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author hiran
 * @Description Common place for configuring all properties
 */
@Configuration
public class ConfigProperties {
	
	@Value("${file.upload.directory}")
	private String fileUploadPath;
	
	@Value("${csv.sales.header}")
	private String csvHeader;

	/**
	 * @return the fileUploadPath
	 */
	public String getFileUploadPath() {
		return fileUploadPath;
	}

	/**
	 * @param fileUploadPath the fileUploadPath to set
	 */
	public void setFileUploadPath(String fileUploadPath) {
		this.fileUploadPath = fileUploadPath;
	}

	/**
	 * @return the csvHeader
	 */
	public String getCsvHeader() {
		return csvHeader;
	}

	/**
	 * @param csvHeader the csvHeader to set
	 */
	public void setCsvHeader(String csvHeader) {
		this.csvHeader = csvHeader;
	}
	
}
