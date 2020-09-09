package main;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import mergesort.MergeSortProcess;
import model.Person;
import util.DefineValues;
import util.ShowProcess;

public class Main {

	private static ArrayList<Person> personList = new ArrayList<>();
	
	
	public static void main(String[] args) throws ParseException {
		
		
		personList = DefineValues.defineValues(personList);
		
		
		System.out.println("---------------------------------");
		System.out.println("BEFORE MERGE SORT byId");
		ShowProcess.showValues(personList);	
		
		System.out.println("AFTER MERGE SORT byId");
		MergeSortProcess.byId(personList);
		System.out.println("---------------------------------\n");
		
		
		System.out.println("BEFORE MERGE SORT byLastName");		
		ShowProcess.showValues(personList);				

		System.out.println("AFTER MERGE SORT byLastName");
		MergeSortProcess.byLastName(personList);	
		System.out.println("---------------------------------\n");
		
		System.out.println("BEFORE MERGE SORT byName");
		ShowProcess.showValues(personList);

		System.out.println("AFTER MERGE SORT byName");
		MergeSortProcess.byName(personList);
		System.out.println("---------------------------------\n");
		
		System.out.println("BEFORE MERGE SORT byAge");		
		ShowProcess.showValues(personList);

		System.out.println("AFTER MERGE SORT byAge");
		MergeSortProcess.byAge(personList);
		System.out.println("---------------------------------");
		
		System.out.println("BEFORE MERGE SORT byRegisterDate");		
		ShowProcess.showValues(personList);

		System.out.println("AFTER MERGE SORT byRegisterDate");
		MergeSortProcess.byRegisterDate(personList);
		System.out.println("---------------------------------");
	}
}
