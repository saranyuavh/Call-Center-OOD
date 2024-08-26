package saranyu.ood;

public class Call {
    CallStatus status;
    IEmployee handler;

    static int globalCallId = 1;

    int callId;
    public Call() {
        status = CallStatus.REQUESTED;
        callId = ++globalCallId;
    }

    public CallStatus getStatus() {
        return status;
    }

    public void setStatus(CallStatus status) {
        this.status = status;
    }

    public IEmployee getHandler() {
        return handler;
    }

    public void setHandler(IEmployee handler) {
        this.handler = handler;
    }

    public int getCallId() {
        return callId;
    }

    public void setCallId(int callId) {
        this.callId = callId;
    }

    public void execute() {
        this.handler = EmployeeAllocator.getEmployee(Hierarchy.getFirstResponder());
        handler.execute(this);

    }
}
