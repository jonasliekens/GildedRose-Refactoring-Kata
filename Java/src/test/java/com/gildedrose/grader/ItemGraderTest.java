package com.gildedrose.grader;

import com.gildedrose.Item;
import com.gildedrose.classifier.ItemClass;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ItemGraderTest {
    final ItemGrader itemGrader = new ItemGrader();

    @Test
    void itemGraderGradesCommonItems() {
        // Given
        final Item item = new Item("name", 0, 10);

        // When
        itemGrader.gradeItem(ItemClass.COMMON, item);

        // Then
        Assertions.assertThat(item.quality).isEqualTo(8);
    }

    @Test
    void itemGraderGradesConjuredItems() {
        // Given
        final Item item = new Item("name", 0, 10);

        // When
        itemGrader.gradeItem(ItemClass.CONJURED, item);

        // Then
        Assertions.assertThat(item.quality).isEqualTo(6);
    }

    @Test
    void itemGraderGradesBackstagePassItems() {
        // Given
        final Item item = new Item("name", 0, 10);

        // When
        itemGrader.gradeItem(ItemClass.BACKSTAGE_PASS, item);

        // Then
        Assertions.assertThat(item.quality).isEqualTo(0);
    }

    @Test
    void itemGraderGradesAgingCheeseItems() {
        // Given
        final Item item = new Item("name", 0, 10);

        // When
        itemGrader.gradeItem(ItemClass.AGING_CHEESE, item);

        // Then
        Assertions.assertThat(item.quality).isEqualTo(12);
    }

    @Test
    void itemGraderGradesLegendaryItems() {
        // Given
        final Item item = new Item("name", 0, 10);

        // When
        itemGrader.gradeItem(ItemClass.LEGENDARY, item);

        // Then
        Assertions.assertThat(item.quality).isEqualTo(10);
    }
}
