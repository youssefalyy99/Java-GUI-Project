import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileHandler {

    private File employeesFile;
    private File departmentsFile;

    public FileHandler() {

        employeesFile = new File("data/employees.txt");
        departmentsFile = new File("data/departments.txt");

        if (employeesFile.exists() && departmentsFile.exists()) {
            System.out.println("Files exist");
        } else {
            System.out.println("One or both files do not exist");
        }
    }

    
    
    public void saveEmployees(Employee employee) {

        try (FileWriter writer = new FileWriter(employeesFile, true)) {

            writer.write(employee.toCSVLine() + "\n");

        } catch (IOException e) {
            System.out.println("Could not write file");
        }
    }





  public void saveDepartments(Department department){
     try (FileWriter writer = new FileWriter(departmentsFile, true)) {

            writer.write(department.toCSVLine() + "\n");

        } catch (IOException e) {
            System.out.println("Could not write file");
        }
  
  }

public void loadEmployees(){
    try(BufferedReader reader = new BufferedReader(new FileReader(employeesFile))){
        String line;
        while((line = reader.readLine()) != null){
            System.out.println(line);}
    }
    catch(FileNotFoundException e){
        System.out.println("File not Found");
    }
    catch(IOException e){
        System.out.println("Something went wrong");
    }
            
}



public void loadDepartments(){

    try(BufferedReader reader = new BufferedReader(new FileReader(departmentsFile))){
        String line;
        while((line = reader.readLine()) != null){
            System.out.println(line);}
    }
    catch(FileNotFoundException e){
        System.out.println("File not Found");
    }
    catch(IOException e){
        System.out.println("Something went wrong");
    }


}







}















    
    

