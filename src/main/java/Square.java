package main.java;

public class Square {
    Point one;
    Point another;

    private final int minX;
    private final int maxX;
    private final int minY;
    private final int maxY;

    public Square(Point one, Point another) {
	this.one = one;
	this.another = another;
	minX = Math.min(one.x, another.x);
	maxX = Math.max(one.x, another.x);
	minY = Math.min(one.y, another.y);
	maxY = Math.max(one.y, another.y);
    }

    public boolean intersects(Edge edge) {
	if (edge.edgeType == EdgeType.VERTICAL) {
	    int x = edge.begin.x;
	    return x > minX && x < maxX && edge.end.y > minY && edge.begin.y < maxY;
	} else { // HORIZONTAL
	    int y = edge.begin.y;
	    return y > minY && y < maxY && edge.end.x > minX && edge.begin.x < maxX;
	}
    }
}
