package mg.zotoavina.core;

public enum Direction {
    UP(-1), DOWN(1), LEFT(-1), RIGHT(1);
    private final int coefficient;

    Direction(int coefficient) {
        this.coefficient = coefficient;
    }

    public int getCoefficient() {
        return coefficient;
    }
}
