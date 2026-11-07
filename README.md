# 👾 Reel Monster (Level 1)

A lightweight, distraction-free Android floating utility designed to tackle mindless social media consumption. It renders an interactive floating monster overlay on top of short-form video apps (Instagram Reels, YouTube Shorts), letting users manually log every reel watched with real-time dynamic growth feedback.

---

## ✨ Features

- **Floating Overlay (`SYSTEM_ALERT_WINDOW`):** Stays pinned over third-party apps like Instagram and YouTube.
- **Draggable & Responsive:** Free-form drag-and-drop movement anywhere across the mobile screen.
- **Manual Reel Counter:** Tap to increment the watched counter with dynamic humorous feedback.
- **Monster Scaling:** The avatar grows larger as the reel count increases, visually signaling excessive screen time.
- **Persistent Storage:** Keeps count records intact across app closures and full device reboots via `SharedPreferences`.
- **100% Offline & Private:** Zero account requirements, no internet connectivity needed, and zero background data leaks.

---

## 🛠 Tech Stack

- **Platform:** Native Android (Java)
- **Minimum SDK:** API 24 (Android 7.0 Nougat)
- **Target SDK:** API 34+
- **JDK:** Eclipse Temurin JDK 17
- **UI:** XML Layouts (`WindowManager` dynamic inflation)

---

## 🚀 Getting Started

### 1. Prerequisites
- Android Studio (Ladybug or later)
- JDK 17 configured in Project Structure
- Android device running Android 7.0+ with USB Debugging enabled

### 2. Installation
1. Clone this repository:
   ```bash
   git clone [https://github.com/IshaniKarmakar30/ReelMonster.git](https://github.com/IshaniKarmakar30/ReelMonster.git)
