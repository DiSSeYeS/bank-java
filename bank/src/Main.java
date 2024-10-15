import java.util.ArrayList;
import java.util.Date;

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Account account = new Account(1233, 1100, "Семён");
        account.deposit(500);
        account.deposit(600);
        account.deposit(700);
        account.withdraw(700);
        account.withdraw(600);
        account.withdraw(100);

        System.out.println(account.getId());
        System.out.println(account.name);
        System.out.println(account.getMontlyInterest());

        for (Transaction item : account.getTransactions()){
            System.out.println(item.getType());
            System.out.println(item.getAmount());
            System.out.println(item.getBalance());
            System.out.println(item.getDesctiption());
        }
    }

    public static class Account {
        private int id;
        private double balance;
        private double annualInterestRate;
        private Date dateCreated;
        private String name;
        private ArrayList<Transaction> transactions = new ArrayList<Transaction>(){};

        public Account(){
            this.id = 0;
            this.balance = 0;
            this.annualInterestRate = 0;
            this.dateCreated = new Date();
        }

        public Account(int id, int balance, String name){
            this.id = id;
            this.balance = balance;
            this.name = name;
        }

        public void setId(int id){
            this.id = id;
        }

        public void setBalance(int balance){
            this.balance = balance;
        }

        public void setAnnualInterestRate(int annualInterestRate){
            this.annualInterestRate = annualInterestRate;
        }

        public int getId(){
            return this.id;
        }

        public double getBalance(){
            return this.balance;
        }

        public double getAnnualInterestRate(){
            return this.annualInterestRate;
        }

        public String getName(){
            return this.name;
        }

        public double getMontlyInterest(){
            return 7.5;
        }

        public void withdraw(double payment){
            this.balance = balance - payment;
            Transaction transaction = new Transaction();
            transaction.setTransaction('-', payment, this.balance, "Снятие");
            transactions.add(transaction);
        }

        public void deposit(double payment){
            this.balance = balance + payment;
            Transaction transaction = new Transaction();
            transaction.setTransaction('+', payment, this.balance, "Снятие");
            transactions.add(transaction);
        }

        public ArrayList<Transaction> getTransactions(){
            return this.transactions;
        }




    }

    public static class Transaction{
        private char type;
        private double amount;
        private double balance;
        private String description;

        public void setTransaction(char type, double amount, double balance, String description){
            this.type = type;
            this.amount = amount;
            this.balance = balance;
            this.description = description;
        }

        public char getType(){
            return this.type;
        }

        public double getAmount(){
            return this.amount;
        }

        public double getBalance(){
            return this.balance;
        }

        public String getDesctiption(){
            return this.description;
        }

    }
}


