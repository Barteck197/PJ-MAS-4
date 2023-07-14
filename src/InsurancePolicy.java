import java.time.LocalDate;

public class InsurancePolicy {
    private LocalDate insuranceStartDate;
    private LocalDate insuranceEndDate;
    private float insuranceQuota;

    // Suma zniżek na ubezpieczeniu - nie może być większa niż 40%.
    // Przechowujemy jako float, gdzie 100 - 100%
    private float insuranceTotalDiscounts;

    public InsurancePolicy(LocalDate insuranceStartDate, LocalDate insuranceEndDate, float insuranceQuota) throws Exception {
        setInsuranceStartDate(insuranceStartDate);
        setInsuranceEndDate(insuranceEndDate);
        setInsuranceQuota(insuranceQuota);
        setInsuranceTotalDiscounts(0.00f);
    }

    public LocalDate getInsuranceStartDate() {
        return insuranceStartDate;
    }

    public void setInsuranceStartDate(LocalDate insuranceStartDate) {
        this.insuranceStartDate = insuranceStartDate;
    }

    public LocalDate getInsuranceEndDate() {
        return insuranceEndDate;
    }

    public void setInsuranceEndDate(LocalDate insuranceEndDate) {
        this.insuranceEndDate = insuranceEndDate;
    }

    public float getInsuranceQuota() {
        return insuranceQuota;
    }

    public void setInsuranceQuota(float insuranceQuota) {
        this.insuranceQuota = insuranceQuota;
    }

    public float getInsuranceTotalDiscounts() {
        return insuranceTotalDiscounts;
    }

    public void setInsuranceTotalDiscounts(float insuranceTotalDiscount) throws Exception {
        if (insuranceTotalDiscount > maxDiscount) {
            throw new Exception("Nie możesz dać tak wysokiej zniżki");
        }

        insuranceTotalDiscounts = insuranceTotalDiscount;
    }

    public void addInsuranceDiscount(float discount) throws Exception {
        // Czy suma zniżek przekracza dozwolony limit
        if (discount + insuranceTotalDiscounts > maxDiscount) {
            throw new Exception("Dodanie zniżki przekracza dozwolony limit.");
        }

        // Czy dodawana zniżka sama w sobie jest większa niż dozwolony limit
        if (discount > maxDiscount) {
            throw new Exception("Nie możesz dać tak wysokiej zniżki.");
        }

        insuranceTotalDiscounts += discount;
    }

    private final static float maxDiscount = 40.00f;
}
