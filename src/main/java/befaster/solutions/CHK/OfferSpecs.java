package befaster.solutions.CHK;

class OfferSpecs implements Comparable {

    private final int offerMultiple;
    private String constrainingSku;
    private int offerPrice;

    public OfferSpecs(String constrainingSku, int offerMultiple, int offerPrice) {
        this.constrainingSku = constrainingSku;
        this.offerMultiple = offerMultiple;
        this.offerPrice = offerPrice;
    }

    public String getConstrainingSku() {
        return constrainingSku;
    }

    public int getOfferPrice() {
        return offerPrice;
    }

    public int getOfferMultiple() {
        return offerMultiple;
    }

    @Override
    public int compareTo(Object o) {
        o = (OfferSpecs) o;

        (this.offerPrice / this.offerMultiple) - (((OfferSpecs) o).getOfferPrice() - ((OfferSpecs) o).getOfferMultiple())
    }
}


