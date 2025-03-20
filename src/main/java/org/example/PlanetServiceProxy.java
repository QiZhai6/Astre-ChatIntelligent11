package org.example;

import java.util.HashMap;
import java.util.Map;

public class PlanetServiceProxy implements PlanetScaleAdapter {
    private final PlanetScaleAdapter realService;
    private final Map<String, Double> cache = new HashMap<>();

    public PlanetServiceProxy(PlanetScaleAdapter realService) {
        this.realService = realService;
    }

    @Override
    public double getScaleFactor(String planet) {
        if (cache.containsKey(planet)) {
            System.out.println("Recherche dans le cache: " + planet);
            return cache.get(planet);
        }

        double factor = realService.getScaleFactor(planet);
        cache.put(planet, factor);
        System.out.println("Calcul et stockage dans la mémoire cache: " + planet);
        return factor;
    }
}

