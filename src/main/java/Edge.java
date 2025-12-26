package main.java;

public class Edge {
    Point begin;
    Point end;
    EdgeType edgeType;

    public Edge(Point begin, Point end) {
	this.edgeType = (begin.x == end.x) ? EdgeType.VERTICAL : EdgeType.HORIZONTAL;
	if (EdgeType.VERTICAL.equals(edgeType)) {
	    if (begin.y < end.y) {
		this.begin = begin;
		this.end = end;
	    } else {
		this.begin = end;
		this.end = begin;
	    }
	} else {
	    if (begin.x < end.x) {
		this.begin = begin;
		this.end = end;
	    } else {
		this.begin = end;
		this.end = begin;
	    }
	}

    }

}
