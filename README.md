# 🌊 Pacific Atlantic Water Flow Simulator
A Java-based graphical simulation of the classical Pacific Atlantic Water Flow problem, extended with additional terrain types such as Rivers and Deserts, and visualized using Java Swing.

This project combines algorithms, simulation, and object‑oriented programming in a clean and educational way.
---
📸 Preview
Add a screenshot of your running program here:
🧠 Problem Overview
The Pacific Atlantic Water Flow problem determines which cells in a grid allow water to reach:
![Simulation](
src/images/screenshot(1).png 
src/images/screenshot(2).png
)
---

The Pacific Ocean

The Atlantic Ocean

Water can flow from a cell to another only if the next cell has equal or lower elevation.
---
🌍 Terrain Types
This project extends the classical problem with environmental terrain simulation:

Terrain Type	Behavior
Normal Cell	Water flows only to lower elevation
River	Water can flow even if elevation is equal
Desert	Water cannot flow (evaporates)
⚙️ Features
✔️ Water flow simulation on a 2D grid

✔️ Special terrain types (River / Desert)

✔️ Graphical visualization using Java Swing

✔️ Object‑oriented design

✔️ Extended version of a classic algorithmic problem
---
🏗 Project ArchitecturePacificAtlantic
│
├── src
│   └── main
│       └── java
│            └── pacificatlantic
│                 ├── PacificAtlantic.java   # Main application
│                 ├── WaterFlow.java         # Flow algorithm
│                 ├── CellType.java          # Terrain types
│
├── images
│   └── simulation.png
│
├── pom.xml
└── README.md

---
🔄 Algorithm Idea
The simulation checks neighboring cells and determines water flow based on:

Cell height

Terrain type

Flow constraints

Pseudo‑logic:
if neighbor is Desert
    stop flow
else if neighbor height < current height
    allow flow
else if neighbor is River AND height equal
    allow flow

---
🛠 Technologies Used
Java

Java Swing

Maven

Grid‑based Algorithms
---
▶️ How to Run
1️⃣ Clone the repository
git clone https://github.com/your-username/PacificAtlantic.git

2️⃣ Open the project
Using IntelliJ, NetBeans, or Eclipse.

3️⃣ Build
mvn clean install

4️⃣ Run
Run the main class:
PacificAtlantic.java
---

🎓 Learning Objectives
Grid traversal algorithms (DFS/BFS)

Algorithm simulation

Java GUI development

Object‑oriented architecture

👩‍💻 Author
Shahd  
Computer Engineering Student

📄 License
This project is licensed under the MIT License.


