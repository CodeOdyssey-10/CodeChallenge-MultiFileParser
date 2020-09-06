package com.codeodyssey.fileparser.api;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.util.Assert;

import com.codeodyssey.fileparser.api.controller.FileParserController;


@SpringBootApplication
public class FileParserApiApplication {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(FileParserApiApplication.class);
	
	@Autowired
	private static FileParserController fileParserController;
	
	static ApplicationContext context;
	
	public static void main(String[] args) {
		context              = SpringApplication.run(FileParserApiApplication.class, args);
		fileParserController = (FileParserController) context.getBean("fileParserController");
		try {
			Assert.notEmpty(args, "Input argument missing.Please provide filename as input parameter.");
			if(0<args.length) { 
				fileParserController.uploadFile(new File(args[0])); 
			}
		 }catch(IllegalArgumentException ex) {
			 LOGGER.error("Exception:"+ex.getMessage());
		}
	}
}
