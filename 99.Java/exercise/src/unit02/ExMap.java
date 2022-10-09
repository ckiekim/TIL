package unit02;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ExMap {
	public static void main(String[] args) {
		Map hm = new HashMap();
		hm.put("james", "1234");
		hm.put("maria", "1234");
		hm.put("brian", "3456");
		System.out.println(hm);
		System.out.println(hm.entrySet());
		System.out.println(hm.keySet());
		for (Object s: hm.keySet())
			System.out.println(s + ": " + hm.get(s));
		
		Random ran = new Random();
		int[] dice = new int[30];
		for (int i=0; i<dice.length; i++)
			dice[i] = ran.nextInt(6) + 1;
		System.out.println(Arrays.toString(dice));
		
		hm.clear();
		for (int key: dice) {
			if (hm.containsKey(key)) {
				int val = (int)hm.get(key);
				hm.put(key, val+1);
			} else {
				hm.put(key, 1);
			}
		}
		for (Object s: hm.keySet())
			System.out.println(s + ": " + hm.get(s));
	}
}
