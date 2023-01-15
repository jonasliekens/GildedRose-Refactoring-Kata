package com.gildedrose.grader;

import com.gildedrose.Item;
import com.gildedrose.grader.strategy.ItemGradingStrategy;
import com.gildedrose.grader.strategy.LegendaryItemGradingStrategy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LegendaryItemGradingStrategyTest {
    private final ItemGradingStrategy itemGradingStrategy = new LegendaryItemGradingStrategy();

    @Test
    void legendaryItemsDoNotChangeInQuality() {
        // Given
        final Item item = new Item("Legendary item", 0, 80);

        // When
        itemGradingStrategy.gradeItem(item);

        // Then
        Assertions.assertThat(item.quality).isEqualTo(80);
    }

    @Test
    void legendaryItemsDoNotChangeInQualityEvenWithNegativeSellIn() {
        // Given
        final Item item = new Item("Legendary item", -1, 80);

        // When
        itemGradingStrategy.gradeItem(item);

        // Then
        Assertions.assertThat(item.quality).isEqualTo(80);
    }
}
