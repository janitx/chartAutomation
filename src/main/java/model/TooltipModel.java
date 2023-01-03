package model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;


@JsonPropertyOrder({"date", "year", "name", "numberOfEmployee"})
public class TooltipModel {
    private String date;
    private String year;
    private String name;
    private String numberOfEmployees;

    public TooltipModel() {
    }

    public TooltipModel(String date, String year, String name, String numberOfEmployees) {
        this.date = date;
        this.year = year;
        this.name = name;
        this.numberOfEmployees = numberOfEmployees;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getSurname() {
        return name;
    }

    public void setSurname(String name) {
        this.name = name;
    }

    public String getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(String numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    @Override
    public String toString() {
        return "TooltipModel{" +
                "date='" + date + '\'' +
                ", year='" + year + '\'' +
                ", name='" + name + '\'' +
                ", numberOfEmployees=" + numberOfEmployees +
                '}';
    }

    public String asString() {
        return String.format("%s, %s%s%s employees", date, year, numberOfEmployees, name);
    }
}
