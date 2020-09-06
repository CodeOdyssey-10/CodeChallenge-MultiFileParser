package com.codeodyssey.fileparser.api;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import com.codeodyssey.fileparser.api.exception.FileParserNotFoundException;
import com.codeodyssey.fileparser.api.exception.InvalidCSVFileException;
import com.codeodyssey.fileparser.api.factory.FileParserServiceFactory;
import com.codeodyssey.fileparser.api.model.StoreOrder;
import com.codeodyssey.fileparser.api.service.IFileParserService;



@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
class FileParserApiApplicationTests {
	
	private BufferedReader br = null;
	
	/**Check if input.txt file exists in classpath*/
	@Test
	@DisplayName("CSVFileExistsCheck")
    public void checkInputFileExists()
        throws IOException
    {
       Assert.notNull(br, "File Not Found");
    }
	
	
	@Test
	@DisplayName("CheckUnsupportedFileParserError")
	public void unsupportedfileparsererror() {
		File file= new File("sales.txt");
		try {
			FileParserServiceFactory.getFileParserService(StringUtils.getFilenameExtension(file.getName()));
		} catch (FileParserNotFoundException e) {
			String message = "No File Parser defined for File type: txt";
			assertThat(e.getMessage(), is(message));
		}

	}
	
	@Test
	@DisplayName("CheckCSVFileHeader")
	public void checkcsvfileheader() {
		File file= new File("sales1.csv");
		try {
			IFileParserService fileParserService=FileParserServiceFactory.getFileParserService(StringUtils.getFilenameExtension(file.getName()));
			fileParserService.validate(file);
		} catch(FileParserNotFoundException |InvalidCSVFileException|IOException ex) {
			String message = "Missing Headers";
			assertThat(ex.getMessage(), is(message));
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	@DisplayName("CheckCSVFileParseCount")
	public void checkcsvfileparsecount() {
		File file= new File("sales.csv");
		try {
			IFileParserService fileParserService=FileParserServiceFactory.getFileParserService(StringUtils.getFilenameExtension(file.getName()));
			List<StoreOrder> storeOrderList=(List<StoreOrder>)fileParserService.parseFile(file);
			assertThat(11, is(storeOrderList.size()));
		} catch(FileParserNotFoundException|IOException ex) {
			System.out.println("Exception:"+ex.getMessage());
		}
	}
	
	
	/**Instantiate sales.csv Reader*/
	@BeforeAll
	public void setUp() throws IOException{
		br = new BufferedReader(
	            new InputStreamReader(getClass().getResourceAsStream("/sales.csv")));
	}
	
	
	/**Close the Stream Reader*/
	@AfterAll
	public void tearDown() throws IOException{
		 if (br != null)
	        {
	            br.close();
	        }
	        br = null;
	}

}
