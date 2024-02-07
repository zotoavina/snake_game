package mg.zotoavina.core;

import static mg.zotoavina.core.Support.HORIZONTAL;
import static mg.zotoavina.core.Support.VERTICAL;

public enum Direction {
    UP(-1, VERTICAL),
    DOWN(1, VERTICAL),
    LEFT(-1, HORIZONTAL),
    RIGHT(1, HORIZONTAL);
    private final int coefficient;
    private final Support support;

    Direction(int coefficient, Support support) {
        this.coefficient = coefficient;
        this.support = support;
    }

    public int getCoefficient() {
        return coefficient;
    }

    public boolean opposed(Direction direction) {
        return support.equals(direction.support)
                && (coefficient + direction.getCoefficient() == 0);
    }
}

enum Support {
    VERTICAL, HORIZONTAL
}
