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
    },
    BONUS(30000000) {
        @Override
        long calculate(int count) {
            return count * BONUS.price;
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
            case 6:
                return SIX.calculate(count);
            default:
                return BONUS.calculate(count);
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
            case 6:
                return SIX.getPrice();
            default:
                return BONUS.getPrice();
        }
    }

    private final long price;

    CollectCalculator(long price) {
        this.price = price;
    }

    abstract long calculate(int count);
}
