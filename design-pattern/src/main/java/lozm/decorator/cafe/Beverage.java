package lozm.decorator.cafe;

public abstract class Beverage {

    String description = "내용";
    String size = "사이즈";

    protected static final String TALL = "TALL";
    protected static final String MEDIUM = "MEDIUM";
    protected static final String SMALL = "SMALL";

    public String getDescription() {
        return description;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public abstract double cost();

}
