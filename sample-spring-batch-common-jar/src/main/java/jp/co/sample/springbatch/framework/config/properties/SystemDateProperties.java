package jp.co.sample.springbatch.framework.config.properties;

import jp.co.sample.springbatch.framework.constant.ScopeConst;
import jp.co.sample.springbatch.framework.util.SystemDateUtils;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * システム日付プロパティ.
 * テストで任意の日付で動作させたい場合に利用
 */
@Scope(ScopeConst.SINGLETON)
@Component
public class SystemDateProperties {

  /**
   * システム日付（みなし日付）.
   * ※起動時に読み込まれた後は利用しません.
   */
  @Value("${framework.system-date}")
  private String systemDate;

  /**
   * 初期化.
   */
  @PostConstruct
  public void initailize() {
    SystemDateUtils.initailize(systemDate);
  }

}
