# Task 3 - Use Cases Answered
### Question 1. When working with a large collection where frequent insertion and deletion operations are expected, and random access is not a primary concern, what is the best choice ?
**Answer:** LinkedList class is the best option, because its insertion and deletion operations are fast, and a large dataset means we need a data structure that can also easily grow, without the need for resizing.

### Question 2. Suppose you are building an inventory management system for an online store. You need to keep track of the available stock of products. Each product has a unique identifier (product ID) and a corresponding quantity in stock. Which Collection can we use to solve this?
**Answer:** A HashSet class is best suited, because it provides a Hashtable for key-value mapping ideal to map the productID with the corresponding quantity in stock. Also, it eliminates any redundant products from the database thanks to the Set data structure.

### Question 3. Suppose you are developing a user activity tracking system where you need to maintain the order of user actions. You want to store the actions in a collection while ensuring uniqueness?
**Answer:** A LinkedHashSet is the best option, since the LinkedList provides the memory of the order of insertion and the Set structure provides uniqueness.

### Question 4. In a social media application, there are millions of user posts generated every day. How can Java Collections help you handle and display the latest posts efficiently? Which collection would you use to maintain a sorted order of posts based on their timestamps?
**Answer:** A TreeSet is the best option, because it provides a custom sorting mechanism while avoiding data duplicates.

### Question 5. You are developing a game, and you want to keep track of the top 10 players' high scores. Which Java Collection would be most appropriate for maintaining this leaderboard?
**Answer:** 
