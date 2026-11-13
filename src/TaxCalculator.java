import java.util.Scanner;

public class TaxCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("---------------------------------------------------------");
        System.out.println("|\t\tSALARY INFORMATION SYSTEM\t\t|");
        System.out.println("---------------------------------------------------------\n\n");

        System.out.println("\t [1] Calculate Income Tax\n\t [2] Calculalte Annual Bonus\n\t [3] Calculate Loan Amount\n\n");

        System.out.print("Enter an Option to Continue: ");
        int userOption = input.nextInt();
        input.nextLine();  //clear left over "New Line -\n" in buffer since nextInt only consume digits
        System.out.println("\n");

        switch(userOption){

            case 1:{
                System.out.println("---------------------------------------------------------");
                System.out.println("|\t\t[1] Calculate Income Tax\t\t|");
                System.out.println("---------------------------------------------------------\n\n");

                System.out.print("Input Employee Name   : ");
                String name = input.nextLine();

                System.out.println();

                System.out.print("Input Employee Salary : ");
                double salary = input.nextDouble();

                System.out.println("\n\n");

                double group_1 = (141667 - 100000) * 0.06;
                double group_2 = (183333 - 141667) * 0.12;
                double group_3 = (225000 - 183333) * 0.18;
                double group_4 = (266667 - 225000) * 0.24;
                double group_5 = (308333 - 266667) * 0.30;

                int tax = 0;

                if(salary<=100000){
                    System.out.println("Tax Free");
                } else if(salary <= 141667){
                    tax = (int) ((salary - 100000) * 0.06);
                } else if(salary <= 183333){
                    tax = (int) (((salary - 141667) * 0.12) + group_1);
                } else if(salary <= 225000){
                    tax = (int) (((salary - 183333) * 0.18) + group_1 + group_2);
                } else if(salary <= 266667){
                    tax = (int) (((salary - 225000) * 0.24) + group_1 + group_2 + group_3);
                } else if(salary <= 308333){
                    tax = (int) (((salary - 266667) * 0.30) + group_1 + group_2 + group_3 + group_4);
                } else if(salary > 308333){
                    tax = (int) (((salary - 308333) * 0.36) + group_1 + group_2 + group_3 + group_4 + group_5);
                }

                System.out.printf("Your Income Tax Per Month : %d",tax); //because "tax" is a global variable

            }break;

            case 2:{
                System.out.println("---------------------------------------------------------");
                System.out.println("|\t\t[2] Calculalte Annual Bonus\t\t|");
                System.out.println("---------------------------------------------------------\n\n");

                System.out.print("Input Employee Name   : ");
                String name = input.nextLine();

                System.out.print("Input Employee Salary : ");
                double salary = input.nextDouble();

                double bonus = 0;
                if (salary < 10000){
                    bonus = 5000;
                } else if(salary <= 199999){
                    bonus = salary * 0.10;
                } else if(salary <= 299999){
                    bonus = salary * 0.15;
                } else if(salary <= 399999){
                    bonus = salary * 0.20;
                } else {
                    bonus = salary * 0.35;
                }
                System.out.println();
                System.out.printf("Your Annual Bonus is :%.2f ",bonus);

            }break;

            case 3:{
                System.out.println("---------------------------------------------------------");
                System.out.println("|\t\t[3] Calculate Loan Amount\t\t|");
                System.out.println("---------------------------------------------------------\n\n");

                System.out.print("Input Employee Name   : ");
                String name = input.nextLine();

                System.out.print("Input Employee Salary : ");
                double salary = input.nextDouble();

                System.out.print("Premium Pay Period    : ");
                int years = input.nextInt();
                input.nextLine();

                if(salary <= 50000){
                    System.out.println("Insufficient Salary Amount to Grant a Loan !");
                } else {

                    double installment = salary * 0.60;
                    double annualRate = 0.15;
                    double monthlyRate = annualRate / 12;
                    int months = years * 12;

                    double loan = installment * ((1- (1 / Math.pow((1 + monthlyRate), months))) / monthlyRate);

                    loan = Math.round(loan / 1000.0) * 1000;

                    System.out.printf("You Can Get Loan Amount: %.0f", loan);
                }
            }break;

            default:{
                System.out.println("Invalid Selection");
            }
        }
    }
}
