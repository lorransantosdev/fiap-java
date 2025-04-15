package org.example.repository;

import java.util.List;
import java.util.Locale;

public interface ValueFormatterRepository {

    public int getAmountOfValues();

    public Locale getShowTypeLocale();

    public char getSeparatorType();

    public List<Double> getDecimalValues(int amount);

    public void formatAndPrintValues(List<Double> values, char separatorType, Locale locale);

}
