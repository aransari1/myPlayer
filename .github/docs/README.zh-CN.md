<div align="center">

# My Player

**A Modern Android Local Video Player**

[![Android 29+](https://img.shields.io/badge/Android-29+-34A853?logo=android&logoColor=white)](https://developer.android.com)
[![Kotlin](https://img.shields.io/badge/Kotlin-7F52FF?logo=kotlin&logoColor=white)](https://kotlinlang.org)
[![Jetpack Compose](https://img.shields.io/badge/Compose-4285F4?logo=jetpackcompose&logoColor=white)](https://developer.android.com/compose)
[![Media3](https://img.shields.io/badge/Media3-FF6F00?logo=android&logoColor=white)](https://developer.android.com/media/media3)

</div>

> Built with **Kotlin**, **Jetpack Compose**, **Hilt**, and **Media3 / ExoPlayer**.  
> **My Player** is a fork derived from the original [Next Player](https://github.com/anilbeesetti/nextplayer) project. It enhances the original experience with features such as in-app language switching, full settings backup and restore, and advanced ASS stylized subtitle rendering.
>
> *Special thanks to the [Next Player](https://github.com/anilbeesetti/nextplayer) project and all upstream contributors for providing the solid foundation and long-term maintenance.*

---

## ✨ Key Features

| | Feature | Description |
|:---:|---|---|
| 🎬 | **Smart Media Library** | Folder, tree, and flat list views with search, layout toggles, and sorting options. |
| ▶️ | **Full Playback Control** | Resume playback, autoplay next video, PiP mode, intuitive gestures, and per-file track memory. |
| 🔤 | **Rich Subtitle Support** | ASS styled subtitle rendering, external subtitle loading, encoding adjustment, and style customization. |
| 🎨 | **Material You** | Dynamic color theme, in-app language switcher, and comprehensive UI customization. |
| 💾 | **Backup & Restore** | Export and import all application and player settings for seamless cross-device migration. |
| 🚀 | **CI/CD Ready** | Automated signature verification and build artifact releases via GitHub Actions. |

---

<details>
<summary>📖 <strong>Feature Overview</strong></summary>

### Media Library

- Support for Folder, Tree, and All-Videos view modes.
- Fast media content search.
- Switch between list and grid layouts.
- Sort videos by title, duration, size, date, and more.
- Exclude specific folders from media scans.
- Option to ignore `.nomedia` files and force-scan specified directories.
- Debug menu entries in debug builds to easily test media refresh and `.nomedia` behaviors.

### Playback

- Open videos from the local media library or via external `Intent`.
- Resume playback from where you left off.
- Auto-play the next video in the same directory.
- Picture-in-Picture (PiP) mode.
- Configurable background playback options.
- Playback speed controls, long-press speed boost, zooming, and aspect ratio adjustments.
- Touch gestures for seeking, brightness, volume, zooming, and double-tap actions.
- Remember audio and subtitle track selections on a per-file basis.

### Subtitles & Audio

- Switch between embedded audio and subtitle tracks.
- Load external subtitle files using the system document picker.
- Advanced ASS subtitle rendering (supports styled effects beyond simple plain text).
- Configure preferred audio and subtitle languages.
- Comprehensive subtitle adjustments: font, weight, size, background, delay, speed, and text encoding.
- Audio decoder priority and playback strategy configurations.

### Personalization & Settings

- In-app language switching.
- Material 3 styling with Dynamic Color support.
- Customizable gestures, player controls, orientation, decoders, and thumbnail settings.
- Export application and player settings to a file.
- Restore settings from a backup file.
- Reset settings to default state.

### Build & Release

- Automated CI workflows for generating debug build artifacts on branches.
- Production release workflows with automatic signature verification prior to building.

</details>

<details>
<summary>📱 <strong>User Guide</strong></summary>

### 1. First Launch

- Install the Debug or Release APK.
- Grant media access permissions upon first launch.
- If you enable the option to ignore `.nomedia` files, All Files Access permission will be required.

### 2. Navigating the Library

- Switch between Folder, Tree, and Video List views from the main screen.
- Use the search bar to locate files quickly.
- Customize sorting, layout, and view modes via quick settings on the media page.
- Exclude unwanted directories in settings.

### 3. Playing Videos

- Tap any video to launch the player.
- Horizontal swipe to seek forward or backward.
- Vertical swipe on the left/right sides to adjust brightness and volume.
- Double-tap to trigger configured actions.
- Pinch-to-zoom when zoom gestures are enabled.
- Utilize PiP or background playback if enabled in settings.

### 4. Working with Subtitles

- Select embedded subtitle tracks directly from the player interface.
- Load external subtitle files via the file picker.
- ASS subtitles render styled visual effects automatically.
- Adjust subtitle appearance and timing behavior in **Settings > Subtitles**.

### 5. Backup & Restore

- Go to **Settings > General**.
- Export your current settings to a backup file.
- Import the file anytime on the current device or a new device to migrate preferences.
- Use the reset option to restore all settings to default.

### 6. Troubleshooting

- **Missing Videos:** Check excluded folders and `.nomedia` settings.
- **Playback Issues:** Verify that all required storage permissions are granted.
- **Subtitle Errors:** Verify file encoding and double-check track selection for ASS rendering.
- **CI Build Failures:** Check the signature validation step in the workflow output.

</details>

---

## 🏗️ Project Structure

```text
app/                  App entry point, Manifest, build variants
core/common/          Logging, dispatchers, and common utilities
core/data/            Repository implementations and data mapping
core/database/        Room database, DAOs, schemas
core/datastore/       DataStore data sources and serialization
core/domain/          Use case layer
core/media/           Media scanning and playback service
core/model/           Shared models
core/ui/              Common Compose UI, strings, theme
feature/player/       Player UI and playback logic
feature/settings/     Settings screens and preference management
feature/videopicker/  Media browser, search, and quick settings
.github/workflows/    CI, release, and build workflows