package paymentSampleTest;
import paymentSampleTest.PersonAccount;

public class PaymentTransfer1 {
    int senderAcc;
    int receiverAcc;
    double amountToSend;

    public PaymentTransfer1(int senderAcc, int receiverAcc, double amountToSend){
        this.senderAcc = senderAcc;
        this.receiverAcc = receiverAcc;
        this.amountToSend = amountToSend;
    }

    public void sendAmountToReceiver(PersonAccount senderAcc, PersonAccount receiverAcc, double amountToSend){
        //validation check here
        try{
            if(senderAcc.hasSufficeintFunds(amountToSend)){
                double currBal = senderAcc.getBalance();
                double diff = senderAcc.getBalance() - amountToSend;
                senderAcc.setBalance(diff);
            }

        } catch (Exception e){
            System.out.println("Error in sending money!!");
        }
    }

    public void receiveAmount(PersonAccount senderAcc, PersonAccount receiverAcc, double amountToReceive){
        //validation check here
        try{
            double amountReceived = receiverAcc.getBalance() + amountToReceive;
                receiverAcc.setBalance(amountReceived);
                System.out.println("You have received" + amountReceived);
            } catch(Exception e){
            System.out.println("Error in sending money!!" + e);
        }
    }
}
