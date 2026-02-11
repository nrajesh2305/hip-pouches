package com.hippouches.data;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class HipPouchManager {
    
    public static final int MAX_POUCHES = 6;
    public static final int SLOTS_PER_POUCH = 3;

    private final Map<UUID, Integer> pouchCounts = new HashMap<>();

    public int getPouchCount(UUID playerId) {
        return pouchCounts.getOrDefault(playerId, 0);
    }

    public boolean canAddPouch(UUID playerId) {
        return getPouchCount(playerId) < MAX_POUCHES;
    }

    public boolean addPouch(UUID playerID)
    {
        if(!canAddPouch(playerID))
        {
            return false;
        }
        pouchCounts.put(playerID, getPouchCount(playerID) + 1);
        return true;
    }

    public int getExtraSlots(UUID playerId) {
        return getPouchCount(playerId) * SLOTS_PER_POUCH;
    }
}
