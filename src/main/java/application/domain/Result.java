package application.domain;

public class Result {

    private final int matchCount;
    private final Boolean bonus;

    public Result(int matchCount, Boolean bonus) {
        this.matchCount = matchCount;
        this.bonus = bonus;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public Boolean getBonus() {
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
        return (matchCount == result.getMatchCount() && bonus == null && result.getBonus() == null)
                || (matchCount == result.getMatchCount() && bonus == result.getBonus());
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "Result{" +
                "matchCount=" + matchCount +
                ", bonus=" + bonus +
                '}';
    }
}
