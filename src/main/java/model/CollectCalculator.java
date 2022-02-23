package model;

public enum CollectCalculator {

    THREE(3, 5000) {
        @Override
        long calculate(int count) {
            return count * THREE.price;
        }
    },
    FOUR(4, 50000) {
        @Override
        long calculate(int count) {
            return count * FOUR.price;
        }
    },
    FIVE(5, 1500000) {
        @Override
        long calculate(int count) {
            return count * FIVE.price;
        }
    },
    SIX(6, 2000000000) {
        @Override
        long calculate(int count) {
            return count * SIX.price;
        }
    };

    public static long getCalculator(int number, int count) {
        switch (number) {
            case 3:
                return THREE.calculate(count);
            case 4:
                return FOUR.calculate(count);
            case 5:
                return FIVE.calculate(count);
            default:
                return SIX.calculate(count);
        }
    }

    // TODO
    private long price;
    private int collectCount;

    CollectCalculator(int collectCount, long price) {
        this.collectCount = collectCount;
        this.price = price;
    }


    abstract long calculate(int count);
}
