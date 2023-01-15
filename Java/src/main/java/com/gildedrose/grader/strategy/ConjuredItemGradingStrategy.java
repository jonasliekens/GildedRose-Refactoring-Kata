package com.gildedrose.grader.strategy;

/**
 * Conjured items follow the same logic as common items, but degrade twice as fast.
 */
public class ConjuredItemGradingStrategy extends CommonItemGradingStrategy{
    @Override
    protected Integer determineDegradingMultiplier(Integer sellIn) {
        return super.determineDegradingMultiplier(sellIn) * 2;
    }
}
