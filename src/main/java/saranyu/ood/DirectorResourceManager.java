package saranyu.ood;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class DirectorResourceManager implements IResourceManager{
    public static Set<IEmployee> assignedDirectors = new HashSet<>();
    public static Queue<IEmployee> unassignedDirectors = new LinkedList<>();

    @Override
    public IEmployee allocate() {
        if(!unassignedDirectors.isEmpty()) {
            IEmployee employee = unassignedDirectors.poll();
            assignedDirectors.add(employee);
            return employee;
        }
        return null;
    }

    @Override
    public void relieve(IEmployee employee) {
        assignedDirectors.remove(employee);
        unassignedDirectors.add(employee);
    }
}
