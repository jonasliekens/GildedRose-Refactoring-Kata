package com.gildedrose;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class GildedRoseTest {

    @Test
    void itemsDegradeTwiceAsFastAfterSellInDate() {
        // Given
        Item[] items = new Item[]{new Item("foo", 0, 10)};
        GildedRose app = new GildedRose(items);

        // When
        app.updateQuality();

        // Then
        Assertions.assertThat(app.items[0]).satisfies(item -> {
            Assertions.assertThat(item.name).isEqualTo("foo");
            Assertions.assertThat(item.quality).isEqualTo(8);
            Assertions.assertThat(item.sellIn).isEqualTo(-1);
        });
    }

    @Test
    void itemsDoNotDegradePastZero() {
        // Given
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        GildedRose app = new GildedRose(items);

        // When
        app.updateQuality();

        // Then
        Assertions.assertThat(app.items[0]).satisfies(item -> {
            Assertions.assertThat(item.name).isEqualTo("foo");
            Assertions.assertThat(item.quality).isEqualTo(0);
            Assertions.assertThat(item.sellIn).isEqualTo(-1);
        });
    }

    @Test
    void itemsDoNotDegradePastZeroEvenWhenDegradingTwiceAsFast() {
        // Given
        Item[] items = new Item[]{new Item("foo", -2, 1)};
        GildedRose app = new GildedRose(items);

        // When
        app.updateQuality();

        // Then
        Assertions.assertThat(app.items[0]).satisfies(item -> {
            Assertions.assertThat(item.name).isEqualTo("foo");
            Assertions.assertThat(item.quality).isEqualTo(0);
            Assertions.assertThat(item.sellIn).isEqualTo(-3);
        });
    }

    @Test
    void itemPerfectlyDegradesToZeroWithQualityTwoAndSellInBelowZero() {
        // Given
        Item[] items = new Item[]{new Item("foo", -2, 2)};
        GildedRose app = new GildedRose(items);

        // When
        app.updateQuality();

        // Then
        Assertions.assertThat(app.items[0]).satisfies(item -> {
            Assertions.assertThat(item.name).isEqualTo("foo");
            Assertions.assertThat(item.quality).isEqualTo(0);
            Assertions.assertThat(item.sellIn).isEqualTo(-3);
        });
    }

    @Test
    void itemPerfectlyDegradesToZeroWithQualityOneAndSellInZero() {
        // Given
        Item[] items = new Item[]{new Item("foo", 0, 1)};
        GildedRose app = new GildedRose(items);

        // When
        app.updateQuality();

        // Then
        Assertions.assertThat(app.items[0]).satisfies(item -> {
            Assertions.assertThat(item.name).isEqualTo("foo");
            Assertions.assertThat(item.quality).isEqualTo(0);
            Assertions.assertThat(item.sellIn).isEqualTo(-1);
        });
    }

    @Test
    void onlyAgedBrieIncreasesInQuality() {
        // Given
        Item[] items = new Item[]{new Item("Aged Brie", 1, 0)};
        GildedRose app = new GildedRose(items);

        // When
        app.updateQuality();

        // Then
        Assertions.assertThat(app.items[0]).satisfies(item -> {
            Assertions.assertThat(item.name).isEqualTo("Aged Brie");
            Assertions.assertThat(item.quality).isEqualTo(1);
            Assertions.assertThat(item.sellIn).isEqualTo(0);
        });
    }

    @Test
    void itemHasMaxQualityOf50() {
        // Given
        Item[] items = new Item[]{new Item("Aged Brie", 1, 50)};
        GildedRose app = new GildedRose(items);

        // When
        app.updateQuality();

        // Then
        Assertions.assertThat(app.items[0]).satisfies(item -> {
            Assertions.assertThat(item.name).isEqualTo("Aged Brie");
            Assertions.assertThat(item.quality).isEqualTo(50);
            Assertions.assertThat(item.sellIn).isEqualTo(0);
        });
    }

    @Test
    void sulfurasDoesNotDegradeInQualityOrSellInValue() {
        // Given
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 10, 80)};
        GildedRose app = new GildedRose(items);

        // When
        app.updateQuality();

        // Then
        Assertions.assertThat(app.items[0]).satisfies(item -> {
            Assertions.assertThat(item.name).isEqualTo("Sulfuras, Hand of Ragnaros");
            Assertions.assertThat(item.quality).isEqualTo(80);
            Assertions.assertThat(item.sellIn).isEqualTo(10);
        });
    }

    @Test
    void backstagePassesIncreaseInValue() {
        // Given
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 15, 25)};
        GildedRose app = new GildedRose(items);

        // When
        app.updateQuality();

        // Then
        Assertions.assertThat(app.items[0]).satisfies(item -> {
            Assertions.assertThat(item.name).isEqualTo("Backstage passes to a TAFKAL80ETC concert");
            Assertions.assertThat(item.quality).isEqualTo(26);
            Assertions.assertThat(item.sellIn).isEqualTo(14);
        });
    }

    @Test
    void backstagePassesIncreaseTwiceAsFastInValue10DaysFromConcert() {
        // Given
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 10, 25)};
        GildedRose app = new GildedRose(items);

        // When
        app.updateQuality();

        // Then
        Assertions.assertThat(app.items[0]).satisfies(item -> {
            Assertions.assertThat(item.name).isEqualTo("Backstage passes to a TAFKAL80ETC concert");
            Assertions.assertThat(item.quality).isEqualTo(27);
            Assertions.assertThat(item.sellIn).isEqualTo(9);
        });
    }

    @Test
    void backstagePassesIncreaseThriceAsFastInValue5DaysFromConcert() {
        // Given
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 5, 25)};
        GildedRose app = new GildedRose(items);

        // When
        app.updateQuality();

        // Then
        Assertions.assertThat(app.items[0]).satisfies(item -> {
            Assertions.assertThat(item.name).isEqualTo("Backstage passes to a TAFKAL80ETC concert");
            Assertions.assertThat(item.quality).isEqualTo(28);
            Assertions.assertThat(item.sellIn).isEqualTo(4);
        });
    }

    @Test
    void backstagePassesHaveZeroQualityAfterConcertDate() {
        // Given
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 0, 25)};
        GildedRose app = new GildedRose(items);

        // When
        app.updateQuality();

        // Then
        Assertions.assertThat(app.items[0]).satisfies(item -> {
            Assertions.assertThat(item.name).isEqualTo("Backstage passes to a TAFKAL80ETC concert");
            Assertions.assertThat(item.quality).isEqualTo(0);
            Assertions.assertThat(item.sellIn).isEqualTo(-1);
        });
    }

    @Test
    void conjuredItemsDegradeTwiceAsFast() {
        // Given
        Item[] items = new Item[]{new Item("Conjured apple cake", 5, 22)};
        GildedRose app = new GildedRose(items);

        // When
        app.updateQuality();

        // Then
        Assertions.assertThat(app.items[0]).satisfies(item -> {
            Assertions.assertThat(item.name).isEqualTo("Conjured apple cake");
            Assertions.assertThat(item.quality).isEqualTo(20);
            Assertions.assertThat(item.sellIn).isEqualTo(4);
        });
    }

    @Test
    void conjuredItemsDegradeTwiceAsFastAfterSellInPassedBy() {
        // Given
        Item[] items = new Item[]{new Item("Conjured apple cake", -1, 22)};
        GildedRose app = new GildedRose(items);

        // When
        app.updateQuality();

        // Then
        Assertions.assertThat(app.items[0]).satisfies(item -> {
            Assertions.assertThat(item.name).isEqualTo("Conjured apple cake");
            Assertions.assertThat(item.quality).isEqualTo(18);
            Assertions.assertThat(item.sellIn).isEqualTo(-2);
        });
    }
}
