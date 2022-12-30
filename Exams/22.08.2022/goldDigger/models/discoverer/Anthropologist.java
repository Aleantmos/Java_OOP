package goldDigger.models.discoverer;

import goldDigger.models.museum.Museum;

public class Anthropologist extends BaseDiscoverer {

    private static final double INITIAL_ENERGY = 40;


    public Anthropologist(String name) {
        super(name, INITIAL_ENERGY);
    }

}
