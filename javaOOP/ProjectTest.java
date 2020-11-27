public class ProjectTest {
    public static void main(String[] args) {
        Project test1 = new Project();
        System.out.println(test1.elevatorPitch());
        Project test1a = new Project("MeowMeow");
        System.out.println(test1a.elevatorPitch());
        Project test1b = new Project("WoofWoof", "This is another Project");
        System.out.println(test1b.elevatorPitch());
        test1.setName("First Test Ever");
        test1.setDescription("This is my first test for Project 1");
        test1.setCost(1000.22);
        System.out.println(test1.elevatorPitch());
        Project test2 = new Project("Has cost", "This is a project with cost this time", 48734.34);
        System.out.println(test2.elevatorPitch());
        test1a.setCost(3213.34);
        test1b.setCost(5858.84);

        Portfolio portfolio = new Portfolio();
        portfolio.addProject(test1);
        portfolio.addProject(test1a);
        portfolio.addProject(test1b);
        System.out.println(portfolio.getPortfolioCost());
        portfolio.showPortfolio();
    }
}