package com.codeodyssey.fileparser.api.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeodyssey.fileparser.api.config.ConfigProperties;
import com.codeodyssey.fileparser.api.constants.FileConstants;
import com.codeodyssey.fileparser.api.exception.InvalidCSVFileException;
import com.codeodyssey.fileparser.api.model.StoreOrder;
import com.codeodyssey.fileparser.api.repository.StoreOrderRepository;
import com.codeodyssey.fileparser.api.service.IFileParserService;
import com.codeodyssey.fileparser.api.utils.CSVUtils;

/**
 * @Description Implements CSV File Parser
 *
 */
@Service
public class CSVFileParserService implements IFileParserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CSVFileParserService.class);

	@Autowired
	ConfigProperties configProperties;

	@Autowired
	StoreOrderRepository storeOrderRepository;

	@Override
	public String getFileType() {
		return FileConstants.FILE_TYPES.CSV;
	}

	@Override
	public  List<? extends Object> parseFile(File file) throws IOException {
		
		File inputCsvFile = new File(configProperties.getFileUploadPath().concat(file.getName()));
		InputStream inputFileStream = new FileInputStream(inputCsvFile);
			try (BufferedReader csvBufferReader = new BufferedReader(new InputStreamReader(inputFileStream))) 
			{
				List<StoreOrder> storeOrderList = csvBufferReader.lines().skip(1)
						.map(mapLineToObject)
						.collect(Collectors.toList());
				return storeOrderList;
			}
	}
	
	/**
	 * Check for basic CSV file validation
	 * a)CHeck Header exists & matches -to avoid 
	 *  ArrayIndexOutOfBoundException 
	 */
	@Override
	public boolean validate(File file) throws IOException,InvalidCSVFileException {
		boolean isValid=true;
		File inputCsvFile = new File(configProperties.getFileUploadPath().concat(file.getName()));
		InputStream inputFileStream = new FileInputStream(inputCsvFile);
		
		try (BufferedReader csvBufferReader = new BufferedReader(new InputStreamReader(inputFileStream))) {
			if(!configProperties.getCsvHeader()
					.equalsIgnoreCase(csvBufferReader.readLine()))
			{
				isValid=false;
				throw new InvalidCSVFileException("Missing Headers");
			}
		}
		return isValid;
	}
	
	/**
	 * Function to map each line in csv file to Model class
	 */
	private Function<String, StoreOrder> mapLineToObject = (line) -> {
		 List<String> strListofLines=CSVUtils.parseLine(line);
		 String[] data= new String[strListofLines.size()];
		 strListofLines.toArray(data);
		  //String[] data = line.split(FileConstants.CSV_FILE_DELIMITER);// a CSV has comma separated lines
		  StoreOrder storeOrder = new StoreOrder();
		  try {
			  	storeOrder.setOrderId(data[1]);
			  	storeOrder.setOrderDate(new SimpleDateFormat("dd.MM.yy").parse(data[2]));
			  	storeOrder.setShipDate(new SimpleDateFormat("dd.MM.yy").parse(data[3]));
				 storeOrder.setShipMode(data[4]);
				 storeOrder.setCustomerId(data[5]);
				 storeOrder.setCustomerName(data[6]);
				 storeOrder.setSegment(data[7]);
				 storeOrder.setCountry(data[8]);
				 storeOrder.setCity(data[9]);
				 storeOrder.setState(data[10]);
				 storeOrder.setPostalCode(data[11]);
				 storeOrder.setRegion(data[12]);
				 storeOrder.setProductId(data[13]);
				 storeOrder.setCategory(data[14]);
				 storeOrder.setSubCategory(data[15]);
				 storeOrder.setProductName(data[16]);
				 storeOrder.setSales(Double.valueOf(data[17]));
				 storeOrder.setQuantity(Integer.valueOf(data[18]));
				 storeOrder.setDiscount(Double.valueOf(data[19]));
				 storeOrder.setProfit(Float.valueOf(data[20]));
			} catch (Exception ex) {
				LOGGER.error("Exception Caught While Parsing colums:"+ex.getMessage());
			 }
		  return storeOrder;
		};

	/**
	 * @Description Persist Entity Object StoreOrder to database
	 * @param entityBeanList
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void save(List<? extends Object> entityBeanList) {
		List<StoreOrder> storeOrderList=(List<StoreOrder>) entityBeanList;
		
		storeOrderList.forEach(storeOrder->{
					try {
						storeOrderRepository.save(storeOrder);
					}catch(Exception ex) {
						LOGGER.error("Exception occurred while persisting order=>"+storeOrder.getOrderId());
						if(ex instanceof  SQLException) {
							CSVUtils.printSQLException((SQLException)ex);
						}
					}
				});
		}
}
