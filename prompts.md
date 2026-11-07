\# Reel Monster - Development Prompts \& Workflow Log



Project: Week 2 - Project 6: Reel Monster (Section B: Phone apps and games)

Platform: Android Native (Java, XML)

Level: Level 1 (Manual Reel Counter \& Floating Overlay)



\---



\## 1. Project Planning \& Architecture

\- \*\*Objective:\*\* Build a standalone, offline Android application that floats a monster bubble over social media apps (Instagram, YouTube) to track reels watched manually.

\- \*\*Key Requirements:\*\*

&#x20; - Floating overlay using Android WindowManager (`SYSTEM\_ALERT\_WINDOW`).

&#x20; - Movable touch interaction (drag \& drop across the screen).

&#x20; - Tap counter increment with humorous messages and monster growth animation.

&#x20; - Persistent storage using `SharedPreferences` to survive phone reboots.

&#x20; - 100% offline functionality without API keys, accounts, or background data leaks.



\---



\## 2. Agent Prompts \& Step-by-Step Execution



\### Step 1: Project Setup \& SDK Environment

\*\*User Intent:\*\* Set up an Android project with the correct architecture, SDK version, and directory structure.

\*\*Prompt:\*\*

> "I want to create Project 6: Reel Monster from the Week 2 projects list. Help me set up an Android project targeting Minimum SDK API 24 using Empty Views Activity (Java). Provide the full folder structure and explain whether nested package folders are individual directories."

\*\*Outcome:\*\*

\- Configured project directory under `C:\\Projects\\ReelMonster` to prevent whitespaces issues.

\- Selected Empty Views Activity with Java.

\- Configured JDK 17 (Eclipse Temurin) to ensure full compatibility with modern Android Gradle Plugin.



\---



\### Step 2: Overlay Permissions \& Manifest Setup

\*\*User Intent:\*\* Enable overlay rendering over other applications and background service lifecycle.

\*\*Prompt:\*\*

> "What permissions and service declarations are required in AndroidManifest.xml so that an Android app can display a floating widget over apps like Instagram and YouTube Shorts?"

\*\*Outcome:\*\*

\- Added `<uses-permission android:name="android.permission.SYSTEM\_ALERT\_WINDOW" />`.

\- Registered `FloatingMonsterService` inside the `<application>` node.



\---



\### Step 3: Floating UI \& Monster Layout Design

\*\*User Intent:\*\* Create the visual floating widget with an avatar, badge counter, and dynamic speech bubble.

\*\*Prompt:\*\*

> "Create an XML layout file `layout\_floating\_monster.xml` containing a circular monster avatar, a visible reel counter badge, and an expandable text bubble that displays witty remarks when clicked."

\*\*Outcome:\*\*

\- Created `layout\_floating\_monster.xml` with `LinearLayout`, emoji monster avatar, yellow counter badge, and speech popup.



\---



\### Step 4: Floating Service \& Touch Event Implementation

\*\*User Intent:\*\* Implement draggable floating logic, tap detection, counter persistence, and growth scaling.

\*\*Prompt:\*\*

> "Write the Java code for `FloatingMonsterService.java` extending `Service`. Use `WindowManager` to inflate `layout\_floating\_monster.xml`, handle touch gestures (differentiating between drag moves and static taps), increment the reel count, persist it in `SharedPreferences`, increase avatar scale, and cycle through witty remarks."

\*\*Outcome:\*\*

\- Created `FloatingMonsterService.java`.

\- Managed `WindowManager.LayoutParams.TYPE\_APPLICATION\_OVERLAY` for Android 8.0+.

\- Stored `today\_count` persistently via `SharedPreferences`.



\---



\### Step 5: Main Activity \& Permission Handling

\*\*User Intent:\*\* Build the launcher dashboard to check overlay permission and trigger the monster.

\*\*Prompt:\*\*

> "Write `MainActivity.java` and `activity\_main.xml` to display today's total reels watched, estimated minutes lost, and a button to check `Settings.canDrawOverlays` and start `FloatingMonsterService`."

\*\*Outcome:\*\*

\- Implemented `MainActivity.java` with intent redirection to `Settings.ACTION\_MANAGE\_OVERLAY\_PERMISSION`.

\- Displayed session stats and launch trigger.



\---



\## 3. Done When Verification Checklist

\- \[x] \*\*Install on real phone:\*\* App installed via USB Debugging on a real Android device.

\- \[x] \*\*Floating behavior:\*\* The monster stays pinned and draggable over both Instagram Reels and YouTube Shorts.

\- \[x] \*\*Data persistence:\*\* Reel count survives complete phone reboot (verified via SharedPreferences).

\- \[x] \*\*Zero network dependency:\*\* App operates entirely in Airplane/Flight mode without internet or accounts.

\- \[x] \*\*Interactive feedback:\*\* Monster displays dialogue and scales dynamically on user tap.

