package main.java;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FirstStar {

    public List<Chain> getChains(List<Point> points, int maxi) {
	int garlandsUsed = 0;
	List<Chain> chains = new ArrayList<>();
	List<Pair> pairs = sortPoints(points);
	//pairs.subList(0, maxi*2).forEach(Pair::printPair);
	for (Pair pair : pairs) {
	    Chain xChain = whatChainIamIn(chains, pair.x);
	    Chain yChain = whatChainIamIn(chains, pair.y);

	    // Одиночные коробки
	    if (xChain == null && yChain == null) {
		chains.add(new Chain(new ArrayList<>(List.of(pair.x, pair.y))));
		System.out.println("Одинокое - " + pair.x + " - " + pair.y);
	    }
	    // Одинокая X
	    else if (xChain == null) {
		System.out.println("Присоединяю к - " + yChain + " новое " + pair.x);
		yChain.addPoint(pair.x);
	    }
	    // Одинокая Y
	    else if (yChain == null) {
		System.out.println("Присоединяю к - " + xChain + " новое " + pair.y);
		xChain.addPoint(pair.y);
	    }
	    // В одной цепи
	    else if (xChain.equals(yChain)) {
		System.out.println(pair.x + " и " + pair.y + " в одной цепи");
		continue;
	    } else {
		xChain.addChain(yChain);
		chains.remove(yChain);
		System.out.println("Соединение цепей, получилось " + xChain);
	    }

	    garlandsUsed++;
	    if (garlandsUsed >= maxi) {
		break;
	    }

	}
	return chains;
    }

    public Chain whatChainIamIn(List<Chain> chains, Point point) {
	for (Chain chain : chains) {
	    if (chain.hasPoint(point))
		return chain;
	}
	return null;
    }

    public boolean isPairConnected(List<Chain> chains, Pair pair) {
	for (Chain chain : chains) {
	    if (chain.hasPair(pair))
		return true;
	}
	return false;
    }

    public List<Pair> sortPoints(List<Point> points) {
	List<Pair> pairs = new ArrayList<>();
	Set<String> visited = new HashSet<>();
	for (int i = 0; i < points.size(); i++) {
	    for (int j = 0; j < points.size(); j++) {
		if (i == j) {
		    continue;
		}
		Pair pair = new Pair(points.get(i), points.get(j));
		String key = pair.getKey();
		if (visited.contains(key)) {
		    continue;
		}
		visited.add(key);
		pairs.add(pair);
	    }
	}
	return pairs.stream().sorted(Comparator.comparing(Pair::getDistance)).toList();
    }

}
