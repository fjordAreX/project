package Homework3.Basic;

import java.io.Serializable;

public class FinancialRecord {

    private int incomes;
    private int outcomes;

    public int getIncomes() {
        return incomes;
    }

    public void setIncomes(int incomes) {
        this.incomes = incomes;
    }

    public int getOutcomes() {
        return outcomes;
    }

    public void setOutcomes(int outcomes) {
        this.outcomes = outcomes;
    }

    public FinancialRecord(int incomes, int outcomes) {
        this.incomes = incomes;
        this.outcomes = outcomes;
    }

    @Override
    public String toString() {
        return "доходы = " + incomes +
                ", расходы = " + outcomes + "; ";
    }
}
