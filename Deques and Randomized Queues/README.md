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
1. resizing array: resize() is a linear-time funtion  
2. single-linked list: AddLast() and MoveFirst() will not be constant time  
so I choose **Double-linkded list**  
## implementation
1. To make `size()` and `isEmpty()` cost constant time, add a variant `int n` in the constructor, standing for the number of elements in the deque.  
2. `first/last` is the pointer to the first/last element. If deque is empty, then first = last = null; if `size() = 1`, then first = last.  
# Randomized Queue
## data structure
