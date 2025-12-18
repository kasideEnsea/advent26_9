package main.java;

public class Pair {
    Point x;
    Point y;

    public Integer getDistance() {
	return x.getDistance(y);
    }

    public Pair(Point x, Point y) {
	this.x = x;
	this.y = y;
    }

    public String getKey() {
	long xInteger = x.combinedCoordinates();
	long yInteger = y.combinedCoordinates();
	long max = Math.max(xInteger, yInteger);
	long min = Math.min(xInteger, yInteger);
	return max + "_" + min;
    }

    public void printPair() {
	System.out.println(x.toString() + " " + y.toString());
    }
}
