package saranyu.ood;

import java.util.ArrayList;

public class Hierarchy {
    static ArrayList<EmployeeType> hierarchy = new ArrayList<>();

    static {
        hierarchy.add(EmployeeType.RESPONDENT);
        hierarchy.add(EmployeeType.MANAGER);
        hierarchy.add(EmployeeType.DIRECTOR);
    }

    public static EmployeeType getSuperiorType(EmployeeType emp) {
        int i=0;
        for(i=0; i<hierarchy.size(); i++) {
            if(hierarchy.get(i).equals(emp))
                break;
        }

        return hierarchy.get(i+1);
    }

    public static EmployeeType getFirstResponder() {
        return hierarchy.get(0);
    }
}
