public class Person {
	
    private HireDate date;
    
    public void setHireDate(HireDate date) {
        this.date = date;
    }

    public int getHireDay() {
        return date.getHireDay();
    }

    public int getHireMonth() {
        return date.getHireMonth();
    }

    public int getHireYear() {
        return date.getHireYear();
    }
}
