package com.example.computer_calc;

public class Computer {
    //Поля
    public double procPrice, motherboardPrice, memPrice, perPrice;
    //Конструктор
    Computer() {
        procPrice = 0;
        motherboardPrice = 0;
        memPrice = 1099;
        perPrice = 0;
    }
    //Сеттеры
    public void setProc(double p) {
        procPrice = p;
    }
    public void setMotherboard(double p) {
        motherboardPrice = p;
    }
    public void setMem(double p) {
        memPrice = p;
    }
    public void setPer(double p) {
        perPrice = p;
    }
    //Метод подсчёта результата
    public double getResult() {
        return procPrice + motherboardPrice + memPrice + perPrice;
    }
}
