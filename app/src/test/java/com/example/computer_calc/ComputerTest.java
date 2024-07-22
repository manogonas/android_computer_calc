package com.example.computer_calc;

import org.junit.Test;
import org.mockito.Mock;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.*;

public class ComputerTest {
    @Mock
    Computer c = new Computer();

    @Test
    public void createComputer() {
        //Проверяем типы полей
        assertThat(c.procPrice, instanceOf(double.class));
        assertThat(c.motherboardPrice, instanceOf(double.class));
        assertThat(c.memPrice, instanceOf(double.class));
        assertThat(c.perPrice, instanceOf(double.class));
    }

    @Test
    public void setPrices() {
        //Устанавливаем новые значения
        c.setMem(100);
        c.setMotherboard(100);
        c.setPer(100);
        c.setProc(100);
        //Проверяем правильность установки
        assertEquals(100, c.procPrice, 0.1);
        assertEquals(100, c.motherboardPrice, 0.1);
        assertEquals(100, c.memPrice, 0.1);
        assertEquals(100, c.perPrice, 0.1);
        //Проверяем правильность результата
        assertEquals(400, c.getResult(), 0.1);
    }
}