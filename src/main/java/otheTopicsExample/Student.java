package otheTopicsExample;
// Comparable Example- Sort by a default value- one fixed way to compare objects.
class Student implements Comparable<Student>{
    String name;
    int age;
    int score;
    //Constructor
    public Student(String name, int age, int score){
        this.name = name;
        this.age = age;
        this.score = score;
    }
    //compare by score
    //Default sorting
    @Override
    public int compareTo(Student s){ //compareTo() tells Java how to compare two students.
        return this.score - s.score;
    }
}
//Now if you do Collections.sort(listOfStudents), they’ll be sorted by score.
