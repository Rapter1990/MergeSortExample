package mergesort;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;

import model.Person;
import util.ShowProcess;

public class MergeSortProcess {
	
	private static ArrayList<Person> sortedpersonList = new ArrayList<>();

	public static void byId(ArrayList<Person> personList) {
		
		Comparator<Person> compTr = new Comparator<Person>() {
			@Override
			public int compare(Person p0, Person p1) {	
				// return Long.compare(p0.getId(), p1.getId());  // DESC
				return Long.compare(p1.getId(), p0.getId()); // ASC
			}
		};

		mergeSort(personList, compTr);
		
		sortedpersonList = personList;
		
		ShowProcess.showValues(sortedpersonList);	

	}

	public static void byLastName(ArrayList<Person> personList) {

		Comparator<Person> compTr = new Comparator<Person>() {
			@Override
			public int compare(Person p0, Person p1) {
				Collator collator = Collator.getInstance(new Locale("tr", "TR"));
				// return collator.compare(p0.getLastname(), p1.getLastname()); // DESC 
				return collator.compare(p1.getLastname(), p0.getLastname()); // ASC
			}
		};

		mergeSort(personList, compTr);
		
		sortedpersonList = personList;
		
		ShowProcess.showValues(sortedpersonList);	
	}

	public static void byName(ArrayList<Person> personList) {

		Comparator<Person> compTr = new Comparator<Person>() {
			@Override
			public int compare(Person p0, Person p1) {
				Collator collator = Collator.getInstance(new Locale("tr", "TR"));
				// return collator.compare(p0.getName(), p1.getName()); // DESC 
				return collator.compare(p1.getName(), p0.getName()); // ASC 
			}
		};

		mergeSort(personList, compTr);
		
		sortedpersonList = personList;
		
		ShowProcess.showValues(sortedpersonList);	
	}

	public static void byAge(ArrayList<Person> personList) {

		Comparator<Person> compTr = new Comparator<Person>() {
			@Override
			public int compare(Person p0, Person p1) {			
				// return Long.compare(p0.getAge(), p1.getAge()); // DESC 
				return Long.compare(p1.getAge(), p0.getAge()); // ASC 
			}
		};

		mergeSort(personList, compTr);
		
		sortedpersonList = personList;
		
		ShowProcess.showValues(sortedpersonList);	
	}
	
	public static void byRegisterDate(ArrayList<Person> personList) {

		Comparator<Person> compTr = new Comparator<Person>() {
			@Override
			public int compare(Person p0, Person p1) {
				if(p0.getRegisterDate().before(p1.getRegisterDate())){
					return 1;
				}else if(p0.getRegisterDate().after(p1.getRegisterDate())) {
					return -1;
				}else {
					return 0;
				}
			}
		};

		mergeSort(personList, compTr);
		
		sortedpersonList = personList;
		
		ShowProcess.showValues(sortedpersonList);	
	}

	public static void mergeSort(ArrayList<Person> personList, Comparator<Person> compTr) {
	    ArrayList<Person> helper = new ArrayList<Person>(personList);
	    mergeSort(personList, helper, 0, personList.size(), compTr);
	}

	private static void mergeSort(ArrayList<Person> list, 
	                              ArrayList<Person> helper, 
	                              int low, 
	                              int high, 
	                              Comparator<Person> compTr) {
	    if (high - low >= 2) {
	        int middle = low + (high - low) / 2;
	        mergeSort(list, helper, low, middle, compTr); //sort left half
	        mergeSort(list, helper, middle, high, compTr); //sort right half
	        merge(list, helper, low, middle, high, compTr); // merge
	    }
	}

	private static void merge(ArrayList<Person> list, 
	                          ArrayList<Person> helper, 
	                          int low, 
	                          int middle, 
	                          int high,
	                          Comparator<Person> compTr) {

	    for (int i = low; i < high; i++) {
	        helper.set(i, list.get(i));
	    }

	    int helperLeft = low;
	    int helperRight = middle;
	    int current = low;

	    while (helperLeft < middle && helperRight < high) {
	        if (isGreaterThan(helper.get(helperLeft), helper.get(helperRight), compTr)) {
	            list.set(current, helper.get(helperLeft));
	            helperLeft++;
	        } else {
	            list.set(current, helper.get(helperRight));
	            helperRight++;
	        }
	        current++;
	    }

	    // Copy remaining elements
	    while (helperLeft < middle) {
	        list.set(current, helper.get(helperLeft));
	        helperLeft++;
	        current++;
	    }
	}
	
	public static boolean isGreaterThan(Person helperLeft,Person helperRight,Comparator<Person> compTr) {
        return greaterThan(compTr, helperLeft, helperRight);
	}

	private static boolean greaterThan(Comparator comp, Person x, Person y) {
		return comp.compare(x, y) > 0;
	}

}
