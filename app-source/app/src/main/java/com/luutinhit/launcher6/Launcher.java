package com.luutinhit.launcher6;

import p126s3.RunnableC2743b;
import A2.C0022a;
import A4.RunnableC0027b;
import B1.RunnableC0031a;
import B3.AbstractC0075r;
import B3.C0039G;
import B3.C0046N;
import B3.C0056Y;
import B3.C0057Z;
import B3.C0067j;
import B3.C0081x;
import B3.InterfaceC0040H;
import B3.RunnableC0054W;
import B3.ViewOnClickListenerC0045M;
import B3.ViewOnClickListenerC0065h;
import C0.C0119k;
import E4.AbstractC0212f;
import F3.EnumC0278e;
import G3.C0343C;
import G3.C0351g;
import G3.C0361q;
import G3.C0367w;
import J3.C0546e;
import L2.C0630c;
import T2.C1043e;
import U0.RunnableC1089s;
import U2.ViewOnTouchListenerC1095a;
import U3.DialogC1104f;
import X3.C1185a;
import Y3.EnumC1218h;
import Y3.InterfaceC1217g;
import Z1.C1291i;
import Z2.C1300b;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityOptions;
import android.app.AlertDialog;
import android.app.WallpaperManager;
import android.appwidget.AppWidgetHostView;
import android.appwidget.AppWidgetProviderInfo;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.SharedPreferences;
import android.content.pm.LauncherApps;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RenderEffect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.os.StrictMode;
import android.os.UserHandle;
import android.os.UserManager;
import android.os.Vibrator;
import android.provider.Settings;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.TextKeyListener;
import android.util.Log;
import android.util.Pair;
import android.util.Property;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.PathInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.Advanceable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.window.OnBackInvokedCallback;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import com.bumptech.glide.AbstractC1690d;
import com.google.android.gms.internal.ads.C3534g7;
import com.google.android.gms.internal.ads.S9;
import com.luutinhit.launcher6.appslibrary.AppsLibraryView;
import com.luutinhit.launcher6.editscreen.LinearLayoutRound;
import com.luutinhit.launcher6.editscreen.SlidingUpCustomizeColorIconStyle;
import com.luutinhit.launcher6.ioslauncher.IOSLauncher;
import com.luutinhit.launcher6.ioslauncher.IOSLauncherCallbacks;
import com.luutinhit.launcher6.leftpage.widgets.PhotoWidget_2x2;
import com.luutinhit.launcher6.util.DeleteCircleView;
import com.luutinhit.launcher6.widget.WidgetsContainerView;
import com.luutinhit.launcher6.widget.view.PictureWidget_2x2;
import com.luutinhit.launcher6.widget.view.SlidingUpWidgetsCellAppStyle;
import com.luutinhit.launcherios.MainActivity;
import com.luutinhit.launcherios.R;
import com.luutinhit.launcherios.notification.NotificationListener;
import com.luutinhit.launcherios.searchview.SearchViewLayout;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import n3.C2504b;
import p015Q.AbstractC0839e;
import p024a.AbstractC1314a;
import p055b2.RunnableC1585t;
import p085i1.C2188y;
import p111o3.C2535b;
import p118q3.C2615e;
import p119q4.AbstractC2620e;
import p122r3.AbstractC2659c;
import p122r3.AbstractC2662f;
import p122r3.AbstractC2666j;
import p122r3.C2673q;
import p122r3.C2674r;
import p126s3.InterfaceC2744c;
import p126s3.SharedPreferencesOnSharedPreferenceChangeListenerC2745d;
import p127s4.C2750c;
import p127s4.InterfaceC2749b;
import p131t3.ViewOnClickListenerC2791d;
import p136u4.InterfaceC2834a;
import p141v4.EnumC2867a;
import p146w4.AbstractC2934a;
import p150x4.C2973a;
import p154y3.C3033h;
import p158z3.C3079j;
import p158z3.InterfaceC3077h;
import p158z3.SharedPreferencesOnSharedPreferenceChangeListenerC3078i;
import t5.C2801d;

