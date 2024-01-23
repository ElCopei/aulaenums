package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import entities.HourContract;
import entities.enums.WorkerLevel;

public class Worker {
    private String name;
    private WorkerLevel level;
    private Double baseSalary;

    private Departament departament; // 1a composição com a classe departament
    private List<HourContract> contracts = new ArrayList<>(); // 2a composição com a classe HourContract, notar q um
                                                              // trabalhador pode ter mais de um contrata
    // por isso *contrats* é o do tipo List

    public Worker(String name, WorkerLevel level, Double baseSalary, Departament departament) {
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.departament = departament;
        // Quando há uma composição com lista, esta n é passada como argumento no
        // construtor, mas sim inicia a lista vazia na declaração
    }

    public Worker(String name, Double baseSalary, Departament departament) {
        this.name = name;
        this.baseSalary = baseSalary;
        this.departament = departament;
    }

    public void AddContract(HourContract contract) {
        contracts.add(contract);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkerLevel getLevel() {
        return level;
    }

    public void setLevel(WorkerLevel level) {
        this.level = level;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Departament getDepartament() {
        return departament;
    }

    public void setDepartament(Departament departament) {
        this.departament = departament;
    }

    public List<HourContract> getContracts() {
        return contracts;
    }

    // implementação dos métodos da classe
    public void removeContract(HourContract contract) {
        contracts.remove(contract);
    }

    public Double income(Integer year, Integer month) {
        Double sum = baseSalary;
        for (HourContract c : contracts) {
            LocalDate c_date = c.getDate();
            int c_month = c_date.getMonthValue();
            int c_year = c_date.getYear();
            if (year==c_year && month==c_month) {
                sum += c.totalValue();
            }
        }
        return sum;
    }

}
