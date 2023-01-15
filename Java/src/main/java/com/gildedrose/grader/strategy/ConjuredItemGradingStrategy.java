package com.gildedrose.grader.strategy;

public class ConjuredItemGradingStrategy extends CommonItemGradingStrategy{
    @Override
    protected Integer determineDegradingMultiplier(Integer sellIn) {
        return super.determineDegradingMultiplier(sellIn) * 2;
    }
}
