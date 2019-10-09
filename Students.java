import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student{
    public String name;
    public int age;
    Student(String name, int age)
    {
        this.name = name;
        this.age = age;
    }
    public String toString()
    {
        return "Name: " + name + "\n   age: " + age;
    }
}


public class App{
    public static void main(String[] args){
        Boolean yesno = true;
        Scanner scanner = new Scanner(System.in);
        List<Student> list = new ArrayList();
        System.out.println("Welcome");
        do {
            System.out.println("What do you want to do?");
            System.out.println("1. Add new student\n2. Give a mark to a student\n3. Show students\n4. Quit\nPlease choose an option:  ");
            int answer = scanner.nextInt();

            switch(answer){
                case 1:
                {
                    String enter = scanner.nextLine();
                    System.out.println("Name of student: ");
                    String name = scanner.nextLine();
                    System.out.println("Age of student: ");
                    int age = scanner.nextInt();
                    list.add(new Student(name,age));
                    break;
                }
                case 2:
                    // working on it
                case 3:
                    for(int i = 0;i<list.size();i++) {
                        System.out.println((i+1) + ". " +list.get(i).toString());
                    }
                    break;
                case 4:
                    yesno = false;
                    break;
                default:
                    System.out.println("There is no option as: " + answer);
            }

        } while (yesno);
    }
}
