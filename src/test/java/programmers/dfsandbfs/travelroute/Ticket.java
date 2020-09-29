package programmers.dfsandbfs.travelroute;

public class Ticket {
    private static final String FIRST_START_POINT = "ICN";
    private final String startPoint;
    private final String endPoint;

    public Ticket(final String startPoint, final String endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public boolean isFirstStartPoint() {
        return startPoint.equals(FIRST_START_POINT);
    }

    public boolean isUse(Ticket otherTicket) {
        return endPoint.equals(otherTicket.startPoint);
    }
}
