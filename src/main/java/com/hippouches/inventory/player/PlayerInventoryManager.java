package com.hippouches.inventory.player;

import com.hippouches.data.HipPouchManager;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PlayerInventoryManager {
    
    private final HipPouchManager pouchManager;
    private final Map<UUID, PlayerInventoryState> inventoryStates = new HashMap<>();

    public PlayerInventoryManager(HipPouchManager pouchManager)
    {
        this.pouchManager = pouchManager;
    }

    public PlayerInventoryState getInventoryState(UUID playerId)
    {
        return inventoryStates.computeIfAbsent(playerId, id -> 
        {
            int pouchCount = pouchManager.getPouchCount(id);
            return new PlayerInventoryState(id, pouchCount);
        });
    }

    public void refreshInventory(UUID playerId)
    {
        int pouchCount = pouchManager.getPouchCount(playerId);
        inventoryStates.put(playerId, new PlayerInventoryState(playerId, pouchCount));

    }

    public void removePlayer(UUID playerId)
    {
        inventoryStates.remove(playerId);
    }

}
