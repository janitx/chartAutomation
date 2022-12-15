package converter;

import model.TooltipModel;

import java.util.ArrayList;
import java.util.List;

public class CollectionToString {

    public static ArrayList<String> convert(List<TooltipModel> models) {

        ArrayList<String> strings = new ArrayList<>();

        for (TooltipModel model : models) {

            strings.add(model.asString());
        }

        return strings;
    }
}
