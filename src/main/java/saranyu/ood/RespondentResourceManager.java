package saranyu.ood;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class RespondentResourceManager implements IResourceManager{
    public static Set<IEmployee> assignedRespondents = new HashSet<>();
    public static Queue<IEmployee> unassignedRespondents = new LinkedList<>();

    @Override
    public IEmployee allocate() {

        if(!unassignedRespondents.isEmpty()) {
            IEmployee employee = unassignedRespondents.poll();
            assignedRespondents.add(employee);
            return employee;
        }
        return null;
    }

    @Override
    public void relieve(IEmployee employee) {
        assignedRespondents.remove(employee);
        unassignedRespondents.add(employee);
    }
}
