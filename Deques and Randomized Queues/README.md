[project spec](https://coursera.cs.princeton.edu/algs4/assignments/queues/specification.php)
|                         | Deque | Randomized Queue|
| :---------------------: | :---: | :-------------: |
| **Non-iterator operations** | Constant worst-case time | Constant amortized time|
| **Iterator constructor** | Constant worst-case time | linear in current # of items|
| **Other iterator operations** | Constant worst-case time | Constant worst-case time |
|**Non-iterator memory use**|	Linear in current # of items|Linear in current # of items|
|**Memory per iterator**|Constant|Linear in current # of items|
# Deque  
## data structure
resizing array: resize() is a linear-time funtion
single-linked list: AddLast() and MoveFirst() will not be constant time
so I choose **Double-linkded list**

