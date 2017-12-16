package pl.sdacademy.italianrestaurant.food;

import java.util.HashSet;
import java.util.Set;

public class Pasta implements Food {
    private final PastaType pastaType;
    private final String sauce;
    private final Set<String> spices;
    private final boolean parmesan;

    public PastaType getPastaType() {
        return pastaType;
    }

    public String getSauce() {
        return sauce;
    }

    public Set<String> getSpices() {
        return spices;
    }

    public boolean isParmesan() {
        return parmesan;
    }

    private Pasta(PastaBuilder pastaBuilder) {
        pastaType = pastaBuilder.pastaType;
        sauce = pastaBuilder.sauce;
        spices = pastaBuilder.spices;
        parmesan = pastaBuilder.parmesan;
    }

    public static PastaBuilder builder() {
        return new PastaBuilder();
    }

    public static class PastaBuilder {
        private PastaType pastaType;
        private String sauce;
        private Set<String> spices;
        private boolean parmesan;

        private PastaBuilder() {
            spices = new HashSet<>();
        }

        public PastaBuilder pastaType(PastaType pastaType) {
            this.pastaType = pastaType;
            return this;
        }

        public PastaBuilder sauce(String sauce) {
            this.sauce = sauce;
            return this;
        }

        public PastaBuilder spices(String spice) {
            spices.add(spice);
            return this;
        }

        public PastaBuilder spices(Set<String> spices) {
            this.spices.addAll(spices);
            return this;
        }

        public PastaBuilder parmesan(boolean parmesan) {
            this.parmesan = parmesan;
            return this;
        }

        public Pasta build() {
            return new Pasta(this);
        }
    }
}
