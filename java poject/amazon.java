import java.util.*;
public class amazon {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while(true){
            System.out.print("\033[H\033[2J");
            System.out.println("Welcome to amazon");
            System.out.println("1. Admin login");
            System.out.println("2. merchant  login");
            System.out.println("3. user login");
            System.out.println("4. Exit");
            System.out.print("ENTER A NUMBER : ");
            int user_ip=sc.nextInt();
            if(user_ip==1){
                admin.admin_login();
            }
            else if(user_ip==2){
                merchant_login.merchant_pannel();
            }
            else if(user_ip==3){
                user_login.user_pannel();
            }
                    
        }
        
    }
}
class admin{
    static boolean merch_rem=false;
    static Scanner sc = new Scanner(System.in);
    public static List<admin> merchants = new ArrayList<>();
    public String name,password;
    public  int merch_id;
    static public int merchant_id=1000;//static public
    public Boolean merchant_verify=false;
    admin(String merchnat_name, String merchnat_pass,int mer_id,boolean verify){
        name=merchnat_name;
        password=merchnat_pass;
        merch_id=mer_id;
        merchant_verify=verify;


    }
    public static void admin_login(){
        System.out.print("\033[H\033[2J");
        System.out.println("enter name : ");
        String name=sc.next();
        System.out.println("enter pass : ");
        String pass=sc.next();
        if(name.equals("admin")&&pass.equals("1234")){
            admin_pannel();
        }else{
            System.out.println("invalid detais");
            System.out.println("press enter to continue");
            sc.nextLine();
            sc.nextLine();
        }
    }
    public static void admin_pannel(){
        while (true) {
            System.out.print("\033[H\033[2J");
            System.out.println("******* Welcome Admin ******\n");
            System.out.println("1. Add_Merchant\n2. Remove_Merchant\n3. View All Products\n4. Add product category\n5. Approve Merchants\n6. Exit\n");
            int a=sc.nextInt();
            if(a==1){
                Add_Merchant();
            }
            else if(a==2){
                Remove_Merchant();
            }
            else if(a==3){
                veiw_product_list();
            }
            else if(a==5){
                approve_merchant();
            }
            else if(a==6){
                break;
            }else{
                System.out.println("Invalid\n");
                System.out.println("Press ENTER to continue");
                sc.nextLine();
                sc.nextLine();
            }

        }
        
    }
    static void Add_Merchant(){
        System.out.print("\033[H\033[2J");
        System.out.print("enter name of merchant : ");
        String merchnat_name=sc.next();
        System.out.print("enter password: ");
        String merchant_password=sc.next();
        merchants.add(new admin(merchnat_name,merchant_password,++merchant_id,true));
        System.out.println("merchent:"+merchant_id+" "+"added succesfully");
        System.out.println();
        System.out.println("press enter to continue");
        sc.nextLine();
        sc.nextLine();
    }
    static void Add_Merchant_Merchant(){
        merchant_login.mer_verify=true;
        System.out.print("\033[H\033[2J");
        System.out.print("enter name of merchant : ");
        String merchnat_name=sc.next();
        System.out.print("enter password: ");
        String merchant_password=sc.next();
        merchants.add(new admin(merchnat_name,merchant_password,++merchant_id,false));
        //System.out.println("merchent:"+merchant_id+" "+"account verified by admin added succesfully");
        System.out.println();
        System.out.println("you will be approved when admin come online thankyou");
        System.out.println("press enter to continue");
        sc.nextLine();
        sc.nextLine();
    

    }
    static void Remove_Merchant(){
        System.out.print("\033[H\033[2J");
        System.out.print("enter Merchant id to remove : ");
        Integer merchantr_id= sc.nextInt();
        for(int i=0;i<merchants.size();i++){
            if(merchantr_id== merchants.get(i).merch_id){
                merch_rem=true;
                System.out.println("merchant removed successfully");
                merchants.remove(i);
                System.out.println("press enter to continue");
                sc.nextLine();
                sc.nextLine();
            }
            
        }
        if(merch_rem==false){
            System.out.println("invalaid details");
            System.out.println("press enter to continue");
            sc.nextLine();
            sc.nextLine();
        }

    }
    static void veiw_product_list(){
        System.out.print("\033[H\033[2J");
        if(merchant_login.products.size()>0){
            System.out.println("product name"+"        "+"product prize"+"        "+"available product(no)");
            for(int i=0;i<merchant_login.products.size();i++){
            
                System.out.println(merchant_login.products.get(i).prod_name+"                 "+merchant_login.products.get(i).prod_prize+"                   "+merchant_login.products.get(i).prod_pavailabe);
            
            }
            System.out.println("press enter continue");
            sc.nextLine();
            sc.nextLine();
        }
        else{
            System.out.println("no products available");
            System.out.println("press enter continue");
            sc.nextLine();
            sc.nextLine();
        }
        
    }
    static void approve_merchant(){
        System.out.print("\033[H\033[2J");
        int count=0;
        System.out.println("list of unapproved merchants:");
        for(admin object : merchants){
            if(object.merchant_verify==false){
                System.out.println(object.merch_id+" "+"not approved");
            }
            count=count+1;
        }
        if (count != 0) {
            System.out.print("Enter id to Approve : ");
            int id = sc.nextInt();
            System.out.print("Do you want to Approve (y/n) : ");
            String approve = sc.next();
            if (approve.equals("y")) {
                for (admin object : merchants) {
                    if (object.merch_id == id && !(object.merchant_verify)) {
                        object.merchant_verify = true;
                        System.out.println("\nMerchant Approved");
                    }
                }
            }
        }
        System.out.println("\nPress ENTER to continue");
        sc.nextLine();
        sc.nextLine();
    }
    
}
class merchant_login{
    public static boolean  d = false;
    public static String pron;
    public static boolean t1 = true; 
    public static boolean existmerw=true;
    public static boolean verifyem=false;
    static boolean mer_verify=false;
    public static Scanner sc = new Scanner(System.in);
    public String prod_name;
    public int prod_prize;
    public int prod_pavailabe;
    public static List<merchant_login> products = new ArrayList<>();
    merchant_login(String pname,int pprize,int pavilable ){
        prod_name=pname;
        prod_prize=pprize;
        prod_pavailabe=pavilable;


    }
    public static void merchant_pannel(){
        while(true){
            System.out.print("\033[H\033[2J");
            System.out.println("welcome merchant");
            System.out.println();
            System.out.println("1 . new merchant registration(self regsitering)\n2 . existing merchant\n3 . exit");
            int user_ip=sc.nextInt();
            if(user_ip==1){
                new_merchant_registration();
            }
            if(user_ip==2){
                existing_merchant();
            }
            if(user_ip==3){
                break;
            }
        }
    }
    public static void new_merchant_registration(){
        System.out.print("\033[H\033[2J");
        System.out.println("your id wii be verified by admin");
        System.out.println("Press enter to continue");
        sc.nextLine();
        sc.nextLine();
        admin.Add_Merchant_Merchant();
    
        
    
    }
    public static void  existing_merchant(){
        System.out.print("\033[H\033[2J");
        System.out.print("enter merchant id : ");
        int  merchant_id=sc.nextInt();
        sc.nextLine();
        System.out.println("enter pass");
        String password=sc.nextLine();
        for(int i=0;i<admin.merchants.size();i++){
            if(merchant_id==admin.merchants.get(i).merch_id && password.equals(admin.merchants.get(i).password))
            {
                verifyem=true;
                while(true){
                    System.out.print("\033[H\033[2J");
                    System.out.println("---------------welcome-----------------");
                    System.out.println("1 . add product\n 2 . exit\n 3 . update product");
                    int user_ip=sc.nextInt();
                    if(user_ip==1){
                        add_products();
                        System.out.println("press enter to continue");
                        sc.nextLine();
                            //sc.nextLine();
                    }
                    else if(user_ip==2){
                            //wc=false;
                            break;
                    }
                    else if(user_ip==3){
                        System.out.print("\033[H\033[2J");
                        System.out.println("---------------welcome enter product name -----------------");
                        pron= sc.next();
                        update_product(products.indexOf(pron));
                    }
                        

                }
            }
        }
        if(verifyem==false){
            System.out.println("invalid merchant detais");
            System.out.println();
            System.out.println("press enter to cont");
            sc.nextLine();
            sc.nextLine();
        }   
                
        
    }
    public static void add_products(){
        System.out.print("\033[H\033[2J");
        System.out.print("enter product name : ");
        sc.nextLine();
        String product_name=sc.nextLine();
        System.out.println("enter pize of product");
        int product_prize=sc.nextInt();
        System.out.println("no of vaialable products");
        int product_available=sc.nextInt();
        products.add(new merchant_login(product_name,product_prize,product_available));
        System.out.println("product added ssuccessfully");
        
    
    }
    public static int update_product(int cur_user){
        System.out.print("\033[H\033[2J");
        for(merchant_login objecct: products ){
            System.out.println(pron);
            System.out.println(objecct.prod_name);
            if(pron.equals(objecct.prod_name)){
                d=true;
                System.out.println("enter prize of product");
                objecct.prod_prize=sc.nextInt();
                System.out.println("eneter avail products");
                objecct.prod_pavailabe=sc.nextInt();
                System.out.println("products updated successfully");
                System.out.println();
                System.out.println("press enter to continue");
                sc.nextLine();
                sc.nextLine();
            }
            else{
                System.out.println("invalid product name");
                System.out.println("press enter to cont");
                sc.nextLine();
                sc.nextLine();
            }
        }
        if(d==false){
            System.out.println("please enter correct product name ");
            System.out.println("press enter to continue");
            sc.nextLine();
            sc.nextLine();
        }
        return 0;
    }
}
class user_login{
    public static int idincrement=0;
    String user_name;
    int user_password;
    int user_id;
    user_login(String name,int password,int idincremennt){
        user_name=name;
        user_password=password;
        user_id=idincremennt;

    }
    public static List<user_login> users = new ArrayList<>();
    public static Scanner  sc = new Scanner(System.in);
    public static void user_pannel(){
        System.out.println("\033[H\033[2J");
        System.out.println("____________________welcome to user pannel____________________");
        System.out.println("1 . self registration\n2 . existing user login\n3 . exit ");
        int user_ip=sc.nextInt();
        while(true){
            if(user_ip==1){
                self_registration();
                System.out.println("user added succesfully");
                System.out.println("press enter to cont");
                sc.nextLine();
                sc.nextLine();
            }
            else if(user_ip==2){
                existing_user_login();
            }
            else if(user_ip==3){
                break;
            }
            else{
                System.out.println("invalid input");
            }
        }
    }
    public  static void  self_registration(){
        System.out.println("\033[H\033[2J");
        System.out.println("enter name");
        sc.nextLine();
        String name = sc.nextLine();
        System.out.println("enter pass");
        int pass = sc.nextInt();
        users.add(new user_login(name,pass,++idincrement));
        System.out.println("user "+idincrement++ +" "+"added successfully");
        //System.out.println("press enter to cont");
        //sc.nextLine();
        //sc.nextLine();
    }
    public static void  existing_user_login(){
        System.out.println("\033[H\033[2J");
        System.out.println("enter name");
        String name = sc.nextLine();
        System.out.println("enter pass");
        int pass = sc.nextInt();
        int c = 0;
        for(user_login object : users){
            if(object.user_name.equals(name)&&object.user_id==pass){
                c=1;
                while(true){
                    System.out.println("\033[H\033[2J");
                    System.out.println("welcome "+name);
                }
            }
        }
        if(c==1){
            System.out.println("invalid detais");
            System.out.println("press enter to cont");
            sc.nextLine();
            sc.nextLine();
        }
    }
}

