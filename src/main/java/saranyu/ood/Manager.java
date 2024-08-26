package saranyu.ood;

import java.util.Random;

public class Manager implements IEmployee{
    static int globalManagerId = 1;
    private EmployeeType type;

    private Integer id;

    public Manager() {
        type  = EmployeeType.MANAGER;
        id = ++globalManagerId;
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
        Random random = new Random();
        int randomNumber = random.nextInt(1500);
        if(randomNumber % 3 == 0) {
            IEmployee superior = EmployeeAllocator.getSuperiorEmployee(this);
            System.out.println("Passing "+call.getCallId()+" on to superior "+superior.getType()+" "+superior.getId());
            return superior.execute(call);
        } else {
            System.out.println("Call "+call.getCallId()+" resolved by "+this.getType()+" "+this.getId());
        }
        EmployeeReliever.relieveEmployee(this);
        return true;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
