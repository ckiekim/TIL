package unit02;

import java.util.Calendar;

public class DateTime {
	static final String[] DAY_OF_WEEK = {"","일","월","화","수","목","금","토"};
	public static void main(String[] args) {
		Calendar today = Calendar.getInstance();	// 2022-10-08
		int year = today.get(Calendar.YEAR);
		int month = today.get(Calendar.MONTH) + 1;
		int lastDayOfMonth = today.getActualMaximum(Calendar.DATE);
		System.out.printf("%d-%02d, %d%n", year, month, lastDayOfMonth);
		
		Calendar date2 = Calendar.getInstance();
		date2.set(2022, 11, 25);		// 2022-12-25
		System.out.println(DAY_OF_WEEK[date2.get(Calendar.DAY_OF_WEEK)]);
		
		long diff = date2.getTimeInMillis() - today.getTimeInMillis();
		int dayDiff = (int) (diff / (24*60*60*1000));
		System.out.println(dayDiff);
		System.out.println(dateStr(today));
	}
	public static String dateStr(Calendar date) {
		return String.format("%d-%02d-%02d", date.get(Calendar.YEAR),
						date.get(Calendar.MONTH) + 1, date.get(Calendar.DATE));
	}
}
