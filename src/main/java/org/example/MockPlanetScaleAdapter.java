package org.example;

import java.util.HashMap;
import java.util.Map;

public class MockPlanetScaleAdapter implements PlanetScaleAdapter {
    private static final Map<String, Double> mockFactors = new HashMap<>();

    static {
        mockFactors.put("Soleil", 0.000158);
        mockFactors.put("la Terre", 0.000158);
        mockFactors.put("Mars", 0.000158);
        mockFactors.put("la Lune", 0.000158);
    }

    @Override
    public double getScaleFactor(String planet) {
        return mockFactors.getOrDefault(planet, 1.0);
    }
}

