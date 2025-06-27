public class PremiumMember extends GymMember {
    private final double premiumCharge = 50000;
    private String personalTrainer;
    private boolean isFullPayment;
    private double paidAmount;
    private double discountAmount;
    private String removalReason;

    /**
     * Constructor to initialize a PremiumMember object
     */
    public PremiumMember(int id, String name, String location, String phone, String email, String gender,
                        String DOB, String membershipStartDate, String personalTrainer) {
        super(id, name, location, phone, email, gender, DOB, membershipStartDate);
        this.personalTrainer = personalTrainer;
        this.isFullPayment = false;
        this.paidAmount = 0;
        this.discountAmount = 0;
        this.removalReason = "";
    }

    @Override
    public void markAttendance() {
        if (this.activeStatus) {
            this.attendance++;
            this.loyaltyPoints += 10; // Premium members earn more loyalty points
        } else {
            System.out.println("Your membership is not active. Sorry we cannot mark your attendance.");
        }
    }

    /**
     * Allows the member to make payments towards their premium membership fee.
     */
    public String payDueAmount(double amount) {
        if (this.isFullPayment) {
            return "Your payment is already done.";
        } else if (this.paidAmount + amount > premiumCharge) {
            return "Payment exceeds the premium charge.";
        } else {
            this.paidAmount += amount;
            if (this.paidAmount == premiumCharge) {
                this.isFullPayment = true;
            }
            double remainingAmount = premiumCharge - this.paidAmount;
            return "Payment successful. Remaining amount: " + remainingAmount;
        }
    }

    public void calculateDiscount() {
        if (this.isFullPayment) {
            this.discountAmount = 0.1 * premiumCharge;
            System.out.println("Discount calculated: " + discountAmount);
        } else {
            System.out.println("There is no discount available. Payment is not complete.");
        }
    }

    public void revertPremiumMember(String removalReason) {
        super.resetMember();
        this.personalTrainer = "";
        this.isFullPayment = false;
        this.paidAmount = 0;
        this.discountAmount = 0;
        this.removalReason = removalReason;
    }

    //@Override
    public String getRemovalReason() {
        return removalReason;
    }

    /**
     * Displays all details of the premium member.
     */
    @Override
    public void display() {
        super.display();
        System.out.println("Personal Trainer: " + personalTrainer);
        System.out.println("Paid Amount: " + paidAmount);
        System.out.println("Full Payment: " + isFullPayment);
        System.out.println("Remaining Amount: " + (premiumCharge - paidAmount));
        if (isFullPayment) {
            System.out.println("Discount Amount: " + discountAmount);
        }
        if (!removalReason.isEmpty()) {
            System.out.println("Removal Reason: " + removalReason);
        }
    }

    // Getter methods
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
}