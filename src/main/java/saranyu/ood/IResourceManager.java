package saranyu.ood;

public interface IResourceManager {
    public IEmployee allocate();
    public void relieve(IEmployee employee);
}
