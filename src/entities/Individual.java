package entities;

public class Individual extends TaxPayer{

   private Double healthExpenditures;

   public Individual(){

   }

    public Individual(Double healthExpenditures) {
        this.healthExpenditures = healthExpenditures;
    }

    public Individual(String name, Double annualIncome, Double healthExpenditures) {
        super(name, annualIncome);
        this.healthExpenditures = healthExpenditures;
    }

    public Double getHealthExpenditures() {
        return healthExpenditures;
    }

    public void setHealthExpenditures(Double healthExpenditures) {
        this.healthExpenditures = healthExpenditures;
    }


    @Override
    public String tax() {
       double tax = taxTotal();

        return getName() + ": $ " + String.format("%.2f" , tax);
    }

    @Override
    public double taxTotal() {
        Double tax;
        if (getAnnualIncome() < 20000) {
            tax = getAnnualIncome() * 0.15 - (getHealthExpenditures() * 0.5);
        } else {
            tax = getAnnualIncome() * 0.25 - (getHealthExpenditures() * 0.5);
        }
        return tax;
    }

}
