import java.util.Scanner;

class Farmer {
    int pa;
    float td;
    float ri;
    float si;
    float ci;

    // Input method
    void input(int farmerNumber) {
        Scanner scan = new Scanner(System.in);
        System.out.println("\n🌾 Farmer " + farmerNumber + " Details 🌾");
        
        // Principal amount input with validation
        while (true) {
            System.out.print("Enter the amount required (₹): ");
            pa = scan.nextInt();
            if (pa > 0) break;
            System.out.println(" Invalid amount. Please enter a positive value.");
        }

        // Time duration input with validation
        while (true) {
            System.out.print("Enter the time duration (in years): ");
            td = scan.nextFloat();
            if (td > 0) break;
            System.out.println(" Invalid duration. Please enter a positive value.");
        }

        // Dynamic interest rate input
        System.out.print("Enter the interest rate (%): ");
        ri = scan.nextFloat();
    }

    // SI Calculation
    void computeSI() {
        si = (pa * ri * td) / 100f;
    }

    // Compound Interest Calculation
    void computeCI() {
        ci = (float) (pa * Math.pow(1 + (ri / 100), td) - pa);
    }

   
    void display(int farmerNumber) {
        System.out.println("\n📊 Farmer " + farmerNumber + " Loan Details 📊");
        System.out.println("-----------------------------");
        System.out.printf(" Principal Amount: ₹%,d%n", pa);
        System.out.printf(" Time Duration: %.2f years%n", td);
        System.out.printf("Interest Rate: %.2f%%%n", ri);
        System.out.printf("Simple Interest: ₹%.2f%n", si);
        System.out.printf("Compound Interest: ₹%.2f%n", ci);
        System.out.println("-----------------------------");
    }
}

public class Lone1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\n Enter the number of farmers: ");
        int numFarmers = scanner.nextInt();
        
        // Array of Farmer objects
        Farmer[] farmers = new Farmer[numFarmers];

        for (int i = 0; i < numFarmers; i++) {
            farmers[i] = new Farmer();
            farmers[i].input(i + 1);
            farmers[i].computeSI();
            farmers[i].computeCI();
            farmers[i].display(i + 1);
        }
        
        System.out.println("\n✅ Loan calculation completed for all farmers!");
        scanner.close();
    }
}

