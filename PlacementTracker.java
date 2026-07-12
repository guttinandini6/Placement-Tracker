import java.util.*;

class Student {
    int id;
    String name;
    String branch;
    double cgpa;
    String company = "Not Placed";
    String result = "Pending";

    Student(int id, String name, String branch, double cgpa) {
        this.id = id;
        this.name = name;
        this.branch = branch;
        this.cgpa = cgpa;
    }
}

class Company {
    String name;
    double eligibility;

    Company(String name, double eligibility) {
        this.name = name;
        this.eligibility = eligibility;
    }
}

public class PlacementTracker {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Student> students = new ArrayList<>();
    static ArrayList<Company> companies = new ArrayList<>();

    static void registerStudent() {
        System.out.print("Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Branch: ");
        String branch = sc.nextLine();

        System.out.print("CGPA: ");
        double cgpa = sc.nextDouble();

        students.add(new Student(id, name, branch, cgpa));

        System.out.println("Student Registered Successfully.");
    }

    static void addCompany() {
        sc.nextLine();
        System.out.print("Company Name: ");
        String name = sc.nextLine();

        System.out.print("Minimum CGPA: ");
        double cgpa = sc.nextDouble();

        companies.add(new Company(name, cgpa));

        System.out.println("Company Added Successfully.");
    }

    static void eligibleStudents() {

        if(companies.isEmpty()){
            System.out.println("No company added.");
            return;
        }

        Company c = companies.get(companies.size()-1);

        System.out.println("Eligible Students for " + c.name);

        for(Student s : students){

            if(s.cgpa >= c.eligibility){

                System.out.println(s.id+" "+s.name+" "+s.cgpa);

            }
        }
    }

    static void updateInterview() {

        System.out.print("Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        for(Student s : students){

            if(s.id == id){

                System.out.print("Company Name: ");
                s.company = sc.nextLine();

                System.out.print("Result (Selected/Rejected): ");
                s.result = sc.nextLine();

                System.out.println("Interview Updated.");
                return;
            }
        }

        System.out.println("Student Not Found.");

    }

    static void placementReport(){

        System.out.println("\n------ Placement Report ------");

        for(Student s : students){

            System.out.println("ID : "+s.id);
            System.out.println("Name : "+s.name);
            System.out.println("Branch : "+s.branch);
            System.out.println("CGPA : "+s.cgpa);
            System.out.println("Company : "+s.company);
            System.out.println("Result : "+s.result);
            System.out.println("--------------------------");

        }
    }

    public static void main(String args[]) {

        int choice;

        do{

            System.out.println("\n===== Placement Tracker =====");
            System.out.println("1. Register Student");
            System.out.println("2. Add Company");
            System.out.println("3. View Eligible Students");
            System.out.println("4. Update Interview Result");
            System.out.println("5. Placement Report");
            System.out.println("6. Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();

            switch(choice){

                case 1:
                    registerStudent();
                    break;

                case 2:
                    addCompany();
                    break;

                case 3:
                    eligibleStudents();
                    break;

                case 4:
                    updateInterview();
                    break;

                case 5:
                    placementReport();
                    break;

                case 6:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        }while(choice != 6);

    }
}