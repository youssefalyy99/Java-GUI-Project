abstract class Employee {
    private int ID;
    private String FullName;
    private String Position;
    private int Age;
    private Department dep;
    protected String Type;

    Employee(int ID, String FullName, int age ,String Position, Department dep){
        this.ID = ID;
        this.FullName = FullName;
        this.Position = Position;
        this.dep = dep;
        this.Age = age;
    }
    
    public void setAge(int age) {Age = age;}
    public void setDep(Department dep) {this.dep = dep;}
    public void setFullName(String fullName){FullName = fullName;}
    public void setID(int iD){ID = iD;}
    public void setPosition(String position){Position = position;}
    
    public int getAge(){return Age;}
    public Department getDep(){return dep;}
    public String getFullName(){return FullName;}
    public int getID(){return ID;}
    public String getPosition(){return Position;}
    public String getType(){return Type;}

    abstract String toCSVLine();
}
