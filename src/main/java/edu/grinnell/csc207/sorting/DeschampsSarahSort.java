package edu.grinnell.csc207.sorting;

import edu.grinnell.csc207.util.ArrayUtils;

import java.util.Comparator;

/**
 * A spin-off of selection sort, but checking both the
 * smallest and largest values. The smallest value goes
 * to the beginning of the array, and the largest value
 * at the end. The sorting stops when the smallest and
 * largest values are equal.
 *
 * @param T
 *    The types of values that are sorted.
 *
 * @author Sarah Deschamps
 */
public class DeschampsSarahSort<T> implements Sorter<T> {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The way in which elements are ordered.
   */
  Comparator<? super T> order;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter using a particular comparator.
   *
   * @param comparator
   *   The order in which elements in the array should be ordered
   *   after sorting.
   */
  public DeschampsSarahSort(Comparator<? super T> comparator) {
    this.order = comparator;
  } // InsertionSorter(Comparator)

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Sort an array in place using a spin-off of selection
   * sort that searches for the smallest and largest value.
   *
   * @param values
   *   an array to sort.
   *
   * @post
   *   The array has been sorted according to some order (often
   *   one given to the constructor).
   * @post
   *   For all i, 0 &lt; i &lt; values.length,
   *     order.compare(values[i-1], values[i]) &lt;= 0
   */
  @Override
  public void sort(T[] values) {
    int smallest;
    int largest;
    int i = 0;
    while (i < values.length - i) {
      smallest = i;
      largest = i;
      for (int j = i; j < values.length - i; j++) {
        if (order.compare(values[smallest], values[j]) > 0) {
          smallest = j;
        } // if
        if (order.compare(values[largest], values[j]) <= 0) {
          largest = j;
        } // if
      } // for
      if (!(smallest == values.length - i - 1 || largest == i)) {
        ArrayUtils.swap(values, smallest, i);
        ArrayUtils.swap(values, largest, values.length - i - 1);
      } else if (largest == i && smallest != values.length - i - 1) {
        ArrayUtils.swap(values, i, smallest);
        ArrayUtils.swap(values, values.length - i - 1, smallest);
      } else if (largest != i && smallest == values.length - i - 1) {
        ArrayUtils.swap(values, i, smallest);
        ArrayUtils.swap(values, largest, values.length - i - 1);
      } else {
        ArrayUtils.swap(values, smallest, largest);
      } // if-else
      i++;
      if (largest == smallest) {
        break;
      } // if
    } // for
  } // sort(T[])
} // class DeschampsSarahSort
