package pharmacy_system;

import java.text.SimpleDateFormat;
import java.util.Date;

public class triel {
    public static void main(String[] args) {
        Date dNow = new Date( );
        SimpleDateFormat ft =
                new SimpleDateFormat ("E");

        System.out.println(ft.format(dNow));
    }
}
