package com.hippouches;

import com.hippouches.data.HipPouchManager;
import com.hippouches.inventory.player.PlayerInventoryManager;
import com.hippouches.triggers.HipPouchService;
import com.hippouches.triggers.HipPouchTrigger;

import java.util.UUID;

public class HipPouchesPlugin {

    private final HipPouchManager pouchManager;
    private final PlayerInventoryManager inventoryManager;
    private final HipPouchTrigger pouchTrigger;

    public HipPouchesPlugin() {
        System.out.println("[HipPouches] Plugin loaded");

        this.pouchManager = new HipPouchManager();
        this.inventoryManager = new PlayerInventoryManager(pouchManager);
        this.pouchTrigger = new HipPouchService(pouchManager);

        // 🔹 TEMP test player
        UUID fakePlayerId = UUID.randomUUID();

        System.out.println("[HipPouches] Triggering pouch grant...");
        boolean granted = pouchTrigger.trigger(fakePlayerId);

        inventoryManager.refreshInventory(fakePlayerId);

        System.out.println("[HipPouches] Granted: " + granted);
        System.out.println("[HipPouches] Pouch count: " + pouchManager.getPouchCount(fakePlayerId));
    }
}
