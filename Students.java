import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Student {
    private ArrayList<Integer> empty = new ArrayList<>();
    public String name;
    public int personal_identity_number;
    public ArrayList<ArrayList<Integer>> marks;

    Student(String name, int personal_identity_number, ArrayList<ArrayList<Integer>> marks) {
        this.name = name;
        this.personal_identity_number = personal_identity_number;
        this.marks = marks;
        this.marks.add(empty);

    }

    public String toString(int i) {
        return "Name: " + name + "\n   Personal identity number: " + personal_identity_number + "\n   Marks: " + marks.get(i);
    }

    public boolean getPIN(int pin) {
        return personal_identity_number == pin;
    }
    //public Integer getPINN() { return personal_identity_number; } method used to debug the program

    public void newMark(int mark, int z){
        marks.get(z).add(mark);
    }


}


public class Students{
    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> empty = new ArrayList<>();
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
                    System.out.println("Personal identity number of student: ");
                    int personal_identity_number = scanner.nextInt();
                    list.add(new Student(name,personal_identity_number, empty));
                    break;
                }
                case 2:
                    boolean check = true;
                    int z = 0;
                    System.out.println("PIN of a student: ");
                    int pin = scanner.nextInt();
                    do {
                        if (list.get(z).getPIN(pin)) {
                            check = false;
                            System.out.println("Mark:  ");
                            int mark = scanner.nextInt();
                            list.get(z).newMark(mark,z);
                        }
                        if (z<=list.size()){z++;}
                        else{check=false;}
                    } while(check);
                    break;
                case 3:
                    for(int i = 0;i<list.size();i++) {
                        System.out.println((i+1) + ". " +list.get(i).toString(i));
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