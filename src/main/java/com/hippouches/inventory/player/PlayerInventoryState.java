package com.hippouches.inventory.player;

import com.hippouches.data.HipPouchManager;
import com.hippouches.inventory.HipPouchInventory;

import java.util.UUID;

public class PlayerInventoryState {

    private final UUID playerId;
    private final HipPouchManager pouchManager;
    private final HipPouchInventory inventory;

    public PlayerInventoryState(UUID playerId, HipPouchManager pouchManager) {
        this.playerId = playerId;
        this.pouchManager = pouchManager;
        this.inventory = new HipPouchInventory(pouchManager);
    }

    public UUID getPlayerId() {
        return playerId;
    }

    public HipPouchInventory getInventory() {
        return inventory;
    }

    public int getPouchCount() {
        return pouchManager.getPouchCount(playerId);
    }

    public int getExtraSlots() {
        return inventory.getExtraSlots(playerId);
    }

    public int getTotalRows() {
        return inventory.getTotalRows(playerId);
    }
}
