package com.codeodyssey.fileparser.api.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RestController;

import com.codeodyssey.fileparser.api.exception.FileParserNotFoundException;
import com.codeodyssey.fileparser.api.exception.InvalidCSVFileException;
import com.codeodyssey.fileparser.api.factory.FileParserServiceFactory;
import com.codeodyssey.fileparser.api.model.StoreOrder;
import com.codeodyssey.fileparser.api.service.IFileParserService;

/**
 * 
 * @Description Controller dispatches the 
 * incoming request to Respective FileParser Service based on filetype(extension)
 * Note:Could be extended to provide RestAPI endpoint from this Controller
 */
@RestController
public class FileParserController {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(FileParserController.class);
	
	@SuppressWarnings("unchecked")
	public void uploadFile(File file) {
		IFileParserService fileParserService;
		try {
			fileParserService = FileParserServiceFactory.getFileParserService(StringUtils.getFilenameExtension(file.getName()));
			if(fileParserService.validate(file)) {
				//Parse Each line in csv to collection
				List<StoreOrder> storeOrderList=(List<StoreOrder>) fileParserService.parseFile(file);
				
				//Perist the entity bean to database
				fileParserService.save(storeOrderList);
			}
		}catch(FileParserNotFoundException |InvalidCSVFileException|IOException ex) {
					LOGGER.error("Exception:"+ex.getMessage());
			}
		}
	
	
}
