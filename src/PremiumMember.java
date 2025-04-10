public class PremiumMember extends GymMember {
   private double  premiumCharge;
   private String  personalTrainer;
   private boolean isFullPayment;
   private double  paidAmount;
   private double discountAmount;

    public PremiumMember(int id, String name, String location, String phone, String email, String gender, String DOB, String membershipStartDate, String personalTrainer){
        super(id,name, location,phone, email, gender, DOB,membershipStartDate);
        this.premiumCharge = 50000;
        this.paidAmount = 0;
        isFullPayment = false;
        discountAmount = 0;
        this.personalTrainer = personalTrainer;
    }

    @Override
    public void markAttendance() {

    }

    public double getPremiumCharge() {
        return premiumCharge;
    }

    public String getPersonalTrainer() {
        return personalTrainer;
    }

    public boolean isFullPayment() {
        return isFullPayment;
    }

    public double getPaidAmount() {
        return paidAmount;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public String payDueAmount(double paidAmount){
         if (this.isFullPayment){
            System.out.println("Full payment has been already done");
            return "Payment already done";
        }

        if (this.paidAmount+paidAmount>premiumCharge){
            System.out.println("Payment is more than the remaining premium charge");
            return "Payment is more than the remaining premium charge" +"paidAmount: " + this.paidAmount + "remaining premium charge: " +(premiumCharge-this.paidAmount);
        }

        this.paidAmount = this.paidAmount+paidAmount;
        double remainingAmount = premiumCharge - this.paidAmount;

        if (remainingAmount==0){
            isFullPayment = true;
            System.out.println("All the payment has been cleared");
            return "Full payment done!!";
        }else {
            System.out.println("Payment done and remaining payment:"+remainingAmount);
            return "Payment done and remaining payment: "+ remainingAmount;
        }

    }

    public String calculateDiscount(){
        if (isFullPayment){
            discountAmount = ((double) 10 /100)*premiumCharge;
            System.out.println("Congratulations you have got 10% discount i.e RS "+discountAmount);
            return "Congratulations you have got 10% discount i.e RS "+discountAmount;
        }

        return "Sorry you havenot done the full payment, so you dont get any discount";


    }

    public void revertPremiumUser(){
        super.resetMember();
        personalTrainer = "";
        isFullPayment = false;
        paidAmount = 0;
        discountAmount = 0;
    }

    public void display(){
        super.display();
        System.out.println("Personal Trainer: "+personalTrainer);
        System.out.println("Paid amount:"+paidAmount);
        System.out.println("Is full payment: "+isFullPayment);
        System.out.println("Remaining amount: "+ (premiumCharge-paidAmount));
        if (isFullPayment){
            System.out.println("Discount Amount: "+discountAmount);
        }

    }
}
