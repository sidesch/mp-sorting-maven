package edu.grinnell.csc207.sorting;

import java.util.Comparator;

import edu.grinnell.csc207.util.ArrayUtils;

/**
 * Something that sorts using selection sort.
 *
 * @param <T>
 *   The types of values that are sorted.
 *
 * @author Sarah Deschamps
 * @author Samuel A. Rebelsky
 */

public class SelectionSorter<T> implements Sorter<T> {
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
  public SelectionSorter(Comparator<? super T> comparator) {
    this.order = comparator;
  } // SelectionSorter(Comparator)

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Sort an array in place using selection sort.
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
    for (int i = 0; i < values.length; i++) {
      smallest = findSmallest(values, i);
      ArrayUtils.swap(values, i, smallest);
    } // for
  } // sort(T[])

  /**
   * Find the smallest value in an array of values
   * given a starting index.
   *
   * @param values
   *    The array of values.
   * @param i
   *    The starting index.
   * @return The index of the smallest value.
   */
  private int findSmallest(T[] values, int i) {
    int smallest = i;
    for (int j = i + 1; j < values.length; j++) {
     if (order.compare(values[smallest], values[j]) > 0) {
       smallest = j;
      } // if
    } // for
    return smallest;
  } // findSmallest(T[], int)
} // class SelectionSorter
