package com.hippouches.inventory;

public class HipPouchInventory {
    
    public static final int BASE_ROWS = 4;
    public static final int SLOTS_PER_ROW = 9;
    public static final int SLOTS_PER_POUCH = 3;

    private final int pouchCount;

    public HipPouchInventory(int pouchCount)
    {
        this.pouchCount = Math.max(0, pouchCount);
    }

    public int getExtraSlots()
    {
        return pouchCount * SLOTS_PER_POUCH;
    }

    public int getTotalSlots()
    {
        return getBaseSlots() + getExtraSlots();
    }

    public int getBaseSlots()
    {
        return BASE_ROWS * SLOTS_PER_ROW;
    }

    public int getTotalRows()
    {
        int extraRows = (int) Math.ceil(getExtraSlots() / (double) SLOTS_PER_ROW);
        return BASE_ROWS + extraRows;
    }

    public boolean isPouchSlot(int slotIndex)
    {
        return slotIndex < getExtraSlots();
    }
}

