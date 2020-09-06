package com.codeodyssey.fileparser.api.utils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import io.micrometer.core.instrument.util.StringUtils;

/**
 * @author hiran
 * Utility for parsing csv file line
 */
public class CSVUtils {
	
	private static final char DEFAULT_DELIMITER = ',';
    private static final char DEFAULT_QUOTE = '"';
    
	public static List<String> parseLine(String csvLine) {
        return parseLine(csvLine, DEFAULT_DELIMITER, DEFAULT_QUOTE);
    }
   
	/**
	 * Handle parsing of CSV line
	 * including special scenario like
	 * a)separator included in the column string
	 * b)Double quotes included in the column string
	 * @param csvLine
	 * @param delimiters
	 * @param customQuote
	 * @return
	 */
	public static List<String> parseLine(String csvLine, 
										char delimiters, 
										char customQuote) {
		
		List<String> result = new ArrayList<>();
		//For empty line return empty list
		if (StringUtils.isEmpty(csvLine)) {
	            return result;
	        }
		//Convert Whitespace to default quote
		if (customQuote == ' ') {
	            customQuote = DEFAULT_QUOTE;
	        }
		//Convert Whitespace in delimiters to default delimiters
		 if (delimiters == ' ') {
			 delimiters = DEFAULT_DELIMITER;
	        }
		
		 StringBuilder curVal = new StringBuilder();
		 boolean inQuotes = false;
	     boolean startCollectChar = false;
	     boolean doubleQuotesInColumn = false;
	     
	     char[] chars = csvLine.toCharArray();
	     
	     for (char ch : chars) {
	    	 if (inQuotes) {
	                startCollectChar = true;
	                if (ch == customQuote) {
	                    inQuotes = false;
	                    doubleQuotesInColumn = false;
	                } else {

	                    //Fixed : allow "" in custom quote enclosed
	                    if (ch == '\"') {
	                        if (!doubleQuotesInColumn) {
	                            curVal.append(ch);
	                            doubleQuotesInColumn = true;
	                        }
	                    } else {
	                        curVal.append(ch);
	                    }

	                }
	            } else {
	                if (ch == customQuote) {

	                    inQuotes = true;

	                    //Fixed : allow "" in empty quote enclosed
	                    if (chars[0] != '"' && customQuote == '\"') {
	                        curVal.append('"');
	                    }

	                    //double quotes in column will hit this!
	                    if (startCollectChar) {
	                        curVal.append('"');
	                    }

	                } else if (ch == delimiters) {//Handle delimiters in String

	                    result.add(curVal.toString());

	                    curVal = new StringBuilder();
	                    startCollectChar = false;

	                } else if (ch == '\r') {
	                    continue; //ignore LF characters
	                } else if (ch == '\n') {
	                    break;  //the end, break!
	                } else {
	                    curVal.append(ch);
	                }
	            }

	        }
	        result.add(curVal.toString());
	        return result;
	    	}
	
	/**
	 * Format SQLException & print
	 * SQL ErrorCode, SQLState
	 * @param ex
	 */
	public static void printSQLException(SQLException ex) {

	    for (Throwable e : ex) {
	        if (e instanceof SQLException) {
	            if (ignoreSQLException(
	                ((SQLException)e).
	                getSQLState()) == false) {

	                e.printStackTrace(System.err);
	                System.err.println("SQLState: " +
	                    ((SQLException)e).getSQLState());

	                System.err.println("Error Code: " +
	                    ((SQLException)e).getErrorCode());

	                System.err.println("Message: " + e.getMessage());

	                Throwable t = ex.getCause();
	                while(t != null) {
	                    System.out.println("Cause: " + t);
	                    t = t.getCause();
	                }
	            }
	        }
	    }
	}
	
	public static boolean ignoreSQLException(String sqlState) {

	    if (sqlState == null) {
	        System.out.println("The SQL state is not defined!");
	        return false;
	    }

	    // X0Y32: Jar file already exists in schema
	    if (sqlState.equalsIgnoreCase("X0Y32"))
	        return true;

	    // 42Y55: Table already exists in schema
	    if (sqlState.equalsIgnoreCase("42Y55"))
	        return true;

	    return false;
	}
	   	
}

