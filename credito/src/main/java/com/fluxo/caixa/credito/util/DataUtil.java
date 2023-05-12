package com.fluxo.caixa.credito.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DataUtil {

    private DataUtil(){}

    public static LocalDate getLocalDate(String data, String pattern){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return LocalDate.parse(data, formatter);
    }
}