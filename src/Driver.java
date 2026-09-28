import java.util.Scanner;


public class Driver {
    private Scanner input = new Scanner(System.in);         //importing scanner
    private int[] course;
    private Course studentCount;

    public static void main(String[] args) {
    Driver driver = new Driver();
    }           //creating driver

    public Driver() {
        studentCount();
        runMenu();
    }

    private int mainMenu(){     //main menu which is displayed
        System.out.print( """
               Student System
               ---------
                  1) Add a Student
                  2) Add student marks
                  3) Add a student to the course (Register)
                  4) Remove a student from the course (De-Register)
                  5) List all students
                  6) List the students currently enrolled in the course
                  7) List students whose average mark is greater than a given mark
                  8) List the students' names with their average mark
                  9) Display average student mark
                  10) Display student with the lowest average mark
                  11) Display student with the highest average mark
                  12) List the students' names which have passed the course 
                  0) Exit
               ==>> """);
        int choice = input.nextInt();   //records user input for the choice in menu
        return choice;                     //returns input
    }

    private void runMenu(){         //executes menu choice
        int choice = mainMenu();

        while(choice != 0){         //checks if the choice is not 0

            switch(choice){         //depending on input executes the method
                case 1 -> addStudent();
                case 2 -> addStudentMarks();
                case 3 -> addStudentToCourse();
                case 4 -> deregisterStudent();
                case 5 -> printStudents();
                case 6 -> printCurrentStudents();
                case 7 -> printStudentsWithAverageMarkAboveAGivenMark();
                case 8 -> printStudentsWithAverageMark();
                case 9 -> printAverageStudentMark();
                case 10 -> printStudentWithLowestAverageMark();
                case 11 -> printStudentWithHighestAverageMark();
                case 12 -> printStudentsWhoHavePassed();
                default -> System.out.println("Invalid choice" + choice);       //if choice is invalid eg 13 returns this
            }
            System.out.println("\n Press enter key to continue");       //gives the user time to read
            input.nextLine();
            input.nextLine();

            choice = mainMenu();        //returns the menu again

        }
        System.out.println("Exiting");      //if 0 is pressed exits the program
        System.exit(0);
    }
    private void addStudentMarks(){     //adds student marks to the specified student
        System.out.print("Which of the following students would you like to add marks to?\n");
        System.out.println(studentCount.listStudents());    //lists all the students from the Course class whit method .listStudents
        int choice = input.nextInt();

        Student student = studentCount.getStudent(choice);  //gets the student according to user input above
        int marks[] = new int[6];       //declares the variable of size 6 to input six seperate marks


        for(int i = 0; i < marks.length; i++){      //runs this loop until all the student grades are filled in
            System.out.println("Enter mark" + i);      //promps to enter mark plus index number or the student
            int mark = input.nextInt();                 //stores choice in int mark
                if(mark >= 0 && mark <= 100)            //validation for input
                    mark = mark;                           //if within parameters sets the mark to itself
                else mark = 0;                              //if outside parameters sets mark to 0
            marks[i] = mark;                                 //takes array location and adds the student mark to it
        }
        student.setMarks(marks);                        //accesses method in student .setMarks and sets the marks with this.marks

    }

    private void studentCount(){
        System.out.println("How many students would you like to have?");        //this appears when the program is run and sets the array size for students
        int number = input.nextInt();                                           //stores the input
        System.out.println("What is the course name ?");                        //asks user for the course name
        input.nextLine();
        String courseName = input.nextLine();                                   //sets the coursename in variable
        studentCount = new Course(courseName,number);                           //inputs the entered details into the course class
    }

    public void addStudentToCourse() {              //option  which registers students students to array
        System.out.print("Choose the student number to register\n");
        System.out.print(studentCount.listStudents());              //lists students which you can select to register
        int numberStudent = input.nextInt();                        //stores the user input
        System.out.print("Type y to add student to course\n");
        System.out.println("--------------------------");
        char choiceRegistration = input.next().charAt(0);

            int result = studentCount.registerStudent(numberStudent); //changes the student registration to true in course

    }
    public void deregisterStudent(){                    //same as the above except it unregisters student
        System.out.print("Choose the student number to register\n");
        System.out.print(studentCount.listStudents());
        int numberStudent = input.nextInt();
        System.out.print("Type y to add student to course\n");
        System.out.println("--------------------------");
        char choiceRegistration = input.next().charAt(0);

        int result = studentCount.deRegisterStudent(numberStudent);
    }

    private void addStudent(){          //option one in menu which adds students to the array
        boolean registered = true;  //sets default boolean value
        input.nextLine();
        System.out.print("Enter student name: ");
        String name = input.nextLine();
        System.out.print("Enter student id (8 numbers): ");
        String id = input.nextLine();
        System.out.print("Enter y if student is registered and n if not: ");
        char isRegistered = input.next().charAt(0);

            if ((isRegistered == 'y') || (isRegistered == 'Y')){
                 registered = true;
            }
            else if ((isRegistered == 'n' || isRegistered == 'N')){
                 registered = false;
        }

            boolean added = studentCount.addStudent(new Student(name, id, registered)); //adds student details to the course
                if(added == true)
                    System.out.println("Student added");
                else
                    System.out.println("Student not added");

    }

    private void printStudents(){           //prints all students
        System.out.println("Printing all students: ");
        System.out.println("-------------------");
        System.out.println(studentCount.listStudents());

    }
    private void printCurrentStudents(){        //prints students which are registered
        System.out.println("Printing current students: ");
        System.out.println("--------------------");
        System.out.println(studentCount.listCurrentStudents());

    }
    private void printStudentsWithAverageMarkAboveAGivenMark(){


    }
    private void printAverageStudentMark(){

    }
    private void printStudentWithLowestAverageMark(){

    }
    private void printStudentWithHighestAverageMark(){

    }
    private void printStudentsWithAverageMark(){    //prints average mark for students
        System.out.println("Printing students with average mark \n");
        System.out.println("-------------------------");
        System.out.println(studentCount.listStudentsWithAverageMark() + studentCount.listStudents() + "\n");
    }

    private void printStudentsWhoHavePassed(){

    }


}
