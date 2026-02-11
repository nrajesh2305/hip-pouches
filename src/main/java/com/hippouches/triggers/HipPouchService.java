package com.hippouches.triggers;

import com.hippouches.data.HipPouchManager;

import java.util.UUID;

public class HipPouchService implements HipPouchTrigger {

    private final HipPouchManager pouchManager;

    public HipPouchService(HipPouchManager pouchManager) {
        this.pouchManager = pouchManager;
    }

    @Override
    public boolean trigger(UUID playerId) {
        return pouchManager.addPouch(playerId);
    }

    // Friendly semantic alias
    public boolean grantPouch(UUID playerId) {
        return trigger(playerId);
    }
}
