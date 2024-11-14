# mp-sorting-maven

An exploration of sorting in Java.

Authors

* Sarah Deschamps
* Samuel A. Rebelsky (starter code)

Acknowledgements

* The dnf algorithm in QuickSort was largely based on the algorithm found in this page: https://rebelsky.cs.grinnell.edu/Courses/CSC207/2024Fa/eboards/eboard20-1.html 

This code may be found at <https://github.com/sidesch/mp-sorting-maven>. The original code may be found at <https://github.com/Grinnell-CSC207/mp-sorting-maven>.

Description of custom sorting algorithm
---------------------------------------
My algorithm uses a double selection sort method. Through each iteration of the array, it finds the smallest and largest value, and then swaps indeces accordingly. It stops when the largest and largest index are the same, since that means the rest of the array is sorted. 