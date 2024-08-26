package saranyu.ood;

import java.util.Random;

public class Respondent implements IEmployee{
    static int globalRespondentId = 1;
    private EmployeeType type;

    private int id;

    public Respondent() {
        type  = EmployeeType.RESPONDENT;
        id = ++globalRespondentId;
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

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean execute(Call call) {
        System.out.println("Call "+call.getCallId()+" received by "+this.getType()+" "+this.getId());
        Random random = new Random();
        int randomNumber = random.nextInt(999);
        if(randomNumber%2 == 0) {
            IEmployee superior = EmployeeAllocator.getSuperiorEmployee(this);
            System.out.println("Passing "+call.getCallId()+" on to superior "+superior.getType()+" "+superior.getId());
            return superior.execute(call);
        } else {
            System.out.println("Call "+call.getCallId()+" resolved by "+this.getType()+" "+this.getId());
        }
        EmployeeReliever.relieveEmployee(this);
        return true;
    }
}
