package org.apache.twill.internal.zookeeper;

import org.apache.zookeeper.KeeperException;
import org.junit.Test;

import static org.junit.Assert.*;

public class RetryUtilsTest {

  @Test
  public void shouldReturnTrueIfKeeperExceptionCodeIsOneOfThoseEligibleForRetry(){
    assertTrue(RetryUtils.canRetry(KeeperException.Code.CONNECTIONLOSS));
    assertTrue(RetryUtils.canRetry(KeeperException.Code.OPERATIONTIMEOUT));
    assertTrue(RetryUtils.canRetry(KeeperException.Code.SESSIONEXPIRED));
    assertTrue(RetryUtils.canRetry(KeeperException.Code.SESSIONMOVED));
  }

  @Test
  public void shouldReturnFalseIfKeeperExceptionCodeIsOtherThanThoseEligibleForRetry(){
    assertFalse(RetryUtils.canRetry(KeeperException.Code.APIERROR));
    assertFalse(RetryUtils.canRetry(KeeperException.Code.AUTHFAILED));
    assertFalse(RetryUtils.canRetry(KeeperException.Code.DATAINCONSISTENCY));
    assertFalse(RetryUtils.canRetry(KeeperException.Code.BADVERSION));
  }

}