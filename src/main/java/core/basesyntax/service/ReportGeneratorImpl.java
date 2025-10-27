package core.basesyntax.service;

import core.basesyntax.storage.FruitStorage;
import java.util.Map;
import java.util.StringJoiner;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public String getReport() {
        StringJoiner reportBuilder = new StringJoiner(System.lineSeparator());
        reportBuilder.add("fruit,quantity");

        for (Map.Entry<String, Integer> entry : FruitStorage.storage.entrySet()) {
            String line = entry.getKey() + "," + entry.getValue();
            reportBuilder.add(line);
        }
        return reportBuilder.toString();
    }
}
