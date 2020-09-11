package com.codeodyssey.fileparser.api;

import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import org.hamcrest.core.IsNull;
import org.junit.jupiter.api.Test;

import com.codeodyssey.fileparser.api.utils.CSVUtils;


class CSVUtilsTest {

	@Test
	public void testnoquotestring() {
		String line = "Furniture,Bookcases,Bush Somerset Collection Bookcase";
        List<String> result = CSVUtils.parseLine(line);

        assertThat(result, IsNull.notNullValue());
        assertThat(result.size(), is(3));
        assertThat(result.get(0), is("Furniture"));
        assertThat(result.get(1), is("Bookcases"));
        assertThat(result.get(2), is("Bush Somerset Collection Bookcase"));
	}
	
	@Test
    public void test_double_quotes_in_column() throws Exception {

        String line = "Office Supplies,Envelopes,\"#10-4 1/8\"\" x, 9 1/2\"\"";

        List<String> result = CSVUtils.parseLine(line);
        assertThat(result, IsNull.notNullValue());
        assertThat(result.size(), is(3));
        assertThat(result.get(0), is("Office Supplies"));
        assertThat(result.get(1), is("Envelopes"));
        assertThat(result.get(2), is("\"#10-4 1/8\"\" x, 9 1/2\"\""));

    }
	
	 @Test
	    public void test_double_quotes_but_comma_in_column() {

	        String line = "Furniture,Furnishings,\"Eldon Expressions Wood and Plastic Desk Accessories, Cherry Wood\"";
	        List<String> result = CSVUtils.parseLine(line);

	        assertThat(result, IsNull.notNullValue());
	        assertThat(result.size(), is(3));
	        assertThat(result.get(0), is("Furniture"));
	        assertThat(result.get(1), is("Furnishings"));
	        assertThat(result.get(2), is("\"Eldon Expressions Wood and Plastic Desk Accessories, Cherry Wood"));

	    }
}
