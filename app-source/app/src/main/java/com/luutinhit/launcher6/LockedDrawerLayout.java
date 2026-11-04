package com.luutinhit.launcher6;

import android.content.Context;
import android.util.AttributeSet;
import androidx.drawerlayout.widget.DrawerLayout;

/**
 * The sliding menu of the settings screen was removed (its entries moved to docs/ or into the settings list).
 * MainActivity still looks up a DrawerLayout and a NavigationView, so both stay in the layout, but the drawer is
 * locked closed: no button opens it and an edge swipe does nothing.
 * Added for the recompiled copy. Listed in app/compiled-extra-classes.txt because only the layout refers to it.
 */
public class LockedDrawerLayout extends DrawerLayout {
    public LockedDrawerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setDrawerLockMode(LOCK_MODE_LOCKED_CLOSED);
    }
}
