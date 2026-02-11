package com.hippouches.commands;

import com.hippouches.data.HipPouchManager;
import com.hippouches.inventory.player.PlayerInventoryManager;

import java.util.UUID;

public class HipPouchCommand {

    private final HipPouchManager pouchManager;
    private final PlayerInventoryManager inventoryManager;

    public HipPouchCommand(
            HipPouchManager pouchManager,
            PlayerInventoryManager inventoryManager
    ) {
        this.pouchManager = pouchManager;
        this.inventoryManager = inventoryManager;
    }

    // TEMP test method (Phase 4.1)
    public void executeTest(UUID playerId) {
        boolean added = pouchManager.addPouch(playerId);
        inventoryManager.refreshInventory(playerId);

        System.out.println("[HipPouches] Command test → added=" + added);
    }
}
