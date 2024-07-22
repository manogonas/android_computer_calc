package com.example.computer_calc;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    //Объявление полей класса
    TextView procPriceLabel, motherboardPriceLabel, memoryPriceLabel, periferalPriceLabel, resultLabel;
    Computer c;
    Spinner sp1;
    CheckBox cb;
    RadioButton am4, am5, lga1151, lga1200, lga1700;
    SeekBar sb;
    CustomAdapter adapter;
    String price;
    String[] names = {"Процессор AMD A6-7480 OEM [FM2+, 2 x 3.5 ГГц, L2 - 1 МБ, 2 х DDR3-2133 МГц, AMD Radeon R5, TDP 65 Вт]",
            "Процессор AMD FX-4300 BOX [AM3+, 4 x 3.8 ГГц, L2 - 4 МБ, L3 - 4 МБ, 2 х DDR3-1866 МГц, TDP 95 Вт, кулер]",
            "Процессор AMD Athlon 200GE OEM [AM4, 2 x 3.2 ГГц, L2 - 1 МБ, L3 - 4 МБ, 2 х DDR4-2667 МГц, AMD Radeon Vega 3, TDP 35 Вт]",
            "Процессор AMD Athlon 3000G OEM [AM4, 2 x 3.5 ГГц, L2 - 1 МБ, L3 - 4 МБ, 2 х DDR4-2666 МГц, AMD Radeon Vega 3, TDP 35 Вт]",
            "Процессор Intel Celeron G5905 OEM [LGA 1200, 2 x 3.5 ГГц, L2 - 0.5 МБ, L3 - 4 МБ, 2 х DDR4-2666 МГц, Intel UHD Graphics 610, TDP 58 Вт]"};
    int[] images = {R.drawable.first,
                    R.drawable.second,
                    R.drawable.third,
                    R.drawable.fourth,
                    R.drawable.fifth};
    float[] prices = {1199, 1850, 3599, 4499, 4499};

    //Переопределение слушателей
    //Для выпадающего списка
    AdapterView.OnItemSelectedListener proc_listener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            setPrice(prices[i], 1);
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };
    //Для переключателя
    View.OnClickListener motherboard_listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            RadioButton rb = (RadioButton) v;
            float p = 0;
             if (rb.getId() == R.id.am4) {
                 p = 5999;
             } else if (rb.getId() == R.id.am5) {
                 p = 9899;
             } else if (rb.getId() ==  R.id.lga_1151) {
                 p = 6999;
             } else if (rb.getId() == R.id.lga_1200) {
                 p = 5799;
             } else if (rb.getId() == R.id.lga_1700) {
                 p = 6699;
             }
            setPrice(p, 2);
        }
    };
    //Для слайдера
    SeekBar.OnSeekBarChangeListener mem_listener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
            int selected = seekBar.getProgress();
            int selected1 = i;
            double p = 0;
            if (selected1 == 0) {
                p = 1099;
            } else if (selected1 == 1) {
                p = 899;
            }
            else if (selected1 == 2) {
                p = 1499;
            }
            else if (selected1 == 3) {
                p = 3299;
            }
            else if (selected1 == 4) {
                p = 8099;
            }
            setPrice(p, 3);
        }
        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {}
        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {}
    };
    //Для флажка
    View.OnClickListener per_listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            double p = 0;
            if (((CheckBox) view).isChecked()) {
                p = 15000;
            }
            setPrice(p, 4);
        }
    };

    //Переопределение метода onCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Инициализация полей
        c = new Computer();
        sp1 = findViewById(R.id.spinner);
        cb = findViewById(R.id.periferal);
        am4 = findViewById(R.id.am4);
        am5 = findViewById(R.id.am5);
        lga1151 = findViewById(R.id.lga_1151);
        lga1200 = findViewById(R.id.lga_1200);
        lga1700 = findViewById(R.id.lga_1700);
        sb = findViewById(R.id.seekbar);
        adapter = new CustomAdapter(this, names, images);
        procPriceLabel = findViewById(R.id.proc_price);
        motherboardPriceLabel = findViewById(R.id.motherboard_price);
        memoryPriceLabel = findViewById(R.id.mem_price);
        periferalPriceLabel = findViewById(R.id.per_price);
        resultLabel = findViewById(R.id.res);

        //Назначение адаптера и слушателей
        sp1.setAdapter(adapter);
        sp1.setOnItemSelectedListener(proc_listener);
        am4.setOnClickListener(motherboard_listener);
        am5.setOnClickListener(motherboard_listener);
        lga1151.setOnClickListener(motherboard_listener);
        lga1200.setOnClickListener(motherboard_listener);
        lga1700.setOnClickListener(motherboard_listener);
        sb.setOnSeekBarChangeListener(mem_listener);
        cb.setOnClickListener(per_listener);
    }

    //Вспомогательные методы
    //Для установки значений и вывода цены
    public void setPrice(double p, int i) {
        price = p + " руб.";
        switch (i) {
            case 1:
                procPriceLabel.setText(price);
                c.setProc(p);
                break;
            case 2:
                motherboardPriceLabel.setText(price);
                c.setMotherboard(p);
                break;
            case 3:
                memoryPriceLabel.setText(price);
                c.setMem(p);
                break;
            case 4:
                periferalPriceLabel.setText(price);
                c.setPer(p);
                break;
        }
        updRes();
    }
    //Для подсчёта и обновления результата
    public void updRes() {
        String s = "Итоговая цена: " + c.getResult() + " рублей.";
        resultLabel.setText(s);
    }
}