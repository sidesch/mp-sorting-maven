package edu.grinnell.csc207.sorting;

import java.util.Comparator;
import java.util.Random;

import edu.grinnell.csc207.util.ArrayUtils;

/**
 * Something that sorts using Quicksort.
 *
 * @param <T>
 *   The types of values that are sorted.
 *
 * @author Sarah Deschamps
 * @author Samuel A. Rebelsky
 */

public class Quicksorter<T> implements Sorter<T> {
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
  public Quicksorter(Comparator<? super T> comparator) {
    this.order = comparator;
  } // Quicksorter(Comparator)

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Sort an array in place using Quicksort.
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
    Random rand = new Random();
    sortHelper(values, 0, values.length, rand);
  } // sort(T[])

  /**
   * Sorts the array from lb to ub.
   *
   * @param values
   *    The array to sort.
   * @param lb
   *    The lower bound (inclusive).
   * @param ub
   *    The upper bound (exclusive).
   * @param rand
   *    The random number generator.
   */
  private void sortHelper(T[] values, int lb, int ub, Random rand) {
    if (lb >= ub) {
      return;
    } // if
    int med = rand.nextInt(lb, ub);
    T partition = values[med];
    int[] bounds = dnf(values, partition, lb, ub);
    sortHelper(values, lb, bounds[0], rand);
    sortHelper(values, bounds[1], ub, rand);
  } // sortHelper(T[], int, int, Random)

  /**
   * Partitions the array into three sections, solving the Dutch National Flag problem.
   * @param values
   *    The array of values to sort.
   * @param partition
   *    The middle of the array.
   * @param lb
   *    The lower bound.
   * @param ub
   *    The upper bound.
   *
   * @return the values of r and w.
   */
  public int[] dnf(T[] values, T partition, int lb, int ub) {
    int r = lb;
    int w = lb;
    int b = ub;
    while (w < b) {
      if (order.compare(partition, values[w]) == 0) {
        w++;
      } else if (order.compare(values[w], partition) > 0) {
        ArrayUtils.swap(values, w, b - 1);
        b--;
      } else {
        ArrayUtils.swap(values, w, r);
        r++;
        w++;
      } // if-else
    } // while
    return new int[] {r, w};
  } // dnf(T[], T, int, int)
} // class Quicksorter
