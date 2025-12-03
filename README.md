# 🎵 🎶 MOODify  🎶 🎵 
CS 211 - Final Project
Object-Oriented Programming: A Mood-Based Audio Recommendation System

Student Name, Section, Institution
- Abanilla, Shane M., IT 2111, Batangas State University
- Camacho, Janine A., IT 2111, Batangas State University
- Jarque, Sykes Andrei I., IT 2111, Batangas State University

# OVERVIEW 📌

MOODify is a Java console application that provides mood-based music and podcast recommendations. Built on Object-Oriented Programming (OOP) principles, its core purpose is to demonstrate practical applications of inheritance, polymorphism, and abstraction in a real-world simulation.

- [Abstraction](#abstraction)
- [Encapsulation](#encapsulation)
- [Inheritance](#inheritance)
- [Polymorphism](#polymorphism)

# IMPLEMENTATION 🎯
1. Abstraction:  
The core concept is the abstract superclass AudioContent.
It defines a common interface for all audio items (music and podcasts), specifying essential properties like title and duration and the abstract method play().
Users of the AudioContent object (like LibraryManager or AppController) interact with it through its general methods without needing to know the specific implementation details of a Music or Podcast object.
2. Inheritance:  
The classes Music and Podcast inherit from the abstract class AudioContent.
They inherit common fields (id, title, duration) and the play() method signature.
This promotes code reusability as the common logic is centralized in the superclass.
3. Polymorphism:   
Method Overriding: Both Music and Podcast provide their own unique implementation of the inherited abstract method play().
Music.play(): Prints the song title and artist.
Podcast.play(): Prints the podcast title and link.
Dynamic Behavior: In the AppController.showLibrary() method, we iterate over a List<AudioContent>, but call the specific play() method defined in the actual object type (Music or Podcast).
4. Encapsulation:   
All class variables are declared as private.

# MAIN FEATURES ✏️
[1] Mood Music        🎶  → Recommends music based on feeling  
[2] Podcasts          🎙️ → Displays podcast links (YouTube)  
[3] Manage Library    🛠️ → CRUD Operations  
[4] Show All          📚 → Shows all audio items  
[5] Exit              🚪  

# PROGRAM STRUCTURE ✏️


               ┌──────────────────┐
               │  AudioContent    │ (abstract)
               │  id, title, dur  │
               │  + play()        │◄─────────┐
               └─────────┬────────┘          │
                         │                    │
          ┌──────────────┘                    └───────────────┐
          │                                                   │
    ┌──────────────┐                                  ┌────────────────┐
    │    Music     │                                  │    Podcast     │
    │ mood, artist │                                  │    link        │
    └──────────────┘                                  └────────────────┘
                   ▲
           │
    ┌──────────────────────┐
    │    LibraryManager    │
    │ CRUD + Recommendation│
    └ ───────────┬─────────┘
            │
     ┌──────┴─────────┐
     │ AppController  │
     │  User Menus    │
     └────────────────┘

# HOW TO RUN THE PROGRAM 🔍
Follow these steps to compile and run the MOODify application using the command line:   

  1. Save Files: Ensure all class files (MOODify.java, AudioContent.java, Music.java, Podcast.java, LibraryManager.java, AppController.java, AudioUtil.java) are saved in the same directory (e.g., in a folder named src).   
  2. Navigate: Open your command line (Terminal or Command Prompt) and navigate to the directory where your source files are located.   
  3. Compile: Compile the Java source files. The *.java wildcard compiles all files.
javac *.java   
  4. Run: Execute the compiled program by calling the main class, MOODify
java MOODify   

# SAMPLE OUTPUT 🔎
Sample Output
The following shows a sample user session:

=== MOODify ===  
[1] Mood Music  
[2] Podcasts  
[3] Manage Library (CRUD)  
[4] Show All  
[5] Exit  
Choose: 1  

Mood (happy/sad/angry/broken): happy

Mood Music Recommendation:
Mananatili by Cup of Joe

=== MOODify ===  
[1] Mood Music  
[2] Podcasts  
[3] Manage Library (CRUD)  
[4] Show All  
[5] Exit  
Choose: 2  

Podcasts:  
[1] Podcast 1  
[2] Podcast 2  
[3] Podcast 3  
...  
[10] Podcast 10  
Choose: 1  

Podcast Recommendation:
Title: Podcast 1  
Watch here: https://youtu.be/N90UIXMuMMU?si=rHBI95ogiJLh5wBL

=== MOODify ===  
[1] Mood Music  
[2] Podcasts  
[3] Manage Library (CRUD)  
[4] Show All  
[5] Exit  
Choose: 3  

[1] View by ID  
[2] Update Title  
[3] Delete  
Choose: 2  
ID: M1  
New Title: Bawat Piyesa (New Mix)  
Updated.  

![image alt](https://github.com/armansalon/firstrepo/blob/6e9d68a4c6f65ff44489d31fd3e2a78648b93588/Screenshot%202025-12-04%20010449.png)  

# AUTHOR AND ACKNOWLEDGEMENT 🧾  

Contributors
This project was developed by:   

ABANILLA, SHANE M.  
CAMACHO, JANINE A.  
JARQUE, SYKES ANDREI I.  

Acknowledgement:   

This project extends sincere thanks to Ms. Christiana Grace Alib, our CS 211 Instructor, for her comprehensive guidance and expertise in Object-Oriented Programming, which provided the foundational knowledge and architectural principles necessary for the development of MOODify. We also extend sincere thanks to Christiana Grace Alib for her specific guidance on OOP principles and design patterns, to open-source language learning communities for inspiring the use of CSV data structures, to the ANSI color formatting standards that helped enhance the overall user experience, and to the Gang of Four Design Patterns for providing valuable architectural guidance.  
  
# FUTURE ENHANCEMENTS  🧠
- Implement the actual audio playback using the AudioUtil class.
Integrate Custom Exceptions for specific, clearly defined error cases.  
- Implement a file-based storage system (e.g., CSV or JSON) to persist library data between sessions.  
- Add a feature to add new music/podcasts via the library management menu.  

 

















               
              
