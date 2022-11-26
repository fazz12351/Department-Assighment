import java.math.BigDecimal;
import java.time.Month;
import java.util.Scanner;
import javax.security.sasl.SaslServer;
import javax.sound.sampled.FloatControl;

public class Quarterly_Report {
    //store each department in an array. Electrical is in index 0 meaning the sales in january will also be at index 0
    public static String[] Departments = {
        "Electrical",
        "Kitchen",
        "Bathroom",
        "Soft Furnighsing",
        "Accessories"
    };
    //the sales of each department in January is listed
    public static int[] SalesJan = {
        0,
        0,
        0,
        65,
        55
    };
    //Sales in Feb
    public static int[] SalesFeb = {
        0,
        0,
        0,
        120,
        55
    };
    //Sales in March
    public static int[] SalesMar = {
        0,
        0,
        0,
        19,
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
    //sales in Jun
    public static int[] SalesJun = {
        78,
        56,
        65,
        22,
        21
    };
    //Sales in July
    public static int[] SalesJul = {
        78,
        45,
        71,
        19,
        19
    };
    //Sales in Aug
    public static int[] SalesAug = {
        104,
        56,
        73,
        17,
        20
    };
    //Sales in Sep
    public static int[] SalesSep = {
        103,
        72,
        69,
        16,
        19
    };



    //main method which is called and executeed when the application is running
    public static void main(String[] args) {
        //Call "QuaterIncome" function with the quaters you would like data about as the paramater of the function for example "QuaterIncome(2)" for all data to quater 2 .
        QuatersIncome(2);

    }

    //this method takes int value. Based on the users input, we display certain data. Forexample, quater 2 we will display data dealing with month from APril to June.
    public static void QuatersIncome(int quaters) {
        //this conditonal checks if the users input is withing range. If not, we get defualt respoonce such as out of range. 
        if (quaters <= 0) {
            System.out.print("Error, Make Sure Your Withing Range of 1,3");
        } else if (quaters > 3) {
            System.out.print("Out of range ; No Data Available");
        }


        //if the above conditional are false, we execute the code below.
        //we create integer varailes for each department which stored the return value of the Department calculation function. The function is repsonmsible for working out the total sales of a selected department.
        //the selected department is selected ny taking in paramanter as there input asn quater as the second input. 
        else {
            int ElectricalSales = DepartmentCalculations(0, quaters);
            // System.out.println("Electric : " + ElectricalSales);
            int KitchenSales = DepartmentCalculations(1, quaters);
            // System.out.println("Kitchen : " + KitchenSales);
            int BathroomSales = DepartmentCalculations(2, quaters);
            // System.out.println("Bathroom : " + BathroomSales);

            int SoftFurnishingSales = DepartmentCalculations(3, quaters);
            // System.out.println("SoftFurnishing : " + SoftFurnishingSales);

            int AccessoriesSales = DepartmentCalculations(4, quaters);
            // System.out.println("Accessories : " + AccessoriesSales);


            //this method displays the best and worst peformance of each department.
            bestAndWorstPeformingDep(ElectricalSales, KitchenSales, BathroomSales, SoftFurnishingSales, AccessoriesSales, quaters);
            //this works out the tax neede to pay for each department
            taxneeded(ElectricalSales, KitchenSales, BathroomSales, SoftFurnishingSales, AccessoriesSales);
            //this works iout the future sales targetr of each quater
            newSalesTarget(ElectricalSales, KitchenSales, BathroomSales, SoftFurnishingSales, AccessoriesSales);
            //this figures out the most afective months in a specific quater.
            MostAffectiveMonths(quaters);


        }



    }
    //this return method allows us to work out the toals sales within a given quater.
    public static int DepartmentCalculations(int Departments, int Quaters) {
        //we cerate a local variabel which stores the current ewrning. Depending on the quaters which is passed by the  Quaterincome function, we will execute a specific condition.
        int Earnings = 0;

        //forexample, if quaters in the main mehtod is set to 1, we execute the conditon. The conditoon  loops through a specif quantity of elements in an array which depend on the deparmtent we need.
        //Forexample,if we wanted Electronic data, we will set the Departments partam to 0 and add the int "deparment" so we know the starting point of the loop and the ending point.
        //we then get the index and get the sales of that index with that specificed quater.
        if (Quaters == 1) {
            for (int i = 0 + Departments; i < 1 + Departments; i++) {
                Earnings = SalesJan[i] + SalesFeb[i] + SalesMar[i];
            }
        }

        //the same goes with this method. If the quaters are set to 2 in the mian method,we loop through the elemebnt and output the earning within the months in that quater.
        else if (Quaters == 2) {
            for (int j = 0 + Departments; j < 1 + Departments; j++) {
                Earnings = SalesApr[j] + SalesMay[j] + SalesJun[j];
            }

        } else if (Quaters == 3) {
            for (int u = 0 + Departments; u < 1 + Departments; u++) {
                Earnings = SalesJul[u] + SalesAug[u] + SalesSep[u];
            }

        }
        //we return out earning so we will be able to use that data to work out tax, future sales ect.......
        return Earnings;
    }

    //as we have total sales of eadh department, we can now work out the best and worst peforming deparment using the return data of our departmentcaluclation method.
    public static void bestAndWorstPeformingDep(int dep1, int dep2, int dep3, int dep4, int dep5, int quaters) {
        //the highes income is set to 0. This defualt valeue will change 
        //the lowest income is by deafualt set to dep1. The reason for this is because if we have it set to 0, No departament value is less than or equal to that. Whic hwill return invalid data
        //
        int highestIncome = 0;
        int lowestIncome = dep1;
        String BestDepartment = "";
        String WorstDepartment = "";
        int HighestEarningMonth1 = 0;
        int HighestEarningMonth2 = 0;
        int HighestEarningMonth3 = 0;
        int LowestEarningMonth1 = 0;
        int LowestEarningMonth2 = 0;
        int LowestEarningMonth3 = 0;
        //we store the total sales of each department into an array.
        int[] largerst = {
            dep1,
            dep2,
            dep3,
            dep4,
            dep5
        };

        //we loop through the start of the array till the end. if any elements in the array is less than our default lowest sales which is Electornics, the result of that will be saved to lowestIncoem.
        for (int i = 0; i < largerst.length; i++) {
            if (largerst[i] <= lowestIncome) {
                lowestIncome = largerst[i];
                WorstDepartment = Departments[i];

                //we then check the quaters we are in. this data is passed using the quaters method in our main method. 
                //we set the vatrible lowestearning to the corresponfig output of sales.
                if (quaters == 1) {
                    LowestEarningMonth1 = SalesJan[i];
                    LowestEarningMonth2 = SalesFeb[i];
                    LowestEarningMonth3 = SalesMar[i];

                } 
                //this goes the same with the above
                else if (quaters == 2) {
                    LowestEarningMonth1 = SalesApr[i];
                    LowestEarningMonth2 = SalesMay[i];
                    LowestEarningMonth3 = SalesJun[i];

                }
                //this goes the same iwht the above. 
                else if (quaters == 3) {
                    LowestEarningMonth1 = SalesJul[i];
                    LowestEarningMonth2 = SalesAug[i];
                    LowestEarningMonth3 = SalesSep[i];

                }
            }
            //we work out the highestincome
            if (largerst[i] >= highestIncome) {
                //this variables 
                highestIncome = largerst[i];
                BestDepartment = Departments[i];
                if (quaters == 1) {

                    HighestEarningMonth1 = SalesJan[i];
                    HighestEarningMonth2 = SalesFeb[i];
                    HighestEarningMonth3 = SalesMar[i];

                } else if (quaters == 2) {

                    HighestEarningMonth1 = SalesApr[i];
                    HighestEarningMonth2 = SalesMay[i];
                    HighestEarningMonth3 = SalesJun[i];


                } else if (quaters == 3) {
                    HighestEarningMonth1 = SalesJul[i];
                    HighestEarningMonth2 = SalesAug[i];
                    HighestEarningMonth3 = SalesSep[i];

                }
            }
        }
        System.out.println("The best peforming department is : " + BestDepartment + " With Sales of " + highestIncome + " in Quater " + quaters + " With respective sales of:");
        System.out.println("Month 1 : " + HighestEarningMonth1);
        System.out.println("Month 2 : " + HighestEarningMonth2);
        System.out.println("Month 3 : " + HighestEarningMonth3);
        System.out.println("Total :" + highestIncome);

        System.out.println("The worst peforming department is " + WorstDepartment + " which has made  the least with " + lowestIncome + " as there final total in Quater" + quaters + " With respective sales of:");
        System.out.println("Lowest Month 1 : " + LowestEarningMonth1);
        System.out.println("Lowest Month 2 : " + LowestEarningMonth2);
        System.out.println("Lowest Month 3 : " + LowestEarningMonth3);
        System.out.println("Total :" + lowestIncome);




    }

    public static void MostAffectiveMonths(int quaters) {
        if (quaters == 1) {
            for (int i = 0; i < Departments.length; i++) {
                String MostAffectiveMonth = "";
                int CurrentAmount = 0;
                if (SalesJan[i] >= CurrentAmount) {
                    CurrentAmount = SalesJan[i];
                    MostAffectiveMonth = "Jan";
                }
                if (SalesFeb[i] >= CurrentAmount) {
                    CurrentAmount = SalesFeb[i];
                    MostAffectiveMonth = "Feb";
                }
                if (SalesMar[i] >= CurrentAmount) {
                    CurrentAmount = SalesMar[i];
                    MostAffectiveMonth = "Mar";
                }
                System.out.println(Departments[i] + "s most affective mointh is " + MostAffectiveMonth + " in Quater " + quaters + " With sales of " + CurrentAmount);




            }

        }
        if (quaters == 2) {
            for (int i = 0; i < Departments.length; i++) {
                String MostAffectiveMonth = "";
                int CurrentAmount = 0;
                if (SalesApr[i] >= CurrentAmount) {
                    CurrentAmount = SalesApr[i];
                    MostAffectiveMonth = "April";
                }
                if (SalesMay[i] >= CurrentAmount) {
                    CurrentAmount = SalesMay[i];
                    MostAffectiveMonth = "May";
                }
                if (SalesJun[i] >= CurrentAmount) {
                    CurrentAmount = SalesJun[i];
                    MostAffectiveMonth = "Jun";
                }
                System.out.println(Departments[i] + "s most affective mointh is " + MostAffectiveMonth + " in Quater " + quaters + " With sales of " + CurrentAmount);




            }

        }
        if (quaters == 3) {

            for (int j = 0; j < Departments.length; j++) {
                String MostAffectiveMonth = "";
                int CurrentAmount = 0;
                if (SalesJul[j] >= CurrentAmount) {
                    CurrentAmount = SalesJul[j];
                    MostAffectiveMonth = "Jul";
                }
                if (SalesAug[j] >= CurrentAmount) {
                    CurrentAmount = SalesAug[j];
                    MostAffectiveMonth = "Aug";
                }
                if (SalesSep[j] >= CurrentAmount) {
                    CurrentAmount = SalesSep[j];
                    MostAffectiveMonth = "Sep";
                }
                System.out.println(Departments[j] + "s most affective mointh is " + MostAffectiveMonth + " in Quater " + quaters + " With sales of " + CurrentAmount);




            }

        }
    }

    public static void taxneeded(int dep1, int dep2, int dep3, int dep4, int dep5) {
        int[] DepartmentTaxTotals = {
            dep1,
            dep2,
            dep3,
            dep4,
            dep5
        };
        float[] TaxDueForEachDeps = {
            0,
            0,
            0,
            0,
            0
        };
        float taxPercent = 17f;

        for (int i = 0; i < DepartmentTaxTotals.length; i++) {

            Float amounFloatnew = new Float(DepartmentTaxTotals[i]);
            float changeValue = amounFloatnew.floatValue();
            float interestAdded = changeValue / 100 * taxPercent;
            TaxDueForEachDeps[i] = interestAdded;
        }
        for (var j = 0; j < TaxDueForEachDeps.length; j++) {
            System.out.println("Tax Needed For " + Departments[j] + " :");
            System.out.println(TaxDueForEachDeps[j]);
            System.out.println("       ");
        }


    }

    public static void newSalesTarget(int dep1, int dep2, int dep3, int dep4, int dep5) {
        int[] averageSales = {
            dep1,
            dep2,
            dep3,
            dep4,
            dep5
        };
        for (int i = 0; i < averageSales.length; i++) {
            double average = averageSales[i] / 3;
            double increasePercentage = average / 100 * 12;
            System.out.print(Departments[i] + " New sales target is : ");
            System.out.print(average + increasePercentage);
            System.out.print(":::");

        }


    }
}