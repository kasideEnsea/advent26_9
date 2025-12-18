package main.java;

import java.util.List;
import java.util.stream.Collectors;

public class Chain {
    List<Point> points;

    public boolean hasPoint(Point point) {
	return points.contains(point);
    }

    public boolean hasPair(Pair pair) {
	return points.contains(pair.x) && points.contains(pair.y);
    }

    public Chain(List<Point> points) {
	this.points = points;
    }

    public void addPoint(Point point) {
	points.add(point);
    }

    public void addChain(Chain chain) {
	points.addAll(chain.points);
    }

    public int getSize() {
	return points.size();
    }

    @Override
    public String toString() {
	return points.stream().map(String::valueOf).collect(Collectors.joining(" - "));
    }
}
