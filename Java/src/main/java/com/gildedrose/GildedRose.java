package com.gildedrose;

import com.gildedrose.classifier.ItemClass;
import com.gildedrose.classifier.ItemClassifier;
import com.gildedrose.grader.*;

import java.util.Arrays;
import java.util.List;

class GildedRose {
    final Item[] items;
    final List<String> legendaryItemNames = List.of("Sulfuras, Hand of Ragnaros");
    final List<String> agingCheeseNames = List.of("Aged Brie");
    final ItemClassifier itemClassifier = new ItemClassifier(
        legendaryItemNames,
        agingCheeseNames
    );
    final ItemGrader itemGrader = new ItemGrader();

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        Arrays.stream(items).forEach(item -> {
            final ItemClass itemClass = itemClassifier.classifyItem(item);

            // Update sellIn
            if (!ItemClass.LEGENDARY.equals(itemClass)) {
                item.sellIn = item.sellIn - 1;
            }

            // Update quality
            itemGrader.gradeItem(itemClass, item);
        });
    }
}
