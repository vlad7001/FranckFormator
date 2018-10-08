package com.example.vlad.franckformator;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import com.example.vlad.franckformator.data.Spending;
import com.example.vlad.franckformator.storage.DatabaseStorage;
import com.example.vlad.franckformator.storage.Storage;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Create Navigation menu
 * Manage PieChart and Spending Fragment
 */

public class PieChartActivity extends AppCompatActivity {

    Storage storage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart);

        storage = new DatabaseStorage(PieChartActivity.this);

        List<Spending> spendings = storage.fetch();
        List<PieEntry> entries = getEntries(spendings);
        initPieChart(entries);
    }



    protected String[] mActivities = new String[]{       //list of possible SpendingTypes
            "PRODUCTS", "LEISURE", "LUNCH", "CLOTHES", "SPORT", "FUN"
    };

    private List<PieEntry> getEntries(List<Spending> spendings) {
        List<PieEntry> entries = new ArrayList<PieEntry>();
        for (String activityName : mActivities) {
            float sumOfEntries = 0f;                //sum per one SpendingType
            for (Spending spending : spendings) {
                if (spending.type.toString().equals(activityName)) {
                    sumOfEntries += spending.amount;
                }
            }
            if (sumOfEntries > 0) {
                entries.add(new PieEntry(sumOfEntries, activityName));
            }
        }
        return entries;
    }

    //List<PieEntry> - список который отображает библиотека PieChart
    // PieEntry состоит из значения и названия, где значение это сумма всех трат для определенной категории,
    // а название это название категории трат.
    // List<Spending> это то что мы получили из Сторедж.
    void initPieChart(List<PieEntry> entries) {
        PieChart mChart = findViewById(R.id.chart);
        // the chart.
        PieDataSet dataSet = new PieDataSet(entries, "");
        ArrayList<Integer> colors = new ArrayList<Integer>();

        for (int c : ColorTemplate.VORDIPLOM_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.JOYFUL_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.COLORFUL_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.LIBERTY_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.PASTEL_COLORS)
            colors.add(c);

        colors.add(ColorTemplate.getHoloBlue());
        dataSet.setColors(colors);

        PieData data = new PieData(dataSet);
//        data.setValueFormatter(new PercentFormatter());
        data.setValueTextSize(11f);
        data.setValueTextColor(Color.BLACK);


//        mChart.setUs(true);
        mChart.animateY(1400, Easing.EasingOption.EaseInOutQuad);
        mChart.setCenterText("FF");
        mChart.setCenterTextSize(32f);
        mChart.setData(data);
        mChart.setRotationEnabled(false);
        mChart.invalidate();
    }
}
