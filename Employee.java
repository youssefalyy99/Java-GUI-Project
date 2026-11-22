public abstract class Employee {
    private int ID;
    private String FullName;
    private String Position;
    private int Age;
    private Department dep;
    private String Type;
    private double totalSalary;

    Employee(int ID, String FullName, int age ,String Position, Department dep){
        this.ID = ID;
        this.FullName = FullName;
        this.Position = Position;
        this.dep = dep;
        this.Age = age;
    }

    public void setTotalSalary(double totalSalary) {
        this.totalSalary = totalSalary;
    }
    public double getTotalSalary() {
        return totalSalary;
    }

    public void setID(int id) {
        if (id <= 0) throw new IllegalArgumentException("ID must be a positive integer.");
        this.ID = id;
    }
    public void setAge(int age) {
        if (age <= 0) throw new IllegalArgumentException("Age must be a positive integer.");
        this.Age = age;
    }

    public void setDepartment(Department d) {
        if (d == null) throw new IllegalArgumentException("A valid department must be selected.");
        this.dep = d;
    }
    
    public void setFullName(String n) {
        if (n == null || n.isBlank()) throw new IllegalArgumentException("Full name is required.");
        if (n.contains(",")) throw new IllegalArgumentException("Name cannot contain commas.");
        this.FullName = n.trim();
    }

    public void setPosition(String p) {
        if (p == null || p.isBlank()) throw new IllegalArgumentException("Position is required.");
        if (p.contains(",")) throw new IllegalArgumentException("Position cannot contain commas.");
        this.Position = p.trim();
    }

    protected void setType(String type){this.Type = type;}
    
    public int getAge(){return Age;}
    public Department getDep(){return dep;}
    public String getFullName(){return FullName;}
    public int getID(){return ID;}
    public String getPosition(){return Position;}
    public String getType(){return Type;}

    abstract String toCSVLine();
    abstract double CalculateSalary();
}
