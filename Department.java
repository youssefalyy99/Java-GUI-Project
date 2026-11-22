public class Department{
    private int DepartmentID;
    private String Name;

    public int getDepartmentID(){return DepartmentID;}
    public String getName(){return Name;}

    public void setDepartmentID(int departmentID) {
        if (departmentID <= 0) throw new IllegalArgumentException("Department ID must be a positive integer.");
        this.DepartmentID = departmentID;
    }
    public void setName(String name){
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Department name is required.");
        if (name.contains(",")) throw new IllegalArgumentException("Name cannot contain commas.");
        this.Name = name.trim();
    }

    public String toCSVLine(){return this.DepartmentID + "," + this.Name + "\n";}
}
