package saranyu.ood;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class ManagerResourceManager implements IResourceManager{
    public static Set<IEmployee> assignedManagers = new HashSet<>();
    public static Queue<IEmployee> unassignedManagers = new LinkedList<>();

    @Override
    public IEmployee allocate() {
        if(!unassignedManagers.isEmpty()) {
            IEmployee employee = unassignedManagers.poll();
            assignedManagers.add(employee);
            return employee;
        }
        return null;
    }

    @Override
    public void relieve(IEmployee employee) {
        assignedManagers.remove(employee);
        unassignedManagers.add(employee);
    }
}
