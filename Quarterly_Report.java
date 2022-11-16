import java.time.Month;
import java.util.Scanner;
import javax.security.sasl.SaslServer;

public class Quarterly_Report {
    String BestPeromingDepartment = "";
    public static String[] Departments = {
        "Electrical",
        "Kitchen",
        "Bathroom",
        "Soft Furnighsing",
        "Accessories"
    };
    public static int[] SalesJan = {
        0,
        0,
        0,
        0,
        55
    };
    public static int[] SalesFeb = {
        0,
        0,
        0,
        0,
        55
    };
    public static int[] SalesMar = {
        0,
        0,
        0,
        0,
        55
    };
    public static int[] SalesApr = {
        67,
        65,
        63,
        18,
        16
    };
    public static int[] SalesMay = {
        63,
        67,
        63,
        24,
        23
    };
    public static int[] SalesJun = {
        78,
        56,
        65,
        22,
        21
    };
    public static int[] SalesJul = {
        78,
        45,
        71,
        19,
        19
    };
    public static int[] SalesAug = {
        104,
        56,
        73,
        17,
        20
    };
    public static int[] SalesSep = {
        103,
        72,
        69,
        16,
        19
    };




    public static void main(String[] args) {
        //Select the quater information you would like;
        QuatersIncome(2);


    }


    public static void QuatersIncome(int quaters) {
        int ElectricalSales = DepartmentCalculations(0, quaters);
        System.out.println("Electric : " + ElectricalSales);
        int KitchenSales = DepartmentCalculations(1, quaters);
        System.out.println("Kitchen : " + KitchenSales);
        int BathroomSales = DepartmentCalculations(2, quaters);
        System.out.println("Bathroom : " + BathroomSales);

        int SoftFurnishingSales = DepartmentCalculations(3, quaters);
        System.out.println("SoftFurnishing : " + SoftFurnishingSales);

        int AccessoriesSales = DepartmentCalculations(4, quaters);
        System.out.println("Accessories : " + AccessoriesSales);

        peformance(ElectricalSales, KitchenSales, BathroomSales, SoftFurnishingSales, AccessoriesSales, quaters);
    }



    public static int DepartmentCalculations(int Departments, int Quaters) {
        int Earnings = 0;
        if (Quaters == 1) {
            for (int i = 0 + Departments; i < 1 + Departments; i++) {
                Earnings = SalesJan[i] + SalesFeb[i] + SalesMar[i];
            }
        } else if (Quaters == 2) {
            for (int j = 0 + Departments; j < 1 + Departments; j++) {
                Earnings = SalesApr[j] + SalesMay[j] + SalesJun[j];
            }

        } else if (Quaters == 3) {
            for (int u = 0 + Departments; u < 1 + Departments; u++) {
                Earnings = SalesJul[u] + SalesAug[u] + SalesSep[u];
            }

        }

        return Earnings;
    }

    public static String peformance(int dep1, int dep2, int dep3, int dep4, int dep5, int quaters) {
        int[] largerst = {
            dep1,
            dep2,
            dep3,
            dep4,
            dep5
        };
        int highestIncome = 0;
        int highestIncomeIndex = 0;
        String BestDepartment = "";
        int EarningMonth1 = 0;
        int EarningMonth2 = 0;
        int EarningMonth3 = 0;


        for (int i = 0; i < largerst.length; i++) {
            if (largerst[i] >= highestIncome) {
                highestIncome = largerst[i];
                BestDepartment = Departments[i];
                if (quaters == 1) {

                    EarningMonth1 = SalesJan[i];
                    EarningMonth2 = SalesFeb[i];
                    EarningMonth3 = SalesMar[i];

                } else if (quaters == 2) {

                    EarningMonth1 = SalesApr[i];
                    EarningMonth2 = SalesMay[i];
                    EarningMonth3 = SalesJun[i];


                }
            }
        }
        System.out.println("The best peforming department is : " + BestDepartment + " With Sales of " + highestIncome + " in Quater " + quaters);
        System.out.println("Month 1 : "+EarningMonth1);
        System.out.println("Month 2 : "+EarningMonth2);
        System.out.println("Month 3 : "+EarningMonth3);
        return BestDepartment;



    }
}