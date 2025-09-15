# 🧱 PlayerWorlds Plugin

**Version:** 1.0-SNAPSHOT  
**Author:** gamecat999 
**Platform:** Spigot 1.20.1  


---

## 🌍 Overview

PlayerWorlds is a Minecraft server plugin that gives each player their own private world—secured with a password, dynamically loaded when accessed, and unloaded when empty. It’s built for performance, personalization, and mythic immersion.

---

## ⚙️ Features

- 🔐 **Private Worlds** — Each player can create one personal world with a password.
- 🚪 **Dynamic Loading** — Worlds load on demand and unload when empty.
- 🧠 **Persistent Registry** — World data is saved in `worlds.yml` and survives restarts.
- 🏠 **Lobby Return** — Players can teleport back to the main world anytime.
- 🔄 **Auto-Unload Scheduler** — Keeps memory lean by unloading idle worlds.

---

## 🧪 Commands

| Command | Description |
|--------|-------------|
| `/createworld <name> <password>` | Creates a new personal world |
| `/joinworld <name> <password>` | Joins an existing world |
| `/lobby` | Returns to the main lobby world |

---

## 📦 Setup

1. Clone this repo:
   ```bash
   git clone https://github.com/yourusername/PlayerWorlds.git
   cd PlayerWorlds
