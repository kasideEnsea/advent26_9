package main.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
	String filePath = "C:\\Users\\tutiv\\IdeaWorkspace\\IdeaWorkspace\\advent26_8\\src\\main\\resources\\test.txt";
	try {
	    List<Point> result = readLinesFromFile(filePath);
	    FirstStar star = new FirstStar();
	    List<Chain> chains = star.getChains(result, 10);
	    long mult = multOfThreeLongestChains(chains);
	    System.out.println(mult);
	} catch (IOException e) {
	    System.err.println("Ошибка чтения файла: " + e.getMessage());
	}
    }

    private static long multOfThreeLongestChains(List<Chain> chains) {
	chains = chains.stream().sorted(Comparator.comparing(Chain::getSize).reversed()).toList();
	return (long) chains.get(0).getSize() * chains.get(1).getSize() * chains.get(2).getSize();
    }

    // Метод для чтения строк из файла
    public static List<Point> readLinesFromFile(String filePath) throws IOException {
	List<Point> result = new ArrayList<>();

	try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
	    String line;
	    while ((line = reader.readLine()) != null) {
		String[] parts = line.split(",");

		Point point = new Point(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]),
			Integer.parseInt(parts[2]));
		result.add(point);
	    }
	}
	return result;
    }
}