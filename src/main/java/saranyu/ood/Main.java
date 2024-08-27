package saranyu.ood;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello! Welcome to Dumb Call Center");
        Random rand = new Random();
        int minNum = rand.nextInt(200);
        for(int i=0; i<minNum; i++) {
            IEmployee respondent = new Respondent();
            IEmployee manager = new Manager();
            IEmployee director = new Director();
            RespondentResourceManager.unassignedRespondents.add(respondent);
            ManagerResourceManager.unassignedManagers.add(manager);
            DirectorResourceManager.unassignedDirectors.add(director);
        }
        for(int i=0; i<minNum; i++) {
            Call call = new Call();
            CallCenter.queueCall(call);
        }
        CallCenter.runQueue();
    }
}