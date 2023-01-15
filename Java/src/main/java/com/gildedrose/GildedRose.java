package com.gildedrose;

import java.util.List;

class GildedRose {
    final Item[] items;
    final ItemClassifier itemClassifier = new ItemClassifier(
        List.of("Sulfuras, Hand of Ragnaros"),
        List.of("Aged Brie")
    );

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (final Item item : items) {
            final ItemClass itemClass = itemClassifier.classifyItem(item);

            // Update sellIn
            if (!ItemClass.LEGENDARY.equals(itemClass)) {
                item.sellIn = item.sellIn - 1;
            }

            // Update quality
            if (ItemClass.COMMON.equals(itemClass) && item.quality > 0) {
                final int degradingModifier = item.sellIn < 0 ? 2 : 1;
                item.quality -= degradingModifier;
            }

            if (ItemClass.BACKSTAGE_PASS.equals(itemClass)) {
                if (item.sellIn < 0) {
                    item.quality = 0;
                } else {
                    if (item.quality < 50) {
                        if (item.sellIn <= 5) {
                            item.quality += 3;
                        } else if (item.sellIn <= 10) {
                            item.quality += 2;
                        } else {
                            item.quality += 1;
                        }
                    }
                }
            }

            if (ItemClass.AGING_CHEESE.equals(itemClass) && item.quality < 50) {
                item.quality += 1;
            }
        }
    }
}
