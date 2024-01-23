package application;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Departament;
import entities.HourContract;
import entities.Worker;


public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        List<HourContract> contracts = new ArrayList<>();
        System.out.println("Enter departament's name: ");
        String departament = sc.nextLine();
        System.out.println("Enter worker data: ");
        System.out.println("Name: ");
        String name = sc.nextLine();
        System.out.println("Base salary: ");
        Double baseSalary = sc.nextDouble();
        Departament d = new Departament(departament);
        Worker w = new Worker(name, baseSalary, d);
        System.out.println("How many contracts to this worker?");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter contract #" + (i + 1) + "data");
            System.out.println("Date (DD/MM/YYYY): ");
            sc.nextLine();
            String data = sc.nextLine();
            LocalDate localDate = LocalDate.parse(data,formatter);
            System.out.println("Value per hour: ");
            Double valuePerHour = sc.nextDouble();
            System.out.println("Duration(hours): ");
            Integer duration = sc.nextInt();
            HourContract c = new HourContract(localDate, valuePerHour, duration);
            w.AddContract(c);

        }
       /*  for(HourContract c: list){
            LocalDate teste = c.getDate();
            System.out.println("Ano: "+ teste.getYear());
            System.out.println(c.totalValue());
        }*/
        sc.nextLine();
        System.out.println("Enter the month and year to calculute income (MM/YYYY)");
        String dateToCons = sc.nextLine();
        LocalDate localDate = LocalDate.parse("01/"+dateToCons,formatter2);
        Integer year = localDate.getYear();
        Integer month =localDate.getMonthValue();
    
       
        System.out.println("Name: "+ w.getName());
        System.out.println("Departament: "+ d.getName());
        System.out.println("Income for "+dateToCons+": "+ w.income(year, month));

        sc.close();
    }
}
