package com.example.csv.model;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class CSVHelper {
	
		  public static String TYPE = "text/csv";
		  static String[] HEADERs = { "Id", "Name", "role", "age" };

		  public static boolean hasCSVFormat(MultipartFile file) {
		    if (TYPE.equals(file.getContentType())
		    		|| file.getContentType().equals("application/vnd.ms-excel")) {
		      return true;
		    }

		    return false;
		  }

		  public static List<Employee> csvToTutorials(InputStream is) {
		    try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		        CSVParser csvParser = new CSVParser(fileReader,
		            CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

		      List<Employee> developerTutorialList = new ArrayList<>();

		      Iterable<CSVRecord> csvRecords = csvParser.getRecords();

		      for (CSVRecord csvRecord : csvRecords) {
		    	  Employee employee = new Employee(
		              Long.parseLong(csvRecord.get("Id")),
		              csvRecord.get("Name"),
		              csvRecord.get("Role"),
		              Boolean.parseBoolean(csvRecord.get("Age"))
		            );

		    	  developerTutorialList.add(employee);
		      }

		      return developerTutorialList;
		    } catch (IOException e) {
		      throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
		    }
		  }

		  public static ByteArrayInputStream tutorialsToCSV(List<Employee> employeelist) {
		    final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);

		    try (ByteArrayOutputStream out = new ByteArrayOutputStream();
		        CSVPrinter csvPrinter = new CSVPrinter();) {
		      for (Employee employee : employeelist) {
		        List<String> data = Arrays.asList(
		              String.valueOf(employee.getId()),
		              employee.getAge(),
		              employee.getName(),
		              String.valueOf(employee.getRole()))
		            );

		        csvPrinter.printRecord(data);
		      }

		      csvPrinter.flush();
		      return new ByteArrayInputStream(out.toByteArray());
		    } catch (IOException e) {
		      throw new RuntimeException("fail to import data to CSV file: " + e.getMessage());
		    }
		  }
		}

}
