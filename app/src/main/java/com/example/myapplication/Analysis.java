package com.example.myapplication;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Analysis {


    public HashMap<String,Double> calculateWeightedMap(int gmoImp, int costImp, int timeImp, int locationImp) {
        HashMap<String,Double> map = new HashMap<>();

        if (gmoImp == 4) {
            map.put("gmo", 0.75);
        }
        if (costImp == 4) {
            map.put("distance", 0.75);
        }
        if (timeImp == 4) {
            map.put("time", 0.75);
        }
        if (locationImp == 4) {
            map.put("location", 0.75);
        }
        if (gmoImp == 3) {
            map.put("gmo", 0.1875);
        }
        if (costImp == 3) {
            map.put("distance", 0.1875);
        }
        if (timeImp == 3) {
            map.put("time", 0.1875);
        }
        if (locationImp == 3) {
            map.put("location", 0.1875);
        }
        if (gmoImp == 2) {
            map.put("gmo", 0.0556);
        }
        if (costImp == 2) {
            map.put("distance", 0.0556);
        }
        if (timeImp == 2) {
            map.put("time", 0.0556);
        }
        if (locationImp == 2) {
            map.put("location", 0.0556);
        }
        if (gmoImp == 1) {
            map.put("gmo", 0.0185);
        }
        if (costImp == 1) {
            map.put("distance", 0.0185);
        }
        if (timeImp == 1) {
            map.put("time", 0.0185);
        }
        if (locationImp == 1) {
            map.put("location", 0.0185);
        }
        return map;
    }

    /** Returns double array in order: location, cost, GMO, time
     */
    public double[] findWeights(String location, int cost, boolean GMO, int time) {
        double[] toReturn = new double[4];
        toReturn[0] = 1;
        if (cost > 5000) {
            toReturn[1] = 0;
        } else {
            toReturn[1] = 1;
        }
        if (GMO) {
            toReturn[2] = 1;
        } else {
            toReturn[2] = 0;
        }
        if (time > 10) {
            toReturn[3] = 0;
        } else {
            toReturn[3] = 1;
        }
        return toReturn;
    }

    public Seller[] sellerWeightGenerator(Seller[] sellers, User user, double[] userRankings, HashMap<String, Double> topFour) {
        Map<Double, Seller> sellerMap = new HashMap<>();
        for (Seller seller : sellers) {
            double[] rankingSet = new double[4];
            if (seller.getLocation().equals(user.getLocation())) {
                rankingSet[0] = topFour.get("Location");
            } else {
                rankingSet[0] = 0.0;
            }
            if (user.getMaxDeliveryTime() > seller.getCrop().getDaysFromHarvest()) {
                rankingSet[1] = topFour.get("Time");
            } else {
                rankingSet[1] = -1 * topFour.get("Time");
            }
            if (seller.getCrop().isGMO() && user.getGMO()) {
                rankingSet[2] = topFour.get("GMO");
            } else {
                rankingSet[2] = 0.0;
            }
            if (user.getMaxPrice() > seller.getCrop().getCost()) {
                rankingSet[3] = topFour.get("Cost");
            } else {
                rankingSet[3] = -1 * topFour.get("Cost");
            }
            sellerMap.put(cosineSimilarity(rankingSet, userRankings), seller);
        }

        return rank(sellerMap);
    }

    public Seller[] rank(Map<Double, Seller> sellerMap) {
        Seller[] sellers = new Seller[sellerMap.values().size()];
        ArrayList<Double> valuesArrayList = (ArrayList) sellerMap.keySet();
        Collections.sort(valuesArrayList);
        for (int i = 0; i < sellerMap.values().size(); i++) {
            sellers[i] = sellerMap.get(valuesArrayList.get(i));
        }
        return sellers;
    }

    public double cosineSimilarity(double[] vectorA, double[] vectorB) {
        double dotProduct = 0.0;
        double normA = 0.0;
        double normB = 0.0;
        for (int i = 0; i < vectorA.length; i++) {
            dotProduct += vectorA[i] * vectorB[i];
            normA += Math.pow(vectorA[i], 2);
            normB += Math.pow(vectorB[i], 2);
        }
        return dotProduct / (Math.sqrt(normA) * Math.sqrt(normB));
    }
}
