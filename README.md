# Project_RiskMap

## Overview
Project_RiskMap is a game developed as part of the SOFTENG 281 assignment for Semester 1, 2024. This project involves implementing a strategic board game where players can simulate territorial expansion and conflict. The game is inspired by the classic board game "Risk" and aims to provide a digital platform for users to engage in strategic gameplay.

## Table of Contents
- [Features](#features)
- [Installation](#installation)
- [Gameplay](#gameplay)
- [Contributing](#contributing)
- [License](#license)

## Features
- **Graph Data Structure**: Model the map as a graph with countries as nodes and edges representing neighboring relations.
- **Shortest Path Calculation**: Implement an algorithm to find and print the shortest path between two countries.
- **Tax Calculation**: Calculate the total taxes paid for crossing borders based on predefined values.
- **Interactive Command-Line Interface**: User-friendly interface to interact with the game.
- **Map Loading**: Load the game map into the graph structure from a file or predefined data.

## Installation
To run Project_RiskMap locally, follow these steps:

1. **Clone the repository**:
   ```sh
   git clone https://github.com/ZingZing001/Project_RiskMap.git
   ```
2. **Navigate to the project directory**:
  ```
  cd Project_RiskMap
  ```
3. Run the program:
  For Mac:
  ```
  ./mvnw clean javafx:run
  ```
  For Windows:
  ```
  .\mvnw.cmd clean javafx:run
  ```

## Gameplay
### Objective
The main objective of this assignment is to implement a Java application that simulates a simplified version of the Risk board game. A Graph data structure is used to model the map, where countries are nodes and edges represent the neighborhood relations. Players must implement code to load the map into a graph, print the shortest path between two countries, and calculate the total taxes paid for crossing borders. This assignment simulates a real-world scenario where a company needs to find optimal routing for international deliveries.

## How to Play
1. Start the Game: Run the game by executing the Maven command.
For Mac:
```
./mvnw clean javafx:run
```

For Windows:
```
.\mvnw.cmd clean javafx:run
```

2. Select a Territory: Choose a starting territory to begin your expansion.
3. Select a Destination: Choose a finishing territory and the program will calculate the shortest path (with the lowest risk) to that country.
   
## Contributing
Contributions are welcome! If you have suggestions for improvements or new features, feel free to fork the repository and create a pull request.

## Fork the Project
1. Create a Feature Branch (git checkout -b feature/AmazingFeature)
2. Commit your Changes (git commit -m 'Add some AmazingFeature')
3. Push to the Branch (git push origin feature/AmazingFeature)
4. Open a Pull Request
## License
Distributed under the MIT License. See LICENSE for more information.
