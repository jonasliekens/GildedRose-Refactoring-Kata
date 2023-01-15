package com.gildedrose.grader;

import com.gildedrose.Item;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CommonItemGradingStrategyTest {
    private final ItemGradingStrategy itemGradingStrategy = new CommonItemGradingStrategy();

    @Test
    void commonItemDegradesByOne() {
        // Given
        final Item item = new Item("some item", 1, 10);

        // When
        itemGradingStrategy.gradeItem(item);

        // Then
        Assertions.assertThat(item.quality).isEqualTo(9);
    }

    @Test
    void commonItemDegradesByTwoWhenSellInLesserThanZero() {
        // Given
        final Item item = new Item("some item", -1, 10);

        // When
        itemGradingStrategy.gradeItem(item);

        // Then
        Assertions.assertThat(item.quality).isEqualTo(8);
    }

    @Test
    void commonItemDegradesByOneWhenSellInIsZero() {
        // Given
        final Item item = new Item("some item", 0, 1);

        // When
        itemGradingStrategy.gradeItem(item);

        // Then
        Assertions.assertThat(item.quality).isEqualTo(0);
    }

    @Test
    void commonItemDegradesToExactlyZeroWithSellInLesserThanZero() {
        // Given
        final Item item = new Item("some item", -1, 2);

        // When
        itemGradingStrategy.gradeItem(item);

        // Then
        Assertions.assertThat(item.quality).isEqualTo(0);
    }

    @Test
    void commonItemNeverDegradesBelowZeroWithSellInAboveZero() {
        // Given
        final Item item = new Item("some item", 1, 0);

        // When
        itemGradingStrategy.gradeItem(item);

        // Then
        Assertions.assertThat(item.quality).isEqualTo(0);
    }

    @Test
    void commonItemNeverDegradesBelowZeroWithSellInBelowZero() {
        // Given
        final Item item = new Item("some item", -1, 1);

        // When
        itemGradingStrategy.gradeItem(item);

        // Then
        Assertions.assertThat(item.quality).isEqualTo(0);
    }
}
