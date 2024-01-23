package entities;

import java.time.LocalDate;

public class HourContract {
    private LocalDate date;
    private Double ValuePerHour;
    private Integer hours;

    
    


    public HourContract(LocalDate date, Double valuePerHour, Integer hours) {
        this.date = date;
        ValuePerHour = valuePerHour;
        this.hours = hours;
    }


    public HourContract() {
    }


    public LocalDate getDate() {
        return date;
    }


    public void setDate(LocalDate date) {
        this.date = date;
    }


    public Double getValuePerHour() {
        return ValuePerHour;
    }


    public void setValuePerHour(Double valuePerHour) {
        ValuePerHour = valuePerHour;
    }


    public Integer getHours() {
        return hours;
    }


    public void setHours(Integer hours) {
        this.hours = hours;
    }
    
    public double totalValue(){
        return ValuePerHour*hours;
    }


    @Override
    public String toString() {
        return "HourContract [date=" + date + ", ValuePerHour=" + ValuePerHour + ", hours=" + hours + "]";
    }
    
}
