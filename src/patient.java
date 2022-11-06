import java.sql.*;
import java.util.Scanner;

public class patient {

    public static void main(String[] args) {
        int pid,age,phone;
        String name,doctorname,place,symptom;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitaldb1","root","");
        }
        catch (Exception e){
            System.out.println((e));
        }
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
                    System.out.println("Enter patient id:--");
                    pid=sc.nextInt();
                    System.out.println("Enter the name of patient:--");
                    name=sc.next();
                    System.out.println("Enter the place:--");
                    place=sc.next();
                    System.out.println("Enter phone number:--");
                    phone=sc.nextInt();
                    System.out.println("Enter Age :--");
                    age=sc.nextInt();
                    System.out.println("Enter symptom:--");
                    symptom=sc.next();
                    System.out.println("Enter doctorname:--");
                    doctorname	=sc.next();
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitaldb1","root","");
                        String sql="INSERT INTO `patient`(`pid`, `name`, `place`, `phone`, `age`, `symptom`, `doctorname`)  VALUES (?,?,?,?,?,?,?)";
                        PreparedStatement stmt=con.prepareStatement((sql));
                        stmt.setInt(1,pid);
                        stmt.setString(2,name);
                        stmt.setString(3,place);
                        stmt.setInt(4,phone);
                        stmt.setInt(5,age);
                        stmt.setString(6,symptom);
                        stmt.setString(7,doctorname);
                        stmt.executeUpdate();
                        System.out.println("value inserted successfully.........!");
                    }
                    catch (Exception e){
                        System.out.println((e));
                    }
                    break;
                case 2:
                    System.out.println("View patients");
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitaldb1","root","");
                        String sql="SELECT `pid`, `name`, `place`, `phone`, `age`, `symptom`, `doctorname` FROM `patient`";
                        Statement stmt=con.createStatement();
                        ResultSet rs=stmt.executeQuery(sql);
                        while ((rs.next())) {
                            String getpid = rs.getString(("pid"));
                            String getname = rs.getString(("name"));
                            String getplace = rs.getString(("place"));
                            String getphone = rs.getString(("phone"));
                            String getage = rs.getString(("age"));
                            String getsymptom = rs.getString(("symptom"));
                            String getdoctorname = rs.getString(("doctorname"));
                            System.out.println("Patient id=" + getpid);
                            System.out.println("Name=" + getname);
                            System.out.println("place=" + getplace);
                            System.out.println("phone=" + getphone);
                            System.out.println("age =" + getage);
                            System.out.println("symptom=" + getsymptom);
                            System.out.println("doctorname=" + getdoctorname);
                            System.out.println("\n");

                        }
                    }
                    catch (Exception e){
                        System.out.println((e));
                    }
                    break;
                case 3:
                    System.out.println("Search patients");
                    System.out.println("enter patient id to search");
                    pid=sc.nextInt();
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitaldb1","root","");
                        String sql = "SELECT  `name`, `place`, `phone`, `age`, `symptom`, `doctorname` FROM `patient` WHERE `pid`="+String.valueOf(pid);
                        Statement stmt=con.createStatement();
                        ResultSet rs=stmt.executeQuery(sql);
                        while ((rs.next())) {
                            String getname = rs.getString(("name"));
                            String getplace = rs.getString(("place"));
                            String getphone = rs.getString(("phone"));
                            String getage = rs.getString(("age"));
                            String getsymptom = rs.getString(("symptom"));
                            String getdoctorname = rs.getString(("doctorname"));
                            System.out.println("Name=" + getname);
                            System.out.println("place=" + getplace);
                            System.out.println("phone=" + getphone);
                            System.out.println("age =" + getage);
                            System.out.println("symptom=" + getsymptom);
                            System.out.println("doctorname=" + getdoctorname);
                            System.out.println("\n");

                        }
                    }
                    catch (Exception e){
                        System.out.println((e));
                    }
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
