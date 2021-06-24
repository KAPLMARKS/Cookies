import java.sql.Time;

public class OrderT {
    int orderID;
    int employeeID;
    Time dateGet;
    Time dateArrived;
    Status status;
    int staffID;
    int cabinet;

    public OrderT(int orderID, int employeeID, Time dateGet, Time dateArrived, Status status, int staffID, int cabinet) {
        this.orderID = orderID;
        this.employeeID = employeeID;
        this.dateGet = dateGet;
        this.dateArrived = dateArrived;
        this.status = status;
        this.staffID = staffID;
        this.cabinet = cabinet;
    }
}
enum Status{
    DECLINED("Отклонен"),
    WAITING("На рассмотрении");
    //еще какие нибудь статусы
    public final String messsage;

    Status(String messsage) {
        this.messsage = messsage;
    }
}
