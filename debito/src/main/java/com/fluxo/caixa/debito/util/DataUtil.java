package com.fluxo.caixa.debito.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DataUtil {

    private DataUtil(){}

    public static LocalDate getLocalDate(String data, String pattern){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return LocalDate.parse(data, formatter);
    }

    public static String getDataAtual(String pattern){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return formatter.format(LocalDate.now());
    }
}