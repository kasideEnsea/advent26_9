package main.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
	String filePath = "C:\\Users\\tutiv\\IdeaWorkspace\\IdeaWorkspace\\advent26_9\\src\\main\\resources\\input.txt";
	try {
	    List<Point> points = readLinesFromFile(filePath);
	    List<Point> normalizedPoints = SquaresMeasurement.normalizePoints(points);
	    List<Edge> edges = SquaresMeasurement.generateEdges(normalizedPoints);
	    Map<Long, Square> squareMap = SquaresMeasurement.getAllSquares(normalizedPoints);
	    SquaresMeasurement.findWhoIsntCrossed(squareMap, edges);
	} catch (IOException e) {
	    System.err.println("Ошибка чтения файла: " + e.getMessage());
	}
    }

    // Метод для чтения строк из файла
    public static List<Point> readLinesFromFile(String filePath) throws IOException {
	List<Point> result = new ArrayList<>();

	try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
	    String line;
	    while ((line = reader.readLine()) != null) {
		String[] parts = line.split(",");
		Point point = new Point(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
		result.add(point);
	    }
	}
	return result;
    }
}