package de.andreasschrade.androidtemplate.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.andreasschrade.androidtemplate.R;

/**
 * Just Hotel content. Nothing special.
 *
 * Created by Andreas Schrade on 14.12.2015.
 */
public class HotelContent {

    /**
     * An array of sample items.
     */
    public static final List<HotelItem> ITEMS = new ArrayList<>();

    /**
     * A map of sample items. Key: sample ID; Value: Item.
     */
    public static final Map<String, HotelItem> ITEM_MAP = new HashMap<>(10);

    static {
        addItem(new HotelItem("1", R.drawable.h1, "Nayara Hotel, Spa & Gardens", "La Fortuna de San Carlos, Costa Rica ", ""));
        addItem(new HotelItem("2", R.drawable.h2, "Buena Vista Luxury Villas", "Manuel Antonio National Park, Costa Rica",""));
        addItem(new HotelItem("3", R.drawable.h3, "Arenas del Mar Beachfront and Rainforest Resort", "Manuel Antonio National Park, Costa Rica", ""));
        addItem(new HotelItem("4", R.drawable.h4, "Villa Blanca Cloud Forest Hotel and Nature Reserve ", "San Ramon, Costa Rica",""));
        addItem(new HotelItem("5", R.drawable.h5, "Hotel Capitan Suizo", "Tamarindo, Costa Rica",""));
        addItem(new HotelItem("6", R.drawable.h6, "The Springs Resort and Spa ", "Arenal Volcano National Park, Costa Rica ",""));
        addItem(new HotelItem("7", R.drawable.h7, "Hotel Bougainvillea ", "Santo Domingo de Heredia, Costa Rica ",""));
        addItem(new HotelItem("8", R.drawable.h8, "Hotel Grano de Oro San Jose", "San Jose, Costa Rica ",""));
        addItem(new HotelItem("9", R.drawable.h9, "Cala Luna Luxury Boutique Hotel & Villas ", "Tamarindo, Costa Rica ",""));
        addItem(new HotelItem("10", R.drawable.h10, "Hotel Punta Islita, Autograph Collection ", "Punta Islita, Costa Rica ",""));
    }

    private static void addItem(HotelItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    public static class HotelItem {
        public final String id;
        public final int photoId;
        public final String title;
        public final String author;
        public final String content;

        public HotelItem(String id, int photoId, String title, String author, String content) {
            this.id = id;
            this.photoId = photoId;
            this.title = title;
            this.author = author;
            this.content = content;
        }
    }
}
