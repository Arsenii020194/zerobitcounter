package com.company;

import com.company.counter.FileCounter;
import com.company.counter.ZeroBitFileCounter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

  private static final Logger logger = LoggerFactory.getLogger(Main.class);

  public static void main(String[] args) {
    if (args.length == 0) {
      logger.error("file path is not present!");
      System.exit(-1);
    }
    String fileName = args[0];
    FileCounter<Integer> zeroBitFileCounter = new ZeroBitFileCounter();
    System.out.println(zeroBitFileCounter.count(fileName));
  }
}
