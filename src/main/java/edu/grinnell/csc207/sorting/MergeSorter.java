package edu.grinnell.csc207.sorting;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Something that sorts using merge sort.
 *
 * @param <T>
 *   The types of values that are sorted.
 *
 * @author Samuel A. Rebelsky
 */

public class MergeSorter<T> implements Sorter<T> {
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
  public MergeSorter(Comparator<? super T> comparator) {
    this.order = comparator;
  } // MergeSorter(Comparator)

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Sort an array in place using merge sort.
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
    sortHelper(values, 0, values.length);
  } // sort(T[])

  /**
   * Sorts the values in values from lb (inclusive) to ub (exclusive).
   * @param values
   *    The array of values to sort.
   * @param lb
   *    The lower bound (inclusive).
   * @param ub
   *    The upper bound (exclusive).
   */
  private void sortHelper(T[] values, int lb, int ub) {
    if (ub - lb <= 1) {
      return;
    } // if
    int med = (int)(lb / 2.0 + ub / 2.0);
    T[] sub1 = Arrays.copyOfRange(values, 0, med);
    T[] sub2 = Arrays.copyOfRange(values, med, values.length);
    sortHelper(values, lb, med);
    sortHelper(values, med, ub);
    merge(values, lb, med, ub); // the merging is creating problems
  } // sortHelper(T[], int, int)

  /**
   * Merges two subarrays.
   * @param values
   *    The array of values (containing subarrays).
   * @param lb
   *    The lower bound of the first subarray.
   * @param med
   *    The upper bound of the first subarray and 
   *    lower bound of the second subarray.
   * @param ub
   *    The upper bound of the second subarray.
   * @return
   *    A new sorted merged array.
   */
  private void merge(T[] values, int lb, int med, int ub) {
    int counter = med;
    T[] copy = values.clone();
    int idx = lb;
    while (lb < med && counter < ub) {
      if (order.compare(copy[lb], copy[counter]) <= 0) {
        values[idx++] = copy[lb++];
      } else {
        values[idx++] = copy[counter++];
      } // if-else
    } // while
    if (lb < med) {
      for (int i = idx; i < ub; i++) {
        values[i] = copy[lb++];
      } // for
    } else if (counter < ub) {
      for (int i = idx; i < values.length; i++) {
        values[i] = copy[counter++];
      } // for
    } // if-else
  } // merge(T[], int, int, int)
} // class MergeSorter
