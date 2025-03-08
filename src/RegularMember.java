
public class RegularMember extends GymMember {


    private  int attendanceLimit;
    private  boolean isEligibleForUpgrade;
    private String removalReason;
    private String referralSource;
    private  String plan;
    private  double price;

    public  RegularMember(int id, String name, String location,
                          String phone, String email,String gender, String DOB, String membershipStartDate, String referralSource){
        super(id, name, location, phone, email,gender, DOB, membershipStartDate);
        this.referralSource = referralSource;
        this.isEligibleForUpgrade = false;
        this.attendanceLimit =30;
        this.plan = "basic";
        this.price = 6500;
        this.removalReason = "";
    }


    @Override
    public void markAttendance() {
        this.attendance++;
        this.loyaltyPoints = loyaltyPoints+5;
    }

    public double getPlanPrice(String plan){
        switch (plan)
        {
            case "basic": return 6500;
            case "standard": return 12500;
            case "deluxe": return 18500;
            default:return -1;
        }
    }

    public String  upgradePlan(String plan){
       isEligibleForUpgrade = getAttendance() >= attendanceLimit;

        if (plan.equals(this.plan)) {
            System.out.println("Already subscribed plan chosen");
            return "Already subscribed plan chosen";
        }

        if (isEligibleForUpgrade){
           double planPrice =  getPlanPrice(plan);
           if (planPrice!=-1){
            this.plan = plan;
            this.price = planPrice;
               System.out.println("Plan Changed");
               return "Planed changed";
           }
           else {
               System.out.println("Invalid plan provided. There are currently three plans: basic, standard and deluxe");
               return "Invalid plan";
           }
        }else{
            return "Not eligible for upgrade";
        }
    }


    public void revertRegularMember(String removalReason){
        resetMember();
        isEligibleForUpgrade = false;
        plan = "basic";
        price = 6500;


    }

    public void display(){
        super.display();
        System.out.println("Plan: "+plan);
        System.out.println("Price: "+price);
        if(!removalReason.isEmpty()){
            System.out.println("Reason for removal");
        }
    }

    public int getAttendanceLimit() {
        return attendanceLimit;
    }

    public boolean isEligibleForUpgrade() {
        return isEligibleForUpgrade;
    }

    public String getRemovalReason() {
        return removalReason;
    }

    public String getReferralSource() {
        return referralSource;
    }

    public String getPlan() {
        return plan;
    }

    public double getPrice() {
        return price;
    }
}
