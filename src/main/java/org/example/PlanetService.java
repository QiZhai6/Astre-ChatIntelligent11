package org.example;

import org.springframework.stereotype.Service;

@Service
public class PlanetService {
    private final PlanetScaleAdapter adapter;

    public PlanetService(PlanetScaleAdapter adapter) {
        this.adapter = new PlanetServiceProxy(adapter);
    }

    public double getScaleFactor(String planet) {
        return adapter.getScaleFactor(planet);
    }

    public double getProportion(String planet) {
        return 1.0; //
    }


}


