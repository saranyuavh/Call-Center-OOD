package saranyu.ood;

import java.util.HashMap;
import java.util.Map;

public class EmployeeAllocator {
    static Map<EmployeeType, IResourceManager> resourceManaegerMap = new HashMap<>();

    static {
        resourceManaegerMap.put(EmployeeType.RESPONDENT, new RespondentResourceManager());
        resourceManaegerMap.put(EmployeeType.MANAGER, new ManagerResourceManager());
        resourceManaegerMap.put(EmployeeType.DIRECTOR, new DirectorResourceManager());
    }

    public static IEmployee getEmployee(EmployeeType employeeType) {
        return resourceManaegerMap.get(employeeType).allocate();
    }

    public static IEmployee getSuperiorEmployee(IEmployee employee) {
        EmployeeType superiorType = Hierarchy.getSuperiorType(employee.getType());

        IEmployee superior = getEmployee(superiorType);

        return superior;
    }
}
