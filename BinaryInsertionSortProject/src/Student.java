public class Student { //student class
    private int id;
    private String name;
    private int age;
    private double gpa;

    //Student constructor with necessary attributes
    public Student(int id, String name, int age, double gpa){ 
        this.id = id;
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }

    //helper methods
    public int getID(){
        return id;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public double getGpa(){
        return gpa;
    }
    public String toString(){ //toString method to return info as a string
        return id + "," + name + "," + age + "," + gpa;
    }
}
