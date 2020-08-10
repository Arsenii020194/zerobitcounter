package com.company.counter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ZeroBitFileCounter implements FileCounter<Integer> {

  private final Logger logger = LoggerFactory.getLogger(ZeroBitFileCounter.class);

  @Override
  public Integer count(String fileName) {
    File f = new File(fileName);
    int countZero = 0;
    try (RandomAccessFile is = new RandomAccessFile(f, "r")) {
      int b;
      while ((b = is.read()) != -1) {
        countZero += Integer.toBinaryString(b).chars().filter(ch -> '0' == ch).count();
      }
    } catch (FileNotFoundException e) {
      logger.error(fileName + " NOT FOUND!", e);
    } catch (IOException e) {
      logger.error(e.getMessage(), e);
    }
    return countZero;
  }
}
