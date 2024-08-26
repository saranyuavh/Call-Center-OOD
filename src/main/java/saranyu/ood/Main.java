package saranyu.ood;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello! Welcome to Dumb Call Center");
        for(int i=0; i<10; i++) {
            IEmployee respondent = new Respondent();
            IEmployee manager = new Manager();
            IEmployee director = new Director();
            RespondentResourceManager.unassignedRespondents.add(respondent);
            ManagerResourceManager.unassignedManagers.add(manager);
            DirectorResourceManager.unassignedDirectors.add(director);
        }
        for(int i=0; i<10; i++) {
            Call call = new Call();
            CallCenter.queueCall(call);
        }
        CallCenter.runQueue();
    }
}