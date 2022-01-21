import java.util.*;
public class library {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while(true){
            System.out.print("\033[H\033[2J");
            System.out.println("Welcome to amazon");
            System.out.println("1. Admin login");
            System.out.println("2. borrower  login");
            System.out.println("3. Exit");
            System.out.print("ENTER A NUMBER : ");
            int user_ip=sc.nextInt();
            if(user_ip==1){
                admin_login.admin_pannel();
            }
            else if(user_ip==2){
                borrower_login.merchant_pannel();
            }
            else if(user_ip==3){
                break;
            }
            else{
                System.out.println("plese enter valid number");
            }
                    
        }
        
    }
}
class admin_login{
    List<admin_login> admins = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);
    public static void admin_pannel(){
        System.out.print("\033[H\033[2J");
        System.out.println("enter emailid:");
        String name = sc.next();
        System.out.println("enter password");
        int password = sc.nextInt();
        if(name.equals("123@gmail.com")&& password==1234){
            while(true){
                System.out.print("\033[H\033[2J");
                System.out.println("-----------------------------welcome admin-----------------------------");
                System.out.println("1. Add book ");
                System.out.println("2. modify book details");
                System.out.println("3. add admin");
                System.out.println("4. add borrowers");
                System.out.print("ENTER A NUMBER : ");
                int user_ip=sc.nextInt();
                if(user_ip)
            }
            
        }
    }
}