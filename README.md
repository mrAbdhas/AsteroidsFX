JPMS Study project

# AsteroidsFX


## Getting Started

### Prerequisites
- Java Development Kit (JDK)
- Apache Maven

### Installation

1. Clone the repository:

   cd AsteroidsFX


2. Build the project using Maven
     ```bash
        mvn clean install
    ```

3. Run the project:
     ```bash
        java --module-path "mods-mvn;mods-libs" --module=Core/dk.sdu.cbse.core.App 
    ```

## Usage
* Use the arrow keys to navigate your spaceship.


* Press the spacebar to shoot asteroids.
  Avoid collisions void collisions to stay alive — enemy bullets can destroy you!

## Acknowledgments
Inspired by the classic Asteroids game
