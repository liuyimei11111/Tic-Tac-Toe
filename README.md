# Tic-Tac-Toe

## Description
This is a Tic-Tac-Toe game. There are two players whose pieces are 'x' and 'o' respectively, place their piece
alternatively in a 3 * 3 board. When 3 same pieces at the same row, or at the same column, or at main diagonal,
or at sub diagonal, the corresponding player wins the game. Otherwise, when the board is full and no winner can
be determined, then the game is a draw.

However, different from traditional game development, this project bases on the whole software lifecycle including
designing, developing, testing, and iterating upon a digital rendition of the timeless game. Thus, we can stand in
a higher perspective, deeply participate in the whole process of software development, and do a good CI/CD.

## Group Members and Responsibilities

Name1(GitHub: liuyimei11111, Leader of the Project, mainly for making overall management of the project, designing the
prototype of the project, and developing functions of board).

Name2(GitHub: gcsunn, Unit tester of the project, mainly for developing functions of board, and writing unit test cases
to test the whole project).

Name3(GitHub: Liu010517, Version control administrator of the project, mainly for developing functions of driver of the
project, and handling works related to CI/CD).

## User Stories

In the project, there are four main user stories and we allocate unique ID for them:

US1: As a player, I want to be able to make a move by choosing an empty square, so that I can place my symbol on the
board.

US2: As a player, I want to be able to see the current state of the game, so that I can keep track of the moves made by
both myself and my opponent.

US3: As a player, I want to be notified when the game has ended in a win, loss or draw, so that I can see the result of
the game.

US4: As a player, I want to be able to start a new game after the current game has ended, so that I can play again.


## Tasks

In the project, there are fifteen main tasks and we allocate unique ID for them:

T1: Create a GitHub repository (public).

T2: Create a GitHub project and link it to the created repository.

T3: Transfer the user stories to a new Kanban board in the project.

T4: Give every user story a unique id. 

T5: Create a new Java Maven project. 

T6: Initialize a new git repository.

T7: Set the GitHub repository as a remote repository.

T8: Commit and push your blank Java project to the main branch.

T9: Protect the main branch (only allow pull requests).

T10: Start working on the user stories.

T11: Create a new feature branch for every user story and name it correctly.

T12: Merge the branch after completion via pull request.

T13: Make sure the CI/CD tests your code before merging.

T14: Always advance the user stories on the Kanban board.

T15: The main branch should "deploy" the application via CI/CD (make the jar downloadable).


## Project Architecture

Based on the requirements of the project, we design the overall architecture with the tree structure as follows:

main/java/com.ttt: A package that includes core code based on the class diagram of the project, guarantees that the
project is runnable, and all requirements are implemented.
test/java/com.ttt: A package that includes unit test code for classes in the main/java/com.ttt package, guarantees
that every method has at least two unit tests, positives and negative test cases are used, and all functions
including edge situations can be covered.
pom.xml: Includes necessary configuration, such as junit.
readme.md: Project documentation and tutorials.
target/Tic-Tac-Toe-1.0-SNAPSHOT.jar: The executable .jar file automatically created in the deployment session, for 
CI/CD. 

    ``` Tic-Tac-Toe
    |---- src
    |        |---- main/java/com.ttt
    |        |        |---- Board.java
    |        |        |---- Player.java
    |        |        |---- TicTacToe.java
    |        |---- test/java/com.ttt
    |        |        |---- BoardTest.java
    |        |        |---- PlayerTest.java
    |        |        |---- TicTacToeTest.java
    |---- target
    |----    |---- Tic-Tac-Toe-1.0-SNAPSHOT.jar
    |---- pom.xml
    |---- readme.md
    ```

## Execution

There are two options for executing the project:

Option 1: Open the project and find the file src/main/java/com.ttt/TicTacToe.java, then you can click the arrow in
public static void main(String[] args) method to execute it.

Option 2: A .jar file is provided in target, then you can execute the command as follows to execute it.

    ```
    java -jar Tic-Tac-Toe-1.0-SNAPSHOT.jar
    ```


## Attention

If you have any question, you can contact us. Enjoy yourself! 
