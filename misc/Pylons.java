package misc;

import java.util.Arrays;

public class Pylons{



// 1. while all cities are powered
// 	1.1 pick a city which will have the maximum impact wrt supply standings
// 	1.2 build power plant there and update the supply standings

	public static void run(){

		System.out.println(pylons(2, new int[]{0, 1, 1, 1, 1, 0}));
	}

	static boolean allCitiesPowered(int[] dist){
		for(int p : dist){
			if (p == 0) return false;
		}
		return true;
	}

	static int getCityWithMaxImpact(int[] cities, int[] dist, int k){
		int currOptimalCity = -1;
		int currOptimalRange = -1;
		for(int cx = 0; cx < cities.length; cx++){
			if (cities[cx] == 1){
				// # feasible city found
				int range = 0;
				range++; // for the city in which the plant resides

				for(int ix = cx + 1; ix <= (cx + k); ix++){
					if (ix < dist.length && dist[ix] == 0){
						range++;
					}
				}
				for(int ix = cx - 1; ix >= (cx - k); ix--){
					if (ix >= 0 && dist[ix] == 0){
						range++;
					}
				}
				if (range > currOptimalRange){
					currOptimalRange = range;
					currOptimalCity = cx;
				}
			}
		}

		return currOptimalCity;
	}

	static void installPylon(int[] dist, int pos, int k){

		for(int ix = pos; ix <= (pos + k); ix++){
			if (ix >=0 && ix < dist.length){
				dist[ix]++;
			}
		}
		for(int ix = pos; ix >= (pos - k); ix--){
			if (ix >=0 && ix < dist.length){
				dist[ix]++;
			}
		}
	}

	

    static int pylons(int k, int[] cities) {
		k--; // adjusting k

		// if notComplete(k, cities){
		// 	return -1;
		// }

		int[] powDist = new int[cities.length];
		int pylonsCount = 0;
		System.out.println("A cits: " + Arrays.toString(cities));

    	while(!allCitiesPowered(powDist)){
			System.out.println("I dist: " + Arrays.toString(powDist));
			int prospectCity = getCityWithMaxImpact(cities, powDist, k);
			System.out.println("Pros city: " + prospectCity);
			installPylon(powDist, prospectCity, k);
			System.out.println("P dist: " + Arrays.toString(powDist));
			pylonsCount++;
    	}
		return pylonsCount;
	}

	
}