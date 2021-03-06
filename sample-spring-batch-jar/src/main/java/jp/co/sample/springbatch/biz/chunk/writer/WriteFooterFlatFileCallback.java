package jp.co.sample.springbatch.biz.chunk.writer;

import jp.co.sample.springbatch.framework.code.RecodeTypeVo;
import jp.co.sample.springbatch.framework.constant.ScopeConst;
import jp.co.sample.springbatch.framework.util.SystemDateUtils;
import java.io.IOException;
import java.io.Writer;
import org.springframework.batch.item.file.FlatFileFooterCallback;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * フッターWriterCallback.
 */
@Scope(ScopeConst.SINGLETON)
@Service
public class WriteFooterFlatFileCallback implements FlatFileFooterCallback {

  /**
   * フッター（トレーラレコード）書き込み.
   * 03,yyyyMMdd
   *
   * @param writer {@link Writer} フッターの書き込みに使用するWriter
   * @throws IOException 書き込み中にエラーが発生した場合
   */
  @Override
  public void writeFooter(Writer writer) throws IOException {
    writer.write(RecodeTypeVo.TRAILER_RECORD.getCode() + "," + SystemDateUtils.getNowDateString());
  }

}
