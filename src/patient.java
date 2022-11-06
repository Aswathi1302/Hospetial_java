import java.util.Scanner;

public class patient {
    public static void main(String[] args) {
        int choice;
        while(true)
        {
            System.out.println("*******HOSPETIAL*******)");

            System.out.println("1.Add Patient");
            System.out.println("2.View patient");
            System.out.println("3.Search patient");
            System.out.println("4.Update patient");
            System.out.println("5.delete patient");
            System.out.println("6.Exit");
            System.out.println("*****************");
            System.out.println("ENTER YOUR CHOICE:--");
            Scanner sc=new Scanner(System.in);
            choice=sc.nextInt();
            switch(choice)
            {
                case 1:
                    System.out.println("Add patients");
                    break;
                case 2:
                    System.out.println("View patients");
                    break;
                case 3:
                    System.out.println("Search patients");
                    break;
                case 4:
                    System.out.println("Update patients");
                    break;
                case 5:
                    System.out.println("Delete patients");
                    break;
                case 6:
                    System.exit(0);
                    break;


            }
        }
    }
}
