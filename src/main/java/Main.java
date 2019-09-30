import com.anz.service.RelativeBalanceService;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger("Main.class");

    public static void main(String[] args) {

        RelativeBalanceService relativeBalanceService = new RelativeBalanceService();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        Scanner in = new Scanner(System.in);

        try {
            System.out.println("accountId: ");
            String accountId = in.next();
            System.out.println("from: ");
            in.nextLine();
            Date fromDate = dateFormat.parse(in.nextLine());
            System.out.println("to: ");
            Date toDate = dateFormat.parse(in.nextLine());
            Map<String,String> result= relativeBalanceService.process(accountId,fromDate,toDate);
            System.out.println("Relative balance for the period is: " + result.get("balance"));
            System.out.println("Number of transactions included is: " + result.get("count"));

        }catch (ParseException e)
        {
            logger.log(Level.SEVERE,"Exception while parsing the provided dates");
        }

    }
}
