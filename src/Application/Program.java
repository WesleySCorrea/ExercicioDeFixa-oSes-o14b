package Application;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<TaxPayer> taxPayerList = new ArrayList<>();

        System.out.println("Enter the number of tax payers: ");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.println("Tax payer #" + i + " data:");
            System.out.print("Individual or company (i/c)? ");
            char ch = sc.next().charAt(0);
            if (ch == 'i') {
                System.out.print("Name: ");
                String name = sc.next();
                System.out.print("Annual income: ");
                Double annualIncome = sc.nextDouble();
                System.out.print("Health expenditures: ");
                Double healthExpenditures = sc.nextDouble();
                taxPayerList.add(new Individual(name, annualIncome, healthExpenditures));
            }
            if (ch == 'c') {
                System.out.print("Name: ");
                String name = sc.next();
                System.out.print("Annual income: ");
                Double annualIncome = sc.nextDouble();
                System.out.print("Number of employees: ");
                Integer numberOfEmployees = sc.nextInt();
                taxPayerList.add(new Company(name, annualIncome, numberOfEmployees));
            }
        }
        System.out.println("TAXES PAID:");
        for (TaxPayer taxPayer : taxPayerList){
            System.out.println(taxPayer.tax());
        }
        System.out.println();
        double taxTotal = 0;
        for (TaxPayer taxPayer : taxPayerList) {
            taxTotal += taxPayer.taxTotal();
        }
        System.out.printf("TOTAL TAXES: $ %.2f",taxTotal);
    }
}

