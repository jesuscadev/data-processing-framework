package jesuscadev.dpf.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
	public enum tiposLog {logError, logAdvertencia, logInformativo}

	public static void mensaje(String clase, String mensaje, String tipoLogTexto) {
		System.out.println(tipoLogTexto + " | " + clase + " : [" + mensaje + "]");
	}

	public static void mensajeAdv(String clase, String mensaje) {
		mensaje(clase, mensaje, "ADV");
	}

	public static void mensajeErr(String clase, String mensaje) {
		mensaje(clase, mensaje, "ERR");
	}

	public static void mensajeInf(String clase, String mensaje) {
		mensaje(clase, mensaje, "INF");
	}

	public static Date convertirCadenaEnFecha(String valorFecha, String formatoFecha) {
		DateFormat formateadorFecha = new SimpleDateFormat(formatoFecha);
		Date fecha = null;
		formateadorFecha.setLenient(false);
		try {
			fecha = formateadorFecha.parse(valorFecha);
		} catch (ParseException e) {
			e.printStackTrace();
			return fecha;
		}
		return fecha;
	}

	public static String convertirFechaEnCadena(Date valorFecha, String formatoFecha) {
		DateFormat formateadorFecha = new SimpleDateFormat(formatoFecha);
		String fecha = "";
		fecha = formateadorFecha.format(valorFecha);
		return fecha;
	}

	/*
	and call it like formatDate("2014-07-10T11:31:35"", inFormat, outFormat)

	where inFormat = "yyyy-MM-dd'T'HH:mm:ss" and outFormat = "dd/MM/yyyy"
	*/
}
