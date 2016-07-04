package de.andreasschrade.androidtemplate.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.andreasschrade.androidtemplate.R;

/**
 * Just dummy content. Nothing special.
 *
 * Created by Andreas Schrade on 14.12.2015.
 */
public class PlacesContent {

    /**
     * An array of sample items.
     */
    public static final List<PlaceItem> ITEMS = new ArrayList<>();

    /**
     * A map of sample items. Key: sample ID; Value: Item.
     */
    public static final Map<String, PlaceItem> ITEM_MAP = new HashMap<>(9);

    static {
        addItem(new PlaceItem("1", R.drawable.p1, "Monteverde  and Santa Elena", "Puntarenas, Costa Rica", ""));
        addItem(new PlaceItem("2", R.drawable.p2, "Volcan Arenal", "San Carlos, Costa Rica",""));
        addItem(new PlaceItem("3", R.drawable.p3, "Parque Nacional Manuel Antonio", "Manuel Antonio, Costa Rica", ""));
        addItem(new PlaceItem("4", R.drawable.p4, "Puerto Viejo", "Limon, Costa Rica",""));
        addItem(new PlaceItem("6", R.drawable.p5, "Parque Nacional Tortuguero", "Tortuguero, Costa Rica",""));
        addItem(new PlaceItem("7", R.drawable.p6, "Mal Pais y Santa Teresa", "Peninsula de Nicoya, Costa Rica",""));
        addItem(new PlaceItem("8", R.drawable.p7, "Central Valley thrills", "Turrialba, Costa Rica",""));
        addItem(new PlaceItem("9", R.drawable.p8, "Playa Samara", "Guanacaste, Costa Rica",""));
        addItem(new PlaceItem("10", R.drawable.p9, "Montezuma", "Peninsula de Nicoya, Costa Rica",""));
    }

    private static void addItem(PlaceItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    public static class PlaceItem {
        public final String id;
        public final int photoId;
        public final String title;
        public final String author;
        public final String content;

        public PlaceItem(String id, int photoId, String title, String author, String content) {
            this.id = id;
            this.photoId = photoId;
            this.title = title;
            this.author = author;
            this.content = content;
        }
    }
}
