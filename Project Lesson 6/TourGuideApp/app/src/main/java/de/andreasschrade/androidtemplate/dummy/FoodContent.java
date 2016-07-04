package de.andreasschrade.androidtemplate.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.andreasschrade.androidtemplate.R;

/**
 * Just Food content. Nothing special.
 *
 * Created by Andreas Schrade on 14.12.2015.
 */
public class FoodContent {

    /**
     * An array of sample items.
     */
    public static final List<FoodItem> ITEMS = new ArrayList<>();

    /**
     * A map of sample items. Key: sample ID; Value: Item.
     */
    public static final Map<String, FoodItem> ITEM_MAP = new HashMap<>(10);

    static {
        addItem(new FoodItem("1", R.drawable.f1, "Rondon", "Spicy coconut soup", ""));
        addItem(new FoodItem("2", R.drawable.f2, "Gallo pinto", "In essence, rice and beans",""));
        addItem(new FoodItem("3", R.drawable.f3, "Casado", "Also, rice and beans, but with a subtle difference.", ""));
        addItem(new FoodItem("4", R.drawable.f4, "Plantains", "Plantains have the same general look as bananas, but are typically cooked",""));
        addItem(new FoodItem("5", R.drawable.f5, "Tres leches cake", "Tres leches cake is for those who have a sweet tooth and want dessert to cap off their meal.",""));
        addItem(new FoodItem("6", R.drawable.f6, "Ceviche", " In Costa Rica it's often prepared with tilapia, cilantro, lime juice, and finely diced vegetables. ",""));
        addItem(new FoodItem("7", R.drawable.f7, "Tamales", "Tamale is a dish made of masa (a starchy corn-based dough) mixed with vegetables, meats and/or cheese, which is steamed or boiled in a banana leaf., Costa Rica ",""));
        addItem(new FoodItem("8", R.drawable.f8, "Chicharrones", "Chicharrónes are essentially deep fried pork rinds, the skin part of the pork, served with lime juice, fried yucca, and/or cabbage salad",""));
        addItem(new FoodItem("9", R.drawable.f9, "Carne Asada", "Carne Asada is Spanish for meat (specifically beef) on a stick.",""));
        addItem(new FoodItem("10", R.drawable.f10, "Rice and Beans", "Also, rice and beans with coconut sauce.",""));
    }

    private static void addItem(FoodItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    public static class FoodItem {
        public final String id;
        public final int photoId;
        public final String title;
        public final String author;
        public final String content;

        public FoodItem(String id, int photoId, String title, String author, String content) {
            this.id = id;
            this.photoId = photoId;
            this.title = title;
            this.author = author;
            this.content = content;
        }
    }
}
