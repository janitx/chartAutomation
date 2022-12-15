package io;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import model.TooltipModel;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvToJavaReader {
    public static List<TooltipModel> read(String path) {

        List<TooltipModel> result = null;

        try {
            File csvFile = new File(path);
            CsvMapper csvMapper = new CsvMapper();

            CsvSchema csvSchema = csvMapper
                    .typedSchemaFor(TooltipModel.class)
                    .withColumnSeparator(',');

            MappingIterator<TooltipModel> tooltip = csvMapper
                    .readerWithTypedSchemaFor(TooltipModel.class)
                    .with(csvSchema)
                    .readValues(csvFile);

            List<TooltipModel> toolTips = tooltip.readAll();
            result = new ArrayList<>();

            for (int i = 1; i < toolTips.size(); i++) {
                result.add(toolTips.get(i));
            }
        } catch (IOException e) {
            System.err.format("%s%n", e);
        }
        return result;
    }
}