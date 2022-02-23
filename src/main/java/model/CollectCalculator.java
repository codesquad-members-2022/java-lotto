package model;

public enum CollectCalculator {

    THREE(5000) {
        @Override
        long calculate(int count) {
            return count * THREE.price;
        }
    },
    FOUR(50000) {
        @Override
        long calculate(int count) {
            return count * FOUR.price;
        }
    },
    FIVE(1500000) {
        @Override
        long calculate(int count) {
            return count * FIVE.price;
        }
    },
    SIX(2000000000) {
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

    private long getPrice() {
        return price;
    }

    public static long getWinnerMoney(int number) {
        switch (number) {
            case 3:
                return THREE.getPrice();
            case 4:
                return FOUR.getPrice();
            case 5:
                return FIVE.getPrice();
            default:
                return SIX.getPrice();
        }
    }

    private final long price;

    CollectCalculator(long price) {
        this.price = price;
    }

    abstract long calculate(int count);
}
