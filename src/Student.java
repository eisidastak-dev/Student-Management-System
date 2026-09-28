public class Student {
    private String name;
    private String studentID = "invalid";
    private int[] marks;
    private boolean registered = true;

    public Student(String name, String studentID,boolean registered) {
        setName(name);
        setStudentID(studentID);
        setRegistered(registered);
    }


    public String getName() {

        return name;
    }
    public String getStudentID() {

        return studentID;
    }
    public boolean isRegistered() {

        return registered;
    }
    public int[] getMarks() {

        return marks;
    }

    public void setName(String name) { //sets the student name with validation
        if(name.length() <= 20)
            this.name = name;
        else{
            name = name.substring(0, 20);
                this.name = name;
        }
    }


    public void setStudentID(String studentID) { //sets student id with validation
        if(studentID.length() == 8)
            this.studentID = studentID;
        else {
            studentID = "Invalid";
        }
    }

    public void setRegistered(boolean registered) {

        this.registered = registered;
    }
    public void setMarks(int[] marks) {

        this.marks = marks;
    }

    public String toString(){

        return "Name: " + name +  "  " + "Student ID: " + studentID + "  " + "Registered: " + registered;
    }
    public double calculateAverageMark(){
        double sum = 0;
        for(int i = 0; i < marks.length; i++){
            sum += marks[i];
        }
        return sum / marks.length;
    }
}
