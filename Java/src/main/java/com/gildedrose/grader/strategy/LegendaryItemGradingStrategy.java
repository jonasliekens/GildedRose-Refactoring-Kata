package com.gildedrose.grader.strategy;

import com.gildedrose.Item;

public class LegendaryItemGradingStrategy implements ItemGradingStrategy{
    @Override
    public void gradeItem(Item item) {
        // does nothing, legendary items do not increase, nor decrease in value :)
    }
}
