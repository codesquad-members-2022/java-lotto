package PACKAGE_NAME.domain;

import java.util.Objects;

public class RateOfReturn {

    private double rateOfReturn;

    public RateOfReturn(double rateOfReturn) {
        this.rateOfReturn = rateOfReturn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RateOfReturn that = (RateOfReturn) o;
        return Double.compare(that.rateOfReturn, rateOfReturn) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rateOfReturn);
    }
}
