package com.gildedrose;

import java.util.List;

public class ItemClassifier {
    final List<String> legendaryItemNames;
    final List<String> agingCheeseNames;

    public ItemClassifier(List<String> legendaryItemNames, List<String> agingCheeseNames) {
        this.legendaryItemNames = legendaryItemNames;
        this.agingCheeseNames = agingCheeseNames;
    }

    public ItemClass classifyItem(Item item) {
        if (isLegendaryItem(item.name)) {
            return ItemClass.LEGENDARY;
        }

        if (isAgingCheese(item.name)) {
            return ItemClass.AGING_CHEESE;
        }

        if (isBackstagePass(item.name)) {
            return ItemClass.BACKSTAGE_PASS;
        }

        if (isConjuredItem(item.name)) {
            return ItemClass.CONJURED;
        }

        return ItemClass.COMMON;
    }

    private boolean isAgingCheese(String itemName) {
        return agingCheeseNames.contains(itemName);
    }

    private boolean isLegendaryItem(String itemName) {
        return legendaryItemNames.contains(itemName);
    }

    private boolean isBackstagePass(String itemName) {
        return itemName.toLowerCase().contains("backstage pass");
    }

    private boolean isConjuredItem(String itemName) {
        return itemName.toLowerCase().contains("conjured");
    }
}
