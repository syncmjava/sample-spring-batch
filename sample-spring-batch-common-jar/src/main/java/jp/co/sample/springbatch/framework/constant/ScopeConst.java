package jp.co.sample.springbatch.framework.constant;

/**
 * Scope定数.
 */
public final class ScopeConst {

  /** singleton. */
  public static final String SINGLETON = "singleton";

  /** prototype. */
  public static final String PROTOTYPE = "prototype";

  /** request. */
  public static final String REQUEST = "request";

  /** session. */
  public static final String SESSION = "session";

  /**
   * デフォルトコンストラクタ.
   */
  private ScopeConst() {
    // do nothing
  }

}
