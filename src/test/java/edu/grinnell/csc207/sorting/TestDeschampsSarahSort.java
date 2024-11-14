package edu.grinnell.csc207.sorting;

import org.junit.jupiter.api.BeforeAll;

/**
 * Tests of our InsertionSorter.
 */
public class TestDeschampsSarahSort extends TestSorter {
  /**
   * Set up the sorters.
   */
  @BeforeAll
  static void setup() {
    stringSorter = new DeschampsSarahSort<String>((x,y) -> x.compareTo(y));
    intSorter = new DeschampsSarahSort<Integer>((x,y) -> x.compareTo(y));
  } // setup()

} // class TestDeschampsSarahSort
