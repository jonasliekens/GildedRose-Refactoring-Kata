package com.gildedrose;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class GildedRoseIT {

    @Test
    void appCorrectlyGradesItems() {
        // Given
        Item[] items = new Item[] {
            new Item("+5 Dexterity Vest", 10, 20),
            new Item("Aged Brie", 2, 0),
            new Item("Elixir of the Mongoose", 5, 7),
            new Item("Sulfuras, Hand of Ragnaros", 0, 80),
            new Item("Sulfuras, Hand of Ragnaros", -1, 80),
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
            new Item("Conjured Mana Cake", 3, 6)
        };
        GildedRose app = new GildedRose(items);

        // When
        for (int daysCounter = 0 ; daysCounter < 5 ; daysCounter ++ ) {
           app.updateQuality();
        }

        // Then
        final List<String> stringifiedItems = Arrays.stream(items).map(Item::toString).toList();
        Assertions.assertThat(stringifiedItems).containsExactlyInAnyOrder(
            "+5 Dexterity Vest, 5, 15",
            "Aged Brie, -3, 5",
            "Elixir of the Mongoose, 0, 2",
            "Sulfuras, Hand of Ragnaros, 0, 80",
            "Sulfuras, Hand of Ragnaros, -1, 80",
            "Backstage passes to a TAFKAL80ETC concert, 10, 25",
            "Backstage passes to a TAFKAL80ETC concert, 5, 50",
            "Backstage passes to a TAFKAL80ETC concert, 0, 50",
            "Conjured Mana Cake, -2, 0"
        );
    }
}
