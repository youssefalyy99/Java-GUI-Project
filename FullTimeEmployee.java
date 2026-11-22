public class FullTimeEmployee extends Employee {
    private double Bonus;
    private double BasicSalary;

    FullTimeEmployee(int ID, String FullName, int age ,String Position, Department dep,double BasicSalary, double Bonus){
        super(ID, FullName, age, Position, dep);
        this.BasicSalary = BasicSalary;
        this.Bonus = Bonus;
        setType("Full Time");
    }

    @Override
    String toCSVLine(){
        return getID()+","+getFullName()+","+getAge()+","+getType()+","+getPosition()+","+getDep().getDepartmentID()+","+getBasicSalary()+","+getBonus();
    }

    @Override
    public double CalculateSalary(){
        setTotalSalary(this.BasicSalary + this.Bonus);
        return this.BasicSalary + this.Bonus;
    }

    public double getBasicSalary() {return BasicSalary;}
    public double getBonus(){return Bonus;}

    public void setBasicSalary(double basicSalary){
        if (basicSalary < 0) throw new IllegalArgumentException("Basic salary cannot be negative.");
        this.BasicSalary = basicSalary;
    }

    public void setBonus(double bonus){
        if (bonus < 0) throw new IllegalArgumentException("Bonus cannot be negative.");
        this.Bonus = bonus;
    }
}
