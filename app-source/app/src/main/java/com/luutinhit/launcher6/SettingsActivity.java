package com.luutinhit.launcher6;

import android.app.Activity;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.SwitchPreference;
import com.luutinhit.launcherios.R;

/* JADX INFO: loaded from: classes.dex */
public class SettingsActivity extends Activity {

    /* JADX INFO: renamed from: com.luutinhit.launcher6.SettingsActivity$a */
    public static class C1847a extends PreferenceFragment implements Preference.OnPreferenceChangeListener {
        @Override // android.preference.PreferenceFragment, android.app.Fragment
        public final void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            addPreferencesFromResource(R.xml.launcher_preferences);
            SwitchPreference switchPreference = (SwitchPreference) findPreference("pref_allowRotation");
            switchPreference.setPersistent(false);
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("default_value", false);
            switchPreference.setChecked(getActivity().getContentResolver().call(SettingsColumns.f15702a, "get_boolean_setting", "pref_allowRotation", bundle2).getBoolean("value"));
            switchPreference.setOnPreferenceChangeListener(this);
        }

        @Override // android.preference.Preference.OnPreferenceChangeListener
        public final boolean onPreferenceChange(Preference preference, Object obj) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("value", ((Boolean) obj).booleanValue());
            getActivity().getContentResolver().call(SettingsColumns.f15702a, "set_boolean_setting", preference.getKey(), bundle);
            return true;
        }
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getFragmentManager().beginTransaction().replace(android.R.id.content, new C1847a()).commit();
    }
}
