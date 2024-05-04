package org.robotdreams.patterns.lesson3.theory;

import java.util.*;

public class BuiltInPatternsDemo {


    public void start() {
        // inspired by:
        // https://medium.com/javarevisited/design-patterns-in-javas-in-built-libraries-d3ea5654ff35
        // https://azeynalli1990.medium.com/10-software-design-patterns-used-in-java-core-libraries-8fe2651d4f11

        System.out.println();
        System.out.println("↓↓↓↓");
        System.out.println("Starting Built In Patterns Demo");

        Iterator();

        Singleton();

        FactoryAndAdapter();

        TemplateMethod();

        System.out.println("↑↑↑↑");
        System.out.println();
    }

    private static void Iterator() {
        System.out.println("----");
        System.out.println("Iterator Pattern");
        System.out.println();
        int[] myArray = {1, 2, 3, 4};

        System.out.println("Direct iterator usage:");
        Iterator<Integer> iterator = Arrays.stream(myArray).iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("Built-in iteration support");
        for (int element : myArray) {
            System.out.println(element);
        }
    }

    private void Singleton() {
        System.out.println("----");
        System.out.println("Singleton Pattern");
        System.out.println("The java.lang.Runtime class represents the runtime environment of the Java Virtual Machine (JVM).");
        System.out.println();

        Runtime runtime1 = Runtime.getRuntime();
        Runtime runtime2 = Runtime.getRuntime();
        System.out.printf("%s%s to %s%n", "runtime1", getEqual(runtime1, runtime2), "runtime2");
    }

    private void FactoryAndAdapter() {
        System.out.println("----");
        System.out.println("Factory Pattern");
        System.out.println("The Calendar class uses the Factory pattern to create instances of its subclasses.");
        System.out.println();
        Calendar defaultCalendar = Calendar.getInstance();
        Calendar buddhistCalendar = Calendar.getInstance(TimeZone.getTimeZone("Asia/Bangkok"), new Locale("th", "TH", "TH"));
        Calendar japaneseCalendar = Calendar.getInstance(TimeZone.getTimeZone("Asia/Japan"), new Locale("ja", "JP", "JP"));
        Calendar gregoryCalendar = Calendar.getInstance(Locale.ENGLISH);

        System.out.printf("%s is %s, today: %s %n", "default Calendar", defaultCalendar.getCalendarType(), getCurrentDate(defaultCalendar));
        System.out.printf("%s is %s, today: %s %n", "buddhist Calendar", buddhistCalendar.getCalendarType(), getCurrentDate(buddhistCalendar));
        System.out.printf("%s is %s, today: %s %n", "japanese Calendar", japaneseCalendar.getCalendarType(), getCurrentDate(japaneseCalendar));
        System.out.printf("%s is %s, today: %s %n", "gregory Calendar", gregoryCalendar.getCalendarType(), getCurrentDate(gregoryCalendar));
    }

    private static void TemplateMethod() {
        System.out.println("----");
        System.out.println("Template Method Pattern");
        System.out.printf("The java.util.Collections class uses the Template Method pattern. %nThis class provides a set of methods for manipulating collections, such as sorting, searching, and shuffling. %n");
        System.out.println();
        List<Integer> list = getIntegerList();
        outputList("Default list: ", list);

        list = getIntegerList();
        Comparator<Integer> comparator = Integer::compare;
        Collections.sort(list, comparator);
        outputList("Sorted with comparator asc: ", list);

        list = getIntegerList();
        comparator = Collections.reverseOrder();
        Collections.sort(list, comparator);
        outputList("Sorted with comparator desc: ", list);
    }

    private static List<Integer> getIntegerList() {
        List<Integer> list = Arrays.asList(3, 1, 4, 1, 5, 9);
        return list;
    }

    private String getEqual(Object o1, Object o2) {
        return o1 == o2 ? " is equal" : " is NOT equal";
    }

    private String getCurrentDate(Calendar cal) {
        return String.format("%d-%02d-%02d",
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH) + 1,
                cal.get(Calendar.DAY_OF_MONTH));
    }

    public static <T> void outputList(String prefix, List<T> itemList) {
        StringBuilder result = new StringBuilder("[");

        for (int i = 0; i < itemList.size(); i++) {
            result.append("\"").append(itemList.get(i)).append("\"");

            if (i < itemList.size() - 1) {
                result.append(", ");
            }
        }

        result.append("]");

        System.out.println(prefix + result);
    }
}
