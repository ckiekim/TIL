package unit02;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTime {
	static final String[] DAY_OF_WEEK = {"","일","월","화","수","목","금","토"};
	public static void main(String[] args) throws Exception {
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
		
		printMonth(2022, 10);
		
		DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat df2 = new SimpleDateFormat("yyyy년 MM월 dd일");
		Date d = df2.parse("2022년 5월 5일");
		System.out.println(df1.format(d));
	}
	public static String dateStr(Calendar date) {
		return String.format("%d-%02d-%02d", date.get(Calendar.YEAR),
						date.get(Calendar.MONTH) + 1, date.get(Calendar.DATE));
	}
	public static void printMonth(int year, int month) {
		Calendar date = Calendar.getInstance();
		date.set(year, month-1, 1);
		int lastDayOfMonth = date.getActualMaximum(Calendar.DATE);
		int dayOfWeek = date.get(Calendar.DAY_OF_WEEK);
		System.out.println("====================");
		System.out.println("     " + year + "년 " + month + "월");
		System.out.println("일 월 화 수 목 금 토");
		for (int i=1; i<dayOfWeek; i++) {
			System.out.print("   ");
		}
		for (int i=1, k=dayOfWeek; i<=lastDayOfMonth; i++, k++) {
			System.out.print(String.format("%2d ", i));
			if (k % 7 == 0 && i != lastDayOfMonth)
				System.out.println();
		}
		System.out.println();
		System.out.println("====================");
	}
}
