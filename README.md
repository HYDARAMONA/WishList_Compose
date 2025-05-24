# 🎯 WishList - A Jetpack Compose App

A modern Android app for managing wishes with **local persistence** using Room Database, *
*dependency injection** with Hilt, and a sleek **Material 3** UI.

---

## ✨ Features

- ✅ **Add/Edit/Delete** wishes
- 🖐️ **Swipe-to-delete** gestures
- 🎨 **Dark/Light** theme support
- 🏗️ **MVVM Architecture** with clean separation of layers

---

<h2>📽️ Demo</h2>
<table>
  <tr>
    <td align="center">
      <img src="assets/demo.gif" alt="Demo 1" width="300" style="border-radius: 8px;" /><br/>
      <strong>📝 Add Wish</strong>
    </td>
    <td align="center">
      <img src="assets/demo2.gif" alt="Demo 2" width="300" style="border-radius: 8px;" /><br/>
      <strong>🗑️ Delete Wish</strong>
    </td>
  </tr>
</table>

---

## 🛠️ Tech Stack

| Component        | Technology         | Key Dependency                                     |
|------------------|--------------------|----------------------------------------------------|
| **UI Framework** | Jetpack Compose    | `androidx.compose:compose-bom`                     |
| **Database**     | Room               | `androidx.room:room-ktx`                           |
| **DI**           | Hilt               | `com.google.dagger:hilt-android`                   |
| **Navigation**   | Compose Navigation | `androidx.navigation:navigation-compose`           |
| **Async**        | Kotlin Coroutines  | `org.jetbrains.kotlinx:kotlinx-coroutines-android` |

---

```mermaid
graph TD
    UI[Compose UI] -->|Events| VM[ViewModel]
    VM -->|State| UI
    VM -->|Data| Repo[Repository]
    Repo -->|CRUD| DB[Room Database]
```

## 📦 Project Structure

```plaintext
WishList/
├── app/
│   ├── src/main/
│   │   ├── data/
│   │   │   ├── local/      # Room Database & DAO
│   │   │   └── repository  # WishRepository
│   │   ├── presentation/
│   │   │   ├── ui/         # Compose Screens
│   │   │   └── viewModel   # WishViewModel
│   │   └── theme/          # Material 3 Theming
├── build.gradle
└── README.md               # You are here!
```