package com.gildedrose.grader;

import com.gildedrose.Item;
import com.gildedrose.classifier.ItemClass;
import com.gildedrose.grader.strategy.*;

import java.util.Map;
import java.util.Optional;

public class ItemGrader {
    private final Map<ItemClass, ItemGradingStrategy> itemGradingStrategies;
    private final ItemGradingStrategy defaultGradingStrategy = new CommonItemGradingStrategy();

    public ItemGrader() {
        itemGradingStrategies = Map.of(
            ItemClass.CONJURED, new ConjuredItemGradingStrategy(),
            ItemClass.AGING_CHEESE, new AgingCheeseItemGradingStrategy(),
            ItemClass.BACKSTAGE_PASS, new BackstagePassItemGradingStrategy(),
            ItemClass.LEGENDARY, new LegendaryItemGradingStrategy()
        );
    }

    public void gradeItem(ItemClass itemClass, Item item) {
        final ItemGradingStrategy itemGradingStrategy = Optional.ofNullable(itemGradingStrategies.get(itemClass)).orElse(defaultGradingStrategy);
        itemGradingStrategy.gradeItem(item);
    }
}
