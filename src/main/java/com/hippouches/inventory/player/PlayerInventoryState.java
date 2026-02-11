package com.hippouches.inventory.player;

import com.hippouches.inventory.HipPouchInventory;

import java.util.UUID;

public class PlayerInventoryState {
    
    private final UUID playerId;
    private final HipPouchInventory inventory;

    public PlayerInventoryState(UUID playerId, int pouchCount)
    {
        this.playerId = playerId;
        this.inventory = new HipPouchInventory(pouchCount);
    }

    public UUID getPlayerId()
    {
        return playerId;
    }

    public HipPouchInventory getInventory()
    {
        return inventory;
    }
}
