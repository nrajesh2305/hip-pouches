package com.hippouches.inventory;

import com.hippouches.data.HipPouchManager;

import java.util.UUID;

public class HipPouchInventory {

    public static final int BASE_ROWS = 4;
    public static final int SLOTS_PER_ROW = 9;
    public static final int SLOTS_PER_POUCH = 3;

    private final HipPouchManager pouchManager;

    public HipPouchInventory(HipPouchManager pouchManager) {
        this.pouchManager = pouchManager;
    }

    public int getBaseSlots() {
        return BASE_ROWS * SLOTS_PER_ROW;
    }

    public int getExtraSlots(UUID playerId) {
        int pouchCount = pouchManager.getPouchCount(playerId);
        return pouchCount * SLOTS_PER_POUCH;
    }

    public int getTotalSlots(UUID playerId) {
        return getBaseSlots() + getExtraSlots(playerId);
    }

    public int getTotalRows(UUID playerId) {
        return getTotalSlots(playerId) / SLOTS_PER_ROW;
    }
}
