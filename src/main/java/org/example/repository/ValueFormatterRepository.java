package org.example.repository;

import java.util.List;
import java.util.Locale;

public interface ValueFormatterRepository {

    public int getDecimalPlacesFromUser();

    public Locale getShowTypeSymbols();

    public char getSeparatorTypeFromUser();

    public List<Double> getDecimalValuesFromUser(int amount);

    public void formatAndPrintValues(List<Double> values, char separatorType, Locale locale);

}
