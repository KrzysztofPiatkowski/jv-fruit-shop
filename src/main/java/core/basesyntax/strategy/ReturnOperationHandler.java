package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.storage.FruitStorage;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int quantity = transaction.getQuantity();

        int currentQuantity = FruitStorage.storage.getOrDefault(fruit, 0);
        FruitStorage.storage.put(fruit, currentQuantity + quantity);
    }
}
