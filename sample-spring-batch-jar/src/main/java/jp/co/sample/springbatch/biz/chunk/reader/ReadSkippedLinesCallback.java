package jp.co.sample.springbatch.biz.chunk.reader;

import jp.co.sample.springbatch.framework.constant.ScopeConst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.file.LineCallbackHandler;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Read Skipped Line Callback.
 */
@Scope(ScopeConst.SINGLETON)
@Service
@Slf4j
public class ReadSkippedLinesCallback implements LineCallbackHandler {

  /**
   * Skip時のコールバック.
   * linesToSkipによりSkipした場合も呼ばれます
   *
   * @param line Skipした行
   */
  @Override
  public void handleLine(String line) {
    log.debug("skipped line: {}", line);
  }

}
