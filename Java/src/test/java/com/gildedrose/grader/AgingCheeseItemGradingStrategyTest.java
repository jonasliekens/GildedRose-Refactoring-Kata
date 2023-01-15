package com.gildedrose.grader;

import com.gildedrose.Item;
import com.gildedrose.grader.strategy.AgingCheeseItemGradingStrategy;
import com.gildedrose.grader.strategy.ItemGradingStrategy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class AgingCheeseItemGradingStrategyTest {
    final ItemGradingStrategy itemGradingStrategy = new AgingCheeseItemGradingStrategy();

    @Test
    void agingCheeseIncreasesInQuality() {
        // Given
        final Item item = new Item("Blue chiieeeuuuwws", 5, 1);

        // When
        itemGradingStrategy.gradeItem(item);

        // Then
        Assertions.assertThat(item.quality).isEqualTo(2);
    }

    @Test
    void agingCheeseIncreasesTwiceInQualityWithNegativeSellIn() {
        // Given
        final Item item = new Item("Blue chiieeeuuuwws", -1, 1);

        // When
        itemGradingStrategy.gradeItem(item);

        // Then
        Assertions.assertThat(item.quality).isEqualTo(3);
    }

    @Test
    void agingCheeseQualityCanNeverExceedFifty() {
        // Given
        final Item item = new Item("Blue chiieeeuuuwws", 0, 50);

        // When
        itemGradingStrategy.gradeItem(item);

        // Then
        Assertions.assertThat(item.quality).isEqualTo(50);
    }

    @Test
    void agingCheeseQualityCanNeverExceedFiftyWithNegativeSellIn() {
        // Given
        final Item item = new Item("Blue chiieeeuuuwws", -1, 50);

        // When
        itemGradingStrategy.gradeItem(item);

        // Then
        Assertions.assertThat(item.quality).isEqualTo(50);
    }

    @Test
    void agingCheeseQualityCanNeverExceedFiftyWithPositiveSellIn() {
        // Given
        final Item item = new Item("Blue chiieeeuuuwws", 1, 50);

        // When
        itemGradingStrategy.gradeItem(item);

        // Then
        Assertions.assertThat(item.quality).isEqualTo(50);
    }
}
