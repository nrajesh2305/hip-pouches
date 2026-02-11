package com.hippouches;

import com.hippouches.data.HipPouchManager;
import java.util.UUID;

public class HipPouchesPlugin {
    
    private final HipPouchManager pouchManager = new HipPouchManager();

    public HipPouchesPlugin()
    {
        System.out.println("HipPouchesPlugin Plugin loaded.");
    
        UUID fakePlayerID = UUID.randomUUID();

        boolean added = pouchManager.addPouch(fakePlayerID);

        System.out.println("Added pouch: " + added);
        System.out.println("Total pouches: " + pouchManager.getPouchCount(fakePlayerID));
        System.out.println("Extra slots: " + pouchManager.getExtraSlots(fakePlayerID));
    }
}