/* JADX INFO: renamed from: com.luutinhit.launcher6.W1 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Launcher extends Activity implements View.OnClickListener, View.OnLongClickListener, LauncherModelCallbacks, View.OnTouchListener, PageSwitchListener, LauncherProviderChangeListener, InterfaceC1217g, InterfaceC3077h, SharedPreferences.OnSharedPreferenceChangeListener, InterfaceC2744c {
    static final String ACTION_FIRST_LOAD_COMPLETE = "com.luutinhit.launcher6.action.FIRST_LOAD_COMPLETE";
    public static final int ACTIVITY_START_DELAY = 1000;
    static final int APPWIDGET_HOST_ID = 1024;
    public static final float BOUNCE_ANIMATION_TENSION = 1.3f;
    static final boolean DEBUG_DUMP_LOG = false;
    static final boolean DEBUG_RESUME_TIME = false;
    static final boolean DEBUG_STRICT_MODE = false;
    static final boolean DEBUG_WIDGETS = false;
    public static final boolean DISABLE_SYNCHRONOUS_BINDING_CURRENT_PAGE = false;
    static final String DUMP_STATE_PROPERTY = "launcher_dump_state";
    static final boolean ENABLE_DEBUG_INTENTS = false;
    public static final int EXIT_SPRINGLOADED_MODE_SHORT_TIMEOUT = 300;
    public static final String EXTRA_WALLPAPER_OFFSET = "com.luutinhit.launcher6.WALLPAPER_OFFSET";
    static final String FIRST_LOAD_COMPLETE = "launcher.first_load_complete";
    static final String FIRST_RUN_ACTIVITY_DISPLAYED = "launcher.first_run_activity_displayed";
    static final String INTENT_EXTRA_IGNORE_LAUNCH_ANIMATION = "com.luutinhit.launcher6.intent.extra.shortcut.INGORE_LAUNCH_ANIMATION";
    static final String INTRO_SCREEN_DISMISSED = "launcher.intro_screen_dismissed";
    static int NEW_APPS_ANIMATION_DELAY = 500;
    public static final int NEW_APPS_ANIMATION_INACTIVE_TIMEOUT_SECONDS = 5;
    public static final int NEW_APPS_PAGE_MOVE_DELAY = 500;
    public static final int ON_ACTIVITY_RESULT_ANIMATION_DELAY = 500;
    static final boolean PROFILE_STARTUP = false;
    public static final String QSB_WIDGET_ID = "qsb_widget_id";
    public static final String QSB_WIDGET_PROVIDER = "qsb_widget_provider";
    public static final int REQUEST_BIND_APPWIDGET = 11;
    public static final int REQUEST_CREATE_APPWIDGET = 5;
    public static final int REQUEST_CREATE_SHORTCUT = 1;
    public static final int REQUEST_PERMISSION_CALL_PHONE = 13;
    public static final int REQUEST_PICK_APPWIDGET = 9;
    public static final int REQUEST_PICK_WALLPAPER = 10;
    public static final int REQUEST_RECONFIGURE_APPWIDGET = 12;
    public static final String RUNTIME_STATE = "launcher.state";
    public static final String RUNTIME_STATE_CURRENT_SCREEN = "launcher.current_screen";
    public static final String RUNTIME_STATE_PENDING_ADD_CELL_X = "launcher.add_cell_x";
    public static final String RUNTIME_STATE_PENDING_ADD_CELL_Y = "launcher.add_cell_y";
    public static final String RUNTIME_STATE_PENDING_ADD_COMPONENT = "launcher.add_component";
    public static final String RUNTIME_STATE_PENDING_ADD_CONTAINER = "launcher.add_container";
    public static final String RUNTIME_STATE_PENDING_ADD_SCREEN = "launcher.add_screen";
    public static final String RUNTIME_STATE_PENDING_ADD_SPAN_X = "launcher.add_span_x";
    public static final String RUNTIME_STATE_PENDING_ADD_SPAN_Y = "launcher.add_span_y";
    public static final String RUNTIME_STATE_PENDING_ADD_WIDGET_ID = "launcher.add_widget_id";
    public static final String RUNTIME_STATE_PENDING_ADD_WIDGET_INFO = "launcher.add_widget_info";
    static final int SCREEN_COUNT = 5;
    static final String TAG = "Launcher";
    public static final String USER_HAS_MIGRATED = "launcher.user_migrated_from_old_data";
    public static PendingAddArguments sPendingAddItem;
    public AppsLibraryView appsLibraryLayout;
    public boolean isDarkMode;
    public boolean isHideNavigation;
    public ViewOnClickListenerC2791d leftPage;
    public AppCompatButton mAddWidgets;
    public AppCompatButton mAddWidgetsDone;
    public LauncherAppWidgetHost mAppWidgetHost;
    public AbstractC2659c mAppWidgetManager;
    public long mAutoAdvanceSentTime;
    public BlurScreenLayout mBlurBackgroundView;
    public BlurWallpaperBackground mBlurWallpaperBackground;
    public C2615e mBlurWallpaperProvider;
    public LauncherClings mClings;
    public SlidingUpCustomizeColorIconStyle mCustomizeColorApp;
    public C0067j mDeleteDialog;
    public DeviceProfile mDeviceProfile;
    public DragController mDragController;
    DragLayer mDragLayer;
    public SharedPreferencesOnSharedPreferenceChangeListenerC2745d mEditMenu;
    public DialogC1104f mEditWidgetLabelDialog;
    public BlurScreenLayout mFloatingBackgroundView;
    public SharedPreferencesOnSharedPreferenceChangeListenerC3078i mFloatingMenu;
    FocusIndicatorView mFocusHandler;
    public Bitmap mFolderIconBitmap;
    public Canvas mFolderIconCanvas;
    ImageView mFolderIconImageView;
    public View.OnTouchListener mHapticFeedbackTouchListener;
    public Hotseat mHotseat;
    public IconCache mIconCache;
    public LayoutInflater mInflater;
    public boolean mIsSafeModeEnabled;
    public LauncherCallbacks mLauncherCallbacks;
    public LauncherRootView mLauncherView;
    public LauncherModel mModel;
    public boolean mMoveToDefaultScreenFromNewIntent;
    public C1185a mNotificationChangedListener;
    public boolean mOnResumeNeedsLoad;
    public ViewGroup mOverviewPanel;
    public View mPageIndicators;
    public LauncherAppWidgetProviderInfo mPendingAddWidgetInfo;
    public AppWidgetHostView mQsb;
    public boolean mRestoring;
    public Bundle mSavedState;
    public SearchViewLayout mSearchView;
    public SharedPreferences mSharedPrefs;
    IconTransitionHelper mStateTransitionAnimation;
    public Stats mStats;
    public C0056Y mTinyDB;
    ArrayList<AppInfo> mTmpAppsList;
    public Handler mUiHandler;
    public Vibrator mVibrator;
    public boolean mWaitingForResult;
    public BubbleTextView mWaitingForResume;
    public View mWeightWatcher;
    public SlidingUpWidgetsCellAppStyle mWidgetsAppStyle;
    public View mWidgetsButton;
    C3033h mWidgetsModel;
    WidgetsContainerView mWidgetsView;
    public Handler mWorkerHandler;
    Workspace mWorkspace;
    public C0039G pullDetector;
    public int screenHeight;
    public int screenWidth;
    public static C0081x sFolders = new C0081x();
    static final ArrayList<String> sDumpLogs = new ArrayList<>();
    static Date sDateStamp = new Date();
    static DateFormat sDateFormat = DateFormat.getDateTimeInstance(3, 3);
    protected static HashMap<String, CustomAppWidget> sCustomAppWidgets = new HashMap<>();
    LauncherState mState = LauncherState.f16045k;
    public BroadcastReceiver mCloseSystemDialogsReceiver = new LauncherActionReceiver(1, this);
    public int MSG_NOTIFICATION_CLEAR_ALL = 0;
    public int MSG_NOTIFICATION_FULL_REFRESH = 1;
    public int MSG_SAVE_HISTORY_BACKGROUND = 3;
    public Handler.Callback mWorkerCallback = new LauncherHandlerCallback(this, 1);
    public Handler.Callback mUiCallback = new Handler.Callback() { // from class: com.luutinhit.launcher6.u1
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            Launcher launcher = Launcher.this;
            launcher.getClass();
            if (message != null) {
                try {
                    int i6 = message.what;
                    if (i6 == 0 || i6 == 1) {
                        Workspace workspace = launcher.mWorkspace;
                        workspace.a1(true, new C1291i(25));
                        workspace.a1(false, new C1043e());
                    }
                } catch (Throwable th) {
                    th.getMessage();
                }
            }
            return true;
        }
    };
    public boolean mIsListening = false;
    PendingAddItemInfo mPendingAddInfo = new PendingAddItemInfo();
    public int mPendingAddWidgetId = -1;
    public int[] mTmpAddItemCellCoordinates = new int[2];
    public boolean mAutoAdvanceRunning = false;
    public LauncherState mOnResumeState = LauncherState.f16044j;
    public SpannableStringBuilder mDefaultKeySsb = null;
    boolean mWorkspaceLoading = true;
    public boolean mPaused = true;
    public ArrayList<Runnable> mBindOnResumeCallbacks = new ArrayList<>();
    public ArrayList<Runnable> mOnResumeCallbacks = new ArrayList<>();
    boolean mUserPresent = true;
    public boolean mVisible = false;
    public boolean mHasFocus = false;
    public boolean mAttached = false;
    public int ADVANCE_MSG = 1;
    public int SCREEN_OFF = 2;
    public int mAdvanceInterval = 20000;
    public int mAdvanceStagger = 250;
    public long mAutoAdvanceTimeLeft = -1;
    HashMap<View, AppWidgetProviderInfo> mWidgetsToAdvance = new HashMap<>();
    public int mRestoreScreenOrientationDelay = 500;
    public ArrayList<Integer> mSynchronouslyBoundPages = new ArrayList<>();
    public Rect mRectForFolderAnimation = new Rect();
    public boolean mIsShaking = false;
    public boolean showingFloatingMenu = false;
    public boolean showingEditMenu = false;
    public boolean autoRearrange = false;
    public boolean isUseLiquidGlass = false;
    public boolean isRuntimeRenderSupport = false;
    public boolean isRenderEffectSupport = false;
    public boolean isRTL = false;
    public boolean isUnlockAnim = true;
    public boolean isOpenCloseAnim = true;
    public boolean isShowAppsLibraryGuide = true;
    HashMap<View, ObjectAnimator> mDeleteAnimators = new HashMap<>();
    Runnable mBuildLayersRunnable = new LauncherWorkspaceTask(this, 2);
    public boolean mRotationEnabled = false;
    public Runnable mUpdateOrientationRunnable = new LauncherWorkspaceTask(this, 9);
    public int mIconTextColor = -1;
    public BroadcastReceiver mReceiver = new LauncherActionReceiver(0, this);
    Handler mHandler = new Handler(new LauncherHandlerCallback(this, 0));
    public Runnable mBindAllApplicationsRunnable = new LauncherWorkspaceTask(this, 3);
    public Runnable mBindWidgetModelRunnable = new LauncherWorkspaceTask(this, 4);
    public C0057Z mTinyDBChange = new C0057Z();

    /* JADX INFO: renamed from: C */
    public static PendingAddArguments preparePendingAddArgs(int i6, Intent intent, int i7, ItemInfo itemInfo) {
        Objects.toString(intent);
        Objects.toString(itemInfo);
        PendingAddArguments pendingAddArguments = new PendingAddArguments();
        pendingAddArguments.f15966a = i6;
        pendingAddArguments.f15967b = intent;
        pendingAddArguments.f15968c = itemInfo.container;
        pendingAddArguments.f15969d = itemInfo.screenId;
        pendingAddArguments.f15970e = itemInfo.cellX;
        pendingAddArguments.f15971f = itemInfo.cellY;
        pendingAddArguments.f15972g = i7;
        return pendingAddArguments;
    }

    /* JADX INFO: renamed from: a */
    public static /* synthetic */ void m7823a(Launcher launcher) {
        launcher.mCustomizeColorApp.clearFocus();
        launcher.mCustomizeColorApp.setVisibility(8);
        launcher.mCustomizeColorApp.setPanelStateInternal(EnumC0278e.f850k);
        launcher.mCustomizeColorApp.m742j();
    }

    public static void addDumpLog(String str, String str2, Exception exc, boolean z5) {
    }

    /* JADX INFO: renamed from: b */
    public static /* synthetic */ void m7824b(Launcher launcher) {
        launcher.mCustomizeColorApp.requestFocus();
        launcher.mCustomizeColorApp.setVisibility(0);
        launcher.mCustomizeColorApp.setPanelState(EnumC0278e.f849j);
    }

    public static void dumpDebugLogsToConsole() {
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0015 A[Catch: all -> 0x0009, TRY_LEAVE, TryCatch #0 {all -> 0x0009, blocks: (B:2:0x0000, B:4:0x0004, B:5:0x0006, B:13:0x0015, B:8:0x000b, B:10:0x000f), top: B:18:0x0000 }] */
    /* JADX INFO: renamed from: e */
    public static /* synthetic */ void m7825e(Launcher launcher, ItemInfo itemInfo, Pair pair) {
        com.luutinhit.launcher6.JadxSupport.useOriginalBytecode(); // jadx flagged this method; the original bytecode runs
        C2673q c2673q = null;
        ItemInfo itemInfo2;
        try {
            if (!(itemInfo instanceof ShortcutInfo)) {
                if (itemInfo instanceof AppInfo) {
                    itemInfo2 = (AppInfo) itemInfo;
                } else {
                    c2673q = null;
                }
                if (c2673q != null) {
                    launcher.startApplicationUninstallActivity((ComponentName) pair.first, ((Integer) pair.second).intValue(), c2673q);
                }
                launcher.mDeleteDialog.m177a();
            }
            itemInfo2 = (ShortcutInfo) itemInfo;
            c2673q = itemInfo2.user;
            if (c2673q != null) {
                launcher.startApplicationUninstallActivity((ComponentName) pair.first, ((Integer) pair.second).intValue(), c2673q);
            }
        } catch (Throwable th) {
            th.getMessage();
        }
        launcher.mDeleteDialog.m177a();
    }

    /* JADX INFO: renamed from: g */
    public static /* synthetic */ void m7826g(Launcher launcher, Pair pair) {
        try {
            ArrayList arrayListM134d = launcher.mTinyDB.m134d("list_hidden_apps");
            String strFlattenToString = ((ComponentName) pair.first).flattenToString();
            if (!arrayListM134d.contains(strFlattenToString)) {
                arrayListM134d.add(strFlattenToString);
                launcher.mTinyDB.m139i("list_hidden_apps", arrayListM134d);
            }
            Intent intent = new Intent("com.luutinhit.launcherios.ACTION_HIDDEN_APPS_IN_WORKSPACE");
            intent.putExtra("HIDDEN_APPS_UPDATED", new String[0]);
            intent.putExtra("HIDDEN_APPS_REMOVED", (String[]) arrayListM134d.toArray(new String[0]));
            launcher.sendBroadcast(intent);
        } catch (Throwable th) {
            th.getMessage();
        }
        launcher.mDeleteDialog.m177a();
    }

    public static Pair<ComponentName, Integer> getAppInfoFlags(Object obj) {
        Objects.toString(obj);
        if (obj instanceof AppInfo) {
            AppInfo appInfo = (AppInfo) obj;
            return Pair.create(appInfo.f16329D, Integer.valueOf(appInfo.f16331F));
        }
        if (!(obj instanceof ShortcutInfo)) {
            return null;
        }
        ShortcutInfo shortcutInfo = (ShortcutInfo) obj;
        ComponentName targetComponent = shortcutInfo.getTargetComponent();
        if (shortcutInfo.itemType != 0 || targetComponent == null) {
            return null;
        }
        return Pair.create(targetComponent, Integer.valueOf(shortcutInfo.f16562J));
    }

    public static CustomAppWidget getCustomAppWidget(String str) {
        if (sCustomAppWidgets.get(str) == null) {
            return null;
        }
        throw new ClassCastException();
    }

    public static HashMap<String, CustomAppWidget> getCustomAppWidgets() {
        return sCustomAppWidgets;
    }

    public static List<View> getFolderContents(View view) {
        Objects.toString(view);
        return view instanceof FolderIcon ? ((FolderIcon) view).getFolder().getItemsInReadingOrder() : Collections.EMPTY_LIST;
    }

    /* JADX INFO: renamed from: w */
    public static void updateDialerShortcut(Launcher launcher, String str) {
        if (str == null) {
            launcher.getClass();
            return;
        }
        if (launcher.mModel != null) {
            ArrayList arrayList = LauncherModel.sBgWorkspaceItems;
            int size = arrayList.size();
            int i6 = 0;
            while (i6 < size) {
                Object obj = arrayList.get(i6);
                i6++;
                ItemInfo itemInfo = (ItemInfo) obj;
                if (itemInfo != null && (itemInfo instanceof ShortcutInfo)) {
                    ShortcutInfo shortcutInfo = (ShortcutInfo) itemInfo;
                    if (shortcutInfo.getTargetComponent() != null && shortcutInfo.getTargetComponent().getPackageName().equals(str)) {
                        shortcutInfo.f16793v++;
                    } else if (str.equals("com.android.server.telecom") && shortcutInfo.getTargetComponent() != null && (shortcutInfo.getTargetComponent().toString().toLowerCase().contains("dialer") || shortcutInfo.getTargetComponent().toString().toLowerCase().contains("dialtacts"))) {
                        shortcutInfo.f16793v++;
                    }
                } else if (itemInfo instanceof FolderInfo) {
                    ArrayList arrayList2 = ((FolderInfo) itemInfo).contents;
                    int size2 = arrayList2.size();
                    int i7 = 0;
                    while (i7 < size2) {
                        Object obj2 = arrayList2.get(i7);
                        i7++;
                        ShortcutInfo shortcutInfo2 = (ShortcutInfo) obj2;
                        if (shortcutInfo2.getTargetComponent() != null && shortcutInfo2.getTargetComponent().getPackageName().equals(str)) {
                            shortcutInfo2.f16793v++;
                            itemInfo.f16793v++;
                        } else if (str.equals("com.android.server.telecom") && shortcutInfo2.getTargetComponent() != null && (shortcutInfo2.getTargetComponent().toString().toLowerCase().contains("dialer") || shortcutInfo2.getTargetComponent().toString().toLowerCase().contains("dialtacts"))) {
                            shortcutInfo2.f16793v++;
                            itemInfo.f16793v++;
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: A */
    public final void removeAppWidget(LauncherAppWidgetInfo launcherAppWidgetInfo) {
        Objects.toString(launcherAppWidgetInfo);
        LauncherAppWidgetHost appWidgetHost = getAppWidgetHost();
        if (appWidgetHost != null && launcherAppWidgetInfo.f16568A != -100 && (launcherAppWidgetInfo.f16570C & 1) == 0) {
            new DeleteAppWidgetIdTask(appWidgetHost, launcherAppWidgetInfo).executeOnExecutor(Utilities.f16756q, new Void[0]);
        }
        LauncherModel.deleteItemFromDatabase(this, launcherAppWidgetInfo);
    }

    /* JADX INFO: renamed from: B */
    public final void closeAllPanels() {
        AppsLibraryView appsLibraryView;
        LauncherCallbacks launcherCallbacks = this.mLauncherCallbacks;
        if (launcherCallbacks != null && (appsLibraryView = ((IOSLauncherCallbacks) launcherCallbacks).f16589a.appsLibraryLayout) != null) {
            appsLibraryView.removeExpandedFolder();
        }
        DragController dragController = this.mDragController;
        if (dragController != null && dragController.f16097f) {
            dragController.cancelDrag();
            return;
        }
        BlurScreenLayout blurScreenLayout = this.mBlurBackgroundView;
        if (blurScreenLayout != null && blurScreenLayout.getBackground() != null) {
            this.mBlurBackgroundView.animateBlurAlpha(0, false);
        }
        BlurScreenLayout blurScreenLayout2 = this.mFloatingBackgroundView;
        if (blurScreenLayout2 != null && blurScreenLayout2.getBackground() != null) {
            this.mFloatingBackgroundView.animateBlurAlpha(0, true);
        }
        SearchViewLayout searchViewLayout = this.mSearchView;
        if (searchViewLayout != null && searchViewLayout.m8357J()) {
            this.mSearchView.m8352D();
        }
        if (isOpeningFloatingMenu()) {
            closeFloatingMenu();
        }
        if (isOpeningEditMenu()) {
            closeEditMenu();
        }
        if (isAppsViewVisible()) {
            showWorkspace(true);
            return;
        }
        if (isWidgetsViewVisible()) {
            closeWidgetViewWithAnimation();
            return;
        }
        Workspace workspace = this.mWorkspace;
        if (workspace != null && workspace.X0()) {
            showWorkspace(true);
            return;
        }
        Workspace workspace2 = this.mWorkspace;
        if (workspace2 != null && workspace2.getOpenFolder() != null) {
            Folder openFolder = this.mWorkspace.getOpenFolder();
            if (openFolder.f15616S) {
                openFolder.dismissEditingName();
                return;
            } else {
                closeFolder();
                return;
            }
        }
        Workspace workspace3 = this.mWorkspace;
        if (workspace3 != null) {
            workspace3.f23432V0.getDragLayer().clearAllResizeFrames();
            Workspace workspace4 = this.mWorkspace;
            if (!workspace4.f23377a0 && workspace4.f16064N == 0) {
                workspace4.l0(workspace4.mCurrentPage);
            }
            cancelShakingAnimation();
        }
    }

    /* JADX INFO: renamed from: D */
    public final void m7838D() {
        PendingAddItemInfo pendingAddItemInfo = this.mPendingAddInfo;
        pendingAddItemInfo.container = -1L;
        pendingAddItemInfo.screenId = -1L;
        pendingAddItemInfo.cellY = -1;
        pendingAddItemInfo.cellX = -1;
        pendingAddItemInfo.spanY = -1;
        pendingAddItemInfo.spanX = -1;
        pendingAddItemInfo.minSpanY = 1;
        pendingAddItemInfo.minSpanX = 1;
        pendingAddItemInfo.componentName = null;
    }

    /* JADX INFO: renamed from: E */
    public final void setWaitingForResult(boolean z5) {
        boolean zIsWorkspaceLocked = isWorkspaceLocked();
        this.mWaitingForResult = z5;
        if (zIsWorkspaceLocked != isWorkspaceLocked()) {
            onWorkspaceLockedChanged();
        }
    }

    /* JADX INFO: renamed from: F */
    public final void applyLauncherState(LauncherState launcherState) {
        Objects.toString(launcherState);
        LauncherState launcherState2 = this.mState;
        if (launcherState2 == LauncherState.f16045k || launcherState2 == LauncherState.f16047m || launcherState2 == LauncherState.f16049o) {
            LauncherState launcherState3 = LauncherState.f16046l;
            LauncherState launcherState4 = LauncherState.f16048n;
            if (launcherState == launcherState3 || launcherState == launcherState4) {
                if (launcherState == launcherState4) {
                    IconTransitionHelper iconTransitionHelper = this.mStateTransitionAnimation;
                    WorkspaceState state = this.mWorkspace.getState();
                    iconTransitionHelper.getClass();
                    Objects.toString(state);
                    iconTransitionHelper.f15744a.openWidgetView(true, true);
                }
                this.mState = launcherState;
                this.mUserPresent = false;
                updateAutoAdvanceState();
                closeFolder();
                getWindow().getDecorView().sendAccessibilityEvent(32);
            }
        }
    }

    /* JADX INFO: renamed from: G */
    public final void showBrokenAppInstallDialog(String str, DialogInterface.OnClickListener onClickListener) {
        Objects.toString(onClickListener);
        new AlertDialog.Builder(this).setTitle(R.string.abandoned_promises_title).setMessage(R.string.abandoned_promise_explanation).setPositiveButton(R.string.abandoned_search, onClickListener).setNeutralButton(R.string.abandoned_clean_this, new LauncherDialogClickListener(this, str, 0)).create().show();
    }

    /* JADX INFO: renamed from: H */
    public final void postRefreshViews(ViewGroup viewGroup) {
        BlurScreenLayout blurScreenLayout = this.mFloatingBackgroundView;
        if (blurScreenLayout != null) {
            blurScreenLayout.runOnMainThread(new RunnableC0054W(15, blurScreenLayout, viewGroup));
        }
    }

    /* JADX WARN: Code duplicated, block: B:33:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:8:0x0024  */
    /* JADX INFO: renamed from: I */
    public final boolean startActivity(View view, Intent intent, Object obj) {
        com.luutinhit.launcher6.JadxSupport.useOriginalBytecode(); // jadx flagged this method; the original bytecode runs
        boolean z5;
        ActivityOptions activityOptionsMakeCustomAnimation;
        Objects.toString(view);
        Objects.toString(intent);
        Objects.toString(obj);
        intent.addFlags(268435456);
        if (view != null) {
            try {
                if (intent.hasExtra(INTENT_EXTRA_IGNORE_LAUNCH_ANIMATION)) {
                    z5 = false;
                } else {
                    z5 = true;
                }
            } catch (Throwable unused) {
                if (Utilities.f16748i && (obj instanceof ItemInfo) && intent.getComponent() == null && "android.intent.action.CALL".equals(intent.getAction()) && checkSelfPermission("android.permission.CALL_PHONE") != 0) {
                    sPendingAddItem = preparePendingAddArgs(13, intent, 0, (ItemInfo) obj);
                    requestPermissions(new String[]{"android.permission.CALL_PHONE"}, 13);
                    return false;
                }
                Toast.makeText(this, R.string.activity_not_found, 0).show();
                intent.toString();
                Objects.toString(obj);
                intent.toString();
                return false;
            }
        } else {
            z5 = false;
        }
        AbstractC2666j abstractC2666jM9657c = AbstractC2666j.m9657c(this);
        Bundle bundle = null;
        C2673q c2673qMo9678h = intent.hasExtra("profile") ? C2674r.m9673e(this).mo9678h(intent.getLongExtra("profile", -1L)) : null;
        if (z5) {
            if (Utilities.f16748i) {
                int measuredWidth = view.getMeasuredWidth();
                int measuredHeight = view.getMeasuredHeight();
                if (view instanceof BubbleTextView) {
                    Drawable icon = ((BubbleTextView) view).getIcon();
                    if (icon != null) {
                        Rect bounds = icon.getBounds();
                        int iWidth = (measuredWidth - bounds.width()) / 2;
                        int paddingTop = view.getPaddingTop();
                        int iWidth2 = bounds.width();
                        int iHeight = bounds.height();
                        Bitmap bitmapIcon = ((BubbleTextView) view).getBitmapIcon();
                        activityOptionsMakeCustomAnimation = ActivityOptions.makeClipRevealAnimation(view, iWidth, paddingTop, iWidth2, iHeight);
                        if (Utilities.f16745f && !(view.getParent().getParent().getParent() instanceof FolderPagedView)) {
                            this.mStateTransitionAnimation.m7751a(((BubbleTextView) view).getIconView(), bitmapIcon);
                        }
                    } else {
                        activityOptionsMakeCustomAnimation = null;
                    }
                } else {
                    activityOptionsMakeCustomAnimation = ActivityOptions.makeScaleUpAnimation(view, 0, 0, measuredWidth, measuredHeight);
                }
            } else if (!Utilities.f16752m) {
                activityOptionsMakeCustomAnimation = ActivityOptions.makeScaleUpAnimation(view, 0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
            } else if (Utilities.f16751l) {
                activityOptionsMakeCustomAnimation = ActivityOptions.makeCustomAnimation(this, R.anim.task_open_enter, R.anim.no_anim);
            } else {
                activityOptionsMakeCustomAnimation = null;
            }
            if (activityOptionsMakeCustomAnimation != null) {
                bundle = activityOptionsMakeCustomAnimation.toBundle();
            }
        }
        if (c2673qMo9678h != null && !c2673qMo9678h.equals(C2673q.m9672b())) {
            abstractC2666jM9657c.mo9665i(intent.getComponent(), c2673qMo9678h, intent.getSourceBounds(), bundle);
            return true;
        }
        StrictMode.VmPolicy vmPolicy = StrictMode.getVmPolicy();
        try {
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectActivityLeaks().detectLeakedClosableObjects().detectLeakedRegistrationObjects().detectFileUriExposure().penaltyLog().build());
            if (getPackageManager().queryIntentActivities(intent, 0).isEmpty()) {
                intent.toString();
                Toast.makeText(this, R.string.activity_not_found, 0).show();
            } else if (!isFinishing() && !isDestroyed()) {
                startActivity(intent, bundle);
                return true;
            }
            return false;
        } finally {
            StrictMode.setVmPolicy(vmPolicy);
        }
    }

    /* JADX INFO: renamed from: J */
    public final boolean deferUntilResume(Runnable runnable) {
        Objects.toString(runnable);
        return waitUntilResume(runnable, false);
    }

    public void addAppWidgetFromDropImpl(int i6, ItemInfo itemInfo, AppWidgetHostView appWidgetHostView, LauncherAppWidgetProviderInfo launcherAppWidgetProviderInfo) {
        addAppWidgetImpl(i6, itemInfo, appWidgetHostView, launcherAppWidgetProviderInfo, 0);
    }

    public void addAppWidgetImpl(int i6, ItemInfo itemInfo, AppWidgetHostView appWidgetHostView, LauncherAppWidgetProviderInfo launcherAppWidgetProviderInfo, int i7) {
        if (((AppWidgetProviderInfo) launcherAppWidgetProviderInfo).configure != null) {
            this.mPendingAddWidgetInfo = launcherAppWidgetProviderInfo;
            this.mPendingAddWidgetId = i6;
            this.mAppWidgetManager.mo9650l(launcherAppWidgetProviderInfo, i6, this, this.mAppWidgetHost, 5);
        } else {
            LauncherWorkspaceTask launcherWorkspaceTask = new LauncherWorkspaceTask(this, 6);
            completeAddAppWidget(i6, itemInfo.container, itemInfo.screenId, appWidgetHostView, launcherAppWidgetProviderInfo);
            this.mWorkspace.i1(true, launcherWorkspaceTask, i7, false);
        }
    }

    public FolderIcon addFolder(CellLayout cellLayout, long j6, long j7, int i6, int i7) {
        Objects.toString(cellLayout);
        FolderInfo folderInfo = new FolderInfo();
        folderInfo.title = getText(R.string.folder_name);
        LauncherModel.addItemToDatabase(this, folderInfo, j6, j7, i6, i7);
        sFolders.put(folderInfo.id, folderInfo);
        FolderIcon folderIconM7716g = FolderIcon.m7716g(this, cellLayout, folderInfo, this.mIconCache);
        Workspace workspace = this.mWorkspace;
        boolean zIsWorkspaceLocked = isWorkspaceLocked();
        workspace.getClass();
        Objects.toString(folderIconM7716g);
        workspace.v0(folderIconM7716g, j6, j7, i6, i7, 1, 1, zIsWorkspaceLocked, false);
        this.mWorkspace.R0(folderIconM7716g).getShortcutsAndWidgets().measureChild(folderIconM7716g);
        return folderIconM7716g;
    }

    public void addOnResumeCallback(Runnable runnable) {
        Objects.toString(runnable);
        this.mOnResumeCallbacks.add(runnable);
    }

    public void addPendingItem(PendingAddItemInfo pendingAddItemInfo, long j6, long j7, int[] iArr, int i6, int i7) {
        Parcelable parcelable;
        Objects.toString(pendingAddItemInfo);
        int i8 = pendingAddItemInfo.itemType;
        if (i8 == 1) {
            ComponentName componentName = pendingAddItemInfo.componentName;
            Objects.toString(componentName);
            m7838D();
            PendingAddItemInfo pendingAddItemInfo2 = this.mPendingAddInfo;
            pendingAddItemInfo2.container = j6;
            pendingAddItemInfo2.screenId = j7;
            pendingAddItemInfo2.componentName = componentName;
            if (iArr != null) {
                pendingAddItemInfo2.cellX = iArr[0];
                pendingAddItemInfo2.cellY = iArr[1];
            }
            Intent intent = new Intent("android.intent.action.CREATE_SHORTCUT");
            intent.setComponent(componentName);
            Rect rect = Utilities.sOldBounds;
            try {
                startActivityForResult(intent, 1);
                return;
            } catch (ActivityNotFoundException unused) {
                Toast.makeText(this, R.string.activity_not_found, 0).show();
                return;
            } catch (SecurityException unused2) {
                Toast.makeText(this, R.string.activity_not_found, 0).show();
                Objects.toString(intent);
                return;
            }
        }
        if (i8 != 4 && i8 != 5) {
            throw new IllegalStateException("Unknown item type: " + pendingAddItemInfo.itemType);
        }
        int[] iArr2 = {i6, i7};
        C0351g c0351g = (C0351g) pendingAddItemInfo;
        m7838D();
        PendingAddItemInfo pendingAddItemInfo3 = this.mPendingAddInfo;
        c0351g.container = j6;
        pendingAddItemInfo3.container = j6;
        c0351g.screenId = j7;
        pendingAddItemInfo3.screenId = j7;
        pendingAddItemInfo3.minSpanX = c0351g.minSpanX;
        pendingAddItemInfo3.minSpanY = c0351g.minSpanY;
        if (iArr != null) {
            pendingAddItemInfo3.cellX = iArr[0];
            pendingAddItemInfo3.cellY = iArr[1];
        }
        pendingAddItemInfo3.spanX = iArr2[0];
        pendingAddItemInfo3.spanY = iArr2[1];
        AppWidgetHostView appWidgetHostView = c0351g.f1150D;
        LauncherAppWidgetProviderInfo launcherAppWidgetProviderInfo = c0351g.f1149C;
        if (appWidgetHostView != null) {
            getDragLayer().removeView(appWidgetHostView);
            addAppWidgetFromDropImpl(appWidgetHostView.getAppWidgetId(), c0351g, appWidgetHostView, launcherAppWidgetProviderInfo);
            c0351g.f1150D = null;
            return;
        }
        int iAllocateAppWidgetId = getAppWidgetHost().allocateAppWidgetId();
        if (this.mAppWidgetManager.mo9640a(iAllocateAppWidgetId, launcherAppWidgetProviderInfo, c0351g.f1151E)) {
            addAppWidgetFromDropImpl(iAllocateAppWidgetId, c0351g, null, launcherAppWidgetProviderInfo);
            return;
        }
        this.mPendingAddWidgetInfo = launcherAppWidgetProviderInfo;
        Intent intent2 = new Intent("android.appwidget.action.APPWIDGET_BIND");
        intent2.putExtra("appWidgetId", iAllocateAppWidgetId);
        intent2.putExtra("appWidgetProvider", c0351g.componentName);
        C2673q c2673qMo9646h = this.mAppWidgetManager.mo9646h(this.mPendingAddWidgetInfo);
        c2673qMo9646h.getClass();
        if (Utilities.f16752m && (parcelable = c2673qMo9646h.f20687a) != null) {
            intent2.putExtra("appWidgetProviderProfile", parcelable);
        }
        startActivityForResult(intent2, 11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void addToCustomContentPage(View view, AppsLibraryProgressCallback appsLibraryProgressCallback, String str, int i6) {
        com.luutinhit.launcher6.JadxSupport.useOriginalBytecode(); // jadx flagged this method; the original bytecode runs
        Objects.toString(view);
        Objects.toString(appsLibraryProgressCallback);
        Workspace workspace = this.mWorkspace;
        workspace.getClass();
        long j6 = i6 == 0 ? -301L : -302L;
        if (workspace.Q0(j6) < 0) {
            throw new RuntimeException("Expected custom content screen to exist");
        }
        CellLayout cellLayoutT0 = workspace.T0(j6);
        CellLayoutLayoutParams cellLayoutLayoutParams = new CellLayoutLayoutParams(0, 0, cellLayoutT0.getCountX(), cellLayoutT0.getCountY());
        cellLayoutLayoutParams.f15694j = false;
        cellLayoutLayoutParams.f15693i = true;
        if (view instanceof Insettable) {
            ((Insettable) view).setInsets(workspace.f23393q0);
        }
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(view);
        }
        cellLayoutT0.removeAllViews();
        view.setFocusable(true);
        view.setOnKeyListener(new IconKeyEventListener(0));
        view.setOnFocusChangeListener(workspace.f23432V0.mFocusHandler.getHideIndicatorOnFocusListener());
        cellLayoutT0.addViewToCellLayout(view, 0, 0, cellLayoutLayoutParams, true);
        if (i6 != 0) {
            workspace.f23423N0 = appsLibraryProgressCallback;
        } else {
            workspace.f23428R0 = str;
            workspace.mCustomContentCallbacks = appsLibraryProgressCallback;
        }
    }

    public void bindAddScreens(ArrayList<Long> arrayList) {
        Objects.toString(arrayList);
        int size = arrayList.size();
        for (int i6 = 0; i6 < size; i6++) {
            Workspace workspace = this.mWorkspace;
            long jLongValue = arrayList.get(i6).longValue();
            ArrayList arrayList2 = workspace.f23403D0;
            int iIndexOf = arrayList2.contains(-302L) ? arrayList2.indexOf(-302L) : arrayList2.indexOf(-201L);
            if (iIndexOf < 0) {
                iIndexOf = arrayList2.size();
            }
            workspace.W0(iIndexOf, jLongValue);
        }
    }

    @Override // com.luutinhit.launcher6.LauncherModelCallbacks
    public void bindAllApplications(ArrayList arrayList) {
        Objects.toString(arrayList);
        if (waitUntilResume(this.mBindAllApplicationsRunnable, true)) {
            this.mTmpAppsList = arrayList;
            return;
        }
        LauncherModel launcherModel = this.mModel;
        if (launcherModel != null) {
            launcherModel.addAppsToAllApps(this, arrayList);
        }
        LauncherCallbacks launcherCallbacks = this.mLauncherCallbacks;
        if (launcherCallbacks != null) {
            IOSLauncher iOSLauncher = ((IOSLauncherCallbacks) launcherCallbacks).f16589a;
            AppsLibraryView appsLibraryView = iOSLauncher.appsLibraryLayout;
            if (appsLibraryView != null) {
                appsLibraryView.setApps(arrayList);
            }
            if (iOSLauncher.getSearchView() != null) {
                iOSLauncher.getSearchView().m8358K(arrayList);
            }
        }
    }

    @Override // com.luutinhit.launcher6.LauncherModelCallbacks
    public void bindAppInfosRemoved(ArrayList arrayList) {
        AppsLibraryView appsLibraryView;
        ArrayList arrayList2;
        Objects.toString(arrayList);
        if (deferUntilResume(new LauncherMiscRunnable(this, arrayList, 2)) || (appsLibraryView = this.appsLibraryLayout) == null || (arrayList2 = appsLibraryView.f16294o) == null || arrayList2.size() != 10) {
            return;
        }
        Objects.toString(arrayList);
        int size = arrayList.size();
        int i6 = 0;
        while (i6 < size) {
            AppInfo appInfo = (AppInfo) arrayList.get(i6);
            i6++;
            AppInfo appInfo2 = appInfo;
            if (appInfo2 != null) {
                boolean zContains = ((C2535b) arrayList2.get(0)).f20266b.contains(appInfo2);
                C2504b c2504b = appsLibraryView.f16292m;
                if (zContains) {
                    ((C2535b) arrayList2.get(0)).f20266b.remove(appInfo2);
                    c2504b.m9704g(0);
                }
                int iResolveAppCategory = appsLibraryView.resolveAppCategory(appInfo2);
                if (iResolveAppCategory >= 0) {
                    if (arrayList2.get(iResolveAppCategory) != null) {
                        ((C2535b) arrayList2.get(iResolveAppCategory)).f20266b.remove(appInfo2);
                        c2504b.m9704g(iResolveAppCategory);
                    }
                } else if (arrayList2.get(0) != null && arrayList2.get(9) != null) {
                    ((C2535b) arrayList2.get(9)).f20266b.remove(appInfo2);
                    c2504b.m9704g(9);
                }
            }
        }
    }

    @Override // com.luutinhit.launcher6.LauncherModelCallbacks
    public void bindAppWidget(final LauncherAppWidgetInfo launcherAppWidgetInfo) {
        LauncherAppWidgetProviderInfo launcherAppWidgetProviderInfoMo9641b;
        AppWidgetHostView appWidgetHostViewCreateView;
        if (launcherAppWidgetInfo == null) {
            return;
        }
        int i6 = 0;
        if (deferUntilResume(new Runnable() { // from class: com.luutinhit.launcher6.q1

            /* JADX INFO: renamed from: k */
            public /* synthetic */ Launcher f16829k;

            {
                this.f16829k = Launcher.this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                switch (i6) {
                    case 0:
                        this.f16829k.bindAppWidget(launcherAppWidgetInfo);
                        break;
                    case 1:
                        Launcher launcher = this.f16829k;
                        launcher.getClass();
                        LauncherModel.deleteItemFromDatabase(launcher, launcherAppWidgetInfo);
                        break;
                    case 2:
                        Launcher launcher2 = this.f16829k;
                        launcher2.getClass();
                        LauncherModel.deleteItemFromDatabase(launcher2, launcherAppWidgetInfo);
                        break;
                    case 3:
                        Launcher launcher3 = this.f16829k;
                        launcher3.getClass();
                        LauncherModel.updateItemInDatabase(launcher3, launcherAppWidgetInfo);
                        break;
                    default:
                        Launcher launcher4 = this.f16829k;
                        launcher4.getClass();
                        LauncherModel.updateItemInDatabase(launcher4, launcherAppWidgetInfo);
                        break;
                }
            }
        })) {
            return;
        }
        try {
            if (this.mIsSafeModeEnabled) {
                PendingAppWidgetHostView pendingAppWidgetHostView = new PendingAppWidgetHostView(this, launcherAppWidgetInfo, true);
                pendingAppWidgetHostView.updateIcon(this.mIconCache);
                launcherAppWidgetInfo.f16573F = pendingAppWidgetHostView;
                pendingAppWidgetHostView.updateAppWidget(null);
                launcherAppWidgetInfo.f16573F.setOnClickListener(this);
                addAppWidgetToWorkspace(launcherAppWidgetInfo, null, false);
                this.mWorkspace.requestLayout();
                return;
            }
            boolean zHasRestoreFlag = launcherAppWidgetInfo.hasRestoreFlag(2);
            boolean zHasRestoreFlag2 = launcherAppWidgetInfo.hasRestoreFlag(1);
            ComponentName componentName = launcherAppWidgetInfo.providerName;
            if (zHasRestoreFlag) {
                launcherAppWidgetProviderInfoMo9641b = null;
            } else {
                launcherAppWidgetProviderInfoMo9641b = zHasRestoreFlag2 ? this.mAppWidgetManager.mo9641b(componentName, launcherAppWidgetInfo.user) : this.mAppWidgetManager.m9645g(launcherAppWidgetInfo.f16568A);
            }
            int i7 = launcherAppWidgetInfo.f16570C;
            if (!zHasRestoreFlag && i7 != 0) {
                if (launcherAppWidgetProviderInfoMo9641b == null) {
                    Objects.toString(componentName);
                    int i8 = 1;
                    LauncherModel.m7567y(new Runnable() { // from class: com.luutinhit.launcher6.q1

                        /* JADX INFO: renamed from: k */
                        public /* synthetic */ Launcher f16829k;

                        {
                            this.f16829k = Launcher.this;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            switch (i8) {
                                case 0:
                                    this.f16829k.bindAppWidget(launcherAppWidgetInfo);
                                    break;
                                case 1:
                                    Launcher launcher = this.f16829k;
                                    launcher.getClass();
                                    LauncherModel.deleteItemFromDatabase(launcher, launcherAppWidgetInfo);
                                    break;
                                case 2:
                                    Launcher launcher2 = this.f16829k;
                                    launcher2.getClass();
                                    LauncherModel.deleteItemFromDatabase(launcher2, launcherAppWidgetInfo);
                                    break;
                                case 3:
                                    Launcher launcher3 = this.f16829k;
                                    launcher3.getClass();
                                    LauncherModel.updateItemInDatabase(launcher3, launcherAppWidgetInfo);
                                    break;
                                default:
                                    Launcher launcher4 = this.f16829k;
                                    launcher4.getClass();
                                    LauncherModel.updateItemInDatabase(launcher4, launcherAppWidgetInfo);
                                    break;
                            }
                        }
                    });
                    return;
                }
                if (zHasRestoreFlag2) {
                    C0351g c0351g = new C0351g(this, launcherAppWidgetProviderInfoMo9641b);
                    c0351g.spanX = launcherAppWidgetInfo.spanX;
                    c0351g.spanY = launcherAppWidgetInfo.spanY;
                    c0351g.minSpanX = launcherAppWidgetInfo.minSpanX;
                    c0351g.minSpanY = launcherAppWidgetInfo.minSpanY;
                    Bundle bundleM904a = C0361q.m904a(this, c0351g);
                    int iAllocateAppWidgetId = this.mAppWidgetHost.allocateAppWidgetId();
                    if (!this.mAppWidgetManager.mo9640a(iAllocateAppWidgetId, launcherAppWidgetProviderInfoMo9641b, bundleM904a)) {
                        this.mAppWidgetHost.deleteAppWidgetId(iAllocateAppWidgetId);
                        Objects.toString(componentName);
                        int i9 = 2;
                        LauncherModel.m7567y(new Runnable() { // from class: com.luutinhit.launcher6.q1

                            /* JADX INFO: renamed from: k */
                            public /* synthetic */ Launcher f16829k;

                            {
                                this.f16829k = Launcher.this;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                switch (i9) {
                                    case 0:
                                        this.f16829k.bindAppWidget(launcherAppWidgetInfo);
                                        break;
                                    case 1:
                                        Launcher launcher = this.f16829k;
                                        launcher.getClass();
                                        LauncherModel.deleteItemFromDatabase(launcher, launcherAppWidgetInfo);
                                        break;
                                    case 2:
                                        Launcher launcher2 = this.f16829k;
                                        launcher2.getClass();
                                        LauncherModel.deleteItemFromDatabase(launcher2, launcherAppWidgetInfo);
                                        break;
                                    case 3:
                                        Launcher launcher3 = this.f16829k;
                                        launcher3.getClass();
                                        LauncherModel.updateItemInDatabase(launcher3, launcherAppWidgetInfo);
                                        break;
                                    default:
                                        Launcher launcher4 = this.f16829k;
                                        launcher4.getClass();
                                        LauncherModel.updateItemInDatabase(launcher4, launcherAppWidgetInfo);
                                        break;
                                }
                            }
                        });
                        return;
                    }
                    launcherAppWidgetInfo.f16568A = iAllocateAppWidgetId;
                    launcherAppWidgetInfo.f16570C = ((AppWidgetProviderInfo) launcherAppWidgetProviderInfoMo9641b).configure == null ? 0 : 4;
                    int i10 = 3;
                    LauncherModel.m7567y(new Runnable() { // from class: com.luutinhit.launcher6.q1

                        /* JADX INFO: renamed from: k */
                        public /* synthetic */ Launcher f16829k;

                        {
                            this.f16829k = Launcher.this;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            switch (i10) {
                                case 0:
                                    this.f16829k.bindAppWidget(launcherAppWidgetInfo);
                                    break;
                                case 1:
                                    Launcher launcher = this.f16829k;
                                    launcher.getClass();
                                    LauncherModel.deleteItemFromDatabase(launcher, launcherAppWidgetInfo);
                                    break;
                                case 2:
                                    Launcher launcher2 = this.f16829k;
                                    launcher2.getClass();
                                    LauncherModel.deleteItemFromDatabase(launcher2, launcherAppWidgetInfo);
                                    break;
                                case 3:
                                    Launcher launcher3 = this.f16829k;
                                    launcher3.getClass();
                                    LauncherModel.updateItemInDatabase(launcher3, launcherAppWidgetInfo);
                                    break;
                                default:
                                    Launcher launcher4 = this.f16829k;
                                    launcher4.getClass();
                                    LauncherModel.updateItemInDatabase(launcher4, launcherAppWidgetInfo);
                                    break;
                            }
                        }
                    });
                } else if (launcherAppWidgetInfo.hasRestoreFlag(4) && ((AppWidgetProviderInfo) launcherAppWidgetProviderInfoMo9641b).configure == null) {
                    launcherAppWidgetInfo.f16570C = 0;
                    int i11 = 4;
                    LauncherModel.m7567y(new Runnable() { // from class: com.luutinhit.launcher6.q1

                        /* JADX INFO: renamed from: k */
                        public /* synthetic */ Launcher f16829k;

                        {
                            this.f16829k = Launcher.this;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            switch (i11) {
                                case 0:
                                    this.f16829k.bindAppWidget(launcherAppWidgetInfo);
                                    break;
                                case 1:
                                    Launcher launcher = this.f16829k;
                                    launcher.getClass();
                                    LauncherModel.deleteItemFromDatabase(launcher, launcherAppWidgetInfo);
                                    break;
                                case 2:
                                    Launcher launcher2 = this.f16829k;
                                    launcher2.getClass();
                                    LauncherModel.deleteItemFromDatabase(launcher2, launcherAppWidgetInfo);
                                    break;
                                case 3:
                                    Launcher launcher3 = this.f16829k;
                                    launcher3.getClass();
                                    LauncherModel.updateItemInDatabase(launcher3, launcherAppWidgetInfo);
                                    break;
                                default:
                                    Launcher launcher4 = this.f16829k;
                                    launcher4.getClass();
                                    LauncherModel.updateItemInDatabase(launcher4, launcherAppWidgetInfo);
                                    break;
                            }
                        }
                    });
                }
            }
            if (launcherAppWidgetInfo.f16570C == 0 && launcherAppWidgetProviderInfoMo9641b != null) {
                LauncherAppWidgetHost launcherAppWidgetHost = this.mAppWidgetHost;
                if (launcherAppWidgetHost != null && (appWidgetHostViewCreateView = launcherAppWidgetHost.createView(this, launcherAppWidgetInfo.f16568A, launcherAppWidgetProviderInfoMo9641b)) != null) {
                    launcherAppWidgetInfo.f16573F = appWidgetHostViewCreateView;
                    launcherAppWidgetInfo.minSpanX = launcherAppWidgetProviderInfoMo9641b.f16576l;
                    launcherAppWidgetInfo.minSpanY = launcherAppWidgetProviderInfoMo9641b.f16577m;
                    addAppWidgetToWorkspace(launcherAppWidgetInfo, launcherAppWidgetProviderInfoMo9641b, false);
                    return;
                }
                return;
            }
            PendingAppWidgetHostView pendingAppWidgetHostView2 = new PendingAppWidgetHostView(this, launcherAppWidgetInfo, this.mIsSafeModeEnabled);
            pendingAppWidgetHostView2.updateIcon(this.mIconCache);
            launcherAppWidgetInfo.f16573F = pendingAppWidgetHostView2;
            pendingAppWidgetHostView2.updateAppWidget(null);
            launcherAppWidgetInfo.f16573F.setOnClickListener(this);
            addAppWidgetToWorkspace(launcherAppWidgetInfo, null, false);
            this.mWorkspace.requestLayout();
        } catch (Throwable unused) {
        }
    }

    @Override // com.luutinhit.launcher6.LauncherModelCallbacks
    public void bindAppsAdded(ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
        AppsLibraryView appsLibraryView;
        ArrayList arrayList5;
        Objects.toString(arrayList);
        Objects.toString(arrayList2);
        Objects.toString(arrayList3);
        Objects.toString(arrayList4);
        if (deferUntilResume(new RunnableC1089s((Object) this, (Object) arrayList, (Serializable) arrayList2, (Object) arrayList3, (Object) arrayList4, 4))) {
            return;
        }
        if (arrayList != null) {
            bindAddScreens(arrayList);
        }
        int i6 = 0;
        if (arrayList2 != null && !arrayList2.isEmpty()) {
            bindItems(arrayList2, 0, arrayList2.size(), false);
        }
        if (arrayList3 != null && !arrayList3.isEmpty()) {
            bindItems(arrayList3, 0, arrayList3.size(), true);
        }
        this.mWorkspace.i1(false, null, 0, false);
        if (arrayList4 == null || (appsLibraryView = this.appsLibraryLayout) == null || (arrayList5 = appsLibraryView.f16294o) == null) {
            return;
        }
        try {
            if (arrayList5.size() == 10) {
                int size = arrayList4.size();
                while (i6 < size) {
                    AppInfo appInfo = (AppInfo) arrayList4.get(i6);
                    i6++;
                    AppInfo appInfo2 = appInfo;
                    arrayList4.toString();
                    if (appInfo2 != null) {
                        int iResolveAppCategory = appsLibraryView.resolveAppCategory(appInfo2);
                        C2504b c2504b = appsLibraryView.f16292m;
                        if (iResolveAppCategory >= 0) {
                            if (arrayList5.get(iResolveAppCategory) != null && !((C2535b) arrayList5.get(iResolveAppCategory)).f20266b.contains(appInfo2)) {
                                ((C2535b) arrayList5.get(iResolveAppCategory)).f20266b.add(appInfo2);
                                c2504b.m9704g(iResolveAppCategory);
                            }
                        } else if (arrayList5.get(9) != null && !((C2535b) arrayList5.get(9)).f20266b.contains(appInfo2)) {
                            ((C2535b) arrayList5.get(9)).f20266b.add(appInfo2);
                            c2504b.m9704g(9);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.luutinhit.launcher6.LauncherModelCallbacks
    public void bindAppsUpdated(ArrayList arrayList) {
        Objects.toString(arrayList);
        deferUntilResume(new LauncherMiscRunnable(this, arrayList, 0));
    }

    @Override // com.luutinhit.launcher6.LauncherModelCallbacks
    public void bindFolders(C0081x c0081x) {
        Objects.toString(c0081x);
        if (deferUntilResume(new MergedModelRunnable(7, this, c0081x))) {
            return;
        }
        sFolders = c0081x.m200d();
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0048  */
    /* JADX WARN: Code duplicated, block: B:64:0x0143  */
    @Override // com.luutinhit.launcher6.LauncherModelCallbacks
    public void bindItems(ArrayList arrayList, int i6, int i7, boolean z5) {
        com.luutinhit.launcher6.JadxSupport.useOriginalBytecode(); // jadx flagged this method; the original bytecode runs
        boolean z6 = false;
        char c6;
        View viewCreateShortcut;
        CellLayout cellLayoutT0;
        char c7 = 0;
        View childAt;
        int i8;
        View view;
        LauncherClings launcherClings;
        int i9 = 2;
        int i10 = 1;
        Objects.toString(arrayList);
        if (deferUntilResume(new BindItemsRunnable(this, arrayList, i6, i7, z5))) {
            return;
        }
        AnimatorSet animatorSetCreateAnimatorSet = LauncherAnimUtils.createAnimatorSet();
        ArrayList arrayList2 = new ArrayList();
        if (z5) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            DragController dragController = this.mDragController;
            if (jCurrentTimeMillis - (dragController.f16097f ? System.currentTimeMillis() : dragController.f16114w) <= 5000 || ((launcherClings = this.mClings) != null && launcherClings.f16800l)) {
                z6 = false;
            } else {
                z6 = true;
            }
        } else {
            z6 = false;
        }
        Workspace workspace = this.mWorkspace;
        int i11 = i6;
        long j6 = -1;
        while (i11 < i7) {
            ItemInfo itemInfo = (ItemInfo) arrayList.get(i11);
            if (itemInfo.container == -101 && this.mHotseat == null) {
                i8 = i11;
            } else {
                int i12 = itemInfo.itemType;
                if (i12 == 0 || i12 == i10) {
                    c6 = 2;
                    ShortcutInfo shortcutInfo = (ShortcutInfo) itemInfo;
                    HashSet hashSet = LauncherModel.sBgWidgetProviders;
                    if (hashSet != null && !hashSet.isEmpty()) {
                        Objects.toString(LauncherModel.sBgWidgetProviders);
                        Intent intent = shortcutInfo.f16553A;
                        if (intent != null && intent.getComponent() != null && LauncherModel.sBgWidgetProviders.contains(shortcutInfo.f16553A.getComponent().flattenToString())) {
                            i8 = i11;
                        }
                    }
                    viewCreateShortcut = createShortcut(shortcutInfo);
                    if (itemInfo.container == -100 && (cellLayoutT0 = this.mWorkspace.T0(itemInfo.screenId)) != null) {
                        int i13 = itemInfo.cellX;
                        int i14 = itemInfo.cellY;
                        c7 = 0;
                        if (i13 >= cellLayoutT0.mCountX || i14 >= cellLayoutT0.mCountY) {
                            throw new RuntimeException("Position exceeds the bound of this CellLayout");
                        }
                        if (cellLayoutT0.f15481v[i13][i14] && (childAt = cellLayoutT0.mShortcutsAndWidgets.getChildAt(i13, i14)) != null) {
                            Object tag = childAt.getTag();
                            itemInfo.toString();
                            Objects.toString(tag);
                            WeakReference weakReference = LauncherAppState.f16215h;
                        }
                    }
                    long j7 = itemInfo.container;
                    long j8 = itemInfo.screenId;
                    int i15 = itemInfo.cellX;
                    int i16 = itemInfo.cellY;
                    workspace.getClass();
                    Objects.toString(viewCreateShortcut);
                    int i17 = i11;
                    view = viewCreateShortcut;
                    i8 = i17;
                    workspace.v0(view, j7, j8, i15, i16, 1, 1, false, true);
                    if (z6) {
                        view.setAlpha(0.0f);
                        view.setScaleX(0.0f);
                        view.setScaleY(0.0f);
                        Objects.toString(view);
                        float[] fArr = new float[1];
                        fArr[c7] = 1.0f;
                        PropertyValuesHolder propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat("alpha", fArr);
                        float[] fArr2 = new float[1];
                        fArr2[c7] = 1.0f;
                        PropertyValuesHolder propertyValuesHolderOfFloat2 = PropertyValuesHolder.ofFloat("scaleX", fArr2);
                        float[] fArr3 = new float[1];
                        fArr3[c7] = 1.0f;
                        PropertyValuesHolder propertyValuesHolderOfFloat3 = PropertyValuesHolder.ofFloat("scaleY", fArr3);
                        PropertyValuesHolder[] propertyValuesHolderArr = new PropertyValuesHolder[3];
                        propertyValuesHolderArr[c7] = propertyValuesHolderOfFloat;
                        propertyValuesHolderArr[1] = propertyValuesHolderOfFloat2;
                        propertyValuesHolderArr[c6] = propertyValuesHolderOfFloat3;
                        ObjectAnimator objectAnimatorOfPropertyValuesHolder = LauncherAnimUtils.ofPropertyValuesHolder(view, propertyValuesHolderArr);
                        objectAnimatorOfPropertyValuesHolder.setDuration(450L);
                        objectAnimatorOfPropertyValuesHolder.setStartDelay(((long) i8) * 85);
                        objectAnimatorOfPropertyValuesHolder.setInterpolator(new OvershootInterpolator(BOUNCE_ANIMATION_TENSION));
                        arrayList2.add(objectAnimatorOfPropertyValuesHolder);
                        j6 = itemInfo.screenId;
                    }
                    i11 = i8 + 1;
                    i9 = 2;
                    i10 = 1;
                } else {
                    if (i12 != i9) {
                        throw new RuntimeException("Invalid Item Type");
                    }
                    c6 = 2;
                    viewCreateShortcut = FolderIcon.m7716g(this, (CellLayout) workspace.getChildAt(workspace.getCurrentPage()), (FolderInfo) itemInfo, this.mIconCache);
                }
                c7 = 0;
                long j9 = itemInfo.container;
                long j10 = itemInfo.screenId;
                int i18 = itemInfo.cellX;
                int i19 = itemInfo.cellY;
                workspace.getClass();
                Objects.toString(viewCreateShortcut);
                int i110 = i11;
                view = viewCreateShortcut;
                i8 = i110;
                workspace.v0(view, j9, j10, i18, i19, 1, 1, false, true);
                if (z6) {
                    view.setAlpha(0.0f);
                    view.setScaleX(0.0f);
                    view.setScaleY(0.0f);
                    Objects.toString(view);
                    float[] fArr4 = new float[1];
                    fArr4[c7] = 1.0f;
                    PropertyValuesHolder propertyValuesHolderOfFloat4 = PropertyValuesHolder.ofFloat("alpha", fArr4);
                    float[] fArr5 = new float[1];
                    fArr5[c7] = 1.0f;
                    PropertyValuesHolder propertyValuesHolderOfFloat5 = PropertyValuesHolder.ofFloat("scaleX", fArr5);
                    float[] fArr6 = new float[1];
                    fArr6[c7] = 1.0f;
                    PropertyValuesHolder propertyValuesHolderOfFloat6 = PropertyValuesHolder.ofFloat("scaleY", fArr6);
                    PropertyValuesHolder[] propertyValuesHolderArr2 = new PropertyValuesHolder[3];
                    propertyValuesHolderArr2[c7] = propertyValuesHolderOfFloat4;
                    propertyValuesHolderArr2[1] = propertyValuesHolderOfFloat5;
                    propertyValuesHolderArr2[c6] = propertyValuesHolderOfFloat6;
                    ObjectAnimator objectAnimatorOfPropertyValuesHolder2 = LauncherAnimUtils.ofPropertyValuesHolder(view, propertyValuesHolderArr2);
                    objectAnimatorOfPropertyValuesHolder2.setDuration(450L);
                    objectAnimatorOfPropertyValuesHolder2.setStartDelay(((long) i8) * 85);
                    objectAnimatorOfPropertyValuesHolder2.setInterpolator(new OvershootInterpolator(BOUNCE_ANIMATION_TENSION));
                    arrayList2.add(objectAnimatorOfPropertyValuesHolder2);
                    j6 = itemInfo.screenId;
                }
                i11 = i8 + 1;
                i9 = 2;
                i10 = 1;
            }
            j6 = j6;
            i11 = i8 + 1;
            i9 = 2;
            i10 = 1;
        }
        long j11 = j6;
        if (z6 && j11 > -1) {
            Workspace workspace2 = this.mWorkspace;
            long jS0 = workspace2.S0(workspace2.getNextPage());
            int iQ0 = this.mWorkspace.Q0(j11);
            MergedModelRunnable mergedModelRunnable = new MergedModelRunnable(animatorSetCreateAnimatorSet, arrayList2, 6, false);
            if (j11 != jS0) {
                this.mWorkspace.postDelayed(new LauncherDeferredRunnable(this, iQ0, mergedModelRunnable), 500L);
            } else {
                this.mWorkspace.postDelayed(mergedModelRunnable, NEW_APPS_ANIMATION_DELAY);
            }
        }
        workspace.requestLayout();
    }

    @Override // com.luutinhit.launcher6.LauncherModelCallbacks
    public void bindRestoreItemsChange(HashSet hashSet) {
        Objects.toString(hashSet);
        if (deferUntilResume(new MergedModelRunnable(8, this, hashSet))) {
            return;
        }
        Workspace workspace = this.mWorkspace;
        workspace.getClass();
        Objects.toString(hashSet);
        workspace.a1(true, new MergedItemCallbacks(7, hashSet));
    }

    @Override // com.luutinhit.launcher6.LauncherModelCallbacks
    public void bindScreens(ArrayList arrayList) {
        Objects.toString(arrayList);
        bindAddScreens(arrayList);
        if (arrayList.size() == 0) {
            this.mWorkspace.u0();
        }
        if (hasCustomContentToLeft()) {
            this.mWorkspace.D0(0);
            this.mWorkspace.D0(1);
            populateCustomContentContainer();
        }
    }

    @Override // com.luutinhit.launcher6.LauncherModelCallbacks
    public void bindShortcutsChanged(ArrayList arrayList, ArrayList arrayList2, C2673q c2673q) {
        Objects.toString(arrayList);
        Objects.toString(arrayList2);
        Objects.toString(c2673q);
        if (deferUntilResume(new LauncherMiscRunnable2(this, arrayList, arrayList2, c2673q, 0))) {
            return;
        }
        if (!arrayList.isEmpty()) {
            Workspace workspace = this.mWorkspace;
            workspace.getClass();
            Objects.toString(arrayList);
            workspace.a1(true, new Partner(workspace, new HashSet(arrayList)));
        }
        if (arrayList2.isEmpty()) {
            return;
        }
        HashSet hashSet = new HashSet();
        int size = arrayList2.size();
        int i6 = 0;
        while (i6 < size) {
            ShortcutInfo shortcutInfo = (ShortcutInfo) arrayList2.get(i6);
            i6++;
            hashSet.add(shortcutInfo.getTargetComponent());
        }
        this.mWorkspace.j1(hashSet, c2673q);
        this.mDragController.onAppsRemoved(new HashSet(), hashSet);
    }

    @Override // com.luutinhit.launcher6.LauncherModelCallbacks
    public void bindShortcutsHidden(ArrayList arrayList, ArrayList arrayList2, C2673q c2673q) {
        int i6 = 0;
        Objects.toString(arrayList);
        Objects.toString(arrayList2);
        Objects.toString(c2673q);
        if (deferUntilResume(new LauncherMiscRunnable2(this, arrayList, arrayList2, c2673q, 1))) {
            return;
        }
        if (!arrayList2.isEmpty()) {
            HashSet hashSet = new HashSet();
            int size = arrayList2.size();
            int i7 = 0;
            while (i7 < size) {
                ShortcutInfo shortcutInfo = (ShortcutInfo) arrayList2.get(i7);
                i7++;
                ShortcutInfo shortcutInfo2 = shortcutInfo;
                Objects.toString(shortcutInfo2);
                hashSet.add(shortcutInfo2.getTargetComponent());
                LauncherModel.deleteItemFromDatabase(this, shortcutInfo2);
            }
            this.mWorkspace.j1(hashSet, c2673q);
            this.mDragController.onAppsRemoved(new HashSet(), hashSet);
            if (this.autoRearrange) {
                rearrangeApps(false);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        int size2 = arrayList.size();
        int i8 = 0;
        while (i8 < size2) {
            int i9 = i8 + 1;
            ShortcutInfo shortcutInfo3 = (ShortcutInfo) arrayList.get(i8);
            int[] iArr = new int[2];
            Workspace workspace = getWorkspace();
            ArrayList<Long> screenOrder = workspace.getScreenOrder();
            int currentPage = workspace.getCurrentPage();
            long jLongValue = screenOrder.get(currentPage).longValue();
            boolean zM7646o = ((CellLayout) workspace.getChildAt(currentPage)).m7646o(shortcutInfo3.spanX, shortcutInfo3.spanY, iArr);
            boolean zU0 = workspace.U0();
            screenOrder.size();
            while (true) {
                if (zM7646o || i6 >= screenOrder.size()) {
                    i6 = (zU0) ? 1 : 0;
                    break;
                }
                i6 = (zU0) ? 1 : 0;
                jLongValue = screenOrder.get(i6).longValue();
                zM7646o = ((CellLayout) workspace.getChildAt(i6)).m7646o(shortcutInfo3.spanX, shortcutInfo3.spanY, iArr);
                i6++;
            }
            if (jLongValue == -201) {
                jLongValue = workspace.C0();
                zM7646o = workspace.T0(jLongValue).m7646o(shortcutInfo3.spanX, shortcutInfo3.spanY, iArr);
            }
            if (!zM7646o) {
                workspace.u0();
                jLongValue = workspace.C0();
                workspace.T0(jLongValue).m7646o(shortcutInfo3.spanX, shortcutInfo3.spanY, iArr);
            }
            LauncherModel.addOrMoveItemInDatabase(this, shortcutInfo3, -100L, jLongValue, iArr[0], iArr[1]);
            ArrayList<ItemInfo> arrayList3 = new ArrayList<>();
            arrayList3.add(shortcutInfo3);
            bindItems(arrayList3, 0, arrayList3.size(), true);
            i8 = i9;
        }
    }

    @Override // com.luutinhit.launcher6.LauncherModelCallbacks
    public void bindWidgetsModel(C3033h c3033h) {
        if (waitUntilResume(this.mBindWidgetModelRunnable, true)) {
            this.mWidgetsModel = c3033h;
            return;
        }
        WidgetsContainerView widgetsContainerView = this.mWidgetsView;
        if (widgetsContainerView == null || c3033h == null) {
            return;
        }
        C0343C c0343c = widgetsContainerView.f23527a0;
        try {
            widgetsContainerView.f23531e0 = c3033h;
            c0343c.f1124o = c3033h;
            c0343c.f1131v = new boolean[c3033h.f21980b.size()];
            c0343c.m9703f();
        } catch (Throwable th) {
            th.getMessage();
        }
        this.mWidgetsModel = null;
    }

    @Override // com.luutinhit.launcher6.LauncherModelCallbacks
    public void bindWidgetsRestored(ArrayList arrayList) {
        AppWidgetProviderInfo appWidgetInfo;
        Objects.toString(arrayList);
        if (deferUntilResume(new LauncherMiscRunnable(this, arrayList, 1))) {
            return;
        }
        Workspace workspace = this.mWorkspace;
        workspace.getClass();
        if (arrayList.isEmpty()) {
            return;
        }
        Launcher launcher = workspace.f23432V0;
        DeferredWidgetRefresh deferredWidgetRefresh = new DeferredWidgetRefresh(workspace, arrayList, launcher.getAppWidgetHost());
        int i6 = 0;
        LauncherAppWidgetInfo launcherAppWidgetInfo = (LauncherAppWidgetInfo) arrayList.get(0);
        if (launcherAppWidgetInfo.hasRestoreFlag(1)) {
            appWidgetInfo = AbstractC2659c.m9639f(launcher).mo9641b(launcherAppWidgetInfo.providerName, launcherAppWidgetInfo.user);
        } else {
            AbstractC2659c abstractC2659cM9639f = AbstractC2659c.m9639f(launcher);
            appWidgetInfo = abstractC2659cM9639f.f20663a.getAppWidgetInfo(launcherAppWidgetInfo.f16568A);
        }
        if (appWidgetInfo != null) {
            deferredWidgetRefresh.run();
            return;
        }
        int size = arrayList.size();
        while (i6 < size) {
            LauncherAppWidgetInfo launcherAppWidgetInfo2 = (LauncherAppWidgetInfo) arrayList.get(i6);
            i6++;
            LauncherAppWidgetInfo launcherAppWidgetInfo3 = launcherAppWidgetInfo2;
            AppWidgetHostView appWidgetHostView = launcherAppWidgetInfo3.f16573F;
            if (appWidgetHostView instanceof PendingAppWidgetHostView) {
                launcherAppWidgetInfo3.f16571D = 100;
                ((PendingAppWidgetHostView) appWidgetHostView).applyState();
            }
        }
    }

    @Override // com.luutinhit.launcher6.LauncherModelCallbacks
    public void bindWorkspaceComponentsRemoved(HashSet hashSet, HashSet hashSet2, C2673q c2673q) {
        Objects.toString(hashSet);
        Objects.toString(hashSet2);
        Objects.toString(c2673q);
        if (deferUntilResume(new RunnableC0031a(this, hashSet, hashSet2, c2673q, 9, false))) {
            return;
        }
        if (!hashSet.isEmpty()) {
            this.mWorkspace.k1(hashSet, c2673q);
        }
        if (!hashSet2.isEmpty()) {
            this.mWorkspace.j1(hashSet2, c2673q);
        }
        this.mDragController.onAppsRemoved(hashSet, hashSet2);
    }

    public void cancelShakingAnimation() {
        if (this.mIsShaking) {
            int i6 = 0;
            this.mIsShaking = false;
            if (this.mWorkspace != null) {
                this.mAddWidgets.setVisibility(8);
                this.mAddWidgetsDone.setVisibility(8);
                if (this.mWorkspace.getOpenFolder() != null) {
                    this.mWorkspace.getOpenFolder().m7694I();
                }
                ArrayList<ShortcutAndWidgetContainer> allShortcutAndWidgetContainers = this.mWorkspace.getAllShortcutAndWidgetContainers();
                int size = allShortcutAndWidgetContainers.size();
                while (i6 < size) {
                    ShortcutAndWidgetContainer shortcutAndWidgetContainer = allShortcutAndWidgetContainers.get(i6);
                    i6++;
                    shortcutAndWidgetContainer.m8037a();
                }
                this.mWorkspace.postOnAnimationDelayed(new LauncherWorkspaceRunnable(this, 4), 568L);
                this.mWorkspace.getPageIndicator().mo7789h();
            }
        }
    }

    public void changeWallpaperVisiblity(boolean z5) {
        int i6 = z5 ? 1048576 : 0;
        if (i6 != (getWindow().getAttributes().flags & 1048576)) {
            getWindow().setFlags(i6, 1048576);
        }
    }

    public void clearBadgeCount() {
        LauncherModel launcherModel = this.mModel;
        if (launcherModel != null) {
            launcherModel.getClass();
            ArrayList arrayList = LauncherModel.sBgWorkspaceItems;
            int size = arrayList.size();
            int i6 = 0;
            while (i6 < size) {
                Object obj = arrayList.get(i6);
                i6++;
                ItemInfo itemInfo = (ItemInfo) obj;
                if (itemInfo instanceof ShortcutInfo) {
                    itemInfo.f16793v = 0;
                } else if (itemInfo instanceof FolderInfo) {
                    FolderInfo folderInfo = (FolderInfo) itemInfo;
                    ArrayList arrayList2 = folderInfo.contents;
                    int size2 = arrayList2.size();
                    int i7 = 0;
                    while (i7 < size2) {
                        Object obj2 = arrayList2.get(i7);
                        i7++;
                        ((ShortcutInfo) obj2).f16793v = 0;
                    }
                    folderInfo.f16793v = 0;
                }
            }
        }
    }

    public void closeCustomizeColorAppStyle() {
        SlidingUpCustomizeColorIconStyle slidingUpCustomizeColorIconStyle = this.mCustomizeColorApp;
        if (slidingUpCustomizeColorIconStyle != null) {
            slidingUpCustomizeColorIconStyle.postOnAnimation(new LauncherWorkspaceRunnable(this, 3));
        }
    }

    public void closeEditMenu() {
        SharedPreferencesOnSharedPreferenceChangeListenerC2745d sharedPreferencesOnSharedPreferenceChangeListenerC2745d = this.mEditMenu;
        if (sharedPreferencesOnSharedPreferenceChangeListenerC2745d == null || !this.showingEditMenu) {
            return;
        }
        this.showingEditMenu = false;
        sharedPreferencesOnSharedPreferenceChangeListenerC2745d.m9831b();
    }

    public void closeFloatingMenu() {
        if (this.mFloatingMenu == null || !this.showingFloatingMenu) {
            return;
        }
        this.showingFloatingMenu = false;
        this.mFloatingBackgroundView.animateBlurAlpha(0, true);
        this.mFloatingMenu.m10339d();
    }

    public void closeFolder() {
        closeFolder(true);
    }

    public void closeSystemDialogs() {
        getWindow().closeAllPanels();
        setWaitingForResult(false);
    }

    public void closeWidgetView(boolean z5) {
        WidgetsContainerView widgetsContainerView;
        if (isWidgetsViewVisible() && (widgetsContainerView = this.mWidgetsView) != null) {
            widgetsContainerView.postOnAnimation(new MergedViewRunnable(this, z5, 0));
        }
        this.mState = LauncherState.f16045k;
        getWorkspace().setState(WorkspaceState.f15305k);
    }

    public void closeWidgetViewWithAnimation() {
        this.mWidgetsView.setPanelState(EnumC0278e.f850k);
    }

    public void completeAddAppWidget(int i6, long j6, long j7, AppWidgetHostView appWidgetHostView, LauncherAppWidgetProviderInfo launcherAppWidgetProviderInfo) {
        PendingAddItemInfo pendingAddItemInfo = this.mPendingAddInfo;
        LauncherAppWidgetProviderInfo launcherAppWidgetProviderInfoM9645g = launcherAppWidgetProviderInfo == null ? this.mAppWidgetManager.m9645g(i6) : launcherAppWidgetProviderInfo;
        launcherAppWidgetProviderInfoM9645g.getClass();
        LauncherAppWidgetInfo launcherAppWidgetInfo = new LauncherAppWidgetInfo(i6, ((AppWidgetProviderInfo) launcherAppWidgetProviderInfoM9645g).provider);
        launcherAppWidgetInfo.spanX = pendingAddItemInfo.spanX;
        launcherAppWidgetInfo.spanY = pendingAddItemInfo.spanY;
        launcherAppWidgetInfo.minSpanX = pendingAddItemInfo.minSpanX;
        launcherAppWidgetInfo.minSpanY = pendingAddItemInfo.minSpanY;
        launcherAppWidgetInfo.user = this.mAppWidgetManager.mo9646h(launcherAppWidgetProviderInfoM9645g);
        LauncherModel.addItemToDatabase(this, launcherAppWidgetInfo, j6, j7, pendingAddItemInfo.cellX, pendingAddItemInfo.cellY);
        if (!this.mRestoring) {
            if (appWidgetHostView == null) {
                LauncherAppWidgetHost launcherAppWidgetHost = this.mAppWidgetHost;
                launcherAppWidgetHost.getClass();
                launcherAppWidgetInfo.f16573F = launcherAppWidgetHost.createView(this, i6, launcherAppWidgetProviderInfoM9645g);
            } else {
                launcherAppWidgetInfo.f16573F = appWidgetHostView;
            }
            launcherAppWidgetInfo.f16573F.setVisibility(0);
            addAppWidgetToWorkspace(launcherAppWidgetInfo, launcherAppWidgetProviderInfoM9645g, isWorkspaceLocked());
        }
        m7838D();
    }

    public void completeTwoStageWidgetDrop(int i6, int i7) {
        CompleteAddRunnable completeAddRunnable;
        AppWidgetHostView appWidgetHostView;
        int i8;
        CellLayout cellLayoutT0 = this.mWorkspace.T0(this.mPendingAddInfo.screenId);
        if (cellLayoutT0 != null && i6 == -1) {
            LauncherAppWidgetHost launcherAppWidgetHost = this.mAppWidgetHost;
            LauncherAppWidgetProviderInfo launcherAppWidgetProviderInfo = this.mPendingAddWidgetInfo;
            launcherAppWidgetHost.getClass();
            launcherAppWidgetProviderInfo.getClass();
            AppWidgetHostView appWidgetHostViewCreateView = launcherAppWidgetHost.createView(this, i7, launcherAppWidgetProviderInfo);
            appWidgetHostView = appWidgetHostViewCreateView;
            completeAddRunnable = new CompleteAddRunnable(i7, i6, appWidgetHostViewCreateView, this);
            i8 = 3;
        } else if (cellLayoutT0 == null || i6 == 0) {
            this.mAppWidgetHost.deleteAppWidgetId(i7);
            completeAddRunnable = null;
            appWidgetHostView = null;
            i8 = 4;
        } else {
            completeAddRunnable = null;
            appWidgetHostView = null;
            i8 = 0;
        }
        if (cellLayoutT0 != null && this.mDragLayer.getAnimatedView() != null) {
            this.mWorkspace.x0(this.mPendingAddInfo, cellLayoutT0, (DragView) this.mDragLayer.getAnimatedView(), completeAddRunnable, i8, appWidgetHostView);
        } else if (completeAddRunnable != null) {
            completeAddRunnable.run();
        }
    }

    @TargetApi(C3534g7.zzm)
    public ItemInfo createAppDragInfo(Intent intent) {
        UserHandle userHandle;
        Objects.toString(intent);
        return createAppDragInfo(intent, (!Utilities.f16752m || (userHandle = (UserHandle) intent.getParcelableExtra("android.intent.extra.USER")) == null) ? null : C2673q.m9671a(userHandle));
    }

    public FastBitmapDrawable createIconDrawable(Bitmap bitmap) {
        Objects.toString(bitmap);
        FastBitmapDrawable fastBitmapDrawable = new FastBitmapDrawable(this, bitmap);
        fastBitmapDrawable.setFilterBitmap(true);
        resizeIconDrawable(fastBitmapDrawable);
        return fastBitmapDrawable;
    }

    public View createShortcut(ShortcutInfo shortcutInfo) {
        Objects.toString(shortcutInfo);
        Workspace workspace = this.mWorkspace;
        return createShortcut((ViewGroup) workspace.getChildAt(workspace.getCurrentPage()), shortcutInfo);
    }

    public ItemInfo createShortcutDragInfo(Intent intent, CharSequence charSequence, Bitmap bitmap) {
        Objects.toString(intent);
        Objects.toString(charSequence);
        Objects.toString(bitmap);
        C2673q c2673qM9672b = C2673q.m9672b();
        ShortcutInfo shortcutInfo = new ShortcutInfo();
        shortcutInfo.f16553A = intent;
        shortcutInfo.title = Utilities.trim(charSequence);
        shortcutInfo.contentDescription = charSequence;
        shortcutInfo.f16558F = bitmap;
        shortcutInfo.user = c2673qM9672b;
        return shortcutInfo;
    }

    public void dismissIntroScreen() {
        SharedPreferences.Editor editorEdit = this.mSharedPrefs.edit();
        editorEdit.putBoolean(INTRO_SCREEN_DISMISSED, true);
        editorEdit.apply();
        if (showFirstRunActivity()) {
            this.mWorkspace.postDelayed(new LauncherWorkspaceTask(this, 5), 1000L);
        } else {
            this.mDragLayer.dismissOverlayView();
            showFirstRunClings();
        }
        changeWallpaperVisiblity(true);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        Objects.toString(keyEvent);
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 3) {
                if (keyCode == 25) {
                    Rect rect = Utilities.sOldBounds;
                    if (Log.isLoggable(DUMP_STATE_PROPERTY, 2)) {
                        dumpState();
                    }
                }
            }
            return true;
        }
        if (keyEvent.getAction() == 1 && keyEvent.getKeyCode() == 3) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        Objects.toString(accessibilityEvent);
        boolean zDispatchPopulateAccessibilityEvent = super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        List<CharSequence> text = accessibilityEvent.getText();
        text.clear();
        LauncherState launcherState = this.mState;
        if (launcherState == LauncherState.f16046l) {
            text.add(getString(R.string.all_apps_button_label));
            return zDispatchPopulateAccessibilityEvent;
        }
        if (launcherState == LauncherState.f16048n) {
            text.add(getString(R.string.widget_button_text));
            return zDispatchPopulateAccessibilityEvent;
        }
        Workspace workspace = this.mWorkspace;
        if (workspace != null) {
            text.add(workspace.getCurrentPageDescription());
            return zDispatchPopulateAccessibilityEvent;
        }
        text.add(getString(R.string.all_apps_home_button_label));
        return zDispatchPopulateAccessibilityEvent;
    }

    @Override // android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        Objects.toString(fileDescriptor);
        Objects.toString(printWriter);
        super.dump(str, fileDescriptor, printWriter, strArr);
        synchronized (sDumpLogs) {
            try {
                printWriter.println(" ");
                printWriter.println("Debug logs: ");
                int i6 = 0;
                while (true) {
                    ArrayList<String> arrayList = sDumpLogs;
                    if (i6 >= arrayList.size()) {
                        break;
                    }
                    printWriter.println("  " + arrayList.get(i6));
                    i6++;
                }
            } catch (Throwable th) {
                throw com.luutinhit.launcher6.JadxSupport.sneaky(th);
            }
        }
        LauncherCallbacks launcherCallbacks = this.mLauncherCallbacks;
        if (launcherCallbacks != null) {
            launcherCallbacks.getClass();
        }
    }

    public void dumpState() {
        toString();
        Objects.toString(this.mSavedState);
        sFolders.size();
        LauncherModel launcherModel = this.mModel;
        Objects.toString(launcherModel.f15352t);
        AppInfo.m7981f((ArrayList) launcherModel.f15353u.f1070k);
        AppInfo.m7981f((ArrayList) launcherModel.f15353u.f1071l);
        AppInfo.m7981f((ArrayList) launcherModel.f15353u.f1072m);
        AppInfo.m7981f((ArrayList) launcherModel.f15353u.f1073n);
        LoaderTask loaderTask = launcherModel.mLoaderTask;
        if (loaderTask != null) {
            synchronized (LauncherModel.sBgLock) {
                Objects.toString(loaderTask.f17239j);
                LauncherModel.sBgWorkspaceItems.size();
            }
        }
    }

    public void enterSpringLoadedDragMode() {
        LauncherState launcherState;
        LauncherState launcherState2;
        this.mState.name();
        LauncherState launcherState3 = this.mState;
        if (launcherState3 == LauncherState.f16045k || launcherState3 == (launcherState = LauncherState.f16047m) || launcherState3 == (launcherState2 = LauncherState.f16049o)) {
            return;
        }
        this.mStateTransitionAnimation.m7752b(launcherState3, this.mWorkspace.getState(), WorkspaceState.f15307m, null);
        if (!isAppsViewVisible()) {
            launcherState = launcherState2;
        }
        this.mState = launcherState;
    }

    public void exitSpringLoadedDragMode() {
        LauncherState launcherState = this.mState;
        if (launcherState == LauncherState.f16047m) {
            showAppsView(true, false, false, false);
        } else if (launcherState == LauncherState.f16049o) {
            showWidgetsView(true, false);
        }
    }

    public void exitSpringLoadedDragModeDelayed(boolean z5, int i6, Runnable runnable) {
        Objects.toString(runnable);
        LauncherState launcherState = this.mState;
        if (launcherState == LauncherState.f16047m || launcherState == LauncherState.f16049o) {
            this.mHandler.postDelayed(new MergedLoaderRunnable(this, z5, runnable), i6);
        }
    }

    @Override // com.luutinhit.launcher6.LauncherModelCallbacks
    public void finishBindingItems() {
        ArrayList arrayList;
        if (deferUntilResume(new LauncherWorkspaceTask(this, 8))) {
            return;
        }
        if (this.mSavedState != null) {
            if (!this.mWorkspace.hasFocus()) {
                this.mWorkspace.getCurrentPage();
                Workspace workspace = this.mWorkspace;
                workspace.getChildAt(workspace.getCurrentPage()).requestFocus();
            }
            this.mSavedState = null;
        }
        Workspace workspace2 = this.mWorkspace;
        int childCount = workspace2.getChildCount();
        int i6 = 0;
        while (true) {
            arrayList = workspace2.f23408F1;
            if (i6 >= childCount) {
                break;
            }
            if (!arrayList.contains(Integer.valueOf(i6))) {
                workspace2.m1(i6);
            }
            i6++;
        }
        arrayList.clear();
        workspace2.f23406E1 = null;
        boolean zIsWorkspaceLocked = isWorkspaceLocked();
        this.mWorkspaceLoading = false;
        if (zIsWorkspaceLocked != isWorkspaceLocked()) {
            onWorkspaceLockedChanged();
        }
        if (!this.mSharedPrefs.getBoolean(FIRST_LOAD_COMPLETE, false)) {
            sendBroadcast(new Intent(ACTION_FIRST_LOAD_COMPLETE), getResources().getString(R.string.receive_first_load_broadcast_permission));
            SharedPreferences.Editor editorEdit = this.mSharedPrefs.edit();
            editorEdit.putBoolean(FIRST_LOAD_COMPLETE, true);
            editorEdit.apply();
        }
        PendingAddArguments pendingAddArguments = sPendingAddItem;
        if (pendingAddArguments != null) {
            this.mWorkspace.post(new ScrollToScreenRunnable(this, completeAdd(pendingAddArguments)));
            sPendingAddItem = null;
        }
        if (Utilities.f16755p) {
            NotificationListener.f17614m = this.mNotificationChangedListener;
        }
        InstallShortcutReceiver.f15736b = false;
        InstallShortcutReceiver.flushInstallQueue(this);
    }

    public LauncherAppWidgetHost getAppWidgetHost() {
        return this.mAppWidgetHost;
    }

    public BlurScreenLayout getBlurBackground() {
        return this.mBlurBackgroundView;
    }

    public Bitmap getBlurGlassWallpaper() {
        C2615e blurWallpaperProvider = getBlurWallpaperProvider();
        Bitmap bitmap = blurWallpaperProvider.f20556f;
        if (bitmap == null) {
            bitmap = blurWallpaperProvider.f20555e;
        }
        if (bitmap == null) {
            return getBlurWallpaperProvider().f20557g;
        }
        bitmap.toString();
        return bitmap;
    }

    public C2615e getBlurWallpaperProvider() {
        return this.mBlurWallpaperProvider;
    }

    public CellLayout getCellLayout(long j6, long j7) {
        if (j6 != -101) {
            return this.mWorkspace.T0(j7);
        }
        Hotseat hotseat = this.mHotseat;
        if (hotseat != null) {
            return hotseat.getLayout();
        }
        return null;
    }

    @Override // com.luutinhit.launcher6.LauncherModelCallbacks
    public int getCurrentWorkspaceScreen() {
        Workspace workspace = this.mWorkspace;
        if (workspace != null) {
            return workspace.getCurrentPage();
        }
        return 2;
    }

    public DeviceProfile getDeviceProfile() {
        return this.mDeviceProfile;
    }

    public DragController getDragController() {
        return this.mDragController;
    }

    public DragLayer getDragLayer() {
        return this.mDragLayer;
    }

    public SharedPreferencesOnSharedPreferenceChangeListenerC2745d getEditMenu() {
        return this.mEditMenu;
    }

    public Intent getFirstRunActivity() {
        LauncherCallbacks launcherCallbacks = this.mLauncherCallbacks;
        if (launcherCallbacks != null) {
            launcherCallbacks.getClass();
        }
        return null;
    }

    public SharedPreferencesOnSharedPreferenceChangeListenerC3078i getFloatingMenu() {
        return this.mFloatingMenu;
    }

    public View.OnTouchListener getHapticFeedbackTouchListener() {
        if (this.mHapticFeedbackTouchListener == null) {
            this.mHapticFeedbackTouchListener = new ViewOnTouchListenerC1095a(2);
        }
        return this.mHapticFeedbackTouchListener;
    }

    public Hotseat getHotseat() {
        return this.mHotseat;
    }

    public IconCache getIconCache() {
        return this.mIconCache;
    }

    public LayoutInflater getInflater() {
        return this.mInflater;
    }

    public View getIntroScreen() {
        LauncherCallbacks launcherCallbacks = this.mLauncherCallbacks;
        if (launcherCallbacks != null) {
            launcherCallbacks.getClass();
        }
        return null;
    }

    public LauncherCallbacks getLauncherCallbacks() {
        return this.mLauncherCallbacks;
    }

    public LauncherRootView getLauncherView() {
        return this.mLauncherView;
    }

    public LauncherModel getModel() {
        return this.mModel;
    }

    public ViewGroup getOverviewPanel() {
        return this.mOverviewPanel;
    }

    public Rect getSearchBarBounds() {
        DeviceProfile deviceProfile = this.mDeviceProfile;
        Utilities.isRtl(getResources());
        return deviceProfile.getHotseatRect();
    }

    public int getSearchBarHeight() {
        LauncherCallbacks launcherCallbacks = this.mLauncherCallbacks;
        if (launcherCallbacks != null) {
            launcherCallbacks.getClass();
        }
        return 0;
    }

    public SearchViewLayout getSearchView() {
        return this.mSearchView;
    }

    public SharedPreferences getSharedPrefs() {
        return this.mSharedPrefs;
    }

    public IconTransitionHelper getStateTransitionAnimation() {
        return this.mStateTransitionAnimation;
    }

    public Stats getStats() {
        return this.mStats;
    }

    public C0056Y getTinyDB() {
        return this.mTinyDB;
    }

    public int getTopOffsetForCustomContent() {
        return this.mWorkspace.getPaddingTop();
    }

    public int getViewIdForItem(ItemInfo itemInfo) {
        Objects.toString(itemInfo);
        return (int) itemInfo.id;
    }

    public View getWidgetsButton() {
        return this.mWidgetsButton;
    }

    public WidgetsContainerView getWidgetsView() {
        return this.mWidgetsView;
    }

    public Workspace getWorkspace() {
        return this.mWorkspace;
    }

    public boolean hasCustomContentToLeft() {
        LauncherCallbacks launcherCallbacks = this.mLauncherCallbacks;
        if (launcherCallbacks == null) {
            return false;
        }
        launcherCallbacks.getClass();
        return true;
    }

    public boolean hasDismissableIntroScreen() {
        LauncherCallbacks launcherCallbacks = this.mLauncherCallbacks;
        if (launcherCallbacks != null) {
            launcherCallbacks.getClass();
        }
        return false;
    }

    public boolean hasFirstRunActivity() {
        LauncherCallbacks launcherCallbacks = this.mLauncherCallbacks;
        if (launcherCallbacks != null) {
            launcherCallbacks.getClass();
        }
        return false;
    }

    public boolean hasRunFirstRunActivity() {
        return this.mSharedPrefs.getBoolean(FIRST_RUN_ACTIVITY_DISPLAYED, false);
    }

    public boolean hasSettings() {
        LauncherCallbacks launcherCallbacks = this.mLauncherCallbacks;
        if (launcherCallbacks == null) {
            return !getResources().getBoolean(R.bool.allow_rotation);
        }
        launcherCallbacks.getClass();
        return true;
    }

    public void hideAppsLibrary() {
        if (this.appsLibraryLayout != null) {
            ObjectAnimator objectAnimatorOfPropertyValuesHolder = LauncherAnimUtils.ofPropertyValuesHolder(this.appsLibraryLayout, PropertyValuesHolder.ofFloat("alpha", 0.0f), PropertyValuesHolder.ofFloat("scaleX", 0.9f), PropertyValuesHolder.ofFloat("scaleY", 0.9f));
            objectAnimatorOfPropertyValuesHolder.setInterpolator(new PathInterpolator(0.0f, 0.0f, 0.58f, 1.0f));
            objectAnimatorOfPropertyValuesHolder.addListener(new C0022a(12, this));
            objectAnimatorOfPropertyValuesHolder.setDuration(268L);
            this.appsLibraryLayout.setLayerType(2, null);
            objectAnimatorOfPropertyValuesHolder.start();
        }
    }

    public void hideWorkspaceSearchAndHotseat() {
        Workspace workspace = this.mWorkspace;
        if (workspace != null) {
            workspace.setAlpha(0.0f);
        }
        Hotseat hotseat = this.mHotseat;
        if (hotseat != null) {
            hotseat.setAlpha(0.0f);
        }
        View view = this.mPageIndicators;
        if (view != null) {
            view.setAlpha(0.0f);
        }
    }

    public void invalidateHasCustomContentToLeft() {
        Workspace workspace = this.mWorkspace;
        if (workspace == null || workspace.getScreenOrder().isEmpty()) {
            return;
        }
        if (!this.mWorkspace.U0() && hasCustomContentToLeft()) {
            this.mWorkspace.D0(0);
            populateCustomContentContainer();
        } else {
            if (!this.mWorkspace.U0() || hasCustomContentToLeft()) {
                return;
            }
            this.mWorkspace.h1(0);
        }
    }

    @Override // com.luutinhit.launcher6.LauncherModelCallbacks
    public boolean isAllAppsButtonRank(int i6) {
        Hotseat hotseat = this.mHotseat;
        return (hotseat == null || this.mDeviceProfile.inv.f16710b || i6 != hotseat.f15710p) ? false : true;
    }

    public boolean isAllAppsVisible() {
        return isAppsViewVisible();
    }

    public boolean isAppsViewVisible() {
        LauncherState launcherState = this.mState;
        LauncherState launcherState2 = LauncherState.f16046l;
        return launcherState == launcherState2 || this.mOnResumeState == launcherState2;
    }

    public boolean isDraggingEnabled() {
        return !isWorkspaceLoading();
    }

    public boolean isHotseatLayout(View view) {
        Objects.toString(view);
        Hotseat hotseat = this.mHotseat;
        return hotseat != null && view != null && (view instanceof CellLayout) && view == hotseat.getLayout();
    }

    public boolean isLauncherPreinstalled() {
        LauncherCallbacks launcherCallbacks = this.mLauncherCallbacks;
        if (launcherCallbacks != null) {
            launcherCallbacks.getClass();
            return false;
        }
        try {
            return (getPackageManager().getApplicationInfo(getComponentName().getPackageName(), 0).flags & 1) != 0;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isOnCustomContent() {
        return this.mWorkspace.Y0() || this.mHotseat.getTranslationX() != 0.0f;
    }

    public boolean isOpeningAppsLibrary() {
        Workspace workspace = this.mWorkspace;
        return workspace != null && workspace.Y0();
    }

    public boolean isOpeningEditMenu() {
        DragLayer dragLayer = this.mDragLayer;
        return dragLayer != null && dragLayer.isOpenEditMenu();
    }

    public boolean isOpeningFloatingMenu() {
        DragLayer dragLayer = this.mDragLayer;
        return dragLayer != null && dragLayer.isOpenFloatingMenu();
    }

    public boolean isOpeningFolder() {
        Workspace workspace = this.mWorkspace;
        return (workspace != null ? workspace.getOpenFolder() : null) != null;
    }

    public boolean isOpeningLeftPage() {
        Workspace workspace = this.mWorkspace;
        return workspace != null && workspace.Y0();
    }

    public boolean isOpeningSearchView() {
        SearchViewLayout searchViewLayout = this.mSearchView;
        if (searchViewLayout != null) {
            return searchViewLayout.f17630j == EnumC1218h.f3540j || searchViewLayout.m8357J();
        }
        return false;
    }

    public boolean isShaking() {
        return this.mIsShaking;
    }

    public boolean isWidgetsViewVisible() {
        LauncherState launcherState = this.mState;
        LauncherState launcherState2 = LauncherState.f16048n;
        return launcherState == launcherState2 || this.mOnResumeState == launcherState2 || this.mWidgetsView.getVisibility() == 0;
    }

    public boolean isWorkspaceLoading() {
        return this.mWorkspaceLoading;
    }

    public boolean isWorkspaceLocked() {
        return this.mWorkspaceLoading || this.mWaitingForResult;
    }

    public boolean launcherCallbacksProvidesSearch() {
        LauncherCallbacks launcherCallbacks = this.mLauncherCallbacks;
        if (launcherCallbacks == null) {
            return false;
        }
        launcherCallbacks.getClass();
        return false;
    }

    public void lockAllApps() {
    }

    /* JADX WARN: Code duplicated, block: B:14:0x002f  */
    /* JADX WARN: Code duplicated, block: B:15:0x0031 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:16:0x0033  */
    @TargetApi(18)
    public void lockScreenOrientation() {
        com.luutinhit.launcher6.JadxSupport.useOriginalBytecode(); // jadx flagged this method; the original bytecode runs
        if (this.mRotationEnabled) {
            if (Utilities.f16755p) {
                setRequestedOrientation(14);
                return;
            }
            int i6 = getResources().getConfiguration().orientation;
            Display defaultDisplay = getWindowManager().getDefaultDisplay();
            int rotation = defaultDisplay.getRotation();
            if (rotation != 0) {
                if (rotation == 1) {
                    if (i6 == 2) {
                        i6 = 1;
                    } else {
                        i6 = 2;
                    }
                } else if (rotation != 2) {
                    if (rotation != 3) {
                        i6 = 2;
                    } else if (i6 == 2) {
                        i6 = 1;
                    } else {
                        i6 = 2;
                    }
                }
            }
            setRequestedOrientation(new int[]{1, 0, 9, 8}[(defaultDisplay.getRotation() + (i6 != 2 ? 0 : 1)) % 4]);
        }
    }

    public void moveToCustomContentScreen(boolean z5) {
        closeFolder();
        Workspace workspace = this.mWorkspace;
        if (workspace.U0()) {
            int iQ0 = workspace.Q0(-301L);
            if (z5) {
                workspace.l0(iQ0);
            } else {
                workspace.setCurrentPage(iQ0);
            }
            View childAt = workspace.getChildAt(iQ0);
            if (childAt != null) {
                childAt.requestFocus();
            }
        }
        workspace.f23432V0.getDragLayer().clearAllResizeFrames();
    }

    public void moveWorkspaceToDefaultScreen() {
        this.mWorkspace.post(new LauncherWorkspaceRunnable(this, 1));
    }

    @Override // com.luutinhit.launcher6.LauncherModelCallbacks
    public void notifyWidgetProvidersChanged() {
        Workspace workspace = this.mWorkspace;
        if (workspace == null || !workspace.getState().f15312j) {
            return;
        }
        LauncherModel launcherModel = this.mModel;
        boolean z5 = this.mWidgetsView.f23527a0.mo893c() == 0;
        launcherModel.getClass();
        LauncherModel.m7567y(new MergedLoaderRunnable(launcherModel, z5, this));
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01fb A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:101:0x01fd  */
    @Override // android.app.Activity
    public void onActivityResult(int i6, int i7, final Intent intent) {
        com.luutinhit.launcher6.JadxSupport.useOriginalBytecode(); // jadx flagged this method; the original bytecode runs
        SearchViewLayout searchViewLayout;
        int i8 = 12;
        int i9 = 16;
        int i10 = 1;
        int i11 = 0;
        Objects.toString(intent);
        Objects.toString(intent);
        setWaitingForResult(false);
        int i12 = this.mPendingAddWidgetId;
        this.mPendingAddWidgetId = -1;
        LauncherPageRunnable launcherPageRunnable = new LauncherPageRunnable(this, i7);
        if (i6 == 11) {
            int intExtra = intent != null ? intent.getIntExtra("appWidgetId", -1) : -1;
            if (i7 == 0) {
                completeTwoStageWidgetDrop(0, intExtra);
                this.mWorkspace.i1(true, launcherPageRunnable, 500, false);
                return;
            } else {
                if (i7 == -1) {
                    addAppWidgetImpl(intExtra, this.mPendingAddInfo, null, this.mPendingAddWidgetInfo, 500);
                    return;
                }
                return;
            }
        }
        if (i6 == 10) {
            if (i7 == -1 && this.mWorkspace.X0()) {
                Workspace workspace = this.mWorkspace;
                workspace.setCurrentPage(workspace.getPageNearestToCenterOfScreen());
                showWorkspace(false);
                return;
            }
            return;
        }
        if (i6 == 42 && i7 == -1) {
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("android.speech.extra.RESULTS");
            Objects.toString(stringArrayListExtra);
            if (stringArrayListExtra == null || stringArrayListExtra.isEmpty() || (searchViewLayout = this.mSearchView) == null) {
                return;
            }
            searchViewLayout.setEditText(stringArrayListExtra.get(0));
            return;
        }
        if (i6 == 1002 && i7 == -1) {
            int i13 = PhotoWidget_2x2.f16696r;
            if (intent != null) {
                int i14 = PhotoWidget_2x2.f16696r;
                PhotoWidget_2x2.f16696r = -1;
                if (i14 == -1) {
                    return;
                }
                Context applicationContext = getApplicationContext();
                C2188y c2188y = new C2188y(i9, new InterfaceC2834a() { // from class: x3.a
                    @Override // p136u4.InterfaceC2834a
                    public final void run() {
                        int i15 = PhotoWidget_2x2.f16696r;
                        ArrayList arrayList = new ArrayList();
                        Intent intent2 = intent;
                        if (intent2.getClipData() != null) {
                            int itemCount = intent2.getClipData().getItemCount();
                            for (int i16 = 0; i16 < itemCount; i16++) {
                                Uri uri = intent2.getClipData().getItemAt(i16).getUri();
                                if (uri != null) {
                                    arrayList.add(uri);
                                }
                            }
                        } else if (intent2.getData() != null) {
                            arrayList.add(intent2.getData());
                        }
                        if (arrayList.isEmpty()) {
                            return;
                        }
                        HashSet hashSet = new HashSet();
                        int size = arrayList.size();
                        int i17 = 0;
                        while (true) {
                            Context context = applicationContext;
                            if (i17 >= size) {
                                context.getSharedPreferences("photo_widget_prefs", 0).edit().putStringSet("selected_photo_uris_" + i14, hashSet).apply();
                                return;
                            }
                            Object obj = arrayList.get(i17);
                            i17++;
                            Uri uri2 = (Uri) obj;
                            try {
                                context.getContentResolver().takePersistableUriPermission(uri2, 1);
                            } catch (Exception unused) {
                                Objects.toString(uri2);
                            }
                            hashSet.add(uri2.toString());
                        }
                    }
                });
                AbstractC2620e abstractC2620e = AbstractC0212f.f640a;
                AbstractC2934a.m10120a(abstractC2620e, "scheduler is null");
                C2973a c2973a = new C2973a(new C0367w(7), new C0367w(6));
                try {
                    RunnableC0027b runnableC0027b = new RunnableC0027b(c2973a, c2188y);
                    c2973a.mo38c(runnableC0027b);
                    InterfaceC2749b interfaceC2749bM9550b = abstractC2620e.m9550b(runnableC0027b);
                    C2750c c2750c = runnableC0027b.f66l;
                    c2750c.getClass();
                    EnumC2867a.m10032c(c2750c, interfaceC2749bM9550b);
                    return;
                } catch (NullPointerException e) {
                    throw e;
                } catch (Throwable th) {
                    AbstractC1314a.m2681A(th);
                    AbstractC1690d.m3673F(th);
                    NullPointerException nullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
                    nullPointerException.initCause(th);
                    throw nullPointerException;
                }
            }
            return;
        }
        if (i6 == 1003 && i7 == -1) {
            int i15 = PictureWidget_2x2.f17190q;
            Objects.toString(intent);
            if (intent == null) {
                return;
            }
            C2188y c2188y2 = new C2188y(i9, new C0546e(i11, intent, getApplicationContext()));
            AbstractC2620e abstractC2620e2 = AbstractC0212f.f640a;
            AbstractC2934a.m10120a(abstractC2620e2, "scheduler is null");
            C2973a c2973a2 = new C2973a(new C0367w(2), new C0367w(i10));
            try {
                RunnableC0027b runnableC0027b2 = new RunnableC0027b(c2973a2, c2188y2);
                c2973a2.mo38c(runnableC0027b2);
                InterfaceC2749b interfaceC2749bM9550b2 = abstractC2620e2.m9550b(runnableC0027b2);
                C2750c c2750c2 = runnableC0027b2.f66l;
                c2750c2.getClass();
                EnumC2867a.m10032c(c2750c2, interfaceC2749bM9550b2);
                return;
            } catch (NullPointerException e5) {
                throw e5;
            } catch (Throwable th2) {
                AbstractC1314a.m2681A(th2);
                AbstractC1690d.m3673F(th2);
                NullPointerException nullPointerException2 = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
                nullPointerException2.initCause(th2);
                throw nullPointerException2;
            }
        }
        boolean z5 = i6 == 9 || i6 == 5;
        boolean zIsWorkspaceLocked = isWorkspaceLocked();
        if (!z5) {
            if (i6 == 12) {
                if (i7 == -1) {
                    PendingAddArguments pendingAddArgumentsPreparePendingAddArgs = preparePendingAddArgs(i6, intent, i12, this.mPendingAddInfo);
                    if (zIsWorkspaceLocked) {
                        sPendingAddItem = pendingAddArgumentsPreparePendingAddArgs;
                        return;
                    } else {
                        completeAdd(pendingAddArgumentsPreparePendingAddArgs);
                        return;
                    }
                }
                return;
            }
            if (i7 == -1) {
                PendingAddItemInfo pendingAddItemInfo = this.mPendingAddInfo;
                if (pendingAddItemInfo.container != -1) {
                    PendingAddArguments pendingAddArgumentsPreparePendingAddArgs2 = preparePendingAddArgs(i6, intent, -1, pendingAddItemInfo);
                    if (isWorkspaceLocked()) {
                        sPendingAddItem = pendingAddArgumentsPreparePendingAddArgs2;
                    } else {
                        completeAdd(pendingAddArgumentsPreparePendingAddArgs2);
                        this.mWorkspace.i1(true, launcherPageRunnable, 500, false);
                    }
                } else if (i7 == 0) {
                    this.mWorkspace.i1(true, launcherPageRunnable, 500, false);
                }
            } else if (i7 == 0) {
                this.mWorkspace.i1(true, launcherPageRunnable, 500, false);
            }
            this.mDragLayer.clearAnimatedView();
            return;
        }
        int intExtra2 = intent != null ? intent.getIntExtra("appWidgetId", -1) : -1;
        if (intExtra2 >= 0) {
            i12 = intExtra2;
        }
        if (i12 < 0 || i7 == 0) {
            completeTwoStageWidgetDrop(0, i12);
            LauncherWorkspaceTask launcherWorkspaceTask = new LauncherWorkspaceTask(this, i8);
            if (zIsWorkspaceLocked) {
                this.mWorkspace.postDelayed(launcherWorkspaceTask, 500L);
                return;
            } else {
                this.mWorkspace.i1(true, launcherWorkspaceTask, 500, false);
                return;
            }
        }
        if (zIsWorkspaceLocked) {
            sPendingAddItem = preparePendingAddArgs(i6, intent, i12, this.mPendingAddInfo);
            return;
        }
        PendingAddItemInfo pendingAddItemInfo2 = this.mPendingAddInfo;
        if (pendingAddItemInfo2.container == -100) {
            long jC0 = pendingAddItemInfo2.screenId;
            if (this.mWorkspace.T0(jC0) == null) {
                this.mWorkspace.u0();
                jC0 = this.mWorkspace.C0();
            }
            pendingAddItemInfo2.screenId = jC0;
        }
        CellLayout cellLayoutT0 = this.mWorkspace.T0(this.mPendingAddInfo.screenId);
        cellLayoutT0.setDropPending(true);
        this.mWorkspace.i1(true, new CompleteAddRunnable(this, i7, i12, cellLayoutT0), 500, false);
    }

    @Override // com.luutinhit.launcher6.LauncherModelCallbacks
    public void onAllAppsChanged(ArrayList arrayList) {
        this.mSearchView.m8358K(arrayList);
    }

    @Override // com.luutinhit.launcher6.LauncherProviderChangeListener
    public void onAppWidgetHostReset() {
        LauncherAppWidgetHost launcherAppWidgetHost = this.mAppWidgetHost;
        if (launcherAppWidgetHost != null) {
            launcherAppWidgetHost.startListening();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        intentFilter.addAction("com.luutinhit.launcherios.ACTION_SET_BACKGROUND");
        intentFilter.addAction("com.luutinhit.launcherios.ACTION_HIDDEN_APPS_IN_WORKSPACE");
        intentFilter.addAction("com.luutinhit.launcherios.ACTION_RELOAD_WIDGET");
        intentFilter.addAction("com.luutinhit.launcherios.ACTION_FORCE_RELOAD_LAUNCHER");
        intentFilter.addAction("com.luutinhit.SCREEN_UNLOCK");
        if (Utilities.f16749j) {
            registerReceiver(this.mReceiver, intentFilter, 2);
        } else {
            registerReceiver(this.mReceiver, intentFilter);
        }
        View decorView = getWindow().getDecorView();
        if (FirstFrameAnimatorHelper.f16701o != null) {
            decorView.getViewTreeObserver().removeOnDrawListener(FirstFrameAnimatorHelper.f16701o);
        }
        FirstFrameDrawListener firstFrameDrawListener = new FirstFrameDrawListener();
        System.currentTimeMillis();
        FirstFrameAnimatorHelper.f16701o = firstFrameDrawListener;
        decorView.getViewTreeObserver().addOnDrawListener(FirstFrameAnimatorHelper.f16701o);
        FirstFrameAnimatorHelper.f16703q = true;
        this.mAttached = true;
        this.mVisible = true;
    }

    @Override // android.app.Activity
    @SuppressLint({"GestureBackNavigation"})
    public void onBackPressed() {
        closeAllPanels();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z5;
        Objects.toString(view);
        Objects.toString(view);
        if (view != null) {
            Object tag = view.getTag();
            Objects.toString(tag);
            if (tag == null && this.mIsShaking) {
                cancelShakingAnimation();
                return;
            }
            if (tag == null && this.mWorkspace.X0()) {
                showWorkspace(true);
                return;
            }
            if (tag != null) {
                if (this.mIsShaking && (((z5 = tag instanceof ShortcutInfo)) || (tag instanceof AppInfo))) {
                    view.clearAnimation();
                    Pair<ComponentName, Integer> appInfoFlags = getAppInfoFlags(tag);
                    if (appInfoFlags == null && z5) {
                        ShortcutInfo shortcutInfo = (ShortcutInfo) tag;
                        if (shortcutInfo.itemType == 1) {
                            removeItem(view, shortcutInfo, true);
                            return;
                        }
                        return;
                    }
                    if (appInfoFlags != null) {
                        if ((((Integer) appInfoFlags.second).intValue() & 1) == 0) {
                            showDeleteOrUninstallDialog(true, tag, appInfoFlags);
                            return;
                        }
                        if (z5) {
                            startApplicationUninstallActivity((ComponentName) appInfoFlags.first, ((Integer) appInfoFlags.second).intValue(), ((ShortcutInfo) tag).user);
                            return;
                        } else if (tag instanceof AppInfo) {
                            startApplicationUninstallActivity((ComponentName) appInfoFlags.first, ((Integer) appInfoFlags.second).intValue(), ((AppInfo) tag).user);
                            return;
                        } else {
                            removeAppWidget((LauncherAppWidgetInfo) tag);
                            return;
                        }
                    }
                    return;
                }
                if (view.getWindowToken() == null) {
                    return;
                }
                this.mWorkspace.getClass();
                if (view instanceof Workspace) {
                    if (this.mWorkspace.X0()) {
                        showWorkspace(true);
                        return;
                    }
                    return;
                }
                if ((view instanceof CellLayout) && this.mWorkspace.X0()) {
                    showWorkspace(this.mWorkspace.indexOfChild(view), true);
                }
                if (tag instanceof ShortcutInfo) {
                    onClickAppShortcut(view);
                    return;
                }
                if (tag instanceof FolderInfo) {
                    if (view instanceof FolderIcon) {
                        onClickFolderIcon(view);
                    }
                } else if (tag instanceof AppInfo) {
                    startAppShortcutOrInfoActivity(view);
                } else if ((tag instanceof LauncherAppWidgetInfo) && (view instanceof PendingAppWidgetHostView)) {
                    onClickPendingWidget((PendingAppWidgetHostView) view);
                }
            }
        }
    }

    public void onClickAddWidgetButton(View view) {
        openEditMenu(view);
    }

    public void onClickAllAppsButton(View view) {
        Objects.toString(view);
        if (isAppsViewVisible()) {
            return;
        }
        showAppsView(true, false, true, false);
        LauncherCallbacks launcherCallbacks = this.mLauncherCallbacks;
        if (launcherCallbacks != null) {
            launcherCallbacks.getClass();
        }
    }

    public void onClickAppShortcut(View view) {
        Objects.toString(view);
        Object tag = view.getTag();
        if (!(tag instanceof ShortcutInfo)) {
            throw new IllegalArgumentException("Input must be a Shortcut");
        }
        ShortcutInfo shortcutInfo = (ShortcutInfo) tag;
        int i6 = shortcutInfo.f16559G;
        if (i6 != 0 && (i6 & 4) == 0 && (i6 & 8) == 0) {
            Toast.makeText(this, (i6 & 1) != 0 ? R.string.safemode_shortcut_error : R.string.activity_not_available, 0).show();
        } else if ((view instanceof BubbleTextView) && shortcutInfo.hasStatusFlag(3) && !shortcutInfo.hasStatusFlag(4)) {
            showBrokenAppInstallDialog(shortcutInfo.getTargetComponent().getPackageName(), new LauncherDialogClickListener(this, view, 1));
        } else {
            startAppShortcutOrInfoActivity(view);
        }
    }

    public void onClickFolderIcon(View view) {
        Objects.toString(view);
        if (view instanceof FolderIcon) {
            FolderIcon folderIcon = (FolderIcon) view;
            if (getWorkspace().getTranslationY() != 0.0f) {
                return;
            }
            if (this.mIsShaking) {
                view.clearAnimation();
            }
            FolderInfo folderInfo = folderIcon.getFolderInfo();
            Workspace workspace = this.mWorkspace;
            workspace.getClass();
            Objects.toString(folderInfo);
            Folder folder = (Folder) workspace.N0(new MergedItemCallbacks(4, folderInfo));
            int i6 = 0;
            if (folderInfo.f15523B && folder == null) {
                folderInfo.f15523B = false;
            }
            if (!folderInfo.f15523B && !folderIcon.getFolder().f15617T) {
                closeFolder();
                openFolder(folderIcon);
                return;
            }
            if (folder != null) {
                Workspace workspace2 = this.mWorkspace;
                workspace2.getClass();
                ViewParent parent = folder.getParent();
                int childCount = workspace2.getChildCount();
                while (true) {
                    if (i6 >= childCount) {
                        i6 = -1;
                        break;
                    } else if (parent == workspace2.getChildAt(i6)) {
                        break;
                    } else {
                        i6++;
                    }
                }
                closeFolder(folder, true);
                if (i6 != this.mWorkspace.getCurrentPage()) {
                    closeFolder();
                    openFolder(folderIcon);
                }
            }
        }
    }

    public void onClickPendingWidget(PendingAppWidgetHostView pendingAppWidgetHostView) {
        if (this.mIsSafeModeEnabled) {
            Toast.makeText(this, R.string.safemode_widget_error, 0).show();
            return;
        }
        LauncherAppWidgetInfo launcherAppWidgetInfo = (LauncherAppWidgetInfo) pendingAppWidgetHostView.getTag();
        int i6 = pendingAppWidgetHostView.f16192I.f16570C;
        if ((i6 & 2) != 0 || (i6 & 4) == 0) {
            int i7 = launcherAppWidgetInfo.f16571D;
            ComponentName componentName = launcherAppWidgetInfo.providerName;
            if (i7 >= 0) {
                startActivitySafely(pendingAppWidgetHostView, LauncherModel.getMarketIntent(componentName.getPackageName()), launcherAppWidgetInfo);
                return;
            } else {
                String packageName = componentName.getPackageName();
                showBrokenAppInstallDialog(packageName, new MergedDialogClickListener(this, pendingAppWidgetHostView, packageName, launcherAppWidgetInfo, 0));
                return;
            }
        }
        int i8 = launcherAppWidgetInfo.f16568A;
        LauncherAppWidgetProviderInfo launcherAppWidgetProviderInfoM9645g = this.mAppWidgetManager.m9645g(i8);
        if (launcherAppWidgetProviderInfoM9645g != null) {
            this.mPendingAddWidgetInfo = launcherAppWidgetProviderInfoM9645g;
            this.mPendingAddInfo.copyFrom(launcherAppWidgetInfo);
            this.mPendingAddWidgetId = i8;
            AbstractC2659c.m9639f(this).mo9650l(launcherAppWidgetProviderInfoM9645g, launcherAppWidgetInfo.f16568A, this, this.mAppWidgetHost, 12);
        }
    }

    public void onClickSettingsButton(View view) {
        Objects.toString(view);
        LauncherCallbacks launcherCallbacks = this.mLauncherCallbacks;
        if (launcherCallbacks == null) {
            startActivity(new Intent(this, (Class<?>) SettingsActivity.class));
            return;
        }
        IOSLauncherCallbacks iOSLauncherCallbacks = (IOSLauncherCallbacks) launcherCallbacks;
        iOSLauncherCallbacks.getClass();
        IOSLauncher iOSLauncher = iOSLauncherCallbacks.f16589a;
        iOSLauncher.startActivity(new Intent(iOSLauncher, (Class<?>) MainActivity.class));
    }

    @Override // p126s3.InterfaceC2744c
    public void onCloseEditMenu() {
        this.showingEditMenu = false;
    }

    @Override // p158z3.InterfaceC3077h
    public void onCloseFloatingMenu(View view) {
        this.showingFloatingMenu = false;
        if (view instanceof BubbleTextView) {
            ((BubbleTextView) view).m7598G();
        } else if (view instanceof LauncherAppWidgetHostView) {
            ((LauncherAppWidgetHostView) view).m8051a();
        }
        this.mFloatingBackgroundView.animateBlurAlpha(0, true);
    }

    /* JADX WARN: Code duplicated, block: B:22:0x00d9  */
    /* JADX WARN: Type inference failed for: r2v7, types: [com.luutinhit.launcher6.s1] */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        com.luutinhit.launcher6.JadxSupport.useOriginalBytecode(); // jadx flagged this method; the original bytecode runs
        boolean z5;
        boolean z6 = false;
        int i6;
        int i7 = 0;
        int i8 = 1;
        Objects.toString(bundle);
        super.onCreate(bundle);
        Context applicationContext = getApplicationContext();
        Context context = LauncherAppState.f16216i;
        if (context != null) {
            Objects.toString(context);
            Objects.toString(applicationContext);
        }
        LauncherAppState.f16216i = applicationContext.getApplicationContext();
        LauncherAppState launcherAppState = LauncherAppState.getInstance();
        launcherAppState.f16224g = this;
        int i9 = getResources().getConfiguration().orientation;
        InvariantDeviceProfile invariantDeviceProfile = launcherAppState.f16222e;
        DeviceProfile deviceProfile = i9 == 2 ? invariantDeviceProfile.f16725q : invariantDeviceProfile.f16726r;
        this.mDeviceProfile = deviceProfile;
        C0056Y c0056y = deviceProfile.inv.f16734z;
        this.mTinyDB = c0056y;
        c0056y.m140j(this);
        this.mVibrator = (Vibrator) getSystemService("vibrator");
        C0056Y c0056y2 = this.mTinyDB;
        c0056y2.getClass();
        LauncherModel.sBgWidgetProviders = new HashSet(Arrays.asList(TextUtils.split(c0056y2.f137a.getString("list_hidden_apps", ""), "‚‗‚")));
        this.autoRearrange = this.mTinyDB.m131a("auto_rearrange");
        this.isDarkMode = this.mTinyDB.m131a("dark_mode");
        this.isUnlockAnim = this.mTinyDB.f137a.getBoolean("unlock_animation", true);
        this.isOpenCloseAnim = this.mTinyDB.f137a.getBoolean("open_close_animation", true);
        InvariantDeviceProfile invariantDeviceProfile2 = this.mDeviceProfile.inv;
        this.isHideNavigation = invariantDeviceProfile2 != null && invariantDeviceProfile2.f16732x;
        this.isShowAppsLibraryGuide = this.mTinyDB.f137a.getBoolean("app_library_dialog_guide", true);
        this.isUseLiquidGlass = this.mTinyDB.f137a.getBoolean("preference_liquid_glass", false);
        Rect rect = Utilities.sOldBounds;
        if (Build.VERSION.SDK_INT < 33) {
            z5 = false;
        } else {
            try {
                AbstractC0839e.m1880m();
                AbstractC0839e.m1872e();
                z5 = true;
            } catch (Throwable unused) {
                z5 = false;
            }
        }
        this.isRuntimeRenderSupport = z5;
        if (Build.VERSION.SDK_INT < 33) {
            z6 = false;
        } else {
            try {
                Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                if (RenderEffect.createBlurEffect(1.0f, 1.0f, Shader.TileMode.CLAMP) != null) {
                    z6 = true;
                } else {
                    z6 = false;
                }
            } catch (Throwable unused2) {
            }
        }
        this.isRenderEffectSupport = z6;
        this.isRTL = Utilities.isRtl(getResources());
        this.mSharedPrefs = getSharedPreferences("com.luutinhit.launcher6.prefs", 0);
        this.mIsSafeModeEnabled = getPackageManager().isSafeMode();
        this.mModel = launcherAppState.m7931d(this);
        this.mIconCache = launcherAppState.f16219b;
        this.screenWidth = this.mDeviceProfile.getCurrentWidth();
        this.screenHeight = this.mDeviceProfile.getCurrentHeight();
        this.mDragController = new DragController(this);
        this.mBlurWallpaperProvider = new C2615e(this);
        this.mInflater = getLayoutInflater();
        IconTransitionHelper iconTransitionHelper = new IconTransitionHelper();
        iconTransitionHelper.f15746c = new int[2];
        iconTransitionHelper.f15744a = this;
        this.mStateTransitionAnimation = iconTransitionHelper;
        DeviceProfile deviceProfile2 = this.mDeviceProfile;
        int i10 = deviceProfile2.f16024x;
        int i11 = deviceProfile2.f16025y;
        SharedPreferencesOnSharedPreferenceChangeListenerC3078i sharedPreferencesOnSharedPreferenceChangeListenerC3078i = new SharedPreferencesOnSharedPreferenceChangeListenerC3078i(this, null);
        sharedPreferencesOnSharedPreferenceChangeListenerC3078i.f22131J = false;
        sharedPreferencesOnSharedPreferenceChangeListenerC3078i.f22132K = null;
        sharedPreferencesOnSharedPreferenceChangeListenerC3078i.f22130I = i10;
        sharedPreferencesOnSharedPreferenceChangeListenerC3078i.f22123B = this;
        C0056Y tinyDB = getTinyDB();
        sharedPreferencesOnSharedPreferenceChangeListenerC3078i.f22124C = tinyDB;
        tinyDB.m140j(sharedPreferencesOnSharedPreferenceChangeListenerC3078i);
        if (Utilities.f16744e) {
            sharedPreferencesOnSharedPreferenceChangeListenerC3078i.f22132K = (LauncherApps) getSystemService("launcherapps");
        }
        sharedPreferencesOnSharedPreferenceChangeListenerC3078i.setFocusable(true);
        sharedPreferencesOnSharedPreferenceChangeListenerC3078i.setClickable(true);
        sharedPreferencesOnSharedPreferenceChangeListenerC3078i.f22131J = tinyDB.m131a("dark_mode");
        sharedPreferencesOnSharedPreferenceChangeListenerC3078i.setClipToOutline(true);
        sharedPreferencesOnSharedPreferenceChangeListenerC3078i.setDarkModeBackgroundColor(sharedPreferencesOnSharedPreferenceChangeListenerC3078i.f22131J ? -1726211044 : -1713447202);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.icon_round_corner);
        boolean z7 = sharedPreferencesOnSharedPreferenceChangeListenerC3078i.f22131J;
        sharedPreferencesOnSharedPreferenceChangeListenerC3078i.f16432x = false;
        sharedPreferencesOnSharedPreferenceChangeListenerC3078i.f16420l = dimensionPixelSize;
        sharedPreferencesOnSharedPreferenceChangeListenerC3078i.f16427s = true;
        sharedPreferencesOnSharedPreferenceChangeListenerC3078i.f16428t = true;
        sharedPreferencesOnSharedPreferenceChangeListenerC3078i.f16429u = true;
        sharedPreferencesOnSharedPreferenceChangeListenerC3078i.f16430v = true;
        sharedPreferencesOnSharedPreferenceChangeListenerC3078i.setDarkModeTransparentBackground(z7);
        sharedPreferencesOnSharedPreferenceChangeListenerC3078i.m8028a();
        sharedPreferencesOnSharedPreferenceChangeListenerC3078i.invalidate();
        sharedPreferencesOnSharedPreferenceChangeListenerC3078i.setFocusable(true);
        sharedPreferencesOnSharedPreferenceChangeListenerC3078i.setFocusableInTouchMode(true);
        sharedPreferencesOnSharedPreferenceChangeListenerC3078i.setOrientation(1);
        DragLayerLayoutParams dragLayerLayoutParams = new DragLayerLayoutParams(i10, i11);
        dragLayerLayoutParams.f16210d = true;
        ((FrameLayout.LayoutParams) dragLayerLayoutParams).gravity = 8388659;
        ((FrameLayout.LayoutParams) dragLayerLayoutParams).bottomMargin = -2;
        sharedPreferencesOnSharedPreferenceChangeListenerC3078i.setLayoutParams(dragLayerLayoutParams);
        sharedPreferencesOnSharedPreferenceChangeListenerC3078i.f22133L = new LinearLayout.LayoutParams(-1, sharedPreferencesOnSharedPreferenceChangeListenerC3078i.getResources().getDimensionPixelSize(R.dimen.shortcut_info_item_height));
        sharedPreferencesOnSharedPreferenceChangeListenerC3078i.f22134M = new LinearLayout.LayoutParams(-1, sharedPreferencesOnSharedPreferenceChangeListenerC3078i.getResources().getDimensionPixelSize(R.dimen.shortcut_padding_item));
        View view = new View(this);
        sharedPreferencesOnSharedPreferenceChangeListenerC3078i.f22138Q = view;
        view.setId(R.id.padding_shortcut_item);
        view.setBackgroundColor(sharedPreferencesOnSharedPreferenceChangeListenerC3078i.f22131J ? 855638016 : -1714763062);
        sharedPreferencesOnSharedPreferenceChangeListenerC3078i.m10338c();
        this.mFloatingMenu = sharedPreferencesOnSharedPreferenceChangeListenerC3078i;
        sharedPreferencesOnSharedPreferenceChangeListenerC3078i.setOnListenerFloatingMenu(this);
        DeviceProfile deviceProfile3 = this.mDeviceProfile;
        int i12 = deviceProfile3.f16024x;
        int i13 = deviceProfile3.f16025y;
        SharedPreferencesOnSharedPreferenceChangeListenerC2745d sharedPreferencesOnSharedPreferenceChangeListenerC2745d = new SharedPreferencesOnSharedPreferenceChangeListenerC2745d(this, null);
        sharedPreferencesOnSharedPreferenceChangeListenerC2745d.f21094H = false;
        sharedPreferencesOnSharedPreferenceChangeListenerC2745d.f21093G = i12;
        sharedPreferencesOnSharedPreferenceChangeListenerC2745d.f21088B = this;
        C0056Y tinyDB2 = getTinyDB();
        sharedPreferencesOnSharedPreferenceChangeListenerC2745d.f21089C = tinyDB2;
        tinyDB2.m140j(sharedPreferencesOnSharedPreferenceChangeListenerC2745d);
        sharedPreferencesOnSharedPreferenceChangeListenerC2745d.setFocusable(true);
        sharedPreferencesOnSharedPreferenceChangeListenerC2745d.setClickable(true);
        sharedPreferencesOnSharedPreferenceChangeListenerC2745d.f21094H = tinyDB2.m131a("dark_mode");
        sharedPreferencesOnSharedPreferenceChangeListenerC2745d.setClipToOutline(true);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.icon_round_corner);
        boolean z8 = sharedPreferencesOnSharedPreferenceChangeListenerC2745d.f21094H;
        sharedPreferencesOnSharedPreferenceChangeListenerC2745d.f16432x = false;
        sharedPreferencesOnSharedPreferenceChangeListenerC2745d.f16420l = dimensionPixelSize2;
        sharedPreferencesOnSharedPreferenceChangeListenerC2745d.f16427s = true;
        sharedPreferencesOnSharedPreferenceChangeListenerC2745d.f16428t = true;
        sharedPreferencesOnSharedPreferenceChangeListenerC2745d.f16429u = true;
        sharedPreferencesOnSharedPreferenceChangeListenerC2745d.f16430v = true;
        sharedPreferencesOnSharedPreferenceChangeListenerC2745d.setDarkModeTransparentBackground(z8);
        sharedPreferencesOnSharedPreferenceChangeListenerC2745d.m8028a();
        sharedPreferencesOnSharedPreferenceChangeListenerC2745d.invalidate();
        sharedPreferencesOnSharedPreferenceChangeListenerC2745d.setBackground(sharedPreferencesOnSharedPreferenceChangeListenerC2745d.f21094H);
        sharedPreferencesOnSharedPreferenceChangeListenerC2745d.setFocusable(true);
        sharedPreferencesOnSharedPreferenceChangeListenerC2745d.setFocusableInTouchMode(true);
        sharedPreferencesOnSharedPreferenceChangeListenerC2745d.setOrientation(1);
        DragLayerLayoutParams dragLayerLayoutParams2 = new DragLayerLayoutParams(i12, i13);
        dragLayerLayoutParams2.f16210d = true;
        ((FrameLayout.LayoutParams) dragLayerLayoutParams2).gravity = 8388659;
        ((FrameLayout.LayoutParams) dragLayerLayoutParams2).bottomMargin = -2;
        sharedPreferencesOnSharedPreferenceChangeListenerC2745d.setLayoutParams(dragLayerLayoutParams2);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, sharedPreferencesOnSharedPreferenceChangeListenerC2745d.getResources().getDimensionPixelSize(R.dimen.shortcut_info_item_height));
        new LinearLayout.LayoutParams(-1, sharedPreferencesOnSharedPreferenceChangeListenerC2745d.getResources().getDimensionPixelSize(R.dimen.shortcut_padding_item));
        sharedPreferencesOnSharedPreferenceChangeListenerC2745d.f21092F = getDeviceProfile().getCurrentWidth();
        getDeviceProfile().getCurrentHeight();
        int i14 = getDeviceProfile().f15978D;
        sharedPreferencesOnSharedPreferenceChangeListenerC2745d.f21090D = i14;
        sharedPreferencesOnSharedPreferenceChangeListenerC2745d.f21091E = i14 / 8;
        C3079j c3079j = new C3079j(this, sharedPreferencesOnSharedPreferenceChangeListenerC2745d.f21094H, false);
        sharedPreferencesOnSharedPreferenceChangeListenerC2745d.f21095I = c3079j;
        c3079j.setId(R.id.add_widget_menu);
        sharedPreferencesOnSharedPreferenceChangeListenerC2745d.f21095I.setText(R.string.add_widget);
        sharedPreferencesOnSharedPreferenceChangeListenerC2745d.f21095I.setIcon(2131231128);
        sharedPreferencesOnSharedPreferenceChangeListenerC2745d.f21095I.setOnClickListener(new View.OnClickListener() { // from class: s3.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                switch (i7) {
                    case 0:
                        SharedPreferencesOnSharedPreferenceChangeListenerC2745d sharedPreferencesOnSharedPreferenceChangeListenerC2745d2 = sharedPreferencesOnSharedPreferenceChangeListenerC2745d;
                        sharedPreferencesOnSharedPreferenceChangeListenerC2745d2.m9831b();
                        sharedPreferencesOnSharedPreferenceChangeListenerC2745d2.postOnAnimation(new RunnableC2743b(sharedPreferencesOnSharedPreferenceChangeListenerC2745d2, 0));
                        break;
                    default:
                        SharedPreferencesOnSharedPreferenceChangeListenerC2745d sharedPreferencesOnSharedPreferenceChangeListenerC2745d3 = sharedPreferencesOnSharedPreferenceChangeListenerC2745d;
                        sharedPreferencesOnSharedPreferenceChangeListenerC2745d3.m9831b();
                        sharedPreferencesOnSharedPreferenceChangeListenerC2745d3.postOnAnimation(new RunnableC2743b(sharedPreferencesOnSharedPreferenceChangeListenerC2745d3, 2));
                        break;
                }
            }
        });
        sharedPreferencesOnSharedPreferenceChangeListenerC2745d.addView(sharedPreferencesOnSharedPreferenceChangeListenerC2745d.f21095I, 0, layoutParams);
        C3079j c3079j2 = new C3079j(this, sharedPreferencesOnSharedPreferenceChangeListenerC2745d.f21094H, false);
        sharedPreferencesOnSharedPreferenceChangeListenerC2745d.f21096J = c3079j2;
        c3079j2.setId(R.id.customize_color_icon_menu);
        sharedPreferencesOnSharedPreferenceChangeListenerC2745d.f21096J.setText(R.string.customize);
        sharedPreferencesOnSharedPreferenceChangeListenerC2745d.f21096J.setIcon(R.drawable.ic_rearrange_apps);
        sharedPreferencesOnSharedPreferenceChangeListenerC2745d.f21096J.setOnClickListener(new View.OnClickListener() { // from class: s3.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                switch (i8) {
                    case 0:
                        SharedPreferencesOnSharedPreferenceChangeListenerC2745d sharedPreferencesOnSharedPreferenceChangeListenerC2745d2 = sharedPreferencesOnSharedPreferenceChangeListenerC2745d;
                        sharedPreferencesOnSharedPreferenceChangeListenerC2745d2.m9831b();
                        sharedPreferencesOnSharedPreferenceChangeListenerC2745d2.postOnAnimation(new RunnableC2743b(sharedPreferencesOnSharedPreferenceChangeListenerC2745d2, 0));
                        break;
                    default:
                        SharedPreferencesOnSharedPreferenceChangeListenerC2745d sharedPreferencesOnSharedPreferenceChangeListenerC2745d3 = sharedPreferencesOnSharedPreferenceChangeListenerC2745d;
                        sharedPreferencesOnSharedPreferenceChangeListenerC2745d3.m9831b();
                        sharedPreferencesOnSharedPreferenceChangeListenerC2745d3.postOnAnimation(new RunnableC2743b(sharedPreferencesOnSharedPreferenceChangeListenerC2745d3, 2));
                        break;
                }
            }
        });
        sharedPreferencesOnSharedPreferenceChangeListenerC2745d.f21096J.setVisibility(8);
        sharedPreferencesOnSharedPreferenceChangeListenerC2745d.addView(sharedPreferencesOnSharedPreferenceChangeListenerC2745d.f21096J, 1, layoutParams);
        this.mEditMenu = sharedPreferencesOnSharedPreferenceChangeListenerC2745d;
        sharedPreferencesOnSharedPreferenceChangeListenerC2745d.setOnListenerEditMenu(this);
        this.mEditWidgetLabelDialog = new DialogC1104f(this);
        this.mStats = new Stats(this);
        this.mAppWidgetManager = AbstractC2659c.m9639f(this);
        this.mPaused = false;
        setContentView(R.layout.launcher);
        invariantDeviceProfile.f16725q.m7813e(getSearchBarHeight());
        invariantDeviceProfile.f16726r.m7813e(getSearchBarHeight());
        DragController dragController = this.mDragController;
        this.mLauncherView = (LauncherRootView) findViewById(R.id.launcher);
        this.mFocusHandler = (FocusIndicatorView) findViewById(R.id.focus_indicator);
        DragLayer dragLayer = (DragLayer) findViewById(R.id.drag_layer);
        this.mDragLayer = dragLayer;
        Workspace workspace = (Workspace) dragLayer.findViewById(R.id.workspace);
        this.mWorkspace = workspace;
        workspace.setPageSwitchListener(this);
        this.mPageIndicators = this.mDragLayer.findViewById(R.id.page_indicator);
        this.mBlurBackgroundView = (BlurScreenLayout) findViewById(R.id.blur_background);
        this.mBlurWallpaperBackground = (BlurWallpaperBackground) findViewById(R.id.blur_wallpaper_background);
        BlurScreenLayout blurScreenLayout = new BlurScreenLayout(this, null);
        this.mFloatingBackgroundView = blurScreenLayout;
        blurScreenLayout.setFocusable(true);
        this.mFloatingBackgroundView.setClickable(true);
        SearchViewLayout searchViewLayout = (SearchViewLayout) findViewById(R.id.search_view);
        this.mSearchView = searchViewLayout;
        searchViewLayout.setSearchViewListener(this);
        this.pullDetector = new C0039G(this, this.screenHeight);
        if (this.isHideNavigation) {
            this.mLauncherView.setSystemUiVisibility(5890);
        } else {
            this.mLauncherView.setSystemUiVisibility(1792);
        }
        this.mDragLayer.setup(this, dragController);
        Hotseat hotseat = (Hotseat) findViewById(R.id.hotseat);
        this.mHotseat = hotseat;
        if (hotseat != null) {
            hotseat.setOnLongClickListener(this);
        }
        this.mWidgetsAppStyle = (SlidingUpWidgetsCellAppStyle) findViewById(R.id.sliding_up_widgets_app_style);
        this.mCustomizeColorApp = (SlidingUpCustomizeColorIconStyle) findViewById(R.id.customize_color_icon_style);
        this.mOverviewPanel = (ViewGroup) findViewById(R.id.overview_panel);
        LauncherLongClickListener launcherLongClickListener = new LauncherLongClickListener();
        View viewFindViewById = findViewById(R.id.wallpaper_button);
        viewFindViewById.setOnClickListener(new LauncherClickListenerB(this));
        viewFindViewById.setOnLongClickListener(launcherLongClickListener);
        viewFindViewById.setOnTouchListener(getHapticFeedbackTouchListener());
        View viewFindViewById2 = findViewById(R.id.widget_button);
        this.mWidgetsButton = viewFindViewById2;
        viewFindViewById2.setOnClickListener(new LauncherClickListenerC(this));
        this.mWidgetsButton.setOnLongClickListener(launcherLongClickListener);
        this.mWidgetsButton.setOnTouchListener(getHapticFeedbackTouchListener());
        AppCompatButton appCompatButton = (AppCompatButton) findViewById(R.id.add_widgets_done);
        this.mAddWidgetsDone = appCompatButton;
        appCompatButton.setOnClickListener(new WidgetClickListener(this, i8));
        AppCompatButton appCompatButton2 = (AppCompatButton) findViewById(R.id.add_widgets);
        this.mAddWidgets = appCompatButton2;
        appCompatButton2.setOnClickListener(new WidgetClickListener(this, i7));
        this.mAddWidgets.setOnLongClickListener(launcherLongClickListener);
        this.mAddWidgets.setOnTouchListener(getHapticFeedbackTouchListener());
        View viewFindViewById3 = findViewById(R.id.settings_button);
        if (hasSettings()) {
            viewFindViewById3.setOnClickListener(new LauncherClickListenerD(this));
            viewFindViewById3.setOnLongClickListener(launcherLongClickListener);
            viewFindViewById3.setOnTouchListener(getHapticFeedbackTouchListener());
        } else {
            viewFindViewById3.setVisibility(8);
        }
        this.mOverviewPanel.setAlpha(0.0f);
        this.mWorkspace.setHapticFeedbackEnabled(false);
        this.mWorkspace.setOnLongClickListener(this);
        this.mWorkspace.setup(dragController);
        dragController.f16104m.add(this.mWorkspace);
        WidgetsContainerView widgetsContainerView = (WidgetsContainerView) findViewById(R.id.widgets_view);
        this.mWidgetsView = widgetsContainerView;
        Objects.toString(widgetsContainerView);
        Workspace workspace2 = this.mWorkspace;
        dragController.f16108q = workspace2;
        dragController.f16106o = this.mDragLayer;
        dragController.f16107p = workspace2;
        dragController.f16103l.add(workspace2);
        DeviceProfile deviceProfile4 = this.mDeviceProfile;
        deviceProfile4.getClass();
        boolean zIsRtl = Utilities.isRtl(getResources());
        PagedView pagedView = (PagedView) findViewById(R.id.workspace);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) pagedView.getLayoutParams();
        layoutParams2.gravity = 17;
        Rect rectM7812d = deviceProfile4.m7812d();
        pagedView.setLayoutParams(layoutParams2);
        pagedView.setPadding(rectM7812d.left, rectM7812d.top, rectM7812d.right, rectM7812d.bottom);
        boolean z9 = deviceProfile4.f16003c;
        int iMax = deviceProfile4.defaultPageSpacingPx;
        if (!z9) {
            iMax = Math.max(iMax, deviceProfile4.m7812d().left * 2);
        }
        pagedView.setPageSpacing(iMax);
        View viewFindViewById4 = findViewById(R.id.hotseat);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) viewFindViewById4.getLayoutParams();
        int i15 = layoutParams3.bottomMargin;
        float currentWidth = deviceProfile4.getCurrentWidth();
        InvariantDeviceProfile invariantDeviceProfile3 = deviceProfile4.inv;
        Math.round(((currentWidth / invariantDeviceProfile3.f16712d) - (deviceProfile4.getCurrentWidth() / invariantDeviceProfile3.f16719k)) / 2.0f);
        int i16 = deviceProfile4.f15977C;
        if (deviceProfile4.f16002b) {
            layoutParams3.gravity = 80;
            layoutParams3.width = -1;
            layoutParams3.height = deviceProfile4.f15995U;
            viewFindViewById4.findViewById(R.id.layout).setPadding(i16, 0, i16, 0);
        } else {
            layoutParams3.gravity = 80;
            layoutParams3.width = -1;
            layoutParams3.height = deviceProfile4.f15995U;
            viewFindViewById4.findViewById(R.id.layout).setPadding(i16, 0, i16, 0);
        }
        if (invariantDeviceProfile3.f16731w && invariantDeviceProfile3.f16732x) {
            layoutParams3.bottomMargin = (-invariantDeviceProfile3.f16733y) + deviceProfile4.f15989O;
        }
        if (deviceProfile4.f15997W) {
            layoutParams3.bottomMargin -= deviceProfile4.f15989O;
        }
        if (deviceProfile4.f15988N) {
            layoutParams3.bottomMargin += deviceProfile4.f15989O;
        }
        int i17 = layoutParams3.bottomMargin + deviceProfile4.f15995U;
        viewFindViewById4.setLayoutParams(layoutParams3);
        View viewFindViewById5 = findViewById(R.id.page_indicator);
        if (viewFindViewById5 != null) {
            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) viewFindViewById5.getLayoutParams();
            layoutParams4.gravity = 81;
            int i18 = deviceProfile4.f16022v;
            layoutParams4.width = i18 * 3;
            layoutParams4.height = i18;
            i6 = 1;
            layoutParams4.bottomMargin = (int) ((i18 * (deviceProfile4.f16006f ? 0.75d : invariantDeviceProfile3.f16711c >= 6 ? 0.5d : 0.6d)) + i17);
            viewFindViewById5.setLayoutParams(layoutParams4);
        } else {
            i6 = 1;
        }
        ViewGroup overviewPanel = getOverviewPanel();
        if (overviewPanel != null) {
            int iMin = Math.min(deviceProfile4.overviewModeMaxIconZoneHeightPx, Math.max(deviceProfile4.overviewModeMinIconZoneHeightPx, (int) (deviceProfile4.overviewModeIconZoneRatio * deviceProfile4.f16013m)));
            FrameLayout.LayoutParams layoutParams5 = (FrameLayout.LayoutParams) overviewPanel.getLayoutParams();
            layoutParams5.gravity = 81;
            int i19 = 0;
            for (int i20 = 0; i20 < overviewPanel.getChildCount(); i20 += i6) {
                if (overviewPanel.getChildAt(i20).getVisibility() != 8) {
                    i19 += i6;
                }
            }
            int i21 = deviceProfile4.overviewModeBarItemWidthPx * i19;
            int i22 = i19 - 1;
            layoutParams5.width = Math.min(deviceProfile4.f16012l, (deviceProfile4.overviewModeBarSpacerWidthPx * i22) + i21);
            layoutParams5.height = iMin;
            overviewPanel.setLayoutParams(layoutParams5);
            int i23 = layoutParams5.width;
            if (i23 > i21 && i19 > i6) {
                int i24 = (i23 - i21) / i22;
                View view2 = null;
                for (int i25 = 0; i25 < i19; i25++) {
                    if (view2 != null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
                        if (zIsRtl) {
                            marginLayoutParams.leftMargin = i24;
                        } else {
                            marginLayoutParams.rightMargin = i24;
                        }
                        view2.setLayoutParams(marginLayoutParams);
                        view2 = null;
                    }
                    View childAt = overviewPanel.getChildAt(i25);
                    if (childAt.getVisibility() != 8) {
                        view2 = childAt;
                    }
                }
            }
        }
        lockAllApps();
        this.mSavedState = bundle;
        Objects.toString(bundle);
        if (bundle != null) {
            int i26 = bundle.getInt(RUNTIME_STATE, 1);
            LauncherState launcherState = LauncherState.f16045k;
            LauncherState[] launcherStateArrValues = LauncherState.values();
            for (int i27 = 0; i27 < launcherStateArrValues.length; i27++) {
                if (launcherStateArrValues[i27].ordinal() == i26) {
                    launcherState = launcherStateArrValues[i27];
                    break;
                }
            }
            if (launcherState == LauncherState.f16046l || launcherState == LauncherState.f16048n) {
                this.mOnResumeState = launcherState;
            }
            int i28 = bundle.getInt(RUNTIME_STATE_CURRENT_SCREEN, -1001);
            if (i28 != -1001) {
                this.mWorkspace.setRestorePage(i28);
            }
            long j6 = bundle.getLong(RUNTIME_STATE_PENDING_ADD_CONTAINER, -1L);
            long j7 = bundle.getLong(RUNTIME_STATE_PENDING_ADD_SCREEN, -1L);
            if (j6 != -1 && j7 > -1) {
                PendingAddItemInfo pendingAddItemInfo = this.mPendingAddInfo;
                pendingAddItemInfo.container = j6;
                pendingAddItemInfo.screenId = j7;
                pendingAddItemInfo.cellX = bundle.getInt(RUNTIME_STATE_PENDING_ADD_CELL_X);
                this.mPendingAddInfo.cellY = bundle.getInt(RUNTIME_STATE_PENDING_ADD_CELL_Y);
                this.mPendingAddInfo.spanX = bundle.getInt(RUNTIME_STATE_PENDING_ADD_SPAN_X);
                this.mPendingAddInfo.spanY = bundle.getInt(RUNTIME_STATE_PENDING_ADD_SPAN_Y);
                this.mPendingAddInfo.componentName = (ComponentName) bundle.getParcelable(RUNTIME_STATE_PENDING_ADD_COMPONENT);
                AppWidgetProviderInfo appWidgetProviderInfo = (AppWidgetProviderInfo) bundle.getParcelable(RUNTIME_STATE_PENDING_ADD_WIDGET_INFO);
                this.mPendingAddWidgetInfo = appWidgetProviderInfo == null ? null : LauncherAppWidgetProviderInfo.fromProviderInfo(appWidgetProviderInfo);
                this.mPendingAddWidgetId = bundle.getInt(RUNTIME_STATE_PENDING_ADD_WIDGET_ID);
                setWaitingForResult(true);
                this.mRestoring = true;
            }
        }
        if (!this.mRestoring) {
            this.mModel.startLoader(this.mWorkspace.getRestorePage(), 0);
        }
        if (Utilities.f16755p) {
            C1185a c1185a = new C1185a();
            c1185a.f3479b = new ArrayList();
            c1185a.f3478a = this;
            this.mNotificationChangedListener = c1185a;
        }
        this.mWorkerHandler = new Handler(LauncherModel.sWorkerThread.getLooper(), this.mWorkerCallback);
        this.mUiHandler = new Handler(Looper.getMainLooper(), this.mUiCallback);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        this.mDefaultKeySsb = spannableStringBuilder;
        Selection.setSelection(spannableStringBuilder, 0);
        IntentFilter intentFilter = new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS");
        boolean z10 = Utilities.f16749j;
        if (z10) {
            registerReceiver(this.mCloseSystemDialogsReceiver, intentFilter, 2);
        } else {
            registerReceiver(this.mCloseSystemDialogsReceiver, intentFilter);
        }
        boolean z11 = getResources().getBoolean(R.bool.allow_rotation);
        this.mRotationEnabled = z11;
        if (!z11) {
            this.mRotationEnabled = Utilities.isRotationAllowedForDevice(getApplicationContext());
        }
        setOrientation();
        LauncherCallbacks launcherCallbacks = this.mLauncherCallbacks;
        if (launcherCallbacks != null) {
            ((IOSLauncherCallbacks) launcherCallbacks).m8078a();
        }
        if (!hasDismissableIntroScreen() || this.mSharedPrefs.getBoolean(INTRO_SCREEN_DISMISSED, false)) {
            showFirstRunActivity();
            showFirstRunClings();
        } else {
            showIntroScreen();
        }
        C2615e c2615e = this.mBlurWallpaperProvider;
        c2615e.getClass();
        Utilities.f16756q.execute(c2615e.f20568r);
        if (z10) {
            getOnBackInvokedDispatcher().registerOnBackInvokedCallback(0, new OnBackInvokedCallback() { // from class: com.luutinhit.launcher6.s1
                @Override // android.window.OnBackInvokedCallback
                public final void onBackInvoked() {
                    Launcher.this.closeAllPanels();
                }
            });
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        AlertDialog alertDialog;
        super.onDestroy();
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(0);
        this.mWorkspace.removeCallbacks(this.mBuildLayersRunnable);
        LauncherAppState launcherAppState = LauncherAppState.getInstance();
        LauncherModel launcherModel = this.mModel;
        launcherModel.getClass();
        Objects.toString(this);
        WeakReference weakReference = launcherModel.f15352t;
        if (weakReference != null && weakReference.get() == this) {
            LauncherModel launcherModel2 = this.mModel;
            synchronized (launcherModel2.f15344l) {
                try {
                    LoaderTask loaderTask = launcherModel2.mLoaderTask;
                    if (loaderTask != null) {
                        loaderTask.stopLocked();
                    }
                } catch (Throwable th) {
                    throw com.luutinhit.launcher6.JadxSupport.sneaky(th);
                }
            }
            launcherAppState.m7931d(null);
        }
        try {
            this.mAppWidgetHost.stopListening();
        } catch (NullPointerException unused) {
        }
        this.mIsListening = false;
        this.mAppWidgetHost = null;
        this.mWidgetsToAdvance.clear();
        TextKeyListener.getInstance().release();
        unregisterReceiver(this.mCloseSystemDialogsReceiver);
        this.mDragLayer.clearAllResizeFrames();
        ((ViewGroup) this.mWorkspace.getParent()).removeAllViews();
        this.mWorkspace.g1();
        this.mWorkspace = null;
        this.mDragController = null;
        WeakHashMap weakHashMap = LauncherAnimUtils.sAnimators;
        WeakHashMap weakHashMap2 = LauncherAnimUtils.sAnimators;
        for (Animator animator : (Iterable<Animator>) (Iterable) (new HashSet(weakHashMap2.keySet()))) {
            if (animator.isRunning()) {
                animator.cancel();
            }
            weakHashMap2.remove(animator);
        }
        LauncherCallbacks launcherCallbacks = this.mLauncherCallbacks;
        if (launcherCallbacks != null) {
            IOSLauncher iOSLauncher = ((IOSLauncherCallbacks) launcherCallbacks).f16589a;
            if (iOSLauncher.mRequestSetDefaultLauncher != null && (alertDialog = iOSLauncher.mRequestSetDefaultLauncher.f114b) != null && alertDialog.isShowing()) {
                C0046N c0046n = iOSLauncher.mRequestSetDefaultLauncher;
                AlertDialog alertDialog2 = c0046n.f114b;
                if (alertDialog2 != null && alertDialog2.isShowing()) {
                    c0046n.f114b.dismiss();
                }
                c0046n.f114b = null;
            }
            if (iOSLauncher.mDialogWarningWallpaper != null && iOSLauncher.mDialogWarningWallpaper.isShowing()) {
                iOSLauncher.mDialogWarningWallpaper.dismiss();
            }
        }
        this.mTinyDB.f137a.unregisterOnSharedPreferenceChangeListener(this);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mVisible = false;
        if (this.mAttached) {
            unregisterReceiver(this.mReceiver);
            this.mAttached = false;
        }
        updateAutoAdvanceState();
        LauncherCallbacks launcherCallbacks = this.mLauncherCallbacks;
        if (launcherCallbacks != null) {
            launcherCallbacks.getClass();
        }
    }

    public void onDragStarted(View view) {
        Objects.toString(view);
        if (isOnCustomContent()) {
            moveWorkspaceToDefaultScreen();
        }
        LauncherCallbacks launcherCallbacks = this.mLauncherCallbacks;
        if (launcherCallbacks != null) {
            launcherCallbacks.getClass();
        }
    }

    public void onInteractionBegin() {
        LauncherCallbacks launcherCallbacks = this.mLauncherCallbacks;
        if (launcherCallbacks != null) {
            launcherCallbacks.getClass();
        }
    }

    public void onInteractionEnd() {
        LauncherCallbacks launcherCallbacks = this.mLauncherCallbacks;
        if (launcherCallbacks != null) {
            IOSLauncher iOSLauncher = ((IOSLauncherCallbacks) launcherCallbacks).f16589a;
            if (iOSLauncher.autoRearrange) {
                iOSLauncher.rearrangeApps(true);
            }
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i6, KeyEvent keyEvent) {
        SpannableStringBuilder spannableStringBuilder;
        Objects.toString(keyEvent);
        int unicodeChar = keyEvent.getUnicodeChar();
        boolean zOnKeyDown = super.onKeyDown(i6, keyEvent);
        boolean z5 = unicodeChar > 0 && !Character.isWhitespace(unicodeChar);
        if (!zOnKeyDown && !((InputMethodManager) getSystemService("input_method")).isFullscreenMode() && z5 && TextKeyListener.getInstance().onKeyDown(this.mWorkspace, this.mDefaultKeySsb, i6, keyEvent) && (spannableStringBuilder = this.mDefaultKeySsb) != null && spannableStringBuilder.length() > 0) {
            return onSearchRequested();
        }
        if (i6 == 82 && keyEvent.isLongPress()) {
            return true;
        }
        return zOnKeyDown;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i6, KeyEvent keyEvent) {
        Objects.toString(keyEvent);
        if (i6 != 82) {
            return super.onKeyUp(i6, keyEvent);
        }
        if (!isOnCustomContent() && !this.mDragController.f16097f) {
            closeFolder();
            this.mWorkspace.f23432V0.getDragLayer().clearAllResizeFrames();
            if (this.mState == LauncherState.f16045k && !this.mWorkspace.X0()) {
                this.mWorkspace.getClass();
                this.mOverviewPanel.requestFocus();
                showOverviewMode(true, true);
            }
        }
        return true;
    }

    @Override // com.luutinhit.launcher6.LauncherProviderChangeListener
    public void onLauncherProviderChange() {
        LauncherCallbacks launcherCallbacks = this.mLauncherCallbacks;
        if (launcherCallbacks != null) {
            launcherCallbacks.getClass();
        }
    }

    /* JADX WARN: Code duplicated, block: B:68:0x00d7  */
    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        com.luutinhit.launcher6.JadxSupport.useOriginalBytecode(); // jadx flagged this method; the original bytecode runs
        View view2;
        CellInfo cellInfo;
        boolean z5;
        Objects.toString(view);
        Objects.toString(this.mState);
        try {
            if (isDraggingEnabled() && !isWorkspaceLocked() && this.mState == LauncherState.f16045k && !isOpeningSearchView()) {
                if (!(view instanceof Workspace)) {
                    if (!this.mIsShaking && !this.showingFloatingMenu && ((view instanceof BubbleTextView) || (view instanceof LauncherAppWidgetHostView))) {
                        vibrate();
                        openFloatingMenu(view);
                        return true;
                    }
                    closeFloatingMenu();
                    if (view instanceof BubbleTextView) {
                        ((BubbleTextView) view).f15410x.m8196c(8, false);
                    } else if (view instanceof LauncherAppWidgetHostView) {
                        DeleteCircleView deleteCircleView = ((LauncherAppWidgetHostView) view).f16543q;
                        Objects.toString(deleteCircleView);
                        if (deleteCircleView != null) {
                            deleteCircleView.m8196c(8, false);
                        }
                    }
                    Object tag = view.getTag();
                    if (tag instanceof ItemInfo) {
                        ItemInfo itemInfo = (ItemInfo) tag;
                        if (!this.mIsShaking) {
                            onShakingAllApps();
                            return true;
                        }
                        CellInfo cellInfo2 = new CellInfo(view, itemInfo);
                        m7838D();
                        cellInfo = cellInfo2;
                        view2 = view;
                    } else {
                        view2 = null;
                        cellInfo = null;
                    }
                    boolean zIsHotseatLayout = isHotseatLayout(view);
                    if (!this.mDragController.f16097f) {
                        if (view2 == null) {
                            this.mWorkspace.performHapticFeedback(0, 1);
                            if (this.mWorkspace.X0()) {
                                this.mWorkspace.p0(view);
                                return true;
                            }
                            showOverviewMode(true);
                            return true;
                        }
                        if (zIsHotseatLayout) {
                            Hotseat hotseat = this.mHotseat;
                            int i6 = cellInfo.f15557b;
                            hotseat.getClass();
                            if (isAllAppsButtonRank(i6)) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                        } else {
                            z5 = false;
                        }
                        if (!(view2 instanceof Folder) && !z5) {
                            Workspace workspace = this.mWorkspace;
                            workspace.getClass();
                            Objects.toString(cellInfo);
                            workspace.mo7714x(cellInfo, false);
                            return true;
                        }
                    }
                    return true;
                }
                if (!this.mWorkspace.X0()) {
                    if (!(this.mWorkspace.f16064N != 0)) {
                        showOverviewMode(true);
                        this.mWorkspace.performHapticFeedback(0, 1);
                        return true;
                    }
                }
            }
            return false;
        } catch (Throwable th) {
            th.getMessage();
            return false;
        }
    }

    public void onLongClickAllAppsButton(View view) {
        Objects.toString(view);
        if (isAppsViewVisible()) {
            return;
        }
        showAppsView(true, false, true, true);
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        AppsLibraryView appsLibraryView;
        WidgetsContainerView widgetsContainerView;
        Objects.toString(intent);
        super.onNewIntent(intent);
        Folder openFolder = this.mWorkspace.getOpenFolder();
        boolean z5 = this.mHasFocus && (intent.getFlags() & 4194304) != 4194304;
        boolean zEquals = "android.intent.action.MAIN".equals(intent.getAction());
        LauncherState launcherState = LauncherState.f16045k;
        if (zEquals) {
            closeSystemDialogs();
            Workspace workspace = this.mWorkspace;
            if (workspace == null) {
                return;
            }
            workspace.f23432V0.getDragLayer().clearAllResizeFrames();
            closeFolder(z5);
            exitSpringLoadedDragMode();
            SearchViewLayout searchViewLayout = this.mSearchView;
            if (searchViewLayout != null && searchViewLayout.m8357J()) {
                this.mSearchView.m8352D();
            }
            if (isOpeningFloatingMenu()) {
                closeFloatingMenu();
            }
            if (isOpeningEditMenu()) {
                closeEditMenu();
            }
            if (z5) {
                showWorkspace(true);
            } else {
                this.mOnResumeState = launcherState;
            }
            View viewPeekDecorView = getWindow().peekDecorView();
            if (viewPeekDecorView != null && viewPeekDecorView.getWindowToken() != null) {
                ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(viewPeekDecorView.getWindowToken(), 0);
            }
            if (!z5 && (widgetsContainerView = this.mWidgetsView) != null) {
                widgetsContainerView.f17189W.n0(0);
            }
            LauncherCallbacks launcherCallbacks = this.mLauncherCallbacks;
            if (launcherCallbacks != null && (appsLibraryView = ((IOSLauncherCallbacks) launcherCallbacks).f16589a.appsLibraryLayout) != null) {
                appsLibraryView.removeExpandedFolder();
            }
        }
        if (!zEquals || this.mIsShaking) {
            cancelShakingAnimation();
            return;
        }
        if (z5 && this.mState == launcherState) {
            Workspace workspace2 = this.mWorkspace;
            if (workspace2.f16064N == 0 && openFolder == null) {
                this.mMoveToDefaultScreenFromNewIntent = true;
                workspace2.post(new LauncherWorkspaceTask(this, 0));
            }
        }
    }

    @Override // com.luutinhit.launcher6.LauncherModelCallbacks
    public void onPageBoundSynchronously(int i6) {
        this.mSynchronouslyBoundPages.add(Integer.valueOf(i6));
    }

    @Override // com.luutinhit.launcher6.PageSwitchListener
    public void onPageSwitch(View view, int i6) {
        Objects.toString(view);
        LauncherCallbacks launcherCallbacks = this.mLauncherCallbacks;
        if (launcherCallbacks != null) {
            launcherCallbacks.getClass();
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        InstallShortcutReceiver.f15736b = true;
        super.onPause();
        this.mPaused = true;
        this.mDragController.cancelDrag();
        this.mDragController.f16114w = -1L;
        if (this.mWorkspace.getCustomContentCallbacks() != null) {
            this.mWorkspace.getCustomContentCallbacks().mo7797e();
        }
        LauncherCallbacks launcherCallbacks = this.mLauncherCallbacks;
        if (launcherCallbacks != null) {
            launcherCallbacks.getClass();
        }
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle) {
        Objects.toString(bundle);
        super.onPostCreate(bundle);
        this.mAppWidgetHost = new LauncherAppWidgetHost(this);
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        Objects.toString(menu);
        super.onPrepareOptionsMenu(menu);
        LauncherCallbacks launcherCallbacks = this.mLauncherCallbacks;
        if (launcherCallbacks != null) {
            launcherCallbacks.getClass();
        }
        return false;
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i6, String[] strArr, int[] iArr) {
        PendingAddArguments pendingAddArguments;
        View childAt;
        if (i6 == 13 && (pendingAddArguments = sPendingAddItem) != null && pendingAddArguments.f15966a == 13) {
            CellLayout cellLayout = getCellLayout(pendingAddArguments.f15968c, pendingAddArguments.f15969d);
            if (cellLayout != null) {
                PendingAddArguments pendingAddArguments2 = sPendingAddItem;
                childAt = cellLayout.mShortcutsAndWidgets.getChildAt(pendingAddArguments2.f15970e, pendingAddArguments2.f15971f);
            } else {
                childAt = null;
            }
            Intent intent = sPendingAddItem.f15967b;
            sPendingAddItem = null;
            if (iArr.length <= 0 || iArr[0] != 0) {
                Toast.makeText(this, getString(R.string.msg_no_phone_permission, getString(R.string.app_name)), 0).show();
            } else {
                startActivitySafely(childAt, intent, null);
            }
        }
        LauncherCallbacks launcherCallbacks = this.mLauncherCallbacks;
        if (launcherCallbacks != null) {
            launcherCallbacks.getClass();
        }
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        Objects.toString(bundle);
        try {
            super.onRestoreInstanceState(bundle);
            ArrayList<Integer> arrayList = this.mSynchronouslyBoundPages;
            int size = arrayList.size();
            int i6 = 0;
            while (i6 < size) {
                Integer num = arrayList.get(i6);
                i6++;
                this.mWorkspace.m1(num.intValue());
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        View.OnClickListener pageIndicatorClickListener;
        int i6;
        LauncherCallbacks launcherCallbacks = this.mLauncherCallbacks;
        if (launcherCallbacks != null) {
            IOSLauncherCallbacks iOSLauncherCallbacks = (IOSLauncherCallbacks) launcherCallbacks;
            if (Utilities.f16745f) {
                IOSLauncher iOSLauncher = iOSLauncherCallbacks.f16589a;
                if (iOSLauncher.isOpenCloseAnim) {
                    IconTransitionHelper stateTransitionAnimation = iOSLauncher.getStateTransitionAnimation();
                    int[] iArr = stateTransitionAnimation.f15746c;
                    try {
                        ObjectAnimator objectAnimator = stateTransitionAnimation.f15747d;
                        if ((objectAnimator == null || (!objectAnimator.isRunning() && !stateTransitionAnimation.f15747d.isStarted())) && stateTransitionAnimation.f15745b != null && (i6 = iArr[0]) != 0 && iArr[1] != 0) {
                            PropertyValuesHolder propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat((Property<?, Float>) View.X, i6);
                            PropertyValuesHolder propertyValuesHolderOfFloat2 = PropertyValuesHolder.ofFloat((Property<?, Float>) View.Y, iArr[1]);
                            PropertyValuesHolder propertyValuesHolderOfFloat3 = PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_X, 1.0f);
                            PropertyValuesHolder propertyValuesHolderOfFloat4 = PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_Y, 1.0f);
                            PropertyValuesHolder propertyValuesHolderOfFloat5 = PropertyValuesHolder.ofFloat((Property<?, Float>) View.ALPHA, 0.0f, 1.0f);
                            ObjectAnimator objectAnimator2 = stateTransitionAnimation.f15747d;
                            if (objectAnimator2 == null || !objectAnimator2.isRunning()) {
                                ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(stateTransitionAnimation.f15745b, propertyValuesHolderOfFloat, propertyValuesHolderOfFloat2, propertyValuesHolderOfFloat3, propertyValuesHolderOfFloat4, propertyValuesHolderOfFloat5);
                                stateTransitionAnimation.f15747d = objectAnimatorOfPropertyValuesHolder;
                                objectAnimatorOfPropertyValuesHolder.setDuration(386L);
                                stateTransitionAnimation.f15747d.setInterpolator(new DecelerateInterpolator(1.5f));
                                stateTransitionAnimation.f15747d.addListener(new C0022a(14, stateTransitionAnimation));
                            }
                            C2801d.m9955b().m9958e("CLOSE_ANIM");
                            stateTransitionAnimation.f15747d.start();
                        }
                    } catch (Throwable th) {
                        th.getMessage();
                    }
                }
            }
        }
        super.onResume();
        LauncherState launcherState = this.mOnResumeState;
        if (launcherState == LauncherState.f16045k) {
            showWorkspace(false);
        } else if (launcherState == LauncherState.f16046l) {
            showAppsView(false, false, !(this.mWaitingForResume != null), false);
        }
        this.mOnResumeState = LauncherState.f16044j;
        this.mPaused = false;
        if (this.mRestoring || this.mOnResumeNeedsLoad) {
            boolean zIsWorkspaceLocked = isWorkspaceLocked();
            this.mWorkspaceLoading = true;
            if (zIsWorkspaceLocked != isWorkspaceLocked()) {
                onWorkspaceLockedChanged();
            }
            this.mBindOnResumeCallbacks.clear();
            this.mModel.startLoader(-1001, 0);
            this.mRestoring = false;
            this.mOnResumeNeedsLoad = false;
        }
        if (this.mBindOnResumeCallbacks.size() > 0) {
            for (int i7 = 0; i7 < this.mBindOnResumeCallbacks.size(); i7++) {
                this.mBindOnResumeCallbacks.get(i7).run();
            }
            this.mBindOnResumeCallbacks.clear();
        }
        if (this.mOnResumeCallbacks.size() > 0) {
            for (int i8 = 0; i8 < this.mOnResumeCallbacks.size(); i8++) {
                this.mOnResumeCallbacks.get(i8).run();
            }
            this.mOnResumeCallbacks.clear();
        }
        BubbleTextView bubbleTextView = this.mWaitingForResume;
        if (bubbleTextView != null) {
            bubbleTextView.setStayPressed(false);
        }
        if (!isWorkspaceLoading()) {
            getWorkspace().f1();
        }
        if (this.leftPage != null && isOpeningLeftPage() && this.mWorkspace.getCustomContentCallbacks() != null && !this.mMoveToDefaultScreenFromNewIntent && this.mWorkspace.Y0()) {
            this.mWorkspace.getCustomContentCallbacks().mo7796b(true);
        }
        this.mMoveToDefaultScreenFromNewIntent = false;
        updateInteraction(WorkspaceState.f15305k, this.mWorkspace.getState());
        Workspace workspace = this.mWorkspace;
        if (workspace.getPageIndicator() != null && (pageIndicatorClickListener = workspace.getPageIndicatorClickListener()) != null) {
            workspace.getPageIndicator().setOnClickListener(pageIndicatorClickListener);
        }
        LauncherAppState launcherAppState = LauncherAppState.getInstance();
        boolean z5 = launcherAppState.f16221d;
        launcherAppState.f16221d = false;
        if (z5) {
            Utilities.f16756q.execute(new MergedIdleRunnable(11, workspace));
        }
        workspace.f23458x0.getWallpaperInfo();
        if (!isWorkspaceLoading()) {
            InstallShortcutReceiver.f15736b = false;
            InstallShortcutReceiver.flushInstallQueue(this);
        }
        LauncherCallbacks launcherCallbacks2 = this.mLauncherCallbacks;
        if (launcherCallbacks2 != null) {
            ((IOSLauncherCallbacks) launcherCallbacks2).m8079b();
        }
    }

    @Override // android.app.Activity
    public Object onRetainNonConfigurationInstance() {
        LauncherModel launcherModel = this.mModel;
        launcherModel.getClass();
        Objects.toString(this);
        WeakReference weakReference = launcherModel.f15352t;
        if (weakReference != null && weakReference.get() == this) {
            LauncherModel launcherModel2 = this.mModel;
            synchronized (launcherModel2.f15344l) {
                try {
                    LoaderTask loaderTask = launcherModel2.mLoaderTask;
                    if (loaderTask != null) {
                        loaderTask.stopLocked();
                    }
                } catch (Throwable th) {
                    throw com.luutinhit.launcher6.JadxSupport.sneaky(th);
                }
            }
        }
        return Boolean.TRUE;
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Bundle bundle2;
        Objects.toString(bundle);
        if (isWorkspaceLoading() && (bundle2 = this.mSavedState) != null) {
            bundle.putAll(bundle2);
            return;
        }
        if (this.mWorkspace.getChildCount() > 0) {
            bundle.putInt(RUNTIME_STATE_CURRENT_SCREEN, this.mWorkspace.getCurrentPageOffsetFromCustomContent());
        }
        super.onSaveInstanceState(bundle);
        bundle.putInt(RUNTIME_STATE, this.mState.ordinal());
        closeFolder(false);
        PendingAddItemInfo pendingAddItemInfo = this.mPendingAddInfo;
        long j6 = pendingAddItemInfo.container;
        if (j6 != -1 && pendingAddItemInfo.screenId > -1 && this.mWaitingForResult) {
            bundle.putLong(RUNTIME_STATE_PENDING_ADD_CONTAINER, j6);
            bundle.putLong(RUNTIME_STATE_PENDING_ADD_SCREEN, this.mPendingAddInfo.screenId);
            bundle.putInt(RUNTIME_STATE_PENDING_ADD_CELL_X, this.mPendingAddInfo.cellX);
            bundle.putInt(RUNTIME_STATE_PENDING_ADD_CELL_Y, this.mPendingAddInfo.cellY);
            bundle.putInt(RUNTIME_STATE_PENDING_ADD_SPAN_X, this.mPendingAddInfo.spanX);
            bundle.putInt(RUNTIME_STATE_PENDING_ADD_SPAN_Y, this.mPendingAddInfo.spanY);
            bundle.putParcelable(RUNTIME_STATE_PENDING_ADD_COMPONENT, this.mPendingAddInfo.componentName);
            bundle.putParcelable(RUNTIME_STATE_PENDING_ADD_WIDGET_INFO, this.mPendingAddWidgetInfo);
            bundle.putInt(RUNTIME_STATE_PENDING_ADD_WIDGET_ID, this.mPendingAddWidgetId);
        }
        LauncherCallbacks launcherCallbacks = this.mLauncherCallbacks;
        if (launcherCallbacks != null) {
            launcherCallbacks.getClass();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onSearchRequested() {
        startSearch(null, false, null, true);
        return true;
    }

    public void onSearchViewAlphaChanged(float f6) {
    }

    @Override // Y3.InterfaceC1217g
    public void onSearchViewClosed(int i6) {
        this.mBlurBackgroundView.animateBlurAlpha(i6, false);
    }

    @Override // Y3.InterfaceC1217g
    public void onSearchViewOpened() {
    }

    @Override // Y3.InterfaceC1217g
    public void onSearchViewTranslationYChanged(float f6) {
        if (this.isRenderEffectSupport) {
            Workspace workspace = this.mWorkspace;
            if (workspace != null) {
                workspace.setTranslationY(f6);
            }
            Hotseat hotseat = this.mHotseat;
            if (hotseat != null) {
                hotseat.setTranslationY(f6);
            }
        }
    }

    @Override // com.luutinhit.launcher6.LauncherProviderChangeListener
    public void onSettingsChanged(String str, boolean z5) {
        if ("pref_allowRotation".equals(str)) {
            this.mRotationEnabled = z5;
            if (waitUntilResume(this.mUpdateOrientationRunnable, true)) {
                return;
            }
            this.mUpdateOrientationRunnable.run();
        }
    }

    @Override // p158z3.InterfaceC3077h
    public void onShakingAllApps() {
        if (this.mIsShaking) {
            return;
        }
        this.mIsShaking = true;
        if (this.mWorkspace != null) {
            if (isOpeningFolder()) {
                this.mWorkspace.getOpenFolder().m7702Q();
            }
            int i6 = 0;
            this.mAddWidgets.setVisibility(0);
            this.mAddWidgetsDone.setVisibility(0);
            ArrayList<ShortcutAndWidgetContainer> allShortcutAndWidgetContainers = this.mWorkspace.getAllShortcutAndWidgetContainers();
            int size = allShortcutAndWidgetContainers.size();
            while (i6 < size) {
                ShortcutAndWidgetContainer shortcutAndWidgetContainer = allShortcutAndWidgetContainers.get(i6);
                i6++;
                shortcutAndWidgetContainer.m8047k();
            }
            this.mWorkspace.getPageIndicator().mo7785d();
        }
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (str != null) {
            switch (str) {
                case "unlock_animation":
                    this.isUnlockAnim = sharedPreferences.getBoolean(str, true);
                    break;
                case "dark_mode":
                    boolean z5 = sharedPreferences.getBoolean(str, false);
                    this.isDarkMode = z5;
                    this.appsLibraryLayout.setDarkMode(z5);
                    this.leftPage.setDarkMode(this.isDarkMode);
                    this.mWidgetsView.setDarkMode(this.isDarkMode);
                    this.mWorkspace.getClass();
                    this.mWidgetsView.setDarkMode(this.isDarkMode);
                    this.mWidgetsAppStyle.setDarkMode(this.isDarkMode);
                    C0057Z c0057z = this.mTinyDBChange;
                    boolean z6 = this.isDarkMode;
                    Iterator it = c0057z.f138a.iterator();
                    while (it.hasNext()) {
                        InterfaceC0040H interfaceC0040H = (InterfaceC0040H) ((WeakReference) it.next()).get();
                        if (interfaceC0040H != null) {
                            interfaceC0040H.mo79a(z6);
                        } else {
                            it.remove();
                        }
                    }
                    break;
                case "app_library_dialog_guide":
                    this.isShowAppsLibraryGuide = sharedPreferences.getBoolean(str, false);
                    break;
                case "open_close_animation":
                    this.isOpenCloseAnim = sharedPreferences.getBoolean(str, true);
                    break;
                case "iphone_8_style":
                    this.mHotseat.requestLayout();
                    break;
                case "hide_navigation":
                    this.isHideNavigation = sharedPreferences.getBoolean(str, false);
                    break;
                case "auto_rearrange":
                    boolean z7 = sharedPreferences.getBoolean(str, false);
                    this.autoRearrange = z7;
                    if (z7) {
                        rearrangeApps(true);
                        break;
                    }
                    break;
            }
        }
    }

    @Override // android.app.Activity
    public void onStart() {
        LauncherAppWidgetHost launcherAppWidgetHost;
        super.onStart();
        FirstFrameAnimatorHelper.f16703q = true;
        LauncherCallbacks launcherCallbacks = this.mLauncherCallbacks;
        if (launcherCallbacks != null) {
            IOSLauncher iOSLauncher = ((IOSLauncherCallbacks) launcherCallbacks).f16589a;
            if (!iOSLauncher.isMyLauncherDefault() && !iOSLauncher.isFinishing()) {
                iOSLauncher.mRequestSetDefaultLauncher.m111a();
            }
            iOSLauncher.startPlayOpenAnimation();
        }
        if (!this.mIsListening && (launcherAppWidgetHost = this.mAppWidgetHost) != null) {
            try {
                launcherAppWidgetHost.startListening();
                this.mIsListening = true;
            } catch (Throwable unused) {
            }
        }
        if (!Utilities.f16755p || isWorkspaceLoading()) {
            return;
        }
        NotificationListener.f17614m = this.mNotificationChangedListener;
    }

    @Override // android.app.Activity
    public void onStop() {
        AlertDialog alertDialog;
        super.onStop();
        FirstFrameAnimatorHelper.f16703q = false;
        LauncherCallbacks launcherCallbacks = this.mLauncherCallbacks;
        if (launcherCallbacks != null) {
            IOSLauncher iOSLauncher = ((IOSLauncherCallbacks) launcherCallbacks).f16589a;
            iOSLauncher.getDragLayer().setScaleX(1.0f);
            iOSLauncher.getDragLayer().setScaleY(1.0f);
            iOSLauncher.prepareOpenAnimation(false);
            if (iOSLauncher.mRequestSetDefaultLauncher != null && (alertDialog = iOSLauncher.mRequestSetDefaultLauncher.f114b) != null && alertDialog.isShowing()) {
                C0046N c0046n = iOSLauncher.mRequestSetDefaultLauncher;
                AlertDialog alertDialog2 = c0046n.f114b;
                if (alertDialog2 != null && alertDialog2.isShowing()) {
                    c0046n.f114b.dismiss();
                }
                c0046n.f114b = null;
            }
            if (iOSLauncher.mDialogWarningWallpaper != null && iOSLauncher.mDialogWarningWallpaper.isShowing()) {
                iOSLauncher.mDialogWarningWallpaper.dismiss();
            }
        }
        SearchViewLayout searchViewLayout = this.mSearchView;
        if (searchViewLayout != null && searchViewLayout.m8357J()) {
            this.mSearchView.m8352D();
        }
        if (isOpeningFloatingMenu()) {
            closeFloatingMenu();
        }
        if (isOpeningEditMenu()) {
            closeEditMenu();
        }
        closeWidgetView(false);
        closeCustomizeColorAppStyle();
        cancelShakingAnimation();
    }

    @Override // android.view.View.OnTouchListener
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Objects.toString(view);
        Objects.toString(motionEvent);
        return false;
    }

    public void onTouchIcon(BubbleTextView bubbleTextView, MotionEvent motionEvent) {
        if (motionEvent != null) {
            int action = motionEvent.getAction();
            if ((action == 1 || action == 3) && !isOpeningFloatingMenu()) {
                bubbleTextView.m7598G();
            }
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i6) {
        super.onTrimMemory(i6);
        if (i6 >= 20) {
            SQLiteDatabase.releaseMemory();
        }
        LauncherCallbacks launcherCallbacks = this.mLauncherCallbacks;
        if (launcherCallbacks != null) {
            launcherCallbacks.getClass();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z5) {
        super.onWindowFocusChanged(z5);
        this.mHasFocus = z5;
        LauncherCallbacks launcherCallbacks = this.mLauncherCallbacks;
        if (launcherCallbacks != null) {
            launcherCallbacks.getClass();
        }
    }

    public void onWindowVisibilityChanged(int i6) {
        this.mVisible = i6 == 0;
        updateAutoAdvanceState();
        if (this.mVisible) {
            if (!this.mWorkspaceLoading) {
                this.mWorkspace.getViewTreeObserver().addOnDrawListener(new LauncherFirstDrawListener(this));
            }
            SpannableStringBuilder spannableStringBuilder = this.mDefaultKeySsb;
            if (spannableStringBuilder != null) {
                spannableStringBuilder.clear();
                this.mDefaultKeySsb.clearSpans();
                Selection.setSelection(this.mDefaultKeySsb, 0);
            }
        }
    }

    public void onWorkspaceLockedChanged() {
        LauncherCallbacks launcherCallbacks = this.mLauncherCallbacks;
        if (launcherCallbacks != null) {
            launcherCallbacks.getClass();
        }
    }

    public void openCustomizeColorAppStyle() {
        Objects.toString(this.mCustomizeColorApp);
        this.mCustomizeColorApp.post(new LauncherWorkspaceRunnable(this, 2));
    }

    public void openEditMenu(View view) {
        SharedPreferencesOnSharedPreferenceChangeListenerC2745d sharedPreferencesOnSharedPreferenceChangeListenerC2745d;
        if (this.mSearchView.m8357J() || (sharedPreferencesOnSharedPreferenceChangeListenerC2745d = this.mEditMenu) == null) {
            return;
        }
        this.showingEditMenu = true;
        sharedPreferencesOnSharedPreferenceChangeListenerC2745d.f21088B.getDragLayer().post(new RunnableC0054W(28, sharedPreferencesOnSharedPreferenceChangeListenerC2745d, view));
    }

    public void openFloatingMenu(View view) {
        SharedPreferencesOnSharedPreferenceChangeListenerC3078i sharedPreferencesOnSharedPreferenceChangeListenerC3078i;
        if (this.mSearchView.m8357J() || (sharedPreferencesOnSharedPreferenceChangeListenerC3078i = this.mFloatingMenu) == null) {
            return;
        }
        this.showingFloatingMenu = true;
        if (view instanceof BubbleTextView) {
            sharedPreferencesOnSharedPreferenceChangeListenerC3078i.f22123B.getDragLayer().post(new RunnableC1585t(18, sharedPreferencesOnSharedPreferenceChangeListenerC3078i, (BubbleTextView) view));
            this.mDragLayer.addView(this.mFloatingBackgroundView, new DragLayerLayoutParams(-1, -1));
            this.mDragLayer.postOnAnimation(new RunnableC0054W(19, this, (BubbleTextView) view));
        } else if (view instanceof LauncherAppWidgetHostView) {
            sharedPreferencesOnSharedPreferenceChangeListenerC3078i.f22123B.getDragLayer().post(new RunnableC1585t(17, sharedPreferencesOnSharedPreferenceChangeListenerC3078i, (LauncherAppWidgetHostView) view));
            this.mDragLayer.addView(this.mFloatingBackgroundView, new DragLayerLayoutParams(-1, -1));
            this.mDragLayer.postOnAnimation(new RunnableC0054W(20, this, (LauncherAppWidgetHostView) view));
        }
    }

    public void openFolder(FolderIcon folderIcon) {
        float f6;
        char c6;
        char c7;
        FolderReplaceWithItemRunnable folderReplaceWithItemRunnable;
        int i6;
        int i7 = 3;
        Objects.toString(folderIcon);
        Folder folder = folderIcon.getFolder();
        Workspace workspace = this.mWorkspace;
        Object obj = null;
        Folder openFolder = workspace != null ? workspace.getOpenFolder() : null;
        if (openFolder != null && openFolder != folder) {
            closeFolder();
        }
        folder.mInfo.f15523B = true;
        ((CellLayoutLayoutParams) folderIcon.getLayoutParams()).f15694j = false;
        if (folder.getParent() == null) {
            this.mDragLayer.addView(folder);
            this.mDragController.f16103l.add(folder);
        } else {
            folder.toString();
            Objects.toString(folder.getParent());
        }
        String str = "alpha";
        if (folder.getParent() instanceof DragLayer) {
            folder.mContent.x0();
            if (folder.f15610M) {
                f6 = 0.0f;
            } else {
                FolderPagedView folderPagedView = folder.mContent;
                int iT0 = folderPagedView.t0(0);
                f6 = 0.0f;
                folderPagedView.n0(iT0, folderPagedView.getScrollForPage(iT0) - folderPagedView.getUnboundedScrollX(), 750, true, null);
            }
            Launcher launcher = folder.f15628q;
            if (launcher != null && launcher.isShaking()) {
                folder.m7702Q();
            }
            folder.f15611N = false;
            if (folder.getParent() instanceof DragLayer) {
                folder.setScaleX(f6);
                folder.setScaleY(f6);
                folder.setAlpha(f6);
                folder.f15603F = 0;
            }
            folder.centerAboutIcon();
            c6 = 0;
            ObjectAnimator objectAnimatorOfPropertyValuesHolder = LauncherAnimUtils.ofPropertyValuesHolder(folder, PropertyValuesHolder.ofFloat(str, 1.0f), PropertyValuesHolder.ofFloat("scaleX", 1.0f), PropertyValuesHolder.ofFloat("scaleY", 1.0f));
            objectAnimatorOfPropertyValuesHolder.setDuration(folder.mExpandDuration);
            folder.f23335e0 = new FolderGlassFrameCallback(folder, objectAnimatorOfPropertyValuesHolder);
            boolean z5 = Utilities.f16752m;
            if (z5) {
                c7 = 1;
                objectAnimatorOfPropertyValuesHolder.setInterpolator(new PathInterpolator(0.25f, 0.1f, 0.1f, 1.0f));
            } else {
                c7 = 1;
            }
            if (z5) {
                folder.setLayerType(2, null);
                folderReplaceWithItemRunnable = new FolderReplaceWithItemRunnable(folder, i7);
                i6 = 4;
            } else {
                folder.mContentWrapper.setLayerType(2, null);
                i6 = 4;
                folderReplaceWithItemRunnable = new FolderReplaceWithItemRunnable(folder, i6);
            }
            objectAnimatorOfPropertyValuesHolder.addListener(new C0119k(i7, folder, folderReplaceWithItemRunnable));
            if (folder.mContent.getPageCount() <= 1 || (folder.mInfo.f16792u & i6) != 0) {
                folder.mFolderName.setTranslationX(f6);
                folder.mContent.setMarkerScale(1.0f);
            } else {
                folder.mContent.setMarkerScale(f6);
                objectAnimatorOfPropertyValuesHolder.addListener(new C0630c(folder, !folder.f15610M));
            }
            objectAnimatorOfPropertyValuesHolder.start();
            DragController dragController = folder.mDragController;
            if (dragController.f16097f) {
                int[] iArr = dragController.f16113v;
                int i8 = iArr[0];
                int i9 = iArr[c7];
                int[] iArr2 = dragController.f16095d;
                DropTarget dropTargetFindDropTarget = dragController.findDropTarget(i8, i9, iArr2);
                DragObject dragObject = dragController.f16102k;
                dragObject.f16517a = iArr2[0];
                dragObject.f16518b = iArr2[c7];
                dragController.checkTouchMove(dropTargetFindDropTarget);
            }
            FolderPagedView folderPagedView2 = folder.mContent;
            folderPagedView2.z0(folderPagedView2.getNextPage());
        } else {
            str = "alpha";
            f6 = 0.0f;
            c6 = 0;
        }
        Objects.toString(folderIcon);
        if (((FolderInfo) folderIcon.getTag()).container == -101) {
            CellLayout cellLayout = (CellLayout) folderIcon.getParent().getParent();
            CellLayoutLayoutParams cellLayoutLayoutParams = (CellLayoutLayoutParams) folderIcon.getLayoutParams();
            int i10 = cellLayoutLayoutParams.f15685a;
            int i11 = cellLayoutLayoutParams.f15686b;
            int[] iArr3 = cellLayout.f15446A;
            iArr3[c6] = i10;
            iArr3[1] = i11;
            cellLayout.invalidate();
        }
        copyFolderIconToImage(folderIcon);
        folderIcon.setVisibility(4);
        float[] fArr = new float[1];
        fArr[c6] = f6;
        PropertyValuesHolder propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat(str, fArr);
        float[] fArr2 = new float[1];
        fArr2[c6] = 2.0f;
        PropertyValuesHolder propertyValuesHolderOfFloat2 = PropertyValuesHolder.ofFloat("scaleX", fArr2);
        float[] fArr3 = new float[1];
        fArr3[c6] = 2.0f;
        PropertyValuesHolder propertyValuesHolderOfFloat3 = PropertyValuesHolder.ofFloat("scaleY", fArr3);
        ImageView imageView = this.mFolderIconImageView;
        PropertyValuesHolder[] propertyValuesHolderArr = new PropertyValuesHolder[2];
        propertyValuesHolderArr[c6] = propertyValuesHolderOfFloat2;
        propertyValuesHolderArr[1] = propertyValuesHolderOfFloat3;
        ObjectAnimator objectAnimatorOfPropertyValuesHolder2 = LauncherAnimUtils.ofPropertyValuesHolder(imageView, propertyValuesHolderArr);
        ImageView imageView2 = this.mFolderIconImageView;
        PropertyValuesHolder[] propertyValuesHolderArr2 = new PropertyValuesHolder[1];
        propertyValuesHolderArr2[c6] = propertyValuesHolderOfFloat;
        ObjectAnimator objectAnimatorOfPropertyValuesHolder3 = LauncherAnimUtils.ofPropertyValuesHolder(imageView2, propertyValuesHolderArr2);
        if (Utilities.f16752m) {
            objectAnimatorOfPropertyValuesHolder2.setInterpolator(new PathInterpolator(0.755f, 0.05f, 0.855f, 0.06f));
            objectAnimatorOfPropertyValuesHolder3.setInterpolator(new PathInterpolator(0.26f, 0.55f, 0.46f, 0.86f));
        }
        objectAnimatorOfPropertyValuesHolder3.setDuration(getResources().getInteger(R.integer.config_growAndFadeOutFolderIcon));
        objectAnimatorOfPropertyValuesHolder2.setDuration(getResources().getInteger(R.integer.config_growAndFadeOutFolderIcon));
        objectAnimatorOfPropertyValuesHolder3.start();
        objectAnimatorOfPropertyValuesHolder2.start();
        BlurScreenLayout blurScreenLayout = this.mBlurBackgroundView;
        if (blurScreenLayout != null) {
            blurScreenLayout.runOnMainThread(new RunnableC0054W(15, blurScreenLayout, obj));
        }
        folder.sendAccessibilityEvent(32);
        getDragLayer().sendAccessibilityEvent(2048);
    }

    public void openWidgetView(boolean z5, boolean z6) {
        if (z6) {
            this.mWidgetsView.f17189W.n0(0);
        }
        LauncherState launcherState = LauncherState.f16048n;
        LauncherState launcherState2 = this.mState;
        if (launcherState2 == LauncherState.f16045k || launcherState2 == LauncherState.f16047m || launcherState2 == LauncherState.f16049o) {
            getWorkspace().setState(WorkspaceState.f15308n);
            if (this.mWidgetsView.f23527a0.mo893c() <= 0) {
                notifyWidgetProvidersChanged();
            }
            this.mWidgetsView.postOnAnimation(new LauncherWorkspaceTask(this, 1));
            this.mState = launcherState;
            this.mUserPresent = false;
            updateAutoAdvanceState();
            closeFolder();
            getWindow().getDecorView().sendAccessibilityEvent(32);
        }
    }

    public boolean overrideWallpaperDimensions() {
        LauncherCallbacks launcherCallbacks = this.mLauncherCallbacks;
        if (launcherCallbacks == null) {
            return true;
        }
        launcherCallbacks.getClass();
        return false;
    }

    public void populateCustomContentContainer() {
        LauncherCallbacks launcherCallbacks = this.mLauncherCallbacks;
        if (launcherCallbacks != null) {
            IOSLauncher iOSLauncher = ((IOSLauncherCallbacks) launcherCallbacks).f16589a;
            ViewOnClickListenerC2791d viewOnClickListenerC2791d = new ViewOnClickListenerC2791d(iOSLauncher);
            iOSLauncher.leftPage = viewOnClickListenerC2791d;
            iOSLauncher.addToCustomContentPage(viewOnClickListenerC2791d, viewOnClickListenerC2791d.getCallBack(), "custom_content", 0);
            AppsLibraryView appsLibraryView = new AppsLibraryView(iOSLauncher);
            iOSLauncher.appsLibraryLayout = appsLibraryView;
            iOSLauncher.addToCustomContentPage(appsLibraryView, appsLibraryView.getCallBack(), "apps_library", 1);
        }
    }

    public void rearrangeApps(boolean z5) {
        Workspace workspace = this.mWorkspace;
        if (workspace == null || !workspace.isAttachedToWindow()) {
            return;
        }
        workspace.postOnAnimationDelayed(new MergedViewRunnable(workspace, z5, 2), 100L);
    }

    public boolean removeItem(View view, ItemInfo itemInfo, boolean z5) {
        boolean z6 = false;
        Objects.toString(view);
        Objects.toString(itemInfo);
        if (itemInfo instanceof ShortcutInfo) {
            FolderInfo folderInfo = (FolderInfo) sFolders.get(itemInfo.container);
            if (folderInfo != null) {
                folderInfo.remove((ShortcutInfo) itemInfo);
            } else {
                this.mWorkspace.l1(view);
            }
            if (!z5) {
                return true;
            }
            LauncherModel.deleteItemFromDatabase(this, itemInfo);
            return true;
        }
        if (itemInfo instanceof FolderInfo) {
            FolderInfo folderInfo2 = (FolderInfo) itemInfo;
            Objects.toString(folderInfo2);
            sFolders.remove(folderInfo2.id);
            this.mWorkspace.l1(view);
            if (!z5) {
                return true;
            }
            HandlerThread handlerThread = LauncherModel.sWorkerThread;
            Objects.toString(this);
            Objects.toString(folderInfo2);
            LauncherModel.m7567y(new MergedModelRunnable(getContentResolver(), folderInfo2, 11, z6));
            return true;
        }
        if (!(itemInfo instanceof LauncherAppWidgetInfo)) {
            return false;
        }
        LauncherAppWidgetInfo launcherAppWidgetInfo = (LauncherAppWidgetInfo) itemInfo;
        this.mWorkspace.l1(view);
        AppWidgetHostView appWidgetHostView = launcherAppWidgetInfo.f16573F;
        if (this.mWidgetsToAdvance.containsKey(appWidgetHostView)) {
            this.mWidgetsToAdvance.remove(appWidgetHostView);
            updateAutoAdvanceState();
        }
        launcherAppWidgetInfo.f16573F = null;
        if (!z5) {
            return true;
        }
        removeAppWidget(launcherAppWidgetInfo);
        return true;
    }

    public void removeOnTinyDBChangeListener(InterfaceC0040H interfaceC0040H) {
        Iterator it = this.mTinyDBChange.f138a.iterator();
        while (it.hasNext()) {
            InterfaceC0040H interfaceC0040H2 = (InterfaceC0040H) ((WeakReference) it.next()).get();
            if (interfaceC0040H2 == null || interfaceC0040H2 == interfaceC0040H) {
                it.remove();
            }
        }
    }

    public Drawable resizeIconDrawable(Drawable drawable) {
        Objects.toString(drawable);
        int i6 = this.mDeviceProfile.f15978D;
        drawable.setBounds(0, 0, i6, i6);
        return drawable;
    }

    public void sendAdvanceMessage(long j6) {
        this.mHandler.removeMessages(1);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), j6);
        this.mAutoAdvanceSentTime = System.currentTimeMillis();
    }

    public boolean setLauncherCallbacks(LauncherCallbacks launcherCallbacks) {
        Objects.toString(launcherCallbacks);
        this.mLauncherCallbacks = launcherCallbacks;
        launcherCallbacks.getClass();
        return true;
    }

    public void setLauncherOverlay(SimpleCallback simpleCallback) {
        Objects.toString(simpleCallback);
        if (simpleCallback != null) {
            simpleCallback.m7805a();
        }
        this.mWorkspace.setLauncherOverlay(simpleCallback);
    }

    @Override // com.luutinhit.launcher6.LauncherModelCallbacks
    public boolean setLoadOnResume() {
        if (!this.mPaused) {
            return false;
        }
        this.mOnResumeNeedsLoad = true;
        return true;
    }

    public void setOnTinyDBChangeListener(InterfaceC0040H interfaceC0040H) {
        this.mTinyDBChange.f138a.add(new WeakReference(interfaceC0040H));
    }

    public void setOrientation() {
        if (this.mRotationEnabled) {
            unlockScreenOrientation(true);
        } else {
            setRequestedOrientation(5);
        }
    }

    public void setShaking(boolean z5) {
        this.mIsShaking = z5;
    }

    public void showAppsLibrary() {
        if (this.appsLibraryLayout != null) {
            ObjectAnimator objectAnimatorOfPropertyValuesHolder = LauncherAnimUtils.ofPropertyValuesHolder(this.appsLibraryLayout, PropertyValuesHolder.ofFloat("alpha", 1.0f), PropertyValuesHolder.ofFloat("scaleX", 1.0f), PropertyValuesHolder.ofFloat("scaleY", 1.0f));
            objectAnimatorOfPropertyValuesHolder.setDuration(268L);
            objectAnimatorOfPropertyValuesHolder.setInterpolator(new PathInterpolator(0.0f, 0.0f, 0.58f, 1.0f));
            objectAnimatorOfPropertyValuesHolder.start();
        }
    }

    public void showAppsView(boolean z5, boolean z6, boolean z7, boolean z8) {
        applyLauncherState(LauncherState.f16046l);
    }

    public void showBlurWallpaperBackground(float f6) {
        BlurWallpaperBackground blurWallpaperBackground = this.mBlurWallpaperBackground;
        if (blurWallpaperBackground != null) {
            blurWallpaperBackground.setAlpha(f6);
        }
    }

    public void showDeleteOrUninstallDialog(boolean z5, Object obj, Pair<ComponentName, Integer> pair) {
        if (obj instanceof ItemInfo) {
            if (this.mDeleteDialog == null) {
                C0067j c0067j = new C0067j(this);
                c0067j.setClickable(true);
                c0067j.setFocusable(true);
                c0067j.setBackgroundColor(1711276032);
                c0067j.f179t = this.isDarkMode;
                LayoutInflater.from(this).inflate(R.layout.dialog_content_view, (ViewGroup) c0067j, true);
                c0067j.f173n = (LinearLayoutRound) c0067j.findViewById(R.id.dialog_root);
                c0067j.f174o = (TextView) c0067j.findViewById(R.id.tvTitle);
                c0067j.f175p = (TextView) c0067j.findViewById(R.id.tvMessage);
                c0067j.f176q = (AppCompatButton) c0067j.findViewById(R.id.btnAction1);
                c0067j.f177r = (AppCompatButton) c0067j.findViewById(R.id.btnAction2);
                c0067j.f178s = (AppCompatButton) c0067j.findViewById(R.id.btnCancel);
                c0067j.f174o.setTextColor(c0067j.f179t ? -1 : -16777216);
                c0067j.f175p.setTextColor(c0067j.f179t ? -1 : -16777216);
                c0067j.f173n.setDarkModeBackgroundColor(c0067j.f179t ? -872415232 : -858401323);
                int i6 = 1;
                c0067j.setOnClickListener(new View.OnClickListener() { // from class: B3.f
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        switch (i6) {
                            case 0:
                                c0067j.m177a();
                                break;
                            default:
                                c0067j.m177a();
                                break;
                        }
                    }
                });
                this.mDeleteDialog = c0067j;
            }
            C0067j c0067j2 = this.mDeleteDialog;
            c0067j2.f174o.setText(getString(R.string.delete_target_label) + " \"" + ((Object) ((ItemInfo) obj).title) + "\"?");
            c0067j2.f175p.setText(R.string.remove_app_message);
            ViewOnClickListenerC0045M viewOnClickListenerC0045M = new ViewOnClickListenerC0045M(1, this, pair);
            c0067j2.f176q.setText(R.string.delete_target_label);
            c0067j2.f176q.setOnClickListener(new ViewOnClickListenerC0065h(0, viewOnClickListenerC0045M));
            c0067j2.f178s.setText(c0067j2.getContext().getString(android.R.string.cancel));
            int i7 = 0;
            c0067j2.f178s.setOnClickListener(new View.OnClickListener() { // from class: B3.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (i7) {
                        case 0:
                            c0067j2.m177a();
                            break;
                        default:
                            c0067j2.m177a();
                            break;
                    }
                }
            });
            if (z5) {
                AppCompatButton appCompatButton = this.mDeleteDialog.f177r;
                if (appCompatButton != null) {
                    appCompatButton.setVisibility(8);
                }
            } else {
                C0067j c0067j3 = this.mDeleteDialog;
                LauncherClickListenerA launcherClickListenerA = new LauncherClickListenerA(this, (ItemInfo) obj, pair);
                c0067j3.f177r.setText(R.string.delete_target_uninstall_label);
                c0067j3.f177r.setOnClickListener(new ViewOnClickListenerC0065h(1, launcherClickListenerA));
            }
            if (this.mDeleteDialog.getParent() != null) {
                this.mDeleteDialog.bringToFront();
                this.mDeleteDialog.animate().alpha(1.0f).setDuration(150L).start();
                return;
            }
            C0067j c0067j4 = this.mDeleteDialog;
            DragLayer dragLayer = this.mDragLayer;
            if (c0067j4.getParent() != null) {
                return;
            }
            c0067j4.setAlpha(0.0f);
            InsertAbleFrameLayoutParams insertAbleFrameLayoutParams = new InsertAbleFrameLayoutParams(-1, -1);
            ((FrameLayout.LayoutParams) insertAbleFrameLayoutParams).gravity = 17;
            dragLayer.addView(c0067j4, insertAbleFrameLayoutParams);
            c0067j4.animate().withLayer().alpha(1.0f).setDuration(236L).start();
            c0067j4.f173n.setScaleX(1.5f);
            c0067j4.f173n.setScaleY(1.5f);
            c0067j4.f173n.animate().withLayer().scaleX(1.0f).scaleY(1.0f).setDuration(286L).setInterpolator(new DecelerateInterpolator(1.36f)).start();
        }
    }

    public boolean showFirstRunActivity() {
        Intent firstRunActivity;
        if (ActivityManager.isRunningInTestHarness() || this.mSharedPrefs.getBoolean(FIRST_RUN_ACTIVITY_DISPLAYED, false) || !hasFirstRunActivity() || (firstRunActivity = getFirstRunActivity()) == null) {
            return false;
        }
        startActivity(firstRunActivity);
        SharedPreferences.Editor editorEdit = this.mSharedPrefs.edit();
        editorEdit.putBoolean(FIRST_RUN_ACTIVITY_DISPLAYED, true);
        editorEdit.apply();
        return true;
    }

    public void showFirstRunClings() {
        LauncherClings launcherClings = new LauncherClings(this);
        SharedPreferences sharedPrefs = getSharedPrefs();
        if (ActivityManager.isRunningInTestHarness() || ((AccessibilityManager) getSystemService("accessibility")).isTouchExplorationEnabled()) {
            return;
        }
        if ((Utilities.f16755p && ((UserManager) getSystemService("user")).getUserRestrictions().getBoolean("no_modify_accounts", false)) || Settings.Secure.getInt(getContentResolver(), "skip_first_use_hints", 0) == 1 || sharedPrefs.getBoolean("cling_gel.workspace.dismissed", false) || sharedPrefs.getBoolean("cling_gel.migration.dismissed", false)) {
            return;
        }
        this.mClings = launcherClings;
        LauncherModel launcherModel = this.mModel;
        launcherModel.getClass();
        Objects.toString(this);
        if (!launcherModel.f15342j || isLauncherPreinstalled()) {
            launcherClings.showLongPressCling(true);
            return;
        }
        launcherClings.f16800l = true;
        hideWorkspaceSearchAndHotseat();
        View viewInflate = launcherClings.f16799k.inflate(R.layout.migration_cling, (ViewGroup) findViewById(R.id.launcher));
        viewInflate.findViewById(R.id.cling_dismiss_migration_copy_apps).setOnClickListener(launcherClings);
        viewInflate.findViewById(R.id.cling_dismiss_migration_use_default).setOnClickListener(launcherClings);
    }

    public void showFolderBlurBackground(float f6) {
        BlurScreenLayout blurScreenLayout = this.mBlurBackgroundView;
        if (blurScreenLayout != null) {
            blurScreenLayout.runOnMainThread(new BlurAnimRunnable(blurScreenLayout, f6, 0));
        }
    }

    public void showIntroScreen() {
        View introScreen = getIntroScreen();
        changeWallpaperVisiblity(false);
        if (introScreen != null) {
            this.mDragLayer.showOverlayView(introScreen);
        }
    }

    public void showOutOfSpaceMessage(boolean z5) {
        Toast.makeText(this, getString(z5 ? R.string.hotseat_out_of_space : R.string.out_of_space), 0).show();
    }

    public void showOverviewMode(boolean z5) {
        if (this.mIsShaking) {
            cancelShakingAnimation();
        } else {
            onShakingAllApps();
        }
    }

    public void showPopupToChangeLabel(int i6, CharSequence charSequence) {
        DialogC1104f dialogC1104f = this.mEditWidgetLabelDialog;
        if (dialogC1104f != null) {
            dialogC1104f.f3230o = i6;
            AppCompatEditText appCompatEditText = dialogC1104f.f3229n;
            appCompatEditText.setHint(charSequence);
            appCompatEditText.requestFocus();
            dialogC1104f.show();
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.copyFrom(dialogC1104f.getWindow().getAttributes());
            layoutParams.width = (dialogC1104f.f3228m.screenWidth * 3) / 4;
            dialogC1104f.getWindow().setAttributes(layoutParams);
        }
    }

    public void showWidgetsView(boolean z5, boolean z6) {
        if (z6) {
            this.mWidgetsView.f17189W.n0(0);
        }
        applyLauncherState(LauncherState.f16048n);
        this.mWidgetsView.post(new LauncherWorkspaceRunnable(this, 0));
    }

    public boolean showWorkspace(boolean z5) {
        return showWorkspace(-1, z5, null);
    }

    public void showWorkspaceSearchAndHotseat() {
        Workspace workspace = this.mWorkspace;
        if (workspace != null) {
            workspace.setAlpha(1.0f);
        }
        Hotseat hotseat = this.mHotseat;
        if (hotseat != null) {
            hotseat.setAlpha(1.0f);
        }
        View view = this.mPageIndicators;
        if (view != null) {
            view.setAlpha(1.0f);
        }
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i6) {
        try {
            Objects.toString(intent);
            if (i6 >= 0) {
                setWaitingForResult(true);
            }
            super.startActivityForResult(intent, i6);
        } catch (Throwable unused) {
            Toast.makeText(this, getString(R.string.activity_not_found), 1).show();
        }
    }

    public boolean startActivitySafely(final View view, final Intent intent, final Object obj) {
        Objects.toString(view);
        Objects.toString(intent);
        Objects.toString(obj);
        if (intent == null) {
            return false;
        }
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        if (!this.mIsSafeModeEnabled || Utilities.isSystemApp(this, intent)) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.luutinhit.launcher6.t1
                @Override // java.lang.Runnable
                public final void run() {
                    AtomicBoolean atomicBoolean2 = atomicBoolean;
                    View view2 = view;
                    Intent intent2 = intent;
                    Object obj2 = obj;
                    Launcher launcher = Launcher.this;
                    try {
                        atomicBoolean2.set(launcher.startActivity(view2, intent2, obj2));
                    } catch (ActivityNotFoundException unused) {
                        Toast.makeText(launcher, R.string.activity_not_found, 0).show();
                        Objects.toString(obj2);
                        Objects.toString(intent2);
                    }
                }
            });
            return atomicBoolean.get();
        }
        Toast.makeText(this, R.string.safemode_shortcut_error, 0).show();
        return false;
    }

    public void startAppShortcutOrInfoActivity(View view) {
        Intent intent;
        ShortcutInfo shortcutInfo;
        Objects.toString(view);
        LauncherCallbacks launcherCallbacks = this.mLauncherCallbacks;
        if (launcherCallbacks != null) {
            IOSLauncher iOSLauncher = ((IOSLauncherCallbacks) launcherCallbacks).f16589a;
            if (iOSLauncher.isOpenCloseAnim) {
                iOSLauncher.zoomInLauncherView();
            }
        }
        Object tag = view.getTag();
        if (tag instanceof ShortcutInfo) {
            shortcutInfo = (ShortcutInfo) tag;
            intent = shortcutInfo.f16553A;
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int i6 = iArr[0];
            intent.setSourceBounds(new Rect(i6, iArr[1], view.getWidth() + i6, view.getHeight() + iArr[1]));
        } else {
            if (!(tag instanceof AppInfo)) {
                throw new IllegalArgumentException("Input must be a Shortcut or AppInfo");
            }
            intent = ((AppInfo) tag).f16326A;
            shortcutInfo = null;
        }
        boolean zStartActivitySafely = startActivitySafely(view, intent, tag);
        Stats stats = this.mStats;
        stats.getClass();
        Intent intent2 = new Intent(intent);
        intent2.setSourceBounds(null);
        Intent intentPutExtra = new Intent("com.luutinhit.launcher6.action.LAUNCH").putExtra("intent", intent2.toUri(0));
        if (shortcutInfo != null) {
            intentPutExtra.putExtra("container", shortcutInfo.container).putExtra("screen", shortcutInfo.screenId).putExtra("cellX", shortcutInfo.cellX).putExtra("cellY", shortcutInfo.cellY);
        }
        Bundle bundle = new Bundle();
        bundle.putString("container", "homescreen");
        bundle.putInt("container_page", 0);
        bundle.putInt("sub_container_page", 0);
        FocusHelper.m7980h(view, bundle);
        intentPutExtra.putExtra("source", bundle);
        Launcher launcher = stats.f16578a;
        for (String str : launcher.getResources().getStringArray(R.array.launch_broadcast_targets)) {
            intentPutExtra.setPackage(str);
            launcher.sendBroadcast(intentPutExtra, stats.mLaunchBroadcastPermission);
        }
        if (zStartActivitySafely && (view instanceof BubbleTextView)) {
            this.mWaitingForResume = (BubbleTextView) view;
            this.mWorkerHandler.obtainMessage(3, view).sendToTarget();
        }
    }

    public void startApplicationDetailsActivity(ComponentName componentName, C2673q c2673q) {
        Objects.toString(componentName);
        Objects.toString(c2673q);
        try {
            AbstractC2666j.m9657c(this).mo9664h(componentName, c2673q);
        } catch (ActivityNotFoundException unused) {
            Toast.makeText(this, R.string.activity_not_found, 0).show();
        } catch (SecurityException unused2) {
            Toast.makeText(this, R.string.activity_not_found, 0).show();
        }
    }

    public boolean startApplicationUninstallActivity(ComponentName componentName, int i6, C2673q c2673q) {
        UserHandle userHandle;
        Objects.toString(componentName);
        Objects.toString(c2673q);
        if ((i6 & 1) == 0) {
            Toast.makeText(this, R.string.uninstall_system_app_text, 0).show();
            return false;
        }
        Intent intent = new Intent("android.intent.action.DELETE", Uri.fromParts("package", componentName.getPackageName(), componentName.getClassName()));
        intent.setFlags(276824064);
        if (c2673q != null && Utilities.f16752m && (userHandle = c2673q.f20687a) != null) {
            intent.putExtra("android.intent.extra.USER", userHandle);
        }
        startActivity(intent);
        return true;
    }

    @Override // com.luutinhit.launcher6.LauncherModelCallbacks
    public void startBinding() {
        boolean zIsWorkspaceLocked = isWorkspaceLocked();
        this.mWorkspaceLoading = true;
        if (zIsWorkspaceLocked != isWorkspaceLocked()) {
            onWorkspaceLockedChanged();
        }
        this.mBindOnResumeCallbacks.clear();
        Workspace workspace = this.mWorkspace;
        workspace.getClass();
        workspace.a1(false, new MergedItemCallbacks(6, workspace));
        this.mWorkspace.g1();
        this.mWidgetsToAdvance.clear();
    }

    public void startDrag(View view, ItemInfo itemInfo, DragSource dragSource) {
        Objects.toString(view);
        Objects.toString(itemInfo);
        Objects.toString(dragSource);
        view.setTag(itemInfo);
        Workspace workspace = this.mWorkspace;
        workspace.getClass();
        Objects.toString(view);
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (view instanceof BubbleTextView) {
            BubbleTextView bubbleTextView = (BubbleTextView) view;
            Objects.toString(bubbleTextView);
            Drawable icon = bubbleTextView.getIcon();
            Objects.toString(icon);
            Rect rect = new Rect();
            icon.copyBounds(rect);
            if (rect.width() == 0 || rect.height() == 0) {
                rect.set(0, 0, icon.getIntrinsicWidth(), icon.getIntrinsicHeight());
            } else {
                rect.offsetTo(0, 0);
            }
            if (icon instanceof PreloadIconDrawable) {
                int i6 = -((PreloadIconDrawable) icon).f16231f;
                rect.inset(i6, i6);
            }
            measuredWidth = rect.width();
            measuredHeight = rect.height();
        }
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, config);
        Canvas canvas = workspace.mCanvas;
        canvas.setBitmap(bitmapCreateBitmap);
        Workspace.G0(view, canvas, 0);
        canvas.setBitmap(null);
        Workspace workspace2 = this.mWorkspace;
        workspace2.getClass();
        Objects.toString(view);
        Objects.toString(dragSource);
        int i7 = workspace2.grid.f15978D;
        Launcher launcher = workspace2.f23432V0;
        launcher.onDragStarted(view);
        AtomicInteger atomicInteger = new AtomicInteger(2);
        Bitmap bitmapE0 = workspace2.E0(view, atomicInteger);
        Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(i7, i7, config);
        Paint paint = new Paint();
        paint.setFilterBitmap(true);
        Canvas canvas2 = workspace2.mCanvas;
        canvas2.setBitmap(bitmapCreateBitmap2);
        canvas2.drawBitmap(bitmapE0, new Rect(0, 0, bitmapE0.getWidth(), bitmapE0.getHeight()), new Rect(0, 0, i7, i7), paint);
        canvas2.setBitmap(null);
        float width = bitmapE0.getWidth();
        DragLayer dragLayer = launcher.getDragLayer();
        int[] iArr = workspace2.m1;
        float locationInDragLayer = dragLayer.getLocationInDragLayer(view, iArr) * (width / i7);
        int iRound = Math.round(iArr[0] - ((width - (view.getWidth() * locationInDragLayer)) / 2.0f));
        int iRound2 = Math.round(iArr[1]);
        Point point = new Point((-atomicInteger.get()) / 2, atomicInteger.get() / 2);
        Rect rect2 = new Rect(0, 0, i7, i7);
        if (view.getTag() != null && (view.getTag() instanceof ItemInfo)) {
            workspace2.f23434X0.startDrag(bitmapCreateBitmap2, iRound, iRound2, dragSource, view.getTag(), 0, point, rect2, locationInDragLayer, false).setIntrinsicIconScaleFactor(dragSource.getIntrinsicIconScaleFactor());
            bitmapE0.recycle();
        } else {
            throw new IllegalStateException("Drag started with a view that has no tag set. This will cause a crash (issue 11627249) down the line. View: " + view + "  tag: " + view.getTag());
        }
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(IntentSender intentSender, int i6, Intent intent, int i7, int i8, int i9, Bundle bundle) {
        Objects.toString(intentSender);
        Objects.toString(intent);
        Objects.toString(bundle);
        if (i6 >= 0) {
            setWaitingForResult(true);
        }
        try {
            super.startIntentSenderForResult(intentSender, i6, intent, i7, i8, i9, bundle);
        } catch (IntentSender.SendIntentException unused) {
            throw new ActivityNotFoundException();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0011, code lost:
    
        if (r0.isSetWallpaperAllowed() != false) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean startWallpaperPicker(View view) {
        try {
            if (Utilities.f16745f) {
                WallpaperManager wallpaperManager = (WallpaperManager) getSystemService(WallpaperManager.class);
                Objects.requireNonNull(wallpaperManager);
            }
            Intent intentPutExtra = new Intent("android.intent.action.SET_WALLPAPER").putExtra(EXTRA_WALLPAPER_OFFSET, getWorkspace().getWallpaperOffsetForCenterPage());
            intentPutExtra.addFlags(32768);
            String string = getString(R.string.wallpaper_picker_package);
            if (TextUtils.isEmpty(string)) {
                intentPutExtra.putExtra(INTENT_EXTRA_IGNORE_LAUNCH_ANIMATION, true);
            } else {
                intentPutExtra.setPackage(string);
            }
            return startActivitySafely(view, intentPutExtra, null);
        } catch (Throwable unused) {
        }
        Toast.makeText(this, R.string.msg_disabled_by_admin, 0).show();
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:126:0x0197 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:127:0x0199 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:129:0x019f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:130:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:131:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:135:0x01b9  */
    /* JADX WARN: Code duplicated, block: B:136:0x01c6  */
    /* JADX WARN: Code duplicated, block: B:194:0x03d5  */
    /* JADX WARN: Code duplicated, block: B:195:0x03d7  */
    /* JADX WARN: Code duplicated, block: B:198:0x03dd A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:199:0x03df  */
    /* JADX WARN: Code duplicated, block: B:200:0x0409  */
    /* JADX WARN: Code duplicated, block: B:203:0x0416  */
    /* JADX WARN: Code duplicated, block: B:205:0x041c  */
    /* JADX WARN: Code duplicated, block: B:206:0x041e  */
    /* JADX WARN: Code duplicated, block: B:210:0x0428  */
    public Animator startWorkspaceStateChangeAnimation(WorkspaceState workspaceState, int i6, boolean z5, HashMap<View, Integer> map) {
        com.luutinhit.launcher6.JadxSupport.useOriginalBytecode(); // jadx flagged this method; the original bytecode runs
        int i7;
        DragLayer dragLayer;
        float backgroundAlpha;
        float f6;
        WorkspaceState workspaceState2;
        boolean z6 = false;
        ViewPropertyAnimatorProperty viewPropertyAnimatorProperty;
        Animator animatorOfFloat;
        int i8;
        Workspace workspace;
        float f7 = 0.0f;
        float f8;
        Objects.toString(workspaceState);
        Objects.toString(map);
        WorkspaceState state = this.mWorkspace.getState();
        Workspace workspace2 = this.mWorkspace;
        workspace2.getClass();
        Objects.toString(workspaceState);
        Objects.toString(map);
        WorkspaceState workspaceState3 = workspace2.mState;
        WorkspaceStateTransitionAnimation workspaceStateTransitionAnimation = workspace2.f23418K1;
        Launcher launcher = workspaceStateTransitionAnimation.f15358a;
        boolean zIsEnabled = ((AccessibilityManager) launcher.getSystemService("accessibility")).isEnabled();
        WorkspaceState workspaceState4 = WorkspaceState.f15305k;
        boolean z7 = workspaceState3 == workspaceState4;
        WorkspaceState workspaceState5 = WorkspaceState.f15309o;
        boolean z8 = workspaceState3 == workspaceState5;
        boolean z9 = workspaceState == workspaceState4;
        boolean z10 = workspaceState == WorkspaceState.f15307m;
        boolean z11 = workspaceState == WorkspaceState.f15306l;
        boolean z12 = workspaceState == WorkspaceState.f15310p;
        boolean z13 = workspaceState == workspaceState5;
        boolean z14 = z7 && z13;
        boolean z15 = z7 && z11;
        boolean z16 = z8 && z9;
        boolean z17 = z8 && z12;
        boolean z18 = z11 && z9;
        if (z15 || z17) {
            i7 = workspaceStateTransitionAnimation.mAllAppsTransitionTime;
        } else {
            i7 = (z14 || z16) ? workspaceStateTransitionAnimation.mOverviewTransitionTime : workspaceStateTransitionAnimation.mOverlayTransitionTime;
        }
        int i9 = i7;
        Workspace workspace3 = workspaceStateTransitionAnimation.f15359b;
        int childCount = workspace3.getChildCount();
        boolean z19 = z11;
        if (-1 != childCount) {
            workspaceStateTransitionAnimation.f15361d = new float[childCount];
            workspaceStateTransitionAnimation.f15362e = new float[childCount];
            workspaceStateTransitionAnimation.f15363f = new float[childCount];
            workspaceStateTransitionAnimation.f15364g = new float[childCount];
        }
        AnimatorSet animatorSet = workspaceStateTransitionAnimation.f15360c;
        boolean z20 = z12;
        if (animatorSet != null) {
            animatorSet.setDuration(0L);
            workspaceStateTransitionAnimation.f15360c.cancel();
        }
        workspaceStateTransitionAnimation.f15360c = null;
        if (z5) {
            workspaceStateTransitionAnimation.f15360c = LauncherAnimUtils.createAnimatorSet();
        }
        float f9 = (z10 || z13) ? 1.0f : 0.0f;
        float f10 = (z9 || z10) ? 1.0f : 0.0f;
        float f11 = z13 ? 1.0f : 0.0f;
        float overviewModeTranslationY = (z13 || z20) ? workspace3.getOverviewModeTranslationY() : 0.0f;
        boolean z21 = z8;
        int childCount2 = workspace3.getChildCount();
        int iD1 = workspace3.d1();
        workspaceStateTransitionAnimation.f15365h = 1.0f;
        if (z21) {
            workspace3.disableFreeScroll();
        } else if (z13) {
            workspace3.enableFreeScroll();
        }
        if (!z9) {
            if (z10) {
                workspaceStateTransitionAnimation.f15365h = workspaceStateTransitionAnimation.mSpringLoadedShrinkFactor;
            } else if (z13 || z20) {
                workspaceStateTransitionAnimation.f15365h = workspaceStateTransitionAnimation.mOverviewModeShrinkFactor;
            }
        }
        int pageNearestToCenterOfScreen = i6;
        if (pageNearestToCenterOfScreen == -1) {
            pageNearestToCenterOfScreen = workspace3.getPageNearestToCenterOfScreen();
        }
        int iT0 = workspace3.t0(pageNearestToCenterOfScreen);
        int scrollForPage = workspace3.getScrollForPage(iT0) - workspace3.getUnboundedScrollX();
        ZoomInInterpolator zoomInInterpolator = workspaceStateTransitionAnimation.f15366i;
        int i10 = pageNearestToCenterOfScreen;
        workspace3.n0(iT0, scrollForPage, i9, false, zoomInInterpolator);
        int i11 = 0;
        while (i11 < childCount2) {
            CellLayout cellLayout = (CellLayout) workspace3.getChildAt(i11);
            boolean z22 = i11 == i10;
            float alpha = cellLayout.getShortcutsAndWidgets().getAlpha();
            if (z19 || z20) {
                workspace = workspace2;
            } else {
                workspace = workspace2;
                f7 = (!z9 || !workspaceStateTransitionAnimation.f15373p || i11 == i10 || i11 < iD1) ? 1.0f : 0.0f;
                if (!z15 || z18) {
                    if (!z18 && z22) {
                        f8 = 0.0f;
                    } else if (z22) {
                        f8 = alpha;
                    } else {
                        f8 = 0.0f;
                        f7 = 0.0f;
                    }
                    cellLayout.setShortcutAndWidgetAlpha(f8);
                    alpha = f8;
                } else {
                    i10 = i10;
                }
                workspaceStateTransitionAnimation.f15362e[i11] = alpha;
                workspaceStateTransitionAnimation.f15364g[i11] = f7;
                if (z5) {
                    workspaceStateTransitionAnimation.f15361d[i11] = cellLayout.getBackgroundAlpha();
                    workspaceStateTransitionAnimation.f15363f[i11] = f9;
                } else {
                    cellLayout.setBackgroundAlpha(f9);
                    cellLayout.setShortcutAndWidgetAlpha(f7);
                }
                i11++;
                i10 = i10;
                workspace2 = workspace;
            }
            if (z15) {
                if (!z18) {
                    if (z22) {
                        f8 = 0.0f;
                        f7 = 0.0f;
                    } else {
                        f8 = alpha;
                    }
                } else if (z22) {
                    f8 = 0.0f;
                    f7 = 0.0f;
                } else {
                    f8 = alpha;
                }
                cellLayout.setShortcutAndWidgetAlpha(f8);
                alpha = f8;
            } else {
                if (!z18) {
                    if (z22) {
                        f8 = 0.0f;
                        f7 = 0.0f;
                    } else {
                        f8 = alpha;
                    }
                } else if (z22) {
                    f8 = 0.0f;
                    f7 = 0.0f;
                } else {
                    f8 = alpha;
                }
                cellLayout.setShortcutAndWidgetAlpha(f8);
                alpha = f8;
            }
            workspaceStateTransitionAnimation.f15362e[i11] = alpha;
            workspaceStateTransitionAnimation.f15364g[i11] = f7;
            if (z5) {
                workspaceStateTransitionAnimation.f15361d[i11] = cellLayout.getBackgroundAlpha();
                workspaceStateTransitionAnimation.f15363f[i11] = f9;
            } else {
                cellLayout.setBackgroundAlpha(f9);
                cellLayout.setShortcutAndWidgetAlpha(f7);
            }
            i11++;
            i10 = i10;
            workspace2 = workspace;
        }
        Workspace workspace4 = workspace2;
        ViewGroup overviewPanel = launcher.getOverviewPanel();
        Hotseat hotseat = launcher.getHotseat();
        PageIndicator pageIndicator = workspace3.getPageIndicator();
        if (!z5) {
            overviewPanel.setAlpha(f11);
            FadeVisibilityAnimator.m7972a(overviewPanel, zIsEnabled);
            hotseat.setAlpha(f10);
            FadeVisibilityAnimator.m7972a(hotseat, zIsEnabled);
            if (pageIndicator != null) {
                pageIndicator.setAlpha(f10);
                FadeVisibilityAnimator.m7972a(pageIndicator, zIsEnabled);
            }
            int i12 = workspace3.mState == workspaceState4 ? 0 : 4;
            if (workspace3.U0()) {
                ((CellLayout) workspace3.f23401C0.get(-301L)).setVisibility(i12);
            }
            workspace3.setScaleX(workspaceStateTransitionAnimation.f15365h);
            workspace3.setScaleY(workspaceStateTransitionAnimation.f15365h);
            workspace3.setTranslationY(overviewModeTranslationY);
            if (zIsEnabled && overviewPanel.getVisibility() == 0) {
                overviewPanel.getChildAt(0).performAccessibilityAction(64, null);
            }
            dragLayer = launcher.getDragLayer();
            backgroundAlpha = dragLayer.getBackgroundAlpha();
            if (z9) {
                f6 = 0.0f;
            } else {
                f6 = workspaceStateTransitionAnimation.mWorkspaceScrimAlpha;
            }
            if (f6 != backgroundAlpha) {
                if (z5) {
                    ValueAnimator valueAnimatorM7889c = LauncherAnimUtils.m7889c(backgroundAlpha, f6);
                    valueAnimatorM7889c.addUpdateListener(new SharedAnimatorUpdateListener(6, dragLayer));
                    valueAnimatorM7889c.setInterpolator(new DecelerateInterpolator(1.5f));
                    valueAnimatorM7889c.setDuration(350);
                    workspaceStateTransitionAnimation.f15360c.play(valueAnimatorM7889c);
                } else {
                    dragLayer.setBackgroundAlpha(f6);
                }
            }
            AnimatorSet animatorSet2 = workspaceStateTransitionAnimation.f15360c;
            if (!workspace4.mState.f15312j) {
                workspaceState2 = workspaceState;
                z6 = workspaceState2.f15312j;
                workspace4.mState = workspaceState2;
                workspace4.o1();
                if (z6) {
                    workspace4.f23432V0.notifyWidgetProvidersChanged();
                }
                updateInteraction(state, workspaceState2);
                return animatorSet2;
            }
            workspaceState2 = workspaceState;
            workspace4.mState = workspaceState2;
            workspace4.o1();
            if (z6) {
                workspace4.f23432V0.notifyWidgetProvidersChanged();
            }
            updateInteraction(state, workspaceState2);
            return animatorSet2;
        }
        LauncherViewPropertyAnimator launcherViewPropertyAnimator = new LauncherViewPropertyAnimator(workspace3);
        EnumSet enumSet = launcherViewPropertyAnimator.mPropertiesToSet;
        float f12 = workspaceStateTransitionAnimation.f15365h;
        enumSet.add(ViewPropertyAnimatorProperty.f15770l);
        launcherViewPropertyAnimator.f15827n = f12;
        float f13 = workspaceStateTransitionAnimation.f15365h;
        enumSet.add(ViewPropertyAnimatorProperty.f15771m);
        launcherViewPropertyAnimator.f15828o = f13;
        enumSet.add(ViewPropertyAnimatorProperty.f15769k);
        launcherViewPropertyAnimator.f15826m = overviewModeTranslationY;
        long j6 = i9;
        launcherViewPropertyAnimator.setDuration(j6);
        launcherViewPropertyAnimator.setInterpolator(zoomInInterpolator);
        workspaceStateTransitionAnimation.f15360c.play(launcherViewPropertyAnimator);
        int i13 = 0;
        while (true) {
            viewPropertyAnimatorProperty = ViewPropertyAnimatorProperty.f15773o;
            if (i13 >= childCount2) {
                break;
            }
            CellLayout cellLayout2 = (CellLayout) workspace3.getChildAt(i13);
            float alpha2 = cellLayout2.getShortcutsAndWidgets().getAlpha();
            if (workspaceStateTransitionAnimation.f15362e[i13] == 0.0f && workspaceStateTransitionAnimation.f15364g[i13] == 0.0f) {
                cellLayout2.setBackgroundAlpha(workspaceStateTransitionAnimation.f15363f[i13]);
                cellLayout2.setShortcutAndWidgetAlpha(workspaceStateTransitionAnimation.f15364g[i13]);
                i8 = i13;
            } else {
                if (map != null) {
                    map.put(cellLayout2, 0);
                }
                float f14 = workspaceStateTransitionAnimation.f15362e[i13];
                i8 = i13;
                float f15 = workspaceStateTransitionAnimation.f15364g[i8];
                if (f14 != f15 || alpha2 != f15) {
                    LauncherViewPropertyAnimator launcherViewPropertyAnimator2 = new LauncherViewPropertyAnimator(cellLayout2.getShortcutsAndWidgets());
                    float f16 = workspaceStateTransitionAnimation.f15364g[i8];
                    launcherViewPropertyAnimator2.mPropertiesToSet.add(viewPropertyAnimatorProperty);
                    launcherViewPropertyAnimator2.f15829p = f16;
                    launcherViewPropertyAnimator2.setDuration(j6);
                    launcherViewPropertyAnimator2.setInterpolator(zoomInInterpolator);
                    workspaceStateTransitionAnimation.f15360c.play(launcherViewPropertyAnimator2);
                }
                float f17 = workspaceStateTransitionAnimation.f15361d[i8];
                if (f17 != 0.0f || workspaceStateTransitionAnimation.f15363f[i8] != 0.0f) {
                    ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(cellLayout2, "backgroundAlpha", f17, workspaceStateTransitionAnimation.f15363f[i8]);
                    LauncherAnimUtils.m7889c(0.0f, 1.0f);
                    objectAnimatorOfFloat.setInterpolator(zoomInInterpolator);
                    objectAnimatorOfFloat.setDuration(j6);
                    workspaceStateTransitionAnimation.f15360c.play(objectAnimatorOfFloat);
                }
            }
            i13 = i8 + 1;
        }
        ViewPropertyAnimatorProperty viewPropertyAnimatorProperty2 = ViewPropertyAnimatorProperty.f15777s;
        if (pageIndicator != null) {
            LauncherViewPropertyAnimator launcherViewPropertyAnimator3 = new LauncherViewPropertyAnimator(pageIndicator);
            EnumSet enumSet2 = launcherViewPropertyAnimator3.mPropertiesToSet;
            enumSet2.add(viewPropertyAnimatorProperty);
            launcherViewPropertyAnimator3.f15829p = f10;
            enumSet2.add(viewPropertyAnimatorProperty2);
            launcherViewPropertyAnimator3.addListener(new FadeVisibilityAnimator(pageIndicator, zIsEnabled));
            animatorOfFloat = launcherViewPropertyAnimator3;
        } else {
            animatorOfFloat = ValueAnimator.ofFloat(0.0f, 0.0f);
        }
        LauncherViewPropertyAnimator launcherViewPropertyAnimator4 = new LauncherViewPropertyAnimator(hotseat);
        EnumSet enumSet3 = launcherViewPropertyAnimator4.mPropertiesToSet;
        enumSet3.add(viewPropertyAnimatorProperty);
        launcherViewPropertyAnimator4.f15829p = f10;
        launcherViewPropertyAnimator4.addListener(new FadeVisibilityAnimator(hotseat, zIsEnabled));
        LauncherViewPropertyAnimator launcherViewPropertyAnimator5 = new LauncherViewPropertyAnimator(overviewPanel);
        EnumSet enumSet4 = launcherViewPropertyAnimator5.mPropertiesToSet;
        enumSet4.add(viewPropertyAnimatorProperty);
        launcherViewPropertyAnimator5.f15829p = f11;
        launcherViewPropertyAnimator5.addListener(new FadeVisibilityAnimator(overviewPanel, zIsEnabled));
        hotseat.setLayerType(2, null);
        overviewPanel.setLayerType(2, null);
        if (map != null) {
            map.put(hotseat, 1);
            map.put(overviewPanel, 1);
        } else {
            enumSet3.add(viewPropertyAnimatorProperty2);
            enumSet4.add(viewPropertyAnimatorProperty2);
        }
        if (z14) {
            animatorOfFloat.setInterpolator(new DecelerateInterpolator(2.0f));
            launcherViewPropertyAnimator4.setInterpolator(new DecelerateInterpolator(2.0f));
            launcherViewPropertyAnimator5.setInterpolator(null);
        } else if (z16) {
            animatorOfFloat.setInterpolator(null);
            launcherViewPropertyAnimator4.setInterpolator(null);
            launcherViewPropertyAnimator5.setInterpolator(new DecelerateInterpolator(2.0f));
        }
        launcherViewPropertyAnimator5.setDuration(j6);
        animatorOfFloat.setDuration(j6);
        launcherViewPropertyAnimator4.setDuration(j6);
        workspaceStateTransitionAnimation.f15360c.play(launcherViewPropertyAnimator5);
        workspaceStateTransitionAnimation.f15360c.play(launcherViewPropertyAnimator4);
        workspaceStateTransitionAnimation.f15360c.play(animatorOfFloat);
        workspaceStateTransitionAnimation.f15360c.addListener(new C1300b(workspaceStateTransitionAnimation, zIsEnabled, overviewPanel));
        dragLayer = launcher.getDragLayer();
        backgroundAlpha = dragLayer.getBackgroundAlpha();
        if (z9) {
            f6 = 0.0f;
        } else {
            f6 = workspaceStateTransitionAnimation.mWorkspaceScrimAlpha;
        }
        if (f6 != backgroundAlpha) {
            if (z5) {
                ValueAnimator valueAnimatorM7889c2 = LauncherAnimUtils.m7889c(backgroundAlpha, f6);
                valueAnimatorM7889c2.addUpdateListener(new SharedAnimatorUpdateListener(6, dragLayer));
                valueAnimatorM7889c2.setInterpolator(new DecelerateInterpolator(1.5f));
                valueAnimatorM7889c2.setDuration(350);
                workspaceStateTransitionAnimation.f15360c.play(valueAnimatorM7889c2);
            } else {
                dragLayer.setBackgroundAlpha(f6);
            }
        }
        AnimatorSet animatorSet3 = workspaceStateTransitionAnimation.f15360c;
        if (!workspace4.mState.f15312j) {
            workspaceState2 = workspaceState;
            if (workspaceState2.f15312j) {
            }
            workspace4.mState = workspaceState2;
            workspace4.o1();
            if (z6) {
                workspace4.f23432V0.notifyWidgetProvidersChanged();
            }
            updateInteraction(state, workspaceState2);
            return animatorSet3;
        }
        workspaceState2 = workspaceState;
        workspace4.mState = workspaceState2;
        workspace4.o1();
        if (z6) {
            workspace4.f23432V0.notifyWidgetProvidersChanged();
        }
        updateInteraction(state, workspaceState2);
        return animatorSet3;
    }

    public void unlockAllApps() {
    }

    public void unlockScreenOrientation(boolean z5) {
        if (this.mRotationEnabled) {
            if (z5) {
                setRequestedOrientation(-1);
            } else {
                this.mHandler.postDelayed(new LauncherWorkspaceTask(this, 10), 500L);
            }
        }
    }

    public void updateAutoAdvanceState() {
        boolean z5 = this.mVisible && this.mUserPresent && !this.mWidgetsToAdvance.isEmpty();
        if (z5 != this.mAutoAdvanceRunning) {
            this.mAutoAdvanceRunning = z5;
            if (z5) {
                long j6 = this.mAutoAdvanceTimeLeft;
                sendAdvanceMessage(j6 != -1 ? j6 : 20000L);
            } else {
                if (!this.mWidgetsToAdvance.isEmpty()) {
                    this.mAutoAdvanceTimeLeft = Math.max(0L, 20000 - (System.currentTimeMillis() - this.mAutoAdvanceSentTime));
                }
                this.mHandler.removeMessages(1);
                this.mHandler.removeMessages(0);
            }
        }
    }

    public void updateIconBadges(List<String> list) {
        Objects.toString(list);
        MergedModelRunnable mergedModelRunnable = new MergedModelRunnable(5, this, list);
        if (waitUntilResume(mergedModelRunnable, true)) {
            return;
        }
        mergedModelRunnable.run();
    }

    public void updateIconTextColor(int i6) {
        ArrayList<CellLayout> workspaceAndHotseatCellLayouts;
        if (this.mIconTextColor != i6) {
            this.mIconTextColor = i6;
            C0056Y c0056y = this.mTinyDB;
            if (c0056y != null) {
                c0056y.m136f(i6, "icon_text_color");
            }
            Workspace workspace = this.mWorkspace;
            if (workspace != null && (workspaceAndHotseatCellLayouts = workspace.getWorkspaceAndHotseatCellLayouts()) != null) {
                int size = workspaceAndHotseatCellLayouts.size();
                int i7 = 0;
                while (i7 < size) {
                    CellLayout cellLayout = workspaceAndHotseatCellLayouts.get(i7);
                    i7++;
                    CellLayout cellLayout2 = cellLayout;
                    if (cellLayout2 != null) {
                        cellLayout2.getShortcutsAndWidgets().setIconTextColor(i6);
                    }
                }
            }
            if (Utilities.f16748i) {
                int systemUiVisibility = getWindow().getDecorView().getSystemUiVisibility();
                getWindow().getDecorView().setSystemUiVisibility(i6 == -1 ? systemUiVisibility & (-8193) : systemUiVisibility | 8192);
            }
        }
    }

    public void updateInteraction(WorkspaceState workspaceState, WorkspaceState workspaceState2) {
        Objects.toString(workspaceState);
        Objects.toString(workspaceState2);
        WorkspaceState workspaceState3 = WorkspaceState.f15305k;
        boolean z5 = workspaceState != workspaceState3;
        if (workspaceState2 != workspaceState3) {
            onInteractionBegin();
        } else if (z5) {
            onInteractionEnd();
        }
    }

    public void updateOverlayBounds(Rect rect) {
        Objects.toString(rect);
        this.mWidgetsView.setSearchBarBounds(rect);
    }

    public boolean useVerticalBarLayout() {
        this.mDeviceProfile.getClass();
        return false;
    }

    public void vibrate() {
        try {
            new Thread(new LauncherWorkspaceTask(this, 11)).start();
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public boolean waitUntilResume(Runnable runnable, boolean z5) {
        Objects.toString(runnable);
        if (!this.mPaused) {
            return false;
        }
        if (z5) {
            while (this.mBindOnResumeCallbacks.remove(runnable)) {
            }
        }
        this.mBindOnResumeCallbacks.add(runnable);
        return true;
    }

    /* JADX INFO: renamed from: x */
    public final void addAppWidgetToWorkspace(LauncherAppWidgetInfo launcherAppWidgetInfo, LauncherAppWidgetProviderInfo launcherAppWidgetProviderInfo, boolean z5) {
        int i6;
        launcherAppWidgetInfo.f16573F.setTag(launcherAppWidgetInfo);
        if (!launcherAppWidgetInfo.f16572E) {
            AppWidgetResizeFrame.updateWidgetSizeRanges(launcherAppWidgetInfo.spanX, launcherAppWidgetInfo.spanY, launcherAppWidgetInfo.f16573F, this);
            launcherAppWidgetInfo.f16572E = true;
        }
        launcherAppWidgetInfo.f16573F.setFocusable(true);
        launcherAppWidgetInfo.f16573F.setOnFocusChangeListener(this.mFocusHandler);
        Workspace workspace = this.mWorkspace;
        AppWidgetHostView appWidgetHostView = launcherAppWidgetInfo.f16573F;
        long j6 = launcherAppWidgetInfo.container;
        long j7 = launcherAppWidgetInfo.screenId;
        int i7 = launcherAppWidgetInfo.cellX;
        int i8 = launcherAppWidgetInfo.cellY;
        int i9 = launcherAppWidgetInfo.spanX;
        int i10 = launcherAppWidgetInfo.spanY;
        workspace.getClass();
        Objects.toString(appWidgetHostView);
        workspace.v0(appWidgetHostView, j6, j7, i7, i8, i9, i10, z5, false);
        if (launcherAppWidgetInfo.f16568A == -100) {
            return;
        }
        AppWidgetHostView appWidgetHostView2 = launcherAppWidgetInfo.f16573F;
        if (launcherAppWidgetProviderInfo == null || (i6 = ((AppWidgetProviderInfo) launcherAppWidgetProviderInfo).autoAdvanceViewId) == -1) {
            return;
        }
        KeyEvent.Callback callbackFindViewById = appWidgetHostView2.findViewById(i6);
        if (callbackFindViewById instanceof Advanceable) {
            this.mWidgetsToAdvance.put(appWidgetHostView2, launcherAppWidgetProviderInfo);
            ((Advanceable) callbackFindViewById).fyiWillBeAdvancedByHostKThx();
            updateAutoAdvanceState();
        }
    }

    /* JADX INFO: renamed from: y */
    public final long completeAdd(PendingAddArguments pendingAddArguments) {
        int[] iArr = null;
        CellLayout cellLayout = null;
        ComponentName componentName;
        boolean zM7646o = false;
        Objects.toString(pendingAddArguments);
        long jC0 = pendingAddArguments.f15969d;
        if (pendingAddArguments.f15968c == -100 && this.mWorkspace.T0(jC0) == null) {
            this.mWorkspace.u0();
            jC0 = this.mWorkspace.C0();
        }
        long j6 = jC0;
        int i6 = pendingAddArguments.f15966a;
        if (i6 == 1) {
            Intent intent = pendingAddArguments.f15967b;
            long j7 = pendingAddArguments.f15968c;
            int i7 = pendingAddArguments.f15970e;
            int i8 = pendingAddArguments.f15971f;
            Objects.toString(intent);
            iArr = this.mTmpAddItemCellCoordinates;
            this.mPendingAddInfo.getClass();
            cellLayout = getCellLayout(j7, j6);
            PendingInstallShortcutInfo pendingInstallShortcutInfoM7747a = InstallShortcutReceiver.m7747a(this, intent);
            ShortcutInfo shortcutInfoM8110b = pendingInstallShortcutInfoM7747a == null ? null : pendingInstallShortcutInfoM7747a.m8110b();
            if (shortcutInfoM8110b != null && (componentName = this.mPendingAddInfo.componentName) != null) {
                if (AbstractC0075r.m187h(this, shortcutInfoM8110b.f16553A, componentName.getPackageName())) {
                    View viewCreateShortcut = createShortcut(shortcutInfoM8110b);
                    boolean z5 = getWorkspace().getCurrentCellLayout().mShortcutsAndWidgets.getChildAt(i7, i8) == null;
                    if (i7 < 0 || i8 < 0 || !z5) {
                        zM7646o = cellLayout.m7646o(1, 1, iArr);
                    } else {
                        iArr[0] = i7;
                        iArr[1] = i8;
                        if (!this.mWorkspace.F0(viewCreateShortcut, j7, cellLayout, iArr, 0.0f, true, null, null)) {
                            DragObject dragObject = new DragObject();
                            dragObject.f16523g = shortcutInfoM8110b;
                            if (!this.mWorkspace.w0(viewCreateShortcut, cellLayout, iArr, 0.0f, dragObject, true)) {
                                zM7646o = true;
                            }
                        }
                    }
                    if (zM7646o) {
                        LauncherModel.addItemToDatabase(this, shortcutInfoM8110b, j7, j6, iArr[0], iArr[1]);
                        if (!this.mRestoring) {
                            cellLayout = cellLayout;
                            iArr = iArr;
                            Workspace workspace = this.mWorkspace;
                            int i9 = iArr[0];
                            int i10 = iArr[1];
                            boolean zIsWorkspaceLocked = isWorkspaceLocked();
                            workspace.getClass();
                            Objects.toString(viewCreateShortcut);
                            workspace.v0(viewCreateShortcut, j7, j6, i9, i10, 1, 1, zIsWorkspaceLocked, false);
                            j6 = j6;
                        }
                    } else {
                        cellLayout = cellLayout;
                        iArr = iArr;
                        showOutOfSpaceMessage(isHotseatLayout(cellLayout));
                    }
                } else {
                    shortcutInfoM8110b.f16553A.toUri(0);
                }
            }
        } else if (i6 == 5) {
            completeAddAppWidget(pendingAddArguments.f15972g, pendingAddArguments.f15968c, j6, null, null);
        } else if (i6 == 12) {
            int i11 = pendingAddArguments.f15972g;
            Workspace workspace2 = this.mWorkspace;
            workspace2.getClass();
            LauncherAppWidgetHostView launcherAppWidgetHostView = (LauncherAppWidgetHostView) workspace2.N0(new S9(i11, 8));
            if (launcherAppWidgetHostView != null && (launcherAppWidgetHostView instanceof PendingAppWidgetHostView)) {
                LauncherAppWidgetInfo launcherAppWidgetInfo = (LauncherAppWidgetInfo) launcherAppWidgetHostView.getTag();
                launcherAppWidgetInfo.f16570C = 0;
                this.mWorkspace.f1();
                LauncherModel.updateItemInDatabase(this, launcherAppWidgetInfo);
            }
        }
        cellLayout = cellLayout;
        iArr = iArr;
        cellLayout = cellLayout;
        iArr = iArr;
        m7838D();
        return j6;
    }

    /* JADX INFO: renamed from: z */
    public final void copyFolderIconToImage(FolderIcon folderIcon) {
        Objects.toString(folderIcon);
        int measuredWidth = folderIcon.getMeasuredWidth();
        int measuredHeight = folderIcon.getMeasuredHeight();
        if (this.mFolderIconImageView == null) {
            this.mFolderIconImageView = new ImageView(this);
        }
        Bitmap bitmap = this.mFolderIconBitmap;
        if (bitmap == null || bitmap.getWidth() != measuredWidth || this.mFolderIconBitmap.getHeight() != measuredHeight) {
            this.mFolderIconBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888);
            this.mFolderIconCanvas = new Canvas(this.mFolderIconBitmap);
        }
        DragLayerLayoutParams dragLayerLayoutParams = this.mFolderIconImageView.getLayoutParams() instanceof DragLayerLayoutParams ? (DragLayerLayoutParams) this.mFolderIconImageView.getLayoutParams() : new DragLayerLayoutParams(measuredWidth, measuredHeight);
        float descendantRectRelativeToSelf = this.mDragLayer.getDescendantRectRelativeToSelf(folderIcon, this.mRectForFolderAnimation);
        dragLayerLayoutParams.f16210d = true;
        Rect rect = this.mRectForFolderAnimation;
        dragLayerLayoutParams.f16208b = rect.left;
        dragLayerLayoutParams.f16209c = rect.top;
        ((FrameLayout.LayoutParams) dragLayerLayoutParams).width = (int) (measuredWidth * descendantRectRelativeToSelf);
        ((FrameLayout.LayoutParams) dragLayerLayoutParams).height = (int) (descendantRectRelativeToSelf * measuredHeight);
        this.mFolderIconCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
        folderIcon.draw(this.mFolderIconCanvas);
        this.mFolderIconImageView.setImageBitmap(this.mFolderIconBitmap);
        if (folderIcon.getFolder() != null) {
            this.mFolderIconImageView.setPivotX(folderIcon.getFolder().getPivotXForIconAnimation());
            this.mFolderIconImageView.setPivotY(folderIcon.getFolder().getPivotYForIconAnimation());
        }
        if (this.mDragLayer.indexOfChild(this.mFolderIconImageView) != -1) {
            this.mDragLayer.removeView(this.mFolderIconImageView);
        }
        this.mDragLayer.addView(this.mFolderIconImageView, dragLayerLayoutParams);
        if (folderIcon.getFolder() != null) {
            folderIcon.getFolder().bringToFront();
        }
    }

    public static void addDumpLog(String str, String str2, boolean z5) {
        addDumpLog(str, str2, null, z5);
    }

    public void closeFolder(boolean z5) {
        if (this.mBlurBackgroundView.getBackground() != null) {
            this.mBlurBackgroundView.animateBlurAlpha(0, false);
        }
        Workspace workspace = this.mWorkspace;
        Folder openFolder = workspace != null ? workspace.getOpenFolder() : null;
        if (openFolder != null) {
            if (openFolder.f15616S) {
                openFolder.dismissEditingName();
            }
            closeFolder(openFolder, z5);
        }
    }

    public boolean showWorkspace(boolean z5, Runnable runnable) {
        Objects.toString(runnable);
        return showWorkspace(-1, z5, runnable);
    }

    public View createShortcut(ViewGroup viewGroup, ShortcutInfo shortcutInfo) {
        Objects.toString(viewGroup);
        Objects.toString(shortcutInfo);
        BubbleTextView bubbleTextView = (BubbleTextView) this.mInflater.inflate(R.layout.app_icon, viewGroup, false);
        bubbleTextView.applyFromShortcutInfo(shortcutInfo, this.mIconCache, false);
        bubbleTextView.setOnClickListener(this);
        bubbleTextView.setOnFocusChangeListener(this.mFocusHandler);
        bubbleTextView.setLongPressTimeout(1369);
        bubbleTextView.setTextColor(this.mIconTextColor);
        return bubbleTextView;
    }

    public void showOverviewMode(boolean z5, boolean z6) {
        LauncherWorkspaceTask launcherWorkspaceTask = z6 ? new LauncherWorkspaceTask(this, 7) : null;
        this.mWorkspace.setVisibility(0);
        this.mStateTransitionAnimation.m7752b(this.mState, this.mWorkspace.getState(), WorkspaceState.f15309o, launcherWorkspaceTask);
        this.mState = LauncherState.f16045k;
    }

    public boolean showWorkspace(int i6, boolean z5) {
        return showWorkspace(i6, z5, null);
    }

    public FastBitmapDrawable createIconDrawable(Bitmap bitmap, int i6, boolean z5) {
        Objects.toString(bitmap);
        FastBitmapDrawable fastBitmapDrawable = new FastBitmapDrawable(this, bitmap, i6, z5);
        fastBitmapDrawable.setFilterBitmap(true);
        resizeIconDrawable(fastBitmapDrawable);
        return fastBitmapDrawable;
    }

    public boolean showWorkspace(int i6, boolean z5, Runnable runnable) {
        Objects.toString(runnable);
        LauncherState launcherState = this.mState;
        LauncherState launcherState2 = LauncherState.f16045k;
        WorkspaceState workspaceState = WorkspaceState.f15305k;
        boolean z6 = (launcherState == launcherState2 && this.mWorkspace.getState() == workspaceState) ? false : true;
        if (z6) {
            this.mWorkspace.setVisibility(0);
            this.mStateTransitionAnimation.m7752b(this.mState, this.mWorkspace.getState(), workspaceState, runnable);
        }
        this.mState = launcherState2;
        this.mUserPresent = true;
        updateAutoAdvanceState();
        if (z6) {
            getWindow().getDecorView().sendAccessibilityEvent(32);
        }
        return z6;
    }

    public ItemInfo createAppDragInfo(Intent intent, C2673q c2673q) {
        Objects.toString(intent);
        Objects.toString(c2673q);
        if (c2673q == null) {
            c2673q = C2673q.m9672b();
        }
        AbstractC2662f abstractC2662fMo9663g = AbstractC2666j.m9657c(this).mo9663g(intent, c2673q);
        if (abstractC2662fMo9663g == null) {
            return null;
        }
        return new AppInfo(this, abstractC2662fMo9663g, c2673q, this.mIconCache);
    }

    public void closeFolder(Folder folder, boolean z5) {
        char c6;
        Objects.toString(folder);
        folder.getInfo().f15523B = false;
        if (((ViewGroup) folder.getParent().getParent()) != null) {
            Workspace workspace = this.mWorkspace;
            FolderInfo folderInfo = folder.mInfo;
            workspace.getClass();
            Objects.toString(folderInfo);
            FolderIcon folderIcon = (FolderIcon) workspace.N0(new MergedItemCallbacks(5, folderInfo));
            Objects.toString(folderIcon);
            if (folderIcon == null) {
                c6 = 0;
            } else {
                PropertyValuesHolder propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat("alpha", 1.0f);
                PropertyValuesHolder propertyValuesHolderOfFloat2 = PropertyValuesHolder.ofFloat("scaleX", 1.0f);
                PropertyValuesHolder propertyValuesHolderOfFloat3 = PropertyValuesHolder.ofFloat("scaleY", 1.0f);
                CellLayout cellLayout = (CellLayout) folderIcon.getParent().getParent();
                c6 = 0;
                this.mDragLayer.removeView(this.mFolderIconImageView);
                copyFolderIconToImage(folderIcon);
                ObjectAnimator objectAnimatorOfPropertyValuesHolder = LauncherAnimUtils.ofPropertyValuesHolder(this.mFolderIconImageView, propertyValuesHolderOfFloat, propertyValuesHolderOfFloat2, propertyValuesHolderOfFloat3);
                objectAnimatorOfPropertyValuesHolder.setDuration(getResources().getInteger(R.integer.config_shrinkAndFadeInFolderIcon));
                objectAnimatorOfPropertyValuesHolder.addListener(new FolderCreationAnimListener(this, cellLayout, folderIcon));
                if (Utilities.f16752m) {
                    objectAnimatorOfPropertyValuesHolder.setInterpolator(new PathInterpolator(0.02f, 0.11f, 0.13f, 1.0f));
                }
                objectAnimatorOfPropertyValuesHolder.start();
                if (!z5) {
                    objectAnimatorOfPropertyValuesHolder.end();
                }
            }
            if (folderIcon != null) {
                ((CellLayoutLayoutParams) folderIcon.getLayoutParams()).f15694j = true;
            }
        } else {
            c6 = 0;
        }
        if (z5) {
            if (folder.getParent() instanceof DragLayer) {
                folder.m7694I();
                float[] fArr = new float[1];
                fArr[c6] = 0.0f;
                PropertyValuesHolder propertyValuesHolderOfFloat4 = PropertyValuesHolder.ofFloat("alpha", fArr);
                float[] fArr2 = new float[1];
                fArr2[c6] = 0.3f;
                PropertyValuesHolder propertyValuesHolderOfFloat5 = PropertyValuesHolder.ofFloat("scaleX", fArr2);
                float[] fArr3 = new float[1];
                fArr3[c6] = 0.3f;
                PropertyValuesHolder propertyValuesHolderOfFloat6 = PropertyValuesHolder.ofFloat("scaleY", fArr3);
                PropertyValuesHolder[] propertyValuesHolderArr = new PropertyValuesHolder[3];
                propertyValuesHolderArr[c6] = propertyValuesHolderOfFloat4;
                propertyValuesHolderArr[1] = propertyValuesHolderOfFloat5;
                propertyValuesHolderArr[2] = propertyValuesHolderOfFloat6;
                ObjectAnimator objectAnimatorOfPropertyValuesHolder2 = LauncherAnimUtils.ofPropertyValuesHolder(folder, propertyValuesHolderArr);
                if (Utilities.f16752m) {
                    objectAnimatorOfPropertyValuesHolder2.setInterpolator(new PathInterpolator(0.33f, 0.89f, 0.55f, 1.0f));
                }
                objectAnimatorOfPropertyValuesHolder2.addListener(new C0022a(10, folder));
                objectAnimatorOfPropertyValuesHolder2.setDuration(folder.getResources().getInteger(R.integer.config_folderCollapseDuration));
                folder.setLayerType(2, null);
                objectAnimatorOfPropertyValuesHolder2.start();
            }
        } else {
            folder.m7695J(false);
        }
        getDragLayer().sendAccessibilityEvent(32);
    }
}
