# Doubly Linked List
This project contains Java classes implementing a doubly linked list. The project provides a flexible and efficient implementation of a doubly linked list data structure in Java, supporting insertion, deletion, printing, and various operations on the list.

## Design Overview
The project offers a comprehensive solution for managing doubly linked lists in Java. The `DoublyLinkedList` class represents the doubly linked list data structure, providing essential functionalities such as insertion, deletion, printing, and various operations on the list. It supports dynamic sorting based on the item type. The `NodeType` class defines the structure of a node in the doubly linked list, extending the `Comparable` interface for comparison between node values. The `DoublyLinkedListDriver` class constructs a driver program for interacting with the doubly linked list. It reads commands from a file or user input and executes corresponding operations on the list, ensuring seamless user experience and efficient utilization of the data structure.

## Functionality
`DoublyLinkedListDriver`:
- Constructs a driver program for interacting with the `DoublyLinkedList`.
- Reads commands from a file and processes user input to perform operations on the list.
- Supports commands for inserting values, deleting values, printing the list, obtaining the length, printing the reverse list, reversing the list, deleting subsections, swapping alternate nodes, and quitting the program.

`DoublyLinkedList`:
- Represents a doubly linked list that supports insertion, deletion, printing, and other operations.
- Allows creation of lists containing integer, double, or string types, with dynamic sorting based on the item type.
- Provides methods for reversing the list, deleting subsections, and swapping alternate nodes.

`NodeType`:
- Defines the structure of a node in the doubly linked list.
- Extends the `Comparable` interface to allow comparison between node values.

## File Structure and Content
```
doubly-linked-list/
├── compile.sh
├── README.md
└── src/
    ├── DoublyLinkedListDriver.java
    ├── DoublyLinkedList.java
    └── NodeType.java
```