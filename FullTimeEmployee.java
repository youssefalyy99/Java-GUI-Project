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
        return getID()+","+getFullName()+","+getAge()+","+getType()+","+getPosition()+","+getDep().getDepartmentID()+","+CalculateSalary()+"\n";
    }

    @Override
    public double CalculateSalary(){
        return this.BasicSalary + this.Bonus;
    }

    public double getBasicSalary() {return BasicSalary;}
    public double getBonus(){return Bonus;}

    public void setBasicSalary(double basicSalary){BasicSalary = basicSalary;}
    public void setBonus(double bonus){Bonus = bonus;}
}
