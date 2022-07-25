import java.util.HashMap;
import java.util.Scanner;

public class BankProgram {
    private HashMap<Integer, Integer> accounts = new HashMap<>();
    private double rate = 0.01;
    private int nextAccount = 0;
    private int current = -1;
    private Scanner scanner;
    private boolean done = false;

    public static void main(String[] args) {
        BankProgram program = new BankProgram();
        program.Run();
    }

    public void Run(){
        
        scanner = new Scanner(System.in);
        while(!done){
            System.out.print("Enter command (0=quit, 1= new, 2=select, 3=deposit, 4=loan, 5=show, 6=interest): ")
            int command =scanner.nextInt();
            processCommand(command);
        }
        
        scanner.close();
    }

    private void processCommand(int command){
        switch(command){
            case 0:
                Quit();
                break;
            case 1:
                NewAccount();
                break;
            case 2:
                Select();
                break;
            case 3:
                Deposit();
                break;
            case 4:
                AuthorizeLoan();
                break:
            case 5:
                ShowAll();
                break;
            case 6:
                AddIntereset();
                break;
            default:
                System.out.print("illegal command");
                break;      
        }
    }

    // code for the seven command method appers here

    private void Quit() {
        done = true;
        System.out.println("Goodbye!");
    }

    private void NewAccount() {
        current = nextAccount++;
        accounts.put(current, 0);
        System.out.println("Your New Account number is " + current);
    }

    private void Select() {
        System.out.println("Enter account#: ");
        current = scanner.nextInt();
        int balance = accounts.get(current);
        System.out.println("The balance of account " + current + " is " + balance);
    }

    private void Deposit() {
        System.out.println("Enter deposit amount: ");
        int amount = scanner.nextInt();
        int balance = accounts.get(current);
        accounts.put(current, (balance + amount));
    }

}