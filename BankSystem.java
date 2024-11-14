class BankAccount{
String accountnum;
String holdername;
double balance;
public BankAccount(String accountnum,String holdername,double balance){
this.accountnum=accountnum;
this.holdername=holdername;
this.balance=balance;
}
public void deposit(double amount){
balance +=amount;
}
public void withdraw(double amount){
if(amount<=balance){
balance -= amount;
}else{
System.out.println("not enough balance");
}
}
public double getBalance(){
return balance;
}
}
class SavingAccount extends BankAccount{
final double InterestRate=0.05;
public SavingAccount(String accountnum,String holdername,double balance){
super(accountnum,holdername,balance);
}
public double calculateInterest(){
return balance * InterestRate;
}
}
public class BankSystem{
public static void main(String args[]){
SavingAccount s=new SavingAccount("4578","SHIVA",2000);
s.deposit(800);
s.withdraw(400);
System.out.println("BALANCE: " + s.getBalance());
System.out.println("INTEREST: " + s.calculateInterest());
}
}

