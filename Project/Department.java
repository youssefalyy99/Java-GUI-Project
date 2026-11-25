package BackEnd;

public class Department {
    private int DepartmentID;
    private String Name;

    public Department(int DepartmentID, String Name) {
        setDepartmentID(DepartmentID);
        setName(Name);
    }

    public int getDepartmentID() { return DepartmentID; }
    public String getName() { return Name; }

    public void setDepartmentID(int departmentID) {
        if (departmentID <= 0) throw new IllegalArgumentException("Department ID must be a positive integer.");
        this.DepartmentID = departmentID;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Department name is required.");
        if (name.contains(",")) throw new IllegalArgumentException("Name cannot contain commas.");
        this.Name = name.trim();
    }

    public String toCSVLine() { return DepartmentID + "," + Name; }

    @Override
    public String toString() { return Name; }

    @Override
    public boolean equals(Object o) {
        return o instanceof Department d && d.DepartmentID == DepartmentID;
    }

    @Override
    public int hashCode() { return Integer.hashCode(DepartmentID); }
}
