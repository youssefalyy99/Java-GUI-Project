public class PartTimeEmployee extends Employee {
    private double hourlyRate;
    private double hoursWorked;

    PartTimeEmployee(int ID, String FullName, int age ,String Position, Department dep, double hr , double hw){
        super(ID, FullName, age, Position, dep);
        this.hourlyRate = hr;
        this.hoursWorked = hw;
        setType("Part Time");
    }

    public double getHourlyRate() {return hourlyRate;}
    public double getHoursWorked() {return hoursWorked;}

    public void setHourlyRate(double hourlyRate) {this.hourlyRate = hourlyRate;}
    public void setHoursWorked(double hoursWorked){this.hoursWorked = hoursWorked;}

    @Override
    public double CalculateSalary(){
        return this.hourlyRate*this.hoursWorked;
    }
    
    @Override
    String toCSVLine(){
        return getID()+","+getFullName()+","+getAge()+","+getType()+","+getPosition()+","+getDep().getDepartmentID()+","+CalculateSalary+"\n"
    }
}
