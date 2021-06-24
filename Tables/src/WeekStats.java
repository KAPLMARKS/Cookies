import java.sql.Time;

public class WeekStats {
    int productID;
    int counter;
    int cabinet;
    int employeeID;
    Time date;

    public WeekStats(int productID, int counter, int cabinet, int employeeID, Time date) {
        this.productID = productID;
        this.counter = counter;
        this.cabinet = cabinet;
        this.employeeID = employeeID;
        this.date = date;
    }
}
