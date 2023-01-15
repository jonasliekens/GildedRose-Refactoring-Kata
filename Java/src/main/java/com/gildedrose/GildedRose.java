package com.gildedrose;

import com.gildedrose.classifier.ItemClass;
import com.gildedrose.classifier.ItemClassifier;
import com.gildedrose.grader.AgingCheeseItemGradingStrategy;
import com.gildedrose.grader.BackstagePassItemGradingStrategy;
import com.gildedrose.grader.CommonItemGradingStrategy;
import com.gildedrose.grader.ConjuredItemGradingStrategy;

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
            if (ItemClass.COMMON.equals(itemClass)) {
                new CommonItemGradingStrategy().gradeItem(item);
            }

            if (ItemClass.BACKSTAGE_PASS.equals(itemClass)) {
                new BackstagePassItemGradingStrategy().gradeItem(item);
            }

            if (ItemClass.AGING_CHEESE.equals(itemClass)) {
                new AgingCheeseItemGradingStrategy().gradeItem(item);
            }

            if (ItemClass.CONJURED.equals(itemClass)) {
                new ConjuredItemGradingStrategy().gradeItem(item);
            }
        });
    }
}
