public class PartTimeEmployee extends Employee {
    private double hourlyRate;
    private double hoursWorked;

    PartTimeEmployee(int ID, String FullName, int age, String Position, Department dep,
                     double hr, double hw) {
        super(ID, FullName, age, Position, dep);
        setHourlyRate(hr);        // validated
        setHoursWorked(hw);       // validated
        setType("Part Time");
    }

    public double getHourlyRate() { return hourlyRate; }
    public double getHoursWorked() { return hoursWorked; }

    public void setHourlyRate(double hourlyRate) {
        if (hourlyRate < 0) {
            throw new IllegalArgumentException("Hourly rate cannot be negative: " + hourlyRate);
        }
        this.hourlyRate = hourlyRate;
    }

    public void setHoursWorked(double hoursWorked) {
        if (hoursWorked < 0) {
            throw new IllegalArgumentException("Hours worked cannot be negative: " + hoursWorked);
        }
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double CalculateSalary() {
        return hourlyRate * hoursWorked;     // no setTotalSalary
    }

    @Override
    public String toCSVLine() {              // now public
        return getID() + "," + getFullName() + "," + getAge() + "," + getType() + ","
             + getPosition() + "," + getDep().getDepartmentID() + ","
             + getHourlyRate() + "," + getHoursWorked();
    }
}
