package application.domain;

public class Result {

    private final int matchCount;
    private final boolean bonus;

    public Result(int matchCount, boolean bonus) {
        this.matchCount = matchCount;
        this.bonus = bonus;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean getBonus() {
        return bonus;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (!(object instanceof Result)) {
            return false;
        }

        Result result = (Result) object;
        return matchCount == result.getMatchCount()
            && bonus == result.getBonus();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
