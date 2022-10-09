package unit02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Collection {

	public static void main(String[] args) {
		List al = new ArrayList(16);
		int[] arr = {3, 5, 7, 9, 1};
		String[] strArr = "A quick brown fox".split(" ");
		System.out.println(Arrays.toString(arr));
		
		al.add(arr);
		System.out.println(al.size());
		System.out.println(Arrays.toString((int[])al.get(0)));
		
		al.remove(0);
		for (int i: arr)
			al.add(i);
		for (String str: strArr)
			al.add(str);
		al.add('c');
		System.out.println(al);
		printList(al);
		
		Iterator it = al.iterator();
		while(it.hasNext())
			System.out.println(it.next());
//		for (Object element: al) 
//			System.out.println(element);
		
		System.out.println(new ArrayList(al.subList(4, 9)));
		
		int[] arr2 = Arrays.copyOfRange(arr, 2, 9);
		System.out.println(Arrays.toString(arr2));
		Arrays.setAll(arr2, i -> i*i);
		System.out.println(Arrays.toString(arr2));
		List al2 = new ArrayList(Arrays.asList(arr2));
		//System.out.println(al2.get(0).getClass().getName());
		System.out.println(Arrays.binarySearch(arr2, 9));
		
		//Arrays.sort(strArr, String.CASE_INSENSITIVE_ORDER);
		Arrays.sort(strArr, Comparator.reverseOrder());
		System.out.println(Arrays.toString(strArr));
		
		Object[] objArr = {1, 3.14, "2", 'c', "Str", "2", "2"};
		Set hs = new HashSet();
		for (Object obj: objArr)
			hs.add(obj);
		System.out.println(hs);
		printList(new ArrayList(hs));
		
		hs.clear();
		hs.add(new Person("Maria", 25));
		hs.add(new Person("James", 23));
		printList(new ArrayList(hs));
		
		Set ts = new TreeSet();
		for (int a: arr)
			ts.add(a);
		System.out.println(ts);
		
		ts.clear();
		ts.add(new Person("Maria", 25));
		ts.add(new Person("James", 23));
		ts.add(new Person("Brian", 33));
		ts.add(new Person("Anne", 23));
		System.out.println(ts);
		
	}
	
	public static void printList(List al) {
		for (int i=0; i<al.size(); i++) {
			String pre = (i == 0) ? "[" : ", ";
			System.out.print(pre);
			String type = al.get(i).getClass().getName();
			if (type.indexOf("String") >= 0)
				System.out.print("\""+al.get(i)+"\"");
			else if (type.indexOf("Character") >= 0)
				System.out.print("'"+al.get(i)+"'");
			else
				System.out.print(al.get(i));
		}
		System.out.println("]");
	}
}
