package com.codeodyssey.fileparser.api.factory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.codeodyssey.fileparser.api.exception.FileParserNotFoundException;
import com.codeodyssey.fileparser.api.service.IFileParserService;

/**
 * @author hiran
 * @Description Factory class returns
 * the Specific FileParser Service based on filetype
 * derived from file extension
 */
@Component
public class FileParserServiceFactory {
	
	private static final Map<String, IFileParserService> fileParserServicesServiceCache = new HashMap<>();
	
	@Autowired
	private FileParserServiceFactory(List<IFileParserService> fileParserServices) {
	        for(IFileParserService fileParserService : fileParserServices) {
	        	fileParserServicesServiceCache.put(fileParserService.getFileType(), fileParserService);
	        }
	    }

	/**
	 * Return the FileParserService based on FileType
	 * @param filetype
	 * @return
	 * @throws FileParserNotFoundException 
	 */
	public static IFileParserService getFileParserService(String filetype) throws FileParserNotFoundException {
		IFileParserService fileParserservice = fileParserServicesServiceCache.get(filetype);
        if(fileParserservice == null) throw new FileParserNotFoundException("No File Parser defined for File type: " + filetype);
        return fileParserservice;
    }
}
