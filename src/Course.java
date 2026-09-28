public class Course {
    private String courseName;
    private Student students[];
    private int studentCount = 0;

    public Course(String courseName, int studentCount) {

        students = new Student[studentCount]; //makes a student array which takes the input value of studentCount
    }

    private boolean isFull(){                       //checks if array is full

        return studentCount == students.length;
    }
    private boolean isEmpty(){              //checks if array is empty
        return studentCount == 0;
    }
    public Student getStudent(int numberStudent){           //fetches the student from the array according to input number
        if(numberStudent < studentCount && numberStudent >= 0)
            return students[numberStudent];
        else return null;
    }
    public int registerStudent(int index){      //sets the student registration to true
     Student member = getStudent(index);
     if(member == null){
         return 0;
     }
     else
        member.setRegistered(true);
     return 1;
    }

    public int deRegisterStudent(int index){    //sets student registration to false
        Student member = getStudent(index);
        if(member == null){
            return 0;
        }
        else
            member.setRegistered(false);
        return 1;
    }

    public String listStudents() {      //lists student in array
        if (isEmpty()) {
            return "No students registered";
        } else {
            String members = "";
            for (int i = 0; i < studentCount; i++) {
                members += i + "  " + students[i].toString() + "\n";
            }
            return members;
        }
    }

    public boolean addStudent(Student student){ //adds students to array
        if(isFull()){
            return false;       //if its full does not add student
        }
        else {      //if not full adds to students with the input of the total students and increments it
            students[studentCount] = student;
            studentCount++;
            return true;
        }
    }
    public String listCurrentStudents(){    //lists registered students
        String currrentStudents = "";
            for(int i = 0; i < studentCount; i++){
                if(students[i].isRegistered())      //checks array location of students and if registered is true adds it to string else ignores it
                {
                    currrentStudents += students[i].toString() + "\n";
                }
            }
            return currrentStudents;
    }
    public String listStudentsWithAverageMark(){ //lists all the students with their average mark
        String currrentStudents = "";
        for(int i = 0; i < studentCount; i++){
           currrentStudents +=  students[i].calculateAverageMark() + "\n";
        }
        return currrentStudents;
    }

}

