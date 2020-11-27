// Objectives:
// [x] Practice overloading methods such as constructors.
// [x] Implement getter and setters.

// Tasks:
// [x] Create a Project class that has the fields of name and description.
class Project {
    private String name = "";
    private String description = "";
    private Double initialCost = 0.0;
    // [x] Overload the constructor method in three different ways.
    // public Project() {}
    // public Project(String name) {}
    // public Project(String name, String description) {}
    public Project() {}
    public Project(String name) {
        this.setName(name);
    }
    public Project(String name, String description) {
        this.setName(name);
        this.setDescription(description);
    }
    public Project(String name, String description, Double cost) {
        this.setName(name);
        this.setDescription(description);
        this.setCost(cost);
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return this.description;
    }
    public void setCost(Double cost) {
        this.initialCost = cost;
    }
    public Double getCost() {
        return this.initialCost;
    }
    // [x] Create an instance method called elevatorPitch that will return the name and description separated by a colon.
    public String elevatorPitch() {
        return getName() + " (" + getCost() + "): " + getDescription() ;
    }
    // [x] Create getter and setters for each field
}
// [x] Create a ProjectTest file that will test all the functionality.

// Optional Challenges:
// [x] Add an additional initialCost member variable that is of type double and has both getters and setters
// [x] Add this to the elevator pitch in parentheses after the name, e.g.: name (cost): description


