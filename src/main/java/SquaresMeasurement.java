package main.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SquaresMeasurement {
    public static List<Point> normalizePoints(List<Point> points) {
	List<Point> norm = new ArrayList<>();
	int minX = getMinX(points);
	int minY = getMinY(points);

	for (Point point : points) {
	    Point newPoint = new Point(point.x - minX, point.y - minY);
	    norm.add(newPoint);
	}

	return norm;
    }

    public static List<Edge> generateEdges(List<Point> points) {
	List<Edge> edges = new ArrayList<>();
	for (int i = 0; i < points.size(); i++) {
	    if (i < points.size() - 1) {
		edges.add(new Edge(points.get(i), points.get(i + 1)));
	    } else {
		edges.add(new Edge(points.get(i), points.get(0)));
	    }
	}
	return edges;
    }

    private static Integer getMinX(List<Point> points) {
	return points.stream().map(point -> point.x).min(Integer::compareTo).orElse(0);
    }

    private static Integer getMinY(List<Point> points) {
	return points.stream().map(point -> point.y).min(Integer::compareTo).orElse(0);
    }

    public static Map<Long, Square> getAllSquares(List<Point> normalizedPoints) {
	Map<Long, Square> squares = new TreeMap<>(Collections.reverseOrder());
	for (int i = 0; i < normalizedPoints.size() - 1; i++) {
	    for (int j = i + 1; j < normalizedPoints.size(); j++) {
		squares.put(normalizedPoints.get(i).getSquare(normalizedPoints.get(j)),
			new Square(normalizedPoints.get(i), normalizedPoints.get(j)));
	    }
	}
	return squares;
    }

    public static void findWhoIsntCrossed(Map<Long, Square> squareMap, List<Edge> edges) {
	for (Map.Entry<Long, Square> entry : squareMap.entrySet()) {
	    boolean intercepted = false;
	    for (Edge edge : edges) {
		if (entry.getValue().intersects(edge)) {
		    intercepted = true;
		    break;
		}
	    }
	    if (!intercepted){
		//System.out.println("One: x=" + entry.getValue().one.x + ", y=" + entry.getValue().one.y);
		//System.out.println("Another: x=" + entry.getValue().another.x + ", y=" + entry.getValue().another.y);
		System.out.println(entry.getKey());
		return;
	    }
	}
    }
}
