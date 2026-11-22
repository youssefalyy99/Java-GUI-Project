public class Department{
    private int DepartmentID;
    private String Name;

    public int getDepartmentID(){return DepartmentID;}
    public String getName(){return Name;}

    public void setDepartmentID(int departmentID) {DepartmentID = departmentID;}
    public void setName(String name){Name = name;}

    public String toCSVLine(){return this.DepartmentID + "," + this.Name+"\n";}
}
