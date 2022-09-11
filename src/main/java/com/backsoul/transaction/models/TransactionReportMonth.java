package com.backsoul.transaction.models;

import java.util.ArrayList;
import java.util.List;

public class TransactionReportMonth {
    public String month;

    public int total;

    public List<TransactionReportMonth> months;

    public TransactionReportMonth() {
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setAmountMonth(String monthName, int amount) {
        for (var month : this.months) {
            if (month.getMonth().equals(monthName)) {
                month.setTotal(month.getTotal() + amount);
            }
        }
    }

    public void setupMonths() {
        TransactionReportMonth January = new TransactionReportMonth();
        this.months = new ArrayList<TransactionReportMonth>();
        January.setTotal(0);
        January.setMonth("January");
        this.months.add(January);

        TransactionReportMonth February = new TransactionReportMonth();
        February.setTotal(0);
        February.setMonth("February");
        this.months.add(February);

        TransactionReportMonth March = new TransactionReportMonth();
        March.setTotal(0);
        March.setMonth("March");
        this.months.add(March);

        TransactionReportMonth April = new TransactionReportMonth();
        April.setTotal(0);
        April.setMonth("April");
        this.months.add(April);

        TransactionReportMonth May = new TransactionReportMonth();
        May.setTotal(0);
        May.setMonth("May");
        this.months.add(May);

        TransactionReportMonth June = new TransactionReportMonth();
        June.setTotal(0);
        June.setMonth("June");
        this.months.add(June);

        TransactionReportMonth July = new TransactionReportMonth();
        July.setTotal(0);
        July.setMonth("July");
        this.months.add(July);

        TransactionReportMonth August = new TransactionReportMonth();
        August.setTotal(0);
        August.setMonth("August");
        this.months.add(August);

        TransactionReportMonth September = new TransactionReportMonth();
        September.setTotal(0);
        September.setMonth("September");
        this.months.add(September);

        TransactionReportMonth Octuber = new TransactionReportMonth();
        Octuber.setTotal(0);
        Octuber.setMonth("Octuber");
        this.months.add(Octuber);

        TransactionReportMonth November = new TransactionReportMonth();
        November.setTotal(0);
        November.setMonth("November");
        this.months.add(November);

        TransactionReportMonth December = new TransactionReportMonth();
        December.setTotal(0);
        December.setMonth("December");
        this.months.add(December);
    }
}
