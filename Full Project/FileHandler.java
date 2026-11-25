package BackEnd;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    private final File employeesFile = new File("data/employees.txt");
    private final File departmentsFile = new File("data/departments.txt");

    public FileHandler() {
        File dir = employeesFile.getParentFile();
        if (dir != null && !dir.exists()) dir.mkdirs();  
    }

    public void saveDepartments(List<Department> departments) throws IOException {
        try (BufferedWriter w = new BufferedWriter(new FileWriter(departmentsFile))) {
            for (Department d : departments) {
                w.write(d.toCSVLine());
                w.newLine();
            }
        }
    }

    public void saveEmployees(List<Employee> employees) throws IOException {
        try (BufferedWriter w = new BufferedWriter(new FileWriter(employeesFile))) {
            for (Employee e : employees) {
                w.write(e.toCSVLine());
                w.newLine();
            }
        }
    }

    

    public List<Department> loadDepartments() throws IOException {
        List<Department> list = new ArrayList<>();
        if (!departmentsFile.exists()) return list;

        try (BufferedReader r = new BufferedReader(new FileReader(departmentsFile))) {
            String line;
            while ((line = r.readLine()) != null) {
                if (line.isBlank()) continue;
                try {
                    String[] p = line.split(",");
                    list.add(new Department(Integer.parseInt(p[0].trim()), p[1]));
                } catch (Exception ex) {
                    System.err.println("Skipping bad department line: " + line);
                }
            }
        }
        return list;
    }

    public List<Employee> loadEmployees(List<Department> departments) throws IOException {
        List<Employee> list = new ArrayList<>();
        if (!employeesFile.exists()) return list;

        try (BufferedReader r = new BufferedReader(new FileReader(employeesFile))) {
            String line;
            while ((line = r.readLine()) != null) {
                if (line.isBlank()) continue;
                try {
                    String[] p = line.split(",");
                    int id = Integer.parseInt(p[0].trim());
                    String name = p[1];
                    int age = Integer.parseInt(p[2].trim());
                    String type = p[3].trim();
                    String position = p[4];
                    int depId = Integer.parseInt(p[5].trim());
                    double a = Double.parseDouble(p[6].trim());
                    double b = Double.parseDouble(p[7].trim());

                    Department dep = null;
                    for (Department d : departments) {
                        if (d.getDepartmentID() == depId) { dep = d; break; }
                    }
                    if (dep == null) throw new IllegalArgumentException("Unknown department " + depId);

                    Employee e;
                    if (type.equals("Full Time")) {
                        e = new FullTimeEmployee(id, name, age, position, dep, a, b);
                    } else if (type.equals("Part Time")) {
                        e = new PartTimeEmployee(id, name, age, position, dep, a, b);
                    } else {
                        throw new IllegalArgumentException("Unknown type " + type);
                    }
                    list.add(e);
                } catch (Exception ex) {
                    System.err.println("Skipping bad employee line: " + line);
                }
            }
        }
        return list;
    }
}
