package just.december.streams;

import java.util.*;
import java.util.stream.Collectors;

public class StreamPro {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        System.out.println("Sorting Even Numbers : ");
        List<Integer> sortingEvenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(sortingEvenNumbers);  // Output: [2, 4, 6, 8]

        System.out.println("Counting Length Of String : ");
        List<String> countingLengthOfString = new ArrayList<>();
        countingLengthOfString.add("Nikhil");
        countingLengthOfString.add("More");
        List<Integer> mappings = countingLengthOfString.stream()
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println(mappings);

        System.out.println("Arrange In Ascending Order : ");
        List<Integer> arrangeInAscendingOrder = Arrays.asList(3, 1, 4, 1, 5, 9, 2);
        List<Integer> sortedNumbers = arrangeInAscendingOrder.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(sortedNumbers);  // Output: [1, 1, 2, 3, 4, 5, 9]

        System.out.println("Sum Of Numbers By Reduce : ");
        List<Integer> sumOfNumbersByReduce = Arrays.asList(1, 2, 3, 4, 5);
        int sum = sumOfNumbersByReduce.stream()
                .reduce(0, Integer::sum);
        System.out.println(sum);  // Output: 15

        System.out.println("Sum Of Numbers By ParallelStream : ");
        List<Integer> sumOfNumbersByParallelStream = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int sumByParallelStream = numbers.parallelStream()
                .reduce(0, Integer::sum);
        System.out.println(sumByParallelStream);  // Output: 55

        System.out.println("Even Number Sorting Using Set :");
        List<Integer> evenSortUsingSet = Arrays.asList(1, 2, 3, 4, 5, 6);
        Set<Integer> evenNumbersSet = evenSortUsingSet.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toSet());
        System.out.println(evenNumbersSet);  // Output: [2, 4, 6]

        System.out.println("Making Single List Of Different Lists : ");
        List<List<Integer>> makeSingleListOfDifferenLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7)
        );
        List<Integer> flattenedList = makeSingleListOfDifferenLists.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println(flattenedList);  // Output: [1, 2, 3, 4, 5, 6, 7]

        System.out.println("Checking All Positive Or Not : ");
        List<Integer> checkingAllPositiveOrNot = Arrays.asList(1, 2, 3, 4);
        boolean allPositive = checkingAllPositiveOrNot.stream()
                .allMatch(n -> n > 0);
        System.out.println(allPositive);  // Output: true

        System.out.println("Take First Three Numbers Only : ");
        List<Integer> takeFirstThreeNumbersOnly = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> firstThree = takeFirstThreeNumbersOnly.stream()
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(firstThree);  // Output: [1, 2, 3]

        System.out.println("Sum Of String Which Have More Than 3 Length : ");
        List<String> sumOfStringWhichHaveMoreThan_3_Length = Arrays.asList("java", "python", "scala", "go");
        int totalLength = sumOfStringWhichHaveMoreThan_3_Length.stream()
                .filter(word -> word.length() > 3)  // Filter words with more than 3 characters
                .map(String::toUpperCase)            // Convert to uppercase
                .map(String::length)                 // Get lengths of the words
                .reduce(0, Integer::sum);            // Sum the lengths
        System.out.println(totalLength);  // Output: 15

    }
}

/*
Benefits of Using the Stream API in Java:
Declarative Style: Writing code with Stream API is usually more concise and expressive.
Functional Operations: The Stream API allows for a more functional programming style, making it easier to compose operations.
Lazy Evaluation: Intermediate operations are lazily evaluated, meaning they are not executed until a terminal operation (such as collect, forEach, reduce) is called.
Parallel Processing: Streams can be processed in parallel with minimal effort, taking advantage of multi-core processors.
Conclusion:
The Java Stream API simplifies data processing, making your code more concise, readable, and easier to maintain. It allows you to perform complex operations like filtering, mapping, sorting, reducing, and more in a fluent, functional style, and can improve performance with parallel processing on large datasets.*/
