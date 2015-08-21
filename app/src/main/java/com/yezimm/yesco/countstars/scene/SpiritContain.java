package com.yezimm.yesco.countstars.scene;

import com.yezimm.yesco.countstars.spirit.Spirit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yesco on 2015/8/21.
 */
public class SpiritContain {

    private List<Spirit> spirits = new ArrayList<>();

    private static class SpiritContainHolder {
        static final SpiritContain INSTANCE = new SpiritContain() ;
    }

    public static SpiritContain getInstance() {
        return SpiritContainHolder.INSTANCE ;
    }

    /**
     * Adds the specified spirit at the end of sort by priority {@code List}.
     *
     * @param spirit
     *            the object to add.
     * @return always true.
     * @throws UnsupportedOperationException
     *                if adding to this {@code List} is not supported.
     * @throws ClassCastException
     *                if the class of the object is inappropriate for this
     *                {@code List}.
     * @throws IllegalArgumentException
     *                if the object cannot be added to this {@code List}.
     */
    public void addSpirit(Spirit spirit) {
        if (spirits.size() == 0) {
            spirits.add(spirit);
        } else {
            for (int i = 0; i < spirits.size(); i++) {
                if (spirit.getPriority() > spirits.get(i).getPriority()) {
                    spirits.add(i, spirit);
                }
            }
        }
    }

    /**
     * Removes the first occurrence of the specified object from this {@code List}.
     *
     * @param spirit
     *            the spirit to remove.
     * @return true if this {@code List} was modified by this operation, false
     *         otherwise.
     * @throws UnsupportedOperationException
     *                if removing from this {@code List} is not supported.
     */
    public boolean removeSpirit(Spirit spirit) {
        if (spirits != null && spirits.size() > 0) {
            return spirits.remove(spirit);
        } else {
            return true;
        }
    }

    public List<Spirit> getSpirits() {
        return spirits;
    }

    public Spirit getSpiritsByPosition(int position) {
        return spirits.get(position);
    }
}
