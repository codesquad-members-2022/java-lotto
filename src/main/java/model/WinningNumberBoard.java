package model;

public enum WinningNumberBoard {
    THREE(3,5000),
    FOUR(4,50000),
    FIVE(5,1500000),
    SIX(6,2000000000);

    int num;
    int price;

    WinningNumberBoard(int num, int price) {
        this.num = num;
        this.price = price;
    }

}
