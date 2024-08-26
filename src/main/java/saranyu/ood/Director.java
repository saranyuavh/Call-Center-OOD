package saranyu.ood;

public class Director implements IEmployee{
    static int globalDirectorId = 1;
    private EmployeeType type;

    private int id;

    public Director() {
        type  = EmployeeType.DIRECTOR;
        id = ++globalDirectorId;
    }

    public EmployeeType getType() {
        return type;
    }

    public void setType(EmployeeType type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public boolean execute(Call call) {
        System.out.println("Call "+call.getCallId()+" received by "+this.getType()+" "+this.getId());
        System.out.println("Call "+call.getCallId()+" resolved by "+this.getType()+" "+this.getId());
        EmployeeReliever.relieveEmployee(this);
        return true;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
