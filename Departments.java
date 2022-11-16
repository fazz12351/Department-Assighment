public class Departments {
    private String SelectedDeparment;
    private int Income=0;
    public Departments(){

    }
    public String selectDep(String Dep){
        SelectedDeparment=Dep;
        return SelectedDeparment;

    }
    public int setIncome(int MIncome){
        Income=Income+MIncome;
        return Income;
    }

    public void getInformation(){

        System.out.print("This month income is"+Income);
        System.out.print("Department is "+SelectedDeparment);
    }

    
}
