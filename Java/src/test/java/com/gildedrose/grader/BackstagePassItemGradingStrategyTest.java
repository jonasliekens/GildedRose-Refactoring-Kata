package com.gildedrose.grader;

import com.gildedrose.Item;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class BackstagePassItemGradingStrategyTest {
    private final ItemGradingStrategy itemGradingStrategy = new BackstagePassItemGradingStrategy();

    @Test
    void backstagePassLosesValueAfterConcert() {
        // Given
        final Item item = new Item("Alestorm Backstage Pass", -1, 10);

        // When
        itemGradingStrategy.gradeItem(item);

        // Then
        Assertions.assertThat(item.quality).isEqualTo(0);
    }

    @Test
    void backstagePassIncreasesInValue() {
        // Given
        final Item item = new Item("Alestorm Backstage Pass", 15, 10);

        // When
        itemGradingStrategy.gradeItem(item);

        // Then
        Assertions.assertThat(item.quality).isEqualTo(11);
    }

    @Test
    void backstagePassValueIncreasesByTwoTenDaysFromConcert() {
        // Given
        final Item item = new Item("Alestorm Backstage Pass", 10, 10);

        // When
        itemGradingStrategy.gradeItem(item);

        // Then
        Assertions.assertThat(item.quality).isEqualTo(12);
    }

    @Test
    void backstagePassValueIncreasesByThreeFiveDaysFromConcert() {
        // Given
        final Item item = new Item("Alestorm Backstage Pass", 5, 11);

        // When
        itemGradingStrategy.gradeItem(item);

        // Then
        Assertions.assertThat(item.quality).isEqualTo(14);
    }

    @Test
    void backstagePassValueNeverIncreasesAboveFifty() {
        // Given
        final Item item = new Item("Alestorm Backstage Pass", 15, 50);

        // When
        itemGradingStrategy.gradeItem(item);

        // Then
        Assertions.assertThat(item.quality).isEqualTo(50);
    }

    @Test
    void backstagePassValueNeverIncreasesAboveFiftyEvenTenDaysFromConcert() {
        // Given
        final Item item = new Item("Alestorm Backstage Pass", 10, 50);

        // When
        itemGradingStrategy.gradeItem(item);

        // Then
        Assertions.assertThat(item.quality).isEqualTo(50);
    }

    @Test
    void backstagePassValueNeverIncreasesAboveFiftyEvenFiveDaysFromConcert() {
        // Given
        final Item item = new Item("Alestorm Backstage Pass", 5, 50);

        // When
        itemGradingStrategy.gradeItem(item);

        // Then
        Assertions.assertThat(item.quality).isEqualTo(50);
    }
}
