package nb993;

import nb993.controller.LottoController;
import nb993.view.PrintView;
import nb993.view.ScanView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ScanView scanView = new ScanView(sc);
        PrintView printView = new PrintView();
        LottoController lottoController = new LottoController(scanView, printView);
        lottoController.playGame();

        sc.close();

    }
}