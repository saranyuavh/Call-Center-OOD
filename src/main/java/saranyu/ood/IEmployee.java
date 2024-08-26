package saranyu.ood;

public interface IEmployee {
    public EmployeeType getType();
    public Integer getId();

    public boolean execute(Call call);
}
