import domain.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        LottoCompany lottoCompany = new LottoCompany();
        User user = new User();
        user.goTicketOffice();
        user.checkMyTicketsFrom(lottoCompany);
    }
}
