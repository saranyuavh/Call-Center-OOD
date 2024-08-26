package saranyu.ood;

import java.util.HashMap;
import java.util.Map;

public class EmployeeReliever {

    static Map<EmployeeType, IResourceManager> resourceManaegerMap = new HashMap<>();

    static {
        resourceManaegerMap.put(EmployeeType.RESPONDENT, new RespondentResourceManager());
        resourceManaegerMap.put(EmployeeType.MANAGER, new ManagerResourceManager());
        resourceManaegerMap.put(EmployeeType.DIRECTOR, new DirectorResourceManager());
    }

    public static void relieveEmployee(IEmployee employee) {
        resourceManaegerMap.get(employee.getType()).relieve(employee);
        System.out.println(employee.getType()+" "+employee.getId()+" relieved");
    }
}
