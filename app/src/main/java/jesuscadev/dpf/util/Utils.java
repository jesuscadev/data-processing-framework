package jesuscadev.dpf.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
	public enum tiposLog {logError, logAdvertencia, logInformativo}

	public static void message(String class, String message, String textLogType) {
		System.out.println(textLogType + " | " + class + " : [" + message + "]");
	}

	public static void messageAdv(String class, String message) {
		message(class, message, "ADV");
	}

	public static void messageErr(String class, String message) {
		message(class, message, "ERR");
	}

	public static void messageInf(String class, String message) {
		message(class, message, "INF");
	}

	public static Date convertStringToDate(String dateValue, String dateFormat) {
		DateFormat dateFormatter = new SimpleDateFormat(dateFormat);
		Date date = null;
		dateFormatter.setLenient(false);
		try {
			date = dateFormatter.parse(dateValue);
		} catch (ParseException e) {
			e.printStackTrace();
			return date;
		}
		return date;
	}

	public static String convertDateToString(Date dateValue, String dateFormat) {
		DateFormat dateFormatter = new SimpleDateFormat(dateFormat);
		String date = "";
		date = dateFormatter.format(dateValue);
		return date;
	}

	/*
	and call it like formatDate("2014-07-10T11:31:35"", inFormat, outFormat)

	where inFormat = "yyyy-MM-dd'T'HH:mm:ss" and outFormat = "dd/MM/yyyy"
	*/
}
