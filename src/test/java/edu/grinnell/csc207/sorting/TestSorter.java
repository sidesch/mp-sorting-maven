package edu.grinnell.csc207.sorting;

import edu.grinnell.csc207.util.ArrayUtils;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertFalse;
// import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
// import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

/**
 * Tests of Sorter objects. Please do not use this class directly.
 * Rather, you should subclass it and initialize stringSorter and
 * intSorter in a static @BeforeAll method.
 *
 * @author Your Name
 * @uathor Samuel A. Rebelsky
 */
public class TestSorter {

  // +---------+-----------------------------------------------------
  // | Globals |
  // +---------+

  /**
   * The sorter we use to sort arrays of strings.
   */
  static Sorter<String> stringSorter = null;

  /**
   * The sorter we use to sort arrays of integers.
   */
  static Sorter<Integer> intSorter = null;

  // +-----------+---------------------------------------------------
  // | Utilities |
  // +-----------+

  /**
   * Given a sorted array and a permutation of the array, sort the
   * permutation and assert that it equals the original.
   *
   * @param <T>
   *   The type of values in the array.
   * @param sorted
   *   The sorted array.
   * @param perm
   *   The permuted sorted array.
   * @param sorter
   *   The thing to use to sort.
   */
  public <T> void assertSorts(T[] sorted, T[] perm, Sorter<? super T> sorter) {
    T[] tmp = perm.clone();
    sorter.sort(perm);
    assertArrayEquals(sorted, perm,
      () -> String.format("sort(%s) yields %s rather than %s",
          Arrays.toString(tmp), 
          Arrays.toString(perm), 
          Arrays.toString(sorted)));
  } // assertSorts

  // +-------+-------------------------------------------------------
  // | Tests |
  // +-------+

  /**
   * A fake test. I've forgotten why I've included this here. Probably
   * just to make sure that some test succeeds.
   */
  @Test
  public void fakeTest() {
    assertTrue(true);
  } // fakeTest()

  /**
   * Ensure that an array that is already in order gets sorted correctly.
   */
  @Test
  public void orderedStringTest() {
    if (null == stringSorter) {
      return;
    } // if
    String[] original = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    String[] expected = original.clone();
    assertSorts(expected, original, stringSorter);
  } // orderedStringTest

  /**
   * Ensure that an array that is ordered backwards gets sorted correctly.
   */
  @Test
  public void reverseOrderedStringTest() {
    if (null == stringSorter) {
      return;
    } // if
    String[] original = { "foxtrot", "delta", "charlie", "bravo", "alpha" };
    String[] expected = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    assertSorts(expected, original, stringSorter);
  } // orderedStringTest

  /**
   * Ensure that a randomly permuted version of a moderate-sized
   * array sorts correctly.
   */
  @Test 
  public void permutedIntegersTest() { 
    int SIZE = 100; 
    if (null == intSorter) { 
      return; 
    } // if
    Integer[] original = new Integer[SIZE];
    for (int i = 0; i < SIZE; i++) {
      original[i] = i;
    } // for
    Integer[] expected = original.clone();
    ArrayUtils.permute(original);
    assertSorts(expected, original, intSorter);
  } // permutedIntegers

  @Test
  public void changeEndElement() {
    if (null == stringSorter) {
      return;
    } // if
    String[] original = {"alpha", "delta", "gamma", "beta"};
    String[] expected = {"alpha", "beta", "delta", "gamma"};
    assertSorts(expected, original, stringSorter);
  } // changeEndElement

  @Test
  public void changeStartElement() {
    if (null == stringSorter) {
      return;
    } // if
    String[] original = {"gamma", "alpha", "beta", "delta"};
    String[] expected = {"alpha", "beta", "delta", "gamma"};
    assertSorts(expected, original, stringSorter);
  } // changeStartElement

  @Test
  public void switchFrontBackIntegers() {
    if (null == intSorter) {
      return;
    } // if
    Integer[] original = {10, 2, 3, 4, 5, 6, 7, 8, 9, 1};
    Integer[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    assertSorts(expected, original, intSorter);
  } // switchFrontBackIntegers

  @Test
  public void switchAdjacentElements() {
    if (null == intSorter) {
      return;
    } // if
    Integer[] original = {2, 1, 4, 3, 6, 5, 8, 7, 10, 9};
    Integer[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    assertSorts(expected, original, intSorter);
  } // switchAdjacentElements

  @Test
  public void switchAdjacentStrings() {
    if (null == stringSorter) {
      return;
    } // if
    String[] original = {"beta", "alpha", "gamma", "delta"};
    String[] expected = {"alpha", "beta", "delta", "gamma"};
    assertSorts(expected, original, stringSorter);
  } // switchAdjacentStrings

  @Test
  public void nullArray() {
    if (null == intSorter) {
      return;
    } // if
    Integer[] original = {};
    Integer[] expected = {};
    assertSorts(expected, original, intSorter);
  } // nullArray
} // class TestSorter
