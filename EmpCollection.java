import java.util.*;

class Employee {
    private int empno;
    private String ename;
    private int age;
    private int salary;

    // Employee Constructor
    Employee(int empno, String ename, int age, int salary) {
        this.empno = empno;
        this.ename = ename;
        this.age = age;
        this.salary = salary;
    }

    // User can get and access employee by this
    public int getEmpno() {
        return empno;
    }

    public String getEname() {
        return ename;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }

    public String toString() {
        return empno + " " + ename + " " + age + " " + salary;
    }

}

class CRUDDemo {
    public static void main(String args[]) {

        List<Employee> c = new ArrayList<Employee>();
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);
        int ch;
        do {
            System.out.println("1.INSERT");
            System.out.println("2.DISPLAY");
            System.out.println("3.SEARCH");
            System.out.println("4.DELETE");
            System.out.println("5.UPDATE");
            System.out.println("Enter Your Choice : ");
            ch = s.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter Empno : ");
                    int empno = s.nextInt();
                    System.out.print("Enter EmpName : ");
                    String ename = s1.nextLine();
                    System.out.print("Enter Emp age : ");
                    int age = s.nextInt();
                    System.out.print("Enter Emp salary : ");
                    int salary = s.nextInt();

                    // make a constructor pass the value object will be created
                    c.add(new Employee(empno, ename, age, salary));
                    break;

                case 2:
                    System.out.println("--------------------------");
                    Iterator<Employee> i = c.iterator();
                    while (i.hasNext()) {
                        Employee e = i.next();
                        System.out.println(e);
                    }
                    System.out.println("---------------------------");
                    break;

                case 3:
                    Boolean found = false;
                    System.out.println("Enter Emp no. to Search : ");
                    empno = s.nextInt();
                    System.out.println("--------------------------");
                    i = c.iterator();
                    while (i.hasNext()) {
                        Employee e = i.next();
                        if (e.getEmpno() == empno) {
                            System.out.println(e);
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Record Not Found");
                    }
                    System.out.println("---------------------------");
                    break;

                    case 4:
                    found = false;
                    System.out.println("Enter Emp no. to Delete : ");
                    empno = s.nextInt();
                    System.out.println("--------------------------");
                    i = c.iterator();
                    while (i.hasNext()) {
                        Employee e = i.next();
                        if (e.getEmpno() == empno) {
                            i.remove();
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Record Not Found");
                    } else {
                        System.out.println("Record is Deleted Successfully");
                    }
                    System.out.println("---------------------------");
                    break;

                    case 5:
                    found = false;
                    System.out.println("Enter Emp no. to Update : ");
                    empno = s.nextInt();
                    System.out.println("--------------------------");
                    ListIterator<Employee> li = c.listIterator();
                    while (li.hasNext()) {
                        Employee e = li.next();
                        if (e.getEmpno() == empno) {
                           System.out.println("Enter the new Name : ");
                           ename = s1.nextLine();

                           System.out.println("Enter the new age : ");
                           age = s.nextInt();

                           System.out.println("Enter the new Salary : ");
                           salary = s.nextInt();
                           li.set(new Employee(empno, ename, age, salary));
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Record Not Found");
                    } else {
                        System.out.println("Record is Updated Successfully");
                    }
                    System.out.println("---------------------------");
                    break;

            }
        } while (ch != 0);
    }
}