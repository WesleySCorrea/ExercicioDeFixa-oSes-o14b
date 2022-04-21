package entities;

public class Company extends TaxPayer{

    Integer numberOfEmployees;

    public Company(){

    }

    public Company(Integer numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    public Company(String name, Double annualIncome, Integer numberOfEmployees) {
        super(name, annualIncome);
        this.numberOfEmployees = numberOfEmployees;
    }

    public Integer getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(Integer numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    @Override
    public String tax() {
        Double tax = taxTotal();

        return getName() + ": $ " + String.format("%.2f" , tax);
    }

    @Override
    public double taxTotal() {
        Double tax;
        if (getNumberOfEmployees()>=10){
            tax = getAnnualIncome()*0.14;
        }
        else{
            tax = getAnnualIncome()*0.16;
        }
        return tax;
    }
}
