package paymentSampleTest;

public class PersonAccount {
    double balance;
    int accNum;

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setAccNum(int accNum) {
        this.accNum = accNum;
    }

    public double getBalance() {
        return balance;
    }

    public int getAccNum() {
        return accNum;
    }

    public boolean hasSufficeintFunds(double amountToCheck){
        if(amountToCheck > balance){
            System.out.println("Not sufficient funds available");
            return false;
        }
        return true;
    }
}
