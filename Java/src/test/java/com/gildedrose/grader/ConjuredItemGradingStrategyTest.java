package com.gildedrose.grader;

import com.gildedrose.Item;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ConjuredItemGradingStrategyTest {
    private final ItemGradingStrategy itemGradingStrategy = new ConjuredItemGradingStrategy();

    @Test
    void conjuredItemDegradesByTwo() {
        // Given
        final Item item = new Item("conjured item", 1, 10);

        // When
        itemGradingStrategy.gradeItem(item);

        // Then
        Assertions.assertThat(item.quality).isEqualTo(8);
    }

    @Test
    void conjuredItemDegradesByFourWhenSellInLesserThanZero() {
        // Given
        final Item item = new Item("conjured item", -1, 10);

        // When
        itemGradingStrategy.gradeItem(item);

        // Then
        Assertions.assertThat(item.quality).isEqualTo(6);
    }

    @Test
    void conjuredItemDegradesByTwoWhenSellInIsZero() {
        // Given
        final Item item = new Item("conjured item", 0, 1);

        // When
        itemGradingStrategy.gradeItem(item);

        // Then
        Assertions.assertThat(item.quality).isEqualTo(0);
    }

    @Test
    void conjuredItemDegradesToExactlyZeroWithSellInLesserThanZero() {
        // Given
        final Item item = new Item("conjured item", -1, 2);

        // When
        itemGradingStrategy.gradeItem(item);

        // Then
        Assertions.assertThat(item.quality).isEqualTo(0);
    }

    @Test
    void conjuredItemNeverDegradesBelowZeroWithSellInAboveZero() {
        // Given
        final Item item = new Item("conjured item", 1, 0);

        // When
        itemGradingStrategy.gradeItem(item);

        // Then
        Assertions.assertThat(item.quality).isEqualTo(0);
    }

    @Test
    void conjuredItemNeverDegradesBelowZeroWithSellInBelowZero() {
        // Given
        final Item item = new Item("conjured item", -1, 1);

        // When
        itemGradingStrategy.gradeItem(item);

        // Then
        Assertions.assertThat(item.quality).isEqualTo(0);
    }

}
