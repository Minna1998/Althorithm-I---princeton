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
`dequeue()`, `sample()` and `iterator()` are required to choose element randomly by using `StdRandom.uniform()`. At the same time, we should eliminate the time costs as possible. So we can only use resizing array as the data structure.
## implementation
1. I use the simplest resizing array, without any head or tail index. It is because `dequeue()`, `sample()` and `iterator()` are required to choose element randomly, and I don't need to care about where is the first element of the queue.  
2. To make it easier, I try to keep all the elements tight instead of allowing `null` between any two of them. Otherwise, I need to judge whether the random elements chosed in `dequeue()`, `sample()` and `iterator()` are not `null`, and if it is, I also need to loop to find the next available elements in the queue, which leads to fails in timing tests.
3. How to keep every elements tight?  
 In `dequeue()`, for example, I delete a element `dq[i]` randomly, then let `dq[i] = dq[n-1]`.
 ```
public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException();
        int index = StdRandom.uniform(n);
        Item item = randomque[index];
        if (index != n-1) randomque[index] = randomque[n-1];
        randomque[n-1] = null;
        n--;
        if (n > 0 && n == randomque.length/4) resize(randomque.length/2);
        return item;
    }
```
4. How to make each iterator maintain its own order?  
I copy all the elements in the queue to a new array `sequence[]`, and then randomly dequeue it. In this way:  
 * each iterator maintain its own order  
 * the original array will not be modified
 * a iterator will not scan two same elements

