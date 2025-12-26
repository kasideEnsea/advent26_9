package main.java;

import java.util.List;
import java.util.Objects;

public class Point {
    int x;
    int y;

    public Point(int x, int y) {
	this.x = x;
	this.y = y;
    }

    public Long getSquare(Point other) {
	long dx = Math.abs(x - other.x)+1;
	long dy = Math.abs(y - other.y)+1;
	return dx*dy;
    }

    public String toString() {
	return x + "," + y;
    }

    @Override
    public boolean equals(Object o) {
	if (this == o) return true;
	if (o == null || getClass() != o.getClass()) return false;
	Point point = (Point) o;
	return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
	return Objects.hash(x, y);
    }
}
