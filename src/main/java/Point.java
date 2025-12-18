package main.java;

public class Point {
    int x;
    int y;
    int z;

    public Point(int x, int y, int z) {
	this.x = x;
	this.y = y;
	this.z = z;
    }

    public int getDistance(Point other) {
	int dx = x - other.x;
	int dy = y - other.y;
	int dz = z - other.z;
	return dx * dx + dy * dy + dz * dz;
    }

    public long combinedCoordinates() {
	return Long.parseLong(String.valueOf(x) + String.valueOf(y) + String.valueOf(z));
    }

    public String toString() {
	return x + "," + y + "," + z;
    }
}
