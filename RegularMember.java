public class RegularMember extends GymMember {
    // Private attributes
    private final int attendanceLimit;
    private boolean isEligibleForUpgrade;
    private String removalReason;
    private String referralSource;
    private String plan;
    private double price;

    // Constructor
    public RegularMember(int id, String name, String location, String phone, String email,
                         String gender, String DOB, String membershipStartDate, String referralSource) {
        super(id, name, location, phone, email, gender, DOB, membershipStartDate);
        this.referralSource = referralSource;
        this.attendanceLimit = 30;
        this.isEligibleForUpgrade = false;
        this.plan = "basic";
        this.price = 6500;
        this.removalReason = "";
    }

    // Accessor methods
    public int getAttendanceLimit() {
        return attendanceLimit;
    }

    public boolean getIsEligibleForUpgrade() {
        return isEligibleForUpgrade;
    }

    //@Override
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

    // Implement abstract method
    @Override
    public void markAttendance() {
        if (activeStatus) {
            attendance++;
            loyaltyPoints += 5;
            if (attendance >= attendanceLimit) {
                isEligibleForUpgrade = true;
            }
        } else {
            System.out.println("Membership is not active. Cannot mark attendance.");
        }
    }

    // Get plan price using switch
    public double getPlanPrice(String plan) {
        switch (plan.toLowerCase()) {
            case "basic":
                return 6500;
            case "standard":
                return 12500;
            case "deluxe":
                return 18500;
            default:
                return -1;
        }
    }

    // Upgrade plan method
    public String upgradePlan(String newPlan) {
        if (!activeStatus) {
            return "Cannot upgrade plan. Membership is not active.";
        }

        if (!isEligibleForUpgrade) {
            return "Not eligible for plan upgrade yet.";
        }

        if (plan.equalsIgnoreCase(newPlan)) {
            return "You are already subscribed to the same plan.";
        }

        double newPrice = getPlanPrice(newPlan);
        if (newPrice == -1) {
            return "Invalid plan selected.";
        }

        this.plan = newPlan;
        this.price = newPrice;
        return "Plan upgraded to " + newPlan + " successfully.";
    }

    // Revert member
    public void revertRegularMember(String removalReason) {
        resetMember();
        this.isEligibleForUpgrade = false;
        this.plan = "basic";
        this.price = 6500;
        this.removalReason = removalReason;
    }

    // Override display method
    @Override
    public void display() {
        super.display();
        System.out.println("Plan: " + plan);
        System.out.println("Price: " + price);
        if (!removalReason.isEmpty()) {
            System.out.println("Removal Reason: " + removalReason);
        }
    }
}