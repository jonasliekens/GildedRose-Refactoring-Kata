package com.gildedrose;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class ItemClassifierTest {
    private final ItemClassifier itemClassifier = new ItemClassifier(
        List.of(
            "Sulfuras, Hand of Ragnaros",
            "Hooky, Hand of Captain Jay"
        ),
        List.of(
            "Aged Brie",
            "Camembert"
        )
    );

    @Test
    void correctlyClassifiesLegendaryItems() {
        // Given
        final Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", 10, 80);

        // When
        final ItemClass itemClass = itemClassifier.classifyItem(sulfuras);

        // Then
        Assertions.assertThat(itemClass).isEqualTo(ItemClass.LEGENDARY);
    }

    @Test
    void correctlyClassifiesCommonItems() {
        // Given
        final Item item = new Item("Goblin dagger", 10, 10);

        // When
        final ItemClass itemClass = itemClassifier.classifyItem(item);

        // Then
        Assertions.assertThat(itemClass).isEqualTo(ItemClass.COMMON);
    }

    @Test
    void correctlyClassifiesAgingCheeses() {
        // Given
        final Item item = new Item("Aged Brie", 10, 40);

        // When
        final ItemClass itemClass = itemClassifier.classifyItem(item);

        // Then
        Assertions.assertThat(itemClass).isEqualTo(ItemClass.AGING_CHEESE);
    }

    @Test
    void correctlyClassifiesBackstagePasses() {
        // Given
        final Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 40);

        // When
        final ItemClass itemClass = itemClassifier.classifyItem(item);

        // Then
        Assertions.assertThat(itemClass).isEqualTo(ItemClass.BACKSTAGE_PASS);
    }

    @Test
    void correctlyClassifiesConjuredItems() {
        // Given
        final Item item = new Item("Conjured waifu", 10, 40);

        // When
        final ItemClass itemClass = itemClassifier.classifyItem(item);

        // Then
        Assertions.assertThat(itemClass).isEqualTo(ItemClass.CONJURED);
    }
}
