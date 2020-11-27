// [x] Create a Portfolio class that will keep an ArrayList of Projects in the field projects. Use generics to ensure these are Project objects.
import java.util.ArrayList;
class Portfolio {
    // fields for the class Portfolio should be an ArrayList of projects
    ArrayList<Project> projects;
    public Portfolio() {
        projects = new ArrayList<Project>();
    }
    // [x] Add the appropriate getters/setters/constructors for this class to work
    public void addProject(Project project) {
        projects.add(project);
    }
    public Project getProject(int index) {
        return projects.get(index);
    }
    // [] Add the getPortfolioCost method that calculates and returns the cost to buy the entire portfolio.
    public Double getPortfolioCost() {
        Double cost = 0.0;
        for(Project project : projects) {
            cost += project.getCost();
        }
        return cost;
    }
    // [x] Add the showPortfolio method that will print all the project elevator pitches, followed by the total cost.
    public void showPortfolio() {
        System.out.println("Printing all elevatorPitches in portfolio...");
        for(Project project: projects) {
            System.out.println(project.elevatorPitch());
        }
        System.out.println("Total Cost: " + getPortfolioCost());
    }
}
