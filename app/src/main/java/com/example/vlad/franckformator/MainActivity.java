package com.example.vlad.franckformator;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

/**
 * Create Navigation menu
 * Manage PieChart and Spending Fragment
 */

public class MainActivity extends AppCompatActivity {


    protected String[] mActivities = new String[]{
            "Products", "Leisure", "Lunch", "Clothes", "Sport", "Entertainment"
    };

    protected Float[] mPercents = new Float[]{
            21.0f, 25f, 25f, 6f, 2f, 17f
    };

    private PieChart mChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart);
        ArrayList<PieEntry> entries = new ArrayList<PieEntry>();

        mChart = findViewById(R.id.chart);// NOTE: The order of the entries when being added to the entries array determines their position around the center of
        // the chart.
        for (int i = 0; i < 6; i++) {
            entries.add(new PieEntry(mPercents[i], mActivities[i]));
        }

        PieDataSet dataSet = new PieDataSet(entries, "SomeLabel");
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
        data.setValueFormatter(new PercentFormatter());
        data.setValueTextSize(11f);
        data.setValueTextColor(Color.BLACK);


        mChart.setUsePercentValues(true);
        mChart.animateY(1400, Easing.EasingOption.EaseInOutQuad);
        mChart.setCenterText("FF");
        mChart.setCenterTextSize(32f);
        mChart.setData(data);
        mChart.setRotationEnabled(false);
        mChart.invalidate();
    }
    }
