package com.example.demo.utilidades.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utilidades {
	
	public static String formatearFecha(Date fecha,String formatoNuevo){
		SimpleDateFormat formatter = new SimpleDateFormat(formatoNuevo);
		String fechaTexto = formatter.format(fecha);
	    return fechaTexto;
	}
	
	public static Date ParseFecha(String fecha,String formatoNuevo)
    {
        SimpleDateFormat formato = new SimpleDateFormat(formatoNuevo);
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(fecha);
        } 
        catch (ParseException ex) 
        {
            System.out.println(ex);
        }
        return fechaDate;
    }

}
