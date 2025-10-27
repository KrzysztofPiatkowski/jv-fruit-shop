package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> lines) {
        List<FruitTransaction> transactions = new ArrayList<>();

        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] parts = line.split(",");

            if (parts.length != 3) {
                throw new IllegalArgumentException("Line: " + line + " of this file is invalid");
            }

            String operationType = parts[0].trim();
            String fruit = parts[1].trim();
            int quantity = Integer.parseInt(parts[2].trim());

            FruitTransaction.Operation operation = FruitTransaction
                    .Operation
                    .fromCode(operationType);

            FruitTransaction transaction = new FruitTransaction(operation, fruit, quantity);
            transactions.add(transaction);
        }
        return transactions;
    }
}
