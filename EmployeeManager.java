package BackEnd;

import java.io.IOException;
import java.util.ArrayList;

public class EmployeeManager {
    private final ArrayList<Employee> employees;
    private final FileHandler fileHandler;
    private final DepartmentManager departmentManager;

    public EmployeeManager(ArrayList<Employee> loaded, FileHandler fileHandler, DepartmentManager departmentManager) {
        if (fileHandler == null || departmentManager == null)
            throw new IllegalArgumentException("FileHandler and DepartmentManager are required.");
        this.employees = new ArrayList<>();
        this.fileHandler = fileHandler;
        this.departmentManager = departmentManager;
        if (loaded != null) {
            for (Employee e : loaded) {
                if (findById(e.getID()) == null) this.employees.add(e);
            }
        }
    }

    public Employee addFullTimeEmployee(int id, String name, int age, String position,
                                        Department dep, double basicSalary, double bonus) throws IOException {
        return addEmployee(new FullTimeEmployee(id, name, age, position, dep, basicSalary, bonus));
    }

    public Employee addPartTimeEmployee(int id, String name, int age, String position,
                                        Department dep, double hourlyRate, double hours) throws IOException {
        return addEmployee(new PartTimeEmployee(id, name, age, position, dep, hourlyRate, hours));
    }

    public Employee addEmployee(Employee e) throws IOException {
        validateEmployee(e);
        if (isIdDuplicate(e.getID()))
            throw new IllegalArgumentException("Employee ID " + e.getID() + " already exists.");
        employees.add(e);
        try {
            save();
        } catch (IOException ex) {
            employees.remove(e);
            throw ex;
        }
        return e;
    }

    public void updateEmployee(Employee original, Employee updated) throws IOException {
        if (original == null)
            throw new IllegalArgumentException("Please select an employee first.");
        int index = employees.indexOf(original);
        if (index < 0)
            throw new IllegalArgumentException("The selected employee no longer exists.");
        validateEmployee(updated);

        Employee other = findById(updated.getID());
        if (other != null && other != original)
            throw new IllegalArgumentException("Employee ID " + updated.getID() + " already exists.");

        employees.set(index, updated);
        try {
            save();
        } catch (IOException ex) {
            employees.set(index, original);
            throw ex;
        }
    }

    public void deleteEmployee(int id) throws IOException {
        Employee e = findById(id);
        if (e == null)
            throw new IllegalArgumentException("Employee " + id + " not found.");

        int index = employees.indexOf(e);
        employees.remove(e);
        try {
            save();
        } catch (IOException ex) {
            employees.add(index, e);
            throw ex;
        }
    }

    public Employee findById(int id) {
        for (Employee e : employees)
            if (e.getID() == id) return e;
        return null;
    }

    public boolean isIdDuplicate(int id) { return findById(id) != null; }

    public ArrayList<Employee> searchByName(String text) {
        ArrayList<Employee> result = new ArrayList<>();
        if (text == null || text.isBlank()) return result;
        String t = text.trim().toLowerCase();
        for (Employee e : employees)
            if (e.getFullName().toLowerCase().contains(t)) result.add(e);
        return result;
    }

    public ArrayList<Employee> searchById(String idText) {
        ArrayList<Employee> result = new ArrayList<>();
        Employee e = findById(parseInt(idText, "Employee ID"));
        if (e != null) result.add(e);
        return result;
    }

    public ArrayList<Employee> searchByDepartmentName(String depName) {
        ArrayList<Employee> result = new ArrayList<>();
        if (depName == null || depName.isBlank()) return result;
        String n = depName.trim();
        for (Employee e : employees)
            if (e.getDep().getName().equalsIgnoreCase(n)) result.add(e);
        return result;
    }

    public ArrayList<Employee> filterByDepartment(Department dep) {
        ArrayList<Employee> result = new ArrayList<>();
        if (dep == null) return result;
        for (Employee e : employees)
            if (e.getDep().equals(dep)) result.add(e);
        return result;
    }

    public ArrayList<Employee> getAllEmployees() { return new ArrayList<>(employees); }//copy

    public boolean hasEmployeesInDepartment(Department dep) {
        return !filterByDepartment(dep).isEmpty();
    }

    public double getSalary(Employee e) { return e.CalculateSalary(); }

    public double getTotalPayroll() {
        double total = 0;
        for (Employee e : employees) total += e.CalculateSalary();
        return total;
    }

    public void save() throws IOException {
        fileHandler.saveEmployees(employees);
    }

    private void validateEmployee(Employee e) {
        if (e == null)
            throw new IllegalArgumentException("Employee data is missing.");
        if (e.getDep() == null || departmentManager.findById(e.getDep().getDepartmentID()) == null)
            throw new IllegalArgumentException("The selected department does not exist.");
        if (!(e instanceof FullTimeEmployee) && !(e instanceof PartTimeEmployee))
            throw new IllegalArgumentException("Unsupported employee type.");
    }

    public static int parseInt(String text, String fieldName) {
        if (text == null || text.isBlank())
            throw new IllegalArgumentException(fieldName + " is required.");
        try {
            return Integer.parseInt(text.trim());
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(fieldName + " must be a valid integer.");
        }
    }

    public static double parseDouble(String text, String fieldName) {
        if (text == null || text.isBlank())
            throw new IllegalArgumentException(fieldName + " is required.");
        try {
            double v = Double.parseDouble(text.trim());
            if (Double.isNaN(v) || Double.isInfinite(v))
                throw new IllegalArgumentException(fieldName + " must be a valid number.");
            return v;
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(fieldName + " must be a valid number.");
        }
    }
}